import java.util.function.ObjIntConsumer;

public interface WithIndexIterable<T> extends Iterable<T> {

    default void eachWithIndex(ObjIntConsumer<T> action) {
        int index = 0;
        for (T t : this) {
            action.accept(t, index++);
        }
    }

    static <T> WithIndexIterable<T> iterate(Iterable<T> itr) {
        return () -> itr.iterator();
    }
}
