package ru.avalov.javapp.j110.onedirlist;

public class Main {
    public static void main(String[] args) {
        OneDirList lst = new OneDirList();
        lst.addToTail("str1");
        lst.addToTail("str2");
        lst.addToTail(123);
        lst.printContent();
        
        lst.addToHead("head1");
        lst.addToHead(3.1415926);
        lst.printContent();
        
        lst.removeFromHead();
        lst.removeFromTail();
        lst.printContent();

        lst.addToTail(123);
        lst.printContent();
    }
}
