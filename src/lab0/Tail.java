package lab0;

import java.awt.*;

public class Tail extends BoundingBox {

    private Color bgColor;
    private Color tailColor2;

    public Tail(int x, int y, int width, int height) {
        this.bgColor = new Color(238,238,238);
        this.tailColor2 = Color.BLACK;

        this.setWidth(2 * width);
        this.setHeight(height);
        int tailX = (int) (x - (0.5 * this.getWidth()));
        this.setCoordinates(new Point(tailX, y));
    }

    public void draw() {

        // coordinates for the upper_body
        int x = (int) this.getCoordinates().getX();
        int y = (int) this.getCoordinates().getY();
        int width = this.getWidth();
        int height = this.getHeight();


        Drawing.pen().setColor(tailColor2);
        Drawing.pen().fillArc(x, y, width, height, 0, 90);
        Drawing.pen().setColor(bgColor);
        Drawing.pen().fillArc(x, (int) (y + 0.1 * height), width, height, 0, 90);


        // drawing the bounding box
        this.drawBoundingBox();
    }

    public void setTailColor(Color color) {
        this.tailColor2 = color;
    }

    public Color getTailColor() {
        return this.tailColor2;
    }

    public void setBgColor(Color color) {
        this.bgColor = color;
    }

    public Color getBgColor() {
        return this.bgColor;
    }
}


