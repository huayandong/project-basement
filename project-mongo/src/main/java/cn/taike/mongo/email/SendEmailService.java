package cn.taike.mongo.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * Created by huayandong on 17/8/29.
 */
@Service
public class SendEmailService {

    /**
     * 使用 JavaMailSender 需要在配置文件中配置:
     * <p>
     * #邮箱配置
     * spring.mail.host: ** mail host
     * spring.mail.port: 25
     * spring.mail.username: ** username
     * spring.mail.password: ** password
     * </p>
     */
    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String sendFrom;

    public void submitSend(EmailEntity email) {
        sendMail(email);
        System.out.println("发送成功~");
    }

    private void sendMail(EmailEntity mail) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(sendFrom);
        mailMessage.setTo(mail.getMsgTo());
        mailMessage.setSubject(mail.getEmailSubject());
        mailMessage.setText(mail.getEmailContent());

        javaMailSender.send(mailMessage);
    }

}
