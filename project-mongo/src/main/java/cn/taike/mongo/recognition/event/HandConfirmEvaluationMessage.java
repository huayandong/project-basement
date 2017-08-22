package cn.taike.mongo.recognition.event;

import lombok.Data;

/**
 * Created by huayandong on 17/8/22.
 */
@Data
public class HandConfirmEvaluationMessage extends MessageEvent {

    private Long userId;
    private String paperId;
    private String pageId;
    private String confirmId;

    public HandConfirmEvaluationMessage(Long userId, String paperId, String pageId, String confirmId) {
        super(confirmId);
        this.userId = userId;
        this.paperId = paperId;
        this.pageId = pageId;
        this.confirmId = confirmId;
    }

}
