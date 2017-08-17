package cn.taike.mongo.recognition.handler;

import cn.taike.mongo.basement.exception.IllegalUserTokenException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.awt.geom.IllegalPathStateException;

/**
 * Created by huayandong on 17/8/17.
 */
@Slf4j
@Component
public class UserTokenHandler {

    public Long exchangeUserId(String token) throws IllegalUserTokenException {
        try {
            return new Long(token);

        } catch (IllegalPathStateException e) {   // 虚拟异常
            switch (e.getMessage()) {
                case "404":
                    log.warn("User token handler, token not found.");
                    throw new IllegalUserTokenException(e.toString());
                default:
                    log.error("User token handler, user token error.", e);
                    throw e;
            }

        } catch (Exception e) {
            log.error("User token handler, exchange token error.", e);
            throw e;
        }
    }
}
