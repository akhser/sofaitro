package algorithm;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <Class description goes here>
 */
public class Multithreads {

    static AtomicInteger counter = new AtomicInteger();
    static AtomicInteger counterOfThread = new AtomicInteger();
    static Map<String, Integer> map = new ConcurrentHashMap<>();
    static Integer c = 0;

    public static void main(String[] args) throws InterruptedException {
        System.out.println(Runtime.getRuntime().availableProcessors());

        Thread t1 = new Thread() {
            public void run() {
                qq (Thread.currentThread().getName());
            }
        };
        t1.setName("first");

        Thread t2 = new Thread() {
            public void run() {
                qq (Thread.currentThread().getName());
            }
        };
        t2.setName("second");

        t1.start();
        t2.start();

        int cc = 5;
        while (cc > 0) {
            qq (Thread.currentThread().getName());
            cc --;
        }

        t1.join();
        t2.join();

        System.out.println("***** " + map.toString());
    }

    private static synchronized void qq (String name) {
        System.out.println("-------------------" + name + "---------------------");

        if (name.equals("second")) {
            try {
                Thread.sleep(5000);
//                Thread.currentThread().notify();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if (map.get(name) == null) {
            c = 0;
        } else {
            c = map.get(name);
        }

        for (int i = 0; i < 50000; i++ ) {
            c ++;
        }

        if (map.get(name) == null) {
            map.put(name, c);
        } else {
            map.replace(name, c);
        }

    }
}
