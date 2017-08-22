package cn.taike.mongo.basement.context;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

/**
 * Created by huayandong on 17/8/14.
 */
@Data
@Validated
@Component
@ConfigurationProperties(prefix = "ti.paper")
public class BasementProperties {

    @NotNull
    private String recognitionUrl;
    @NotNull
    private String callbackUrl;
    @NotNull
    private String evaluationUrl;
    @NotNull
    private String evaluationUserName;
    @NotNull
    private String evaluationPassword;
}