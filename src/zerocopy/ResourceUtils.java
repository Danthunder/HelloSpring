package zerocopy;

import java.io.Closeable;
import java.io.IOException;
//import java.util.Optional;
//import java.util.function.Consumer;

/**
 * @author wangdanning
 * @version V1.0
 * @Package PACKAGE_NAME
 * @date 2019/11/5 19:02
 */
public class ResourceUtils {
//    public static void close(Closeable res) {
//        Optional.ofNullable(res).ifPresent(new Consumer<Closeable>() {
//            @Override
//            public void accept(Closeable closeable) {
//                try {
//                    closeable.close();
//                } catch (IOException e) {
//                    System.out.println("close resource failed " + e.getMessage());
//                }
//            }
//        });
//    }

    public static void main(String[] args) {
        System.out.println(Integer.parseInt("01000111011001111101101001001110", 2) & 15);
        System.out.println(Integer.parseInt("11110111010000110000000110111000", 2) & 15);
        System.out.println(Integer.parseInt("01110111011010010100011000111110", 2) & 15);
        System.out.println(Integer.parseInt("10000011000000001100100000011010", 2) & 15);

        System.out.println((Integer.parseInt("01000111011001111101101001001110", 2) >>> 28) & 15);
        System.out.println((Integer.parseInt("11110111010000110000000110111000", 2) >>> 28) & 15);
        System.out.println((Integer.parseInt("01110111011010010100011000111110", 2) >>> 28) & 15);
        System.out.println((Integer.parseInt("10000011000000001100100000011010", 2) >>> 28) & 15);
    }
}
