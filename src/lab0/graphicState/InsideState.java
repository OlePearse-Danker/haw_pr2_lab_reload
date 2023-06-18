	package lab0.graphicState;

import lab0.Scene;

import java.awt.*;

public class InsideState extends State {
    private static InsideState instance = null;

    private Color backgroundColor;

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
        backgroundColor = new Color(107,142,35);
        this.context.setBackgroundColor(backgroundColor);
        return OutsideState.getInstance(context);
    }

    @Override
    public State drawInside() {
        context.setBackgroundColor(Color.DARK_GRAY);
        return this;
    }

    @Override
    public State drawOnlyPoop() {
        context.removeAllCats();
        context.togglePoopMode();
        return PoopState.getInstance(context);
    }

}
