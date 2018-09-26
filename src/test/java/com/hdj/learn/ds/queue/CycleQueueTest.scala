package com.hdj.learn.ds.queue

import org.junit.Test

/**
  * Author: 端吉
  * Date:   2018/9/26.
  */
class CycleQueueTest {

  @Test
  def add() = {
    val cycleQueue = new CycleQueue[Int]()
    for (i <- 0 until 20) {
      cycleQueue.add(i)
    }
    for(i <- 0 until 20){
      println(s"removeEle:${cycleQueue.remove()}")
    }
    println(s"cycleQueue:$cycleQueue")
  }

}
