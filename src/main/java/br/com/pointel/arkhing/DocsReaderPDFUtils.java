package br.com.pointel.arkhing;

import java.io.File;
import org.apache.commons.io.FilenameUtils;

/**
 *
 * @author emuvi
 */
public class DocsReaderPDFUtils {

    public static String[] PDF_EXTENSIONS = new String[]{"pdf", "fdf", "xfdf", "pdx", "ppdf"};

    public static boolean isPDFFile(File file) {
        return isPDFFile(file.getName());
    }

    public static boolean isPDFFile(String fileName) {
        return WizArray.contains(FilenameUtils.getExtension(fileName).toLowerCase(), PDF_EXTENSIONS);
    }
    
}
