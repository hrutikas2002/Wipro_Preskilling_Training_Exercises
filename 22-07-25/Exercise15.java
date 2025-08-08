package com.wipro.basic;

//Find the pair of elements in an array that sum to a given target.
//Input: An integer array arr and a target integer target.
//Output: Indices or values of the pair of elements that sum to target. Assume one pair exists.
//Example:
//Input: arr = [2, 7, 11, 15], target = 9
//Output: [0, 1] (indices of 2 and 7)

public class Exercise15 
{
	public static void main(String[] args) {
		
		//		int[] numbers = {2, 7, 11, 15};
		//		int target = 18;
		//		
		//		for(int i = 0;i<numbers.length;i++) {
		//			for(int j = i+1;j<numbers.length;j++) {
		//				if((numbers[i]+numbers[j])==target) {
		//					System.out.println("pair of indices: "+i+", "+j);
		//				}
		//			}
		//		}

		int[] arr= {21, 17, 14, 15,19,4,5};
		int target=9;
		int[] output= {0,0};


		for(int i=0;i<arr.length;i++)
		{
			if(((i+1)<arr.length)&&(arr[i]+arr[i+1]==target))
			{


				output[0]=i;
				output[1]=i+1;
			}

		}

		System.out.println(output[0]+"-"+output[1]);
	}
}
