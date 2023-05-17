package lab0;

import java.awt.*;

public class Cat extends Animal {

    private Head head;
    private int headHeight;
    private int headWidth;


    private Upperbody upperbody;
    private int upperbodyHeight;
    private int upperbodyWidth;

    private Legs legs;
    private int legsHeight;
    private int legsWidth;


    public Cat(int x, int y, int width) {

        this.setWidth(width);
        double height = width * 5./7.;
        this.setHeight((int) height);
        this.setCoordinates(new Point(x, y));

        this.headWidth = (int) (width * 0.3);
        this.headHeight = this.headWidth;
        this.head = new Head(x, y + (int) (headHeight/3.), headWidth, headHeight);

        final int tailSpacingPlacerholder = (int) (this.getWidth() * 0.2);
        this.upperbodyWidth = this.getWidth() - headWidth/2 - tailSpacingPlacerholder;
        this.upperbodyHeight = (int) (height * 0.5);

        final int bodyOffsetY = (int) (this.head.getCoordinates().getY() + (this.head.getHeight() * 1./3.));
        this.upperbody = new Upperbody(x + headWidth/2, bodyOffsetY, upperbodyWidth, upperbodyHeight);

        this.legsWidth = (int) (this.getWidth() * 0.07);
        this.legsHeight = (int) (this.getHeight() * 0.22);

        final int legOffsetY = (int) (this.upperbody.getCoordinates().getY() + (this.upperbody.getHeight()));
        this.legs = new Legs(x + upperbodyWidth/2, legOffsetY, legsWidth, legsHeight);


    }

    public void draw() {

        // coordinates for the upper_body
        upperbody.draw();
        head.draw();
        legs.draw();

        // drawing the bounding box
        this.drawBoundingBox();
    }

}
