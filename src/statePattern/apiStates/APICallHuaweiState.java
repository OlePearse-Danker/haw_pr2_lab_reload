package statePattern.apiStates;

import statePattern.APICallState;

public class APICallHuaweiState extends APICallState {

    @Override
    public void performCall() {
        System.out.println("Calling the Huawei API.");
    }
}
