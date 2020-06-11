import webserver.WebServer

object SimpleServer {
  def main(args: Array[String]): Unit = {
    println("Hello world!")


    // Starting the server
    WebServer.startServer("localhost", 8080)
    val wait = scala.io.StdIn.readLine("Press enter to stop")
  }
}
