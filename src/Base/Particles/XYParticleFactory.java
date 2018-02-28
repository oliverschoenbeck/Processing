package Base.Particles;

import processing.core.PApplet;

public class XYParticleFactory extends ParticleFactory {

    private final int maxParticlesPerFrame = 2;
    private final int maxParticles;
    private final int x;
    private final int y;

    public XYParticleFactory(PApplet canvas, int maxParticles, int x, int y) {
        super(canvas);

        this.maxParticles = maxParticles;
        this.x = x;
        this.y = y;
    }

    @Override
    public void spawnParticles() {
        int i = 0;
        while (particles.size() < maxParticles)
        {
            if (i >= maxParticlesPerFrame) break;

            Particle p = new Particle(canvas, x, y, 0);
            particles.add(p);
            i++;
        }
    }
}
