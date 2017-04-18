package edu.osu.cs362;

import java.util.NoSuchElementException;


public class Unit {
    private static int MAX_LEVEL=10;
	private String name="";
	private double attack=0;
    private double monster=1000;
    private int level=0;
    

	public Unit(){
    }

    public void SetAbility(String name, double attack, int level){
        this.name = name;
        this.attack = attack;
        this.level = level;
    }
    
    public void Attacking(){
        if(attack < monster)
            throw new NoSuchElementException("Cannot defeaat the monster");
        else {
            levelup();
            MonsterLevelup();
        }
    }
    
    public void GetTreasure(){
        levelup();
    }
    
    private void MonsterLevelup(){
        monster *= 1.5;
    }

	public int GetLevel(){
		return this.level;
	}
    
	private void levelup(){
        if(isLevelMax())
            throw new NoSuchElementException("Cannot level up");
        else {
            System.out.println("Level up");
            this.level += 1;
            this.attack *= 1.01;
            System.out.println("Current Level: " + this.GetLevel());
        }
	}
    
    private boolean isLevelMax(){
        if (level == MAX_LEVEL)
            return true;
        else
            return false;
    }
}
