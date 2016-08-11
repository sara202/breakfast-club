package controllers

import org.jsoup.Jsoup
import org.scalatestplus.play._
import play.api.mvc.Result
import play.api.test.Helpers._
import play.api.test._

import scala.concurrent.Future

class HomeControllerSpec extends PlaySpec with OneAppPerTest {

  "HomeController" should {

    "redirect to the home page from the index page" in {
      index { result =>
        status(result) must be(SEE_OTHER)
        redirectLocation(result) must be(Some("/home"))
      }
    }

    "render the Breakfast Club welcome page" in {
      home { result =>
        status(result) must be(OK)

        val document = Jsoup.parse(contentAsString(result))
        document.getElementById("welcome-heading").text() must be("Welcome to the Breakfast Club")
      }
    }

  }

  def index(test: Future[Result] => Any) = {
    test(route(app, FakeRequest(GET, "/")).get)
  }

  def home(test: Future[Result] => Any) = {
    test(route(app, FakeRequest(GET, "/home")).get)
  }

}
