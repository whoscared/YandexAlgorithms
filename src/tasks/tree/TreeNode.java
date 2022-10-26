package tasks.tree;

public class TreeNode {
    private int data;
    private TreeNode left;
    private TreeNode right;

    public TreeNode (int data ){
        this.data = data;
    }

    public void setData (int data){
        this.data = data;
    }

    public void left (int data){
        if (this.left == null){
            this.left = new TreeNode(data);
        }
        else {
            left.setData(data);
        }
    }

    public void right (int data){
        if (this.right == null){
            this.right = new TreeNode(data);
        }
        else {
            right.setData(data);
        }
    }

    public int getData (){
        return  this.data;
    }

    public TreeNode getLeft (){
        return left;
    }

    public TreeNode getRight(){
        return right;
    }
}
