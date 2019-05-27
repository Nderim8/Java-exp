package Digimon;

public class Digimon 
{
	private DigimonType digimonType;
	private int attack, defence, health, support, limitBreak;
	private int maxAttack, maxDefence, maxHealth, maxSupport, maxLimitBreak;
	private int mainSkillTurns, leaderSkillsTurns;
	private int maxMainSkillTurns, maxLeaderSkillTurns;
	private int stars;
	
	private String name;
	private String rarity;
	private String mainRace, secondaryRace, generation;
	private String mainSkill, leaderSkill;
	private String profile;
	
	public Digimon()
	{
		
	}
	
	public final void setDigimonType(DigimonType type)
	{
		digimonType = type; 
	}
	public final void setMaxAttack(int maxAtk)
	{
		maxAttack = maxAtk; 
	}
	public final void setMaxDefence(int maxDef)
	{
		maxDefence = maxDef; 
	}
	public final void setMaxHealth(int maxHp)
	{
		maxHealth = maxHp; 
	}
	public final void setMaxSup(int maxSupp)
	{
		maxSupport = maxSupp; 
	}
	public final void setMaxLimitBreak(int maxLim)
	{
		maxLimitBreak = maxLim; 
	}
	

}
