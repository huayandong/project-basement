package cn.taike.design.mode.command;

/**
 * Created by huayandong on 17/8/2.
 */
public class CommandOff implements Command {

    private Light light;

    public CommandOff(Light l) {
        this.light = l;
    }

    @Override
    public void execute() {
        light.turnOff();
    }
}
