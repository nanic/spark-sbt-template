package com.iamn.journey

import org.apache.log4j.Logger
import org.apache.spark.sql.SparkSession
import org.scalatest.{BeforeAndAfter, FunSuite}

class SampleSparkTest extends FunSuite with BeforeAndAfter {

  val logger = Logger.getLogger(classOf[SampleSparkTest])

  before {

  }

  test("sample test case") {

    val sparkSession = SparkSession
      .builder()
      .appName("Sample Spark App")
      .master("local[*]")
      .config("spark.driver.host", "localhost")
      .getOrCreate()

    val meetupDataDF = sparkSession.read.json("src/test/resources/sample_weather.json")

    logger.info(meetupDataDF.schema)
    import sparkSession.implicits._

    val grouped = meetupDataDF.groupBy($"city".getItem("name")).count()
    val cities = grouped.count()
    logger.info(cities)

    sparkSession.stop()

  }

  after {

  }

}
