package com.company;

import java.util.*;

interface IntegerOperation<A>{
	A doOperation(A value);
}
public class AbstractionExp {
	public static List<Long> updateList(List <Long> myList, IntegerOperation<Long> op){
		List <Long> newList = new ArrayList<>();
		for(Long n : myList)
			newList.add(op.doOperation(n));
		return newList;
	}
	public static void main(String[] args) {
		IntegerOperation<Long> op =  (v -> v/10);
		
		List <Long> newList = updateList(Arrays.asList(10l,20l,30l,40l), op);
		for(Long n : newList)
			System.out.print(n+" ");
	}

}
