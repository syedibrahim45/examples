import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class i {
    public static void main(String[] args) {
        List<Integer> data = Arrays.asList(1000,5000,2000,4500);
        List<Integer> newData = data.stream().filter(x->x>4000).collect(Collectors.toList());
        System.out.println(newData);
    }
}
