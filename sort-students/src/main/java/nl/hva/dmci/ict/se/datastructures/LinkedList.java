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
    private Node last = new Node(); // link to last node(most right)
    private int N = 0; // number of items in the queue

    public Object popLeft() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int compareTo(Object t) {
        Student student = (Student) this.first.item;
        Student student2 = (Student) t;
        for (int i = 0; i < student.getKlas().length(); i++) {
            if (student.getKlas().charAt(i) > student2.getKlas().charAt(i)) {
                return -1;
            } else if (student.getKlas().charAt(i) == student2.getKlas().charAt(i)) {

            } else {
                return 1;
            }
        }
        return 0;

    }

    // nested class to define nodes
    private class Node {

        private Node next;
        private Node prev;
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
                Node newNode = first;
                first = new Node();
                first.next = newNode;
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

    //add an item to the right end
    public void pushRight(Object item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        if (oldLast.item == null) {
            last.prev = oldLast.prev;
            last.prev.next = last;
        } else {
            last.prev = oldLast;
            oldLast.next = last;
        }

        N++;
    }

    public Object first() {
        return first.item;
    }

    //remove an item from the right end
    public Object popRight() {
        Object item = last.item;
        last = last.prev;
        last.next = null;
        N--;
        return item;
    }

    //change n-th item from the left counting fom 0
    public Object changeLeft(int n, Object newItem) {
        Node a = first; //link to first node in queue
        if (n == 0) { //if n == 0 the node that needs to be changed is reached
            first.item = newItem; //change the node
        } else {
            first = first.next; //set first to the node that comes next to first
            changeLeft(n - 1, newItem); //call to selfe with n-1 so n will eventually reach 0
            first = a; //set first back to a so the queue will build back up
        }
        return a.item; //return item of Node a because that is set to the node that changed right before it changed
    }

    //change n-th item from the right counting fom 0
    public Object changeRight(int n, Object newItem) {
        Node a = last; //link to last node in queue
        if (n == 0) { //if n == 0 the node that needs to be changed is reached
            last.item = newItem; //change the node
        } else {
            last = last.prev; //set last to the node that comes before last
            changeRight(n - 1, newItem); //call to selfe with n-1 so n will eventually reach 0
            last = a; //set first back to a so the queue will build back up
        }
        return a.item; //return item of Node a because that is set to the node that changed right before it changed
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
