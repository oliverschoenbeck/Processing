package Base.Particles;

import processing.core.PApplet;

import java.util.ArrayList;

public abstract class ParticleFactory {

    public PApplet canvas;
    public ArrayList<Particle> particles;

    public ParticleFactory(PApplet canvas){
        this.canvas = canvas;
        particles = new ArrayList<>();
    }

    public abstract void spawnParticles();
}

