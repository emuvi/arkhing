package br.com.pointel.arkhing;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.Pair;

/**
 *
 * @author emuvi
 */
public class WizChars {

    public static String makeParameterName(String ofTitle) {
        return ofTitle.replace(" ", "_").toUpperCase();
    }

    public static String mountGrid(List<Pair<String, String>> grid) {
        var result = new StringBuilder();
        var max = 0;
        for (var line : grid) {
            max = Math.max(max, line.getLeft().length());
        }
        for (var line : grid) {
            result.append(StringUtils.rightPad(line.getLeft(), max, '.'));
            result.append("...: ");
            result.append(line.getRight());
            result.append("\n");
        }
        return result.toString();
    }

    public static String getNameWithNewIndex(String name, int addIndex) {
        int begin = -1;
        int end = name.length();
        for (int i = 0; i < name.length(); i++) {
            char charAt = name.charAt(i);
            if (begin == -1) {
                if (Character.isDigit(charAt)) {
                    begin = i;
                }
            } else {
                if (!Character.isDigit(charAt)) {
                    end = i;
                    break;
                }
            }
        }
        if (begin == -1) {
            return name;
        }
        int number = Integer.parseInt(name.substring(begin, end));
        int newNumber = number + addIndex;
        String newNameNumber = StringUtils.leftPad(newNumber + "", end - begin, '0');
        return name.substring(0, begin) + newNameNumber + name.substring(end);
    }

    public static Set<String> getWords(String source) {
        var parts = SPACER_PATTERN.split(source);
        var words = new HashSet<String>();
        for (var part : parts) {
            if (!part.chars().anyMatch((c) -> !Character.isLetter(c))) {
                words.add(part.toLowerCase());
            }
        }
        return words;
    }

    public static final String SPACER_REGEX = "([^\\p{L}\\p{N}])+";
    public static final Pattern SPACER_PATTERN = Pattern.compile(SPACER_REGEX);
    
}
