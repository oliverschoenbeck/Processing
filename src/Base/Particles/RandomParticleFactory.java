package Base.Particles;

import processing.core.PApplet;

public class RandomParticleFactory extends ParticleFactory {

    private int maxParticles;

    public RandomParticleFactory(PApplet canvas, int maxParticles) {
        super(canvas);

        this.maxParticles = maxParticles;
    }

    @Override
    public void spawnParticles() {
        while (particles.size() < maxParticles)
        {
            Particle p = new Particle(canvas, Math.round(canvas.random(0, canvas.width)), Math.round(canvas.random(0, canvas.height)), 0);
            particles.add(p);
        }
    }
}

