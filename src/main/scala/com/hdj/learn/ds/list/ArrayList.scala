package com.hdj.learn.ds.list

import scala.reflect.ClassTag

/**
  * Author: 端吉
  * Date:   2018/9/14.
  *
  * 底层实现是数组
  *
  * @param capacity 容量
  * @param ev$1
  * @tparam E
  */
class ArrayList[E <% Ordered[E] : ClassTag](private var capacity: Int = 5) extends List[E] {

  var arr = new Array[E](capacity)

  /**
    * 数组当前元素个数，指向的永远为空
    */
  var currentSize: Int = 0

  override def size(): Int = currentSize

  override def isEmpty(): Boolean = currentSize == 0

  override def contains(e: E): Unit = ???

  def resize(newCapacity: Int) = {
    println(s"resize capacity:$capacity newCapacity:$newCapacity")
    var newArray = new Array[E](newCapacity)
    for (i <- 0 until currentSize) {
      newArray(i) = arr(i)
    }
    arr = newArray
    capacity = newCapacity
  }

  override def add(e: E): Boolean = {
    if (currentSize == capacity) {
      resize(capacity * 2)
    }
    //就是往数组最后添加个值，需要判断是否需要扩容
    arr(currentSize) = e
    currentSize += 1
    true
  }

  /**
    * remove就是遍历找到某个值，然后把后面的都向前移动
    *
    * 注意只移动一个
    *
    * 复杂度O(n)
    *
    * @param e
    * @return
    */
  override def remove(e: E): Boolean = {
    if (e == null) {
      throw new IllegalArgumentException("remove null element")
    }
    val eleIndex = (0 until currentSize).find(i => e equals arr(i))
    eleIndex.foreach(i => remove(i))
    !eleIndex.isEmpty
  }

  override def get(index: Int) = {
    if (index < 0 || index > currentSize) {
      throw new IndexOutOfBoundsException(s"$currentSize out of bounds")
    }
    arr(index)
  }

  override def toString: String = {
    var s = "["
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

  override def remove(index: Int) = {
    if (index < 0 || index > currentSize) {
      throw new IndexOutOfBoundsException(s"$currentSize out of bounds")
    }
    if (size() <= capacity / 4) {
      resize(capacity / 2)
    }
    val toRemovedEle = get(index)
    if (index < currentSize - 1) {
      for (index <- index + 1 until currentSize) {
        arr(index - 1) = arr(index)
      }
      //      arr(currentSize - 1) = null todo 泛型数组的默认值究竟该怎么设置？？
    }
    currentSize -= 1
    toRemovedEle
  }
}
