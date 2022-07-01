package pl.kurs.models;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.jsontype.BasicPolymorphicTypeValidator;
import com.fasterxml.jackson.databind.jsontype.PolymorphicTypeValidator;
import com.fasterxml.jackson.databind.module.SimpleModule;
import pl.kurs.serializers.*;

import java.text.SimpleDateFormat;

public enum ObjectMapperHolder {

    INSTANCE;

    private final ObjectMapper objectMapper;

    ObjectMapperHolder() {
        this.objectMapper = create();
    }

    public ObjectMapper getObjectMapper() {
        return objectMapper;
    }

    private static ObjectMapper create() {
        ObjectMapper mapper = new ObjectMapper();

        //CircleSerializer
        CircleSerializer cs = new CircleSerializer(Circle.class);
        SimpleModule sm1 = new SimpleModule("CircleSerializer");
        sm1.addSerializer(Circle.class, cs);
        mapper.registerModule(sm1);
        //CircleDeserializer
        CircleDeserializer cd = new CircleDeserializer(Circle.class);
        SimpleModule sm2 = new SimpleModule("CircleDeserializer");
        sm2.addDeserializer(Circle.class, cd);
        mapper.registerModule(sm2);

        //RectangleSerializer
        RectangleSerializer rs = new RectangleSerializer(Rectangle.class);
        SimpleModule sm3 = new SimpleModule("RectangleSerializer");
        sm3.addSerializer(Rectangle.class, rs);
        mapper.registerModule(sm3);
        //RectangleDeserializer
        RectangleDeserializer rd = new RectangleDeserializer(Rectangle.class);
        SimpleModule sm4 = new SimpleModule("RectangleDeserializer");
        sm4.addDeserializer(Rectangle.class, rd);
        mapper.registerModule(sm4);

        //SquareSerializer
        SquareSerializer ss = new SquareSerializer(Square.class);
        SimpleModule sm5 = new SimpleModule("SquareSerializer");
        sm5.addSerializer(Square.class, ss);
        mapper.registerModule(sm5);
        //SquareDeserializer
        SquareDeserializer sd = new SquareDeserializer(Square.class);
        SimpleModule sm6 = new SimpleModule("SquareDeserializer");
        sm6.addDeserializer(Square.class, sd);
        mapper.registerModule(sm6);

        //ShapeDeserializer
        ShapeDeserializer shapeDeserializer = new ShapeDeserializer(Shape.class);
        SimpleModule simpleModule = new SimpleModule("ShapeDeserializer");
        simpleModule.addDeserializer(Shape.class, shapeDeserializer);
        mapper.registerModule(simpleModule);

        return mapper;
    }
}
