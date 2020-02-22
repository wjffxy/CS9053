package edu.nyu.cs9053.homework5;

/**
 * User: blangel
 */
public class Chef {

    private static final int DEFAULT_INITIAL_TEMPERATURE = 300;

    private static final Double DEFAULT_RECIPE_CONSTANT = -0.002;

    private final Oven oven;

    private final SousChef sousChef;

    public Chef(Oven oven, SousChef sousChef) {
        this.oven = oven;
        this.sousChef = sousChef;
    }

    public static void main(String[] args) {
      // TODO - create an instance of Chef and cook the proper recipes according to the instructions.
        Oven oven = new Oven(DEFAULT_INITIAL_TEMPERATURE);
        SousChef sousChef = new SousChef(oven);
        Chef chef = new Chef(oven, sousChef);
        Recipe potRoast = new PotRoast();
        Recipe baguette = new Baguette(DEFAULT_RECIPE_CONSTANT);
        Recipe roastedSweetPotato = new RoastedSweetPotato();
        Recipe secondBaguette = new Baguette(DEFAULT_RECIPE_CONSTANT);
        chef.prepareToCook(potRoast);
        chef.prepareToCook(baguette);
        chef.prepareToCook(roastedSweetPotato);
        chef.prepareToCook(secondBaguette);
    }

    private void prepareToCook(Recipe recipe) {

        sousChef.prepare(recipe, new RecipeReadyCallback() {
            @Override public void recipeReadyToCook(Recipe recipe) {
                recipe.initializeFromOven(oven);
                cookInOven(recipe, true);
            }
        });
    }

    private void cookInOven(Recipe recipe, boolean initialPutInOven) {

        if(recipe.isRecipeDone()){
            oven.takeOut(recipe);
        }
        else {
            oven.cook(recipe, new Timer() {
                @Override public void update(Time unit, int value, int ovenTemperature) {
                    recipe.adjust(unit, value, ovenTemperature);
                    cookInOven(recipe, false);
                }
            }, initialPutInOven);
        }
    }
}
