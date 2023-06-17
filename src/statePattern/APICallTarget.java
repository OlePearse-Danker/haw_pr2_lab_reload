package statePattern;

public enum APICallTarget {
    TEST,
    SMA,
    Fronius,
    Huawei;

    public String getAPIURL() {
        switch(this) {
            case TEST:
                return "https://api.test.com";
            case SMA:
                return "https://api.sma.com";
            case Fronius:
                return "https://api.dev.fronius.com";
            case Huawei:
                return "https://api.huawei.com";
            default:
                return "https://api.test.com";
        }
    }
}
