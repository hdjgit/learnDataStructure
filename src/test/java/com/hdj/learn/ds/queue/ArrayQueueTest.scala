package com.hdj.learn.ds.queue

import org.junit.Test

/**
  * Author: 端吉
  * Date:   2018/9/21.
  */
class ArrayQueueTest {

  @Test
  def add() = {
    val queue = new ArrayQueue[Int]()
    queue.add(1)
    queue.add(2)
    queue.add(3)
    queue.add(4)
    queue.add(5)
    queue.add(6)
    println(s"queue:$queue")
  }

  @Test
  def remove() = {
    val queue = new ArrayQueue[Int]()
    queue.add(1)
    queue.add(2)
    queue.add(3)
    queue.add(4)
    queue.add(5)
    queue.add(6)
    println(queue.remove())
    println(queue.remove())
    println(queue.remove())
    println(queue.remove())
    println(queue.remove())
    println(queue.remove())
    println(queue.remove())
    println(queue.remove())
  }
}
