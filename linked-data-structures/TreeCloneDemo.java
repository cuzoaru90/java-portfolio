public class TreeCloneDemo {

  public static void main(String[] args){

    int [] numbers = {40, 33, 95, 67, 25, 106, 46, 50, 14};

    BinarySearchTree t1 = new BinarySearchTree();

    for (int n: numbers){
      t1.insert(n);
    }

    BinarySearchTree t2 = t1.cloneTree();

    System.out.println(t1.equals(t2));

  }


}
