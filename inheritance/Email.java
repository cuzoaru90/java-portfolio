public class Email extends Document {

  private String sender, recipient;
  private String title;

  public Email(){
    super();
  }

  public Email(String from, String to, String title){
    sender = from;
    recipient = to;
    this.title = title;
  }

  public String toString(){
    return sender + " " + recipient + " " + title + " " + super.toString();
  }



}
