package cn.boxfish.enummeration;

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
