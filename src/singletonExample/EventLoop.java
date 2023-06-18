package singletonExample;

public class EventLoop {

    private static EventLoop instance = null;

    private EventLoop() {

    }

    public static EventLoop getInstance() {
        if (instance == null) {
            instance = new EventLoop();
        }

        return instance;
    }

    public void start() {
        while (true) {
            System.out.println("Working.");

            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                System.err.println(e);
            }
        }
    }

}
