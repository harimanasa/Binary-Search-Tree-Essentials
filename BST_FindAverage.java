package BST;

public class BST_FindAverage {

    static class BST{
        int value;
        BST left;
        BST right;
        BST(int value){this.value=value;}

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
        static int count, sum;

        static void preOrder_sum(BST tree){
            count++;
            sum += tree.value;
            System.out.println(tree.value);
            if(tree.left != null){ preOrder_sum(tree.left);}
            if(tree.right != null){ preOrder_sum(tree.right);}
        }

    }





    public static void main(String... args){
        BST tree = new BST(10).insert(5).insert(15).insert(1).insert(14).insert(1).insert(4);
        BST.preOrder_sum(tree);
        System.out.println("sum is: " + tree.sum + " and count is: " + tree.count+ " average is: " + tree.sum/tree.count);
    }

}
