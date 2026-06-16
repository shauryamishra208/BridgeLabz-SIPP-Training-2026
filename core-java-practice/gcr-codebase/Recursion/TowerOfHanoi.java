public class TowerOfHanoi {

    static void towerOfHanoi(int n, char source, char destination, char auxiliary) {
        if (n == 0) {
            return;
        }

        towerOfHanoi(n - 1, source, auxiliary, destination);

        System.out.println("Move disk " + n + " from " + source + " to " + destination);

        towerOfHanoi(n - 1, auxiliary, destination, source);
    }

    public static void main(String[] args) {
        int N = 3;
        towerOfHanoi(N, 'A', 'B', 'C');
    }
}
