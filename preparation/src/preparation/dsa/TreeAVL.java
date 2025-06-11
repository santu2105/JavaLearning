package preparation.dsa;

public class TreeAVL {

	private NodeAvl root;

	// utility to get height
	int getHeight(NodeAvl node) {
		return node == null ? 0 : node.height;
	}

	// utility to get balance factor
	int getBalanceFactor(NodeAvl node) {
		return node == null ? 0 : getHeight(node.left) - getHeight(node.right);
	}

	// right rotation
	NodeAvl rightRotate(NodeAvl y) {
		NodeAvl x = y.left;
		NodeAvl t2 = x.right;
		x.right = y;
		y.left = t2;
		y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
		x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
		return x;
	}

	// left rotation
	NodeAvl leftRotate(NodeAvl x) {
		NodeAvl y = x.right;
		NodeAvl t2 = y.left;
		y.left = x;
		x.right = t2;
		x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
		y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
		return y;
	}

	// insert a key
	public NodeAvl insert(NodeAvl node, int data) {
		if (node == null)
			return new NodeAvl(data);
		if(data <node.data) 
			node.left = insert(node.left, data);
		else if (data > node.data)
			node.right = insert(node.right, data);
		else 
			return node;
		node.height=1 +Math.max(getHeight(node.left), getHeight(node.right));
		int balance = getBalanceFactor(node);
		
		// Left Left Case
        if (balance > 1 && data < node.left.data)
            return rightRotate(node);

        // Right Right Case
        if (balance < -1 && data > node.right.data)
            return leftRotate(node);

        // Left Right Case
        if (balance > 1 && data > node.left.data) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Right Left Case
        if (balance < -1 && data < node.right.data) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
	}
	
	   // Search for a key
    boolean search(NodeAvl node, int data) {
        if (node == null) return false;
        if (data == node.data) return true;
        return data < node.data ? search(node.left, data) : search(node.right, data);
    }
}

class NodeAvl {
	public NodeAvl(int data) {
		this.data = data;
		this.height = 1;
	}

	int data, height;
	NodeAvl left, right;
}