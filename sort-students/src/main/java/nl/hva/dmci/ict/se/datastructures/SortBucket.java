/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.hva.dmci.ict.se.datastructures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;
import model.Student;

/**
 *
 * @author alwin
 */
public class SortBucket {

    public static void sort(Student[] students) {

        LinkedList<LinkedList<Student>> buckets = new LinkedList<>();
        boolean check = false;
        for (int i = 0; i < students.length; i++) {
            if (buckets.isEmpty()) {
                LinkedList<Student> firstKlas = new LinkedList<>();
                firstKlas.add(students[i]);
                buckets.add(firstKlas);
            } else {
                for (LinkedList ll : buckets) {
                    Student temp = (Student) ll.first();
                    if (temp.getKlas().equals(students[i].getKlas())) {
                        ll.add(students[i]);
                        check = true;
                    }
                }
                if (!check) {
                    LinkedList<Student> newKlas = new LinkedList<>();
                    newKlas.add(students[i]);
                    buckets.add(newKlas);
                }
                check = false;

            }
        }

        for (LinkedList ll : buckets) {
            System.out.println(" ");
            for (Object obj : ll) {
                System.out.println(obj);
            }
        }

//                for (int j = 0; j < buckets.size(); j++) {
//                    if (buckets.iterator().next().get(j).getFirst().getKlas().equals(students[i].getKlas())) {
//                        System.out.println("s");
//                        buckets.get(j).add(students[i]);
//                        j=0;
//                        break;
//                    } else if (j == buckets.size()-1) {
//                        LinkedList<Student> newKlas = new LinkedList<>();
//                        buckets.add(newKlas);
//                        buckets.getLast().add(students[i]);
//                        j=0;
//                        break;
//                    }
//                    
//                }
    }
}

//        for (int i = 0; i < buckets.size(); i++) {
//           
//                System.out.println(buckets.get(i));
//            
//        }
//        // first find out what classes are in the list so you can make them into buckets
//        SortedSet<String> bucket = new TreeSet();
//        for (int i = 0; i < students.size(); i++) {
//            String newKlas = students.get(i).getKlas();
//            if (!bucket.contains(newKlas)) {
//                bucket.add(newKlas);
//            }
//        }
//        ArrayList<Klas> klasBucket = new ArrayList<>();
//        
//        //place sorted klassen in arraylist from sortedSet
//        Iterator it = bucket.iterator();
//        while (it.hasNext()) {
//            String k = it.next().toString();
//            Klas temp = new Klas(k);
//            klasBucket.add(temp);
//        }
//
//        //place students in klasBucket
//        for (Student x : students) {
//            for (Klas k : klasBucket) {
//                if (k.getClassId().equalsIgnoreCase(x.getKlasNummer())) {
//                    k.addStudent(x);
//                    break;
//                }
//            }
//        }
//
//        //clear the studentList, get the students of each klas in an arrayList and sort on studentNumber, add the contents of the small list to the studentList
//        students.clear();
//        for (Klas k : klasBucket) {
//            ArrayList<Student> sList = k.getStudentList();
//            for (int i = 0; i < k.getSize(); i++) {
//                for (int x = i; x > 0 && less(sList.get(x).getStudentNummer(), sList.get(x - 1).getStudentNummer()); x--) {
//                    exch(sList, x, x - 1);
//                }
//            }
//            students.addAll(sList);
//        }
//    }
//
//    private static boolean less(Comparable a, Comparable b) {
//        return a.compareTo(b) < 0;
//
//    }
//
//    private static void exch(ArrayList<Student> students, int x, int y) {
//        Collections.swap(students, x, y);
//    }
//}
