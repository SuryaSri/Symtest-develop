package functions;

import expression.FunctionCallExpression;
import see.SEE;

public class FunctionHandler {

    private SEE mSEE;
    private FunctionCallExpression call_exp;

    public FunctionHandler(SEE see, FunctionCallExpression exp) {
        this.mSEE = see;
        this.call_exp = exp;
    }

    public void makeFunctionCall() throws Exception{
        Function functionobj = this.mSEE.getFunctionObject(this.call_exp);
        //System.out.println("function call - " + this.call_exp.toString());
    }
}