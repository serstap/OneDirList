package ru.avalov.javapp.j110.onedirlist;

public class OneDirList {
    private ListItem head;
    private ListItem tail;
    
    public void addToHead(Object val) {
        if(head != null) {
            ListItem nh = new ListItem(val);// (1)
            nh.next = head;                 // (2)
            head = nh;                      // (3)
        } else
            head = tail = new ListItem(val);
    }
    
    public Object peekFromHead() {
        if(head != null)
            return head.value;
        else
            return null;
    }
    
    public Object removeFromHead() {
        if(head == null)
            return null;
        
        Object res = head.value;
        head = head.next;  // (1)
        if(head == null)
            tail = null;
        return res;
    }
    
    public void addToTail(Object val) {
        if(tail != null) {
            tail.next = new ListItem(val);  // (1)
            tail = tail.next;               // (2)
        } else
            head = tail = new ListItem(val);
    }
    
    public Object peekFromTail() {
        if(tail != null)
            return tail.value;
        else
            return null;
    }
    
    public Object removeFromTail() {
        if(head == null)
            return null;
        
        if(head == tail) {
            Object res = head.value;
            head = tail = null;
            return res;
        }
        
        ListItem prv = head,
                nxt = head.next;
        while(nxt != tail) {
            prv = nxt;
            nxt = nxt.next;
        }
        
        tail = prv;
        tail.next = null;
        return nxt.value;
    }
    
    public boolean contains(Object val) {
        ListItem li = head;
        while(li != null) {
            if(li.value == null && val == null
                    || li.value != null && li.value.equals(val))
                return true;
            li = li.next;
        }
        return false;
    }
    
    public boolean isEmpty() {
        return head == null;
    }
    
    public void printContent() {
        ListItem li = head;
        while(li != null) {
            System.out.println(li.value);
            li = li.next;
        }
        System.out.println();
    }
    
    private static class ListItem {
        Object value;
        ListItem next;

        ListItem(Object value) {
            this.value = value;
        }
    }
}
