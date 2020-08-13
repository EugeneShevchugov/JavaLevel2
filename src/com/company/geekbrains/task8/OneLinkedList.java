package com.company.geekbrains.task8;

public class OneLinkedList {
    private Node head;
    private Node tail;
    private int size;

    public OneLinkedList() {
        head = null;
        tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void add(String val) {
        Node newNode = new Node(val);
        if (isEmpty()) {
            head = newNode;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
        }
        tail = newNode;
        size++;
    }

    public void add(int index, String val) {
        if (index == 0) {
            Node node = new Node(val);
            node.next = head;
            head = node;
            return;
        }
        checkIndex(index);
        if (index == size) {
            add(val);
        } else {
            int currentIndex = 1;
            Node current = head.next;
            while (currentIndex != index) {
                current = current.next;
                currentIndex++;
            }
            Node node = new Node(val);
            node.previous = current.previous;
            node.previous.next = node;
            current.previous = node;
            node.next = current;
        }
        size++;
    }

    public void remove(int index) {
        checkIndex(index);
        if (index == size) {
            removeLast();
            return;
        }
        if (index == 0) {
            removeFirst();
            return;
        }
        int currentIndex = 1;
        Node current = head.next;
        while (currentIndex != index) {
            current = current.next;
            currentIndex++;
        }
        current.previous.next = current.next;
        current.next.previous = current.previous;
    }

    public void removeFirst() {
        if (head.next == null) {
            tail = null;
        } else {
            head.next.previous = null;
        }
        head = head.next;
    }

    public void removeLast() {
        if (head.next == null) {
            head = null;
        } else {
            tail.previous.next = null;
        }
        tail = tail.previous;
    }

    public int size() {
        return size;
    }

    public Iterator iterator() {
        return new Iterator(head);
    }

    private void checkIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexExceedsSizeLengthException("Ошибка индексации");
        }
    }

    private static class Node {
        private String value;
        private Node next;
        private Node previous;

        public Node(String value) {
            this.value = value;
        }

        public Node(String value, Node next, Node previous) {
            this.value = value;
            this.next = next;
            this.previous = previous;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getPrevious() {
            return previous;
        }

        public void setPrevious(Node previous) {
            this.previous = previous;
        }

        public String getValue() {
            return value == null ? "null" : value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    @Override
    public String toString() {
        return "OneLinkedList{" +
                "head=" + head +
                ", tail=" + tail +
                '}';
    }

    public static class Iterator {
        private Node head;
        private Node current;

        private Iterator() {
        }

        private Iterator(Node current) {
            this.head = current;
        }

        public boolean hasNext() {
            if (current == null) {
                return head != null;
            }
            return current.next != null;
        }

        public String next() {
            if (current == null) {
                current = head;
            } else {
                current = current.next;
            }
            return current.getValue();
        }
    }
}
