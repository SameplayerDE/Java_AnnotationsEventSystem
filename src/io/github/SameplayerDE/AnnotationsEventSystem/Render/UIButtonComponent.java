package io.github.SameplayerDE.AnnotationsEventSystem.Render;

public class UIButtonComponent extends UIComponent {

    private int ID;
    private String text;
    
    public UIButtonComponent(int ID, String text) {
    
        this.ID = ID;
        this.text = text;
    
    }


    public void draw() {

        System.out.println("-----");
        System.out.println("| " + text + " |");
        System.out.println("-----");

    }
    

    public void action() {

    }

}