public class SeparateHashChainingST <Key extends Comparable<Key>, Value>{
    //defines the size of the hash map array
    //and declares 5 linked lists
    private int M = 5;
    LinkedList[] list = new LinkedList[M];
    LinkedList zero = new LinkedList();
    LinkedList one = new LinkedList();
    LinkedList two = new LinkedList();
    LinkedList three = new LinkedList();
    LinkedList four = new LinkedList();

    //this function gets the alphabetical order
    //and gives back the hashcode
    public int hash (int k)
    {
        int hash = 11 * k % M;
        return hash;
    }

    //this puts the key and the value in the linked list
    //via looking for the appropriate linked list
    //and call the insertion method for the linked list
    public void put(String str, int hashcode, int key)
    {
        list[0] = zero;
        list[1] = one;
        list[2] = two;
        list[3] = three;
        list[4] = four;

        //looks for the right place in the array
        //according to the hashcode
        //then calls the insertion method in the linked list
        if (hashcode == 0)
            zero.insert(str, key);

        else if (hashcode == 1)
            one.insert(str, key);

        else if (hashcode == 2)
            two.insert(str, key);

        else if (hashcode == 3)
            three.insert(str, key);

        else if (hashcode == 4)
            four.insert(str, key);
    }

    //returns the value corresponding to the key if the key is present in HT (Hast Table)
    //the key here has to be the string inserted in the list
    //the value is the insertion order of the string
    public Value get(int hashcode, Key key)
    {
        Value val = null;

        //looks for which linked list to go according to the hashcode
        //then calls the get method in the linked list class
        //then return the corresponding insertion order
        if (hashcode == 0)
            val = (Value) zero.get(key);

        else if (hashcode == 1)
            val = (Value) one.get(key);

        else if (hashcode == 2)
            val = (Value) two.get(key);

        else if (hashcode == 3)
            val = (Value) three.get(key);

        else if (hashcode == 4)
            val = (Value) four.get(key);

        return val;
    }
}
