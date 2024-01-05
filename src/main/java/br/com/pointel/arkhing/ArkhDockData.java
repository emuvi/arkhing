package br.com.pointel.arkhing;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.apache.logging.log4j.util.Strings;

/**
 *
 * @author emuvi
 */
public class ArkhDockData {

    private final File folder;
    private final Connection connection;

    public ArkhDockData(File folder) throws Exception {
        this.folder = folder;
        this.connection = DriverManager.getConnection("jdbc:sqlite:"
                + new File(folder, "arkhdock.sdb").getAbsolutePath());
        this.initDatabase();
    }

    private void initDatabase() throws Exception {
        this.connection.createStatement().execute(
                "CREATE TABLE IF NOT EXISTS "
                + "docks (name TEXT PRIMARY KEY, modified INTEGER, words TEXT)");
    }

    public File getFolder() {
        return folder;
    }

    public ArkhDockUnit getByName(String name) throws Exception {
        var select = this.connection.prepareStatement(
                "SELECT name, modified, words "
                + "FROM docks "
                + "WHERE name = ?");
        select.setString(1, name);
        var returned = select.executeQuery();
        if (returned.next()) {
            return new ArkhDockUnit(
                    returned.getString("name"),
                    returned.getLong("modified"),
                    new HashSet<>(Arrays.asList(returned.getString("words").split(",")))
            );
        } else {
            return null;
        }
    }
    
    

    public Long getModifiedByName(String name) throws Exception {
        var select = this.connection.prepareStatement(
                "SELECT modified "
                + "FROM docks "
                + "WHERE name = ?");
        select.setString(1, name);
        var returned = select.executeQuery();
        if (returned.next()) {
            return returned.getLong("modified");
        } else {
            return null;
        }
    }
    
    public List<ArkhDockUnit> getAll() throws Exception {
        var select = this.connection.prepareStatement(
                "SELECT name, modified, words "
                + "FROM docks");
        var returned = select.executeQuery();
        var results = new ArrayList<ArkhDockUnit>();
        while (returned.next()) {
            results.add(new ArkhDockUnit(
                    returned.getString("name"),
                    returned.getLong("modified"),
                    new HashSet<>(Arrays.asList(returned.getString("words").split(",")))
            ));
        }
        return results;
    }
    
    public Set<String> getAllWords() throws Exception {
        var select = this.connection.prepareStatement("SELECT words FROM docks");
        var returned = select.executeQuery();
        var results = new HashSet<String>();
        while (returned.next()) {
            results.addAll(Arrays.asList(returned.getString("words").split(",")));
        }
        return results;
    }
    
    public void putDock(ArkhDockUnit dock) throws Exception {
        this.putDock(dock.name, dock.modified, dock.words);
    }
    
    public void putDock(String name, Long modified, Set<String> words) throws Exception {
        var delete = this.connection.prepareStatement(
                "DELETE FROM docks "
                + "WHERE name = ?");
        delete.setString(1, name);
        delete.executeUpdate();
        String wordsSeparated = Strings.join(words, ',');
        var insert = this.connection.prepareStatement(
                "INSERT INTO docks "
                + "(name, modified, words) "
                + "VALUES (?, ?, ?)");
        insert.setString(1, name);
        insert.setLong(2, modified);
        insert.setString(3, wordsSeparated);
        var results = insert.executeUpdate();
        if (results == 0) {
            throw new Exception("Could not put the dock.");
        }
    }

}
