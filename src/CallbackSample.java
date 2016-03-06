import java.util.Arrays;
import java.util.List;
import java.util.function.ObjIntConsumer;

public class CallbackSample {

    public static <T> void eachWithIndex(Iterable<T> itr, ObjIntConsumer<T> action) {
        int index = 0;
        for (T t : itr) {
            action.accept(t, index++);
        }
    }

    public static void main(String... args) {
        List<String> list = Arrays.asList("AAA", "BBB", "CCC");

        // ラムダ式による順次実行のパターン
        eachWithIndex(list, (v, i) -> Logic.doSomething(v, i));
    }
}
