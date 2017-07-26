package cn.taike.entity;


/**
 * Created by boxfish on 17/2/13.
 */
public class SentenceLabel {
    private Long sentenceId;
    private String sentence;
    private String theSentencePattern;

    public Long getSentenceId() {
        return sentenceId;
    }

    public void setSentenceId(Long sentenceId) {
        this.sentenceId = sentenceId;
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    public String getTheSentencePattern() {
        return theSentencePattern;
    }

    public void setTheSentencePattern(String theSentencePattern) {
        this.theSentencePattern = theSentencePattern;
    }
}
