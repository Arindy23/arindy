package de.arindy.sharv.gui;

import de.arindy.sharv.Logger;
import de.arindy.sharv.api.gui.ConditionMonitorListener;
import de.arindy.sharv.api.gui.ConditionMonitorView;
import de.arindy.sharv.api.gui.DefaultConditionMonitorListener;
import de.arindy.sharv.gui.jfx.CheckBoxPane;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ConditionMonitorPane implements ConditionMonitorView {

    private final Logger LOG;

    @FXML
    private CheckBoxPane physicalCheckBoxes;
    @FXML
    private CheckBoxPane stunCheckBoxes;
    @FXML
    private Label dicePoolModifier;
    private ConditionMonitorListener conditionMonitorListener;

    public ConditionMonitorPane() {
        LOG = Logger.get(getClass().getName());
        conditionMonitorListener = new DefaultConditionMonitorListener();
    }

    @Inject
    public ConditionMonitorView withConditionMonitorListener(final ConditionMonitorListener conditionMonitorListener) {
        this.conditionMonitorListener = conditionMonitorListener.register(this);
        return this;
    }

    public void onPhysicalDamage(final ActionEvent actionEvent) {
        LOG.entering(actionEvent);
        int physicalDamage = physicalCheckBoxes.extractIndex((CheckBox) actionEvent.getSource());
        conditionMonitorListener.changePhysicalDamage(physicalDamage);
        physicalCheckBoxes.setCheckedAmount(physicalDamage);
    }

    public void onStunDamage(final ActionEvent actionEvent) {
        LOG.entering(actionEvent);
        int stunDamage = stunCheckBoxes.extractIndex((CheckBox) actionEvent.getSource());
        conditionMonitorListener.changeStunDamage(stunDamage);
        stunCheckBoxes.setCheckedAmount(stunDamage);
    }

    @Override
    public ConditionMonitorView setPhysicalDamageMax(int physicalDamageMax) {
        LOG.entering(physicalDamageMax);
        physicalCheckBoxes.setAmount(physicalDamageMax);
        return this;
    }

    @Override
    public ConditionMonitorView setPhysicalDamage(int physicalDamage) {
        LOG.entering(physicalDamage);
        physicalCheckBoxes.setCheckedAmount(physicalDamage);
        return this;
    }

    @Override
    public ConditionMonitorView setStunDamageMax(int stunDamageMax) {
        LOG.entering(stunDamageMax);
        stunCheckBoxes.setAmount(stunDamageMax);
        return this;
    }

    @Override
    public ConditionMonitorView setStunDamage(int stunDamage) {
        LOG.entering(stunDamage);
        stunCheckBoxes.setCheckedAmount(stunDamage);
        return this;
    }

    @Override
    public ConditionMonitorView setDicePoolModifier(int dicePoolModifier) {
        LOG.entering(dicePoolModifier);
        this.dicePoolModifier.setText(String.valueOf(dicePoolModifier));
        JavaFXUtil.highlight(this.dicePoolModifier, dicePoolModifier != 0);
        return this;
    }
}
