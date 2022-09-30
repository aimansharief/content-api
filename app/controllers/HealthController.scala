package controllers
import service.CassandraService
import play.api.libs.json.Json
import play.api.mvc._
import com.fasterxml.jackson.databind.ObjectMapper
import exception.ClientException
import utils.JsonUtils
import scala.io.Source
import javax.inject._
import java.util
import scala.collection.JavaConverters.asScalaBufferConverter
import scala.language.{dynamics, postfixOps}
import java.time.LocalDateTime
import com.fasterxml.jackson.module.scala.DefaultScalaModule

class HealthController @Inject()(cc: ControllerComponents) extends AbstractController(cc){
  val mapper = new ObjectMapper()
  mapper.registerModule(DefaultScalaModule)
  val time=LocalDateTime.now().toString()

  def serviceHealth(): Action[AnyContent] = Action {
    Ok(mapper.writeValueAsString(Map("timestamp" ->time,"result" -> Map("healthy" ->"true")))).as("application/json")
  }
}

