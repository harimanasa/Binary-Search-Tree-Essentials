package BST;

import java.lang.Integer;

class ValidateBST {
    public static boolean validateBst(BST tree) {
        return validateBst(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    public static boolean validateBst(BST tree, int min, int max) {
        if(tree.left != null && !validateBst(tree.left, min, tree.value))
            return false;
        if(tree.right != null && !validateBst(tree.right, tree.value, max))
            return false;
        if(tree.value < min || tree.value >= max)
            return false;
        return true;
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }

        public BST insert(int value){
            if(value < this.value){
                if(this.left!=null){this.left.insert(value);}
                else {this.left = new BST(value);}
            }
            else if(value > this.value){
                if(this.right!=null){this.right.insert(value);}
                else {this.right = new BST(value);}
            }
            return this;
        }
        static void preOrder(BST tree){
            System.out.println(tree.value);
            if(tree.left != null){ preOrder(tree.left);}
            if(tree.right != null){ preOrder(tree.right);}
        }
    }


    public static void main(String... args){
        BST tree = new BST(10).insert(5).insert(15).insert(5).insert(2).insert(1).insert(22).insert(11);
        //tree.left.right.right = new BST(11);
        System.out.println(ValidateBST.validateBst(tree));
    }
}
