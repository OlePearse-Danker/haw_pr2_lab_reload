package lab0.graphicState;

import lab0.Scene;

public abstract class State {

    protected Scene context;

    protected static OutsideState outside;
    protected static InsideState inside;
    protected static PoopState poop;

    public abstract State drawOutside();
    public abstract State drawInside();
    public abstract State drawOnlyPoop();

}
