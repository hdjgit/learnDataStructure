package com.hdj.learn.ds.queue

import scala.reflect.ClassTag

/**
  * Author: 端吉
  * Date:   2018/9/21.
  */
class ArrayQueue[E: ClassTag](var capacity: Int = 10) extends Queue[E] {

  var arr = new Array[E](capacity)

  var currentSize = 0

  def resize(newCapacity: Int) = {
    var newArr = new Array[E](newCapacity)
    for (i <- 0 until currentSize) {
      newArr(i) = arr(i)
    }
    capacity = newCapacity
  }

  /**
    * 添加一个元素是O(n)的复杂度
    *
    * @param e
    */
  override def add(e: E): Unit = {
    if (currentSize == capacity) {
      resize(capacity * 2)
    }
    for (i <- 0 until currentSize reverse) {
      arr(i + 1) = arr(i)
    }
    arr(0) = e
    currentSize += 1
  }

  /**
    * 删除一个元素是O(1)的复杂度
    *
    * @return
    */
  override def remove(): E = {
    if (currentSize == 0) {
      throw new NoSuchElementException("queue is empty")
    }
    val headEle = arr(currentSize - 1)
    currentSize -= 1
    headEle
  }

  override def size(): Int = currentSize

  override def toString: String = {
    var s = "tail ["
    for (i <- 0 until currentSize) {
      if (i != currentSize - 1) {
        s += arr(i) + ","
      } else {
        s += arr(i)
      }
    }
    s += "] head"
    s += "capacity:" + capacity
    s += ",size:" + size()
    s
  }
}
