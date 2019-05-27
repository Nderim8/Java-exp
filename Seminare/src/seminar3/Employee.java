package seminar3;

public class Employee 
{
	private String EmployeeName;  double CurrentSalary;
	
	public Employee(String employeeName,double currentSalary)
	{
		EmployeeName = employeeName;
		CurrentSalary = currentSalary;
	}
	public String getName()
	{
		return EmployeeName;
	}
    public double getSalary()
    {
    	return CurrentSalary;
    }
    public void raiseSalary(double byPercent)
    {
    	CurrentSalary += CurrentSalary * byPercent/100;
    }
    
    public static void main(String[]args)
    {
    	Employee L = new Employee("Ryuzaki",50000);
    	
    	System.out.println("Emri punonjesit:" + L.getName());
    	System.out.println("Rroga e tij: " + L.getSalary());
    	L.raiseSalary(50);
    	System.out.println("Rroga e re pas rritjes: " + L.getSalary());


    }
	
}
