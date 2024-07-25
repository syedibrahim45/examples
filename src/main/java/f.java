import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class f {
    public static <list> void main(String[] args) {
       List<Integer> data = Arrays.asList(10,20,21,34,23,21,30,40);
       List<Integer> newdata = data.stream().filter(x->x%2!=0).collect(Collectors.toList());

       System.out.println(newdata);
    }

}
