package com.test;

import java.util.*;

import org.checkerframework.checker.units.qual.Length;
import org.testng.annotations.Test;

public class JavaBasicPrograms {

	@Test
	public void reverseNumber() {

		int number =125,reverseNumber=0, remainder=0 ,iteration=0;//sample numbers - 45897

		while (number!=0) {

			remainder = number%10;
			reverseNumber = reverseNumber *10 + remainder ;
			number =number/10;
			// iteration++;
		}			
		//System.out.println("reverseNumber:"+reverseNumber+'\n'+"No of Iterations+iteration:"+iteration);
		System.out.println("Reverse of given Numberis =:"+reverseNumber);

	}

	//To reverse String
	@Test
	public void reverseString() {

		String str = "abcd", reverseString = "";
		char ch ;
		for (int i=0; i<str.length();i++) {

			ch = str.charAt(i);
			reverseString = ch+reverseString;
			//reverseString = str.charAt(i)+reverseString;

		}
		System.out.println("reverseString......"+reverseString);

	}
	@Test
	public void stringArrayShortestNumber() {

		String sArray[] = { "25", "21", "59", "79", "18","11","57" };
		System.out.println("before String ARray"+sArray);
		int[] intArray = new int[sArray.length];



		for (int i = 0; i < sArray.length; i++) {

			intArray[i]= Integer.parseInt(sArray[i]);
		}
		int shortNum =intArray[0] ;

		/*
		 * for (int itr :intArray ) {
		 * 
		 * if(itr < shortNum) { shortNum=itr; } }
		 */
		for(int j=0;j<intArray.length;j++) {

			if(intArray[j]< shortNum) {
				shortNum = intArray[j];

			}
		}

		System.out.println("ShortTest Number is"+shortNum);
		System.out.println("After int ARray"+Arrays.toString(intArray));
	}

	@Test
	public void stringArrayLargeNumber() {

		String sArray[] = { "25", "21", "59", "79", "18","11","57","99" };

		int[] intArray = new int[sArray.length];


		for (int i = 0; i < sArray.length; i++) {

			intArray[i]= Integer.parseInt(sArray[i]);
		}
		int largeNumber =intArray[0] ;

		/*
		 * for (int itr :intArray ) {
		 * 
		 * if(itr > largeNumber) { largeNumber =itr; } }
		 */
		for(int j=0;j<intArray.length;j++) {

			if(intArray[j] >largeNumber) {
				largeNumber = intArray[j];

			}

		}

		System.out.println("largeNumber Number is...."+largeNumber);
	}


	@Test
	public void printArrayInAscendingOrder() {

		int intArray[]= {12,5,36,7,25};
		System.out.println("Before Sorting..."+Arrays.toString(intArray));

		int temp =0;
		//int sortedArray[]= new int[intArray.length];
		for(int i=0;i<intArray.length;i++ ) {

			for (int j = i+1; j < intArray.length; j++) {   
				if(intArray[i] > intArray[j]) {  
					temp = intArray[i];  
					intArray[i] = intArray[j];  
					intArray[j] = temp;  

				}
			}
		}
		System.out.println("Sorted Array in Ascending Order.... "+Arrays.toString(intArray));
	}

	@Test
	public void printArrayInDescendingOrder() {

		int intArray[]= {12,5,36,7,25};
		System.out.println("Before Sorting..."+Arrays.toString(intArray));

		int temp =0;
		//int sortedArray[]= new int[intArray.length];
		for(int i=0;i<intArray.length;i++ ) {

			for (int j = i+1; j < intArray.length; j++) {   
				if(intArray[i] < intArray[j]) {  
					temp = intArray[i];  
					intArray[i] = intArray[j];  
					intArray[j] = temp;  

				}
			}
		}
		System.out.println("Sorted Arrayin descending order.... "+Arrays.toString(intArray));
	}

