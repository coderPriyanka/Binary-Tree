package com.implementation.binarytree;

public interface Traversals {
	
	void preOrder(Node root);
	void morrisPreOrder(Node root);
	void preOrderUsingStack(Node root);
	
	void inOrder(Node root);
	void morrisInOrder(Node root);
	void inOrderUsingStack(Node root);
	
	void postOrder(Node root);
	void postOrderUsingOneStack(Node root);
	void postOrderUsingTwoStacks(Node root);
	
	void levelOrder(Node root);
	void reverseLevelOrder(Node root);
	void levelByLevelPrinting(Node root);
	void reverseLevelByLevelPrinting(Node root);
	
	void verticalOrder(Node root);

}
