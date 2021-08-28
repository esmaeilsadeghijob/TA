import java.util.List;

public class City {

    private String name;
    private int population;
    private List<Person> personList;

    static class Person {

        private String name;
        private String family;
        private int age;
        private String address;


        public Person() {
        }

        public Person(String name, String family, int age, String address) {
            this.name = name;
            this.family = family;
            this.age = age;
            this.address = address;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getFamily() {
            return family;
        }

        public void setFamily(String family) {
            this.family = family;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }
    }

    public City() {
    }

    public City(String name, int population, List<Person> personList) {
        this.name = name;
        this.population = population;
        this.personList = personList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    public int getPopulation() {
        return population;
    }
}

