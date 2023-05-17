package lab0;

import java.awt.*;

public abstract class BoundingBox {

    private int width;
    private int height;

    private Point coordinates;

    protected void setWidth(int width) {
        this.width = width;
    }

    protected void setHeight(int height) {
        this.height = height;
    }

    protected int getWidth() {
        return width;
    }

    protected int getHeight() {
        return height;
    }

    protected void setCoordinates(Point coordinates) {
        this.coordinates = coordinates;
    }

    protected Point getCoordinates() {
        return this.coordinates;
    }

    public void drawBoundingBox() {
        int posX = (int) this.getCoordinates().getX();
        int posY = (int) this.getCoordinates().getY();
        int width = this.getWidth();
        int height = this.getHeight();

        Drawing.pen().setColor(Color.RED);

        Drawing.pen().drawRect(posX, posY, width, height);

        // Draw a cross at the center of the bounding box
        Drawing.pen().drawLine(posX + width / 2, posY, posX + width / 2, posY + height);
        Drawing.pen().drawLine(posX, posY + height / 2, posX + width, posY + height / 2);

        // Draw a cross at the base coordiantes
        Drawing.pen().setColor(Color.BLUE);
        Drawing.pen().drawLine(posX, posY, posX + width, posY + height);
        Drawing.pen().drawLine(posX + width, posY, posX, posY + height);

        int dotSize = 10;
        Drawing.pen().fillOval(posX - dotSize/2, posY - dotSize/2, dotSize, dotSize);

    }

}