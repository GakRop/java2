import java.util.ArrayList;
import java.util.function.IntFunction;

public class Graph extends ArrayList {
    int M;
    ArrayList<LinkedList> arrayList = new ArrayList<LinkedList>(M);

    @Override
    public Object[] toArray(IntFunction generator) {
        return super.toArray(generator);
    }

    //node class to declare the nodes
    public class Node {
        private String vertex;
        private Node next;
        private String state;
        private int label;

        public Node(String vertex) {
            this.vertex = vertex;
        }

        public Node(String state, int label)
        {
            this.state = state;
            this.label = label;
        }

        public String getstring()
        {
            return this.state;
        }

        public int getLabel()
        {
            return this.label;
        }
    }

    //initiate the linked lists for each arraylist element
    LinkedList alabama = new LinkedList();
    LinkedList arizona = new LinkedList();
    LinkedList arkansas = new LinkedList();
    LinkedList california = new LinkedList();
    LinkedList colorado = new LinkedList();
    LinkedList delaware = new LinkedList();
    LinkedList florida = new LinkedList();
    LinkedList georgia = new LinkedList();
    LinkedList idaho = new LinkedList();
    LinkedList illinois = new LinkedList();
    LinkedList indiana = new LinkedList();
    LinkedList iowa = new LinkedList();
    LinkedList kansas = new LinkedList();
    LinkedList kentucky = new LinkedList();
    LinkedList louisiana = new LinkedList();
    LinkedList maryland = new LinkedList();
    LinkedList massachusetts = new LinkedList();
    LinkedList michigan = new LinkedList();
    LinkedList minnesota = new LinkedList();
    LinkedList mississippi = new LinkedList();
    LinkedList missouri = new LinkedList();
    LinkedList montana = new LinkedList();
    LinkedList nebraska = new LinkedList();
    LinkedList nevada = new LinkedList();
    LinkedList newjersey = new LinkedList();
    LinkedList newmexico = new LinkedList();
    LinkedList newyork = new LinkedList();
    LinkedList northcarolina = new LinkedList();
    LinkedList northdakota = new LinkedList();
    LinkedList ohio = new LinkedList();
    LinkedList oklahoma = new LinkedList();
    LinkedList oregon = new LinkedList();
    LinkedList pennsylvania = new LinkedList();
    LinkedList rhodeisland = new LinkedList();
    LinkedList southdakota = new LinkedList();
    LinkedList tennessee = new LinkedList();
    LinkedList texas = new LinkedList();
    LinkedList utah = new LinkedList();
    LinkedList vermont = new LinkedList();
    LinkedList virginia = new LinkedList();
    LinkedList washington = new LinkedList();
    LinkedList westvirginia = new LinkedList();
    LinkedList wisconsin = new LinkedList();
    LinkedList wyoming = new LinkedList();
    LinkedList connecticut = new LinkedList();
    LinkedList newhampshire = new LinkedList();
    LinkedList maine = new LinkedList();
    LinkedList southcarolina = new LinkedList();

    public Graph(int M) {
        this.M = M;
    }

