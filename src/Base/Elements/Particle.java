package Base.Elements;

import Base.ProcessingObject;
import processing.core.PApplet;
import processing.core.PVector;

public class Particle extends ProcessingObject {

    public PVector previousPosition;
    public float Mass = 1.0f;

    public Particle(PApplet canvas, int x, int y, int z) {
        super(canvas, x, y, z);
        previousPosition = position.copy();
    }

    @Override
    public void simulate() {

        previousPosition = position.copy();
    }

    public void render(){
        canvas.line(previousPosition.x, previousPosition.y, position.x, position.y);
    }
}
