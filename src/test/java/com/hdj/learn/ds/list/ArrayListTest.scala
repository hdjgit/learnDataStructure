package com.hdj.learn.ds.list

import org.junit.Test

/**
  * Author: 端吉
  * Date:   2018/9/14.
  */
class ArrayListTest {

  @Test
  def testNew() = {
    val list: List[Int] = new ArrayList[Int]()
    println(s"list:$list")
  }

  @Test
  def testAdd() = {
    val list: List[Int] = new ArrayList[Int]()
    for (i <- 0 to 100) {
      list.addLast(i)
    }
    println(s"list:$list")
  }

  @Test
  def testAdd2() = {
    val list: List[Int] = new ArrayList[Int]()
    for (i <- 0 to 100) {
      list.addLast(i)
    }
    list.add(1,10000)
    println(s"list:$list")
  }

  @Test
  def testAdd3() = {
    val list: List[Int] = new ArrayList[Int]()
    for (i <- 0 to 100) {
      list.addLast(i)
    }
    list.add(101,10000)
    println(s"list:$list")
  }



  @Test
  def removeEle() = {
    val list: List[Integer] = new ArrayList[Integer]()
    for (i <- 0 until 100) {
      list.addLast(i)
    }

    list.remove(5)
    list.remove(10)
    list.remove(20)
    println(s"list:$list")
  }

  @Test
  def remove() = {
    val list: List[Integer] = new ArrayList[Integer]()
    for (i <- 0 until 20) {
      list.addLast(i)
    }

    for (i <- 0 until 20) {
      list.remove(i.asInstanceOf[Integer])
//      list.remove(i) // 注意，此处不能这样删除的！！！
    }
  }
}
