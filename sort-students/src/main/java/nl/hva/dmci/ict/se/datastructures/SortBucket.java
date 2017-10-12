/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.hva.dmci.ict.se.datastructures;

import model.Student;

/**
 *
 * @author alwin
 */
public class SortBucket {

    public static void sort(Student[] students) {

        LinkedList<LinkedList<Student>> buckets = new LinkedList<>();//LinkedList of LinkedLists to serve as buckets
        boolean check = true;//to serve as check to check if there is a bucket found with a klas equal to the student's klas
        int index = 0;//to keep track of the index
        int timesLooped = 0;//to keep track of the times looped
        for (int i = 0; i < students.length; i++) {//loop through the whole student list
            if (buckets.isEmpty()) {//check if buckets is empty, if true create the 1th bucket
                LinkedList<Student> firstKlas = new LinkedList<>();//LinkedList of Students to serve as bucket
                firstKlas.add(students[i], index);//add the first student to the bucket
                buckets.add(firstKlas, index);//add the bucket to the list of buckets
            } else {//if buckets is not empty 
                timesLooped = 0;//set to 0 before looping to keep track of the times looped. this represents the index of the list with buckets
                for (LinkedList bucket : buckets) {//start looping through the list of buckets
                    index = 0;//set index to 0 at the beginning of every loop to start counting again. this represents the index of the bucket with students
                    Student firstStudentInBucket = (Student) bucket.first();//get first object from the bucket and cast it to a Student
                    if (firstStudentInBucket.getKlas().equals(students[i].getKlas())) {//compare the klas of the i-th student to the klas of the first student in the bucket 
                        for (Object student : bucket) {//if they are equal loop through the bucket
                            Student tempStudent = (Student) student;//cast the object from the bucket to a Student
                            if (students[i].compareToStudentNr(tempStudent) == -1) {//check if the student number is larger or smaller
                                bucket.add(students[i], index);//if larger, add the students at that index
                                break;//break to stop the loop
                            } else if (index + 1 == bucket.size()) {//if index + 1 equals the length of the bucket there are no students with a larger student number
                                bucket.add(students[i], index + 1);// add the student at the end
                                break;//break to stop the loop
                            } else {
                                index++;//else increment the index to keep track of the position
                            }
                        }
                    } else {
                        timesLooped++;//keep track the times looped
                        if (timesLooped == buckets.size()) {//if equal then the end of the list with buckets is reached
                            check = false;//set check to false
                        }
                    }
                }

                if (!check) {//check if check is false 
                    timesLooped = 0;//use timesLooped again to represent the index of the list with buckets
                    LinkedList<Student> newKlas = new LinkedList<>();//create new LinkedList to serve as bucket for Students
                    newKlas.add(students[i], timesLooped);//add the new bucket to the list of buckets
                    for (LinkedList bucket : buckets) {//loop through the list of buckets
                        if (bucket.compareTo(newKlas) == -1) {//compare which klas the bucket represents against the klas the new bucket represents
                            buckets.add(newKlas, timesLooped);//if the new bucket comes behind bucket add the new bucket at that position
                            break;//break to stop the loop
                        } else if (timesLooped + 1 == buckets.size()) {//if timesLooped + 1 == the size of buckets then the new bucket needs to be put at the end of the list with buckets
                            buckets.add(newKlas, timesLooped + 1);//add the new bucket at the end of the list with buckets
                            break;//break to stop the loop
                        }
                        timesLooped++;//increment to keep track of the index of the list with buckets
                    }
                }
                check = true;//set check back to false
            }

        }

//
        for (LinkedList ll : buckets) {
            System.out.println("");
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
//            Klas firstStudentInBucket = new Klas(k);
//            klasBucket.add(firstStudentInBucket);
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
