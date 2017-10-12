/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.hva.dmci.ict.se.datastructures;

import java.util.Random;
import model.Student;

/**
 *
 * @author Alexander van den Herik
 */
public class StudentGenerator {
    private int studentNumberStart= 50080001;
    private static final int NUMBER_OF_STUDENTS = 10000;
    private final Student[] studentArray = new Student[NUMBER_OF_STUDENTS];
    
    public Student[] studentGenerator(){
        String[] klassen = KlasGenerator.maakKlassen(NUMBER_OF_STUDENTS);
        for (int i = 0; i < studentArray.length; i++) {
            Student student = new Student();
            student.setStudentNumber(studentNumberStart++);
            student.setGrade(generateGrade());
            student.setKlas(klassen[i]);
            studentArray[i] = student;
        }
        return studentArray;
    } 
    
    public double generateGrade(){
        double start = 0.95;//minimum, 0.95 because it will be rounded;
        double end = 10.04;//maximum 10.04 because it will be rounded;
        double random = new Random().nextDouble();//generates a random double between 0.0 and 1.0
        double grade = start + (random * (end - start));//calculates the random grade
        grade = Math.round(grade * 10);//rounds up the grade*10 so there wont be to any decimals
        grade = grade / 10;//devide bij 10 so there will be 1 decimal
        return grade;//return the grade
    }
    
}
