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
				Node minimumNode = findMinimum(root.right); // find minimum node in a right subtree
				root.value = minimumNode.value; // copy value of minimum node to value of a node to be deleted
				root.right = delete(root.right, minimumNode.value); // delete the minimum node
				
				// alternative
//				Node maximumNode = findMaximum(root.left);
//				root.value = maximumNode.value;
//				root.left = delete(root.left, maximumNode.value);
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
	 * method to recursively print the contents in a Inorder way
	 */
	private void printInOrder(Node root) {
		if (root == null) {
			return;
		}

		printPreOrder(root.left);
		System.out.print(root.value + ", ");
		printPreOrder(root.right);
	}
	
	/**
	 * method to recursively print the contents in a Preorder way
	 */
	private void printPreOrder(Node root) {
		if (root == null) {
			return;
		}
		
		System.out.print(root.value + ", ");
		printPreOrder(root.left);
		printPreOrder(root.right);
	}

	/**
	 * method to recursively print the contents in a Postorder way
	 */
	private void printPostOrder(Node root) {
		if (root == null) {
			return;
		}
		
		printPostOrder(root.left);
		printPostOrder(root.right);
		System.out.print(root.value + ", ");
	}

	// https://www.cs.usfca.edu/~galles/visualization/BST.html
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(60);
		bst.insert(40);
		bst.insert(70);
		bst.insert(80);

		System.out.println("Inorder traversal");
		bst.printInOrder(bst.root);
		System.out.println();

		System.out.println("Preorder Traversal");
		bst.printPreOrder(bst.root);
		System.out.println();

		System.out.println("Postorder Traversal");
		bst.printPostOrder(bst.root);
		System.out.println();

		System.out.println("remove 70");
		Node nodeReferencingDeletedNode = bst.delete(bst.root, 70);
		System.out.println("nodeReferencingDeletedNode: " + nodeReferencingDeletedNode.value);
		
		System.out.println("Inorder traversal");
		bst.printInOrder(bst.root);
		System.out.println();

		System.out.println("The minimum value in the BST: "
				+ bst.findMinimum(bst.root).value);
		System.out.println("The maximum value in the BST: "
				+ bst.findMaximum(bst.root).value);
	}
}
