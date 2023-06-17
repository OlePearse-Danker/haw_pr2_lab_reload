package statePattern;

import statePattern.apiStates.*;

public class APICallWithStateDesignPattern {

    private APICallContext context;
    private APICallState state;

    private String response;

    private APICallTarget apiCallTarget;

    public APICallWithStateDesignPattern() {
        System.out.println("APICall constructor.");

        this.context = new APICallContext();

        this.apiCallTarget = APICallTarget.TEST;
    }

    public void performCall() {
        this.context.setState(this.state);
        this.context.performCall();
    }

    // Mutator
    public void setTarget(APICallTarget target) {
        switch (target) {
            case TEST:
                this.state = new APICallTestState();
            case SMA:
                this.state = new APICallSMAState();
            case Fronius:
                this.state = new APICallFroniusState();
            case Huawei:
                this.state = new APICallHuaweiState();
            default:
                this.state = new APICallTestState();
        }
    }

    // Accessor
    public APICallTarget getTarget() {
        return this.apiCallTarget;
    }

}