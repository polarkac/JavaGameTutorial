package cz.bamboomachine.javagame.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import cz.bamboomachine.javagame.RenderLayer;

public class Player extends Entity implements MouseMotionListener {

    public Player(RenderLayer l) {
	super( l );
	this.color = Color.GREEN;
	this.width = this.height = 25;
	this.xPosition = 800 / 2 - this.width;
	this.yPosition = 600 / 2 - this.height;
    }

    @Override
    public void render( Graphics g ) {
	g.setColor( this.color );
	g.fillRect( (int) this.xPosition, (int) this.yPosition, this.width,
		this.height );
    }

    @Override
    public void update() {
	ArrayList<Entity> entities = map.getEntities();
	for ( Entity e : entities ) {
	    if ( this.isCollide( e ) ) {
		this.map.gameOver();
	    }
	}
    }

    private boolean isCollide( Entity e ) {
	int entX = e.getPositionX();
	int entY = e.getPositionY();
	int entWidth = e.getWidth();
	int entHeight = e.getHeight();

	if ( this.xPosition <= entX + entWidth
		&& this.xPosition + this.width >= entX
		&& this.yPosition + this.height >= entY
		&& this.yPosition <= entY + entHeight ) {
	    return true;
	}

	return false;
    }

    @Override
    public void mouseMoved( MouseEvent e ) {
	this.xPosition = e.getX() - this.width / 2;
	this.yPosition = e.getY() - this.height / 2;
    }

    @Override
    public void mouseDragged( MouseEvent e ) {
	this.mouseMoved( e );
    }

}
