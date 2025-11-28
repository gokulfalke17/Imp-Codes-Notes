package com.nt.coding.challanges;

public class Custom_LinkedList {

	Node head;

	static class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			next = null;
		}
	}

	public static Custom_LinkedList insert(Custom_LinkedList list, int data) {

		Node newNode = new Node(data);

		if (list.head == null) {
			list.head = newNode;
		} else {
			Node last = list.head;

			while (last.next != null) {
				last = last.next;
			}

			last.next = newNode;
		}

		return list;
	}

	public static void printLinkedList(Custom_LinkedList list) {
		Node currNode = list.head;

		System.out.println("Custom LinkedList Data is :: ");
		while (currNode != null) {
			System.out.println(currNode.data);
			currNode = currNode.next;
		}
	}

	public static void main(String[] args) {
		
		Custom_LinkedList list = new Custom_LinkedList();
		insert(list, 1);
		insert(list, 2);
		insert(list, 3);
		insert(list, 4);
		
		printLinkedList(list);
	}
}
