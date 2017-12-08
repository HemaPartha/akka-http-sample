package akkaSample

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport._
import spray.json.DefaultJsonProtocol._

object  HelloWorldService {

  implicit val system = ActorSystem("hello-world-system")
  implicit val materializer = ActorMaterializer()
  implicit val executionContext = system.dispatcher


  implicit val itemFormat = jsonFormat1(GreetingMessage)
  val defaultPort:Int = 8080
  val defaultInterface:String = "localhost"


  def main(args: Array[String]): Unit = {

    val interface:String = getInterface(args)
    val portNumber: Int = getPortNumber(args)

    val route =
      get {
          pathPrefix("greet" / Segment) { name =>
            val greetingMessage = Greeting.getMessage(name)
            complete(greetingMessage)
          }
      }

    val bindingFuture = Http().bindAndHandle(route, interface, portNumber)

    println(s"Server online at http://$interface:$portNumber/")
  }

  private def getInterface(args: Array[String]):String = {
    val interface = try {
      if (args.length > 0) {
        args(0)
      } else {
        defaultInterface
      }
    }
    catch {
      case _: Throwable => defaultInterface
    }

    interface
  }

  private def getPortNumber(args: Array[String]):Int = {
    val portNumber =
      try {
        if (args.length > 1) {
          args(1).toInt
        } else {
          val envPortNumber = sys.env("AKKA_HTTP_SAMPLE_PORT")
          envPortNumber.toInt
        }
      }
      catch {
        case _: Throwable => defaultPort
      }
    portNumber
  }
}
