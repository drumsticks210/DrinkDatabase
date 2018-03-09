
package java_project;

public class Cocktail {
    
    private String id;
    private String name;
    private String drinkDescription;
    private String catagoryID;
    private String glassID;
    private String methodID;
    private String extraID;
      
    public Cocktail( String cID, String cName, String cDescription, String cCatagoryID,String cGlassID,String cMethodID, String cExtraID )
    {
        this.id = cID;
        this.name = cName;
        this.drinkDescription = cDescription;
        this.catagoryID = cCatagoryID;
        this.glassID = cGlassID;
        this.methodID = cMethodID;
        this.extraID = cExtraID;
    }
    
    public String getId()
    {
        return id;
    }
    
    public String getName()
    {
        return name;
    }
    
    public String getdrinkDescription()
    {
        return drinkDescription;
    }
    
    public String getcatagoryID()
    {
        return  catagoryID;
    }
    
    public String getglassID()
    {
        return glassID;
    }
    
    public String getmethodID()
    {
        return methodID;
    }
    
    public String getextraID()
    {
        return extraID;
    }
    
   
}
