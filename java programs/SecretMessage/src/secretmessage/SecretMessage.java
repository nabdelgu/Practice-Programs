package secretmessage;
import java.io.File;
import java.io.IOException;

/**
 * 12/26/14
 * @author Noah Abdelguerfi
 */

/**
*Iterates through all files in the directory and removes the numbers
*/
public class SecretMessage {

    private static final String fileName = "/Users/noah/Desktop/PracticePrograms/java programs/SecretMessage/src/secretmessage/Pictures";

    public SecretMessage(){
        removeNumbers();
    }

    public static void main(String[] args) {
        new SecretMessage();
    }
    
    /**
     * removes all numbers from files in a directory
     */   
    public void removeNumbers(){
               final File dir = new File(fileName);

       if(dir.isDirectory()){
            for(final File file: dir.listFiles()){
                
                String nameOld = file.getName(); // get old file name              
                String nameNew = nameOld.replaceAll("[0-9]",""); // remove all numbers         
                File newFileName = new File("/Users/noah/Desktop/PracticePrograms/java programs/SecretMessage/src/secretmessage/Pictures" + "/" + nameNew); //reset path          
                file.renameTo(newFileName); //rename file
                System.out.println(nameOld + " renamed to: " + nameNew); 
                
            }
        }
    }

}
