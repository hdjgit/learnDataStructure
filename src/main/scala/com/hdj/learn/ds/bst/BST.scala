package com.hdj.learn.ds.bst

import scala.reflect.ClassTag

/**
  * Author: 端吉
  * Date:   2019-02-18.
  *
  * 二分搜索树
  */
class BST[E <% Ordered[E] : ClassTag] {

  var root: Node[E] = null

  class Node[E](var left: Node[E], var right: Node[E], var data: E) {
    def this(data: E) {
      this(null, null, data)
    }

    override def toString: String = if (data != null) data.toString else null
  }

  def add(e: E): Unit = {
    //之所以要特判root为空，是因为递归调用的函数的结果没有影响

    root = add(e, root)

    /**
      * 对比下之前的add方法，返回了添加了元素后节点的值。
      *
      * 因此不需要在一开始，特判节点为空的情况
      *
      * @param e
      * @return 返回添加了数据之后的节点
      */
    def add(e: E, node: Node[E]): Node[E] = {
      if (node == null) {
        return new Node[E](e)
      }
      if (e < node.data) {
        node.left = add(e, node.left)
      } else if (e > node.data) {
        node.right = add(e, node.right)
      }
      return node
    }
  }

  /**
    * 添加节点
    *
    * @param e
    */
  def add2(e: E): Unit = {
    //1、特判下根节点是不是为空
    if (root == null) {
      //注意为啥这边要特判root呢？因为add操作有副作用，它做的是把元素添加到节点的操作，如果传进去的是个null，它不能把入参改成另一个引用
      root = new Node[E](e)
    } else {
      add2(e, root)
    }
  }

  /**
    * 把元素e添加到Node节点为根节点的子树里
    *
    * @param e
    * @param node 不要传空的进来，传进来不知道怎么处理
    */
  def add2(e: E, node: Node[E]): Unit = {
    if (e < node.data && node.left == null) {
      //添加到左子树里
      node.left = new Node[E](e)
      return
    } else if (e > node.data && node.right == null) {
      node.right = new Node[E](e)
      return
    } else if (e == node.data) {
      return
    }

    //递归添加到左右子树
    if (e < node.data) {
      add2(e, node.left)
    } else if (e > node.data) {
      add2(e, node.right)
    }
  }

  def preTraverse(): Unit = {
    preTraverse(root)

    /**
      * 前序遍历
      */
    def preTraverse(node: Node[E]): Unit = {
      if (node != null) {
        println(node)
        preTraverse(node.left)
        preTraverse(node.right)
      }
    }
  }

  /**
    * 中序遍历
    *
    * 中序遍历的结果就是排序后的结果
    */
  def inTraverse(): Unit = {
    def inTraverse(node: Node[E]): Unit = {
      if (node != null) {
        inTraverse(node.left)
        println(node.data)
        inTraverse(node.right)
      }
    }

    inTraverse(root)
  }

  /**
    * 后续遍历
    */
  def postTraverse(): Unit = {
    def postTraverse(node: Node[E]): Unit = {
      if (node != null) {
        postTraverse(node.left)
        postTraverse(node.right)
        println(node.data)
      }
    }

    postTraverse(root)
  }


}


