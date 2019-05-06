package com.implementation.binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinarySearchTree implements Operations, Traversals {
	private Node root;

	@Override
	public void insert(int data) {
		Node newNode = new Node(data);
		if(root == null) {
			root = newNode;
			return;
		}
		Node parent = findParentNode(root, data);
		if(data <= parent.data) {
			parent.leftChild = newNode;
		}
		else {
			parent.rightChild = newNode;
		}
	}

	private Node findParentNode(Node root, int data) {
		if(data < root.data && root.leftChild != null) {
			return findParentNode(root.leftChild, data);
		}
		if(data > root.data && root.rightChild != null) {
			return findParentNode(root.rightChild, data);
		}
		return root;
	}

	@Override
	public boolean search(int data) {
		return root != null && findParentNode(root, data).data == data;
	}

	@Override
	public boolean delete(int data) {
		return false;
	}

	@Override
	public void preOrder(Node root) {
		if(root == null) {
			return;
		}
		preOrder(root.leftChild);
		preOrder(root.rightChild);
		System.out.print(root.data + " ");
	}

	@Override
	public void inOrder(Node root) {
		if(root == null) {
			return;
		}
		inOrder(root.leftChild);
		System.out.print(root.data + " ");
		inOrder(root.rightChild);
	}

	@Override
	public void postOrder(Node root) {
		if(root == null) {
			return;
		}
		System.out.print(root.data + " ");
		postOrder(root.leftChild);
		postOrder(root.rightChild);
	}

	@Override
	public void levelOrder(Node root) {
		Queue<Node> nodes = new LinkedList<>();
		nodes.add(root);
		while(!nodes.isEmpty()) {
			Node currNode = nodes.remove();
			System.out.print(currNode.data + " ");
			if(currNode.leftChild != null) {
				nodes.add(currNode.leftChild);
			}
			if(currNode.rightChild != null) {
				nodes.add(currNode.rightChild);
			}
		}
	}

	@Override
	public void preOrderUsingStack(Node root) {
		Stack<Node> nodes = new Stack<>();
		nodes.push(root);
		while(!nodes.isEmpty()) {
			Node currNode = nodes.pop();
			if(currNode.rightChild != null) {
				nodes.push(currNode.rightChild);
			}
			if(currNode.leftChild != null) {
				nodes.push(currNode.leftChild);
			}
			System.out.print(currNode.data + " ");
		}
	}

	@Override
	public void inOrderUsingStack(Node root) {
		Stack<Node> nodes = new Stack<>();
		nodes.push(root);
		Node currNode = root.leftChild;
		while(currNode != null || !nodes.isEmpty()) {
			if(currNode != null) {
				nodes.push(currNode);
				currNode = currNode.leftChild;
			}
			else {
				Node temp = nodes.pop();
				System.out.print(temp.data + " ");
				if(temp.rightChild != null) {
					nodes.push(temp.rightChild);
					currNode = nodes.peek().leftChild;
				}
			}
		}
	}

	@Override
	public void postOrderUsingOneStack(Node root) {
		
	}
	
	@Override
	public void postOrderUsingTwoStacks(Node root) {
		Stack<Node> stack1 = new Stack<>();
		Stack<Node> stack2 = new Stack<>();
		stack1.push(root);
		while(!stack1.isEmpty()) {
			Node currNode = stack1.pop();
			if(currNode.leftChild != null) {
				stack1.push(currNode.leftChild);
			}
			if(currNode.rightChild != null) {
				stack1.push(currNode.rightChild);
			}
			stack2.push(currNode);
		}
		while(!stack2.isEmpty()) {
			System.out.print(stack2.pop().data + " ");
		}
	}

	@Override
	public void morrisInOrder(Node root) {
		
	}

	@Override
	public void verticalOrder(Node root) {
		
	}
}
