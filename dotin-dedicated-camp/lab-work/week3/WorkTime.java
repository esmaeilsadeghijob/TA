public class WorkTime extends Person2 {

    public int tax (int salary){
        return 20 + super.getSalary();
    }

    public int salary(int salary) {
        return salary - tax(5000);
    }

}