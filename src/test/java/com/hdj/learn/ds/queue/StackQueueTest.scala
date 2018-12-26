package com.hdj.learn.ds.queue

import org.junit.Test

/**
  * Author: 端吉
  * Date:   2018-12-26.
  */
class StackQueueTest {

  @Test
  def add() = {
    val stackQueue = new StackQueue[Integer]
    stackQueue.add(1)
    stackQueue.add(2)
    stackQueue.add(3)
    stackQueue.add(4)
    stackQueue.add(5)
    println(stackQueue)
  }

  @Test
  def remove() = {
    val stackQueue = new StackQueue[Integer]
    for (i <- 1 to 5) {
      stackQueue.add(i)
      println(stackQueue)
    }
    for (i <- 1 to 5) {
      println(stackQueue.remove())
      println(stackQueue)
    }
  }

}
