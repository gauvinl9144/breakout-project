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
		this.block.setWidth(145);
		this.block.setHeight(45);
		this.blockLevel = 4;
		this.block.setStroke(Color.ANTIQUEWHITE);
		
	}
	
	public Blocks(int inputLevel)
	{
		if(inputLevel > 4)
		{
			inputLevel = 4;
		}
		
		else if(inputLevel < 0)
		{
			inputLevel = 0;
		}
		
		this.block = new Rectangle();
		this.block.setWidth(145);
		this.block.setHeight(45);
		this.blockLevel = inputLevel;
		
		if(inputLevel == 4)
		{
			this.block.setFill(Color.DARKRED);
		}
		
		else if(inputLevel == 3)
		{
			this.block.setFill(Color.ORANGE);
		}
		
		else if(inputLevel == 2)
		{
			this.block.setFill(Color.YELLOW);
		}
		
		else if(inputLevel == 1)
		{
			this.block.setFill(Color.GREEN);
		}
		
		else if(inputLevel == 0)
		{
			this.block.setFill(Color.BLUE);
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
	
	protected Rectangle getRectangle()
    {
        return this.block;
    }
	protected int getBlockLevel()
	{
		return this.blockLevel;
	}
	
}
