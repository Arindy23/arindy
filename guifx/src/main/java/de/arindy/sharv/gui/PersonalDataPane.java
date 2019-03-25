package de.arindy.sharv.gui;

import de.arindy.sharv.Logger;
import de.arindy.sharv.api.gui.PersonalDataListener;
import de.arindy.sharv.api.gui.PersonalDataView;
import de.arindy.sharv.controller.SharVController;
import de.arindy.sharv.gui.jfx.BorderedTitledPane;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

import static de.arindy.sharv.gui.JavaFXUtil.*;

public class PersonalDataPane extends BorderedTitledPane implements PersonalDataView {

    private final Logger LOG;

    private PersonalDataListener personalDataListener;

    //<editor-fold desc="Variables">
    @FXML
    private TextFlow racialBonuses;
    @FXML
    private TextField name;
    @FXML
    private TextField streetname;
    @FXML
    private TextField publicAwareness;
    @FXML
    private ComboBox<String> metatype;
    @FXML
    private Label karma;
    @FXML
    private Label karmaMax;
    @FXML
    private Label nuyen;
    @FXML
    private ComboBox<String> sex;
    @FXML
    private TextField age;
    @FXML
    private TextField height;
    @FXML
    private TextField weight;
    @FXML
    private TextField ethnicity;
    @FXML
    private TextField concept;
    @FXML
    private TextField streetCred;
    @FXML
    private TextField notoriety;
    //</editor-fold>

    public PersonalDataPane() {
        super("personalData");
        LOG = Logger.get(getClass().getName());
        SharVController.register(this);
    }

    public void onName(final InputMethodEvent inputMethodEvent) {
        LOG.entering(inputMethodEvent);
        final String name = extractText(inputMethodEvent);
        if (listenerRegistered()) {
            personalDataListener.changeName(name);
        }
        updateTitle();
    }

    public void onStreetname(final InputMethodEvent inputMethodEvent) {
        LOG.entering(inputMethodEvent);
        if (listenerRegistered()) {
            personalDataListener.changeStreetname(extractText(inputMethodEvent));
        }
        updateTitle();
    }

    public void onMetatype() {
        LOG.entering();
        if (listenerRegistered()) {
            personalDataListener.changeMetatype(getSelectedItem(metatype));
        }
    }

    public void onSex() {
        LOG.entering();
        if (listenerRegistered()) {
            personalDataListener.changeSex(getSelectedItem(sex));
        }
    }

    public void onAge(final InputMethodEvent inputMethodEvent) {
        LOG.entering(inputMethodEvent);
        if (listenerRegistered()) {
        personalDataListener.changeAge(extractInteger(inputMethodEvent));
        }
    }

    public void onHeight(final InputMethodEvent inputMethodEvent) {
        LOG.entering(inputMethodEvent);
        if (listenerRegistered()) {
            personalDataListener.changeHeight(extractInteger(inputMethodEvent));
        }
    }

    public void onWeight(final InputMethodEvent inputMethodEvent) {
        LOG.entering(inputMethodEvent);
        if (listenerRegistered()) {
            personalDataListener.changeWeight(extractInteger(inputMethodEvent));
        }
    }

    public void onEthnicity(final InputMethodEvent inputMethodEvent) {
        LOG.entering(inputMethodEvent);
        if (listenerRegistered()) {
            personalDataListener.changeEthnicity(extractText(inputMethodEvent));
        }
    }

    public void onConcept(final InputMethodEvent inputMethodEvent) {
        LOG.entering(inputMethodEvent);
        if (listenerRegistered()) {
            personalDataListener.changeConcept(extractText(inputMethodEvent));
        }
    }

    public void onStreetCred(final InputMethodEvent inputMethodEvent) {
        LOG.entering(inputMethodEvent);
        if (listenerRegistered()) {
            personalDataListener.changeStreetCred(extractInteger(inputMethodEvent));
        }
    }

    public void onNotoriety(final InputMethodEvent inputMethodEvent) {
        LOG.entering(inputMethodEvent);
        if (listenerRegistered()) {
            personalDataListener.changeNotoriety(extractInteger(inputMethodEvent));
        }
    }

    public void onPublicAwareness(final InputMethodEvent inputMethodEvent) {
        LOG.entering(inputMethodEvent);
        if (listenerRegistered()) {
            personalDataListener.changePublicAwareness(extractInteger(inputMethodEvent));
        }
    }

    @Override
    public PersonalDataView setName(final String name) {
        LOG.entering(name);
        this.name.setText(name);
        updateTitle();
        return LOG.returning(this);
    }

    @Override
    public PersonalDataView setStreetname(final String streetname) {
        LOG.entering(streetname);
        this.streetname.setText(streetname);
        updateTitle();
        return LOG.returning(this);
    }

