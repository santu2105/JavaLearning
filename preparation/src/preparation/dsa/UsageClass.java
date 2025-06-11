package preparation.dsa;

public class UsageClass {

	public static void main(String[] args) {
		TreeAVL tree = new TreeAVL();
		NodeAvl root= tree.insert(null, 10);
		root = tree.insert(root, 20);
		root = tree.insert(root, 40);
		root = tree.insert(root, 15);
		System.out.println(tree.search(root, 16));
		
	}

}
