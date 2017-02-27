import week01.ImList;

/**
 * Created by Tivadar Bocz on 2017.02.27..
 */
public class Main {

    public static void main(String[] args) {

        //System.out.println(Recursive.factorial(3));
        //System.out.println(Recursive.fibonacci(3));
        //System.out.println(Recursive.subsequences("123456"));
        //System.out.println(Recursive.subsequences3("xy"));
        //System.out.println(Recursive.stringValue(170,16));

        ImList<Object> airports = ImList.empty().cons("SFO").cons("IAD").cons("BOS");
        System.out.println(airports.first());
        System.out.println(airports.rest().rest().toString());

    }
}
