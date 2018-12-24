package com.hdj.learn.ds.stack.problem

import scala.collection.mutable

//@formatter:off
/**
  * Author: 端吉
  * Date:   2018-12-24.
  *
  * Implement Stack using Queues
  *
  * Implement the following operations of a stack using queues.
  *
  * push(x) -- Push element x onto stack.
  * pop() -- Removes the element on top of the stack.
  * top() -- Get the top element.
  * empty() -- Return whether the stack is empty.
  *
  * Notes:
  *
  * You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and is empty operations are valid.
  * Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
  * You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).
  */
//@formatter:on
object QueueStack {
  def main(args: Array[String]): Unit = {
    val stack = new MyStack
    stack.push(1)
    stack.push(2)
    stack.push(3)
    stack.push(4)
    stack.push(5)

    println(stack.pop())
    println(stack.pop())
    println(stack.pop())
    println(stack.pop())
    println(stack.pop())
  }
}

class MyStack() {

  /** Initialize your data structure here. */
  var queue = new mutable.Queue[Int]()

  /** Push element x onto stack. */
  def push(x: Int) {
    var newQueue = new mutable.Queue[Int]()
    newQueue.enqueue(x)
    while (!queue.isEmpty) {
      newQueue.enqueue(queue.dequeue())
    }
    queue = newQueue
  }

  /** Removes the element on top of the stack and returns that element. */
  def pop(): Int = {
    queue.dequeue()
  }

  /** Get the top element. */
  def top(): Int = {
    queue.head
  }

  /** Returns whether the stack is empty. */
  def empty(): Boolean = {
    queue.isEmpty
  }

}

/**
  * Your MyStack object will be instantiated and called as such:
  * var obj = new MyStack()
  * obj.push(x)
  * var param_2 = obj.pop()
  * var param_3 = obj.top()
  * var param_4 = obj.empty()
  */
