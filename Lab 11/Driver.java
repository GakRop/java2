import java.util.Iterator;

public class Driver {

    public static void main(String[] args) {

        Bag bag = new Bag();
        bag.add("a");
        bag.add("b");
        bag.add("c");
        bag.add("d");
        bag.add("e");

        Iterator item = bag.iterator();

        while (item.hasNext())
        {
            System.out.println(item.next());
        }
    }
}
