package singletonExample;

public class Main {

    public static void main(String[] args) {
        EventLoop eventLoop = EventLoop.getInstance();
        eventLoop.start();
    }

}
