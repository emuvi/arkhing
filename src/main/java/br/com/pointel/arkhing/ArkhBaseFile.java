package br.com.pointel.arkhing;

/**
 *
 * @author emuvi
 */
public class ArkhBaseFile {
    
    public final String place;
    public final Long modified;
    public final String verifier;

    public ArkhBaseFile(String place, Long modified, String verifier) {
        this.place = place;
        this.modified = modified;
        this.verifier = verifier;
    }
    
}
