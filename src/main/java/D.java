import java.util.function.Predicate;

public class D {
    public static void main(String[] args) {
        Predicate<String> x = i->i.startsWith("S");
      boolean result =  x.test("Stallin");
      if (result) {
      System.out.println("true");
    }else{
      System.out.println("false");
      }
    }
}
