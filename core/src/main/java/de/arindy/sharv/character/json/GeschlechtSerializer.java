package de.arindy.sharv.character.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import de.arindy.sharv.character.Geschlecht;

import java.io.IOException;

/**
 * Created by arindy on 14.05.16.
 */
public class GeschlechtSerializer extends JsonSerializer<Geschlecht> {

    @Override
    public void serialize(Geschlecht type, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeString(type.getValue());
    }
}