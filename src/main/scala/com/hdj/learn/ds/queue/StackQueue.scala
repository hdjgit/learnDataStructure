package com.hdj.learn.ds.queue

/**
  * Author: 端吉
  * Date:   2018-12-26.
  */
class StackQueue[E] extends Queue[E] {

  var head: Node[E] = null

  var tail: Node[E] = null

  var currentSize: Int = 0

  class Node[E](var next: Node[E], var data: E) {
  }

  override def add(e: E): Unit = {
    var addedNode = new Node[E](null, e)
    if (tail == null) {
      head = addedNode
      tail = addedNode
    } else {
      //队列新的节点加到尾巴上，这样移除会比较简单
      tail.next = addedNode
      tail = addedNode
    }
    currentSize += 1
  }

  override def remove(): E = {
    if (currentSize == 0) {
      throw new Error("queue is empty")
    }
    val currentHead = head
    head = head.next

    //补充
    if (head == null)
      tail = null

    currentSize -= 1
    currentHead.data
  }

  override def size(): Int = currentSize

  override def toString: String = {
    var cur = head
    var str = "head ["
    while (cur != null) {
      str += cur.data
      if (cur.next != null) {
        str += "-->"
      }
      cur = cur.next
    }
    str += "] tail"
    str
  }
}
