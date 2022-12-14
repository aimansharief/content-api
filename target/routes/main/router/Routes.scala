// @GENERATOR:play-routes-compiler
// @SOURCE:/home/stpl/Downloads/content-api/conf/routes
// @DATE:Fri Sep 30 09:51:46 IST 2022

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:1
  HomeController_1: controllers.HomeController,
  // @LINE:6
  HealthController_0: controllers.HealthController,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:1
    HomeController_1: controllers.HomeController,
    // @LINE:6
    HealthController_0: controllers.HealthController
  ) = this(errorHandler, HomeController_1, HealthController_0, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, HomeController_1, HealthController_0, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """content/list""", """controllers.HomeController.list"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """content/start""", """controllers.HomeController.start"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """content/update""", """controllers.HomeController.update"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """content/end""", """controllers.HomeController.end"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """content/consumptionList""", """controllers.HomeController.consumptionList"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """content/serviceHealth""", """controllers.HealthController.serviceHealth"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:1
  private[this] lazy val controllers_HomeController_list0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("content/list")))
  )
  private[this] lazy val controllers_HomeController_list0_invoker = createInvoker(
    HomeController_1.list,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "list",
      Nil,
      "GET",
      this.prefix + """content/list""",
      """""",
      Seq()
    )
  )

  // @LINE:2
  private[this] lazy val controllers_HomeController_start1_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("content/start")))
  )
  private[this] lazy val controllers_HomeController_start1_invoker = createInvoker(
    HomeController_1.start,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "start",
      Nil,
      "POST",
      this.prefix + """content/start""",
      """""",
      Seq()
    )
  )

  // @LINE:3
  private[this] lazy val controllers_HomeController_update2_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("content/update")))
  )
  private[this] lazy val controllers_HomeController_update2_invoker = createInvoker(
    HomeController_1.update,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "update",
      Nil,
      "POST",
      this.prefix + """content/update""",
      """""",
      Seq()
    )
  )

  // @LINE:4
  private[this] lazy val controllers_HomeController_end3_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("content/end")))
  )
  private[this] lazy val controllers_HomeController_end3_invoker = createInvoker(
    HomeController_1.end,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "end",
      Nil,
      "POST",
      this.prefix + """content/end""",
      """""",
      Seq()
    )
  )

  // @LINE:5
  private[this] lazy val controllers_HomeController_consumptionList4_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("content/consumptionList")))
  )
  private[this] lazy val controllers_HomeController_consumptionList4_invoker = createInvoker(
    HomeController_1.consumptionList,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "consumptionList",
      Nil,
      "POST",
      this.prefix + """content/consumptionList""",
      """""",
      Seq()
    )
  )

  // @LINE:6
  private[this] lazy val controllers_HealthController_serviceHealth5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("content/serviceHealth")))
  )
  private[this] lazy val controllers_HealthController_serviceHealth5_invoker = createInvoker(
    HealthController_0.serviceHealth,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HealthController",
      "serviceHealth",
      Nil,
      "GET",
      this.prefix + """content/serviceHealth""",
      """""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:1
    case controllers_HomeController_list0_route(params@_) =>
      call { 
        controllers_HomeController_list0_invoker.call(HomeController_1.list)
      }
  
    // @LINE:2
    case controllers_HomeController_start1_route(params@_) =>
      call { 
        controllers_HomeController_start1_invoker.call(HomeController_1.start)
      }
  
    // @LINE:3
    case controllers_HomeController_update2_route(params@_) =>
      call { 
        controllers_HomeController_update2_invoker.call(HomeController_1.update)
      }
  
    // @LINE:4
    case controllers_HomeController_end3_route(params@_) =>
      call { 
        controllers_HomeController_end3_invoker.call(HomeController_1.end)
      }
  
    // @LINE:5
    case controllers_HomeController_consumptionList4_route(params@_) =>
      call { 
        controllers_HomeController_consumptionList4_invoker.call(HomeController_1.consumptionList)
      }
  
    // @LINE:6
    case controllers_HealthController_serviceHealth5_route(params@_) =>
      call { 
        controllers_HealthController_serviceHealth5_invoker.call(HealthController_0.serviceHealth)
      }
  }
}
