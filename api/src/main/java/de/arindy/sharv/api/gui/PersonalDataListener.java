package de.arindy.sharv.api.gui;

public interface PersonalDataListener {

    void changeName(String name);

    void changeStreetname(String streetname);

    void changeMetatype(String metatype);

    void changeSex(String sex);

    void changeAge(String age);

    void changeHeight(int height);

    void changeWeight(int weight);

    void changeEthnicity(String ethnicity);

    void changeConcept(String concept);

    void changeStreetCred(int streetCred);

    void changeNotoriety(int notoriety);

    void changePublicAwareness(int publicAwareness);

}
