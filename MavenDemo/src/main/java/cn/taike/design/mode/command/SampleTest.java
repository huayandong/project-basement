package cn.taike.design.mode.command;


/**
 * Created by huayandong on 17/8/2.
 */
public class SampleTest {

    public static void main(String[] args) {

        //创建接受者
        Light light = new Light();

        //创建命令对象，设定命令的接受者
        Command on = new CommandOn(light);
        Command off = new CommandOff(light);

        //创建请求者，设置命令对象
        Control control = new Control(on, off);
        
        //执行方法
        control.turnOn();
        control.turnOff();
    }
}
