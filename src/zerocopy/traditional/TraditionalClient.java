package zerocopy.traditional;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.*;

/**
 * @author wangdanning
 * @version V1.0
 * @Package zerocopy.traditional
 * @date 2019/11/5 19:01
 */
class MyCall implements Callable<String> {

    @Override
    public String call() throws Exception {
        return "callable";
    }
}

class MyRun implements Runnable {

    @Override
    public void run() {
        System.out.println("aa");
    }
}

class MyThread extends Thread {

    public void run() {
        while (true) {
            System.out.println("aaa");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

public class TraditionalClient {

    public static void main(String[] args) {
//        new Thread(new FutureTask<String>(()-> "callable")).start();
        FutureTask<String> task = new FutureTask<>(new MyCall());
        Thread t = new Thread(task);
        t.start();
        try {
            task.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        new MyThread().start();

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new MyRun());
        executorService.submit(task);


        executorService.shutdown();
//        try {
//            Socket socket = new Socket("127.0.0.1",8080);
//
//            String messageFromStdIn;
//            Scanner scanner = new Scanner(System.in);
//
//            messageFromStdIn = scanner.next();
//
//            socket.getOutputStream().write(messageFromStdIn.getBytes());
//            socket.close();
//            scanner.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }
}
