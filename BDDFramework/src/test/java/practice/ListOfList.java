package practice;

import java.util.ArrayList;
import java.util.List;

public class ListOfList {
	public static void main(String[] args) {
		
		List<List<String>> list=new ArrayList<List<String>>();
		List<String> list1=new ArrayList<String>();
		//java, programming lanaguage
		list1.add("Java");
		list1.add("programming");
		list.add(list1);
		
		List<String> list2=new ArrayList<String>();
		//python, AI/ML
		list2.add("python");
		list2.add("AI/ML");
		list.add(list2);
		
		list.get(0);
		//get programming
		System.out.println(list.get(0).get(1));
		
		System.out.println(list);
		
		for(int i=0;i<list.size();i++) {
			for(int j=0;j<list.get(i).size();j++) {
				System.out.println("("+i+","+j+")==>"+list.get(i).get(j));
			}
		}
		
	}

}
