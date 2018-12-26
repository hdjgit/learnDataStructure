package com.hdj.learn.ds.list

class Node[E](var next: Node[E], var data: E) {
}

/**
  * Author: 端吉
  * Date:   2018/9/27.
  */
class LinkList[E >: Null](var currentSize: Int = 0) extends List[E] {

  var head = new Node[E](null, null)

  override def size(): Int = currentSize

  override def isEmpty(): Boolean = currentSize == 0

  override def contains(e: E): Boolean = {
    if (e == null) {
      return false
    }
    var currentNode: Node[E] = head
    while (currentNode != null) {
      if (currentNode.data == e) {
        return true
      }
      currentNode = currentNode.next
    }
    return false
  }

  override def find(e: E): Int = {
    var currentNode = head
    for (i <- 0 until size()) {
      currentNode = currentNode.next
      if (currentNode.data == e) {
        return i
      }
    }
    return -1
  }

  override def addLast(e: E) = {
    var tailNode: Node[E] = head
    while (tailNode.next != null) {
      tailNode = tailNode.next
    }
    tailNode.next = new Node[E](null, e)
    currentSize += 1
  }

  override def addFirst(e: E) = {
    //    val addedNode = new Node[E](null, e)
    //    addedNode.next = head.next
    //    head.next = addedNode

    //还可以这样
    head.next = new Node[E](head.next, e)
    currentSize += 1
  }

  override def add(index: Int, e: E) = {
    if (index > currentSize) {
      throw new IndexOutOfBoundsException("超出列表范围")
    }
    var preNode: Node[E] = null
    for (i <- 0 until index) {
      preNode = head.next
    }
    preNode.next = new Node[E](preNode.next, e)
  }

  override def set(index: Int, e: E): Unit = {
    if (index > currentSize) {
      throw new IndexOutOfBoundsException("超出列表范围")
    }
    var currentNode = head
    for (i <- 0 to index) {
      currentNode = currentNode.next
    }
    currentNode.data = e
  }

  override def remove(e: E): Boolean = {
    var currentNode = head
    for (i <- 0 until size()) {
      var preNode = currentNode
      currentNode = currentNode.next
      if (currentNode.data == e) {
        preNode.next = currentNode.next
        currentSize -= 1 //这里别漏了
        return true
      }
    }
    return false
  }

  override def remove(index: Int): E = {
    if (index > currentSize) {
      throw new IndexOutOfBoundsException("超出列表范围")
    }
    var currentNode = head
    var preNode = currentNode
    for (i <- 0 to index) {
      preNode = currentNode
      currentNode = currentNode.next
    }
    preNode.next = currentNode.next
    currentSize -= 1
    currentNode.data
  }

  override def get(index: Int): E = {
    if (index > currentSize) {
      throw new IndexOutOfBoundsException("超出列表范围")
    }
    var node: Node[E] = null
    for (i <- 0 to index) {
      node = head.next
    }
    node.data
  }

  override def toString: String = {
    var currentNode = head
    var s = "head ->["
    for (i <- 1 to size) {
      currentNode = currentNode.next
      if (i != size) {
        s += s"${currentNode.data},"
      } else {
        s += currentNode.data
      }
    }
    s += "]->tail"
    s
  }
}
