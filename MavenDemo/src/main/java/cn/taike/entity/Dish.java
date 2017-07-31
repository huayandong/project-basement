package cn.taike.entity;

/**
 * Created by huayandong on 17/7/30.
 */
public class Dish {

    private Integer id;

    private String name;

    private String type;

    private Integer calories;

    private boolean isVagetable;

    public boolean isVagetable() {
        return isVagetable;
    }

    public void setVagetable(boolean vagetable) {
        isVagetable = vagetable;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    public Dish() {
    }

    public Dish(Integer id, String name, String type, Integer calories, boolean isVagetable) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.calories = calories;
        this.isVagetable = isVagetable;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", calories=" + calories +
                ", isVagetable=" + isVagetable +
                '}';
    }
}
