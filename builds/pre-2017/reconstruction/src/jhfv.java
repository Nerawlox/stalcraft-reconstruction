/*
 * Decompiled with CFR 0.152.
 */
import com.google.common.base.Charsets;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import gloomyfolken.bundle.common.core.pidb;
import gloomyfolken.mods.core.main.GloomyCore;
import gloomyfolken.mods.core.misc.jxsn;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.ResourceManager;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.ForgeSubscribe;

public class jhfv {
    private Gson _b = new GsonBuilder().registerTypeAdapter((Type)((Object)ResourceLocation.class), (jsonElement, type, jsonDeserializationContext) -> new ResourceLocation(jsonElement.getAsString())).create();
    public static final jhfv _a = new jhfv();

    @ForgeSubscribe
    public void _a(piyf piyf2) {
        boolean bl;
        rpaa rpaa2 = piyf2._b;
        mqrl mqrl2 = GloomyCore.instance.itemsLoader._b(rpaa2._f);
        String string = piwi._b().asMap().entrySet().stream().filter(entry -> ((Collection)entry.getValue()).stream().anyMatch(clazz -> clazz.isAssignableFrom(mqrl2.getClass()))).findFirst().map(Map.Entry::getKey).orElse(null);
        if (string != null && piyf2._a instanceof jxsn && !(bl = piyf2._b._i("hide_in_pda"))) {
            String string2 = piyf2._b._h("pda_category");
            if (!string2.isEmpty()) {
                string = string + "/" + string2;
            }
            piwi._a(string)._a((Item)((Object)((jxsn)((Object)piyf2._a))));
        }
    }

    public void _a(String string) {
        List<String> list = srxe._a(string);
        ResourceManager resourceManager = Minecraft._E()._S();
        for (String string2 : list) {
            if (!string2.endsWith("json")) continue;
            String string3 = string2.substring(string.length());
            try {
                InputStream inputStream = resourceManager._a(new ResourceLocation("gloomycore", "handbook/" + string3))._a();
                Throwable throwable = null;
                try {
                    this._a(new InputStreamReader(inputStream, Charsets.UTF_8));
                }
                catch (Throwable throwable2) {
                    throwable = throwable2;
                    throw throwable2;
                }
                finally {
                    if (inputStream == null) continue;
                    if (throwable != null) {
                        try {
                            inputStream.close();
                        }
                        catch (Throwable throwable3) {
                            throwable.addSuppressed(throwable3);
                        }
                        continue;
                    }
                    inputStream.close();
                }
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
        }
    }

    public void _a(Reader reader) {
        JsonElement jsonElement = new JsonParser().parse(reader);
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        anms anms2 = this._b.fromJson(jsonElement, anms.class);
        if (!jsonObject.has("category")) {
            pidb._a("Skipping page %s because it doesn't have category defined", anms2.getString());
            return;
        }
        String string = jsonObject.get("category").getAsString();
        piwi._a(string)._a(anms2);
        pidb._a("Handbook page %s/%s successfully loaded", string, anms2.getString());
    }
}

