public class RedBlackTree<Key extends Comparable<Key>, Value>{

    private static final boolean RED   = true;
    private static final boolean BLACK = false;

    private Node root;     // root of the BST

    // BST helper node data type
    //only one key is needed
    private class Node {
        private Key key;//this is the temp, co2 level etc in 1 tree, date in 2 tree
        private Value data1;//this is the entity in 1 tree, temp, co2 etc in 2 tree
        private Value data2;//this is the date in 1 tree, entity in tree 2
        private Node left, right;   //links to left and right subtrees
        private boolean color;      //color of parent link
        private int size;

        //this Node method is to make the temperature, sea leve rise or co2 level key
        //we dont need two node data attributes because the key is key anyway
        public Node(Key key, Value data1, Value data2, boolean color) {
            this.key = key;
            this.data1 = data1;
            this.data2 = data2;
            this.color = color;
        }
        
        /*
        @param get the entity and date
        set the duplicated value for a different date
        */
        public void setValues(Value data1, Value data2)
        {
            this.data1 = data1;
            this.data2 = data2;
        }
        
        public void setKey(Key key)
        {
            this.key = key;
        }
        
        public Key getKey()
        {
            return this.key;
        }
        
        public Value getData1()
        {
            return this.data1;
        }
        
        public Value getData2()
        {
            return this.data2;
        }
    }

    public RedBlackTree() {
    }

    // is node x red; false if x is null ?
    private boolean isRed(Node x) 
    {
        if (x == null) return false;
        return x.color == RED;
    }
    
    //this function is called from the Driver class
    //key is either the temp, sea level, and CO2 or the date
    //depending on which tree we implement
    public void put(Key key, Value data1, Value data2) 
    {
        //System.out.println("Key: "+key+" data1: "+data1+" data2: "+data2);
        root = put(root, key, data1, data2);
        root.color = BLACK;
    }

    //this function inserts the Node into the tree
    //we call the root h because the root of RBT in the example is called h, not x
    private Node put(Node h, Key key, Value data1, Value data2) 
    { 
        if (h == null)
        {
            return new Node(key, data1, data2, RED);
        }

        int cmp = key.compareTo(h.key);
        
        if (cmp < 0)
        {
            h.left  = put(h.left, key, data1, data2);
        }
        
        else if (cmp > 0)
        {
            h.right = put(h.right, key, data1, data2);
        }
        
        else
        {
            h.setValues(data1, data2);
        }

        // fix-up any right-leaning links
        if (isRed(h.right) && !isRed(h.left))      
        {
            h = rotateLeft(h);
        }
        
        if (isRed(h.left)  &&  isRed(h.left.left)) 
        {
            h = rotateRight(h);
        }
        
        if (isRed(h.left) && isRed(h.right))     
        {
            flipColors(h);
        }

        return h;
    }
    
    // make a left-leaning link lean to the right
    private Node rotateRight(Node h) 
    {
        assert (h != null) && isRed(h.left);
        // assert (h != null) && isRed(h.left) &&  !isRed(h.right);  // for insertion only
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = x.right.color;
        x.right.color = RED;
        return x;
    }

    // make a right-leaning link lean to the left
    private Node rotateLeft(Node h) 
    {
        assert (h != null) && isRed(h.right);
        // assert (h != null) && isRed(h.right) && !isRed(h.left);  // for insertion only
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = x.left.color;
        x.left.color = RED;
        return x;
    }

    // flip the colors of a node and its two children
    private void flipColors(Node h) 
    {
        // h must have opposite color of its two children
        // assert (h != null) && (h.left != null) && (h.right != null);
        // assert (!isRed(h) &&  isRed(h.left) &&  isRed(h.right))
        //    || (isRed(h)  && !isRed(h.left) && !isRed(h.right));
        h.color = !h.color;
        h.left.color = !h.left.color;
        h.right.color = !h.right.color;
    }
    
    /*
    @param none
    @return the smallest data
    this gets the min value in the tree
    since the min value is in the farther left child in the tree
    this goes into the left until it hits the null
    */
    public double getMin()
    {
        Key min = getMin(root);
        return convert(min);
    }
    
    public Key getMin(Node x)
    {
        if (x.left == null)
        {
            Key min = x.getKey();
            return min;
        }
        
        else
        {
            return getMin(x.left);
        }
    }
    
    /*
    @param the key (day)
    @return smallest data
    this gets the max value in the tree
    since the max value is in the farther right child in the tree
    this goes into the right until it hits the null
    */
    public double getMax()
    {
        Key max = getMax(root);
        return convert(max);
    }
    
    public Key getMax(Node x)
    {
        if (x.right == null)
        {
            Key max = x.getKey();
            return max;
        }
        
        else
        {
            return getMax(x.right);
        }
    }

    //this converts the key in to double
    public double convert(Key key)
    {
        String str = key.toString();
        return Double.parseDouble(str);
    }

    //this gets the date of the data
    //compare the size of the key and gets the value of the key
    public Value getDate(double key)
    {
        //System.out.println(root.key+" "+root.data1+" "+root.data2);
        Value date = getDate(root, key);
        //System.out.println(date);
        return date;
    }

    public Value getDate(Node x, double key)
    {
        String str = x.key.toString();
        double dob = Double.parseDouble(str);
        //System.out.println(x.key+" "+x.data1+" "+x.data2);

        if (key < dob)
        {
            return getDate(x.left, key);
        }

        else if (key > dob)
        {
            return getDate(x.right, key);
        }

        else
        {
            return x.data2;
        }
    }

    //this gets the data for the date
    //compare the size of the date and go into right and left depending on the size
    //if the data not found, it returns null
    public Value getData(String key)
    {
        //System.out.println(key);
        //System.out.println(key.getClass());
        Value data = getData(root, key);
        return data;
    }

    public Value getData(Node x, String key)
    {
        //System.out.println(x.key);
        //String str = key.toString();
        String st = x.key.toString();
        int cmp = key.compareTo(st);
        //System.out.println(cmp);

        if (cmp < 0)
        {
            if (x.left != null)
            {
                return getData(x.left, key);
            }

            else
                return null;
        }

        else if (cmp > 0)
        {
            if (x.right != null)
            {
                return getData(x.right, key);
            }

            else
                return null;
        }

        else
        {
            return x.data1;
        }
    }

    public void printInOrder()
    {
        printInOrder(root);
    }

    public void printInOrder(Node x)
    {
        if (x == null)
        {
            return;
        }

        printInOrder(x.left);
        System.out.println(x.key+" "+x.data1+" "+x.data2);
        printInOrder(x.right);
    }
}