    /*
    this adds the vertex to the right linked list
    compares the vertex string to the linked list name
    and add the string into the linked list
    and store the linked list in the arraylist
     */
    public void addVertex(String vertex) {
        boolean b = check(vertex);

        if (b == true) {
            Node temp = new Node(vertex);

            if (vertex.equals("Alabama")) {
                alabama.insert(vertex);
                arrayList.add(alabama);
            } else if (vertex.equals("Arizona")) {
                arizona.insert(vertex);
                arrayList.add(arizona);
            } else if (vertex.equals("Arkansas")) {
                arkansas.insert(vertex);
                arrayList.add(arkansas);
            } else if (vertex.equals("California")) {
                california.insert(vertex);
                arrayList.add(california);
            } else if (vertex.equals("Colorado")) {
                colorado.insert(vertex);
                arrayList.add(colorado);
            } else if (vertex.equals("Delaware")) {
                delaware.insert(vertex);
                arrayList.add(delaware);
            } else if (vertex.equals("Florida")) {
                florida.insert(vertex);
                arrayList.add(florida);
            } else if (vertex.equals("Georgia")) {
                georgia.insert(vertex);
                arrayList.add(georgia);
            } else if (vertex.equals("Idaho")) {
                idaho.insert(vertex);
                arrayList.add(idaho);
            } else if (vertex.equals("Illinois")) {
                illinois.insert(vertex);
                arrayList.add(illinois);
            } else if (vertex.equals("Indiana")) {
                indiana.insert(vertex);
                arrayList.add(indiana);
            } else if (vertex.equals("Iowa")) {
                iowa.insert(vertex);
                arrayList.add(iowa);
            } else if (vertex.equals("Kansas")) {
                kansas.insert(vertex);
                arrayList.add(kansas);
            } else if (vertex.equals("Kentucky")) {
                kentucky.insert(vertex);
                arrayList.add(kentucky);
            } else if (vertex.equals("Louisiana")) {
                louisiana.insert(vertex);
                arrayList.add(louisiana);
            } else if (vertex.equals("Maryland")) {
                maryland.insert(vertex);
                arrayList.add(maryland);
            } else if (vertex.equals("Massachusetts")) {
                massachusetts.insert(vertex);
                arrayList.add(massachusetts);
            } else if (vertex.equals("Michigan")) {
                michigan.insert(vertex);
                arrayList.add(michigan);
            } else if (vertex.equals("Minnesota")) {
                minnesota.insert(vertex);
                arrayList.add(minnesota);
            } else if (vertex.equals("Mississippi")) {
                mississippi.insert(vertex);
                arrayList.add(mississippi);
            } else if (vertex.equals("Missouri")) {
                missouri.insert(vertex);
                arrayList.add(missouri);
            } else if (vertex.equals("Montana")) {
                montana.insert(vertex);
                arrayList.add(montana);
            } else if (vertex.equals("Nebraska")) {
                nebraska.insert(vertex);
                arrayList.add(nebraska);
            } else if (vertex.equals("Nevada")) {
                nevada.insert(vertex);
                arrayList.add(nevada);
            } else if (vertex.equals("NewJersey")) {
                newjersey.insert(vertex);
                arrayList.add(newjersey);
            } else if (vertex.equals("NewMexico")) {
                newmexico.insert(vertex);
                arrayList.add(newmexico);
            } else if (vertex.equals("NewYork")) {
                newyork.insert(vertex);
                arrayList.add(newyork);
            } else if (vertex.equals("NorthCarolina")) {
                northcarolina.insert(vertex);
                arrayList.add(northcarolina);
            } else if (vertex.equals("NorthDakota")) {
                northdakota.insert(vertex);
                arrayList.add(northdakota);
            } else if (vertex.equals("Ohio")) {
                ohio.insert(vertex);
                arrayList.add(ohio);
            } else if (vertex.equals("Oklahoma")) {
                oklahoma.insert(vertex);
                arrayList.add(oklahoma);
            } else if (vertex.equals("Oregon")) {
                oregon.insert(vertex);
                arrayList.add(oregon);
            } else if (vertex.equals("Pennsylvania")) {
                pennsylvania.insert(vertex);
                arrayList.add(pennsylvania);
            } else if (vertex.equals("RhodeIsland")) {
                rhodeisland.insert(vertex);
                arrayList.add(rhodeisland);
            } else if (vertex.equals("SouthDakota")) {
                southdakota.insert(vertex);
                arrayList.add(southdakota);
            } else if (vertex.equals("Tennessee")) {
                tennessee.insert(vertex);
                arrayList.add(tennessee);
            } else if (vertex.equals("Texas")) {
                texas.insert(vertex);
                arrayList.add(texas);
            } else if (vertex.equals("Utah")) {
                utah.insert(vertex);
                arrayList.add(utah);
            } else if (vertex.equals("Vermont")) {
                vermont.insert(vertex);
                arrayList.add(vermont);
            } else if (vertex.equals("Virginia")) {
                virginia.insert(vertex);
                arrayList.add(virginia);
            } else if (vertex.equals("Washington")) {
                washington.insert(vertex);
                arrayList.add(washington);
            } else if (vertex.equals("WestVirginia")) {
                westvirginia.insert(vertex);
                arrayList.add(westvirginia);
            } else if (vertex.equals("Wisconsin")) {
                wisconsin.insert(vertex);
                arrayList.add(wisconsin);
            } else if (vertex.equals("Wyoming")) {
                wyoming.insert(vertex);
                arrayList.add(wyoming);
            } else if (vertex.equals("Connecticut")) {
                connecticut.insert(vertex);
                arrayList.add(connecticut);
            } else if (vertex.equals("NewHampshire")) {
                newhampshire.insert(vertex);
                arrayList.add(newhampshire);
            } else if (vertex.equals("SouthCarolina")) {
                southcarolina.insert(vertex);
                arrayList.add(southcarolina);
            } else if (vertex.equals("Maine")) {
                maine.insert(vertex);
                arrayList.add(maine);
            }
        }
    }

