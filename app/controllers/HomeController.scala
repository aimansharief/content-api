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

class HomeController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {
  val cassandraStart=new CassandraService
  val users = List("user1", "user2", "user3")
  val content_type = List("textbook")
  val content_id = List("content-1", "content-2", "content-3", "content-4", "content-5")
  //val source= Source.fromFile("/contents.json")
  val source= Source.fromFile("/home/stpl/Downloads/content-api/conf/contents.json")
  val mapper = new ObjectMapper

  //List API-To list contents present
  def list(): Action[AnyContent] = Action {
    Ok(source.mkString).as("application/json")
  }

  //Start API-To start the content consumption
  def start(): Action[AnyContent] = Action { request: Request[AnyContent] =>
    try {
      val requestBody = JsonUtils.jsonToMap(request)
      validateStartRequest(requestBody)
      val contentId = requestBody.get("content_id").toString.trim
      val contentType = requestBody.get("content_type").toString.trim
      val userId = requestBody.get("user").toString.trim
      if (users.contains(requestBody.get("user").toString) && content_type.contains(requestBody.get("content_type").toString) && content_id.contains((requestBody.get("content_id").toString))) {
        val unqId = (userId + "-" + contentId)
        val insertQuery=(s"INSERT INTO conttab(id,content_id,content_type,percentage,user) VALUES('$unqId','$contentId','$contentType',0,'$userId');")
        cassandraStart.update(insertQuery)
        Ok(JsonUtils.jsonToString(Map("status" ->"successfull","id" -> unqId))).as("application/json")
      }
      else
        throw new ClientException("Invalid Inputs")
    } catch {
      case ex: ClientException =>
        BadRequest(JsonUtils.jsonToString(Map("status" ->"unsuccessfull","message" ->ex.getMessage))).as("application/json")
    }
  }

  //Update API-To update consumption details
  def update(): Action[AnyContent] = Action { request: Request[AnyContent] =>
    try {
      val requestBody = JsonUtils.jsonToMap(request)
      validateUpdateRequest(requestBody)
      val contentPercentage = requestBody.get("percentage").toString.trim.toInt
      val unqId = requestBody.get("id").toString.trim
      if (requestBody.get("percentage").toString.toInt > 0 && requestBody.get("percentage").toString.toInt < 100) {
        val updateQuery =(s"UPDATE conttab SET percentage=$contentPercentage WHERE id='$unqId' IF EXISTS;")
        val result=cassandraStart.update(updateQuery)
        if (!result) {
          throw new ClientException("Invalid id")
        } else
          Ok(JsonUtils.jsonToString(Map("status" ->"successfull","message" ->"Content Details Has Updated"))).as("application/json")
      }
      else
        throw new ClientException("Percentage Out Of Bound")
    } catch {
      case ex: ClientException =>
        BadRequest(JsonUtils.jsonToString(Map("status" ->"unsuccessfull","message" ->ex.getMessage))).as("application/json")
    }
  }
  //End API-To complete the content consumption
  def end(): Action[AnyContent] = Action { request: Request[AnyContent] =>
    val requestBody = JsonUtils.jsonToMap(request)
    if (!requestBody.containsKey("id") || requestBody.getOrDefault("id", "").toString.isEmpty) {
      BadRequest(JsonUtils.jsonToString(Map("status" ->"unsuccessfull","message" ->"Id missing or empty"))).as("application/json")
    } else {
      val unqId = requestBody.get("id").toString.trim()
      val endQuery = (s"UPDATE conttab SET percentage=100 WHERE id='$unqId' IF EXISTS;")
      val result=cassandraStart.update(endQuery)
      if (!result)
        BadRequest(JsonUtils.jsonToString(Map("status" ->"unsuccessfull","message" ->"Invalid id"))).as("application/json")
      else Ok(JsonUtils.jsonToString(Map("status" ->"successfull","message" ->"Content Consumption Has Completed"))).as("application/json")
    }
  }
  //ConsumptionList API -List of content details viewed by respective user
  def consumptionList():Action[AnyContent]= Action{ request: Request[AnyContent]=>
    val requestBody = JsonUtils.jsonToMap(request)
    if (requestBody.isEmpty || !requestBody.containsKey("user"))
      BadRequest(JsonUtils.jsonToString(Map("status" ->"unsuccessfull","message" ->"user missing or empty"))).as("application/json")
    else {
      val userId = requestBody.get("user").toString.trim()
      if (!users.contains(requestBody.get("user").toString))
        BadRequest(JsonUtils.jsonToString(Map("status" ->"unsuccessfull","message" ->"user not found"))).as("application/json")
      else {
        val consumptionQuery= (s"SELECT JSON *FROM conttab WHERE user='$userId' ALLOW FILTERING;")
        val result=cassandraStart.read(consumptionQuery)
        val mylist = new util.ArrayList[Any]()
        val rsList = result.asScala
        for (row <- rsList) {
          mylist.add(row.getString(0))
        }
        Ok(mylist.toString).as("application/json")
      }
    }
  }
  @throws(classOf[ClientException])
  def validateStartRequest(jsonMap: util.Map[String, Object]) = {
    val validateList: List[String] = List("content_id", "content_type", "user")
    for (property <- validateList) {
      if (!jsonMap.containsKey(property) || jsonMap.getOrDefault(property, "").toString.isEmpty) {
        throw new ClientException(s"$property is missing or empty")
      }
    }
  }
  @throws(classOf[ClientException])
  def validateUpdateRequest(jsonMap: util.Map[String, Object]) = {
    val validateList: List[String] = List("percentage", "id")
    for (property <- validateList) {
      if (!jsonMap.containsKey(property) || jsonMap.getOrDefault(property, "").toString.isEmpty) {
        throw new ClientException(s"$property is missing or empty")
        
      }
    }
  }
}

