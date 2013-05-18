package cz.bamboomachine.javagame.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import cz.bamboomachine.javagame.RenderLayer;
import cz.bamboomachine.javagame.Vector;

public class Enemy extends Entity {

    private Vector directionVector;

    public Enemy(RenderLayer l) {
	super( l );
	Random rnd = new Random();

	switch ( rnd.nextInt( 5 ) ) {
	    case 0:
		this.color = Color.BLUE;
		break;
	    case 1:
		this.color = Color.RED;
		break;
	    case 2:
		this.color = Color.YELLOW;
		break;
	    case 3:
		this.color = Color.CYAN;
		break;
	    case 4:
		this.color = Color.MAGENTA;
		break;
	}

	do {
	    this.xPosition = rnd.nextInt( 800 );
	} while ( this.xPosition > 800 - 50 );

	do {
	    this.yPosition = rnd.nextInt( 600 );
	} while ( this.yPosition > 600 - 50 );

	this.directionVector = new Vector( rnd.nextInt( 2 ), rnd.nextInt( 2 ) );
	this.width = 50;
	this.height = 50;
    }

    @Override
    public void render( Graphics g ) {
	g.setColor( this.color );
	g.fillRect( (int) this.xPosition, (int) this.yPosition, 50, 50 );
    }

    @Override
    public void update() {
	Random rnd = new Random();
	int newX = (int) this.xPosition + this.directionVector.getX();
	int newY = (int) this.yPosition + this.directionVector.getY();
	int randomNumber = rnd.nextInt( 500 );

	if ( newX <= 0 || newX >= 800 - 50 ) {
	    this.directionVector.changeDirection( Vector.X_DIRECTION );
	    if ( randomNumber > 250 && randomNumber < 320 ) {
		this.directionVector.newDirection( Vector.X_DIRECTION );
	    }

	    newX = newX <= 0 ? 0 : 800 - 50;
	}
	if ( newY <= 0 || newY >= 600 - 50 ) {
	    this.directionVector.changeDirection( Vector.Y_DIRECTION );
	    if ( randomNumber > 120 && randomNumber < 200 ) {
		this.directionVector.newDirection( Vector.Y_DIRECTION );
	    }

	    newY = newY <= 0 ? 0 : 600 - 50;
	}

	this.xPosition = newX;
	this.yPosition = newY;
    }

}
