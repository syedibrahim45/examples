import java.util.function.Predicate;

public class E {
    public static void main(String[] args) {
        Predicate<String>x=i->i.length()>=4;
      boolean result =  x.test("ram");
      if(result){
      System.out.println("true");
    }else {
          System.out.println("false");
      }
      }
}