    /*
    receives the input of the vertex and the edge
    look for the same vertex and insert the edge in the linked list
     */
    public void addEdge(String vertex, String edge) {
        if (vertex.equals("Alabama")) {
            alabama.insert(edge);
        } else if (vertex.equals("Arizona")) {
            arizona.insert(edge);
        } else if (vertex.equals("Arkansas")) {
            arkansas.insert(edge);
        } else if (vertex.equals("California")) {
            california.insert(edge);
        } else if (vertex.equals("Colorado")) {
            colorado.insert(edge);
        } else if (vertex.equals("Delaware")) {
            delaware.insert(edge);
        } else if (vertex.equals("Florida")) {
            florida.insert(edge);
        } else if (vertex.equals("Georgia")) {
            georgia.insert(edge);
        } else if (vertex.equals("Idaho")) {
            idaho.insert(edge);
        } else if (vertex.equals("Illinois")) {
            illinois.insert(edge);
        } else if (vertex.equals("Indiana")) {
            indiana.insert(edge);
        } else if (vertex.equals("Iowa")) {
            iowa.insert(edge);
        } else if (vertex.equals("Kansas")) {
            kansas.insert(edge);
        } else if (vertex.equals("Kentucky")) {
            kentucky.insert(edge);
        } else if (vertex.equals("Louisiana")) {
            louisiana.insert(edge);
        } else if (vertex.equals("Maryland")) {
            maryland.insert(edge);
        } else if (vertex.equals("Massachusetts")) {
            massachusetts.insert(edge);
        } else if (vertex.equals("Michigan")) {
            michigan.insert(edge);
        } else if (vertex.equals("Minnesota")) {
            minnesota.insert(edge);
        } else if (vertex.equals("Mississippi")) {
            mississippi.insert(edge);
        } else if (vertex.equals("Missouri")) {
            missouri.insert(edge);
        } else if (vertex.equals("Montana")) {
            montana.insert(edge);
        } else if (vertex.equals("Nebraska")) {
            nebraska.insert(edge);
        } else if (vertex.equals("Nevada")) {
            nevada.insert(edge);
        } else if (vertex.equals("NewJersey")) {
            newjersey.insert(edge);
        } else if (vertex.equals("NewMexico")) {
            newmexico.insert(edge);
        } else if (vertex.equals("NewYork")) {
            newyork.insert(edge);
        } else if (vertex.equals("NorthCarolina")) {
            northcarolina.insert(edge);
        } else if (vertex.equals("NorthDakota")) {
            northdakota.insert(edge);
        } else if (vertex.equals("Ohio")) {
            ohio.insert(edge);
        } else if (vertex.equals("Oklahoma")) {
            oklahoma.insert(edge);
        } else if (vertex.equals("Oregon")) {
            oregon.insert(edge);
        } else if (vertex.equals("Pennsylvania")) {
            pennsylvania.insert(edge);
        } else if (vertex.equals("RhodeIsland")) {
            rhodeisland.insert(edge);
        } else if (vertex.equals("SouthDakota")) {
            southdakota.insert(edge);
        } else if (vertex.equals("Tennessee")) {
            tennessee.insert(edge);
        } else if (vertex.equals("Texas")) {
            texas.insert(edge);
        } else if (vertex.equals("Utah")) {
            utah.insert(edge);
        } else if (vertex.equals("Vermont")) {
            vermont.insert(edge);
        } else if (vertex.equals("Virginia")) {
            virginia.insert(edge);
        } else if (vertex.equals("Washington")) {
            washington.insert(edge);
        } else if (vertex.equals("WestVirginia")) {
            westvirginia.insert(edge);
        } else if (vertex.equals("Wisconsin")) {
            wisconsin.insert(edge);
        } else if (vertex.equals("Wyoming")) {
            wyoming.insert(edge);
        } else if (vertex.equals("Connecticut")) {
            connecticut.insert(edge);
        } else if (vertex.equals("NewHampshire")) {
            newhampshire.insert(edge);
        } else if (vertex.equals("SouthCarolina")) {
            southcarolina.insert(edge);
        } else if (vertex.equals("Maine")) {
            maine.insert(edge);
        }
    }

    /*
    prints out the arraylist
    by calling the print method in linked list
     */
    public void print() {
        for (int i = 0; i < arrayList.size(); i++) {
            LinkedList temp = arrayList.get(i);
            String vertex = temp.print();
            System.out.println(vertex);
        }
    }

    /*
    checks if the vertex is duplicated or not
    if not, returns true and adds the vertex in the arraylist
     */
    public boolean check(String str) {
        //System.out.println("checked: "+str);
        boolean b = true;
        for (int i = 0; i < arrayList.size(); i++) {
            if (str.equals(arrayList.get(i).getString())) {
                b = false;
            }
        }
        return b;
    }

