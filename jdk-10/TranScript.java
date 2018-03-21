import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TranScript {
    public static void main(String[] args) {
        new TranScript().execute();
    }

    public void execute() {
        getPid();
        getVersion();
        copyOfImmutableCollection();
        copyOfArrayList();
    }

    private void getPid() {
        long pid = ManagementFactory.getRuntimeMXBean().getPid();
        System.out.println(pid);
    }

    private void getVersion() {
        Runtime.Version version = Runtime.version();
        System.out.printf("%d.%d.%d.%d%n",
                version.feature(), version.interim(), version.update(), version.patch());
    }

    private void copyOfImmutableCollection() {
        var src = List.of("aaa", "bbb", "ccc");
        System.out.println(src);
        System.out.println(src.getClass());
        var dst = List.copyOf(src);
        System.out.println(dst);
        System.out.println(dst.getClass());
    }

    private void copyOfArrayList() {
        var src = new ArrayList<String>();
        Collections.addAll(src, "111", "222", "333");
        System.out.println(src);
        System.out.println(src.getClass());     // ArrayList
        var dst = List.copyOf(src);
        System.out.println(dst);
        System.out.println(dst.getClass());     // ImmutableCollenctions$ListN
    }
}

