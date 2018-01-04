public class File extends Document {

  private String pathname;

  public File(){
    super();
  }

  public File(String words, String path){
    super(words);
    pathname = path;
  }

  public String toString(){
    return pathname + " " + super.toString();
  }

}
