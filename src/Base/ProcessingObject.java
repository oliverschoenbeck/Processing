package Base;

import processing.core.PApplet;
import processing.core.PVector;

import java.util.ArrayList;

public abstract class ProcessingObject implements IDrawable {

    public PApplet canvas;
    public PVector position;

    public ProcessingObject(PApplet canvas, float x, float y, float z){
        this.canvas = canvas;
        this.position = new PVector(x, y, z);
    }

    public void draw(){
        simulate();
        render();
    }

    public void simulate(){

    }

    public abstract void render();

    // Helper for canvas functions

    public int width(){
        return canvas.width;
    }
    public int height(){
        return canvas.height;
    }

    public float random(float high){
        return canvas.random(high);
    }
    public float random(float low, float high){
        return canvas.random(low, high);
    }

    public void translate(float x, float y){
        canvas.translate(x, y);
    }
    public void translate(float x, float y, float z){
        canvas.translate(x, y, z);
    }

    public float map(float value, float s1, float e1, float s2, float e2){
        return canvas.map(value, s1, e1, s2, e2);
    }

    public void stroke(int rgb){
        canvas.stroke(rgb);
    }
    public void stroke(int rgb, float alpha){
        canvas.stroke(rgb, alpha);
    }
    public void stroke(float gray){
        canvas.stroke(gray);
    }
    public void stroke(float gray, float alpha){
        canvas.stroke(gray, alpha);
    }
    public void stroke(float r, float g, float b){
        canvas.stroke(r, g, b);
    }
    public void stroke(float r, float g, float b, float alpha){
        canvas.stroke(r, g, b, alpha);
    }


    public float sin(float angle){
        return canvas.sin(angle);
    }

    public float cos(float angle){
        return canvas.cos(angle);
    }

    public float tan(float angle){
        return canvas.tan(angle);
    }
}