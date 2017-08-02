package cn.taike.command;


/**
 * Created by huayandong on 17/8/2.
 */
public class SampleTest {

    public static void main(String[] args) {
        Light light = new Light();

        CommandOn on = new CommandOn(light);
        CommandOff off = new CommandOff(light);

        Control control = new Control(on, off);
        control.turnOn();
        control.turnOff();
    }
}
