package Base;

import processing.core.PApplet;
import processing.core.PConstants;

import java.util.ArrayList;

public class LSystem {

    private String axiom = "X";
    private String sentence = axiom;

    private ArrayList<LSystemRule> rules;
    private PApplet canvas;
    private float initialLen = 300;
    private float len = initialLen;
    private float deg = 25.0f;// = canvas.random(10, 15);

    public LSystem(PApplet canvas){
        this.canvas = canvas;
        rules = new ArrayList<>();
        // rules.add(new LSystemRule('0', "1[0]01[0]0"));
        // rules.add(new LSystemRule('1', "11"));
        rules.add(new LSystemRule('X', "F[-X][X]F[-X]+FX"));
        rules.add(new LSystemRule('F', "FF"));
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

        System.out.println(sentence);
    }

    public void render() {
        canvas.background(0);
        //canvas.resetMatrix();
        canvas.translate(canvas.width / 2, canvas.height);
        canvas.stroke(255);

        System.out.println("C = " + sentence.length());
        Character lastOp;
        for (int i = 0; i < sentence.length(); i++){
            Character c = sentence.charAt(i);
            if (c == 'F'){
                canvas.stroke(255);
                canvas.line(0,0, 0, -len);
                canvas.translate(0, -len);

            } else if (c == '[') {
                canvas.pushMatrix();

            } else if (c == ']') {
                canvas.popMatrix();

            } else if (c == '+') {
                float val = canvas.radians(deg) * -1;
                canvas.rotate(val);

            } else if (c == '-') {
                float val = canvas.radians(deg);
                canvas.rotate(val);

            }
        }
    }
}