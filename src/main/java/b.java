import ch.qos.logback.core.CoreConstants;

import java.util.function.Predicate;

public class b {

    public static void main(String[] args) {
        Predicate<Integer> x= i->i%2==0;
        boolean result = x.test(111);
        if (result) {
            System.out.println("Even");
        }else{
            System.out.println("Odd");
        }
    }
}