    //this method searches the states that are
    //two or three edges away from Montana
    public void breadthFirstSearch() {
        //arr contains the direct neighbors of montana
        //q contains the visited states like the boolean array
        //q1 contains the Nodes that store the name of the states
        //and the distance from the starting point
        ArrayList arr = montana.traverse();
        ArrayList<String> q = new ArrayList<String>();
        ArrayList<Node> q1 = new ArrayList<Node>();
        //ArrayList<Node> q2 = new ArrayList<Node>();
        //ArrayList<Node> q3 = new ArrayList<Node>();
        //LinkedList ll = montana;
        Node temp = new Node("Montana", 0);
        q.add("Montana");
        q1.add(temp);


        //this for loop investigates the states in the graph
        //that are two edges away from Montana
        //the linked list called montana is investigated and returned as an arraylist
        //the arraylist returned contains the same information as the linked list contains
        //the arraylist is investigated to see if there is a linked list in the graph
        //that has the same name
        //if so, takes the name of the linked list and see if that is already visited or not
        //if not stored in q1
        //this linked list is then investigated to have the arraylist as well
        //see if there is a linked list with the same name ...
        //repeat this until we reach the states that are two or three edges away from the start point
        //the problem is that this should definitely be written in recursion or simple loop function
        //so that it can work in any situation where we are asked to reach random numbers of states away
        for (int i = 0; i < arr.size(); i++) {
            for (int j = 0; j < arrayList.size(); j++) {
                if (arrayList.get(j).getString().equals(arr.get(i).toString())) {
                    LinkedList ll = arrayList.get(j);
                    //arr2 contains the neighbors of direct neighbors of montana
                    ArrayList arr2 = ll.traverse();
                    if (!q.contains(arr2.get(0).toString())) {
                        Node temp2 = new Node(arr2.get(0).toString(), 1);
                        q1.add(temp2);
                        q.add(arr2.get(0).toString());
                    }
                }
            }
        }

        for (int i = 0; i < arr.size(); i++) {
            for (int j = 0; j < arrayList.size(); j++) {
                if (arrayList.get(j).getString().equals(arr.get(i).toString())) {
                    LinkedList ll = arrayList.get(j);
                    //arr2 contains the neighbors of direct neighbors of montana
                    ArrayList arr2 = ll.traverse();

                    for (int a = 0; a < arr2.size(); a++) {
                        for (int b = 0; b < arrayList.size(); b++) {
                            if (arrayList.get(b).getString().equals(arr2.get(a).toString())) {
                                LinkedList ll2 = arrayList.get(b);
                                //arr3 contains the neighbors of the neighbors of the direct neighbors of montana
                                ArrayList arr3 = ll2.traverse();
                                if (!q.contains(arr3.get(0).toString())) {
                                    Node temp3 = new Node(arr3.get(0).toString(), 2);
                                    q1.add(temp3);
                                    q.add(arr3.get(0).toString());
                                }
                            }
                        }
                    }
                }
            }
        }

        for (int i = 0; i < arr.size(); i++) {
            for (int j = 0; j < arrayList.size(); j++) {
                if (arrayList.get(j).getString().equals(arr.get(i).toString())) {
                    LinkedList ll = arrayList.get(j);
                    //arr2 contains the neighbors of direct neighbors of montana
                    ArrayList arr2 = ll.traverse();

                    for (int a = 0; a < arr2.size(); a++) {
                        for (int b = 0; b < arrayList.size(); b++) {
                            if (arrayList.get(b).getString().equals(arr2.get(a).toString())) {
                                LinkedList ll2 = arrayList.get(b);
                                //arr3 contains the neighbors of the neighbors of the direct neighbors of montana
                                ArrayList arr3 = ll2.traverse();

                                for (int n = 0; n < arr3.size(); n++) {
                                    for (int m = 0; m < arrayList.size(); m++) {
                                        if (arrayList.get(m).getString().equals(arr3.get(n).toString())) {
                                            LinkedList ll3 = arrayList.get(m);
                                            //arr4 contains the neighbors of the neighbors of the neighbors of the direct neighbors of montana
                                            ArrayList arr4 = ll3.traverse();
                                            if (!q.contains(arr4.get(0).toString())) {
                                                Node temp4 = new Node(arr4.get(0).toString(), 3);
                                                q1.add(temp4);
                                                q.add(arr4.get(0).toString());
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }


        //this  prints out the states that are 2 edges away
        System.out.println("States that are 2 states away from Montana are:");
        for (int x = 0; x < q1.size(); x++)
        {
            if (q1.get(x).getLabel() == 2)
            {
                System.out.println(q1.get(x).getstring());
            }
        }

        //this prints out the states that are 3 edges away
        System.out.println(" ");
        System.out.println("States that are 3 states away from Montana are:");
        for (int x = 0; x < q1.size(); x++)
        {
            if (q1.get(x).getLabel() == 3)
            {
                System.out.println(q1.get(x).getstring());
            }
        }
    }
}