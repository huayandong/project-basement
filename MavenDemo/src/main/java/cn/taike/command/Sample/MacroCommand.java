package cn.taike.command.Sample;

/**
 * Created by huayandong on 17/8/3.
 */
//定义代表宏命令的接口
public interface MacroCommand extends AudioCommand {

    //宏命令聚集管理方法：可增加成员命令
     void add(AudioCommand command);

    //宏命令聚集管理方法：可删除成员命令
     void remove(AudioCommand command);
}
