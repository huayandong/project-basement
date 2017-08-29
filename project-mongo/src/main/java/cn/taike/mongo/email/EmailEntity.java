package cn.taike.mongo.email;

import lombok.Data;

/**
 * Created by huayandong on 17/8/29.
 */
@Data
public class EmailEntity {

    private String msgTo;
    private String emailSubject;
    private String emailContent;
}
