/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.client.gui.engine.style.util;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.awt.Color;
import java.io.IOException;
import java.util.stream.Stream;
import org.apache.commons.lang3.reflect.FieldUtils;

public class ColorAdapter
extends TypeAdapter<Color> {
    @Override
    public void write(JsonWriter jsonWriter, Color color) throws IOException {
        jsonWriter.value("rgb(" + color.getRed() + "," + color.getGreen() + "," + color.getBlue() + "," + color.getAlpha() + ")");
    }

    @Override
    public Color read(JsonReader jsonReader) throws IOException {
        String string = jsonReader.nextString();
        if (string.startsWith("rgb(") && string.endsWith(")")) {
            String string2 = string.substring(4, string.length() - 1);
            int[] nArray = Stream.of(string2.split(",")).map(String::trim).mapToInt(Integer::parseInt).toArray();
            int n = nArray[0];
            int n2 = nArray[1];
            int n3 = nArray[2];
            int n4 = 255;
            if (nArray.length > 3) {
                n4 = nArray[3];
            }
            return new Color(n, n2, n3, n4);
        }
        if (string.startsWith("0x")) {
            return new Color(Integer.parseInt(string, 16));
        }
        if (!string.isEmpty()) {
            try {
                return (Color)FieldUtils.readDeclaredStaticField(Color.class, string);
            }
            catch (IllegalAccessException illegalAccessException) {
                illegalAccessException.printStackTrace();
            }
        }
        return Color.white;
    }
}

