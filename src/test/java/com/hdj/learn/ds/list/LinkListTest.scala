package com.hdj.learn.ds.list

import org.junit.Test

/**
  * Author: 端吉
  * Date:   2018/9/28.
  */
class LinkListTest {

  @Test
  def linkList() = {
    val list = new LinkList[Integer]()
    list.addLast(1)
    list.addLast(2)
    list.addLast(3)
    list.addLast(4)
    list.addLast(5)
    println(list)
  }

  @Test
  def set() = {
    val list = new LinkList[Integer]()
    list.addLast(1)
    list.addLast(2)
    list.addLast(3)
    list.addLast(4)
    list.addLast(5)

    list.set(3, 999)
    println(list)
  }

  @Test
  def remove() = {
    val list = new LinkList[Integer]()
    list.addLast(1)
    list.addLast(2)
    list.addLast(3)
    list.addLast(4)
    list.addLast(5)

    list.remove(3.asInstanceOf[Integer])
    println(list)
  }

  @Test
  def remove2() = {
    val list = new LinkList[Integer]()
    list.addLast(1)
    list.addLast(5)
    list.addLast(7)
    list.addLast(10)
    list.addLast(15)

    list.remove(3)
    println(list)
  }

  @Test
  def find() = {
    val list = new LinkList[Integer]()
    list.addLast(1)
    list.addLast(5)
    list.addLast(7)
    list.addLast(10)
    list.addLast(15)

    println(list.find(10))
    println(list.find(15))
    println(list.find(120))
  }

  @Test
  def contains() = {
    val list = new LinkList[Integer]()
    list.addLast(1)
    list.addLast(5)
    list.addLast(7)
    list.addLast(10)
    list.addLast(15)

    println(list.contains(1))
    println(list.contains(5))
    println(list.contains(12))
  }

  @Test
  def addFirst() = {
    val list = new LinkList[Integer]()
    list.addFirst(1)
    list.addFirst(5)
    list.addFirst(7)
    list.addFirst(10)
    list.addFirst(15)

    println(list)
  }
}
