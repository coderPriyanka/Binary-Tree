package com.implementation.binarytree;

public class Node {
	
	int data;
	Node leftChild;
	Node rightChild;
	
	public Node(int data) {
		this.data = data;
		this.leftChild = null;
		this.rightChild = null;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(Node leftChild) {
		this.leftChild = leftChild;
	}

	public Node getRightChild() {
		return rightChild;
	}

	public void setRightChild(Node rightChild) {
		this.rightChild = rightChild;
	}
	
}
