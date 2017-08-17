package cn.taike.mongo.recognition.protocol;

import lombok.Data;

/**
 * Created by huayandong on 17/8/17.
 */
@Data
public class RecognitionDetail {

    private Long user_id;
    private String paper_id;
    private String page_id;
    private String paper_name;
    private String task_id;

    private String qas;
    private String sub_img_key;
    private String evaluation;
}
