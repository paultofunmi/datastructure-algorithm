package concurrency;

//public class MultiThreading implements Runnable {
public class MultiThreading extends Thread {

    private int threadNumber;

    MultiThreading(int threadNumber) {

        this.threadNumber = threadNumber;
    }

    @Override
    public void run() {

        for(int i = 0; i < 5; i++) {

            System.out.println( i + " from thread " + threadNumber);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
//                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

        for(int i = 0; i < 3; i ++) {

//            When a class extends Thread
            MultiThreading threading = new MultiThreading(i);
            threading.start();

//          When class extends Runnable
//            MultiThreading threading = new MultiThreading(i);
//            Thread thread = new Thread(threading);
//            thread.start();
        }
    }
}
