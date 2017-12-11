package akkaSample.test

import akkaSample.{Greeting, GreetingMessage}
import org.scalatest.FlatSpec
import org.scalatest.Matchers._

class GreetingTest extends  FlatSpec {

  "Greeting" should "generate the correct Greeting instance" in {
    Greeting.getMessage("john1") should be (GreetingMessage("Hello john1"))
  }
}
