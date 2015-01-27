package standard_deviation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 *
 * @author Noah Abdelguerfi
 * @date 1/25/15
 */
public class StandardDeviation {

    
    private static ArrayList<Double> numbers = new ArrayList<Double>(); //stores ArrayList of numbers
    private static Scanner input = new Scanner(System.in); //take input for the command line
    double number;
    
    /**
     * Computes the mean of a ArrayList
     * @return mean
     */   
    private static double mean(){
        
        double sum = 0;
        
        for (Double d : numbers){   // add all numbers in the ArrayList
            sum += d;
        }
        
        final double mean = sum / numbers.size(); // compute the mean
        
        return mean;
    }
    /**
     * Computes the standard deviation of an ArrayList of numberws
     * @param mean
     * @return standard deviation
     */
    private static double standardDeviation(double n){
        
        double sum = 0;
        double number = 0;
        double standard_deviation = 0;
        
        for(Double d: numbers){        
            number = Math.pow((d - n), 2); //subtract the mean from each value in the ArrayList
            sum += number; //add up each new value
        }
        standard_deviation = Math.sqrt(sum/(numbers.size() - 1)); //find the sqare root of the sum/size of the ArrayList
        
        return standard_deviation;     
    }
  /**
   * computes the occurrence of each number
   * @param list
   */  
  private static void numberFrequency(ArrayList<Double> list)  {

    HashMap<Double, Integer> map = new HashMap();
    
    for(Double d: list){ //interate through the hashmap
        
        if(map.containsKey(d)){
            map.put(d, map.get(d) + 1); //increment the value if each time a number occurs after the first
        }else if(!map.containsKey(d)){
            map.put(d, 1); //assign the value 1 the first time the number occurs
        }
    }
    
    Entry<Double,Integer> maxEntry = null;
    
    for (Map.Entry<Double, Integer> entry : map.entrySet()) { //iterate through the hashmap
        
        
        System.out.println(entry.getKey()+" : "+entry.getValue()); //print out the frequencies of each number
        
        if (maxEntry == null || entry.getValue() >= maxEntry.getValue()) {
        maxEntry = entry;
        }
    
    }     
}
    /**
     * computes the median of a ArrayList of numbers
     * @return median
     */
    private static double median(){
        if(numbers.size() % 2 == 1){
           int i =  numbers.size() / 2;       //number is odd take the middle value
           double median = numbers.get(i);
           return median;
        }           
        else if(numbers.size() % 2 == 0){
            int i = numbers.size() / 2;     //takes the 2 middle value and average them
            double median = (numbers.get(i - 1) + numbers.get(i)) / 2;
            return median;
        }
        
        else{
            System.out.println("Something went wrong");
        }
        
        return 0;
    }
    /**
     * method prints out user instructions
     * takes the number from the command line
     * sort the ArrayList from least to greatest
     * calls methods mean, standardDeviation, and median. Then prints out the results
     */
    public static void main(){
        System.out.println("Enter numbers to compute the mean, median, standard deviation, and the frequency of each number. Type numbers separted by spaces.");
        
        String value = input.nextLine();
        
        String [] number = value.split(" "); //append user input on spaces
        
        for(String s: number){
            double n = Double.parseDouble(s);  //parse input to doubles
            numbers.add(n); //add input to numbers ArrayList
        }
        
        Collections.sort(numbers); //sort ArrayList
           
        double i = mean();
        double standard_deviation = standardDeviation(i);
        double median = median();    
        numberFrequency(numbers);
    
        //print out results of method calls
        System.out.println("The median is: " + median);
        System.out.println("The mean is: " + i );
        System.out.println("The standard deviation is: " + standard_deviation);
    }


    public static void main(String[] args) {
       
         main();

        
        
    }//end of main method
    
}//end of class StandardDeviation
