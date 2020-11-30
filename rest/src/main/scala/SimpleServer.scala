import webserver.WebServer

object SimpleServer {
  def main(args: Array[String]): Unit = {
    println("Hello world!")
    val port = sys.env.getOrElse("PORT", "8082").toInt



    // Starting the server
    WebServer.startServer("0.0.0.0", port)
    val wait = scala.io.StdIn.readLine("Press enter to stop")
  }
}
