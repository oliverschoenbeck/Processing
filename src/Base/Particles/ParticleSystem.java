package Base.Particles;

import Base.ProcessingObject;
import processing.core.PApplet;

import java.util.Iterator;

public class ParticleSystem extends ProcessingObject {

    private ParticleFactory factory;

    public ParticleSystem(PApplet canvas, ParticleFactory factory) {
        super(canvas, 0, 0, 0);
        this.factory = factory;
    }

    @Override
    public void simulate() {
        factory.spawnParticles();
    }

    @Override
    public void render() {
        Iterator<Particle> it = factory.particles.iterator();
        while (it.hasNext()) {
            Particle p = it.next();
            if (p.isDead()) {
                it.remove();
            } else{
                p.draw();
            }
        }
    }
}