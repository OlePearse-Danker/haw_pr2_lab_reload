package lab0.graphicState;

import lab0.Scene;

import java.awt.*;

public class OutsideState extends State {
    private static OutsideState instance = null;

    private OutsideState(Scene context) {
        this.context = context;
    }

    public static OutsideState getInstance(Scene context) {
        if (instance == null) {
            instance = new OutsideState(context);
        }

        return instance;
    }

    @Override
    public State drawOutside() {
        context.setBackgroundColor(Color.GREEN);
        return this;
    }

    @Override
    public State drawInside() {
        context.setBackgroundColor(Color.DARK_GRAY);
        return InsideState.getInstance(context);
    }
}
