package trees;

public class Node<T> {
	public int value;
	public Node left;
	public Node right;

	public Node(int value) {
		this.value = value;
	}

	public boolean remove(int value, Node parent) {
		if (value < this.value) {
			if (left != null)
				return left.remove(value, this);
			else
				return false;
		} else if (value > this.value) {
			if (right != null)
				return right.remove(value, this);
			else
				return false;
		} else {
			if (left != null && right != null) {
				this.value = right.minValue();
				right.remove(this.value, this);
			} else if (parent.left == this) {
				parent.left = (left != null) ? left : right;
			} else if (parent.right == this) {
				parent.right = (left != null) ? left : right;
			}
			return true;
		}
	}

	public int minValue() {
		if (left == null)
			return value;
		else
			return left.minValue();
	}

}