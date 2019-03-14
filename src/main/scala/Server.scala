import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer

import scala.concurrent.Await
import scala.util.{Failure, Success}

object Server extends App {
    val host = "0.0.0.0"
    val port = 9000

    implicit val system: ActorSystem = ActorSystem("todoapi")
    implicit val materializer: ActorMaterializer = ActorMaterializer()
    import system.dispatcher

    import akka.http.scaladsl.server.Directives._
    def route = path("hello") {
        // match route /hello
        // if matches, then it will check below
        get {
            // if the request is a GET request
            // it will do stuff in here
            println("someone pinged you!")
            complete("Hello, world!")
        }
    }

    val binding = Http().bindAndHandle(route, host, port)
    binding.onComplete {
        case Success(serverBinding) => println(s"listening to ${serverBinding.localAddress}")
        case Failure(error) => println(s"error: ${error.getMessage}")
    }

    import scala.concurrent.duration._
    Await.result(binding, 3.seconds)

}