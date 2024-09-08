package com.test;

public class Test {

	public static void main (String[] s){

		int[] intArray = {21,56,89,19,99,11,101};
		int temp;

		for(int i=0;i<intArray.length;i++) {

			for(int j=i+1;j<intArray.length;j++) {

				if(intArray[i]>intArray[j]) {
					temp=intArray[i];
					intArray[i]=intArray[j];
					intArray[j]=temp;
				}

			}
			System.out.println(intArray[i]);


		}

	}
}


