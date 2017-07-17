package cn.taike.multi;

/**
 * Created by huayandong on 17/6/12.
 */
public class Thread1 extends Thread {

    private String name;

    public Thread1(String name) {
        this.name = name;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(name + "运行第：" + i + "次");
            try {
                sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        Thread1 thread1 = new Thread1("线程1");
        Thread1 thread2 = new Thread1("线程2");
        thread1.start();
        thread2.start();
    }
}
