package Card;

import java.awt.Color;
// import java.awt.image.BufferedImage;

public class Card 
{
	private String cardColor;
	private int cardNumber;
	
	private final static int cardWidth = 68;
	private final static int cardHeight = 103;
//	private BufferedImage card;
	
	public Card(String color, int cardNum)
	{
		cardColor = color;
		cardNumber = cardNum;
	
		
	}
	public static int getCardWidth()
	{
		return cardWidth;
	}
	
	public static int getCardHeight()
	{
		return cardHeight;
	}
	
	public String getCardColor()
	{
		return cardColor;
	}
	public void setColor(String color)
	{
		cardColor = color;
	}
	
	public void setCardNumber(int number)
	{
		cardNumber = number;
	
	}
	
	public int getCardNumber()
	{
		return cardNumber;
	}
	

}
