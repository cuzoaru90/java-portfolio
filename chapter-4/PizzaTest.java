public class PizzaTest {

  public static void main (String[] args){
    Pizza aPizza = new Pizza("large", 3, 1, 5);

    String description = aPizza.getDescription();
    System.out.println(description);


    aPizza.setToppings(2, 0, 3);
    aPizza.setSize("medium");

    String alteredDescription = aPizza.getDescription();
    System.out.println(alteredDescription);

  }
}
