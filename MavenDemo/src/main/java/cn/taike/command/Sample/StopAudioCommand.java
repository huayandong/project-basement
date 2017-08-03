package cn.taike.command.Sample;

/**
 * Created by huayandong on 17/8/3.
 */
public class StopAudioCommand implements AudioCommand {

    private AudioPlayer audioPlayer;

    public StopAudioCommand(AudioPlayer audioPlayer) {
        this.audioPlayer = audioPlayer;
    }

    @Override
    public void execute() {
        audioPlayer.stop();
    }
}
