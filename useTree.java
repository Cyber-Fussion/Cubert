
public class useTree {
	public static void main(String[] args) throws TreeViolationException {
		Integer num;
		BinTree<Integer> mytree = new BinTree<Integer>(25);
		BinTree<Integer> subtree = new BinTree<Integer>(50);
		mytree.attachLeft(subtree);
		subtree = new BinTree<Integer>(75);
		mytree.attachRight(subtree);

		//         25
		//       /    \
		//     50      75
		subtree = new BinTree<Integer>(10);
		subtree.attachRight(new BinTree<Integer>(100));
		subtree.attachLeft(new BinTree<Integer>(200));
		mytree = mytree.right;
		mytree.attachLeft(subtree);

		//         25
		//       /    \
		//     50      75
		//            /
		//           10
		//          /  \
		//        200  100
		mytree = mytree.root();
		System.out.println("\npreorder traversal:");
		mytree.reset();
		num = mytree.getNext();
		while (num != null) {
			System.out.println(num);
			num = mytree.getNext();
		}
	}
}