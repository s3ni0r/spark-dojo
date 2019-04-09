package mnt
import org.apache.spark.sql.SparkSession

object Application {
  def main(args: Array[String]): Unit = {

    val spark = SparkSession
      .builder()
      .appName(getClass.getSimpleName)
      .getOrCreate()

    val data = 1 to 100 toArray

    val rdd = spark.sparkContext.parallelize(data)

    rdd.filter(_ % 2 == 0).foreach(println)

    spark.close()

  }
}
