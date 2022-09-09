// @GENERATOR:play-routes-compiler
// @SOURCE:/home/stpl/Downloads/content-api-main/conf/routes
// @DATE:Fri Sep 09 12:52:16 IST 2022

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseHomeController HomeController = new controllers.ReverseHomeController(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseHomeController HomeController = new controllers.javascript.ReverseHomeController(RoutesPrefix.byNamePrefix());
  }

}
