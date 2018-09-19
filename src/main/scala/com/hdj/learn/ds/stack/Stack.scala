package com.hdj.learn.ds.stack

/**
  * Author: 端吉
  * Date:   2018/9/18.
  *
  * 栈
  */
trait Stack[E] {

  def push(e: E)

  def pop(): E

  /**
    * 看一看链表的头
    *
    * @return
    */
  def peek(): E

  def remove(): E

  def isEmpty(): Boolean

  def size(): Int
}
