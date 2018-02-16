public class TreeCloneDemo {

  public static void main(String[] args){

    int [] numbers = {40, 33, 95, 67, 25, 106, 46, 50, 14};

    BinarySearchTree tree = new BinarySearchTree();

    for (int n: numbers){
      tree.insert(n);
    }

    tree.printTree();
      
  }


}
