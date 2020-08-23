//given an array scores [][] = {“jerry”,”65”},{“bob”,”91”}, {“jerry”,”23”}, {“Eric”,”83”}} Find the student with highest average score
package com.company;
import java.util.*;

class Student{
	String name;
	int avgMarks;
	int marks;
	int numOfSubs = 1;
	
	Student(String name, int marks, int avgMarks){
		this.name = name;
		this.marks = marks;
		this.avgMarks = avgMarks;
	}
	
	void addMarks(int m) {
		this.marks += m;
		numOfSubs++;
		avgMarks = marks/numOfSubs;			
	}
	
	int getAvgMarks() {
		return avgMarks;
	}
}
public class ScoreAvg {
	public static void main(String[] args) {
		String s [][] = {{"jerry","160"}, {"bob","81"}, {"jerry","20"}, {"Eric","83"}};
		HashMap<String, Student> hm = new HashMap<>();
		for(String[] str : s) {
			if(hm.containsKey(str[0])) {
				
				Student temp = hm.get(str[0]);
				temp.addMarks(Integer.parseInt(str[1]));
				int avg = temp.getAvgMarks();
				
				hm.put(str[0], new Student(str[0], Integer.parseInt(str[1]), avg));
			}else {
				hm.put(str[0], new Student(str[0], Integer.parseInt(str[1]), Integer.parseInt(str[1])));
			}
		}
		
		int maxAvg = Integer.MIN_VALUE;
		String name = "";
		
		for(String m : hm.keySet()) {
			if(hm.get(m).avgMarks > maxAvg) {
				maxAvg = hm.get(m).avgMarks;
				name = hm.get(m).name;
			}
		}
		System.out.println("name = "+name+" AvgMarks ="+maxAvg);
	}
}
