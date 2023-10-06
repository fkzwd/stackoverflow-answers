package com.vk.dwzkf.stackoverflow.question_77243700;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author Roman Shageev
 * @since 06.10.2023
 */
public class Answer77243700 {
    public static Comparator<String> emptyValuesFirst() {
        return new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == 0 && o2.length() == 0) {
                    //if both strings empty they are same
                    return 0;
                } else if (o1.length() == 0) {
                    //if o1 is empty then it less than o2
                    return -1;
                } else if (o2.length() == 0) {
                    //if o2 is empty then o1 is greater then 02
                    return 1;
                } else {
                    //string are equals comparing by *is empty*
                    return 0;
                }
            }
        };
    }

    public static void main(String[] args) {
        List<String> valuesInSortedColumn = new ArrayList<>();
        valuesInSortedColumn.add("a");
        valuesInSortedColumn.add("zz");
        valuesInSortedColumn.add("b");
        valuesInSortedColumn.add("c");
        valuesInSortedColumn.add("zz");
        valuesInSortedColumn.add("");
        valuesInSortedColumn.add("");
        valuesInSortedColumn.sort(
                //all empty strings are less then non-empty
                //all non empty strings reverse-compared
                emptyValuesFirst().thenComparing(Comparator.reverseOrder())
        );
        System.out.println(valuesInSortedColumn);
    }
}
