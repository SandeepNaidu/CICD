import akka.http.scaladsl.model.{HttpMethods, HttpRequest}
import akka.http.scaladsl.testkit.ScalatestRouteTest
import akka.testkit.TestKit
import org.scalatest.{BeforeAndAfterAll, Matchers, WordSpec, WordSpecLike}

class SimpleHTTPServerTest extends WordSpec with Matchers
  with WordSpecLike with BeforeAndAfterAll with Routes with ScalatestRouteTest{
  implicit val executionContext = system.dispatcher

  override def afterAll: Unit = {
    TestKit.shutdownActorSystem(system)
  }

  "Greeting EndPoint" must {

    "return greeting for root" in {
      val postRequest = HttpRequest(
        HttpMethods.GET,
        uri = "/")

      postRequest ~> route ~> check {
        responseAs[String] shouldEqual """{"message":"hello root!"}"""
      }
    }

    "return greeting for person" in {
      val postRequest = HttpRequest(
        HttpMethods.GET,
        uri = "/greet/James")

      postRequest ~> route ~> check {
        responseAs[String] shouldEqual """{"message":"Hello James"}"""
      }
    }
  }

  "Health EndPoint" must {
    "return OK for health" in {
      val postRequest = HttpRequest(
        HttpMethods.GET,
        uri = "/health")

      postRequest ~> route ~> check {
        responseAs[String] shouldEqual """{"status":"OK"}"""
      }
    }

  }
}