package cn.taike.mongo.recognition.event;

import cn.taike.mongo.recognition.handler.CompositionEvaluationHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;

import javax.inject.Named;

/**
 * Created by huayandong on 17/8/22.
 */
@Named
public class HandEventListener implements ApplicationListener<MessageEvent> {

    @Autowired
    private CompositionEvaluationHandler compositionEvaluationHandler;

    @Override
    public void onApplicationEvent(MessageEvent event) {
        if (event instanceof HandConfirmEvaluationMessage) {
            doEvent((HandConfirmEvaluationMessage) event);
        }
    }

    private void doEvent(HandConfirmEvaluationMessage confirmEvent) {

        compositionEvaluationHandler.confirmEvaluation(
                confirmEvent.getUserId(),
                confirmEvent.getPaperId(),
                confirmEvent.getPageId(),
                confirmEvent.getConfirmId()
        );

    }
}
