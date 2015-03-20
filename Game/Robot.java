package Game;

import java.awt.Color;

public class Robot {
	private String name;
	private Color color;
	private Angle position;
	private Item itemCache;

	private double distance;
	private double velocity;
	private double delta;

	private boolean isDead;
	private boolean onOil;

	public Robot(String name, Color color) {
		System.out.println("[:Robot].Robot()");
		this.name = name;
		this.color = color;
	}

	public void jump() {
		System.out.println("[:Robot].jump()");
	}

	public void accelerate() {
		System.out.println("[:Robot].accelerate()");
	}

	public void decelerate() {
		System.out.println("[:Robot].decelerate()");
	}

	public Angle getPosition() {
		System.out.println("[:Robot].getPosition()");
		return position;
	}

	public boolean getIsDead() {
		System.out.println("[:Robot].getIsDead()");
		return isDead;
	}

	public void setIsDead(boolean isDead) {
		System.out.println("[:Robot].setIsDead()");
		this.isDead = isDead;
	}

	public void halfSpeed() {
		System.out.println("[:Robot].halfSpeed()");
	}

	public Item getItemCache() {
		System.out.println("[:Robot].getItemCache()");
		return itemCache;
	}

	public void setItemCache(Item itemCache) {
		System.out.println("[:Robot].setItemCache");
		this.itemCache = itemCache;
	}

	public boolean getOnOil() {
		System.out.println("[:Robot].getOnOil()");
		return onOil;
	}

	public void setOnOil(boolean onOil) {
		System.out.println("[:Robot].setOnOil()");
		this.onOil = onOil;
	}
}
