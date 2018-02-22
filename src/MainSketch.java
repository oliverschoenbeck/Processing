import Base.Systems.StarField;
import processing.core.PApplet;

public class MainSketch extends PApplet {

    private StarField starField;

    @Override
    public void settings() {
        size(800,800);
        // fullScreen();

        starField = new StarField(this, 500);
    }

    @Override
    public void draw() {
        background(0);
        starField.draw();
    }

    public static void main(String[] args){
        String[] processingArgs = {"MainSketch"};
        PApplet app = new MainSketch();
        PApplet.runSketch(processingArgs, app);
    }
}