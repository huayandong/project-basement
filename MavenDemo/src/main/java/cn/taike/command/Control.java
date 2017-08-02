package cn.taike.command;

/**
 * Created by huayandong on 17/8/2.
 */
public class Control {

    private Command commandOn;
    private Command commandOff;

    public Control(Command on, Command off) {
        this.commandOff = off;
        this.commandOn = on;
    }

    public void turnOn() {
        commandOn.execute();
    }

    public void turnOff() {
        commandOff.execute();
    }
}
