package br.com.pointel.arkhing;

import java.util.List;

/**
 *
 * @author emuvi
 */
public class ArkhDockUnit {
    
    public final String name;
    public final Long modified;
    public final List<String> words;

    public ArkhDockUnit(String name, Long modified, List<String> words) {
        this.name = name;
        this.modified = modified;
        this.words = words;
    }
    
}
