package com.htw.test;

public class Links {
	
	public static long calculateCheckDigit(String numString) {
		
		long checksum = 0;
		
		for ( int i = 0; i < numString.length(); i++ ) {
			byte charValue = (byte) numString.charAt(i);
			checksum += (charValue - 48) * ( i % 2 > 0 ? 2 : 1 );
		}
		
		return (long) ( 10 - checksum % 10 ) % 10;
		
	}

	public static String createLink(long id) {
		
		long sourceId = id * 5 + 104302;
		String numString = Long.toString( sourceId );
		long checkDigit = calculateCheckDigit(numString);
		return numString + String.valueOf(checkDigit);
		
	}
	
	public static long decodeLink(String link) {
		
		String numString = link.substring(0, link.length() - 1);
		long id = (long) ( (Long.parseLong(numString) - 104302) / 5 );
		return createLink(id).equals(link) ? id : 0;
		
	}
	
}
