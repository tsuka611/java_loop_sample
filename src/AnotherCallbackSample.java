import java.util.Arrays;
import java.util.List;


public class AnotherCallbackSample<T> {

    public static void main(String... args) {
        List<String> list = Arrays.asList("AAA", "BBB", "CCC");

        // ラムダ式による順次実行の別パターン
        WithIndexIterable.iterate(list).eachWithIndex((v, i) -> Logic.doSomething(v, i));
    }
}
