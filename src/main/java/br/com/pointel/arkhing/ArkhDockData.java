package br.com.pointel.arkhing;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author emuvi
 */
public class ArkhDockData {
    
    private final ArkhDock arkhDocs;
    private final File folder;
    private final Connection connection;

    public ArkhDockData(ArkhDock arkhDocs, File folder) throws Exception {
        this.arkhDocs = arkhDocs;
        this.folder = folder;
        this.connection = DriverManager.getConnection("jdbc:sqlite:"
                + new File(folder, "arkhdocs.sdb").getAbsolutePath());
        this.initDatabase();
    }
    
    private void initDatabase() throws Exception {
        this.connection.createStatement().execute(
                "CREATE TABLE IF NOT EXISTS "
                + "docks (name TEXT PRIMARY KEY, modified INTEGER, words TEXT)");
    }
    
}
