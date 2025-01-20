class Nodee{
    int key,height;
    Node left, right;
    Node(int d){
        key=d;
        height=1;

    }
}


public class AVLTree {
    Node root;
    int height(Nodee N){
        if(N==null)
            return 0;
        return N.height;
    }
    int max(int a, int b){
        return (a>b)?a:b;
    }
    Nodee rightRotate(Node y){
        Nodee x=y.left;
        Nodee T2=x.right;
        x.right=y;
        y.left=T2;
        y.height=max(height(y.left),height(y.right))+1;
        x.height=max(height(x.left),height(x.right))+1;
        return x;
    }
    Node leftRotate(Node x){
        Node y=x.left;
        Node T2=y.right;
        y.right=x;
        x.left=T2;
        x.height=max(height(x.left),height(x.right))+1;
        y.height=max(height(y.left),height(y.right))+1;
        return y;
    }

}
