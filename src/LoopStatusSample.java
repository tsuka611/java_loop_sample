import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class LoopStatusSample {

    public static class Status<T> {
        private T current;
        private int index;
        private boolean isLast;

        private Status() {
        }

        private Status update(T current, int index, boolean isLast) {
            this.current = current;
            this.index = index;
            this.isLast = isLast;
            return this;
        }

        public T getCurrent() {
            return current;
        }

        public int getIndex() {
            return index;
        }

        public int getCount() {
            return index + 1;
        }

        public boolean isFirst() {
            return index == 0;
        }

        public boolean isLast() {
            return isLast;
        }
    }

    public static <T> void forEach(Iterable<T> itr, Consumer<Status<T>> action) {
        Status sts = new Status();
        int index = 0;
        Iterator<T> it = itr.iterator();
        while (it.hasNext()) {
            action.accept(sts.update(it.next(), index++, !it.hasNext()));
        }
    }

    public static void main(String... args) {
        List<String> list = Arrays.asList("AAA", "BBB", "CCC");

        // ステータスを利用したパターン
        forEach(list, v -> {
                    if (v.isFirst()) {
                        Logic.doFirst(v.getCurrent());
                    } else if (v.isLast()) {
                        Logic.doLast(v.getCurrent());
                    } else {
                        Logic.doOther(v.getCurrent());
                    }
                }
        );
    }
}