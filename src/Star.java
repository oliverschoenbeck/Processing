import processing.core.PApplet;
import processing.core.PVector;

public class Star extends ProcessingObject {

    public float maximumZ;

    public PVector velocity = new PVector(0,0,0);
    public PVector force = new PVector(0,0,0);

    public Star(PApplet canvas, float x, float y, float z) {
        super(canvas, x, y, canvas.random(z));
        this.maximumZ = z;
    }

    public void draw(){
        simulate();
        render();
    }

    private void simulate() {
        position.z = position.z - 10;
        if (position.z < 1)
            position.z = maximumZ;
    }

    private void render(){
        float sx = canvas.map(position.x / position.z, 0, 1, 0, canvas.width);
        float sy = canvas.map(position.y / position.z, 0, 1, 0, canvas.height);

        float r = canvas.map(position.z, 0, maximumZ, 16,0);

        canvas.ellipse(sx, sy, r, r);
    }
}