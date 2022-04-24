package javaheap;

public class JavaHeapMain {
    public static void main(String[] args) {
        var n = 10000;
        var objects = new SampleObjectBuilder().create(n);
        System.out.printf("Program running. %d objects created on heap. Press CTRL-C to terminate.\n", objects.size());
        new Waiter().start();
    }
}

class Waiter extends Thread {
    public void run() {
        while (true);
    }
}
