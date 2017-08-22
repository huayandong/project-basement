package cn.taike.mongo.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by huayandong on 17/8/22.
 */
@RestController
public class EventController {
    @Autowired
    private SendMessageService sendMessageService;

    @RequestMapping(value = "/event/test", method = RequestMethod.POST)
    public Object eventController() {

        return sendMessageService.sendMessageService();

    }

}