	// To remove duplicates in a String
	@Test
	public void removeDuplicate() {
		// Declaring object of Set of type String 


		String str = "Java world Hello Java ";
		String array[] = str.split(" ");
		System.out.println("Before duplicates remove" +array);
		Set<String> hs = new HashSet<String>();

		for(int i=0;i<array.length;i++) {

			hs.add(array[i]);
			System.out.println(hs);
		}

		System.out.println(hs);
		String afterDuplicateREmoved = hs.toString();
		System.out.println("afterDuplicateREmoved...."+afterDuplicateREmoved);

	} 
	@Test
	public void ArmstrongNumber() {

		double num = 157;
		int[] piArray = String.valueOf(num)
				.replaceAll("\\D", "")
				.chars()
				.map(Character::getNumericValue)
				.toArray();
		//for (int i=0;i <=num;i++);
		System.out.println(piArray);
		double mod = 3;
		String s= String.valueOf(num);
		System.out.println(s.length());

		for (int i=0;i<s.length()-2;i++) {
			char s1 = s.charAt(i);
			//double d = Double.parseDouble(s1).toString());
			//double d1= Math.pow(mod,d);
			//System.out.println(d);

		}
		double res = Math.pow(num, mod) ;
		System.out.println( res);
		/*
		 * for (int i = 0; i<s.length();i++) {
		 * 
		 * i = }
		 */

	}

	@Test
	public void ArmstrongNumber1() {

		/*
		 * Armstrong numbers 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 153, 370, 371, 407 An
		 * Armstrong number is a special kind of number in math. It's a number that
		 * equals the sum of its digits, each raised to a power. For example, if you
		 * have a number like 153,it's an Armstrong number because 1^3 + 5^3 + 3^3
		 * equals 153 ..
		 */		
		Scanner scan = new Scanner(System.in);
		int number = scan.nextInt();
		int originalNumber, remainder, result = 0;
		int n = String.valueOf(number).length();
		originalNumber = number;

		while (originalNumber != 0)
		{
			remainder = originalNumber % 10;
			result += Math.pow(remainder, n);
			originalNumber /= 10;
		}

		if(result == number)
			System.out.println(number + " is an Armstrong number.");
		else
			System.out.println(number + " is not an Armstrong number.");
	}

	/*
	 * Array -Java array is an object which contains elements of a similar data
	 * type. Additionally, The elements of an array are stored in a contiguous
	 * memory location. It is a data structure where we store similar elements. We
	 * can store only a fixed set of elements in a Java array.
	 * 
	 */

	@Test
	public void simpleIntegerArray() {

		Integer a[] = {1,4,9,13,21};
		System.out.println("Original Array "+a);
		System.out.println("Array:"+Arrays.toString(a));  
		ArrayList<Integer> arrayList = new ArrayList<Integer>(Arrays.asList(a)) ;
		ArrayList<Integer> reverseArray = new ArrayList<Integer>();
		//a = arrayList.toArray(a);  

		for (int i=arrayList.size()-1;i>=0;i--) {

			reverseArray.add(arrayList.get(i));

		}
		System.out.println("Reverse Array"+reverseArray);

		System.out.println("Reverse Array****"+reverseArray.toArray(a));

		System.out.println("Reverse Array&&&& "+a);

		/*
		 * for (int i=a.length-1;i>=0;i--) { System.out.println("Reverse Array "+a[i]);
		 * 
		 * }
		 */

	}


	// Collections
	/*
	 * Map -In Java, Map Interface is present in java.util package represents a mapping between a key and a value.
	 * Java Map interface is not a subtype of the Collection interface.
	 * A map contains values on the basis of key, i.e. key and value pair. Each key and value pair is known as an entry. A Map contains unique keys.
	 * A Map cannot contain duplicate keys and each key can map to at most one value. 
	 * Some implementations allow null key and null values like the HashMap and LinkedHashMap, but some do not like the TreeMap.
	 */


	//HashMap-	Java HashMap class implements the Map interface which allows us to store key and value pair, where keys should be unique
	@Test
	public void hashMap() {


		HashMap<Integer,String> hm = new HashMap<Integer, String>();
		hm.put(1, "A");
		hm.put(2, "B");
		hm.put(3, "C");
		hm.put(1, "AB");
		hm.put(null, "1");
		hm.put(null, null);
		/* HashMap allows multiple null keys but only allows 1 null value i.e. it
		 * overrides the previous value
		 * 
		 */

		System.out.println("HashMap" + hm);
		for(Map.Entry m : hm.entrySet()) {
			System.out.println(m.getKey()+""+m.getValue());

		}
	}

