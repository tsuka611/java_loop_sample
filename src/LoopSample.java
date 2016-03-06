import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

public class LoopSample {
    public static void main(String... args) {

        List<String> list = Arrays.asList("AAA", "BBB", "CCC");

        // 変数のスコープなどを見やすくするためにブロックで囲んであります。

        {
            // 通常のforループを利用するパターン
            for (int i = 0; i < list.size(); i++) {
                String s = list.get(i);
                Logic.doSomething(s, i);
            }
        }

        {
            // 拡張for文で実現するパターン
            int i = 0;
            for (String s : list) {
                Logic.doSomething(s, i++);
            }
        }

        {
            // forEachとラムダ式を利用するパターン
            AtomicInteger i = new AtomicInteger();
            list.forEach(s -> Logic.doSomething(s, i.getAndIncrement()));
        }

        {
            // 匿名クラスを使って無理やり変数を閉じ込めたパターン
            list.forEach(new Consumer<String>() {
                private int index = 0;

                @Override
                public void accept(String s) {
                    Logic.doSomething(s, index++);
                }
            });
        }

        System.out.println("finish.");
    }
}
