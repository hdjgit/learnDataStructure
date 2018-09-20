package com.hdj.learn.ds.stack

import scala.reflect.ClassTag

/**
  * Author: 端吉
  * Date:   2018/9/18.
  *
  * 数组栈
  */
class ArrayStack[E: ClassTag](var capacity: Int = 10) extends Stack[E] {

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
    * 插入数组第一个位置，后面的元素都向后挪一个
    *
    * @param e
    */
  override def push(e: E): Unit = {
    if (currentSize == capacity) {
      resize(capacity * 2)
    }
    for (i <- 0 until currentSize reverse) {
      arr(i + 1) = arr(i)
    }
    arr(0) = e
    currentSize += 1
  }

  override def pop(): E = {
    if (currentSize == 0) {
      throw new NoSuchElementException("stack is empty")
    }
    if (size() <= capacity / 4 && capacity > 4) {
      resize(capacity / 2)
    }
    val popEle = arr(0)
    for (i <- 1 until currentSize) {
      arr(i - 1) = arr(i)
    }
    currentSize -= 1
    popEle
  }

  override def peek(): E = {
    if (currentSize == 0) {
      throw new NoSuchElementException("stack is empty")
    }
    arr(0)
  }

  override def isEmpty(): Boolean = currentSize == 0

  override def size(): Int = currentSize

  override def toString: String = {
    var s = "head ["
    for (i <- 0 until currentSize) {
      if (i != currentSize - 1) {
        s += arr(i) + ","
      } else {
        s += arr(i)
      }
    }
    s += "]"
    s += "capacity:" + capacity
    s += ",size:" + size()
    s
  }
}
