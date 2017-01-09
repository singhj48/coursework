/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sabhi
 */
public class specialCases {
    public static void sort(int[] arr,int target)
    {
         int min = 0;
    System.out.print("[");
    for(int i = 0;i<arr.length;i++)
    {
        //Assume first element is min
        min = i;
        for(int j = i + 1;j<arr.length;j++)
        {
            if(arr[j] < arr[min]) { min = j;}
        }
        int temp = arr[i];
        arr[i] = arr[min];
        arr[min] = temp;
        System.out.print(arr[i]+",");//I print the in ascending order 
    }
    System.out.print("]");  
    
    }
    public static void checkifsmall(int[] arr,int target)
    {
        if(target< arr[0])
        {
            System.out.print("\n"+target+" target is smaller then smallest value in array "+arr[0]);
        }
        else
        {
            System.out.print("target value is bigger the smallest element of array");
        }
    }
    public static void checkifbigger(int[] arr,int target)
    {
        int sum=0;
        for(int i = 0;i<arr.length;i++)
        {
            sum=sum+arr[i];
        }
        
        if(target> sum)
        {
            System.out.print("\n\n"+ target +" > target value is bigger then total sum = "+ sum);
        }
        else
        {
            System.out.print("\n\n"+ target +" < target value is smaller then total sum = "+ sum);
        }
    }
    public static void resizingarray(int[] arr,int target)
    {
        int i=0;
        int[] resized = new int[5];
        //int[]resized = {0,0,0,0,0};
        int run = 1;
        
        while(run == 1)
        {
            if(arr[i]<= target)
            {
                byte[] counter = new byte[arr.length];
     int sum = 0 ;
    // int starget= 8;
    while (sum != target) 
    {
      // Print combination
        boolean isNULL = true;
      for (int j = 0; j < counter.length; j++) {
        if (counter[j] == 1)
        {
          System.out.print(arr[j] + ",");
        sum = sum + arr[j];
        isNULL = false;

        }
      }
       if (isNULL == false) {
	System.out.print("     ");
	System.out.print("sum of this subset is ");
        System.out.print(" {"+ sum + "} ");
        if((sum == target))
        {
        System.out.print(" is equals to target");
        sum = target;
        run = 0;
        break;
        }
        else{
        System.out.print(" ");
        sum = 0;
        }
        }
 
      
      System.out.println();
      
      // Increment counter
      int j = 0;
      while (j < counter.length && counter[j] == 1)
        counter[j++] = 0;
      if (j == counter.length)
        break;
      counter[j] = 1;
     
     
    }
                //System.out.print("\n run is = "+ i);
                //resized[i] = arr[i];
                //i++;
            }
            else
            {
                run = 0;
                System.out.print("array resized ");
                for(int j = 0;j<resized.length;j++)
               {
                   
                 
                   if(resized[j] == 0)
                   {
                       break;
                   }
                   else{
                      System.out.print(resized[j]);  
                   }
               }
                 
               
            }
        }
    }
    public static void main(String args[]){
    int[] arr = {5,4,2,3,1}; // This is my array
    int target = 19;
    sort(arr,target);
   checkifsmall(arr,target);
   checkifbigger(arr,target);
   // resizingarray(arr,target);
    
}
}
