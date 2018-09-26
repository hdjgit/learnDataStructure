package com.hdj.learn.ds.queue

import scala.reflect.ClassTag

/**
  * Author: 端吉
  * Date:   2018/9/24.
  */
class CycleQueue[E: ClassTag](var capacity: Int = 10) extends Queue[E] {

  var arr = new Array[E](capacity)

  var endIndex = 0

  var startIndex = 0

  def resize(newCapacity: Int) = {
    println(s"start resize:oldCapacity:$capacity newCapacity:$newCapacity")
    var newArr = new Array[E](newCapacity)
    var newArrIndex = 0
    for (i <- startIndex until endIndex) {
      newArr(newArrIndex) = arr(i % capacity)
      newArrIndex += 1
    }
    endIndex = endIndex - startIndex
    startIndex = 0
    capacity = newCapacity
    arr = newArr
  }

  /**
    * 添加一个元素是O(n)的复杂度
    *
    * @param e
    */
  override def add(e: E): Unit = {
    if (isFull()) {
      resize(capacity * 2)
    }
    arr(endIndex % capacity) = e
    endIndex += 1
  }

  /**
    * 删除一个元素是O(1)的复杂度
    *
    * @return
    */
  override def remove(): E = {
    if (endIndex - startIndex == 0) {
      throw new NoSuchElementException("queue is empty")
    }
    if (endIndex - startIndex <= capacity / 4 && capacity / 4 > 0) {
      resize(capacity / 2)
    }
    val headEle = arr(startIndex % capacity)
    startIndex += 1
    headEle
  }

  //这样实现也就是endIndex有可能大于capacity了
  def isFull(): Boolean = {
    endIndex - startIndex == capacity
  }

  override def size(): Int = endIndex - startIndex

  override def toString: String = {
    var s = "head ["
    for (i <- startIndex until endIndex) {
      if (i != endIndex - 1) {
        s += arr(i % capacity) + ","
      } else {
        s += arr(i % capacity)
      }
    }
    s += "] tail"
    s += "capacity:" + capacity
    s += ",size:" + size()
    s
  }
}
