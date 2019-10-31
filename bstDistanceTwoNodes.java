package BST;

public class bstDistanceTwoNodes {
    public static class BST{
        int value;
        BST left, right;
        BST(int value){this.value = value;}

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

        public static int distanceFromRoot(BST tree, int n){
            if(tree.value == n) return 0;
            if(n < tree.value) return distanceFromRoot(tree.left, n)+1;
            if(n > tree.value) return distanceFromRoot(tree.right, n)+1;
            return 0;
        }

        public static int distanceBetweenTwo(BST tree, int n1, int n2){
            if(n1 < tree. value && n2 < tree.value ){
                return distanceBetweenTwo(tree.left, n1, n2);
            }
            if(n1 > tree. value && n2 > tree.value ){
                return distanceBetweenTwo(tree.right, n1, n2);
            }
            if(n1 < tree. value && n2 > tree.value ){
                return distanceFromRoot(tree, n1) + distanceFromRoot(tree, n2);
            }
            return 0;
        }


    }

    public static void main(String[] args){
        BST tree = new BST(10).insert(5).insert(1).insert(15).insert(4).insert(14);
        int n1 = 14; int n2 = 4;
        if (n1 < n2) {
            System.out.println(BST.distanceBetweenTwo(tree, n1, n2));
        } else {
            System.out.println(BST.distanceBetweenTwo(tree, n2, n1));
        }
    }

}
