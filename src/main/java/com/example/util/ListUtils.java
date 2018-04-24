package com.example.util;

import java.util.List;

public class ListUtils {

    public static boolean isEmpty(List list){
        return null == list || list.isEmpty() || Integer.compare(list.size(),0)<=0;
    }

    public static boolean isNotEmpty(List list){
        return !isEmpty(list);
    }

}
