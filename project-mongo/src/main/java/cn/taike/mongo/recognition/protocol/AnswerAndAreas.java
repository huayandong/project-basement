package cn.taike.mongo.recognition.protocol;

import com.google.common.collect.Lists;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by huayandong on 17/9/13.
 */

/**
 * PaperInfoEntity answerAndAreas 属性反序列化后的对象
 */
@Data
public class AnswerAndAreas {

    // 答题区域
    private Map<String, Map<String, Integer>> answer_area = new HashMap<>();

    // 答案
    private List<Answer> answer = new ArrayList<>();

    @Data
    public static class Answer {

        private String question_id;
        private Integer type;
        private List<List<String>> answers = new ArrayList<>();
        private List<String> locations = new ArrayList<>();
    }

    public void build() {

        Map<String, Map<String, Integer>> answerArea = new HashMap<>();
        List<Answer> list = new ArrayList<>();


        Map<String, Integer> areas = new HashMap<>();
        areas.put("x", 1);
        areas.put("y", 1);
        areas.put("w", 1);
        areas.put("h", 1);
        answerArea.put("1", areas);

        Answer answer = new Answer();
        answer.setQuestion_id("");
        answer.setType(0);
        List<String> answerList = Lists.newArrayList("What is your name?");
        ArrayList<List<String>> lists = Lists.newArrayList();
        lists.add(answerList);
        answer.setAnswers(lists);
        ArrayList<String> location = Lists.newArrayList("1");
        answer.setLocations(location);
        list.add(answer);
    }
}
