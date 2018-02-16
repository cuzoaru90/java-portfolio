public class BinarySearchTree implements Cloneable{

  public class BSTNode{
    private int data;
    private BSTNode left;
    private BSTNode right;

    public BSTNode(int newData){
      data = newData;
      left = null;
      right = null;
    }

  } // inner class ends

  private BSTNode root;

  public BinarySearchTree(){
    root = null;
  }

  public void insert(int newData){
    root = addAtRoot(root, newData);
  }

  public BSTNode addAtRoot(BSTNode root, int newData){

    if (root == null){
      root = new BSTNode(newData);
      return root;
    }

    if (newData < root.data){
      root.left = addAtRoot(root.left, newData);
    }
    else if (newData > root.data){
      root.right = addAtRoot(root.right, newData);
    }

    return root;
  }

  public void printTree(){
    inOrderTraversal(root);
  }

  public void inOrderTraversal(BSTNode root){

    if (root != null){
      inOrderTraversal(root.left);
      System.out.println(root.data);
      inOrderTraversal(root.right);
    }

  }


}
