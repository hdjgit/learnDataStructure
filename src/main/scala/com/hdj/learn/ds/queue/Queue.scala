package com.hdj.learn.ds.queue

/**
  * Author: 端吉
  * Date:   2018/9/21.
  */
trait Queue[E] {

  def add(e: E)

  /**
    * 移除并获取queue的头
    *
    * 如果queue为空会抛异常
    *
    * @return
    */
  def remove(): E

  def size(): Int
}
