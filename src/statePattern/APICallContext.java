package statePattern;

public class APICallContext extends APICallState {

    private APICallState apiCallState;

    public APICallContext() {
        super();
    }

    // Mutator
    public void setState(APICallState state) {
        this.apiCallState = state;
    }

    // Accessor
    public APICallState getState() {
        return this.apiCallState;
    }

    @Override
    public void performCall() {
        this.apiCallState.performCall();
    }
}
