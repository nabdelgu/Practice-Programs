import java.util.ArrayList;

public class Animal{
       
    /*
    * animal attibutes
    */
    private String name;
    private String species;
    
    /*
    *animal constructor
    *with arguments name and species
    *creates an animal object
    */   
    public Animal(String name, String species){
        this.name = name;
        this.species = species;
    }//end of animal constructor	
    
    /*
    *returns the animal name
    */
    public String getName(){

            return name;								
    }// end of method getName
	
    /*
    *returns the animal species
    */
    public String getSpecies(){

            return species;								
    }//end of method getSpecies
    
}//end of class Animal
