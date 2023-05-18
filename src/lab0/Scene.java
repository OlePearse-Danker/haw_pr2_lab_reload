package lab0;

import java.awt.*;
import java.util.ArrayList;


public class Scene {

    private ArrayList<Cat> cats; // Declare a private ArrayList called "cats"

    public Scene() {
        this.cats = new ArrayList<Cat>(); // Initialize the "cats" ArrayList

        // Add n cats
        for (int i = 0; i < this.catCount; i++) {
            this.addCat();
        }

        this.draw();
    }

    // Method to add a new cat to the scene
    public void addCat() {
        int width = RandomNumber.between(100, 620);
        Dimension screenSize = ScreenInterface.getScreenSize();
        int x = RandomNumber.between(0, screenSize.width);
        int y = RandomNumber.between(0, screenSize.height);

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
    }

    public void draw() {
        ArrayList<Cat> drawnCats = new ArrayList<Cat>();
        ArrayList<Cat> catsStillToDraw = new ArrayList<Cat>();

        // Copy all cats to the list of cats still to draw
        for (Cat cat : this.cats) {
            catsStillToDraw.add(cat);
        }

        // 1. edge case: no cats are drawn yet

        // Get first cat from the list
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


}






