package com.IOprogram;

/**
 * 
 * @author Kapil
 *
 */
public class Employee {
	/*
	 * Declaring variables
	 */
    private int id;
    private String name;
    private double salary;
    
    /*
     * Create parameterized constructor
     */
    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    /*
     * Returns the string representation of the object
     */
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }

}
