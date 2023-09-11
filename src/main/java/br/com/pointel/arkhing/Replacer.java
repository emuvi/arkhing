package br.com.pointel.arkhing;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author emuvi
 */
public class Replacer {
    
    private List<ReplacerItem> items = new ArrayList<>();

    public Replacer() {}
    
    public Replacer add(boolean regex, String sourceOf, String sourceTo) {
        items.add(new ReplacerItem(regex, sourceOf, sourceTo));
        return this;
    }
    
    public String replace(String source) {
        return source;
    }
    
    private class ReplacerItem {
        
        public boolean regex;
        public String sourceOf;
        public String sourceTo;

        public ReplacerItem(boolean regex, String sourceOf, String sourceTo) {
            this.regex = regex;
            this.sourceOf = sourceOf;
            this.sourceTo = sourceTo;
        }
        
    }
    
}
