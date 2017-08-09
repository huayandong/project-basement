package cn.taike.design.mode.command;

/**
 * Created by huayandong on 17/8/2.
 */
public class CommandOn implements Command {

    private Light light;

    public CommandOn(Light l) {
        this.light = l;
    }

    @Override
    public void execute() {
        light.turnOn();
    }
}
