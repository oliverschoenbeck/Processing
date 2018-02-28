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
        for (int i = 0; i < 2; i++){
            s.mutate();
        }
        System.out.println("CALC DONE");
        s.render();
        System.out.println("RENDER DONE");
    }

    @Override
    public void mousePressed(MouseEvent event) {

    }

    @Override
    public void draw() {

    }

    public static void main(String[] args){
        String[] processingArgs = {"MainSketch"};
        PApplet app = new MainSketch();
        PApplet.runSketch(processingArgs, app);
    }
}