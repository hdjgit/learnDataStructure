package com.hdj.learn.ds.list

/**
  * Author: 端吉
  * Date:   2018/9/14.
  *
  * 可变长度的数组
  */
trait List[E] {

  def size(): Int

  def isEmpty(): Boolean

  def contains(e: E): Boolean

  def find(e: E): Int

  def addLast(e: E): Unit

  def addFirst(e: E): Unit

  def add(index: Int, e: E): Unit

  def set(index: Int, e: E)

  /**
    *
    * @param e
    * @return true 如果List里存在这个元素
    */
  def remove(e: E): Boolean

  def remove(index: Int): E

  def get(index: Int): E
}
