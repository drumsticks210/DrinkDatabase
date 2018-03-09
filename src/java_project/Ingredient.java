
package java_project;

public class Ingredient {
    
    private String ingredient_Chart_id;
    private String drink_id;
    private String ingredient_id;
    private String ingredient_amount;

      
    public Ingredient( String iIngredient_Chart_id, String iDrink_id, String iIngredient_id, String iIngredient_amount)
    {
        this.ingredient_Chart_id = iIngredient_Chart_id;
        this.drink_id = iDrink_id;
        this.ingredient_id = iIngredient_id;
        this.ingredient_amount = iIngredient_amount;

    }
    
    public String getIngredient_Chart_id()
    {
        return ingredient_Chart_id;
    }
    
    public String getDrink_id()
    {
        return drink_id;
    }
    
    public String getIngredient_id()
    {
        return ingredient_id;
    }
    
    public String getingredient_amount()
    {
        return  ingredient_amount;
    }  
   
}
