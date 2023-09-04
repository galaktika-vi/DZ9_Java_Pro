import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;


public class LinkedListMerger {
    public static LinkedList<Integer> mergeSortedLinkedLists(LinkedList<Integer> list1, LinkedList<Integer> list2) {
        LinkedList<Integer> mergedList = new LinkedList<>();
        ListIterator<Integer> iter1 = list1.listIterator();
        ListIterator<Integer> iter2 = list2.listIterator();

        Integer value1 = null;
        Integer value2 = null;

        if (iter1.hasNext()) {
            value1 = iter1.next();
        }

        if (iter2.hasNext()) {
            value2 = iter2.next();
        }

        while (value1 != null && value2 != null) {
            if (value1 < value2) {
                mergedList.add(value1);
                if (iter1.hasNext()) {
                    value1 = iter1.next();
                } else {
                    value1 = null;
                }
            } else if (value1 > value2) {
                mergedList.add(value2);
                if (iter2.hasNext()) {
                    value2 = iter2.next();
                } else {
                    value2 = null;
                }
            } else {
                mergedList.add(value1);
                mergedList.add(value2);
                if (iter1.hasNext()) {
                    value1 = iter1.next();
                } else {
                    value1 = null;
                }
                if (iter2.hasNext()) {
                    value2 = iter2.next();
                } else {
                    value2 = null;
                }
            }
        }

        while (value1 != null) {
            mergedList.add(value1);
            if (iter1.hasNext()) {
                value1 = iter1.next();
            } else {
                value1 = null;
            }
        }

        while (value2 != null) {
            mergedList.add(value2);
            if (iter2.hasNext()) {
                value2 = iter2.next();
            } else {
                value2 = null;
            }
        }

        return mergedList;
    }

    public static void main(String[] args) {
        LinkedList<Integer> list1 = new LinkedList<>(List.of(1, 2, 4));
        LinkedList<Integer> list2 = new LinkedList<>(List.of(1, 3, 4));

        LinkedList<Integer> mergedList = mergeSortedLinkedLists(list1, list2);
        System.out.println(mergedList);
    }
}
