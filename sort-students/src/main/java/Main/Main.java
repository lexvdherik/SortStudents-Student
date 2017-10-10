/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import model.Student;
import nl.hva.dmci.ict.se.datastructures.KlasGenerator;
import nl.hva.dmci.ict.se.datastructures.SelectionSort;
import nl.hva.dmci.ict.se.datastructures.SortBucket;
import nl.hva.dmci.ict.se.datastructures.StudentGenerator;
import nl.hva.dmci.ict.se.datastructures.util.Schudder;
import nl.hva.dmci.ict.se.datastructures.dalendeRijen.DalendeRijen;

/**
 *
 * @author Alexander van den Herik
 */
public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        StudentGenerator stGen = new StudentGenerator();
        Student[] students = stGen.studentGenerator();
        Schudder.schud(students);
        SortBucket.sort(students);
//        SelectionSort.SelectionSort(students);
//        
//        List<Student>  list = new ArrayList<>();
//        for (Student student : students) {
//            list.add(student);
//        }
//        
//        DalendeRijen dalendeRijen = new DalendeRijen();
//        System.out.println(dalendeRijen.isStijgend(list));
//        
//        
//        
//        for (int i = 0; i < students.length; i++) {
//            System.out.println(students[i]);
//        }
        
//         String[] klassen = KlasGenerator.maakKlassen(100);
//         Arrays.sort(klassen);
//         
//         for (int i = 0; i < klassen.length; i++) {
//            System.out.println(klassen[i]);
//            
//        }
//        
    }
}
