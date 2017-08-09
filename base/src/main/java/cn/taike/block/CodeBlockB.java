package cn.taike.block;

/**
 * Created by huayandong on 17/8/9.
 */
public class CodeBlockB extends CodeBlockFoo {

    static {
        System.out.println("子类中的静态代码块---");
    }

    {
        System.out.println("子类中的构造代码块---");
    }

    CodeBlockB() {
        System.out.println("子类中的无参构造函数---");
    }

    public static void main(String[] args) {
        CodeBlockB codeBlockB = new CodeBlockB();
    }
}
