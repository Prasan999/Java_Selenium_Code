package com.ticketChecker;



public class CheckTicketNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		boolean result = checkTicketNumber("123420");//String as parameter
		//boolean result = checkTicketNumber(123222);//integer as parameter
		System.out.println("To check first 3 digits and last 3 digits sum are equal..."+result);


	}


	public static boolean checkTicketNumber(int ticketNumber) {
		
		// Extract the digits
        int firstDigit = ticketNumber / 100000;
        int secondDigit = (ticketNumber / 10000) % 10;
        int thirdDigit = (ticketNumber / 1000) % 10;
        int fourthDigit = (ticketNumber / 100) % 10;
        int fifthDigit = (ticketNumber / 10) % 10;
        int sixthDigit = ticketNumber % 10;

        // Calculate the sums
        int sumFirstThree = firstDigit + secondDigit + thirdDigit;
        int sumLastThree = fourthDigit + fifthDigit + sixthDigit;

        // Compare the sums
        return sumFirstThree == sumLastThree;



	}


	public static boolean checkTicketNumber(String ticketNumber) {
		
		
		// Convert each character to an integer and calculate the sums
        int sumFirstThree = Character.getNumericValue(ticketNumber.charAt(0))
                           + Character.getNumericValue(ticketNumber.charAt(1))
                           + Character.getNumericValue(ticketNumber.charAt(2));

        int sumLastThree = Character.getNumericValue(ticketNumber.charAt(3))
                          + Character.getNumericValue(ticketNumber.charAt(4))
                          + Character.getNumericValue(ticketNumber.charAt(5));

        // Compare the sums
        return sumFirstThree == sumLastThree;


	}

}
