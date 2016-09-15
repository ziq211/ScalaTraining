/**
  * Created by ZQin on 9/15/2016.
  */

package scala.atom.place

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.SparkContext._

object SparkWordCount {
  def main(args: Array[String]): Unit ={
    val sc = new SparkContext(new SparkConf().setAppName("Spark Word Count"))
    val threshold = args(1).toInt

    // split each document into words
    val tokenized = sc.textFile(args(0)).flatMap(_.split(" "))

    // count the occurence of each word
    val wordCounts = tokenized.map((_,1)).reduceByKey(_ + _)

    System.out.println(wordCounts.collect().mkString(", "))
  }
}