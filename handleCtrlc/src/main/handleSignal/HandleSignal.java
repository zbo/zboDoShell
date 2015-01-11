package handleSignal;

/**
 * Created by twer on 15-1-11.
 */
public class HandleSignal implements Runnable {
    private boolean stop;

    public HandleSignal() {
        Runtime.getRuntime().addShutdownHook(new ExitHandler());
    }

    public static void main(String[] args) throws InterruptedException {
        HandleSignal handle = new HandleSignal();
        Thread t = new Thread(handle);
        t.setName("Ctrl C Thread");
        t.run();
        t.join();
    }

    @Override
    public void run() {
        while (!stop) {
            try {
                Thread.sleep(1000);
                System.out.println("hello");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private class ExitHandler extends Thread {
        public ExitHandler() {
            super("Exit Handler");
        }

        public void run() {
            try {
                System.out.println("doing clean tasks");
                Thread.sleep(3000);
                System.out.println("clean tasks finished");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            finally {
                stop = true;
            }
        }
    }
}
