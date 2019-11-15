package com.company;


public class DoublyLinkedList<T> {

    private int size = 0;
    private Node<T> head = null;
    private Node<T> tail = null;

    private static class Node<T> {
        private T data;
        private Node<T> prevNode;
        private Node<T> nextNode;

        public Node(T data, Node<T> prevNode, Node<T> nextNode) {
            this.data = data;
            this.prevNode = prevNode;
            this.nextNode = nextNode;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }


    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return (getSize()==0);
    }

//Adder functions*******************************************************************

    public void addToTail(T data){
        if(isEmpty()){
            head = tail = new Node<T>(data, null, null);
        }else {
            tail.nextNode = new Node<T>(data, tail, null);
            tail = tail.nextNode;
        }
        size++;
    }

    public void addToHead(T data){
        if(isEmpty()){
            head = tail = new Node<T>(data, null, null);
        }else {
            head.prevNode = new Node<T>(data, null, head);
            head = head.prevNode;
        }
        size++;
    }

    public void addAfterIndex(Node prevNode, T data){


    }


//Adder functions*******************************************************************



    public T peekFirst(){
        if(isEmpty()){
            throw new RuntimeException("Empty List!");
        }
        return head.data;
    }

    public T peekLast(){
        if(isEmpty()){
            throw new RuntimeException("Empty List!");
        }
        return tail.data;
    }

    public T popFront(){
        if(isEmpty()){
            throw new RuntimeException("Empty List!");
        }

        T data = head.data;
        head = head.nextNode;
        size--;

        if(isEmpty())   tail = null;
        else   head.prevNode = null;

        return data;
    }

    public T popBack(){
        if(isEmpty()){
            throw new RuntimeException("Empty List!");
        }

        T data = tail.data;
        tail = tail.prevNode;
        size--;

        if(isEmpty()) head = null;
        else tail.nextNode = null;

        return data;
    }


//Checked for the head and tail

    public T removeAtIndex(int index){
        if(index < 0 || index >=size){
            throw new IllegalArgumentException("Index out of bounds!");
        }

        Node<T> current = head;
        T data = current.data;
        int i;


        if(index == 0){
            head = head.nextNode;
            head.prevNode = null;

        }else if(index == getSize() - 1){
            data = tail.data;
            tail = tail.prevNode;
            tail.nextNode = null;
        }else {

            if (index < size / 2) {
                current = head;
                for (i = 0; i != index; i++) {
                    current = current.nextNode;
                }
            } else {
                current = tail;
                for (i = size - 1; i != index; i--) {
                    current = current.prevNode;
                }
            }

            data = current.data;
            current.nextNode.prevNode = current.prevNode;
            current.prevNode.nextNode = current.nextNode;
            current = null;
        }
        size--;
        return data;
    }

    public boolean remove(Object obj) {
        Node<T> trav = head;

        // Support searching for null
        if (obj == null) {
            for (trav = head; trav != null; trav = trav.nextNode) {
                if (trav.data == null) {
                    remove(trav);
                    return true;
                }
            }
            // Search for non null object
        } else {
            for (trav = head; trav != null; trav = trav.nextNode) {
                if (obj.equals(trav.data)) {
                    remove(trav);
                    return true;
                }
            }
        }
        return false;
    }

    public int indexOf(Object obj) {
        int index = 0;
        Node<T> trav = head;


        // Support searching for null
        if (obj == null) {
            for (; trav != null; trav = trav.nextNode, index++) {
                if (trav.data == null) {
                    return index;
                }
            }
            // Search for non null object
        } else
            for (; trav != null; trav = trav.nextNode, index++) {
                if (obj.equals(trav.data)) {
                    return index;
                }
            }

        return -1;
    }

    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        //sb.append("[ ");

        Node<T> trav = head;
        while (trav != null) {
            sb.append(trav.data + ", ");
            trav = trav.nextNode;
        }

        sb.deleteCharAt(sb.length() - 1);
        sb.deleteCharAt(sb.length() - 1);

        sb.append("]");
        return sb.toString();
    }

}
