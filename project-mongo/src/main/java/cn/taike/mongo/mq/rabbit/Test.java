package cn.taike.mongo.mq.rabbit;

/**
 * Created by huayandong on 17/8/18.
 */
public class Test {

    public static void main(String[] args) throws Exception {
        Receiver receiver = new Receiver("testQueue");
        Thread thread = new Thread(receiver);
        thread.start();

        Sender send = new Sender("testQueue");
        for (int i = 0; i < 5; i++) {
            MessageInfo info = new MessageInfo();
            info.setChannel("Test");
            info.setContent("message:" + thread.getId());
            send.sendMessage(info);
        }
    }
}
