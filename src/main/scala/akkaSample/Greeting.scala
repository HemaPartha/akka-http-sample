package akkaSample

final case class GreetingMessage(msg: String)

object Greeting {
  def getMessage(name:String) = GreetingMessage(s"Hello $name")
}
