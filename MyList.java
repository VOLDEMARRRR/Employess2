package humanResourses;

import java.util.*;

public class MyList implements List<BusinessTravel> {
    public Node head;
    int size = 0;

    public MyList(){
        head = null;
    }

    public boolean add(BusinessTravel businessTravel) {
        Node newNode = new Node(businessTravel);
        Node currentNode = head;

        if (head == null) {
            head = new Node();
            head.next = newNode;
            size++;
        } else {
            for (int count = 0; count < size; count++) {
                currentNode = currentNode.next;
            }
            currentNode.next = newNode;
            newNode.next = head.next;
            size++;
        }
        return true;
    } // сделал

    @Override
    public boolean remove(Object o) {
        Node currentNode = head.next;
        Node prevNode;

        if (currentNode.businessTravel.equals(o)) {
            head.next = currentNode.next;
            for (int count = 1; count < size; count++) {
                currentNode = currentNode.next;
            }
            currentNode.next = head.next;
            size--;
            return true;
        }
        for (int count = 1; count < size; count++) {
            prevNode = currentNode;
            currentNode = currentNode.next;
            if (currentNode.businessTravel.equals(o)) {
                prevNode.next = currentNode.next;
                size--;
                return true;
            }
        }
        return false;
    } // сделал

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends BusinessTravel> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends BusinessTravel> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        head.next = null;
        head = null;
        size = 0;
    } // сделал

    @Override
    public BusinessTravel get(int index) {
        Node currentNode = head;

        if (index > size || index < 0) return null;

        for (int count = 0; count < size; count++) {
            currentNode = currentNode.next;
            if (count == index) return currentNode.businessTravel;
        }
        return null;
    } // сделал

    @Override
    public BusinessTravel set(int index, BusinessTravel element) {
        Node currentNode = head;

        if (index > size || index < 0) return null;

        for (int count = 0; count < size; count++) {
            currentNode = currentNode.next;
            if (count == index) return currentNode.businessTravel = element;
        }
        return null;
    } // сделал

    @Override
    public void add(int index, BusinessTravel element) {
        Node newNode = new Node(element);
        Node currentNode = head.next;
        Node prevNode;

        if (index == 0) {
            newNode.next = currentNode;
            head.next = newNode;
            for (int count = 1; count < size; count++) {
                currentNode = currentNode.next;
            }
            currentNode.next = head.next;
            size++;
        } else {
            for (int count = 1; count < size; count++) {
                prevNode = currentNode;
                currentNode = currentNode.next;
                if (index == count) {
                    newNode.next = currentNode;
                    prevNode.next = newNode;
                    size++;
                }
            }
        }
    } // сделал

    @Override
    public BusinessTravel remove(int index) {
        Node currentNode = head.next;
        Node prevNode;
        BusinessTravel delete;

        if (index > size || index < 0) return null;

        if (index == 0) {
            delete = currentNode.businessTravel;
            head.next = currentNode.next;
            for (int count = 1; count < size; count++) {
                currentNode = currentNode.next;
            }
            currentNode.next = head.next;
            size--;
            return delete;
        }

        for (int count = 1; count < size; count++) {
            prevNode = currentNode;
            currentNode = currentNode.next;
            if (index == count) {
                delete = currentNode.businessTravel;
                prevNode.next = currentNode.next;
                size--;
                return delete;
            }
        }
        return null;
    } //сделал

    @Override
    public int indexOf(Object o) {
        Node currentNode = head.next;

        for (int count = 0; count < size; count++) {
            if (currentNode.businessTravel.equals(o)) return count;
            currentNode = currentNode.next;
        }
        return -1;
    } // сделал

    @Override
    public int lastIndexOf(Object o) {
        Node currentNode = head.next;
        int index = -1;

        for (int count = 0; count < size; count++) {
            if (currentNode.businessTravel.equals(o)) index = count;
            currentNode = currentNode.next;
        }
        return index;
    } // сделал

    @Override
    public ListIterator<BusinessTravel> listIterator() {
        return null;
    } // Не надо

    @Override
    public ListIterator<BusinessTravel> listIterator(int index) {
        return null;
    } // Не надо

    @Override
    public List<BusinessTravel> subList(int fromIndex, int toIndex) {
        Node currentNode = head;

        for (int count = 0; count <= fromIndex; count++) {
            currentNode = currentNode.next;
        }
        List<BusinessTravel> list = new MyList();
        for (int count = fromIndex; count < toIndex; count++) {
            list.add(currentNode.businessTravel);
            currentNode = currentNode.next;
        }
        return list;
    } // сделал

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
        Node currentNode = head.next;

        for (int count = 0; count < size; count++) {
            if (currentNode.businessTravel.equals(o)) return true;
            currentNode = currentNode.next;
        }
        return false;
    } // сделал

    @Override
    public Iterator<BusinessTravel> iterator() {
        return new Iterator<BusinessTravel>() {
            Node currentNode = head.next;
            int count = 0;

            @Override
            public boolean hasNext() {
                return count < size;
            }

            @Override
            public BusinessTravel next() {
                BusinessTravel element = currentNode.businessTravel;
                currentNode = currentNode.next;
                count++;
                return element;
            }
        };
    } // сделал

    @Override
    public Object[] toArray() {
        BusinessTravel[] mas = new BusinessTravel[size()];
        Node currentNode = head.next;
        for (int count = 0; count < size; count++) {
            mas[count] = currentNode.businessTravel;
            currentNode = currentNode.next;
        }
        return mas;
    } // сделал

    @Override
    public <T> T[] toArray(T[] a) {
        if (a.length < size) {
            a = (T[])java.lang.reflect.Array.newInstance(a.getClass().getComponentType(), size);
        }

        Object[] result = a;
        Node currentNode = head.next;
        for (int count = 0; count < size; count++) {
            result[count] = currentNode.businessTravel;
            currentNode = currentNode.next;
        }

        if (a.length > size) a[size] = null;

        return a;
    } // сделал

    public void print(){
        Node currentNode = head;

        for (int count = 0; count < size; count++) {
            currentNode = currentNode.next;
            System.out.println(currentNode.businessTravel);
        }
    }

    public class Node {
        BusinessTravel businessTravel;
        Node next;

        Node(BusinessTravel businessTravel) {
            this.businessTravel = businessTravel;
            this.next = null;
        }

        Node(){
            this.businessTravel = null;
            this.next = null;
        }
    }

}

