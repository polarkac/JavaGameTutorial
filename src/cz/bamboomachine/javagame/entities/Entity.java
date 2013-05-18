package cz.bamboomachine.javagame.entities;

import java.awt.Color;
import java.awt.Graphics;

import cz.bamboomachine.javagame.RenderLayer;

public abstract class Entity {
    
    protected int xPosition;
    protected int yPosition;
    protected int width;
    protected int height;
    protected Color color;
    protected RenderLayer map;
    
    public Entity( RenderLayer l ) {
	this.map = l;
    }
    
    abstract public void render(Graphics g);
    abstract public void update();
    
    public int getPositionX() {
	return this.xPosition;
    }
    
    public int getPositionY() {
	return this.yPosition;
    }
    
    public int getWidth() {
	return this.width;
    }
    
    public int getHeight() {
	return this.height;
    }
}
