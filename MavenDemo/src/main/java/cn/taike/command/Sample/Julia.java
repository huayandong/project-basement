package cn.taike.command.Sample;

/**
 * Created by huayandong on 17/8/3.
 */
//客户端角色：Julia
public class Julia {

    public static void main(String[] args) {

        //创建接受对象
        AudioPlayer audio = new AudioPlayer();

        //创建命令
        AudioCommand playCommand = new PlayAudioCommand(audio);
        AudioCommand rewindCommand = new RewindAudioCommand(audio);
        AudioCommand stopCommand = new StopAudioCommand(audio);

        //创建请求对象
//        KeyPad keyPad = new KeyPad();
//        keyPad.setPlayCommand(playCommand);
//        keyPad.setRewindCommand(rewindCommand);
//        keyPad.setStopCommand(stopCommand);
//
//        //执行
//        keyPad.play();
//        keyPad.rewind();
//        keyPad.stop();

        //创建宏命令类：
        MacroAudioCommand macroAudioCommand = new MacroAudioCommand();
        macroAudioCommand.add(playCommand);
        macroAudioCommand.add(rewindCommand);
        macroAudioCommand.add(stopCommand);
        macroAudioCommand.remove(rewindCommand);

        //执行宏命令：
        macroAudioCommand.execute();
    }
}
