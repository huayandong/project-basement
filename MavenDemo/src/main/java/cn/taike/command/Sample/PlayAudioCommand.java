package cn.taike.command.Sample;

/**
 * Created by huayandong on 17/8/3.
 */
public class PlayAudioCommand implements AudioCommand {

    private AudioPlayer audioPlayer;

    public PlayAudioCommand(AudioPlayer audioPlayer) {
        this.audioPlayer = audioPlayer;
    }

    //执行方法
    @Override
    public void execute() {
        audioPlayer.play();
    }
}
