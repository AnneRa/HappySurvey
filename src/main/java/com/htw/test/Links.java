package com.htw.test;

public class Links {
	
	public static int calculateCheckDigit(String numString) {
		
		long checksum = 0;
		
		for ( int i = 0; i < numString.length(); i++ ) {
			byte charValue = (byte) numString.charAt(i);
			checksum += (charValue - 48) * ( i % 2 > 0 ? 2 : 1 );
		}
		
		return (int) ( 10 - checksum % 10 ) % 10;
		
	}

	public static String createLink(int id) {
		
		Long sourceId = ((long) id) * 5 + 104302;
		String numString = Long.toString( sourceId );
		int checkDigit = calculateCheckDigit(numString);
		return numString + String.valueOf(checkDigit);
		
	}
	
	public static int decodeLink(String link) {
		
		String numString = link.substring(0, link.length() - 1);
		int id = (int) ( (Long.parseLong(numString) - 104302) / 5 );
		return createLink(id).equals(link) ? id : 0;
		
	}
	
}
