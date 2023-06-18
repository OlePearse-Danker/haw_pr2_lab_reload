package lab0;

import java.awt.*;
import java.util.ArrayList;

public class Poop extends BoundingBox implements LocatedRectangle {

    private final ArrayList<PoopLayer> poopLayers;

    private int poopHeight;
    private int poopWidth;

    private Color poopColor;

    protected Scene context;
    private final double boundingBoxRatio = 8./10.;

    public Poop(int x, int y, int width, Scene context) {

        this.context = context;

        this.setWidth(width);
        this.calculateAndSetHeight();

        this.setCoordinates(new Point(x, y));

        this.poopColor = new Color(139,69,19);

        this.poopLayers = new ArrayList<>();

        final int layerCount = 4;

        for (int i = 0; i < layerCount; i++) {
            int totalHeight = getHeight();

            int layerHeight = (int) ((double) totalHeight / layerCount);
            int layerWidth = (int) (this.getWidth() / (double) i);

            int layerY = this.getCoordinates().y - (i * layerHeight);
            int layerX = this.getCoordinates().x + layerHeight/2;

            PoopLayer layer = new PoopLayer(new Point(layerX, layerY), new Dimension(layerWidth, layerHeight),this);
            this.poopLayers.add(layer);
        }

    }

    public void calculateAndSetHeight() {
        int height = (int) (this.getWidth() / this.boundingBoxRatio);
        this.setHeight(height);
    }

    public Color getColor() {
        return this.poopColor;
    }

    @Override
    public Point address() {
        return this.getCoordinates();
    }

    @Override
    public int width() {
        return this.getWidth();
    }

    @Override
    public int height() {
        return this.getHeight();
    }

    @Override
    public void draw() {
        System.out.println("Draw poop");
        for (PoopLayer layer : this.poopLayers) {
            layer.draw();
        }
    }
}
