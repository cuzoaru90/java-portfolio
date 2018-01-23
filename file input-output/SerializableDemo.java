import java.io.*;

public class SerializableDemo {

  public static final int ENTRIES = 25;

  public static void main (String[] args){

    try{
      ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("serial.txt"));

      for (int i = 0; i < ENTRIES ; i++){
        int births = (int) (Math.random() * 5000 + 3);
        Entry anEntry = new Entry("John", i+1, births);
        outputStream.writeObject(anEntry);
      }

      System.out.println("Objects written to the file serial.txt.");
      outputStream.close();

    }
    catch(IOException e){
      System.out.println("Problem with file output");
      System.exit(0);
    }

    readBinaryFile("serial.txt");

  }

  public static void readBinaryFile(String filename){

    try{
      ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filename));

      // try-catch is necessary for determining end of binary file; unavoidable code smell
      try {
        while (true) {
          Entry anEntry = (Entry)inputStream.readObject();
          System.out.println(anEntry);
        }
      }
      catch (EOFException e){
        ;
      }
      catch (ClassNotFoundException e) {
        e.printStackTrace();
      }

    }
    catch (FileNotFoundException e){
      System.out.println("Problem opening file.");
      System.exit(0);
    }
    catch (IOException e){
      System.out.println("Problem with input from " + filename);
    }

  }


}
