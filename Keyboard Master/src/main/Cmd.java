package main;

public class Cmd {
	

	private double xCord= 0;
	private double yCord = 0;
	private String Name = null;
	private double Speed = 0;
	public Cmd( int x, int y, String name, int speed) {
		
		xCord = x;
		yCord = y;
		Name = name;
		Speed = speed;
	}
	
	public double getX() {
		return xCord;
	}
	public double getY() {
		return yCord;
	}
	public String getName() {
		return Name;
	}
	
	public void setX( double x) {
		 xCord = x;
	}
	public void setY(double y) {
	     yCord = y;
	}
	public void setName(String name) {
		Name = name;
	}
    public double getSpeed() {
    	return Speed;
    }
    public void setSpeed(double speed) {
    	Speed = speed;
    }
	

}
