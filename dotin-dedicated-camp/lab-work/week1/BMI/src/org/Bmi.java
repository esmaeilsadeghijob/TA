package org;

public class Bmi{

	private float weight;
	private float height;

	public float calculateBmi(){
		float result=weight/(height*height);
		return result;	
	}
	public void setWeight(float weight){
		this.weight=weight;
	}
	public float getWeight(){
		return weight;
	}
	public void setHeight(float height){
		this.height=height;
	}
	public float getHeight(){
		return height;
	}
}