    @Override
    public PersonalDataView setMetatype(final String metatype) {
        LOG.entering(metatype);
        this.metatype.getSelectionModel().select(metatype);
        return LOG.returning(this);
    }

    @Override
    public PersonalDataView setSex(final String sex) {
        LOG.entering(sex);
        this.sex.getSelectionModel().select(sex);
        return LOG.returning(this);
    }

    @Override
    public PersonalDataView setAge(int age) {
        LOG.entering(age);
        this.age.setText(String.valueOf(age));
        return LOG.returning(this);
    }

    @Override
    public PersonalDataView setHeight(int height) {
        LOG.entering(height);
        this.height.setText(String.valueOf(height));
        return LOG.returning(this);
    }

    @Override
    public PersonalDataView setWeight(int weight) {
        LOG.entering(weight);
        this.weight.setText(String.valueOf(weight));
        return LOG.returning(this);
    }

    @Override
    public PersonalDataView setEthnicity(final String ethnicity) {
        LOG.entering(ethnicity);
        this.ethnicity.setText(ethnicity);
        return LOG.returning(this);
    }

    @Override
    public PersonalDataView setConcept(final String concept) {
        LOG.entering(concept);
        this.concept.setText(concept);
        return LOG.returning(this);
    }

    @Override
    public PersonalDataView setStreetCred(int streetCred) {
        LOG.entering(streetCred);
        this.streetCred.setText(String.valueOf(streetCred));
        return LOG.returning(this);
    }

    @Override
    public PersonalDataView setNotoriety(int notoriety) {
        LOG.entering(notoriety);
        this.notoriety.setText(String.valueOf(notoriety));
        return LOG.returning(this);
    }

    @Override
    public PersonalDataView setPublicAwareness(int publicAwareness) {
        LOG.entering(publicAwareness);
        this.publicAwareness.setText(String.valueOf(publicAwareness));
        return LOG.returning(this);
    }

    @Override
    public PersonalDataView addRacialBonuses(final String... bonuses) {
        LOG.entering((Object[]) bonuses);
        for (String bonus : bonuses) {
            final ObservableList<Node> racialBonuses = this.racialBonuses.getChildren();
            if (!racialBonuses.isEmpty()) {
                racialBonuses.add(new Text(String.format("%n")));
            }
            racialBonuses.add(new Text(bonus));
        }
        return LOG.returning(this);
    }

    @Override
    public PersonalDataView removeAllRacialBonuses() {
        LOG.entering();
        racialBonuses.getChildren().clear();
        return LOG.returning(this);
    }

    @Override
    public PersonalDataView setKarma(int karma) {
        LOG.entering(karma);
        this.karma.setText(String.valueOf(karma));
        return LOG.returning(this);
    }

    @Override
    public PersonalDataView setKarmaMax(int karmaMax) {
        LOG.entering(karmaMax);
        this.karmaMax.setText(String.valueOf(karmaMax));
        return LOG.returning(this);
    }

    @Override
    public PersonalDataView setNuyen(int nuyen) {
        LOG.entering(nuyen);
        this.nuyen.setText(String.valueOf(nuyen));
        return LOG.returning(this);
    }

    @Override
    public PersonalDataView registerListener(final PersonalDataListener personalDataListener) {
        LOG.entering(personalDataListener);
        this.personalDataListener = personalDataListener;
        return LOG.returning(this);
    }

    @Override
    public PersonalDataView addSexes(final String... sexes) {
        LOG.entering(sexes);
        this.sex.getItems().addAll(sexes);
        return LOG.returning(this);
    }

    @Override
    public PersonalDataView removeAllSexes() {
        LOG.entering();
        this.sex.getItems().clear();
        return LOG.returning(this);
    }

    @Override
    public PersonalDataView addMetatypes(final String... metatypes) {
        LOG.entering(metatypes);
        this.metatype.getItems().addAll(metatypes);
        return LOG.returning(this);
    }

    @Override
    public PersonalDataView removeMetatypes() {
        LOG.entering();
        this.metatype.getItems().clear();
        return LOG.returning(this);
    }

    private boolean listenerRegistered() {
        return personalDataListener != null;
    }

    private void updateTitle() {
        final String prefix;
        if (streetname.getText().isEmpty()) {
            prefix = name.getText();
        } else {
            prefix = streetname.getText();
        }
        final String titlePrefix;
        if (prefix.isEmpty()) {
            titlePrefix = "";
        } else {
            titlePrefix = String.format("%s - ", prefix);
        }
        ((Stage) getScene().getWindow()).setTitle(String.format("%s%s", titlePrefix, SharVGUI.TITLE));
    }

}
