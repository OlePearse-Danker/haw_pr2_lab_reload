package statePattern;

public class APICallWithoutStateDesignPattern {

    private String response;

    private APICallTarget apiCallTarget;

    public APICallWithoutStateDesignPattern() {
        System.out.println("APICall constructor.");

        this.apiCallTarget = APICallTarget.TEST;
    }

    public void performCall() {

        switch (this.apiCallTarget) {
            case TEST:
                this.response = "Success";

            case SMA:
                // Call the SMA API
                this.response = "SMA call successful";
            case Fronius:
                // Call the Fronius API
                this.response = "Fronius call successful";

            case Huawei:
                this.response = "Huawei call successful";

                // default if unsuccessful
            default:
                this.response = "APICall unsuccessful";
        }

        if (this.apiCallTarget == APICallTarget.TEST) {
            this.response = "Success.";
        } else if (this.apiCallTarget == APICallTarget.SMA) {
            // Call the SMA API
            this.response = "SMA call successful.";
        } else if (this.apiCallTarget == APICallTarget.Fronius) {
            // Call the Fronius API
            this.response = "Fronius call failed.";
        } else if (this.apiCallTarget == APICallTarget.Huawei) {
            // Call the Huawei APi
            this.response = "Huawei call successful.";
        }
    }

    // Mutator
    public void setState(APICallTarget target) {
        this.apiCallTarget = target;
    }

    // Accessor
    public APICallTarget getState() {
        return this.apiCallTarget;
    }

}
