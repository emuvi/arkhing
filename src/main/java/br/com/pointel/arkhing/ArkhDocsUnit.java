package br.com.pointel.arkhing;

import java.util.List;

/**
 *
 * @author emuvi
 */
public class ArkhDocsUnit {
    
    public final String place;
    public final Long modified;
    public final List<String> words;

    public ArkhDocsUnit(String place, Long modified, List<String> words) {
        this.place = place;
        this.modified = modified;
        this.words = words;
    }
    
}
