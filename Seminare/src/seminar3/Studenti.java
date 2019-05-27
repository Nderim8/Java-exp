package seminar3;

public class Studenti 
{
	private String Emri;
	private double Piket;
	private int Quiz;
	private double PiketMes;
	
	public Studenti(String emri,double piket)
	{
		Emri = emri;
		Piket = piket;
		Quiz = 1;
		PiketMes = 0;
	}
	public String getName()
	{
		return Emri;
	}
	
	public void addQuiz(double score)
	{
		Piket += score;
		Quiz ++;	
	}
	public double getTotalScore()
	{
		return Piket;
	}
	
	public double getAvarageScore()
	{
		PiketMes = Piket/Quiz;
		return PiketMes;
	}
	public int getQuizNumber()
	{
		return Quiz;
	}
	
	public void reset()
	{
		Piket = 0;
		Quiz = 0;
		PiketMes = 0;
	}
	
	
	public static void main (String[]args)
	{
		Studenti studenti = new Studenti("Rildi",80);
		studenti.addQuiz(30);
		studenti.addQuiz(70);
		System.out.println("Emri: " + studenti.getName());
		System.out.println("Piket totale: " + studenti.getTotalScore());
		System.out.println("Piket mesatare: " + studenti.getAvarageScore());
		System.out.println("Numri pyetsoreve: " + studenti.getQuizNumber());
	    studenti.reset();
	    studenti.addQuiz(60);
	    studenti.addQuiz(40);
		System.out.println("Emri: " + studenti.getName());
		System.out.println("Piket totale: " + studenti.getTotalScore());
		System.out.println("Piket mesatare: " + studenti.getAvarageScore());
		System.out.println("Numri pyetsoreve: " + studenti.getQuizNumber());
	    
	}

	
	
}
