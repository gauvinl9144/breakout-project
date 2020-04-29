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
			this.blockLevel = 4;
		}
		else if(inputLevel == 3)
		{
			this.block = new Rectangle();
			this.block.setFill(Color.ORANGE);
			this.block.setWidth(100);
			this.block.setHeight(20);
			this.blockLevel = 3;
		}
		else if(inputLevel == 2)
		{
			this.block = new Rectangle();
			this.block.setFill(Color.YELLOW);
			this.block.setWidth(100);
			this.block.setHeight(20);
			this.blockLevel = 2;
		}
		else if(inputLevel == 1)
		{
			this.block = new Rectangle();
			this.block.setFill(Color.GREEN);
			this.block.setWidth(100);
			this.block.setHeight(20);
			this.blockLevel = 1;
		}
		else if(inputLevel == 0)
		{
			this.block = new Rectangle();
			this.block.setFill(Color.BLUE);
			this.block.setWidth(100);
			this.block.setHeight(20);
			this.blockLevel = 0;
		}
		
	}
	
	protected void destroyBlock()
	{
		if(this.blockLevel == 4)
		{
			this.block.setFill(Color.ORANGE);
		}
		if(this.blockLevel == 3)
		{
			this.block.setFill(Color.YELLOW);
		}
		if(this.blockLevel == 2)
		{
			this.block.setFill(Color.GREEN);
		}
		if(this.blockLevel == 1)
		{
			this.block.setFill(Color.BLUE);
		}
		this.blockLevel -= 1;
	}
	protected int getBlockLevel()
	{
		return this.blockLevel;
	}
	
	protected Rectangle getRectangle()
    {
        return this.block;
    }
	
}
