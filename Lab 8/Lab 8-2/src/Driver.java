import java.util.Locale;

public class Driver {

    //this function returns the alphabetical order
    public static int key (String s)
    {
        if (s.equals("A"))
            return 1;

        else if (s.equals("B"))
            return 2;

        else if (s.equals("C"))
            return 3;

        else if (s.equals("D"))
            return 4;

        else if (s.equals("E"))
            return 5;

        else if (s.equals("F"))
            return 6;

        else if (s.equals("G"))
            return 7;

        else if (s.equals("H"))
            return 8;

        else if (s.equals("I"))
            return 9;

        else if (s.equals("J"))
            return 10;

        else if (s.equals("K"))
            return 11;

        else if (s.equals("L"))
            return 12;

        else if (s.equals("M"))
            return 13;

        else if (s.equals("N"))
            return 14;

        else if (s.equals("O"))
            return 15;

        else if (s.equals("P"))
            return 16;

        else if (s.equals("Q"))
            return 17;

        else if (s.equals("R"))
            return 18;

        else if (s.equals("S"))
            return 19;

        else if (s.equals("T"))
            return 20;

        else if (s.equals("U"))
            return 21;

        else if (s.equals("V"))
            return 22;

        else if (s.equals("W"))
            return 23;

        else if (s.equals("X"))
            return 24;

        else if (s.equals("Y"))
            return 25;

        else
            return 26;
    }
    public static void main(String[] args){
        //inputs
        String[] strArr = new String[10];
        strArr[0] = "E";
        strArr[1] = "A";
        strArr[2] = "S";
        strArr[3] = "Y";
        strArr[4] = "Q";
        strArr[5] = "U";
        strArr[6] = "T";
        strArr[7] = "I";
        strArr[8] = "O";
        strArr[9] = "N";

        //declare the new hashcode symbol map
        SeparateHashChainingST shc = new SeparateHashChainingST();

        //reads the input arrays and assign the alphabetical order
        //gives the alphabetical order to get the hashcode
        //then puts the alphabet as the key and the order of insertion as the value
        for (int i = 0; i < strArr.length; i++)
        {
            int alphabeticalOrder = key(strArr[i]);
            int hashcode = shc.hash(alphabeticalOrder);
            shc.put(strArr[i], hashcode, i);
        }

        //reads in the input and reassigns the alphabetical order
        //and a hashcode. then looks for the order of insertion(key)
        //that is corresponding to the key
        //has to get the order of insertion as the value
        //from the inserted alphabet as the key
        //then prints out the hashcode, the key, and the value
        for (int j = 0; j < strArr.length; j++)
        {
            String key = strArr[j];
            int alphabeticalOrder = key(strArr[j]);
            int hashcode = shc.hash(alphabeticalOrder);
            //System.out.println(j);
            Object val = shc.get(hashcode, key);
            System.out.println("hashcode: "+hashcode);
            System.out.println("key: "+key);
            System.out.println("value: "+val+"\n");
        }
    }
}
/*
write a separate chaining hash symbol table class with the constructor,
put(), get(), and hash(). Insert the keys EASYOUTION in that order
into an initially empty table of M = 5 lists using separate chaining.
For a value, assign a number to each letter as it is read in.
Use the hash function 11 * k % M to transform the k-th letter of the alphabet
into a table index. You must write your own class or use another.
You must print out the hash value along with the character and its value.
You can do this by creating a method
inside your SeparateChaining has symbol table to show all keys/values.
 */
