package com.implementation.binarytree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree implements Traversals {
	
	private Node root;
	static int index;
	
	public Node getRoot() {
		return root;
	}

	@Override
	public void preOrder(Node root) {
		if(root == null) {
			return;
		}
		System.out.print(root.data + " ");
		preOrder(root.leftChild);
		preOrder(root.rightChild);
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
		postOrder(root.leftChild);
		postOrder(root.rightChild);
		System.out.print(root.data + " ");
	}

	@Override
	public void levelOrder(Node root) {
		if(root == null) {
			return;
		}
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
		if(root == null) {
			return;
		}
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
		if(root == null) {
			return;
		}
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
		if(root == null) {
			return;
		}
		Stack<Node> nodes = new Stack<>();
		Node currNode = root;
		while(currNode != null || !nodes.isEmpty()) {
			if(currNode != null) {
				nodes.push(currNode);
				currNode = currNode.leftChild;
			}
			else {
				Node temp = nodes.peek().rightChild;
				if(temp == null) {
					temp = nodes.pop();
					System.out.print(temp.data + " ");
				}
				
			}
		}
	}

	@Override
	public void morrisPreOrder(Node root) {
		Node currNode = root;
		while(currNode != null) {
			if(currNode.leftChild == null) {
				System.out.print(currNode.data + " ");
				currNode = currNode.rightChild;
			}
			else {
				Node rightmostNode = findRightmostNodeOfLeft(currNode);
				if(rightmostNode.rightChild == null) {
					System.out.print(currNode.data + " ");
					rightmostNode.rightChild = currNode;
					currNode = currNode.leftChild;
				}
				else {
					rightmostNode.rightChild = null;
					currNode = currNode.rightChild;
				}
			}
		}
	}
	
	@Override
	public void morrisInOrder(Node root) {
		Node currNode = root;
		while(currNode != null) {
			if(currNode.leftChild == null) {
				System.out.print(currNode.data + " ");
				currNode = currNode.rightChild;
			}
			else {
				Node rightmostNode = findRightmostNodeOfLeft(currNode);
				if(rightmostNode.rightChild == null) {
					rightmostNode.rightChild = currNode;
					currNode = currNode.leftChild;
				}
				else {
					System.out.print(currNode.data + " ");
					rightmostNode.rightChild = null;
					currNode = currNode.rightChild;
				}
			}
		}
	}
	
	private Node findRightmostNodeOfLeft(Node currNode) {
		Node left = currNode.leftChild;
		while(left.rightChild != null && left.rightChild != currNode) {
			left = left.rightChild;
		}
		return left;
	}

	@Override
	public void postOrderUsingTwoStacks(Node root) {
		if(root == null) {
			return;
		}
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
	public void verticalOrder(Node root) {
		if(root == null) {
			return;
		}
		
	}

	@Override
	public void reverseLevelOrder(Node root) {
		if(root == null) {
			return;
		}
		Queue<Node> nodes = new LinkedList<>();
		Stack<Node> nodesInReverse = new Stack<>();
		nodes.add(root);
		while(!nodes.isEmpty()) {
			Node currNode = nodes.remove();
			nodesInReverse.push(currNode);
			if(currNode.rightChild != null) {
				nodes.add(currNode.rightChild);
			}
			if(currNode.leftChild != null) {
				nodes.add(currNode.leftChild);
			}
		}
		while(!nodesInReverse.isEmpty()) {
			System.out.print(nodesInReverse.pop() + " ");
		}
	}

	@Override
	public void levelByLevelPrinting(Node root) {
		if(root == null) {
			return;
		}
		Queue<Node> nodes = new LinkedList<>();
		nodes.add(root);
		int count = 1, count2 = 0;
		while(!nodes.isEmpty()) {
			Node currNode = nodes.remove();
			count--;
			System.out.print(currNode.data + " ");
			if(currNode.leftChild != null) {
				nodes.add(currNode.leftChild);
				count2++;
			}
			if(currNode.rightChild != null) {
				nodes.add(currNode.rightChild);
				count2++;
			}
			if(count == 0) {
				count = count2;
				count2 = 0;
				System.out.println();
			}
		}
	}

	@Override
	public void reverseLevelByLevelPrinting(Node root) {
		if(root == null) {
			return;
		}
		
	}
	
	public Node constructTreeFromInorderAndPreorder(int[] inorder, int[] preorder, int size) {
		if(inorder == null || preorder == null || inorder.length == 0 || preorder.length == 0 || inorder.length != preorder.length) {
			return null;
		}
		Map<Integer, Integer> inorderIndex = new HashMap<>();
		for(int i = 0; i < size; i++) {
			inorderIndex.put(inorder[i], i);
		}
		return constructTreeFromInorderandPreorder(inorder, preorder, 0, size - 1, inorderIndex);
	}

	private Node constructTreeFromInorderandPreorder(int[] inorder, int[] preorder, int start, int end, Map<Integer, Integer> inorderIndex) {
		if(start > end) {
			return null;
		}
		Node newNode = new Node(preorder[index++]);
		if(start == end) {
			return newNode;
		}
		int rootIndex = inorderIndex.get(newNode.data);
		newNode.leftChild = constructTreeFromInorderandPreorder(inorder, preorder, start, rootIndex - 1, inorderIndex);
		newNode.rightChild = constructTreeFromInorderandPreorder(inorder, preorder, rootIndex + 1, end, inorderIndex);
		return newNode;
	}
	
	public Node constructFromArray(int[] arr) {
		if(arr == null || arr.length == 0) {
			return null;
		}
		Node root = new Node(arr[0]);
		Queue<Node> nodes = new LinkedList<>();
		nodes.add(root);
		for(int i = 1; i < arr.length;) {
			Node curr = nodes.remove();
			curr.leftChild = new Node(arr[i++]);
			nodes.add(curr.leftChild);
			if(i < arr.length) {
				curr.rightChild = new Node(arr[i++]);
				nodes.add(curr.rightChild);
			}
		}
		return root;
	}
	
	public void printPostFromInAndPre(int[] inorder, int[] preorder, int size) {
		if(inorder == null || preorder == null || inorder.length == 0 || preorder.length == 0 || inorder.length != preorder.length) {
			return;
		}
		Map<Integer, Integer> inorderIndex = new HashMap<>();
		for(int i = 0; i < size; i++) {
			inorderIndex.put(inorder[i], i);
		}
		printPostFromInAndPre(inorder, preorder, 0, size - 1, inorderIndex);
	}
	
	private void printPostFromInAndPre(int[] inorder, int[] preorder, int start, int end,
			Map<Integer, Integer> inorderIndex) {
		if(start > end) {
			return;
		}
		int indexInorder = inorderIndex.get(preorder[index++]);
		printPostFromInAndPre(inorder, preorder, start, indexInorder - 1, inorderIndex);
		printPostFromInAndPre(inorder, preorder, indexInorder + 1, end, inorderIndex);
		System.out.print(inorder[indexInorder] + " ");
	}

	public void constructTree() {
		root = new Node(1);
		root.leftChild = new Node(2);
		root.rightChild = new Node(3);
		root.leftChild.leftChild = new Node(4);
		root.leftChild.rightChild = new Node(5);
		root.rightChild.leftChild = new Node(6);
		root.rightChild.rightChild = new Node(7);
	}
	
	public Node newTreeWithNodeValueAsSumOfInorderPredecessorAndSuccessor() {
		List<Node> nodesInorder = new ArrayList<>();
		Node currNode = root;
		while(currNode != null) {
			if(currNode.leftChild == null) {
				nodesInorder.add(currNode);
				currNode = currNode.rightChild;
			}
			else {
				Node rightmostNode = findRightmostNodeOfLeft(currNode);
				if(rightmostNode.rightChild == null) {
					rightmostNode.rightChild = currNode;
					currNode = currNode.leftChild;
				}
				else {
					System.out.print(currNode.data + " ");
					rightmostNode.rightChild = null;
					currNode = currNode.rightChild;
				}
			}
		}
		
		return null;
	}
}