	@Test
	public void hashMap1() {

		HashMap<Integer,String> hm = new HashMap<Integer, String>();
		hm.put(1, "A");
		hm.put(2, "B");
		hm.put(3, "C");
		hm.put(1, "AB");
		System.out.println("HashMap" + hm);
		for(Map.Entry m : hm.entrySet()) {
			System.out.println(m.getKey()+""+m.getValue());

		}
	}

	/*
	 * Set- It is an unordered collection of objects in which duplicate values cannot be stored. 
	 * The set is an interface available in the java.util package.
	 * The set interface extends the Collection interface. An unordered collection
	 * or list in which duplicates are not allowed is referred to as a collection
	 * interface.
	 */

	@Test
	public void set() {

		Set<String> set = new HashSet<String>();
		set.add("ABN"); 
		set.add("DEF");
		set.add("MBD");
		set.add("ABNN");
		set.add(null);
		System.out.println(set); 

	}

	/*
	 * //List- The List interface in Java provides a way to store the ordered
	 * collection. It is a child interface of Collection. It is an ordered
	 * collection of objects in which duplicate values can be stored.
	 */

	@Test
	public void listOperations() {

		List<String> lst = new ArrayList<String>();

		//  1. Adding elements to List class using add() method
		lst.add("Hello");
		lst.add("World");
		lst.add("Java");
		lst.add(null);
		lst.add("Practice");
		lst.add("Java");
		lst.add(null);

		//2.add values at specific index
		lst.add(4,"programs");
		//In list duplicates allowed
		System.out.println("List..."+lst+'\n'+"In list duplicates allowed");

		// 3. update list elements
		lst.set(1, "Universe");
		System.out.println("AFter Updating list..."+lst+'\n'+"In list duplicates allowed");

		// 4.Searching for elements  indexOf
		int index = lst.indexOf(null);
		System.out.println("Index of given value is...."+index);

		//5.Removing Elements
		lst.remove(2);
		System.out.println("List After removing the elements"+ lst);


		//6.Checking if an element is present in the List
		boolean b = lst.contains("Java");
		System.out.println("list"+b);


	}

	@Test
	public void ListCommanELements() {

		List<String> lista = new ArrayList<String>();
		lista.add("Keyboard") ;
		lista.add("Mouse");
		lista.add("Harddisk");

		List<String> listb = new ArrayList<String>();
		listb.add("Keyboard") ;
		listb.add("Monitor");
		listb.add("Harddisk");


		boolean b = lista.contains(listb);
		for (int i=0;i<lista.size();i++)
			for(int j=0;j<lista.size();j++) {


				if(lista.get(i).equals(listb.get(j))) {
					System.out.println("Same/comman String"+ lista.get(i));

				}
			}
	}
	/*
	 * if(b=true) { System.out.println("boolean..."+b); }
	 */


	// list and Set difference 
	@Test 
	public void list_Set_difference() {

		List<String> lst = new ArrayList<String>();
		lst.add("Hello");
		lst.add("World");
		lst.add("Java");
		lst.add(null);
		lst.add("Practice");
		lst.add("Java");
		lst.add(null);
		//In list duplicates allowed
		System.out.println("List..."+lst+'\n'+"In list duplicates allowed");

		// update list elements
		lst.set(1, "Universe");
		System.out.println("AFter Updating list..."+lst+'\n'+"In list duplicates allowed");


		Set<String> set = new HashSet<String>();
		set.add("India");
		set.add("is");
		set.add("Great");
		set.add(null);
		set.add("India");
		set.add(null);
		//In Set duplicates not allowed
		System.out.println("SET:"+'\n'+set+'\n'+"In Set duplicates not allowed");

	}

	@Test
	public void fibonacciNumbers() {

		int n1=0,n2=1,n3_fibseries;
		int count = 9;
		System.out.print(n1+" "+n2);

		for(int i=2;i<count;i++) {

			n3_fibseries=n1+n2;
			n1=n2;
			n2=n3_fibseries;		;
			System.out.print("  "+n3_fibseries);
		}
	}

	@Test
	public void stringTest() {

		String s1 = "Test";
		String s2 = "Test";
		String s3 = new String("Test");
		String s4 = new String("Test");
		System.out.println(s1 == s2);//true
		System.out.println(s1.equals(s2));//true
		System.out.println(s3 == s4);//false
		System.out.println(s1 == s3);//false
		System.out.println(s1.equals(s3));//true
		System.out.println(s3.equals(s4));//true

	}

