import com.sksamuel.elastic4s.mapping.FieldType.StringType
import com.sksamuel.elastic4s.{ElasticClient, ElasticDsl}
import ElasticDsl._
import java.util.concurrent.Executors
import org.elasticsearch.action.bulk.BulkProcessor
import scala.concurrent.ExecutionContext
import scala.io.Source
import scala.util.{Failure, Success}

/**
 * User: chuluan.ll
 * Date: 14-6-10
 * Time: 下午2:37
 */
object ElasticForScala {
  def main(args: Array[String]) {
    implicit val ec = ExecutionContext.fromExecutor(Executors.newFixedThreadPool(2))
    val client = ElasticClient.remote("10.19.2.181" -> 9300, "10.19.2.182" -> 9300)
    val source = Source.fromFile("/Users/lin/AliDrive/finalout.txt");
    val bulkProcess: BulkProcessor = BulkProcessor.builder(client.client, null).setBulkActions(10000).setConcurrentRequests(10).build()
    client.execute(
      create index "aospoi" mappings (
        "poi" as(
          "poiName" typed StringType analyzer "ik",
          "poiTypeName" typed StringType analyzer "ik"
          )
        )
    ) onComplete {
      case Success(m) => println(m)
      case Failure(e) => println(e)
    }
  }
}
