package cn.taike.command.Sample;

/**
 * Created by huayandong on 17/8/3.
 */
//创建接受者：录音机
public class AudioPlayer {

    public void play() {
        System.out.println("播放...");
    }

    public void stop() {
        System.out.println("停止...");
    }

    public void rewind() {
        System.out.println("倒带...");
    }
}
