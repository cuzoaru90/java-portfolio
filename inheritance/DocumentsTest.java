public class DocumentsTest {

  public static void main(String[] args){
    Document doc = new Document("Hello world");

    Email email = new Email("Jim", "Kelly", "My message");
    email.setText("How's it going?");

    File file = new File("Hello world", "/Documents/Program.java");

    boolean found1 = containsKeyword(doc, "Hello");
    boolean found2 = containsKeyword(email, "Hello");
    boolean found3 = containsKeyword(file, "Hello");

    System.out.println(found1 + " " + found2 + " " + found3);

  }

  public static boolean containsKeyword(Document docObject, String keyword){
    if (docObject.toString().indexOf(keyword, 0) >= 0)
      return true;

    return false;

   }

}
