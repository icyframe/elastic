import scala.io.Source

/**
 * User: chuluan.ll
 * Date: 14-6-13
 * Time: 下午5:47
 */
object Test extends  App{
  val source = Array[String]("a","b","c","d")
  val newone  =source.toIterator.grouped(3)
  newone.foreach(println(_))
}