	//Arrays
	@Test
	public void sortStringArray() {

		String[] strArray = {"Bat", "Apple","Dog", "Cat"};
		System.out.println("Arrays before sorting...."+Arrays.toString(strArray));
		Arrays.sort(strArray);
		System.out.println("Arrays after sorting...."+Arrays.toString(strArray));

	}

	/*
	 * compareTo() method compares two strings lexicographically. The comparison is
	 * based on the Unicode value of each character in the strings. The method
	 * returns 0 if the string is equal to the other string. A value less than 0 is
	 * returned if the string is less than the other string (less characters) and a
	 * value greater than 0 if the string is greater than the other string (more
	 * characters).
	 */

	@Test	
	public void sortStringArrayUsingLoop() {
		String[] strArray = {"JavaFX", "HBase", "OpenCV", "Java", "Hadoop", "Neo4j"};
		System.out.println("Before SortingstrArray..."+Arrays.toString(strArray));

		int strArraySize = strArray.length;


		for(int i=0;i<strArraySize-1;i++) {

			for (int j=i+1;j<strArraySize;j++) {

				if(strArray[i].compareTo(strArray[j])>0) {
					String temp = strArray[i];
					strArray[i]= strArray[j];
					strArray[j]= temp;

				}
			}
		}

		System.out.println("After SortingstrArray..."+Arrays.toString(strArray));
	}


	@Test
	public void sortStringAndDigits() {

		String strValue = "abc123efg456";
		String characters="", digits="" , sortedString="";

		//The method strValue() is undefined for the type JavaBasicPrograms
		for(char ch : strValue.toCharArray()) {

			if(Character.isLetter(ch)){
				characters= characters+ch;

			}
			else if(Character.isDigit(ch)){
				digits= digits+ch;

			}
		}
		sortedString = characters+digits;
		System.out.println("onlyCharacters..."+characters);
		System.out.println("onlydigits..."+digits);

		System.out.println("sortedString..."+sortedString);


	}

	@Test
	public void StringSplitString() {
		String str  = "today is monday";
		String[] splitedString = str.split("\\s+");
		// ("\\s+");- This will cause any number of consecutive spaces to split your string into tokens.

		for(String s : splitedString) {

			System.out.println("Splitted text values:  "+s);
		}

	}


	@Test
	public void bigStringValue() {


		String[] str = {"Apple" , "Mars" , "Fruits","Vegetable","Departments","Cup","Responsibility"};
		int strLen = str.length;
		System.out.println("String length.."+ strLen+str);
		String temp=str[0];

		for(int i=0;i<strLen-1;i++) {

			if(temp.length() < (str[i+1].length())){
				temp=str[i+1];

			}
		}

		System.out.println("Big String value is.."+temp);

	}


