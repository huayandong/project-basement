package cn.taike.bean;

/**
 * Created by huayandong on 17/8/25.
 */
public class UseFunctionService {

    private FunctionService functionService;

    public void setFunctionService(FunctionService functionService) {
        this.functionService = functionService;
    }

    public String testFunction(String world) {
        return functionService.printMessage(world);
    }
}
