
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aziz Ahmed Chowdhury & Ahmed Dider Rahat
 */
public class ClearHistory {

    public ClearHistory() {
        try {
            BufferedWriter bw = null;
            FileWriter fw = null;

            fw = new FileWriter("highScore.txt");
            bw = new BufferedWriter(fw);
            bw.write("0");
            if (bw != null) {
                bw.close();
            }
            if (fw != null) {
                fw.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(ClearHistory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
