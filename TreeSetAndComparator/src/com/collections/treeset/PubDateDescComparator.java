package com.collections.treeset;

import java.util.Collections;
import java.util.Comparator;

public class PubDateDescComparator implements Comparator <Book>{
    @Override
    public int compare(Book o1, Book o2) {
        return ((Book)o2).getYear().compareTo((Book)o1).getYear();
    }
}
