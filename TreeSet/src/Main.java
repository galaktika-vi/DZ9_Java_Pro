import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Выберите задачу для выполнения:");
            System.out.println("1. Замер времени на добавление элементов в различные коллекции");
            System.out.println("2. Работа с TreeSet");
            System.out.println("3. Создание и работа с HashSet (объекты Window)");
            System.out.println("4. Удаление дубликатов из ArrayList");
            System.out.println("5. Подсчет уникальных и дублирующихся элементов в ArrayList");
            System.out.println("0. Выход");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    measureTimeForCollections();
                    break;
                case 2:
                    performTreeSetOperations();
                    break;
                case 3:
                    performHashSetOperations();
                    break;
                case 4:
                    removeDuplicatesFromArrayList();
                    break;
                case 5:
                    countUniqueAndDuplicateElements();
                    break;
                case 0:
                    System.out.println("Программа завершена.");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
    }

    private static void measureTimeForCollections() {
        final int numElements = 10_000_000;
        ArrayList<Integer> arrayList = new ArrayList<>(numElements);
        LinkedList<Integer> linkedList = new LinkedList<>();
        TreeSet<Integer> treeSet = new TreeSet<>();
        HashSet<Integer> hashSet = new HashSet<>();

        Random random = new Random();

        long startTime = System.nanoTime();
        for (int i = 0; i < numElements; i++) {
            arrayList.add(random.nextInt());
        }
        long arrayListTime = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        for (int i = 0; i < numElements; i++) {
            linkedList.add(random.nextInt());
        }
        long linkedListTime = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        for (int i = 0; i < numElements; i++) {
            treeSet.add(random.nextInt());
        }
        long treeSetTime = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        for (int i = 0; i < numElements; i++) {
            hashSet.add(random.nextInt());
        }
        long hashSetTime = System.nanoTime() - startTime;

        System.out.println("Замер времени для " + numElements + " элементов:");
        System.out.println("ArrayList: " + arrayListTime / 1_000_000 + " мс");
        System.out.println("LinkedList: " + linkedListTime / 1_000_000 + " мс");
        System.out.println("TreeSet: " + treeSetTime / 1_000_000 + " мс");
        System.out.println("HashSet: " + hashSetTime / 1_000_000 + " мс");
    }

    private static void performTreeSetOperations() {
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < 100; i++) {
            treeSet.add(ThreadLocalRandom.current().nextInt(0, 101));
        }
        findClosestNumbers(treeSet, 56);
        findClosestNumbers(treeSet, 70);
        findClosestNumbers(treeSet, 40);
        findClosestNumbers(treeSet, 10);
        findNumbersInRange(treeSet, 10, 30);
        findNumbersInRange(treeSet, 30, 40);
        findNumbersInRange(treeSet, 40, 50);
        findNumbersLessThan(treeSet, 40);
    }

    private static void findClosestNumbers(TreeSet<Integer> treeSet, int target) {
        Integer floor = treeSet.floor(target);
        Integer ceiling = treeSet.ceiling(target);

        System.out.println("Для числа " + target + ":");
        System.out.println("Ближайшее число меньше или равное: " + floor);
        System.out.println("Ближайшее число больше или равное: " + ceiling);
    }

    private static void findNumbersInRange(TreeSet<Integer> treeSet, int from, int to) {
        SortedSet<Integer> subSet = treeSet.subSet(from, to);
        System.out.println("Для интервала [" + from + ".." + to + "): " + subSet);
    }

    private static void findNumbersLessThan(TreeSet<Integer> treeSet, int target) {
        SortedSet<Integer> headSet = treeSet.headSet(target);
        System.out.println("Числа меньше " + target + ": " + headSet);
    }

    private static void performHashSetOperations() {
        HashSet<Window> windowSet = new HashSet<>();
        windowSet.add(new Window(50, 60, 80, "Прозрачное"));
        windowSet.add(new Window(40, 70, 90, "Тонированное"));
        windowSet.add(new Window(50, 60, 80, "Прозрачное"));
        windowSet.add(new Window(30, 80, 100, "Тонированное"));

        System.out.println("Множество объектов Window:");
        for (Window window : windowSet) {
            System.out.println(window);
        }
    }

    private static class Window {
        private int weight;
        private int width;
        private int height;
        private String glassType;

        public Window(int weight, int width, int height, String glassType) {
            this.weight = weight;
            this.width = width;
            this.height = height;
            this.glassType = glassType;
        }

        @Override
        public String toString() {
            return "Window{" +
                    "weight=" + weight +
                    ", width=" + width +
                    ", height=" + height +
                    ", glassType='" + glassType + '\'' +
                    '}';
        }

        @Override
        public int hashCode() {
            return Objects.hash(weight, width, height, glassType);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Window window = (Window) o;
            return weight == window.weight &&
                    width == window.width &&
                    height == window.height &&
                    Objects.equals(glassType, window.glassType);
        }
    }

    private static void removeDuplicatesFromArrayList() {
        ArrayList<Integer> listWithDuplicates = new ArrayList<>(Arrays.asList(1, 2, 2, 3, 4, 4, 4));
        removeDuplicates(listWithDuplicates);
        System.out.println("ArrayList после удаления дубликатов: " + listWithDuplicates);

        ArrayList<Integer> listWithDuplicates2 = new ArrayList<>(Arrays.asList(12, 23, 23, 34, 45, 45, 45, 45, 57, 67, 89));
        removeDuplicates(listWithDuplicates2);
        System.out.println("ArrayList после удаления дубликатов: " + listWithDuplicates2);
    }

    private static void removeDuplicates(ArrayList<Integer> list) {
        Set<Integer> uniqueSet = new HashSet<>(list);
        list.clear();
        list.addAll(uniqueSet);
    }

    private static void countUniqueAndDuplicateElements() {
        ArrayList<Integer> listWithDuplicates = new ArrayList<>(generateRandomNumbers(1000, 1, 100));
        int uniqueCount = countUniqueElements(listWithDuplicates);
        int duplicateCount = listWithDuplicates.size() - uniqueCount;
        System.out.println("Количество уникальных элементов: " + uniqueCount);
        System.out.println("Количество дублирующихся элементов: " + duplicateCount);
    }

    private static int countUniqueElements(ArrayList<Integer> list) {
        Set<Integer> uniqueSet = new HashSet<>(list);
        return uniqueSet.size();
    }

    private static List<Integer> generateRandomNumbers(int count, int min, int max) {
        List<Integer> numbers = new ArrayList<>(count);
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            numbers.add(random.nextInt(max - min + 1) + min);
        }
        return numbers;
    }
}

