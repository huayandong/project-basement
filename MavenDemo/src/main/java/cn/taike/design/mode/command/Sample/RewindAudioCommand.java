package cn.taike.design.mode.command.Sample;

/**
 * Created by huayandong on 17/8/3.
 */
public class RewindAudioCommand implements AudioCommand {

    private AudioPlayer audioPlayer;

    public RewindAudioCommand(AudioPlayer audioPlayer) {
        this.audioPlayer = audioPlayer;
    }

    @Override
    public void execute() {
        audioPlayer.rewind();
    }
}
