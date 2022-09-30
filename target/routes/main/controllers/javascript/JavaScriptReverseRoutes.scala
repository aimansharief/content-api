// @GENERATOR:play-routes-compiler
// @SOURCE:/home/stpl/Downloads/content-api/conf/routes
// @DATE:Fri Sep 30 09:51:46 IST 2022

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset

// @LINE:1
package controllers.javascript {

  // @LINE:6
  class ReverseHealthController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:6
    def serviceHealth: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HealthController.serviceHealth",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "content/serviceHealth"})
        }
      """
    )
  
  }

  // @LINE:1
  class ReverseHomeController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:2
    def start: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.start",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "content/start"})
        }
      """
    )
  
    // @LINE:5
    def consumptionList: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.consumptionList",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "content/consumptionList"})
        }
      """
    )
  
    // @LINE:1
    def list: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.list",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "content/list"})
        }
      """
    )
  
    // @LINE:3
    def update: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.update",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "content/update"})
        }
      """
    )
  
    // @LINE:4
    def end: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.end",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "content/end"})
        }
      """
    )
  
  }


}
