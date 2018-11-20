import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer

object SimpleHTTPServer extends App with Routes {
  override def main(args: Array[String]): Unit = {
    implicit val system = ActorSystem("system")
    implicit val actorMaterializer = ActorMaterializer()
    implicit val executionContext = system.dispatcher
    val host = "localhost"
    val port = 8080

    Http().bindAndHandle(route, host, port) map { binding =>
      println(s"REST interface bound to ${binding.localAddress}")
    } recover { case ex =>
      println(s"REST interface could not bind to $host:$port", ex.getMessage)
    }
  }
}
