package cn.taike.enummeration;

/**
 * Created by huayandong on 17/7/10.
 */
public enum ModelType {

    CourseContent(0), ABCWord(100);


    private Number number = 0;

    ModelType(Number number) {
        this.number = number;
    }

    public Number getNumber() {
        return number;
    }
}
