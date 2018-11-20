import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import akka.stream.ActorMaterializer
import spray.json.DefaultJsonProtocol._
import spray.json._

object SimpleHTTPServer extends App {
  override def main(args: Array[String]): Unit = {
    implicit val system = ActorSystem("system")
    implicit val actorMaterializer = ActorMaterializer()
    implicit val executionContext = system.dispatcher
    val host = "localhost"
    val port = 8080
    val route: Route =
        pathSingleSlash {
          get {
            complete(Map("message"->"hello root!").toJson.toString)
          }
        } ~
        path("greet") {
          complete (Map("message" -> s"Greetings only!").toJson.toString)
        } ~
        pathPrefix("greet") {
          path(Segment) { case(person) =>
            get {
              complete {
                Map("message"->s"Hello $person").toJson.toString
              }
            }
          }
        } ~
        path("health"){
          complete(Map("status"->"OK").toJson.toString)
        }

    Http().bindAndHandle(route, host, port) map { binding =>
      println(s"REST interface bound to ${binding.localAddress}")
    } recover { case ex =>
      println(s"REST interface could not bind to $host:$port", ex.getMessage)
    }
  }
}
