import Base.Flocking.Boids;
import Base.Knots.Knot;
import Base.LSystem;
import Base.Pendulums.Pendulum;
import processing.core.PApplet;
import processing.event.KeyEvent;
import processing.event.MouseEvent;

public class MainSketch extends PApplet {

    private Boids boids;

    @Override
    public void settings() {
         size(800,800, P2D);
         boids = new Boids(this);
         // boids.createWalls();
    }

    @Override
    public void setup() {
        colorMode(HSB);
        background(0);
    }

    @Override
    public void draw() {
        boids.draw();
    }

    @Override
    public void mouseClicked() {
        boids.createBoids();
    }

    @Override
    public void keyPressed(KeyEvent event) {
        boids.keyPressed(event);
    }

    public static void main(String[] args){
        String[] processingArgs = {"MainSketch"};
        PApplet app = new MainSketch();
        PApplet.runSketch(processingArgs, app);
    }
}
