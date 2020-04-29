package application;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Blocks {
	private Rectangle block;
	private int blockLevel;
	
	Blocks()
	{
		this.block = new Rectangle();
		this.block.setFill(Color.DARKRED);
		this.block.setWidth(100);
		this.block.setHeight(20);
		this.blockLevel = 4;
		this.block.setStroke(Color.ANTIQUEWHITE);
		
	}
	
	public Blocks(int inputLevel)
	{
		if(inputLevel == 4)
		{
			this.block = new Rectangle();
			this.block.setFill(Color.DARKRED);
			this.block.setWidth(100);
			this.block.setHeight(20);
			this.blockLevel = inputLevel;
		}
		else if(inputLevel == 3)
		{
			this.block = new Rectangle();
			this.block.setFill(Color.ORANGE);
			this.block.setWidth(100);
			this.block.setHeight(20);
			this.blockLevel = inputLevel;
		}
		else if(inputLevel == 2)
		{
			this.block = new Rectangle();
			this.block.setFill(Color.YELLOW);
			this.block.setWidth(100);
			this.block.setHeight(20);
			this.blockLevel = inputLevel;
		}
		else if(inputLevel == 1)
		{
			this.block = new Rectangle();
			this.block.setFill(Color.GREEN);
			this.block.setWidth(100);
			this.block.setHeight(20);
			this.blockLevel = inputLevel;
		}
		else if(inputLevel == 0)
		{
			this.block = new Rectangle();
			this.block.setFill(Color.BLUE);
			this.block.setWidth(100);
			this.block.setHeight(20);
			this.blockLevel = inputLevel;
		}
		
	}
	
	protected void destroyBlock()
	{
		if(this.blockLevel == 4)
		{
			this.block.setFill(Color.ORANGE);
			this.blockLevel -= 1;
		}
		if(this.blockLevel == 3)
		{
			this.block.setFill(Color.YELLOW);
			this.blockLevel -= 1;
		}
		if(this.blockLevel == 2)
		{
			this.block.setFill(Color.GREEN);
			this.blockLevel -= 1;
		}
		if(this.blockLevel == 1)
		{
			this.block.setFill(Color.BLUE);
			this.blockLevel -= 1;
		}
		if(this.blockLevel == 0)
		{
			this.blockLevel -= 1;
		}
	}
	
	protected Rectangle getRectangle()
    {
        return this.block;
    }
	
}
