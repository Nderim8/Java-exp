package puzzle;

import java.awt.Image;

public class Square {

	private int X = 0, Y = 0,  Width = 0, Height = 0, Pos = 0;
	private boolean Taken = false;
	private Image Img;
	public Square(int x, int y, int width, int height, Image img,  int pos, boolean taken) {
		
		X = x;
		Y = y;
		Width = width;
		Height = height;
		Pos = pos;
		Taken = taken;
		Img = img;
	}
	
	public int getX() {
		return X;
	}
	public int getY() {
		return Y;
	}
	
	public int getWidth() {
		return Width;
	}
	public int getHeight() {
		return Height;
	}
	public Image getImage() {
		return Img;
	}
	public void setImage(Image img) {
		Img = img;
	}
	public int getPosition() {
		return Pos;
	}
	public boolean getTaken() {
		return Taken;
	}
	
	public void setX(int x) {
		X = x;
	}
	public void setY(int y) {
		Y = y;
	}
	public void setWidth(int width) {
		Width = width;
	}
	public void setHeight(int height) {
		Height = height;
	}
	public void setPos(int pos) {
		Pos = pos;
	}
	public void setTaken(boolean taken) {
		Taken = taken;
	}
	
	

}
