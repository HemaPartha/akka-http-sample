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

  def main(args: Array[String]): Unit = {

    val portNumber =
      try {
        if(args.length>0) { args(0).toInt } else defaultPort
      }
      catch {
        case _:Throwable => defaultPort
      }

    val route =
      get {
          pathPrefix("greet" / Segment) { name =>
            val greetingMessage = Greeting.getMessage(name)
            complete(greetingMessage)
          }
      }

    val bindingFuture = Http().bindAndHandle(route, "localhost", portNumber)

    println(s"Server online at http://localhost:$portNumber/")
    println("Press RETURN to stop...")
  }

}
