import org.springframework.cglib.core.internal.Function;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;




// it takes an input produces an output
public class j {
    public static void main(String[] args) {
     Supplier<Integer> val = ()-> new Random().nextInt(100);
     System.out.println(val.get());
    }
}
