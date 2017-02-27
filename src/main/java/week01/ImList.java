package week01;

/**
 * Created by Tivadar Bocz on 2017.02.27..
 */
public interface ImList<E> {
    public static <E> ImList<E> empty() {
        return new Empty<>();
    }
    public ImList<E> cons(E e);
    public E first();
    public ImList<E> rest();
}
