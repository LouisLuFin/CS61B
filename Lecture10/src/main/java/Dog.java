import java.util.Comparator;

public class Dog implements Comparable<Dog>{
    private final String name;
    private final int size;

    public Dog(String n,int s){
        name=n;
        size=s;
    }

    public void bark(){
        System.out.println(name+" says: bark");
    }

    //Returns -1 if this dog is less than pointed by o dog
    public int compareTo(Dog dda){
        return this.size-dda.size;
    }

    private static class NameComparator implements Comparator<Dog>{
        public int compare(Dog a, Dog b)
        {
            return a.name.compareTo(b.name);
        }
    }

    public static Comparator<Dog> getNameComparator(){
        return new NameComparator();
    }

}
