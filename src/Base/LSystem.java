package Base;

import processing.core.PApplet;

import java.util.ArrayList;

public class LSystem {

    private String axiom = "0";
    private String sentence = axiom;

    private ArrayList<LSystemRule> rules;
    private PApplet canvas;
    private float initialLen = 500;
    private float len = initialLen;
    private float deg = 25.0f;// = canvas.random(10, 15);

    public LSystem(PApplet canvas){
        this.canvas = canvas;
        rules = new ArrayList<>();
        rules.add(new LSystemRule('0', "1[0]01[0]0"));
        rules.add(new LSystemRule('1', "11"));
        //rules.add(new LSystemRule('F', "FF+F+F+F+F+F-F"));
    }

    public void mutate(){
        len *= 0.5;
        StringBuilder nextSentence = new StringBuilder();
        for (int i = 0; i < sentence.length(); i++){
            boolean found = false;
            for (LSystemRule r : rules){
                if (r.pattern == sentence.charAt(i)){
                    nextSentence.append(r.replacement);
                    found = true;
                    break;
                }
            }
            if (!found)
                nextSentence.append(sentence.charAt(i));
        }
        sentence = nextSentence.toString();
    }

    public void render() {
        canvas.background(0);
        canvas.resetMatrix();
        canvas.translate(canvas.width / 2, canvas.height);
        canvas.stroke(255);

        System.out.println("C = " + sentence.length());
        Character lastOp;
        for (int i = 0; i < sentence.length(); i++){
            Character c = sentence.charAt(i);
            if (c == '0'){
                canvas.stroke(255);
                canvas.line(0,0,0, -len);
                canvas.translate(0, -len);
                canvas.stroke(255, 0, 0);
                for (int f = 0; f < 5; f++){
                    canvas.point(canvas.random(-1,1),canvas.random(-1,1));
                }
            } else if (c == '1'){
                canvas.stroke(255);
                canvas.line(0,0,0, -len);
                canvas.translate(0, -len);
            } else if (c == '[') {
                canvas.pushMatrix();
                canvas.rotate(canvas.radians(-deg));
            } else if (c == ']') {
                canvas.popMatrix();
                canvas.rotate(canvas.radians(deg));
            }
        }
    }
}