package lab0;

import java.awt.*;
import java.util.ArrayList;


public class Scene {

    private ArrayList<Cat> cats; // Declare a private ArrayList called "cats"

    public Scene() {
        this.cats = new ArrayList<Cat>(); // Initialize the "cats" ArrayList

        // Add 20 cats
        for (int i = 0; i < 20; i++) {
            this.addCat();
        }

        this.draw();
    }

    // Method to add a new cat to the scene
    public void addCat() {
        int width = 100;
        int x = RandomNumber.between(100, 800);
        int y = RandomNumber.between(100, 500);

        // Create a new Cat object with the random position and size;
        Cat newCat = new Cat(x, y, width);

        // Append cat to the list of cats
        this.cats.add(newCat);
//
//        boolean intersects = false;
//
//        // Check if the new cat overlaps with any of the existing cats
//        for (Cat currentCat : this.cats) {
//            if (currentCat.intersects(newCat)) {
//                intersects = true;
//                break;
//            }
//        }
//
//        // If the new cat does not overlap with any existing cats, add it to the list
//        if (!intersects) {
//            cats.add(newCat);
//        }
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






