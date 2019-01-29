package io.github.SameplayerDE.Render;

public class UIButtonComponent extends UIComponent {

    private int ID;
    private String text;
    
    public UIButtonComponent(int ID, String text) {
    
        this.ID = ID;
        this.text = text;
    
    }

    @Overwrite
    public void draw() {}
    
    @Overwrite
    public void action() {}

}