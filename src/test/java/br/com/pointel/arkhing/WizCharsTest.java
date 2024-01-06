package br.com.pointel.arkhing;

import java.util.Arrays;
import java.util.HashSet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 *
 * @author emuvi
 */
public class WizCharsTest {

    @Test
    public void test_getWords() {
        String test = "Serviços de TI: Lei 14.133/2021;  Instrução Normativa";
        var expected = new HashSet<String>(Arrays.asList("serviços", "de", "ti", "lei", "14.133/2021", "instrução", "normativa"));
        var result = WizChars.getWords(test);
        Assertions.assertTrue(expected.size() == result.size()
                && expected.containsAll(result)
                && result.containsAll(expected));
    }

}
