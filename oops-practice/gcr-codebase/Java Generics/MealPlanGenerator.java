public class MealPlanGenerator {
    interface MealPlan {
        String getPlanName();
        boolean isValidCombination();
    }

    static class VegetarianMeal implements MealPlan {
        @Override public String getPlanName() { return "Vegetarian"; }
        @Override public boolean isValidCombination() { return true; }
    }

    static class VeganMeal implements MealPlan {
        @Override public String getPlanName() { return "Vegan"; }
        @Override public boolean isValidCombination() { return true; }
    }

    static class KetoMeal implements MealPlan {
        @Override public String getPlanName() { return "Keto"; }
        @Override public boolean isValidCombination() { return true; }
    }

    static class HighProteinMeal implements MealPlan {
        @Override public String getPlanName() { return "High-Protein"; }
        @Override public boolean isValidCombination() { return true; }
    }

    static class Meal<T extends MealPlan> {
        private final T plan;

        public Meal(T plan) {
            this.plan = plan;
        }

        public T getPlan() {
            return plan;
        }
    }

    static <T extends MealPlan> String generatePlan(Meal<T> meal) {
        if (!meal.getPlan().isValidCombination()) {
            throw new IllegalArgumentException("Invalid meal plan combination");
        }
        return "Generated meal plan: " + meal.getPlan().getPlanName();
    }

    public static void main(String[] args) {
        Meal<VegetarianMeal> vegMeal = new Meal<>(new VegetarianMeal());
        Meal<VeganMeal> veganMeal = new Meal<>(new VeganMeal());
        Meal<KetoMeal> ketoMeal = new Meal<>(new KetoMeal());
        Meal<HighProteinMeal> proteinMeal = new Meal<>(new HighProteinMeal());

        System.out.println(generatePlan(vegMeal));
        System.out.println(generatePlan(veganMeal));
        System.out.println(generatePlan(ketoMeal));
        System.out.println(generatePlan(proteinMeal));
    }
}
