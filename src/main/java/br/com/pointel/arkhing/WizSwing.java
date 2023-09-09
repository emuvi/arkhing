package br.com.pointel.arkhing;

import java.awt.Desktop;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author emuvi
 */
public class WizSwing {

    public static void showInfo(String message) {
        JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void showError(Throwable error) {
        JOptionPane.showMessageDialog(null, error.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static String getStringOnClipboard() throws Exception {
        Clipboard systemClipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        Transferable clipboardContents = systemClipboard.getContents(null);
        if (clipboardContents != null) {
            try {
                if (clipboardContents.isDataFlavorSupported(DataFlavor.stringFlavor)) {
                    return (String) clipboardContents.getTransferData(DataFlavor.stringFlavor);
                }
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }

    public static void putStringOnClipboard(String string) {
        StringSelection selection = new StringSelection(string);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(selection, selection);
    }

    public static File selectFolder(File selected) {
        return select(selected, JFileChooser.DIRECTORIES_ONLY);
    }

    public static File selectFile(File selected) {
        return select(selected, JFileChooser.FILES_ONLY);
    }

    public static File select(File selected) {
        return select(selected, JFileChooser.FILES_AND_DIRECTORIES);
    }

    public static File select(File selected, int kind) {
        var chooser = new JFileChooser();
        chooser.setFileSelectionMode(kind);
        if (selected != null) {
            chooser.setSelectedFile(selected);
        }
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            return chooser.getSelectedFile();
        }
        return null;
    }

    public static void open(File file) throws Exception {
        Desktop.getDesktop().open(file);
    }

    public static Font fontMonospaced() {
        return new Font(Font.MONOSPACED, Font.PLAIN, 14);
    }

    public static Font fontSerif() {
        return new Font(Font.SERIF, Font.PLAIN, 14);
    }

    public static Font fontSansSerif() {
        return new Font(Font.SANS_SERIF, Font.PLAIN, 14);
    }

    public static void initPositioner(JFrame frame) {
        final var parameterName = WizChars.makeParameterName(frame.getTitle());
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                frame.setBounds(
                        WizProps.get(parameterName + "_FRAME_LEFT", frame.getBounds().x),
                        WizProps.get(parameterName + "_FRAME_TOP", frame.getBounds().y),
                        WizProps.get(parameterName + "_FRAME_WIDTH", frame.getBounds().width),
                        WizProps.get(parameterName + "_FRAME_HEIGHT", frame.getBounds().height));
            }

            @Override
            public void windowClosing(WindowEvent e) {
                WizProps.set(parameterName + "_FRAME_LEFT", frame.getBounds().x);
                WizProps.set(parameterName + "_FRAME_TOP", frame.getBounds().y);
                WizProps.set(parameterName + "_FRAME_WIDTH", frame.getBounds().width);
                WizProps.set(parameterName + "_FRAME_HEIGHT", frame.getBounds().height);
            }
        });
    }
    
    public static void close(JFrame frame) {
        frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
    }

}
