public abstract class Airplane {
    private String model;
    private String companyName;
    private int enginePower;
    private int capacity;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(int enginePower) {
        this.enginePower = enginePower;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public abstract void fly();

    public void landing() {
        System.out.println("airplane has landed.");
    }

    public void calculateMaxSpeed(int enginePower) {
        System.out.println(enginePower*10);
    }

    public void calculateMaxSpeed(int enginePower, int capacity) {
        System.out.println(enginePower*capacity*10);
    }

}
