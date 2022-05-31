package net.jgp.books.spark.basic

import org.apache.spark.sql.SparkSession

trait Basic {
  def getSession(appName: String): SparkSession = {
    SparkSession.builder().
      appName(appName).
      // master config get from command args
      // master("spark://10.11.1.120:7077").
      config("spark.executor.memory", "4g").
      getOrCreate()
  }
}