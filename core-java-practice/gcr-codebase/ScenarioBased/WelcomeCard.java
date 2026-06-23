public class WelcomeCard {
    public static void main(String[] args) {
        String name = "Ravi";
        int age = 24;
        String rank = "Novice Coder";
        double salary = 45000.0;
        float membershipFee = 499.99f;

        double bonusDouble = salary * 0.12;
        int annualBonus = (int) bonusDouble;

        System.out.println("==================================");
        System.out.println("       WELCOME TO THE GUILD       ");
        System.out.println("==================================");
        System.out.printf("Name           : %s%n", name);
        System.out.printf("Age            : %d%n", age);
        System.out.printf("Rank           : %s%n", rank);
        System.out.printf("Salary         : $%.2f%n", salary);
        System.out.printf("Membership Fee : $%.2f%n", membershipFee);
        System.out.printf("Annual Bonus   : $%d%n", annualBonus);
        System.out.println("==================================");
    }
}
