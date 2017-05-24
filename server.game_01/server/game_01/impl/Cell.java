package server.game_01.impl;

public class Cell {
	
	private int unit;
	private int idPlayer;
	
	private int attack;
	private int defence;
	private int shot;
	private int health;
	
	public Cell(int unit, int idPlayer) {
		super();
		this.unit = unit;
		this.idPlayer = idPlayer;
		this.attack = 0;
		this.defence = 0;
		this.shot = 0;
		this.health = 0;
		
	}
	
	public Cell(int unit, int idPlayer, int attack, int defence, int shot,int health) {
		super();
		this.unit = unit;
		this.idPlayer = idPlayer;
		this.attack = attack;
		this.defence = defence;
		this.shot = shot;
		this.health = health;
	}
	public int getUnit() {
		return unit;
	}
	public void setUnit(int unit) {
		this.unit = unit;
	}
	public int getIdPlayer() {
		return idPlayer;
	}
	public void setIdPlayer(int idPlayer) {
		this.idPlayer = idPlayer;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getDefence() {
		return defence;
	}

	public void setDefence(int defence) {
		this.defence = defence;
	}

	public int getShot() {
		return shot;
	}

	public void setShot(int shot) {
		this.shot = shot;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}
	
}
