import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Cars{
    //this class defines the properties of a car object
    //The car would have a name. A type. and an Id
    String name;
    String type;
    long Id;

    //a constructor with all of the fields as It's parameter
    Cars(String name, String type, long Id){
        this.name=name;
        this.type=type;
        this.Id=Id;
    }
}
// a class thet implements the comparator Inerface  to copmare their names
class NameComparator implements Comparator{
    @Override
    public int compare(Object o1, Object o2){
        // creating two objects in <<Up-To_Down>> way
        Cars c2=(Cars)o2;
        Cars c1=(Cars)o1;
        return c1.name.compareTo(c2.name);
    }
}
class TypeComparator implements Comparator{
    @Override
    public int compare(Object o1, Object o2){
        Cars c2=(Cars)o2;
        Cars c1=(Cars)o1;
        return c1.type.compareTo(c2.type);
    }
}

class Main{
    public static void main(String[] args){

        List<Cars> carslist = new ArrayList<>();
        carslist.add(new Cars("Pride","ForDie",1125412342l));
        carslist.add(new Cars("Peykan","IceAge",1244560087l));
        carslist.add(new Cars("Pezho","Sport",1111412341l));
        carslist.add(new Cars("Tiba","Ghooti",9831441244l));

        System.out.println("The cars before sorting\n\n");
        carslist.forEach((car)->System.out.println(car.name+" "+car.type+" "+car.Id));

        //Now I'm going to sort by the name
        Collections.sort(carslist, new NameComparator());

        System.out.println("\n\nThe cars after sorting by the car names\n\n");
        carslist.forEach((car)->
                System.out.println(car.name+" "+car.type+" "+car.Id));

        System.out.println("\n\nThe cars after sorting them by their type\n\n");

        //Now I'm going to sort the values by their type.
        Collections.sort(carslist,new TypeComparator());
        carslist.forEach((car)->
                System.out.println(car.name+" "+car.type+" "+car.Id));


        System.out.println("");

    }
}
