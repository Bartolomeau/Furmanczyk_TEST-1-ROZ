package pl.kurs.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import pl.kurs.models.Rectangle;
import java.io.IOException;
import java.util.Locale;

public class RectangleSerializer extends StdSerializer<Rectangle> {

    public RectangleSerializer(Class<Rectangle> t) {
        super(t);
    }

    @Override
    public void serialize(Rectangle rectangle, JsonGenerator jg, SerializerProvider sp) throws IOException {
        jg.writeStartObject();
        jg.writeStringField("type", rectangle.getClass().getSimpleName().toLowerCase(Locale.ROOT));
        jg.writeNumberField("length", rectangle.getLength());
        jg.writeNumberField("width", rectangle.getWidth());
        jg.writeEndObject();
    }
}
