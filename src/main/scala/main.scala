import org.apache.spark.sql.SparkSession
import scalapb.spark.Implicits._
import com.google.protobuf.ByteString


object ScalapbSparkIssue extends App {

  val spark = SparkSession.builder()
  .master("local[*]")
  .appName("hd-kafka-s3")
  .getOrCreate()


  val byteStrings: Seq[ByteString] =
    Seq(ByteString.copyFrom(Array[Byte](1, 2, 3)), ByteString.EMPTY)
  val bytesArrays = byteStrings.map(_.toByteArray)
  spark
    .createDataset(byteStrings)
    .map(bs => (bs.toString, bs))
    .show()
}

