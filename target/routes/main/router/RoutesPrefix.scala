// @GENERATOR:play-routes-compiler
// @SOURCE:/home/stpl/Downloads/content-api-main/conf/routes
// @DATE:Fri Sep 09 12:52:16 IST 2022


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
