package statePattern.apiStates;

import statePattern.APICallState;

public class APICallFroniusState extends APICallState {

    @Override
    public void performCall() {
        System.out.println("Calling the Fronius API.");
    }
}
