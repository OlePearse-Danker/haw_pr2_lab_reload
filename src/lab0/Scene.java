package lab0;

import com.sun.security.jgss.GSSUtil;

import java.awt.*;
import java.util.ArrayList;


public class Scene {

    // Declare a private ArrayList called "cats"
    private ArrayList<Cat> cats;

    private boolean centerCat;

    private int catCount;

    private Color bgColor;

    public Scene() {

        // Initialize the "cats" ArrayList
        this.cats = new ArrayList<Cat>();

        this.catCount = 0;

        // change this to true if you want to center the cat
        this.centerCat = false;

        // Add n cats
        int catsToDraw = 30;

        this.addCats(catsToDraw);


        // Set background color
        this.bgColor = new Color(238, 238, 238);
    }

    // Method to add a new cat to the scene
    public void addCat() {
        System.out.println("Add new cat.");
        Dimension screenSize = ScreenInterface.getScreenSize();
        int x = RandomNumber.between(0, screenSize.width);
        int y = RandomNumber.between(0, screenSize.height);

        // change this to set size of cat
        int width = RandomNumber.between(100, 300);

        // Create a new Cat object with the random position and size;
        Cat newCat = new Cat(x, y, width);

        // Center cat
        if (this.centerCat) {
            width = 500;
            newCat.setWidth(width);
            newCat.calculateAndSetHeight();
            int height = newCat.getHeight();

            int centerX = (int) (screenSize.width / 2.);
            int centerY = (int) (screenSize.height / 2.);

            x = (int) (centerX - (width / 2.));
            y = (int) (centerY - (height / 2.));

            newCat = new Cat(x, y, width);
        }

        // Generate a new random color
        final int colorR = RandomNumber.between(0, 255);
        final int colorG = RandomNumber.between(0, 255);
        final int colorB = RandomNumber.between(0, 255);

        Color primaryColor = new Color(colorR, colorG, colorB);
        newCat.setPrimaryColor(primaryColor);

        // Append cat to the list of cats
        this.cats.add(newCat);

        // Get count of cats
        this.catCount = this.cats.size();
    }

    public ArrayList<Cat> getCats() {
        return this.cats;
    }

    public void draw() {
        // Draw fullscreen bg
        Drawing.pen().setColor(this.bgColor);
        Drawing.pen().fillRect(0, 0, ScreenInterface.getScreenSize().width, ScreenInterface.getScreenSize().height);

        System.out.println("Draw scene.");
        System.out.println("Cat count: " + this.cats.size());

        // Draw all cats
        this.drawCats();
    }

    private void drawCats() {
        ArrayList<Cat> drawnCats = new ArrayList<Cat>();
        ArrayList<Cat> catsStillToDraw = new ArrayList<Cat>();

        // Copy all cats to the list of cats still to draw
        catsStillToDraw.addAll(this.cats);

        // 1. edge case: no cats are drawn yet

        // Get first cat from the list
        if (this.cats.size() == 0) {
            return;
        }

        Cat firstCat = this.cats.get(0);

        // Draw the first cat
        firstCat.draw();

        // Remove the first cat from the list of cats still to draw
        catsStillToDraw.remove(firstCat);

        // Add the first cat to the list of drawn cats
        drawnCats.add(firstCat);



        // Repetitive code for all remaining cats

        for (Cat cat : catsStillToDraw) {
            // Check if cat intersects with any of the drawn cats
            boolean intersects = false;

            for (Cat drawnCat : drawnCats) {
                if (cat.intersects(drawnCat)) {
                    intersects = true;
                    break;
                }
            }

            if (!intersects) {
                cat.draw();
                drawnCats.add(cat);
            }
        }

    }

    public void addCats(int catNum) {
        for (int i = 0; i < catNum; i++) {
            this.addCat();
        }
    }

    public void removeAllCats() {
        System.out.println("Remove all cats.");
        this.cats.clear();
    }

    public ArrayList<Cat> getAllCats() {
        return this.cats;
    }

    public void setBackgroundColor(Color color) {
        this.bgColor = color;
    }

    public Color getBackgroundColor() {
        return this.bgColor;
    }
}






