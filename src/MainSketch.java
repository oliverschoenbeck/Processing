import processing.core.PApplet;

public class MainSketch extends PApplet {

    public static final int MAX_STARS = 800;

    public Star[] planets = new Star[MAX_STARS];

    @Override
    public void settings() {
        size(800,800);
        // fullScreen();


        for (int i = 0; i < MAX_STARS; i++){
            planets[i] = new Star(this, random(-width, width), random(-height, height), width);
        }
    }

    @Override
    public void draw() {
        background(0);
        translate(width / 2, height / 2);
        for (int i = 0; i < MAX_STARS; i++){
            planets[i].draw();
        }
    }

    public static void main(String[] args){
        String[] processingArgs = {"MainSketch"};
        PApplet app = new MainSketch();
        PApplet.runSketch(processingArgs, app);
    }
}