	@Test
	public void characterCountInString() {

		String s = "This is the Programming test Prasanna.";

		// Create a HashMap to store character frequencies
		Map<Character, Integer> charCountMap = new HashMap<>();

		// Convert the string to lowercase to make the count case-insensitive
		s = s.toLowerCase();

		// Loop through each character in the string
		for (char c : s.toCharArray()) {
			// Ignore spaces
			if (c != ' ') {
				// If the character is already in the map, increment its count
				charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
			}
		}

		// Print the character frequencies
		for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
			System.out.println("Character '" + entry.getKey() + "' : " + entry.getValue());
		}
	}

	@Test
	public void DuplicateCharacterCount() {

		String str = "PrasannA";
		str =str.toLowerCase();

		char[] chArray = str.toCharArray();
		HashMap<Character,Integer> countDuplicateCharcter = new HashMap<Character,Integer>();


		for(char ch : chArray) {

			if(countDuplicateCharcter.containsKey(ch)) {

				countDuplicateCharcter.put(ch, countDuplicateCharcter.get(ch)+1);

			}
			else {
				countDuplicateCharcter.put(ch,1);
			}
		}

		for(Map.Entry<Character,Integer> entry : countDuplicateCharcter.entrySet()) {

			if(entry.getValue()>1) {
				System.out.println("duplicate character with count "+entry.getKey()+":"+entry.getValue());
			}


		}





	}

	@Test
	public void stringOccurance1() {

		String s = "googlE";

		// Create a HashMap to store character frequencies
		Map<Character, Integer> charCountMap = new HashMap<>();

		// Convert the string to lowercase to make the count case-insensitive
		s = s.toLowerCase();

		// Loop through each character in the string
		for (char c : s.toCharArray()) {
			// Ignore spaces
			if (c != ' ' && charCountMap.containsKey(c)) {
				// If the character is already in the map, increment its count
				charCountMap.put(c, charCountMap.get(c)+1);
			}
			else if ( c != ' ' ) {

				// If char is not present in charCountMap,
				// putting this char to charCountMap with 1 as it's value
				charCountMap.put(c, 1);

			}
		}

		// Print the character frequencies
		for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
			System.out.println("Character '" + entry.getKey() + "' : " + entry.getValue());
		}
	}

	//
	@Test
	public void tryout() {

		String str ="Prasanna";
	}

	@Test
	public void countDuplicateWords() {

		String str = "Bread butter and bread";//Java is java again java//Super Man Bat Man Spider Man

		String[] strArray = str.split(" ");

		HashMap<String,Integer> duplicateWordCount = new HashMap<String, Integer>();

		for(String word :strArray ) {

			if(duplicateWordCount.containsKey(word)) {

				duplicateWordCount.put(word.toLowerCase(), duplicateWordCount.get(word)+1);
			}

			else {
				duplicateWordCount.put(word.toLowerCase(),1);
			}
		}

		/*
		 * Set<String> wordsInString = duplicateWordCount.keySet();
		 * 
		 * for(String word : wordsInString) {
		 * 
		 * if(duplicateWordCount.get(word)>1) {
		 * 
		 * 
		 * System.out.println("Duplicate word +"+word+" :"+duplicateWordCount.get(word))
		 * ;
		 * 
		 * }
		 * 
		 * }
		 */


		for(Map.Entry entry : duplicateWordCount.entrySet()) {

			System.out.println("Duplicate word count = "+entry.getKey()+":"+entry.
					getValue());

		}


	}

	@Test
	public void string_Remove_Duplicates_Whitespaces_reverse() {
		String str="tHi$ iS A jAVa pROgramM foR BeGinnERs iN te$TiNg";
		//"Test #_* Example s";//"Test #_*Example"
		str = str.replaceAll("\\s","");// only replace for empty string 
		//str= str.replaceAll("[^a-zA-Z0-9]", "");
		String revString ="";


		boolean[] bValue = new boolean[256];
		String result="";
		//StringBuilder result = new StringBuilder();

		//logic to remove duplicate character
		for (int i =0;i<str.length();i++) {
			Character ch = str.charAt(i);
			if(!(bValue[ch])) {

				bValue[ch]=true;
				result+=ch;

			}


		}
		System.out.println("Duplicate removal.."+'\n'+str+'\n'+result);
		//System.out.println("Original String:"+str+'\n'+"String after duplicates removal:"+result);

		for(Character ch: str.toCharArray()) { 
			revString= ch+revString;

		}

		System.out.println("Reverse String"+'\n'+str+'\n'+revString);

	}

	@Test
	public void string_Remove_Duplicates_Whitespaces_reverse_1() {

		String str=" tHi$ iS A jAVa pROgramM foR BeGinnERs iN te$TiNg";
		System.out.println(str);
		//str=str.toLowerCase();
		str = str.replaceAll("\\s","");
		String strWithoutDuplicates="";
		boolean[] b= new boolean[256] ;
		Character ch ;

		for(int i=0;i<str.length();i++){
			ch = str.charAt(i);
			if((!b[ch])){
				b[ch]=true;
				strWithoutDuplicates=strWithoutDuplicates+ch;
			}

		}
		System.out.println(strWithoutDuplicates);
	}



	@Test
	public void singleKeyMultipleValues() {


		Map<String,List<String>> multiMapValues = new  HashMap<String,List<String>>();
		//ArrayList<String> listValues = new ArrayList<String>();


		addValue(multiMapValues,"Prasanna","Think@111#");
		addValue(multiMapValues,"Prasanna","Waves@111#");
		addValue(multiMapValues,"gmail","abc@111#");
		addValue(multiMapValues,"gmail","def@111#");

		// Print the map
		for (Map.Entry<String, List<String>> entry : multiMapValues.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}
	}



	// Method to add a value to the list associated with a key
	public static void addValue(Map<String, List<String>> map, String key, String value) {
		// If the key is not already in the map, add it with an empty list
		if (!map.containsKey(key)) {
			map.put(key, new ArrayList<>());
		}
		// Add the value to the list associated with the key
		map.get(key).add(value);
	}

	@Test
	public void SortInteregArrayAscendingOrder() {

		int[] intArray =  {-5,10,-2,-9,21,-10,20};//  int[] intArray= //{21,89,12,20,90,11};
		int temp;

		for(int i=0;i<intArray.length;i++) {

			for(int j=i+1;j<intArray.length;j++) {

				if(intArray[i]>intArray[j]) {
					temp=intArray[i];
					intArray[i]=intArray[j];
					intArray[j]=temp;
				}

			}
			System.out.print(intArray[i]+",");

		}
	}
	
	@Test
	public void SortInteregArrayDescendingOrder() {

		int[] intArray =  {-5,10,-2,-9,21,-10,20};//  int[] intArray= //{21,89,12,20,90,11};
		int temp;

		for(int i=0;i<intArray.length;i++) {

			for(int j=i+1;j<intArray.length;j++) {

				if(intArray[i]>intArray[j]) {
					temp=intArray[i];
					intArray[i]=intArray[j];
					intArray[j]=temp;
				}

			}
			System.out.print(intArray[i]+",");

		}
	}

	@Test
	public void  secondLargestInArray() {

		int[] intArray = {11,99,22,33,29,41,17,98};

		//int largest,secondLargest;
		int temp;
		int length =intArray.length;
		//System.out.println(intArray[length-2]);

		for(int i=0;i<length;i++) {

			for(int j=i+1;j<length;j++) {

				if(intArray[i]>intArray[j]) {
					temp=intArray[i];
					intArray[i]=intArray[j];
					intArray[j]=temp;

				}
			}
			//System.out.println(intArray[i]);
		}
		System.out.println(intArray[length-2]);

	}

	@Test
	public void swapLastStringValues() {

		String str= "Hello Prasanna Hello ";
		String[] strArray = str.split(" ");

		int lastIndex =strArray.length-1;
		int lastPreviousIndex = lastIndex-1 ;

		String temp=strArray[lastPreviousIndex];
		strArray[lastPreviousIndex]=strArray[lastIndex];
		strArray[lastIndex]=temp;

		for(String s: strArray){
			System.out.print(s+" ");

		}

	}

	@Test 
	public void checkVowel() {

		String str = "Education";//Remuneration
		String vowels="";

		str = str.toLowerCase();
		char[] charArray = str.toCharArray();

		for(int i=0;i<str.length();i++){

			if( charArray[i] =='a'|| charArray[i] =='e' || charArray[i] =='i'
					|| charArray[i] =='o' || charArray[i] =='u' ){

				vowels = vowels+charArray[i];

			}
		}
		System.out.println("Vowels in a String="+vowels);

	}


	@Test 
	public void reverseOnlyLetters() {

		System.out.println("Try programiz.pro");
		String str ="ed56z"; //
		String reverse="";
		char[] chArray =str.toCharArray();

		for(Character ch: chArray){
			if(Character.isLetter(ch) ){
				reverse = ch+reverse;

			}
			if(!Character.isLetter(ch) ){
				reverse = reverse+ch;

			}

		}
		System.out.println(reverse);

	}


	@Test
	public void checkStringPermutation() {

		String s ="ABC";
		// ABC ,ACB,BAC,BCA,CBA,CAB
		permute(s, "");



	}

	public static void permute(String s, String answer) {
		// Base case: If string is empty, print the answer
		if (s.length() == 0) {
			System.out.println(answer);
			return;
		}

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			String leftSubStr = s.substring(0, i);
			String rightSubStr = s.substring(i + 1);
			String rest = leftSubStr + rightSubStr;
			permute(rest, answer + ch);
		}

	}
}

//https://javaconceptoftheday.com/java-interview-programs-on-strings/















