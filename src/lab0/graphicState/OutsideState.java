package lab0.graphicState;

import lab0.Scene;

import java.awt.*;

public class OutsideState extends State {
    private static OutsideState instance = null;
    private Scene context;

    private Color backgroundColor;

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
        backgroundColor = new Color(107,142,35);
        this.context.setBackgroundColor(backgroundColor);
        return this;
    }

    @Override
    public State drawInside() {
        this.context.setBackgroundColor(Color.DARK_GRAY);
        return InsideState.getInstance(context);
    }

    @Override
    public State drawOnlyPoop() {
        context.removeAllCats();
        context.togglePoopMode();
        return PoopState.getInstance(context);
    }

}
