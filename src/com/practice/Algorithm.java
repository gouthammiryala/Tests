package com.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


//Assumptions:
//1. Zip Codes will always be greater than 0
//2. The input can be a collection of tuples. 

public class Algorithm {

	/**
	 * Minimizes the number of ranges if there are any overlaps
	 * @param ranges Entire List of ZipCodeRange
	 * @return minimal number of ranges 
	 */
	private static List<ZipCodeRange> minimumRanges(List<ZipCodeRange> ranges) {
		//To sort based on the start in the ZipCodeRange
		Comparator<ZipCodeRange> zipcodeComparator = new Comparator<ZipCodeRange>() {
			public int compare(ZipCodeRange r1, ZipCodeRange r2)
			{
				return r1.getBegin() - r2.getBegin();
			}
		};
		Collections.sort(ranges, zipcodeComparator);

		//If the end of a tuple is greater than or equal to the begin of the next tuple, then merge them 
		for(int i=0; i < ranges.size()-1;  i++) {
			if (ranges.get(i).getEnd() >= ranges.get(i+1).getBegin()) {
				ranges.get(i).setEnd(ranges.get(i+1).getEnd());
				ranges.remove(i+1);
			}
		}
		return ranges;
	}

	public static void main(String a[]) {

		List<ZipCodeRange> ranges = minimumRanges(new ArrayList<ZipCodeRange> (){{
			add(new ZipCodeRange(94300,95600)); 
			add(new ZipCodeRange(94133, 94133));
			add(new ZipCodeRange(94226, 94399));
			add(new ZipCodeRange(95600,95700)); 
			add(new ZipCodeRange(94200,94299)); 
			
		}});

		ranges.forEach(x -> System.out.println(x));	
	}
}
