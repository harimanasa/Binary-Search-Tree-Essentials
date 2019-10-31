package Arrays;
import java.lang.Math;
import java.lang.Double;

public class BST_Closest {

        static class BST {
            public int value;
            public BST left;
            public BST right;

            public BST(int value) {
                this.value = value;
            }
            public BST insert(int value){
                if(value < this.value)
                {
                    if(this.left==null) this.left=new BST(value);
                    else { this.left.insert(value);}
                }
                else if(value >= this.value)
                {
                    if(this.right==null) this.right=new BST(value);
                    else { this.right.insert(value);}
                }
            return this;
            }
        }

    public static int findClosestValueInBst(BST tree, int target) {
            return (int)helper(tree, target, Double.MAX_VALUE);
    }

    public static int helper(BST tree, int target, double closest) {
            if(target==tree.value){
            return tree.value;
            }

            else {
                if(Math.abs(target-tree.value)<(Math.abs(target-closest))){
                    closest = tree.value;
                }

                if(target<tree.value) {
                    if (tree.left != null) {
                        return helper(tree.left, target, closest);
                    }
                }
                if(target>tree.value){
                    if(tree.right!=null){
                        return helper(tree.right, target, closest);
                    }
                }
            }
        return (int)closest;
    }

    public static void main(String... args){
            BST tree = new BST(10).insert(3).insert(1).insert(5).insert(18).insert(12).insert(14);
            System.out.println(findClosestValueInBst(tree, -1));
    }

}



