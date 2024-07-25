import java.util.function.Predicate;

public class C {
    public static void main(String[] args) {
        Predicate<String> x = i -> i.equals("mike");
        boolean result = x.test("mike");
        if (result) {
        System.out.println("true");
    }else {
            System.out.println("false");

        }
    }
}
