import processing.core.PApplet;
import processing.core.PVector;

public class ProcessingObject {

    protected PApplet canvas;
    protected PVector position;

    public ProcessingObject(PApplet canvas, int x, int y){
        this.canvas = canvas;
        this.position = new PVector(x,y);
    }
}