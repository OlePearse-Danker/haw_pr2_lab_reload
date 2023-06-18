package lab0;

import java.awt.*;
import java.util.ArrayList;

import lab0.graphicState.*;


public class Scene {
    private static State graphicState;
    private String currentScene;

    // Declare a private ArrayList called "cats"
    private ArrayList<Cat> cats;
    private ArrayList<Poop> poops;

    private boolean centerCat;

    private int catCount;

    private boolean poopMode;

    private Color bgColor;

    public Scene() {

        graphicState = OutsideState.getInstance(this);
        this.currentScene = "inside";
        this.setState(this.currentScene);

        // Initialize the "cats" ArrayList
        this.cats = new ArrayList<Cat>();
        this.poops = new ArrayList<Poop>();

        this.catCount = 0;
        this.poopMode = false;

        // change this to true if you want to center the cat
        this.centerCat = false;

        // Add n cats
        int catsToDraw = 30;
        int poopsToDraw = 30;

        this.addCats(catsToDraw);
        this.addPoops(poopsToDraw);


        // Set background color
//        this.bgColor = new Color(238, 238, 238);
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
        Cat newCat = new Cat(x, y, width, this);

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

            newCat = new Cat(x, y, width, this);
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

        if (this.poopMode) {
            this.drawPoops();
        }
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

    public void drawPoops() {
        System.out.println("Scene.drawPoops();");
        System.out.println("Poop count: " + this.poops.size());
        for (Poop poop : this.poops) {
            poop.draw();
        }
    }

    public void addCats(int catNum) {
        for (int i = 0; i < catNum; i++) {
            this.addCat();
        }
    }

    public void addPoops(int poopNum) {
        for (int i = 0; i < poopNum; i++) {
            Poop poop = new Poop(200, 200, 50, this);
            this.poops.add(poop);
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


    public void togglePoopMode() {
        this.poopMode = !this.poopMode;
    }


    // Set states

    public void setState(String sceneType) {
        this.currentScene = sceneType;

        if (sceneType.equals("outside")) {
            graphicState = graphicState.drawOutside();
        } else if (sceneType.equals("inside")) {
            graphicState = graphicState.drawInside();
        } else if (sceneType.equals("poop")) {
            graphicState = graphicState.drawPoop();
        }
    }

    public String getCurrentScene() {
        return this.currentScene;
    }
}






