/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.hva.dmci.ict.se.datastructures;

import java.util.Iterator;
import model.Student;

/**
 *
 * @author Alexander van den Herik
 */
public class LinkedList<Object> implements Iterable<Object>, Comparable<Object> {

    private Node first = new Node(); // link to first node(most left)
    private int N = 0; // number of items in the queue

    @Override
    public int compareTo(Object t) {
        Student student = (Student) this.first.item;//get the first object from the bucket and cast is to a Student
        LinkedList<Object> bucket = (LinkedList) t;//cast the param t to a LinkedList called bucket
        Student student2 = (Student) bucket.first.item;//get the first object of bucket and cast it to a Student
        for (int i = 0; i < student.getKlas().length(); i++) {//get the klas of student and loop through the chars of the string
            //compare the i-th char of student versus the i-th char of student2
            if (student.getKlas().charAt(i) > student2.getKlas().charAt(i)) {//if larger return -1
                return -1;
            } else if (student.getKlas().charAt(i) == student2.getKlas().charAt(i)) {//if equal do nothing

            } else {//else the char has a smaller value. Return 1
                return 1;
            }
        }
        return 0;//return 0 if all chars are equal
    }

    // nested class to define nodes
    private class Node {
        private Node next;
        private Object item;
    }

    //is the deque empty?
    public boolean isEmpty() {
        return N == 0;
    }

    //number of items in the deque
    public int size() {
        return N;
    }

    //add an item to the left end
    public void add(Object item, int index) {
        if (index == 0) {
            if (first.item == null) {
                first.item = item;
            } else {
                Node oldFirst = first;
                first = new Node();
                first.next = oldFirst;
                first.item = item;
            }
        } else {
            Node current = first;
            for (int i = 0; i < index-1; i++) {
                if (current.next != null) {
                    current = current.next;
                }
            }
            Node newNode = new Node();
            newNode.item = item;
            if (current.next != null) {
                newNode.next = current.next;
            }
            current.next = newNode;
        }
        N++;
    }

    public Object first() {
        return first.item;
    }

    @Override
    public Iterator<Object> iterator() {
        return new DoubleEndedQueueIterator();
    }

    private class DoubleEndedQueueIterator implements Iterator<Object> {

        private Node current = first;

        @Override
        public boolean hasNext() {
            return (current != null);
        }

        @Override
        public Object next() {
            Object item = current.item;
            current = current.next;
            return item;
        }
    }

}
