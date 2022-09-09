/*
package controllers
import com.typesafe.config.ConfigFactory
import play.api.inject.guice.GuiceApplicationBuilder
import play.api.libs.json.{JsValue, Json}
import play.api.test.Helpers.{POST, contentAsString, contentType, defaultAwaitTimeout, route, status, _}
import play.api.test.{FakeHeaders, FakeRequest}
import org.junit.runner.RunWith
import org.specs2.mutable.Specification
import org.specs2.runner.JUnitRunner
import play.api.test.Helpers.{OK, status, _}

import scala.Console.in
@RunWith(classOf[JUnitRunner])
class HomeControllerSpec extends Specification{
  implicit val config = ConfigFactory.load();
  implicit val app = new GuiceApplicationBuilder()

  "HomeController " should {
    "return success response for start API" in {
      val controller = app.injector.instanceOf[controllers.HomeController]
      val json: JsValue = Json.parse("""{"id":"user2-content-1","content_id":"content-2","content_type":"textbook","user":"user2"}""")
      val fakeRequest = FakeRequest("POST","/content/start").withJsonBody(json)
      val result = controller.start()(fakeRequest)
      status(result) must equalTo(OK)
    }
    "return success response for update API" in {
      val controller = app.injector.instanceOf[controllers.HomeController]
      val json: JsValue = Json.parse("""{"percentage":30,"id":"user2-content-2"}""")
      val fakeRequest = FakeRequest("POST", "/content/update").withJsonBody(json)
      val result = controller.update()(fakeRequest)
      status(result) must equalTo(OK)
    }
    "return success response for end API" in {
      val controller = app.injector.instanceOf[controllers.HomeController]
      val json: JsValue = Json.parse("""{"id": "user2-content-2"}""")
      val fakeRequest = FakeRequest("POST", "/content/end").withJsonBody(json)
      val result = controller.end()(fakeRequest)
      status(result) must equalTo(OK)
    }
    "return success response for consumtionList API" in {
      val controller = app.injector.instanceOf[controllers.HomeController]
      val json: JsValue = Json.parse("""{"id":"user2-content-2","content_id":"content-2","content_type":"textbook","user":"user2"}""")
      val fakeRequest = FakeRequest("POST", "/content/consumptionList").withJsonBody(json)
      val result = controller.start()(fakeRequest)
      status(result) must equalTo(OK)
    }
    "return success response for list API" in {
      val controller = app.injector.instanceOf[controllers.HomeController]
      val fakeRequest = FakeRequest("GET", "/content/list")
      val result = controller.list()(fakeRequest)
      status(result) mustEqual (OK)
    }

  }


}

 */

