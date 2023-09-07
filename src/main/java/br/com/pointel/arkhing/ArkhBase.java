package br.com.pointel.arkhing;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author emuvi
 */
public class ArkhBase implements Closeable {

    public final File root;
    private final int rootLength;

    public final ArkhBaseData baseData;
    public final ArkhBaseLoad baseLoad;

    public ArkhBase(File root) throws Exception {
        if (!root.exists() || !root.isDirectory()) {
            throw new Exception("Could not find the root directory.");
        }
        this.root = root;
        this.rootLength = this.root.getAbsolutePath().length();
        this.baseData = new ArkhBaseData(this);
        this.baseLoad = new ArkhBaseLoad(this);
    }

    public ArkhBase load() throws Exception {
        this.baseLoad.start();
        return this;
    }

    public String getPlace(File file) {
        return file.getAbsolutePath().substring(this.rootLength);
    }

    public String makeCheck(File path) throws Exception {
        var report = new StringBuilder();
        if (path.isDirectory()) {
            for (var inside : path.listFiles()) {
                checkFile(inside, report);
            }
        } else {
            checkFile(path, report);
        }
        return report.toString();
    }
    
    private void checkFile(File path, StringBuilder report) throws Exception {
        report.append("The file: ");
        report.append(path.getName());
        report.append("\n");
        try (FileInputStream input = new FileInputStream(path)) {
            var verifier = DigestUtils.sha256Hex(input);
            var arkhFiles = baseData.getByVerifier(verifier);
            if (arkhFiles.isEmpty()) {
                report.append("Is not in the base.\n");
            } else {
                for (var arkhFile : arkhFiles) {
                    report.append("Is in the base as: ");
                    report.append(arkhFile.place);
                    report.append("\n");
                }
            }
        }
        report.append("\n");
    }

    @Override
    public void close() throws IOException {
        this.baseLoad.stop();
        this.baseData.close();
    }

}
