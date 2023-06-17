package lab0;

import java.awt.*;

public class Cat extends Animal implements LocatedRectangle{

    private Head head;
    private int headHeight;
    private int headWidth;

    private Upperbody upperbody;
    private int upperbodyHeight;
    private int upperbodyWidth;

    private Leg Rightleg;

    private int legsHeight;
    private int legsWidth;

    private Leg Leftleg;

    private Color primaryColor;

    protected Scene context;

    private final double boundingBoxRatio = 5./9.;

    public Cat(int x, int y, int width, Scene context) {
        this.context = context;

        this.setWidth(width);
        this.calculateAndSetHeight();

        this.setCoordinates(new Point(x, y));

        this.primaryColor = Color.BLACK;

        this.headWidth = (int) (width * 0.3);
        this.headHeight = this.headWidth;
        this.head = new Head(x, y + (int) (headHeight/3.), headWidth, headHeight);

        final int tailSpacingPlacerholder = (int) (this.getWidth() * 0.3);
        this.upperbodyWidth = this.getWidth() - headWidth/2 - tailSpacingPlacerholder;
        this.upperbodyHeight = (int) (this.getHeight() * 0.5);

        final int bodyOffsetY = (int) (this.head.getCoordinates().getY() + (this.head.getHeight() * 1./3.));
        this.upperbody = new Upperbody(x + headWidth/2, bodyOffsetY, upperbodyWidth, upperbodyHeight, tailSpacingPlacerholder, this);
        this.upperbody.setPrimaryColor(this.primaryColor);

        this.legsWidth = (int) (this.getWidth() * 0.07);
        this.legsHeight = (int) (this.getHeight() * 0.22);
        int legStartY = this.upperbody.getCoordinates().y + (int ) (this.upperbody.getHeight() * 0.9);
        int legHeightTillBoundBox = this.getCoordinates().y + this.getHeight() - legStartY;

        final int legOffsetY = (int) (this.upperbody.getCoordinates().getY() + (this.upperbody.getHeight() * 0.9));

        // right leg
        this.Rightleg = new Leg((int) (x + upperbodyWidth * 0.45), legStartY, legsWidth, legHeightTillBoundBox);

        // left leg
        this.Leftleg = new Leg((int) (x + upperbodyWidth * 0.85), legStartY, legsWidth, legHeightTillBoundBox);
    }

    public void calculateAndSetHeight() {
        int height = (int) (this.getWidth() * this.boundingBoxRatio);
        this.setHeight(height);
    }


    @Override
    public void draw() {

        // coordinates for the upper_body
        upperbody.draw();
        head.draw();
        Rightleg.draw();
        Leftleg.draw();


        // drawing the bounding box
        // this.drawBoundingBox();
    }

    public Upperbody getUpperbody() {
        return this.upperbody;
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

    public void setPrimaryColor(Color color) {
        this.primaryColor = color;
        this.upperbody.setPrimaryColor(this.primaryColor);
    }

    public Color getPrimaryColor() {
        return this.primaryColor;
    }
}
