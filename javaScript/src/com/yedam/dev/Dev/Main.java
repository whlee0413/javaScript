package com.yedam.dev.Dev;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		Student s1 = new Student("Hong", "S111", 20);
		Student s2 = new Student("Hwang", "S222", 22);
		Student s3 = new Student("Park", "S333", 24);
		System.out.println("==배열==");
		Student[] studAry = { s1, s2, s3 };
		
		for(Student s :studAry) {
			System.out.println(s.toString());
		}
		
		System.out.println(" == ArrayList == ");
		List<Student> list = new ArrayList<Student>();
		list.add(s1);
		list.add(s2);
		list.add(s3);
		for(Student s : list) {
			System.out.println(s);
		}
		
		System.out.println(" == Set == ");
		Set<Student> studSet = new HashSet<Student>();
		studSet.add(s1);
		studSet.add(s2);
		studSet.add(s3);
		Iterator<Student> iter = studSet.iterator();
		while(iter.hasNext( )) {
			System.out.println(iter.next());
		}
		
		System.out.println( " == Map1 == "); //key, value
		Map<Integer, Student> studMap = new HashMap<Integer, Student>();
		studMap.put(1, s1);
		studMap.put(2, s2);
		studMap.put(3, s3);
		Set<Integer> iSet = studMap.keySet(); //key값만 담는것.
		Iterator<Integer> iter2 = iSet.iterator();
		while(iter2.hasNext()) {
			 Integer ikey = iter2.next();
			 System.out.println(ikey + ", " + studMap.get(ikey).toString());
		}
		System.out.println( " == Map2 == ");
		Set<Map.Entry<Integer, Student>> mSet = studMap.entrySet();
				Iterator<Map.Entry<Integer, Student>> iter3 = mSet.iterator();
		while(iter3.hasNext()) {
		Map.Entry<Integer, Student> rMap = iter3.next();
		System.out.println("key: " + rMap.getKey() +", value: " + rMap.getValue());
		}
	}
}	
