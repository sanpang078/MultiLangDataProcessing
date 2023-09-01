package org.example.engine

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd.RDD

object Pratice {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("test")
    val sc = new SparkContext(conf)
    val fileRdd: RDD[String] = sc.textFile("D:\\软件\\maven\\maven-space\\MultiLangDataProcessing\\src\\resources")

    val kvRdd: RDD[(String, String)] = fileRdd.map(line => (line.split(" ")(0), line))

    kvRdd.sortByKey().repartitionAndSortWithinPartitions()
      .collect().foreach(println)

    sc.stop()

  }
}
