/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.hva.dmci.ict.se.datastructures;

import model.Student;

/**
 *
 * @author Alexander van den Herik
 */
public class SelectionSort {
    
    public static void SelectionSort(Student[] students){
        for (int i = 0; i < students.length; i++) {
            int indexOfstudentToSwap = i;
            for (int j = i; j < students.length; j++) {
                if (students[i].compareTo(students[j]) == 1 && students[indexOfstudentToSwap].compareTo(students[j]) == 1) {
//                    System.out.println(students[i] + "   " + students[j]);
                   indexOfstudentToSwap = j; 
                }
            }
            Student tempStudent = students[i];
            students[i] = students[indexOfstudentToSwap];
            students[indexOfstudentToSwap] = tempStudent;    
        }
    }  
}
