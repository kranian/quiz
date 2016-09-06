import java.util.stream.IntStream;

public class Main {


    public static void main(String[] args) {

        IntStream.range(2,100).mapToObj( parent -> new Fountain(1,parent) )
                              .forEach( ft -> ft.show() );


    }
}
