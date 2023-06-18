package lab0.graphicState;

import lab0.Scene;

import java.awt.*;

public class PoopState extends State {
    private static PoopState instance = null;

    private PoopState(Scene context) {
        this.context = context;
    }

    public static PoopState getInstance(Scene context) {
        if (instance == null) {
            instance = new PoopState(context);
        }

        return instance;
    }

    @Override
    public State drawOutside() {
        context.setBackgroundColor(Color.GREEN);
        return OutsideState.getInstance(context);
    }

    @Override
    public State drawInside() {
        context.setBackgroundColor(Color.DARK_GRAY);
        return InsideState.getInstance(context);
    }

    @Override
    public State drawPoop() {
        context.togglePoopMode();
        return this;
    }
}
