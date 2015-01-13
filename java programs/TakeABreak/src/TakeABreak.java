import java.awt.Desktop;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JEditorPane;


/**
 * 12/23/14
 * @author noah
 * Every 2 hours launches your favorite music video
 * Performs this action 3 times
 */

public class TakeABreak {
    private static final String url = "http://youtu.be/nSKUXqJ5l1k"; //url to launch
   
    public TakeABreak(){
        runTimer();
    }
    /**
     * launches a web page 
     * @param uri 
     */
    public static void openWebpage(URI uri) {
        Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
        if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
            try {
                desktop.browse(uri);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * Return the time left HH/MM/SS format
     * @param secondsCount
     * @returncount
     */
    public static String formatHHMMSS(int secondsCount){  
        //Calculate the seconds to display:  
        long seconds = secondsCount % 60;  
        secondsCount -= seconds;  
        //Calculate the minutes:  
        long minutesCount = secondsCount / 60;  
        long minutes = minutesCount % 60;  
        minutesCount -= minutes;  
        //Calculate the hours:  
        long hoursCount = minutesCount / 60;  
        //Build the String  
        String count = "" + hoursCount + ":" + minutes + ":" + seconds;
        return count;  
    }
    /**
     * every 2 hours launch a web page 
     * performs action 3 times
     */
    public static void runTimer(){
        int delay = 7200 * 1000;   // delay for 2 hours
        int period = 7200 * 1000;  // repeat every 2 hours
        Timer timer = new Timer();
        
         
          timer.scheduleAtFixedRate(new TimerTask() {
                int times_run = 0;
                long startTimeHashtable = System.currentTimeMillis();          
                public void run() {
                    System.out.println(formatHHMMSS(5));                   
                    try {
                        java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
                        times_run++;
                         } catch (IOException ex) {
                        Logger.getLogger(TakeABreak.class.getName()).log(Level.SEVERE, null, ex);
                    }
                   
                long endTimeHashtable   = System.currentTimeMillis();
                long totalTimeHashtable = endTimeHashtable - startTimeHashtable; 
                System.out.println(totalTimeHashtable);
                    if(times_run == 3){
                        System.exit(0);
                    }
                }
                
            }, delay, period);
    }
         
    
    public static void main(String [] args){         
         new TakeABreak();  
    }

} // end of class TakeABreak



