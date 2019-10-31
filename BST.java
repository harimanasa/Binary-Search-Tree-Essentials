import java.lang.Integer;
import java.lang.reflect.Array;
import java.util.ArrayList;

class BST_Traversal {
    static class BST {
        int value;
        BST left;
        BST right;

        BST(int value) {
            this.value = value;
        }

        public BST insert(int value) {
            if (value < this.value) {
                if (this.left == null) {
                    this.left = new BST(value);
                } else {
                    this.left.insert(value);
                }
            } else if (value > this.value) {
                if (this.right == null) {
                    this.right = new BST(value);
                } else {
                    this.right.insert(value);
                }
            } else {
                System.out.println("This is a duplicate node");
            }
            return this;
        }

        public static ArrayList<Integer> inOrderTraverse(BST tree, ArrayList<Integer> array) {
            if (tree.left != null) inOrderTraverse(tree.left, array);
            System.out.print(tree.value + " ");
            array.add(tree.value);
            if (tree.right != null) inOrderTraverse(tree.right, array);
            return array;
        }

        public static ArrayList<Integer> preOrderTraverse(BST tree, ArrayList<Integer> array) {
            System.out.print(tree.value + " ");
            array.add(tree.value);
            if (tree.left != null) preOrderTraverse(tree.left, array);
            if (tree.right != null) preOrderTraverse(tree.right, array);
            return array;
        }

        public static ArrayList<Integer> postOrderTraverse(BST tree, ArrayList<Integer> array) {
            if (tree.left != null) postOrderTraverse(tree.left, array);
            if (tree.right != null) postOrderTraverse(tree.right, array);
            System.out.print(tree.value + " ");
            array.add(tree.value);
            return array;
        }



    }
    public static void main(String[] args) {
        BST_Traversal.BST tree = new BST_Traversal.BST(10).insert(5).insert(15).insert(1).insert(14).insert(4);
        ArrayList<Integer> PreOrderResult = BST_Traversal.BST.preOrderTraverse(tree, new ArrayList<Integer>());
        //preOrderTraverse(tree, new ArrayList<Integer>()); System.out.println();
        //inOrderTraverse(tree, new ArrayList<>()); System.out.println();
        //postOrderTraverse(tree, new ArrayList<>()); System.out.println();


    }
}