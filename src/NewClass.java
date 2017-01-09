
import java.text.DecimalFormat;
import java.text.NumberFormat;
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
      int starget = rand.nextInt(sum-1);
      System.out.print(sum-1);
      sum =0;
    // int starget= 65;
    while (sum != starget) 
    {
      // Print combination
        boolean isNULL = true;
      for (int i = 0; i < counter.length; i++) {
        if (counter[i] == 1)
        {
          System.out.print(arr[i] + ",");
        sum = sum + arr[i];
        isNULL = false;

        }
      }
       if (isNULL == false) {
	System.out.print("     ");
	System.out.print("sum of this subset is ");
        System.out.print(" {"+ sum + "} ");
        
        if((sum == starget))
        {
        System.out.print(" is equals to target");
        sum = starget;
        }
        else{
        System.out.print(" ");
        sum = 0;
        }
        long endTime = System.nanoTime();
        
        // System.out.print("\n timing is = "+ startTime);
        }
 
      
      System.out.println();
      
      // Increment counter
      int i = 0;
      while (i < counter.length && counter[i] == 1)
        counter[i++] = 0;
      if (i == counter.length)
          
        break;
      counter[i] = 1;
      System.out.print(" checking...  ");
      
     
     
    }
     
  }
 public static void settarget(int[] arr)
 {
    
     
        //long startTime = System.nanoTime();
       // NumberFormat formatter = new DecimalFormat("#000.00");
      //  System.out.print(" " + formatter.format((startTime-endTime) / 3600) + "");
 }
public static void main(String[] arr){ 
        int[] a = {1,2,3,4,5,6,7,8,9,10,11,12,13};
         printAllSubsets(a);
        
}
}