package humanResourses;

import java.util.*;

public class ProjectList implements List<Employee> {
    private Node head;
    private int size = 0;

    public ProjectList(){}

    public ProjectList(Employee ... employees) {
        this.addAll(Arrays.asList(employees));
    }

    @Override
    public int size() {
        return size;
    } // сделал

    @Override
    public boolean isEmpty() {
        return head == null;
    } // сделал

    @Override
    public boolean contains(Object o) {
        for (Employee employee : this) {
            if (employee.equals(o)) return true;
        }
        return false;
    } // сделал

    @Override
    public Iterator<Employee> iterator() {
        return new Iterator<Employee>() {
            Node currentNode = head;

            @Override
            public boolean hasNext() {
                return currentNode.next != null;
            }

            @Override
            public Employee next() {
                if (head == null) return null;
                currentNode = currentNode.next;
                return currentNode.employee;
            }
        };
    } //  сделал

    @Override
    public Object[] toArray() {
        Employee[] mas = new Employee[size];
        if (head == null) return mas;

        Node currentNode = head.next;
        for (int count = 0; count < size; count++) {
            mas[count] = currentNode.employee;
            currentNode = currentNode.next;
        }
        return mas;
    } // сделал

    @Override
    public <T> T[] toArray(T[] a) {
        if (a.length < size) {
            a = (T[]) java.lang.reflect.Array.newInstance(a.getClass().getComponentType(), size);
        }

        if (head == null) return a;

        Object[] result = a;
        Node currentNode = head.next;
        for (int count = 0; count < size; count++) {
            result[count] = currentNode.employee;
            currentNode = currentNode.next;
        }

        if (a.length > size) a[size] = null;

        return a;
    } //сделал

    @Override
    public boolean add(Employee employee) {
        Node newNode = new Node(employee);

        if (head == null) {
            head = new Node();
            head.next = newNode;
        } else {
            Node currentNode = head;
            for (int count = 0; count < size; count++) {
                currentNode = currentNode.next;
            }
            currentNode.next = newNode;
        }
        size++;
        return true;
    } // сделал

    @Override
    public boolean remove(Object o) {
        Node currentNode = head.next;
        Node prevNode = head;

        for(int count = 0; count < size; count++) {
            if (currentNode.employee.equals(o)) {
                prevNode.next = currentNode.next;
                size--;
                return true;
            }
            prevNode = currentNode;
            currentNode = currentNode.next;
        }
        return false;
    } // сделал

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object element : c) {
            if (!this.contains(element)) return false;
        }
        return true;
    } // сделал

    @Override
    public boolean addAll(Collection<? extends Employee> c) {
        Node currentNode = head;
        for (int count = 0; count < size; count++) {
            currentNode = currentNode.next;
        }

        for (Employee employee : c) {
            Node newNode = new Node(employee);

            if (head == null) {
                head = new Node();
                head.next = newNode;
            } else {
                currentNode.next = newNode;
            }
            size++;
            if (currentNode == null) return false;
            currentNode = currentNode.next;
        }
        return true;
    } // сделал

    @Override
    public boolean addAll(int index, Collection<? extends Employee> c) {
        if (index > size || index < 0) return false;
        Node currentNode = head;
        Node prevNode = null;

        for (int count = 0; count <= index; count++) {
            prevNode = currentNode;
            currentNode = currentNode.next;
        }
        for (Employee employee : c) {
            Node newNode = new Node(employee);

            newNode.next = currentNode;
            prevNode.next = newNode;
            prevNode = newNode;
            size++;
        }
        return true;
    } // сделал

    @Override
    public boolean removeAll(Collection<?> c) {
        for (Object o : c) {
            Node currentNode = head;
            Node prevNode = null;

            for (int count = 0; count < size; count++) {
                prevNode = currentNode;
                currentNode = currentNode.next;
                if (currentNode.employee.equals(o)) {
                    prevNode.next = currentNode.next;
                    size--;
                    break;
                }
            }
        }
        return true;
    } // сделал

    @Override
    public boolean retainAll(Collection<?> c) {
        if (head == null) return false;

        Node currentNode = head;
        Node prevNode;
        int counter = 0;

        for (int count = 0; count < size; count++) {
            prevNode = currentNode;
            currentNode = currentNode.next;
            if (!c.contains(currentNode.employee)) {
                prevNode.next = currentNode.next;
                currentNode = currentNode.next;
                counter++;
            }
        }
        size -= counter;
        return true;
    } // сделал

    @Override
    public void clear() {
        Node currentNode;
        Node bufferNode = head.next;

        for (int count = 0; count < size; count++) {
            currentNode = bufferNode;
            bufferNode = bufferNode.next;
            currentNode.employee = null;
            currentNode.next = null;
        }
        head = null;
        size = 0;
    } // сделал

    @Override
    public Employee get(int index) {
        Node currentNode = head;

        if (index > size || index < 0) return null;

        for (int count = 0; count < size; count++) {
            currentNode = currentNode.next;
            if (count == index) return currentNode.employee;
        }
        return null;
    } // сделал

    @Override
    public Employee set(int index, Employee element) {
        Node currentNode = head;

        if (index > size || index < 0) return null;

        for (int count = 0; count < size; count++) {
            currentNode = currentNode.next;
            if (count == index) return currentNode.employee = element;
        }
        return null;
    } // сделал

    @Override
    public void add(int index, Employee element) {
        Node newNode = new Node(element);
        Node currentNode = head;
        Node prevNode;
        if (index > size || index < 0) return;
        size++;

        for (int count = 0; count < size; count++) {
            prevNode = currentNode;
            currentNode = currentNode.next;
            if (index == count) {
                newNode.next = currentNode;
                prevNode.next = newNode;
            }
        }
    } // сделал

    @Override
    public Employee remove(int index) {
        Node currentNode = head;
        Node prevNode;
        Employee delete;

        if (index > size || index < 0) return null;

        for (int count = 0; count < size; count++) {
            prevNode = currentNode;
            currentNode = currentNode.next;
            if (index == count) {
                delete = currentNode.employee;
                prevNode.next = currentNode.next;
                size--;
                return delete;
            }
        }
        return null;
    } // сделал

    @Override
    public int indexOf(Object o) {
        Node currentNode = head;

        for (int count = 0; count < size; count++) {
            currentNode = currentNode.next;
            if (currentNode.employee.equals(o)) return count;
        }
        return -1;
    } // сделал

    @Override
    public int lastIndexOf(Object o) {
        Node currentNode = head;
        int index = -1;

        for (int count = 0; count < size; count++) {
            currentNode = currentNode.next;
            if (currentNode.employee.equals(o)) index = count;
        }
        return index;
    } // сделал

    @Override
    public ListIterator<Employee> listIterator() {
        return null;
    } // не надо

    @Override
    public ListIterator<Employee> listIterator(int index) {
        return null;
    } // не надо

    @Override
    public List<Employee> subList(int fromIndex, int toIndex) {
        Node currentNode = head;
        List<Employee> list = new ProjectList();
        if (fromIndex < 0 || fromIndex > size || toIndex < 0 || toIndex > size) return list;

        for (int count = 0; count < fromIndex; count++) {
            currentNode = currentNode.next;
        }
        for (int count = fromIndex; count < toIndex; count++) {
            currentNode = currentNode.next;
            list.add(currentNode.employee);
        }
        return list;
    } // сделал

    public static class Node {
        Employee employee;
        Node next;

        Node(Employee employee) {
            this.employee = employee;
            this.next = null;
        }

        Node() {
            this.employee = null;
            this.next = null;
        }
    }

}
