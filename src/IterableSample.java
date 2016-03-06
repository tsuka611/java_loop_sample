import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class IterableSample {

    public static <T> Iterable<ValWithIndex<T>> withIndex(Iterable<T> itr) {

        return () -> new Iterator<ValWithIndex<T>>() {
            private int index = 0;
            private Iterator<T> it = itr.iterator();

            @Override
            public boolean hasNext() {
                return it.hasNext();
            }

            @Override
            public ValWithIndex<T> next() {
                return new ValWithIndex<>(it.next(), index++);
            }
        };
    }

    public static void main(String... args) {
        List<String> list = Arrays.asList("AAA", "BBB", "CCC");

        // 拡張for文に対応させたパターン
        for (ValWithIndex<String> v : withIndex(list)) {
            Logic.doSomething(v.getVal(), v.getIndex());
        }
    }
}
