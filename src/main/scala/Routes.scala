


trait Routes {
  import akka.http.scaladsl.server.Directives._
  import akka.http.scaladsl.server.Route
  import spray.json._
  import DefaultJsonProtocol._


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
        path(Segment) { person =>
          get {
            complete {
              Map("message" -> s"Hello $person").toJson.toString
            }
          }
        }
      } ~
      path("health"){
        complete(Map("status"->"OK").toJson.toString)
      }
}
