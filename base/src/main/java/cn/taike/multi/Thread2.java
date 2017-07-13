package cn.taike.multi;


/**
 * Created by huayandong on 17/6/12.
 */
public class Thread2 implements Runnable {

    private String name;

//    public Thread2(String name) {
//        this.name = name;
//    }


    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {

            System.out.println(Thread.currentThread().getName() + "运行第:" + i + "个");
            try {
                Thread.sleep(200);
                Thread.yield();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Thread2 thread2 = new Thread2();
        Thread a = new Thread(thread2, "A");
        a.setPriority(Thread.MIN_PRIORITY);
        a.start();

        Thread b = new Thread(thread2, "B");
        b.setPriority(Thread.MAX_PRIORITY);
        b.start();

        Thread c = new Thread(thread2, "C");
        c.setPriority(Thread.MIN_PRIORITY);
        c.start();
        try {
            c.wait();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
