package com.IOprogram;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

/**
 * 
 * @author Kapil
 *
 */
public class EmployeeMain {
	
	/**
	 * Create and to read and write employee payroll to a console
	 * @param args
	 */
    public static void main(String[] args) {
        System.out.println("Welcome to File IO!");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Employee Id: ");
        int empId = scanner.nextInt();
        System.out.print("Enter Employee Name: ");
        String empName = scanner.next();
        System.out.print("Enter Employee Salary: ");
        double empSalary = scanner.nextDouble();

        Employee emp = new Employee(empId, empName, empSalary);

        Path path = Paths.get("C:\\Users\\mahaj\\Desktop\\229\\Day27-IO-JavaProgram\\src\\com\\IOprogram\\Payroll_Service");

        try {
            Files.writeString(path, emp.toString(), StandardOpenOption.CREATE);
            System.out.println("Employee information saved successfully to file!\n" + path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
