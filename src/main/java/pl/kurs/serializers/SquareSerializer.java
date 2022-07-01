package pl.kurs.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import pl.kurs.models.Square;
import java.io.IOException;
import java.util.Locale;

public class SquareSerializer extends StdSerializer<Square> {

    public SquareSerializer(Class<Square> t) {
        super(t);
    }

    @Override
    public void serialize(Square square, JsonGenerator jg, SerializerProvider sp) throws IOException {
        jg.writeStartObject();
        jg.writeStringField("type", square.getClass().getSimpleName().toLowerCase(Locale.ROOT));
        jg.writeNumberField("side", square.getSide());
        jg.writeEndObject();
    }
}
