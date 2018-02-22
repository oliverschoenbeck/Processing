package Base.Particles;

import Base.ProcessingObject;
import processing.core.PApplet;
import processing.core.PVector;

public class Particle extends ProcessingObject {

    public final int maxLifetime = 250;

    public PVector previousPosition;
    private PVector velocity;
    private PVector acceleration;
    private float lifetime;
    public float mass = 3.0f;

    public Particle(PApplet canvas, int x, int y, int z) {
        super(canvas, x, y, z);
        previousPosition = position.copy();

        this.acceleration = new PVector(0,0);
        this.velocity = new PVector(random(-10,10) * canvas.PI,-8);
        this.lifetime = canvas.random(maxLifetime - 100,maxLifetime);
    }

    public void applyForce(PVector force) {
        PVector f = force.copy();
        f.div(mass);
        acceleration.add(f);
    }

    @Override
    public void simulate() {
        previousPosition = position.copy();

        applyForce(new PVector(0, 0.1f));
        velocity.add(acceleration);
        velocity.limit(4);
        position.add(velocity);
        acceleration.mult(0);

        if (position.x < -canvas.width/2){
            position.x = canvas.width/2;
            previousPosition.x = canvas.width/2;
        }
        if (position.x > canvas.width / 2) {
            position.x = -canvas.width/2;
            previousPosition.x = -canvas.width/2;
        }

        if (position.y < -canvas.height/2){
            position.y = canvas.height/2;
            previousPosition.y = canvas.height/2;
        }
        if (position.y > canvas.height/2){
            position.y = -canvas.height/2;
            previousPosition.y = -canvas.height/2;
        }
        lifetime -= 1;
    }

    public void render(){
        int c1 = canvas.color(0, 255, 0);
        int c2 = canvas.color(0, 0, 255);
        int color = canvas.lerpColor(c1, c2, map(lifetime, 0, maxLifetime, 0, 1));
        canvas.fill(color);
        canvas.ellipse(position.x, position.y, 4, 4);
    }

    // Is the particle still useful?
    public boolean isDead() {
        if (lifetime < 0.0) {
            return true;
        } else {
            return false;
        }
    }
}