package com.collections.treeset;

import java.util.Collections;
import java.util.Comparator;

public class PubDateDescComparator implements Comparator <Book>{
    @Override
    public int compare(Book o1, Book o2) {
        return (o2.getYear()).compareTo(o1.getYear());
    }
}
