package cn.taike.block;

/**
 * Created by huayandong on 17/8/9.
 */
public class CodeBlockFoo {

    static {
        System.out.println("父类的静态代码块。。。");
    }

    public CodeBlockFoo() {
        System.out.println("父类的无参构造函数。。。");
    }

    {
        System.out.println("父类的构造代码块。。。");
    }


    public void testBlock() {

        System.out.println("before....");

        {
            System.out.println("方法中的构造代码块。。。");
        }

        System.out.println("after....");
    }


    public static void main(String[] args) {
        CodeBlockFoo codeBlock = new CodeBlockFoo();
        System.out.println("----分割线----");
        codeBlock.testBlock();
    }
}
