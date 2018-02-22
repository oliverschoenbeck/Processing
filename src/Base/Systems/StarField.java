package Base.Systems;

import Base.Elements.Star;
import Base.ProcessingObject;
import processing.core.PApplet;

public class StarField extends ProcessingObject {

    private int maxStars;
    public Star[] stars;

    public StarField(PApplet canvas, int maxStars) {
        super(canvas, 0, 0, 0);
        this.maxStars = maxStars;
        this.stars = new Star[maxStars];
        for (int i = 0; i < maxStars; i++){
            stars[i] = new Star(this.canvas, random(-width(), width()), random(-height(), height()), width());
        }
    }

    @Override
    public void render() {
        translate(width() / 2, height() / 2);
        stroke(255);
        for (int i = 0; i < maxStars; i++){
            stars[i].draw();
        }
    }
}
