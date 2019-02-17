package com.hdj.learn.ds.list

/**
  * Author: 端吉
  * Date:   2019-02-17.
  *
  * Remove all elements from a linked list of integers that have value val.
  *
  * Example:
  *
  * Input:  1->2->6->3->4->5->6, val = 6
  * Output: 1->2->3->4->5
  */
object RemoveLinkListEle {

  class ListNode(var _x: Int = 0) {
    var next: ListNode = null
    var x: Int = _x

    override def toString: String = s"${x}->${next}"
  }

  object ListNode {
    def apply(arr: Array[Int]): ListNode = {
      val headNode = new ListNode(arr(0))
      var currentNode = headNode
      for (i <- 1 until arr.length) {
        val nodeToAdd = new ListNode(arr(i))
        currentNode.next = nodeToAdd
        currentNode = currentNode.next
      }
      return headNode
    }
  }

  object Solution {
    def removeElements(head: ListNode, value: Int): ListNode = {
      //1、先移除头部值为value的节点
      var currentHead = head
      if (head == null) {
        return null
      }
      while (currentHead != null && currentHead.x == value) {
        currentHead = currentHead.next
      }

      //2、移除后面相同的节点
      var currentNode = currentHead
      while (currentNode != null) {
        while (currentNode.next != null && currentNode.next.x == value) {
          currentNode.next = currentNode.next.next
        }
        currentNode = currentNode.next
      }
      return currentHead
    }

    /**
      * 使用虚拟节点统一操作，这样就不需要特判头部
      *
      * @param head
      * @param value
      * @return
      */
    def removeElementsWithDummyHead(head: ListNode, value: Int): ListNode = {
      var dummyHead = new ListNode(-1)
      dummyHead.next = head

      //2、移除后面相同的节点
      var currentNode = dummyHead
      while (currentNode != null) {
        while (currentNode.next != null && currentNode.next.x == value) {
          currentNode.next = currentNode.next.next
        }
        currentNode = currentNode.next
      }
      return dummyHead.next
    }

    /**
      * 递归移除
      *
      * @param head
      * @param value
      * @return
      */
    def recusiveElements(head: ListNode, value: Int): ListNode = {
      if (head == null) {
        return null
      }
      head.next = removeElements(head.next, value)
      return if (head.x == value) head.next else head
    }
  }

  def main(args: Array[String]): Unit = {
    val listNode = ListNode(Array(1, 2, 6, 3, 4, 5, 6));
//    Solution.recusiveElements(listNode, 6)
//    println(listNode)

    val listNode2 = ListNode(Array(1,9,9,9,9,9));
    Solution.recusiveElements(listNode2, 1)
    println(Solution.recusiveElements(listNode2, 1))
  }

}


