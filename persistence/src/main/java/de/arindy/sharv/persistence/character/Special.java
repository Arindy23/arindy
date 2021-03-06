package de.arindy.sharv.persistence.character;

import lombok.Data;

import java.util.Objects;

@Data
public class Special {

    private String id;
    private String name;

    public Special() {
        this("");
    }

    public Special(String id) {
        this.id = id;
        this.name = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Special special = (Special) o;
        return Objects.equals(id, special.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }

    @Override
    public String toString() {
        return name;
    }
}
