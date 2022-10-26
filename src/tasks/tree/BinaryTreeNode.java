package tasks.tree;

public class BinaryTreeNode {
    private final int data;
    private BinaryTreeNode left;
    private BinaryTreeNode right;

    public BinaryTreeNode(int data) {
        this.data = data;
    }

    public int getData() {
        return this.data;
    }

    public BinaryTreeNode getLeft() {
        return this.left;
    }

    public BinaryTreeNode getRight() {
        return this.right;
    }

    public void setLeft(BinaryTreeNode left) {
        this.left = left;
    }

    public void setRight(BinaryTreeNode right) {
        this.right = right;
    }

    public void add(int data) {
        BinaryTreeNode current = this;
        BinaryTreeNode parents = current;

        while (current != null){
            parents = current;
            if (data >= current.getData()){
                current = current.getRight();
            }
            else if (data < current.getData()){
                current = current.getLeft();
            }
        }
        if (data >= parents.getData()){
            parents.setRight(new BinaryTreeNode(data));
        }
        else if (data < parents.getData()){
            parents.setLeft(new BinaryTreeNode(data));
        }

        /*if (data < current.getData()) {



            if (current.getLeft() != null) {
                while (current != null && data < current.getData()) {
                    parents = current;
                    current = current.getLeft();
                }
            }
            //parents.add(data);
            parents.setLeft(new BinaryTreeNode(data));
        } else if (data >= current.getData()) {
            if (current.getRight() != null) {
                while (current != null && data < current.getData()) {
                    parents = current;
                    current = current.getRight();
                }
            }
            //parents.add(data);
            parents.setRight(new BinaryTreeNode(data));
        }*/
    }


}
