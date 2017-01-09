
import java.util.Random;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**

/**
 *
 * @author Sabhi
 */
public class NewClass {
   
 public static void printAllSubsets(int[] arr) {
    byte[] counter = new byte[arr.length];
     int sum = 0 ;
      
    
     int k = 0;
    
      while (k < arr.length )
      {
         sum = sum + arr[k];  
       k++;   
      }
       Random rand = new Random();
      int starget = rand.nextInt(sum-1);// generate randon target value 
      System.out.print("target is "+starget);
      sum =0;
    // int starget= 65;
    while (sum != starget) 
    {
      // Print combination
        boolean isNULL = true;// does not allow applicaation to run any other if statement first
      for (int i = 0; i < counter.length; i++) {
        if (counter[i] == 1)
        {
          System.out.print(arr[i] + ",");// prints value 
        sum = sum + arr[i]; //generate sum of the values 
        isNULL = false;// change it to false

        }
      }
       if (isNULL == false) {// run if false
	System.out.print("     ");
	System.out.print("sum of this subset is ");
        System.out.print(" {"+ sum + "} ");
        
        if((sum == starget))// only if its equal to target
        {
        System.out.print(" is equals to target");
        sum = starget;// stops compiling
        }
        else{
        System.out.print(" ");
        sum = 0;
        }
        
        
        }
 
      
      System.out.println();
      
      // Increment counter 
      int i = 0;
      while (i < counter.length && counter[i] == 1)//work as control loop
        counter[i++] = 0;
      if (i == counter.length)
          
        break;
      counter[i] = 1;
      System.out.print(" checking...  ");
    }
     
  }
     //long startTime = System.nanoTime();
       // NumberFormat formatter = new DecimalFormat("#000.00");
      //  System.out.print(" " + formatter.format((startTime-endTime) / 3600) + "");
 
public static void main(String[] arr){ 
        int[] a = {1,2,3,4,5,6,7,8,9,10,11,12,13};// array list a can be generated with for loop better manual 
        // can be increased any time code is faxilable 
        // checks length of array a and works 
         printAllSubsets(a);
        
}
}