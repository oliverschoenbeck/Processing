import processing.core.PApplet;

public class Planet extends ProcessingObject {

    public int id;

    public float mass = 1;

    public Planet(PApplet canvas, int id, int x, int y) {
        super(canvas, x, y);
        this.id = id;
    }

    public void draw(){
        canvas.ellipse();
    }

}