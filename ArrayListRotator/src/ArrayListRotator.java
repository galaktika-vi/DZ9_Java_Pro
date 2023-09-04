import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayListRotator {
    public static void rotateArrayList(ArrayList<Integer> arrayList, int k) {
        int n = arrayList.size();
        if (n == 0) {
            return;
        }

        k %= n;

        if (k < 0) {
            k += n;
        }

        Collections.rotate(arrayList, k);
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        int k = 3;

        rotateArrayList(arrayList, k);
        System.out.println(arrayList);
    }
}
