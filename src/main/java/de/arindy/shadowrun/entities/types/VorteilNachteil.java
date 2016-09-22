package de.arindy.shadowrun.entities.types;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class VorteilNachteil implements Comparable {

    private String name;
    private String beschreibung;
    @JsonIgnore
    private String id;
    @JsonIgnore
    private String zusatzInfo;
    @JsonIgnore
    private String prefixVorteil = "[+]:";
    @JsonIgnore
    private String prefixNachteil = "[-]:";
    private boolean vorteil;

    private int karmaBonusKosten;
    private String details;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getZusatzInfo() {
        return zusatzInfo;
    }

    public void setZusatzInfo(String zusatzInfo) {
        this.zusatzInfo = zusatzInfo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public boolean isVorteil() {
        return vorteil;
    }

    public void setVorteil(boolean vorteil) {
        this.vorteil = vorteil;
    }

    public int getKarmaBonusKosten() {
        return karmaBonusKosten;
    }

    public void setKarmaBonusKosten(int karmaBonusKosten) {
        this.karmaBonusKosten = karmaBonusKosten;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public String toString() {
        String ret = (vorteil) ? prefixVorteil + name : prefixNachteil + name;
        ret += (zusatzInfo != null && !zusatzInfo.isEmpty()) ? ":" + zusatzInfo : "";
        return ret;
    }

    @Override
    public int compareTo(Object o) {
        if (o.toString().startsWith(prefixVorteil) && this.toString().startsWith(prefixNachteil)) {
            return 1;
        }
        if (o.toString().startsWith(prefixNachteil) && this.toString().startsWith(prefixVorteil)) {
            return -1;
        }
        int result = this.toString().toLowerCase().compareTo(o.toString().toLowerCase());

        if (result == 0) {
            result = this.getBeschreibung().compareTo(((VorteilNachteil) o).getBeschreibung());
        }
        if (result == 0) {
            result = this.getDetails().compareTo(((VorteilNachteil) o).getDetails());
        }
        if (result == 0) {
            result = Integer.compare(this.getKarmaBonusKosten(), ((VorteilNachteil) o).getKarmaBonusKosten());
        }
        return result;
    }
}