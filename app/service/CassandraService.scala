package service
import com.datastax.driver.core.{Cluster, Row, Session}
import com.typesafe.config.ConfigFactory
import java.util
class CassandraService {

  val conf =ConfigFactory.load()
  val host= conf.getString("cassandra.host")
  val port= conf.getInt("cassandra.port")

  def cassandraAccess() :Session={
    val cluster = Cluster.builder()
      .addContactPoint(host)
      .withPort(port)
      .build()
    cluster.connect("contents")
  }

  def read(query: String): util.List[Row] = {
    val result = cassandraAccess().execute(query)
    result.all()
  }

  def update(query: String):Boolean ={
    val result = cassandraAccess().execute(query)
    result.wasApplied()
  }

}
