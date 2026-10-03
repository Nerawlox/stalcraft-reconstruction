/*
 * Decompiled with CFR 0.152.
 */
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import gloomyfolken.mods.asm.Logger;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import net.minecraft.client.xpzm;
import net.minecraft.util.ResourceLocation;

public class dium {
    public static Map<String, int[]> _a = new LinkedHashMap<String, int[]>();
    public static Map<String, String> _b = new LinkedHashMap<String, String>();
    private static final ResourceLocation _c = new ResourceLocation("auction", "styles/gui.json");

    public static void _a() {
        try {
            Gson gson2 = new Gson();
            int[] nArray = new int[]{1, 2, 3, 4, 5, 6};
            PrintWriter printWriter = new PrintWriter("gui.json");
            JsonObject jsonObject = new JsonObject();
            JsonArray jsonArray = new JsonArray();
            for (int i = 0; i < 4; ++i) {
                JsonObject jsonObject2 = new JsonObject();
                jsonObject2.addProperty("key", "key_" + i);
                jsonObject2.addProperty("texture", "textures/gui/mail_icons.png");
                jsonObject2.addProperty("uvmap", gson2.toJson(nArray));
                jsonArray.add(jsonObject2);
            }
            jsonObject.add("gui", jsonArray);
            gson2 = new GsonBuilder().setPrettyPrinting().create();
            printWriter.write(gson2.toJson(jsonObject));
            printWriter.close();
        }
        catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
    }

    public static void _b() {
        try {
            Gson gson2 = new Gson();
            htyg htyg2 = xpzm._E()._S()._a(_c);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(htyg2._a()));
            String string = "";
            String string2 = "";
            while ((string2 = bufferedReader.readLine()) != null) {
                string = string + string2;
            }
            bufferedReader.close();
            JsonParser jsonParser = new JsonParser();
            JsonObject jsonObject = (JsonObject)jsonParser.parse(string);
            JsonArray jsonArray = jsonObject.get("gui").getAsJsonArray();
            Iterator<JsonElement> iterator2 = jsonArray.iterator();
            while (iterator2.hasNext()) {
                JsonObject jsonObject2 = iterator2.next().getAsJsonObject();
                String string3 = jsonObject2.get("key").getAsString();
                int[] nArray = gson2.fromJson(jsonObject2.get("uvmap").getAsString(), int[].class);
                int n = nArray.length;
                int[] nArray2 = new int[6];
                for (int i = 0; i < n; ++i) {
                    nArray2[i] = nArray[i];
                }
                nArray2[2] = nArray2[2] + nArray2[0];
                nArray2[3] = nArray2[3] + nArray2[1];
                if (n == 4) {
                    nArray2[4] = (nArray2[2] - nArray2[0]) / 2;
                    nArray2[5] = (nArray2[3] - nArray2[1]) / 2;
                }
                _a.put(string3, nArray2);
                _b.put(string3, jsonObject2.get("texture").getAsString());
            }
            for (String string3 : _a.keySet()) {
                Logger.info(string3 + " : " + Arrays.toString(_a.get(string3)), new Object[0]);
            }
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }
}

