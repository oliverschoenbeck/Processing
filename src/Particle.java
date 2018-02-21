import processing.core.PApplet;
import processing.core.PVector;

public class Particle extends ProcessingObject {

    public PVector previousPosition;
    public float Mass = 1.0f;

    public Particle(PApplet canvas, int x, int y) {
        super(canvas, x, y);

        previousPosition = position.copy();
    }

    public void draw(){
        canvas.line(previousPosition.x, previousPosition.y, position.x, position.y);
    }
}
