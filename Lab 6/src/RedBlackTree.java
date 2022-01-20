import java.util.LinkedList;
import java.util.Queue;

public class RedBlackTree<Key extends Comparable<Key>, Value> {

    private static final boolean RED   = true;
    private static final boolean BLACK = false;

    private Node root;     // root of the BST

    //defines the properties of Node
    private class Node {
        private Key key;            //key (the alphabetical order number)
        private Key var;            //key (varibale name like xvar, yvar, zvar etc)        
        private Value type;         //datatype of var
        private Value val;          //value of var
        private Node left, right;   //links to left and right subtrees
        private boolean color;      //color of parent link
        private int size;           //subtree size

        //defines the node
        public Node(Key var, Key key, Value type, Value val, boolean color, int size) {
            this.key = key;
            this.var = var;
            this.type = type;
            this.val = val;
            this.color = color;
        }
        
        //this is used to update the value of the node
        public void setValue(Value val)
        {
            this.val = val;
        }
    }

    public RedBlackTree() {
    }
    
    //this is called from the driver and calls the recurrsion function
    //by passing the root and the key
    public void get(String key) 
    {
        get(root, key);
    }

    //value associated with the given key in subtree is obtained
    //this function is a recurrsion
    //this traverse throught the tree and finds the key of a node
    //that matches the input string
    //if matched, prtints out the elements
    private void get(Node x, String key) 
    {
        if (x == null)
        {
            return;
        }
        
        get(x.left, key);
        get(x.right, key);
        
        if (key.equals(x.var.toString()))
        {
            String color = determineColor(x.color);
            System.out.println(x.var + ", " + x.type + ", " + x.val + ", " + color);
            return;
        }
    }
    
    //this function returns the color of the node only if it is red
    private boolean isRed(Node x) 
    {
        if (x == null) 
            return false;
        
        return x.color == RED;
    }
    
    //this function is called from the Driver class
    //gets the input of all the elements in a node
    //and calls the recurrsion function by passing root node
    public void put(Key var, Key key, Value type, Value val) 
    {
        root = put(root, var, key, type, val);
        root.color = BLACK;
    }

    //this function inserts the Node into the tree
    //we call the root h because the root of RBT in the example is called h, not x
    //if the traversal reaches the null node
    //it adds another node and its color is red
    //if the alphabetical order number is larger than the root, it goes right
    //if the alphabetical order number is smaller than the root, it goes left
    private Node put(Node h, Key var, Key key, Value type, Value val) 
    { 
        if (h == null)
        {
            return new Node(var, key, type, val, RED, 1);
        }

        int cmp = key.compareTo(h.key);
        
        if (cmp < 0)
        {
            h.left  = put(h.left, var, key, type, val);
        }
        
        else if (cmp > 0)
        {
            h.right = put(h.right, var, key, type, val);
        }
        
        //fix-up any right-leaning links
        //if the rightchild and the leftchild of a root are both red
        //call rotateLeft and rotate left to follow the rule
        //then change the h and x node
        if (isRed(h.right) && !isRed(h.left))      
        {
            h = rotateLeft(h);
        }
        
        //if the leftchild and leftgrandchild are both red
        //we need to fix it
        //so this calls rotateRight
        //then change the h and x node
        if (isRed(h.left)  &&  isRed(h.left.left)) 
        {
            h = rotateRight(h);
        }
        
        //if the both children are red
        //flip the color
        if (isRed(h.left) && isRed(h.right))     
        {
            flipColors(h);
        }
        
        return h;
    }
    
    //this takes the input of node that is currently being worked on
    //then declare that node as another node, x
    //then rotates the node right relative to each other
    //inherit the color of h node to x node
    //then change the color of h node
    private Node rotateRight(Node h) 
    {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = x.right.color;
        x.right.color = RED;
        return x;
    }

    //this takes the input of node that is currently being worked on
    //then declare that node as another node, x
    //then rotates the nodes left relative to each other
    //then change the color to follow the rule
    private Node rotateLeft(Node h) 
    {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = x.left.color;
        x.left.color = RED;
        return x;
    }

    //flip the colors of a node and its two children
    //this just assigns the opposite color of what the node has
    private void flipColors(Node h) 
    {
        h.color = !h.color;
        h.left.color = !h.left.color;
        h.right.color = !h.right.color;
    }
    
    //this function is called from outside to update the value
    //and calls the update function to search for the node 
    //in inorder traversal order and replace the value
    //if the var of the node matches
    public void update(Key var, Value val)
    {
        //System.out.println(root.var);
        //root.var == yvar; here
        update(root, var, val);
    }
    
    //this is the recurrsion function to update the val of node
    //if this finds the node that has the same var,
    //this updates the val of the node
    //this visits the left child of a root node x first,
    //then check if the var of node x matches the input var
    //visits the right child
    //returns and ends the recurrsion if the node is null
    public void update(Node x, Key var, Value val)
    {
        if (x == null)
        {
            return;
        }
        
        update(x.left, var, val);
        
        if (x.var.equals(var))
        {
            x.setValue(val);
        }
        
        update(x.right, var, val);   
    }
    
    //this function is called in the printInOrder function
    //this returns the color of the node as string to print out
    public String determineColor(boolean color)
    {
        if (Boolean.TRUE.equals(color))
            return "Red";
        
        else if (Boolean.FALSE.equals(color))
            return "Black";
        
        else
            return "null";
    } 
    
    //this function is called in driver
    //and creates a new Queue called queue
    //then passes the root node and the queue to keys() function
    public Queue keys()
    {
        Queue<Key> queue = new LinkedList<Key>();
        keys(root, queue);
        
        return queue;
    }
    
    //this is a recurrsion function
    //this gets the root node and a queue as an input
    //this goes through the tree in inorder traversal order
    //and adds the key to the queue
    //when it ends traversing, it returns the queue filled with all keys
    public Queue keys(Node x, Queue queue)
    {
        if (x == null)
        {
            return null;
        }
        
        keys(x.left, queue);
        queue.add(x.var);
        keys(x.right, queue);
        
        return queue;
    }
}