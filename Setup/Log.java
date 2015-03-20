package Setup;
public class Log {
  public static int TABSIZE      = 4;        // Indentation unit size in spaces
  public static int level        = 0;        // Level of deepness 
  private static boolean logging = true;     // Logging the messages (to turn logging off when you
                                            // just setting up for something)
  
  public static void enter () {             // Call it everytime you enter a new level
    if (!logging) return;
    
    level++;
  }
  
  public static void write (String msg) {
    if (!logging) return;
    
    for (int i = 0; i < level * TABSIZE; ++i) System.out.print(" ");
    
    System.out.println(msg);
  }
  
  public static void exit () {              // Call it everytime you leave a level
    if (!logging) return;
    
    level--;
  }
  
  public static void on () {                // Turn on logging
    logging = true;
  }
  
  public static void off () {              // Turn off logging
    logging = false;
  }
}
