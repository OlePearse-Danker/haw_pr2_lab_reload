package statePattern;

public class Main {
    public static void main(String args[]) {
        APICallWithStateDesignPattern apiCall = new APICallWithStateDesignPattern();

        apiCall.setTarget(APICallTarget.Fronius);
        apiCall.performCall();
    }
}
