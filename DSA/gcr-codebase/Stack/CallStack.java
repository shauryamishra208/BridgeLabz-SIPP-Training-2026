public class CallStack {

    static class Stack {
        private static class Frame {
            final String functionName;
            final Frame next;

            Frame(String name, Frame next) {
                this.functionName = name;
                this.next = next;
            }
        }

        private Frame top = null;
        private int size = 0;

        void push(String functionName) {
            top = new Frame(functionName, top);
            size++;
        }

        String pop() {
            if (isEmpty()) throw new RuntimeException("No active call to return from");
            String name = top.functionName;
            top = top.next;
            size--;
            return name;
        }

        String peek() {
            if (isEmpty()) throw new RuntimeException("No active call");
            return top.functionName;
        }

        boolean isEmpty() {
            return top == null;
        }

        int depth() {
            return size;
        }
    }

    public static void main(String[] args) {
        Stack calls = new Stack();

        calls.push("main");
        calls.push("parseArgs");
        System.out.println("current -> " + calls.peek());
        System.out.println("returned -> " + calls.pop());

        calls.push("loadConfig");
        calls.push("readFile");
        calls.push("decodeBytes");
        System.out.println("depth -> " + calls.depth());

        System.out.println("returned -> " + calls.pop());
        System.out.println("returned -> " + calls.pop());
        System.out.println("returned -> " + calls.pop());
        System.out.println("current -> " + calls.peek());
        System.out.println("returned -> " + calls.pop());
        System.out.println("isEmpty -> " + calls.isEmpty());

        try {
            calls.pop();
        } catch (RuntimeException e) {
            System.out.println("pop on empty threw: " + e.getMessage());
        }
    }
}
