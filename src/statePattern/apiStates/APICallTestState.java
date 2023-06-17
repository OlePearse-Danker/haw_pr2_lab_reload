package statePattern.apiStates;

import statePattern.APICallState;

public class APICallTestState extends APICallState {

    @Override
    public void performCall() {
        System.out.println("Calling the Test API.");
    }
}
