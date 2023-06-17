package statePattern.apiStates;

import statePattern.APICallState;

public class APICallSMAState extends APICallState {

    @Override
    public void performCall() {
        System.out.println("Calling the SMA API.");
    }

}