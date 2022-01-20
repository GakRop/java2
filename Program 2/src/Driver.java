/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gakroppongi
 */
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.*;
public class Driver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        // TODO code application logic here
        //reads the file
        File temperature = new File("temperature_anomaly.csv");
        File sea_level = new File("sea_level.csv");
        File co2 = new File("co2.csv");
        
        BufferedReader temper = new BufferedReader(new FileReader(temperature));
        BufferedReader sea = new BufferedReader(new FileReader(sea_level));
        BufferedReader CO2 = new BufferedReader(new FileReader(co2));
        
        temper.readLine();
        sea.readLine();
        CO2.readLine();
        
        String str;
        
        RedBlackTree rbtt1 = new RedBlackTree(); //rbtt1 tree = the RBT with key of temp anomaly
        RedBlackTree rbts1 = new RedBlackTree(); //rbts1 tree = the RBT with key of the sea level rise
        RedBlackTree rbtc1 = new RedBlackTree(); //rbtc1 tree = the RBT with key of the CO2 conc
        RedBlackTree rbtt2 = new RedBlackTree(); //rbtt2 tree = the RBT with key of date for temp anomaly
        RedBlackTree rbts2 = new RedBlackTree(); //rbts2 tree = the RBT with key of date for sea level rise
        RedBlackTree rbtc2 = new RedBlackTree(); //rbtc2 tree = the RBT with key of date for CO2 conc
        
        //key in rbtt1, rbts1 and rbtc1 is the temp, sea level, and CO2
        //data1 in rbtt1, rbts1 and rbtc1 is the entity
        //data2 in rbtt1, rbts1 and rbtc1 is the date

        //split the lines by comma and call the put function
        while((str = temper.readLine()) != null)
        {
            String[] splited = str.split(",");
            String entity = splited[0];
            String date = splited[2];
            double anomaly = Double.parseDouble(splited[3]);

            Date d1 = new Date();
            String day = d1.Date(date);
            //System.out.println(day);

            anomaly = anomaly * 1.8;
            
            if (entity.equals("World"))
            {
                //System.out.println("entity:"+entity+" date: "+date+" anomaly: "+anomaly);
                rbtt1.put(anomaly, entity, day);
                rbtt2.put(day, anomaly, entity);
            }
        }
        
        while((str = sea.readLine()) != null)
        {
            String[] splited = str.split(",");
            String entity = splited[0];
            String date = splited[2];
            double average_rise = Double.parseDouble(splited[3]);

            Date d1 = new Date();
            String day = d1.Date(date);
        
            if (entity.equals("World"))
            {
                //System.out.println("entity:"+entity+" date: "+date+" average_rise: "+average_rise);
                rbts1.put(average_rise, entity, day);
                rbts2.put(day, average_rise, entity);
            }
        }
        
        while((str = CO2.readLine()) != null)
        {
            String[] splited = str.split(",");
            String entity = splited[0];
            String date = splited[2];
            double average_conc = Double.parseDouble(splited[3]);

            Date d1 = new Date();
            String day = d1.Date(date);
        
            if (entity.equals("World"))
            {
                //System.out.println("entity:"+entity+" date: "+date+" average_conc: "+average_conc);
                rbtc1.put(average_conc, entity, day);
                rbtc2.put(day, average_conc, entity);
            }
        }

        //search for the largest and smallest value
        double lowestTemp = rbtt1.getMin();
        double highestTemp = rbtt1.getMax();
        double lowestSeaRise = rbts1.getMin();
        double highestSeaRise = rbts1.getMax();
        double lowestCO2 = rbtc1.getMin();
        double highestCO2 = rbtc1.getMax();

        //search for the date of the largest and smallest value
        Object dateOfLowestTemp = rbtt1.getDate(lowestTemp);
        Object dateOfHighestTemp = rbtt1.getDate(highestTemp);
        Object dateOfLowestSea = rbts1.getDate(lowestSeaRise);
        Object dateOfHighestSea = rbts1.getDate(highestSeaRise);
        Object dateOfLowestCO2 = rbtc1.getDate(lowestCO2);
        Object dateOfHighestCO2 = rbtc1.getDate(highestCO2);

        String lowestTempDate = dateOfLowestTemp.toString();
        String highestTempDate = dateOfHighestTemp.toString();
        String lowestSeaDate = dateOfLowestSea.toString();
        String highestSeaDate = dateOfHighestSea.toString();
        String lowestCO2Date = dateOfLowestCO2.toString();
        String highestCO2Date = dateOfHighestCO2.toString();

        //search for the data on the same date for the largest and smallest data
        Object seaOfLowestTemp = rbts2.getData(lowestTempDate);
        Object co2OfLowestTemp = rbtc2.getData(lowestTempDate);
        Object seaOfHighestTemp = rbts2.getData(highestTempDate);
        Object co2OfHighestTemp = rbtc2.getData(highestTempDate);
        Object tempOfLowestSea = rbtt2.getData(lowestSeaDate);
        Object co2OfLowestSea = rbtc2.getData(lowestSeaDate);
        Object tempOfHighestSea = rbtt2.getData(highestSeaDate);
        Object co2OfHighestSea = rbtc2.getData(highestSeaDate);
        Object tempOfLowestCO2 = rbtt2.getData(lowestCO2Date);
        Object seaOfLowestCO2 = rbts2.getData(lowestCO2Date);
        Object tempOfHighestCO2 = rbtt2.getData(highestCO2Date);
        Object seaOfHighestCO2 = rbts2.getData(highestCO2Date);

        //print out the largest and smallest data
        //and the data on the same day if existing
        System.out.println("Lowest Temperature anomaly (F): "+lowestTemp+" on "+ dateOfLowestTemp);

        if (seaOfLowestTemp != null)
            System.out.println("On the same date, the sea level rise was: " + seaOfLowestTemp);

        if (co2OfLowestTemp != null)
            System.out.println("On that same date, the Average Co2 concentration was: "+co2OfLowestTemp);
        
        System.out.println("\nHighest Temperature anomaly (F): "+highestTemp+" on "+ dateOfHighestTemp);

        if (seaOfHighestTemp != null)
            System.out.println("On the same date, the sea level rise was: "+seaOfHighestTemp);

        if (co2OfHighestTemp != null)
            System.out.println("On that same date, the Average Co2 concentration was: "+co2OfHighestTemp);
        
        
        System.out.println("\nLowest Sea Level Rise: "+lowestSeaRise+" on "+ dateOfLowestSea);

        if (tempOfLowestSea != null)
            System.out.println("On that same date, the Temperature Anomaly (F) was: "+tempOfLowestSea);

        if (co2OfLowestSea != null)
            System.out.println("On that same date, the Average Co2 concentration was: "+co2OfLowestSea);
        
        System.out.println("\nHighest Sea Level Rise: "+highestSeaRise+" on "+ dateOfHighestSea);

        if (tempOfHighestSea != null)
            System.out.println("On that same date, the Temperature Anomaly (F) was: "+tempOfHighestSea);

        if (co2OfHighestSea != null)
            System.out.println("On that same date, the Average Co2 concentration was: "+co2OfHighestSea);
        
        System.out.println("\nLowest Average Co2 concentration: "+lowestCO2+" on "+ dateOfLowestCO2);

        if (tempOfLowestCO2 != null)
            System.out.println("On that same date, the Temperature Anomaly (F) was: "+tempOfLowestCO2);

        if (seaOfLowestCO2 != null)
            System.out.println("On the same date, the sea level rise was: "+seaOfLowestCO2);
        
        System.out.println("\nHighest Average Co2 concentration: "+highestCO2+" on "+ dateOfHighestCO2);

        if (tempOfHighestCO2 != null)
            System.out.println("On that same date, the Temperature Anomaly (F) was: "+tempOfHighestCO2);

        if (seaOfHighestCO2 != null)
            System.out.println("On the same date, the sea level rise was: "+seaOfHighestCO2);
    }
}

/*
Lowest Temperature anomaly (F): -1.48 on Dec 15, 1916

Highest Temperature anomaly (F): 2.47 on Feb 15, 2016
On that same date, the Average Co2 concentration was 403.27

Lowest Sea Level Rise: -204.38073 on Jan 15, 1883
On that same date, the Temperature Anomaly (F) was -0.50

Highest Sea Level Rise: 68.81163 on Jan 15, 2020
On that same date, the Temperature Anomaly (F) was 2.09
On that same date, the Average Co2 concentration was 412.43

Lowest Average Co2 concentration: 337.05 on Sep 15, 1980
On that same date, the Temperature Anomaly (F) was 0.36

Highest Average Co2 concentration: 416.22 on May 15, 2021
On that same date, the Temperature Anomaly (F) was 1.42
*/