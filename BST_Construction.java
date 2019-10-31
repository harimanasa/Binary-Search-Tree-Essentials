package BST;

import java.util.ArrayList;

class BinarySearchTree {
    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }

        public BST insert(int value) {
            if(value<this.value){
                if(this.left == null) this.left = new BST(value);
                else this.left.insert(value);
            }
            else if(value >= this.value){
                if(this.right == null) this.right = new BST(value);
                else this.right.insert(value);
            }
            return this;
        }

        public boolean contains(int value) {
             if(value<this.value){
                if(this.left == null) return false;
                else return this.left.contains(value);
            }
            else if(value > this.value){
                if(this.right == null) return false;
                else return this.right.contains(value);
            }
            return true;
        }

        public BST remove(int key) {
            remove(key, null);
            return this;
        }

        public void remove(int value, BST parent) {
            /* Start : Compare value and recurse till the value node reached */
            if (value < this.value) {
                if (left != null) {
                    left.remove(value, this);
                }
            } else if (value > this.value) {
                if (right != null) {
                    right.remove(value, this);
                }
            }
            /* End : Compare value and recurse till the value node reached */

            else {

                /* When value reached, check if children exist */
                /* both children exist, removing one of the parent nodes in a tree */
                /* If both children exist, the minimum most element should */
                /* After making the right child's minimum most element as the root, you're actually copying the value to the root. So you need to remove the element. */

                if (left != null && right != null) {
                    this.value = right.getMinValue();
                    right.remove(this.value, this);
                }

                /* Start: If the node to remove itself is the root */
                else if (parent == null) {

                    /* Bias is to always make if available, the left (minimum) node to be the root */

                    if (left != null) {
                        this.value = left.value;
                        left = left.left; /* This order is important */
                        right = left.right;
                    }

                    /* If left not available */
                    else if (right != null) {
                        this.value = right.value;
                        left = right.left; /* This order is important */
                        right = right.right;
                    } else {
                        this.value = 0;
                    }

                }

                /* End: If the node to remove itself is the root */
                /* Removing the original element after copying in to root */


                else if (parent.left == this) {
                    parent.left = left != null ? left : right;
                } else if (parent.right == this) {
                    parent.right = left != null ? left : right;
                }
            }
        }

        public int getMinValue(){
            if(this.left!=null){
                return this.left.getMinValue();
            }
            else {
                return this.value;
            }
        }

        public ArrayList<BST> inOrderTraversal(ArrayList<BST> array){
            if(this.left != null) this.left.inOrderTraversal(array);
            array.add(this);
            if(this.right != null) this.right.inOrderTraversal(array);
            return array;
        }

        public ArrayList<BST> preOrderTraversal(ArrayList<BST> array){
            array.add(this);
            if(this.left != null) this.left.inOrderTraversal(array);
            if(this.right != null) this.right.inOrderTraversal(array);
            return array;
        }

        public ArrayList<BST> postOrderTraversal(ArrayList<BST> array){
            if(this.left != null) this.left.inOrderTraversal(array);
            if(this.right != null) this.right.inOrderTraversal(array);
            array.add(this);
            return array;
        }
    }

    public static void main(String... args){
        BST tree = new BST(2).insert(5).insert(7).insert(4).insert(44).insert(12);
        tree.remove(4);
        ArrayList<BST> inOrderTraversal = new ArrayList<BST>();
        inOrderTraversal = tree.inOrderTraversal(inOrderTraversal);

        for(BST node : inOrderTraversal){
            System.out.println(node.value);
        }
    }

}
