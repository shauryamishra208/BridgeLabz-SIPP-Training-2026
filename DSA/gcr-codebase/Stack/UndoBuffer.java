public class UndoBuffer {

    static class Buffer {
        private final String[] data;
        private int top;

        Buffer(int maxDepth) {
            data = new String[maxDepth];
            top = -1;
        }

        boolean push(String edit) {
            if (top == data.length - 1) return false;
            data[++top] = edit;
            return true;
        }

        String pop() {
            if (isEmpty()) throw new RuntimeException("Nothing to undo");
            String edit = data[top];
            data[top] = null;
            top--;
            return edit;
        }

        String peek() {
            if (isEmpty()) throw new RuntimeException("No edits recorded");
            return data[top];
        }

        boolean isEmpty() {
            return top == -1;
        }

        boolean isFull() {
            return top == data.length - 1;
        }

        int size() {
            return top + 1;
        }
    }

    public static void main(String[] args) {
        Buffer buffer = new Buffer(3);

        System.out.println("push edit1 -> " + buffer.push("edit1"));
        System.out.println("push edit2 -> " + buffer.push("edit2"));
        System.out.println("push edit3 -> " + buffer.push("edit3"));
        System.out.println("push edit4 -> " + buffer.push("edit4"));

        System.out.println("peek -> " + buffer.peek());
        System.out.println("size -> " + buffer.size());

        System.out.println("pop -> " + buffer.pop());
        System.out.println("pop -> " + buffer.pop());
        System.out.println("push edit5 -> " + buffer.push("edit5"));
        System.out.println("peek -> " + buffer.peek());

        System.out.println("pop -> " + buffer.pop());
        System.out.println("pop -> " + buffer.pop());
        System.out.println("isEmpty -> " + buffer.isEmpty());

        try {
            buffer.pop();
        } catch (RuntimeException e) {
            System.out.println("pop on empty threw: " + e.getMessage());
        }
    }
}
