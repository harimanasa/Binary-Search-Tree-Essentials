import java.lang.reflect.Array;
import java.util.ArrayList;
import java.lang.Integer;

public class IsSubTreeBST {

    public static class BST{
        public int value;
        BST left;
        BST right;
        BST(int value){this.value=value;}

        public BST insert(int value){
            if(value<this.value){
                if(this.left == null){ this.left = new BST(value);}
                else this.left.insert(value);
            }
            else if(value>=this.value){
                if(this.right == null){ this.right = new BST(value);}
                else this.right.insert(value);
            }
            return this;
        }

        public ArrayList<Integer> inOrderTraverse(ArrayList<Integer> path){
            if(this.left!=null){
                this.left.inOrderTraverse(path);
            }
            //System.out.println(this.value);
            path.add(this.value);
            if(this.right!=null){
                this.right.inOrderTraverse(path);
            }
            return path;
        }

        public boolean contains (int value){
            if(this.value == value) {return true;}
            else if(value<this.value){
                if(this.left!=null)
                return this.left.contains(value);
            }
            else if(value>this.value){
                if(this.right!=null)
                return this.right.contains(value);
            }
            return false;
        }

    }

    public static boolean areIdentical(BST tree, BST subtree){
        System.out.println("Now inside "+ tree.value);
        if(tree==null && subtree==null) {
            return true;
        }
        if(tree==null || subtree==null) {
            return false;
        }

        return ((tree.value == subtree.value) && (areIdentical(tree.left, subtree.left)) && areIdentical(tree.right, subtree.right));
    }

    public static boolean isSubTree(BST tree, BST subtree){
        if(tree==null) return false;
        if(subtree==null) return true;

        if(areIdentical(tree,subtree)==true) return true;
        return isSubTree(tree.left, subtree) || isSubTree(tree.right, subtree);
    }

    public static void main(String[] args){
        BST tree = new BST(10).insert(3).insert(11).insert(6).insert(17).insert(0).insert(4);
        ArrayList<Integer> path = tree.inOrderTraverse(new ArrayList<Integer>());
        BST subtree = new BST(10).insert(3).insert(11);
        System.out.println(isSubTree(tree, subtree));
    }


}
