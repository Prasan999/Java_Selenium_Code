package com.test;

//Online Java Compiler
//Use this editor to write, compile and run your Java code online
import java.util.*;

public class StringOperations {
	public static void main(String[] args) {
		System.out.println("Try programiz.pro");
		String str="tHi$ iS A jAVa pROgramM foR BeGinnERs iN te$TiNg";
		str=str.toLowerCase();
		System.out.println(str);
		System.out.println(str.replaceAll("\\s",""));

		char[] chArray= str.toCharArray();

		HashMap<Character,Integer> charCount = new HashMap<Character,Integer>();
		List<Character>  strWithoutDuplicates= new ArrayList<Character>();
		for(char c: chArray){

			if(c!=' '){

				charCount.put(c,charCount.getOrDefault(c,0)+1);

			}
		}

		for (Map.Entry m: charCount.entrySet()){
			//System.out.println("Count Character Duplicate "+m.getKey()+"= :"+m.getValue());


		}

		for(char chh : chArray){

			if(chh!=' ' && !strWithoutDuplicates.contains(chh)){
				strWithoutDuplicates.add(chh);
			}
		}

		// for(String s:strWithoutDuplicates )
		//System.out.print("strWithoutDuplicates.."+s);
		Iterator iter = strWithoutDuplicates.iterator();
		while (iter.hasNext()) {
			System.out.print(iter.next());
		}

	}


}

