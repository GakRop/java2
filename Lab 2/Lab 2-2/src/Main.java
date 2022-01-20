/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gakroppongi
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int sum = 0; 
        int n = 16;
        
            /*
            for (int k = n; k > 0; k /= 2)
                {System.out.println("k: "+k);
                for (int i = 0; i < k; i++) 
                {sum++;
                System.out.println("sum: "+sum);}}
            */

            ///*
            for (int i = 1; i < n; i *=2)
                for (int j = 0; j < i; j++)
                {sum++;
                System.out.println("sum: "+sum);}}
            //*/
        
            /*
            for (int i = 1; i < n; i *=2)
                {System.out.println("i: "+i);
                for (int j = 0; j < n; j++)
                {sum++;
                System.out.println("sum: "+sum);}}
            */
    }    
