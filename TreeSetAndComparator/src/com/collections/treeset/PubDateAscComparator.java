package com.collections.treeset;

import java.util.Comparator;

public class PubDateAscComparator implements Comparator<Book> {

    @Override
    public int compare(Book o1, Book o2) {
        return ((Book)o1).getYear().compareTo((Book)o2).getYear();
        }
}


