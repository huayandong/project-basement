package cn.taike.enummeration;

import static cn.taike.enummeration.Main.Weeks.FRI;

/**
 * Created by huayandong on 17/7/10.
 */
public class Main {

    public static void main(String[] args) {
        Number number = ModelType.ABCWord.getNumber();
        System.out.println(number.intValue());

        Integer age = EnumType.Sikong.getAge();
        String name = EnumType.Sikong.getName();
        System.out.println("sikong:" + name + ",age:" + age);

        Weeks[] values = Weeks.values();
        for (Weeks value : values) {
            System.out.println(value);
        }

        Weeks mon = Weeks.MON;
        System.out.println("this is MON?:" + mon);

        System.out.println("FRI:" + FRI);

    }


    public enum Weeks {
        MON, TUE, WED, THU, FRI, SAT, SUN;
    }

    public enum EnumType {


        Manager("simayi", 23),
        Sikong("Caocao", 56);


        private String name = null;
        private Integer age = null;

        private EnumType(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public Integer getAge() {
            return age;
        }

        public String getName() {
            return name;
        }

    }
}
