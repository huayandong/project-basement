package cn.taike.command.Sample;

/**
 * Created by huayandong on 17/8/3.
 */
//请求者角色：键盘
public class KeyPad {

    private AudioCommand playCommand;
    private AudioCommand rewindCommand;
    private AudioCommand stopCommand;

    public void setPlayCommand(AudioCommand playCommand) {
        this.playCommand = playCommand;
    }

    public void setRewindCommand(AudioCommand rewindCommand) {
        this.rewindCommand = rewindCommand;
    }

    public void setStopCommand(AudioCommand stopCommand) {
        this.stopCommand = stopCommand;
    }

    public void play() {
        playCommand.execute();
    }

    public void rewind() {
        rewindCommand.execute();
    }

    public void stop() {
        stopCommand.execute();
    }
}
