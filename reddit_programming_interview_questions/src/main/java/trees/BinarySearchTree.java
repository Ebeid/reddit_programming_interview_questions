package trees;

// http://www.javabeat.net/binary-search-tree-traversal-java/
public class BinarySearchTree {
	public Node root;

	public void insert(int value) {
		Node node = new Node<>(value);

		if (root == null) {
			root = node;
			return;
		}

		insertRec(root, node);

	}

	private void insertRec(Node latestRoot, Node node) {

		if (latestRoot.value > node.value) {

			if (latestRoot.left == null) {
				latestRoot.left = node;
				return;
			} else {
				insertRec(latestRoot.left, node);
			}
		} else {
			if (latestRoot.right == null) {
				latestRoot.right = node;
				return;
			} else {
				insertRec(latestRoot.right, node);
			}
		}
	}

	// https://gist.github.com/mycodeschool/9465a188248b624afdbf
	// http://geeksquiz.com/binary-search-tree-set-2-delete/
	/*
	 * Given a binary search tree and a key, this function deletes the key and
	 * returns the new root
	 */
	public Node delete(Node root, int value) {
		if (root == null) {
			return root;
		}
		// If the key to be deleted is smaller than the root's key,
		// then it lies in left subtree
		else if (value < root.value) {
			root.left = delete(root.left, value);
		}
		// If the key to be deleted is greater than the root's key,
		// then it lies in right subtree
		else if (value > root.value) {
			root.right = delete(root.right, value);
		}
		// if key is same as root's key, then This is the node to be deleted
		// else if (value == root.value)
		else {
			// Case 1: No child
			if (root.left == null && root.right == null) {
				root = null;
			}
			// Case 2: One child
			// only right node exists
			else if (root.right != null) {
				root = root.right; // replace current node with its right node
			} 
			// only left no exists
			else if (root.left != null) {
				root = root.left; // replace current node with its left node
			}
			// case 3: 2 children
			else {
				Node minimumNode = findMinimum(root.right);
				root.value = minimumNode.value;
				root.right = delete(root.right, minimumNode.value);
			}
		}

		return root;
	}

	/**
	 * Returns the minimum value in the Binary Search Tree.
	 */
	public Node findMinimum(Node root) {
		Node currNode = root;

		/* loop down to find the leftmost leaf */
		while (currNode.left != null) {
			currNode = currNode.left;
		}

		return currNode;
	}

	/**
	 * Returns the maximum value in the Binary Search Tree
	 */
	public Node findMaximum(Node root) {
		Node currNode = root;

		/* loop down to find the rightmost leaf */
		while (currNode.right != null) {
			currNode = currNode.right;
		}

		return currNode;
	}

	/**
	 * Printing the contents of the tree in an inorder way.
	 */
	public void printInorder() {
		printInOrderRec(root);
		System.out.println("");
	}

	/**
	 * Helper method to recursively print the contents in an inorder way
	 */
	private void printInOrderRec(Node currRoot) {
		if (currRoot == null) {
			return;
		}
		printInOrderRec(currRoot.left);
		System.out.print(currRoot.value + ", ");
		printInOrderRec(currRoot.right);
	}

	/**
	 * Printing the contents of the tree in a Preorder way.
	 */
	public void printPreorder() {
		printPreOrderRec(root);
		System.out.println("");
	}

	/**
	 * Helper method to recursively print the contents in a Preorder way
	 */
	private void printPreOrderRec(Node currRoot) {
		if (currRoot == null) {
			return;
		}
		System.out.print(currRoot.value + ", ");
		printPreOrderRec(currRoot.left);
		printPreOrderRec(currRoot.right);
	}

	/**
	 * Printing the contents of the tree in a Postorder way.
	 */
	public void printPostorder() {
		printPostOrderRec(root);
		System.out.println("");
	}

	/**
	 * Helper method to recursively print the contents in a Postorder way
	 */
	private void printPostOrderRec(Node currRoot) {
		if (currRoot == null) {
			return;
		}
		printPostOrderRec(currRoot.left);
		printPostOrderRec(currRoot.right);
		System.out.print(currRoot.value + ", ");
	}

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(40);
		bst.insert(25);
		bst.insert(78);
		bst.insert(10);
		bst.insert(3);
		bst.insert(17);
		bst.insert(32);
		bst.insert(30);
		bst.insert(38);
		bst.insert(78);
		bst.insert(50);
		bst.insert(93);

		System.out.println("Inorder traversal");
		bst.printInorder();

		System.out.println("Preorder Traversal");
		bst.printPreorder();

		System.out.println("Postorder Traversal");
		bst.printPostorder();

		System.out.println("remove 17");
		bst.delete(bst.root, 17);
		bst.printInorder();

		System.out.println("The minimum value in the BST: "
				+ bst.findMinimum(bst.root).value);
		System.out.println("The maximum value in the BST: "
				+ bst.findMaximum(bst.root).value);
	}
}
