package br.com.pointel.arkhing;

import java.util.List;
import java.util.Set;

/**
 *
 * @author emuvi
 */
public class ArkhDockUnit {
    
    public final String name;
    public final Long modified;
    public final Set<String> words;

    public ArkhDockUnit(String name, Long modified, Set<String> words) {
        this.name = name;
        this.modified = modified;
        this.words = words;
    }
    
}
