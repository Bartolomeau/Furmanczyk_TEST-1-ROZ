package pl.kurs.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import pl.kurs.models.Circle;
import java.io.IOException;
import java.util.Locale;

public class CircleSerializer extends StdSerializer<Circle>{

    public CircleSerializer(Class<Circle> t) {
        super(t);
    }

    @Override
    public void serialize(Circle circle, JsonGenerator jg, SerializerProvider sp) throws IOException {
        jg.writeStartObject();
        jg.writeStringField("type", circle.getClass().getSimpleName().toLowerCase(Locale.ROOT));
        jg.writeNumberField("radius", circle.getRadius());
        jg.writeEndObject();
    }
}
