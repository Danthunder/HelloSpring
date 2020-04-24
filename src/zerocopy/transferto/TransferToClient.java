package zerocopy.transferto;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;

import zerocopy.Constants;

/**
 * @author wangdanning
 * @version V1.0
 * @Package zerocopy.transferto
 * @date 2019/11/5 18:59
 */
public class TransferToClient {
    public static void main(String[] args) throws IOException {
        TransferToClient sfc = new TransferToClient();
        sfc.testSendFile1();
    }

    public void testSendFile1() throws IOException {
        DataOutputStream output = null;
        FileInputStream inputStream = null;
        String filePath = "H://T_MD_ITEM_ZJ.dat";
        inputStream = new FileInputStream(filePath);
        output = new DataOutputStream(new FileOutputStream("H://toFile1.dat"));

        long start = System.currentTimeMillis();
        byte[] b = new byte[Constants.WRITE_BUFFER_SIZE];
        long read = 0, total = 0;
        while ((read = inputStream.read(b)) >= 0) {
            total = total + read;
            output.write(b);
        }
        output.flush();
        System.out.println("bytes send--" + total + " and totaltime--" + (System.currentTimeMillis() - start));
    }

    public void testSendFile() throws IOException {
        SocketAddress sad = new InetSocketAddress(Constants.SERVER_ADDRESS,Constants.SERVER_PORT);
        SocketChannel sc = SocketChannel.open();
        sc.connect(sad);
        sc.configureBlocking(true);

        String filePath = "H://T_MD_ITEM_ZJ.dat";
        RandomAccessFile fromFile = new RandomAccessFile(filePath, "rw");
        FileChannel fromChannel = fromFile.getChannel();
        System.out.println(fromChannel.size());
        long sendSize = 4096L;
        RandomAccessFile toFile = new RandomAccessFile("H://toFile.dat", "rw");
        FileChannel toChannel = toFile.getChannel();


        long start = System.currentTimeMillis();
        long nsend = 0, curnset = 0;
        curnset = fromChannel.transferTo(0,fromChannel.size(), toChannel);
        System.out.println("total bytes transferred--"+ curnset +" and time taken in MS--"+(System.currentTimeMillis() - start));
    }
}
