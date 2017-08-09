package cn.taike.design.mode.command;

/**
 * Created by huayandong on 17/8/2.
 */
//命令的接受者
public class Light {

    public void turnOn() {
        System.out.println("Light is turn ON");
    }

    public void turnOff() {
        System.out.println("Light is turn OFF");
    }
}
