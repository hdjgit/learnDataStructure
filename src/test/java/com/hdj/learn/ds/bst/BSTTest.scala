package com.hdj.learn.ds.bst

import org.junit.Test

/**
  * Author: 端吉
  * Date:   2019-02-18.
  */
class BSTTest {


  //@formatter:off
  /**
    *               4
    *              / \
    *             2   8
    *            / \  /
    *           1  3 7
    */
  //@formatter:on
  @Test
  def add() = {
    val bst = new BST[Integer]
    bst.add(4)
    bst.add(2)
    bst.add(1)
    bst.add(8)
    bst.add(7)
    bst.add(3)
    bst.preTraverse()
  }

  @Test
  def inTraverse() = {
    val bst = new BST[Integer]
    bst.add(4)
    bst.add(2)
    bst.add(1)
    bst.add(8)
    bst.add(7)
    bst.add(3)
    bst.inTraverse()
  }

  @Test
  def postTraverse() = {
    val bst = new BST[Integer]
    bst.add(4)
    bst.add(2)
    bst.add(1)
    bst.add(8)
    bst.add(7)
    bst.add(3)
    bst.postTraverse()
  }

}
