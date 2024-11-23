package com.google.gson.typeadapters;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class RuntimeTypeAdapterFactory<T> implements TypeAdapterFactory {
    private final Class<T> baseType;
    private final String typeFieldName;
    private final Map<String, Class<? extends T>> labelToSubtype = new HashMap<>();
    private final Map<Class<? extends T>, String> subtypeToLabel = new HashMap<>();

    private RuntimeTypeAdapterFactory(Class<T> baseType, String typeFieldName) {
        if (baseType == null || typeFieldName == null) {
            throw new NullPointerException();
        }
        this.baseType = baseType;
        this.typeFieldName = typeFieldName;
    }

    public static <T> RuntimeTypeAdapterFactory<T> of(Class<T> baseType, String typeFieldName) {
        return new RuntimeTypeAdapterFactory<>(baseType, typeFieldName);
    }

    public RuntimeTypeAdapterFactory<T> registerSubtype(Class<? extends T> subtype, String label) {
        if (subtype == null || label == null) {
            throw new NullPointerException();
        }
        if (labelToSubtype.containsKey(label) || subtypeToLabel.containsKey(subtype)) {
            throw new IllegalArgumentException("Subtypes and labels must be unique.");
        }
        labelToSubtype.put(label, subtype);
        subtypeToLabel.put(subtype, label);
        return this;
    }

    @Override
    public <R> TypeAdapter<R> create(Gson gson, TypeToken<R> type) {
        if (!baseType.isAssignableFrom(type.getRawType())) {
            return null;
        }

        final Map<String, TypeAdapter<?>> labelToAdapter = new HashMap<>();
        final Map<Class<?>, TypeAdapter<?>> subtypeToAdapter = new HashMap<>();
        for (Map.Entry<String, Class<? extends T>> entry : labelToSubtype.entrySet()) {
            TypeAdapter<?> adapter = gson.getDelegateAdapter(this, TypeToken.get(entry.getValue()));
            labelToAdapter.put(entry.getKey(), adapter);
            subtypeToAdapter.put(entry.getValue(), adapter);
        }

        return new TypeAdapter<R>() {
            @Override
            public void write(JsonWriter out, R value) throws IOException {
                Class<?> clazz = value.getClass();
                String label = subtypeToLabel.get(clazz);
                if (label == null) {
                    throw new JsonParseException("Cannot serialize " + clazz.getName() + "; did you forget to register a subtype?");
                }
                @SuppressWarnings("unchecked")
                TypeAdapter<R> delegate = (TypeAdapter<R>) subtypeToAdapter.get(clazz);
                out.beginObject();
                out.name(typeFieldName).value(label);
                delegate.write(out, value);
                out.endObject();
            }

            @Override
            public R read(JsonReader in) throws IOException {
                in.beginObject();
                String label = null;
                if (in.peek() == JsonToken.NAME && typeFieldName.equals(in.nextName())) {
                    label = in.nextString();
                }
                if (label == null) {
                    throw new JsonParseException("Missing type field: " + typeFieldName);
                }
                @SuppressWarnings("unchecked")
                TypeAdapter<R> delegate = (TypeAdapter<R>) labelToAdapter.get(label);
                if (delegate == null) {
                    throw new JsonParseException("Cannot deserialize type: " + label + "; did you forget to register a subtype?");
                }
                R result = delegate.read(in);
                in.endObject();
                return result;
            }
        }.nullSafe();
    }
}
