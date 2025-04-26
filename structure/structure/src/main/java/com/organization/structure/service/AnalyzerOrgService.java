package com.organization.structure.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.organization.structure.model.Employee;

public class AnalyzerOrgService {
	
	private Map<String,Employee> empMap = new HashMap<>();
	private Employee ceo;
	
	public void loadEmployees(List<Employee> employees) {
		//Insert employee details into map
		for(Employee e : employees) {
			empMap.put(e.id, e);
		}
		//Adding the subordinates for the manager
		for(Employee e : employees) {
			if(e.managerId != null && !e.managerId.isEmpty()) {
				Employee manager = empMap.get(e.managerId);
				if(manager != null) {
					manager.subordinates.add(e);
				}else {
					ceo = e;
				}
		    }
		}
		
	}
	
	//Identifying which manager is earning less
	//Identifying which manager is earning more
	public void analyzeStructure() {
		for(Employee manager : empMap.values()) {
	       if(!manager.subordinates.isEmpty()) {
	    	   double avgSal = manager.subordinates.stream()
	    			          .mapToDouble(e -> e.salary).average().orElse(0);
	    	   double minExpected = avgSal * 1.2;
	    	   double maxExpected = avgSal * 1.5;
	    	   
	    	   if (manager.salary < minExpected) {
                   System.out.println(manager.firstName + " " + manager.lastName+ " earns too little. Short by: " + (minExpected - manager.salary));
               } else if (manager.salary > maxExpected) {
                   System.out.println(manager.firstName + " " + manager.lastName+" earns too much. Excess: " + (manager.salary - maxExpected));
               }
	       }
		}
		 findLongestChains(ceo, 0);
	}
	
	 private void findLongestChains(Employee e, int depth) {
	        if (depth > 4) {
	            System.out.println(e.firstName+ " "+ e.lastName + " has a reporting line that is too long: " + depth);
	        }
	        for (Employee sub : e.subordinates) {
	            findLongestChains(sub, depth + 1);
	        }
	    }

}
