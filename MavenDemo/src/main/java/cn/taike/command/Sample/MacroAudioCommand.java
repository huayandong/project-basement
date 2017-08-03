package cn.taike.command.Sample;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by huayandong on 17/8/3.
 */
//负责将个别的命令合成宏命令
public class MacroAudioCommand implements MacroCommand {

    private List<AudioCommand> commandList = new ArrayList<AudioCommand>();

    @Override
    public void add(AudioCommand command) {
        commandList.add(command);
    }

    @Override
    public void remove(AudioCommand command) {
        commandList.remove(command);
    }

    @Override
    public void execute() {
        commandList.forEach(AudioCommand::execute);
    }
}
