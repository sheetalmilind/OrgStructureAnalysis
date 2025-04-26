package com.organization.structure;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



import com.organization.structure.model.Employee;
import com.organization.structure.service.AnalyzerOrgService;
import com.organization.structure.util.ConfigUtil;


public class StructureApplication {
	
	
	//Get the employee data from the employee.csv file
    public static List<Employee> readEmployees(String path){
		
		List<Employee> list = new ArrayList<>();
		
		try {
			
			BufferedReader br = new BufferedReader(new FileReader(path));
			String line;
			br.readLine();
			while((line = br.readLine()) != null) {
				String[] parts = line.split(",");
				list.add(new Employee(parts[0],parts[1],parts[2],Double.parseDouble(parts[3]),parts[4]));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public static void main(String[] args) {
		String filePath = ConfigUtil.getProperty("employee.file.path");
		
		List<Employee> employees = readEmployees(filePath);

        AnalyzerOrgService service = new AnalyzerOrgService();
        service.loadEmployees(employees);
        service.analyzeStructure();
		
		
	}

}
