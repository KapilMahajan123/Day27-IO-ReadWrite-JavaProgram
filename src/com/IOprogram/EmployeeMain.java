package com.IOprogram;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 
 * @author Kapil
 *
 */
public class EmployeeMain {
	/**
	 * Create an employee payroll service to store Employee payroll into a file
	 */
	private static int empId;
    private static String empName;
    private static double empSalary;
    private static Scanner scanner;
    
    private static void inputEmpPayroll() {
        System.out.print("Enter Employee Id: ");
        empId = scanner.nextInt();
        System.out.print("Enter Employee Name: ");
        empName = scanner.next();
        System.out.print("Enter Employee Salary: ");
        empSalary = scanner.nextDouble();

    }
    /**
	 * Create and to read and write employee payroll to a console
	 */
    public static void main(String[] args) {
        System.out.println("Welcome to File IO!");

        String option;
        scanner = new Scanner(System.in);

        List<Employee> employees = new ArrayList<>();

        while (true) {
            inputEmpPayroll();
            employees.add(new Employee(empId, empName, empSalary));

            System.out.print("Do you wan't to add one more Employee entry[Yes/No]: ");
            option = scanner.next();

            if (option.equalsIgnoreCase("nO"))
                break;
        }

        Path path = Paths.get("C:\\\\Users\\\\mahaj\\\\Desktop\\\\229\\\\Day27-IO-JavaProgram\\\\src\\\\com\\\\IOprogram\\\\Payroll_Service");

        List<String> empsList = employees
                .stream().map(emp -> emp.toString())
                .collect(Collectors.toList());

        try {
            if (! Files.exists(path))
                Files.createFile(path);

            Files.write(path, empsList, StandardOpenOption.APPEND);
            System.out.println(employees.size() + " Employee information saved successfully to file!\n" + path);

            List<String> emps = Files.readAllLines(path);
            System.out.println("\nPrinting all employee details from file:");
            emps.stream().forEach(emp -> System.out.println(emp));

            long count = emps.stream().count();
            System.out.println("Number of employee entries in file = " + count);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}