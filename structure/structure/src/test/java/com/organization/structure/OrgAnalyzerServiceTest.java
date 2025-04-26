package com.organization.structure;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import com.organization.structure.model.Employee;
import com.organization.structure.service.AnalyzerOrgService;

public class OrgAnalyzerServiceTest {
	
	AnalyzerOrgService service = new AnalyzerOrgService();

	 @Test
	    void testAnalyzeStructure_OutputValidation() {
	        // Arrange: Prepare employee data
	        List<Employee> employees = Arrays.asList(
	                new Employee("1",  "Alice", "S", 150000,"0"),   // CEO
	                new Employee("2", "Bob", "M", 100000,"1"),
	                new Employee("3",  "Carol", "D", 50000,"2"),
	                new Employee("4", "David", "Dev", 50000,"2"),
	                new Employee("5", "Eve", "I", 25000,"3"),
	                new Employee("6", "Frank", "P", 20000,"5"),
	                new Employee("7", "Grace", "T", 18000,"6")
	        );

	        
	        service.loadEmployees(employees);
	        
	        // Capture output
	        ByteArrayOutputStream out = new ByteArrayOutputStream();
	        System.setOut(new PrintStream(out));
	        
	        // Act: Analyze structure
	        service.analyzeStructure();

	        // Restore output
	        System.setOut(System.out);
	        
	        // Assert: Validate messages
	        String output = out.toString();
	        assertTrue(output.contains("Bob Manager earns too much") || output.contains("Bob Manager earns too little"));
	        assertTrue(output.contains("Grace Intern has a reporting line that is too long"));
	        
	        
	}
}
	
	

