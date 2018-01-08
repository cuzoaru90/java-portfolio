/**
 *  Define a class named Document that contains an instance variable of type String named text that stores any textual
 *  content for the document. Create a method named toString that returns the text field and also include a method to
 *  set the value.
 *
 *  Next, define a class for Email that is derived from Document and includes instance variables for the sender,
 *  recipient, and title of an email message. Implement appropriate accessor and mutator methods. The body of the email
 *  message should be stored in the inherited variable text. Redefine the toString method to concatenate all text fields.
 *
 *  Similarly, define a class for File that is derived from Document and includes a instance variable for the pathname.
 *  The textual contents of the file should be stored in the inherited variable text. Redefine the toString method to
 *  concatenate all text fields.
 *
 *  Finally, create several sample objects of type Email and File in your main method. Test your objects by passing them
 *  to the following subroutine that returns true if the object contains the specified keyword in the text property.
 *
 *  public static boolean ContainsKeyword(Document docObject, String keyword)
 *  {
 *    if (docObject.toString().indexOf(keyword, 0) >= 0)
 *      return true;
 *
 *    return false;
 *  }
 *
 */

public class Document {

  private String text;

  public Document(){
    text = "";
  }

  public Document(String words){
    text = words;
  }

  public void setText(String words) {
    text = words;
  }

  public String toString(){
    return text;
  }

}
