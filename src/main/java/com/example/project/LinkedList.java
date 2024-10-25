package com.example.project;

public class LinkedList<T> implements List<T>{
	private Node<T> head;
	private Node<T> current;
	
    public LinkedList() {
		head = current = null;
	}
	public boolean empty() {
		return head == null;
	}
	public boolean last() {
		return current.next == null;
	}
    public boolean full() {
        return false;
    }
    public void findFirst() {
        current = head;
    }
    public void findNext() {
        current = current.next;
    }
    public T retrieve() {
        return current.data;
    }
    public void update(T e) {
        current.data = e;
    }
    public void insert(T e) {
        if (empty()) {
            current = head = new Node<T>(e);
        } else {
            Node<T> tmp = current.next;
            current.next = new Node<T>(e);
            current = current.next;
            current.next = tmp;
        }
    }
    public void remove() {
        if (current == head) {
            head = head.next;
        } else {
            Node<T> tmp = head;
            while (tmp.next != current) {
                tmp = tmp.next;
            }
            tmp.next = current.next;
        }
        if (current.next == null) {
            current = head;
        } else {
            current = current.next;
        }
    }

public T mostFrequentElement() {
        throw new UnsupportedOperationException("Not supported yet.");
    if (empty()) {
        return null; // or throw exception
    }
    
    Map<T, Integer> frequencyMap = new HashMap<>();
    Node<T> temp = head;

    while (temp != null) {
        frequencyMap.put(temp.data, frequencyMap.getOrDefault(temp.data, 0) + 1);
        temp = temp.next;
    }

    T mostFrequent = null;
    int maxCount = 0;

    for (Map.Entry<T, Integer> entry : frequencyMap.entrySet()) {
        if (entry.getValue() > maxCount) {
            maxCount = entry.getValue();
            mostFrequent = entry.getKey();
        }
    }

    return mostFrequent;
}

}
