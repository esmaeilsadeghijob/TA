public class BMI{
	
	private float height;
	private int weight;

        public BMI(float height, int weight){

		this.height = height;
		this.weight = weight;

	}

	public void setHeight(float height){
	
		this.height = height;
	
	}

	
	private float getHeight(){

		return height;
	
	}

	public void setWeight(int weight){
	
		this.weight = weight;
	
	}

	
	private int getWeight(){

		return weight;
	
	}

	private float bodyMassIndex() {
	
		return (getWeight() / (getHeight() * getHeight()));

	}

	public void printDisplay() {
	
		System.out.printf("BMI = %.2f%n", bodyMassIndex());	

	}

}