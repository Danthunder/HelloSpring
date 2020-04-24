package zerocopy.traditional;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wangdanning
 * @version V1.0
 * @Package zerocopy.traditional
 * @date 2019/11/5 19:01
 */
public class TraditionalServer {
    public static void main(String args[]) throws InterruptedException {
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        List<SocketChannel> list = new ArrayList<>();
        try {

            // 非阻塞Socket
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress(8080));
            // 设置未非阻塞
            serverSocketChannel.configureBlocking(false);
            System.out.println("服务器已启动并监听8080端口");

            while (true) {
                System.out.println();
                System.out.println("服务器正在等待连接...");
                SocketChannel socketChannel = serverSocketChannel.accept();

                if (socketChannel == null) {
                    // 没有连接
                    System.out.println("正在等待客户端请求连接...");
                    Thread.sleep(5000);
                } else {
                    // 将连接存储在一个list集合中
                    list.add(socketChannel);
                    System.out.println("当前接收到客户端请求连接...");
                }

                // 每次等待客户端消息时都去轮询，看看消息是否准备好，如果准备好则直接打印消息。
                // 解决BIO在单线程模式下无法处理多客户端请求的问题
                // 解决了非阻塞状态下连接丢失的问题。
                for (SocketChannel socketChannelInList : list) {
                    socketChannelInList.configureBlocking(false);
                    int effective = socketChannelInList.read(byteBuffer);
                    if (effective != 0) {
                        byteBuffer.flip(); // 切换模式  写-->读
                        String content = Charset.forName("utf-8").decode(byteBuffer).toString();
                        System.out.println("接收到消息：" + content);
                        byteBuffer.clear();
                    } else {
                        System.out.println("当前未收到客户端消息");
                    }
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
