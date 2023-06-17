package lab0.graphicState;

import lab0.Scene;

import java.awt.*;

public class InsideState extends State {
    private static InsideState instance = null;

    private InsideState(Scene context) {
        this.context = context;
    }

    public static InsideState getInstance(Scene context) {
        if (instance == null) {
            instance = new InsideState(context);
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
        return this;
    }
}
