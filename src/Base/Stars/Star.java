package Base.Stars;

import Base.ProcessingObject;
import processing.core.PApplet;
import processing.core.PVector;

public class Star extends ProcessingObject {

    public float maximumZ;

    public PVector previousPosition;
    public PVector initialPosition;

    public Star(PApplet canvas, float x, float y, float z) {
        super(canvas, x, y, canvas.random(z));
        initialPosition = new PVector(x, y, z);
        this.maximumZ = z;
    }

    @Override
    public void simulate() {
        boolean reset = false;
        previousPosition = position.copy();
        position.z = position.z - 10;
        if (position.z < 1){
            position.z = maximumZ;
            reset = true;
        }

        position.x = map(initialPosition.x / position.z, 0, 1, 0, width());
        position.y = map(initialPosition.y / position.z, 0, 1, 0, height());

        if (reset)
            previousPosition = position.copy();
    }

    public void render(){
        float r = map(position.z, 0, maximumZ, 16,0);
        float alpha = map(position.z, 0, maximumZ, 255,0);
        stroke(255, alpha);
        canvas.line(previousPosition.x, previousPosition.y, position.x, position.y);
        // canvas.ellipse(position.x, position.y, r, r);
    }
}