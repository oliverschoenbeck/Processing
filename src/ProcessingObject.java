import processing.core.PApplet;
import processing.core.PVector;

public abstract class ProcessingObject {

    protected PApplet canvas;
    protected PVector position;

    public ProcessingObject(PApplet canvas, float x, float y, float z){
        this.canvas = canvas;
        this.position = new PVector(x, y, z);
    }

    public abstract void draw();
}