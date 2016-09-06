import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by kranian on 16. 9. 6.
 */
public class Fountain {

    private final int child;
    private final int parent;
    private double result;

    public Fountain(int  child, int parent){
        this.child = child;
        this.parent = parent;
        this.clac();
    }
    private void clac(){
        result = (double) this.child /(double)this.parent;


    }
    @Override
    public String toString() {
        return "Fountain{" +
                "child=" + child +
                ", parent=" + parent +
                '}';
    }

    public void show() {
        final String search= String.valueOf(result);
        final String gVal = String.valueOf(Long.valueOf(search.substring(2)));
        final StringBuffer pattern = new StringBuffer();

        gVal.chars().distinct().mapToObj(c -> String.valueOf((char)c))
                .filter(v -> {
                   long sCount = gVal.chars().mapToObj(c -> String.valueOf((char)c))
                                  .filter( dv -> Objects.equals(v,dv))
                                  .count();
                return sCount > 1;
        })
        .forEach(pattern::append);

        if( pattern.length() > 0 ){
            System.out.println(this +", orignal = "+result +", pattern = "+pattern);
        }

    }
}
