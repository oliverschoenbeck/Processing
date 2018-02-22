import Base.IDrawable;
import Base.LSystem;
import Base.Particles.ParticleSystem;
import Base.Particles.RandomParticleFactory;
import Base.Particles.XYParticleFactory;
import processing.core.PApplet;
import processing.event.MouseEvent;

public class MainSketch extends PApplet {

    private IDrawable drawable;

    private LSystem s;

    @Override
    public void settings() {
         size(800,800);
         //fullScreen();
    }

    @Override
    public void setup() {
        //drawable = new ParticleSystem(this, new XYParticleFactory(this, 1000, 0, 0));
        s = new LSystem(this);
        s.render();
    }

    @Override
    public void mousePressed(MouseEvent event) {
        s.mutate();
    }

    @Override
    public void draw() {
        // background(0);


        //pushMatrix();
        //translate(width / 2, height / 2);
        //drawable.draw();
        //popMatrix();
    }

    public static void main(String[] args){
        String[] processingArgs = {"MainSketch"};
        PApplet app = new MainSketch();
        PApplet.runSketch(processingArgs, app);
    }
}