package de.arindy.shadowrun.gui.actions;

import de.arindy.shadowrun.controller.CharController;
import de.arindy.shadowrun.controller.helper.DataHelper;
import de.arindy.shadowrun.persistence.helper.JsonHandler;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.io.File;

/**
 * Created by arindy on 15.05.16.
 */
public class SaveCharFile extends AbstractAction {
    private CharController charController;
    private boolean cancel;

    public SaveCharFile(CharController charController) {
        super("Speichern");
        this.charController = charController;
    }

    public boolean saveCanceled(ActionEvent e) {
        actionPerformed(e);
        return cancel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("Char-Datei (*.srVchar)", "srVchar"));
        String suggestedName = (CharController.character.getName() != null && !CharController.character.getName().isEmpty()) ? CharController.character.getName().replaceAll(" ", "_") : "";
        suggestedName = (CharController.character.getStrassenname() != null && !CharController.character.getStrassenname().isEmpty()) ? CharController.character.getStrassenname() : suggestedName;
        fileChooser.setSelectedFile(new File(suggestedName + ".srVchar"));
        int returnValue = fileChooser.showSaveDialog(charController.getCharSheet().getSheet());
        if (JFileChooser.APPROVE_OPTION == returnValue) {
            int override = JOptionPane.YES_OPTION;
            if (fileChooser.getSelectedFile().exists()) {
                override = JOptionPane.showConfirmDialog(charController.getCharSheet().getSheet(), "Datei " + fileChooser.getSelectedFile().getName() + " überschreiben?", fileChooser.getSelectedFile().getName() + " schon vorhanden", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null);
            }
            if (override == JOptionPane.YES_OPTION) {
                File file = (fileChooser.getSelectedFile().getAbsolutePath().endsWith(".srVchar")) ? fileChooser.getSelectedFile() : new File(fileChooser.getSelectedFile().getAbsolutePath() + ".srVchar");
                JsonHandler.writeFile(file, CharController.character);
                DataHelper.unsavedData = false;
                charController.updateTitle();
            } else {
                cancel = true;
                return;
            }
            cancel = false;
        } else {
            cancel = true;
        }
    }

}