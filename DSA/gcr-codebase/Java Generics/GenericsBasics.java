import java.util.ArrayList;
import java.util.List;

public class GenericsBasics {
    static class Pair<T, U> {
        private T first;
        private U second;

        public Pair(T first, U second) {
            this.first = first;
            this.second = second;
        }

        public T getFirst() { return first; }
        public U getSecond() { return second; }

        @Override
        public String toString() {
            return "(" + first + ", " + second + ")";
        }
    }

    static class Stack<T> {
        private final List<T> elements = new ArrayList<>();

        public void push(T item) {
            elements.add(item);
        }

        public T pop() {
            if (isEmpty()) {
                throw new RuntimeException("Stack is empty");
            }
            return elements.remove(elements.size() - 1);
        }

        public T peek() {
            if (isEmpty()) {
                throw new RuntimeException("Stack is empty");
            }
            return elements.get(elements.size() - 1);
        }

        public boolean isEmpty() {
            return elements.isEmpty();
        }

        public int size() {
            return elements.size();
        }
    }

    static <T extends Comparable<T>> T findMax(T[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array must not be empty");
        }
        T max = arr[0];
        for (T item : arr) {
            if (item.compareTo(max) > 0) {
                max = item;
            }
        }
        return max;
    }

    static class Repository<T> {
        private final List<T> entities = new ArrayList<>();

        public void add(T entity) {
            entities.add(entity);
        }

        public boolean remove(T entity) {
            return entities.remove(entity);
        }

        public T get(int index) {
            return entities.get(index);
        }

        public List<T> getAll() {
            return entities;
        }

        public int count() {
            return entities.size();
        }
    }

    static void printList(List<?> list) {
        for (Object obj : list) {
            System.out.print(obj + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Pair<String, Integer> pair = new Pair<>("Age", 25);
        System.out.println("Pair: " + pair);

        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("Stack peek: " + stack.peek());
        System.out.println("Stack pop: " + stack.pop());
        System.out.println("Stack size after pop: " + stack.size());

        Integer[] numbers = {5, 12, 3, 9, 27, 1};
        System.out.println("Max number: " + findMax(numbers));

        String[] words = {"banana", "apple", "cherry"};
        System.out.println("Max word (lexicographically): " + findMax(words));

        Repository<String> userRepo = new Repository<>();
        userRepo.add("Alice");
        userRepo.add("Bob");
        userRepo.add("Charlie");
        System.out.println("Repository entities: " + userRepo.getAll());
        System.out.println("Repository count: " + userRepo.count());

        List<Integer> intList = List.of(1, 2, 3);
        List<String> strList = List.of("x", "y", "z");
        System.out.print("Int list: ");
        printList(intList);
        System.out.print("String list: ");
        printList(strList);
    }
}
