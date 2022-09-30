// @GENERATOR:play-routes-compiler
// @SOURCE:/home/stpl/Downloads/content-api/conf/routes
// @DATE:Fri Sep 30 09:51:46 IST 2022

import play.api.mvc.Call


import _root_.controllers.Assets.Asset

// @LINE:1
package controllers {

  // @LINE:6
  class ReverseHealthController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:6
    def serviceHealth(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "content/serviceHealth")
    }
  
  }

  // @LINE:1
  class ReverseHomeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:2
    def start(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "content/start")
    }
  
    // @LINE:5
    def consumptionList(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "content/consumptionList")
    }
  
    // @LINE:1
    def list(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "content/list")
    }
  
    // @LINE:3
    def update(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "content/update")
    }
  
    // @LINE:4
    def end(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "content/end")
    }
  
  }


}
