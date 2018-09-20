package com.hdj.learn.ds.stack

import org.junit.Test
import com.hdj.learn.ds.stack.Stack

/**
  * Author: 端吉
  * Date:   2018/9/20.
  */
class ArrayStackTest {

  @Test
  def push() = {
    val stack: Stack[Int] = new ArrayStack[Int]()
    stack.push(1)
    stack.push(2)
    stack.push(3)
    stack.push(4)
    stack.push(5)
    println(s"stack:$stack")
  }

  @Test
  def pop() = {
    val stack: Stack[Int] = new ArrayStack[Int]()
    stack.push(1)
    stack.push(2)
    stack.push(3)
    stack.push(4)
    stack.push(5)
    println(s"stack:$stack")
    println(stack.pop())
    println(stack.pop())
    println(stack.pop())
    println(stack.pop())
    println(stack.pop())
    println(stack.pop())
  }

  @Test
  def peek() = {
    val stack: Stack[Int] = new ArrayStack[Int]()
    stack.push(1)
    stack.push(2)
    stack.push(3)
    stack.push(4)
    stack.push(5)
    println(s"stack:$stack")
    println(stack.peek())
    println(s"stack:$stack")
  }
  
  @Test
  def isEmpty() = {
    val stack: Stack[Int] = new ArrayStack[Int]()
    println(s"isEmpty:${stack.isEmpty()}")
    stack.push(1)
    println(s"isEmpty:${stack.isEmpty()}")
  }
}
