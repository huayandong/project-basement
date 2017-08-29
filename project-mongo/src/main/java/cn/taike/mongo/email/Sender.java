package cn.taike.mongo.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by huayandong on 17/8/29.
 */
@Component
public class Sender {

    private String to = "huayandong@boxfish.cn";

    @Autowired
    private SendEmailService sendEmailService;

    public void sendMessage() {
        EmailEntity beEmail = new EmailEntity();

        beEmail.setMsgTo(to);
        beEmail.setEmailSubject("跑课json异常");
        beEmail.setEmailContent("错了。。。\r\n换行");

        sendEmailService.submitSend(beEmail);
    }
}
