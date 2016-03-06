import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class MappingSample {


    public static <T> Function<T, ValWithIndex<T>> withIndex() {
        return new Function<T, ValWithIndex<T>>() {
            private int index;

            @Override
            public ValWithIndex<T> apply(T t) {
                return new ValWithIndex<>(t, index++);
            }
        };
    }

    public static void main(String... args) {
        List<String> list = Arrays.asList("AAA", "BBB", "CCC");

        // Streamの間に挟んだパターン
        list.stream().map(withIndex()).forEach(v -> Logic.doSomething(v.getVal(), v.getIndex()));
    }
}
