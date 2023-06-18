package lab0.graphicState;

import lab0.Scene;

import java.awt.*;

public class PoopState extends State {
    private static PoopState instance = null;

    private Color backgroundColor;

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
        backgroundColor = new Color(107,142,35);
        this.context.setBackgroundColor(backgroundColor);
        return OutsideState.getInstance(context);
    }

    @Override
    public State drawInside() {
        context.setBackgroundColor(Color.DARK_GRAY);
        return InsideState.getInstance(context);
    }

    @Override
    public State drawOnlyPoop() {
        context.removeAllCats();
        context.togglePoopMode();
        return this;
    }

}
