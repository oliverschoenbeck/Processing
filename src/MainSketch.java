import processing.core.PApplet;

public class MainSketch extends PApplet {



    @Override
    public void settings() {
        size(800,600);
    }

    @Override
    public void draw() {
        background(0);
    }



    public static void main(String[] args){
        String[] processingArgs = {"MainSketch"};
        PApplet app = new MainSketch();
        PApplet.runSketch(processingArgs, app);
    }
}