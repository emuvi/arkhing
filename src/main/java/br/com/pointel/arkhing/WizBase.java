package br.com.pointel.arkhing;

import java.util.List;
import org.apache.commons.lang3.tuple.Pair;

/**
 *
 * @author emuvi
 */
public class WizBase {
    
    public static void sleep(long millis) {
        try {
            Thread.currentThread().sleep(millis);
        } catch(Exception e) {}
    }
    
}
