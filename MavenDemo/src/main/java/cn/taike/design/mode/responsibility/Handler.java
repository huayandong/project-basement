package cn.taike.design.mode.responsibility;

/**
 * Created by huayandong on 17/8/7.
 */
//责任链模式：抽象处理类
abstract class Handler {

    private Handler nextHandler;

    public Handler getNextHandler() {
        return nextHandler;
    }

    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public abstract void doHandler();
}

class concreteHandler extends Handler {

    @Override
    public void doHandler() {

        if(getNextHandler() != null){
            System.out.println("还有责任链");
            getNextHandler().doHandler();
        } else {
            System.out.println("自己处理");
        }
    }
}
