package week01;

/**
 * Created by Tivadar Bocz on 2017.02.27..
 *
 *
 * Empty represents the result of the empty operation (an empty list)
 */
public class Empty<E> implements ImList<E> {
    public Empty() {
    }
    public ImList<E> cons(E e) {
        return new Cons<>(e, this);
    }
    public E first() {
        throw new UnsupportedOperationException();
    }
    public ImList<E> rest() {
        throw new UnsupportedOperationException();
    }
}
