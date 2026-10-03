/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.respawn;

import com.google.common.base.Charsets;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.core.main.GloomyAPI;
import gloomyfolken.mods.stalker.respawn.jxtc;
import gloomyfolken.mods.stalker.respawn.kjui;
import gloomyfolken.mods.stalker.respawn.qlgf;
import gloomyfolken.mods.stalker.respawn.zwaw;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.network.packet.Packet;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;
import org.apache.commons.io.IOUtils;

@Mod(modid="GloomyRespawn", name="GloomyFolken's Stalker Respawn Mod", version="2.4.47_[1.6.4]", dependencies="required-after:GloomyCore;required-after:GloomyBundle;required-after:GloomyFactions")
public class RespawnMod {
    public static final ResourceLocation _a = new ResourceLocation("stalker", "deaths_quotes.json");
    public static final String _b = "GloomyRespawn";
    @Mod.Instance(value="GloomyRespawn")
    public static RespawnMod instance;
    public static Block _c;
    public static qlgf _d;
    private Configuration _h;
    @ezey(_a={eidj.CLIENT})
    public vlfg _e;
    @ezey(_a={eidj.CLIENT})
    public Multimap<String, String> _f;
    @ezey(_a={eidj.CLIENT})
    public gloomyfolken.mods.effects.client.main.jxtc _g;

    @Mod.EventHandler
    public void onPreInit(FMLPreInitializationEvent fMLPreInitializationEvent) {
        GloomyAPI.registerAssetsDir("stalkerrespawn", this.getClass());
        this._h = new Configuration(fMLPreInitializationEvent.getSuggestedConfigurationFile());
        this._h.save();
        InvokeSideOnly.client(fMLPreInitializationEvent.getSide().isClient(), () -> this._a());
    }

    @ezey(_a={eidj.CLIENT})
    private void _a() {
        Serializable serializable;
        Object object;
        this._f = HashMultimap.create();
        String string = null;
        try {
            object = Minecraft._E()._S()._a(_a)._a();
            serializable = null;
            try {
                string = String.join((CharSequence)"", IOUtils.readLines((InputStream)object, Charsets.UTF_8));
            }
            catch (Throwable throwable) {
                serializable = throwable;
                throw throwable;
            }
            finally {
                if (object != null) {
                    if (serializable != null) {
                        try {
                            ((InputStream)object).close();
                        }
                        catch (Throwable throwable) {
                            ((Throwable)serializable).addSuppressed(throwable);
                        }
                    } else {
                        ((InputStream)object).close();
                    }
                }
            }
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
        if (string == null) {
            FMLLog.warning("Unable to read quotes from death effect. Create config file at " + _a.toString(), new Object[0]);
        }
        object = new JsonParser().parse(string).getAsJsonObject();
        serializable = new ArrayList();
        serializable.addAll(((JsonObject)object).getAsJsonObject("effects").entrySet());
        serializable.addAll(((JsonObject)object).getAsJsonObject("anomalies").entrySet());
        serializable.add(new AbstractMap.SimpleEntry<String, JsonElement>("suicide", ((JsonObject)object).get("suicide")));
        Iterator iterator2 = serializable.iterator();
        while (iterator2.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator2.next();
            for (JsonElement jsonElement : ((JsonElement)entry.getValue()).getAsJsonArray()) {
                this._f.put((String)entry.getKey(), jsonElement.getAsString());
            }
        }
        this._g = new gloomyfolken.mods.effects.client.main.jxtc("stalkerrespawn", "line");
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent fMLInitializationEvent) {
        MinecraftForge.EVENT_BUS.register(new zwaw());
        MinecraftForge.EVENT_BUS.register(new zgpv());
        Packet.packetIdToClassMap._f(205);
        Packet.addIdClassMapping(205, false, true, ndnf.class);
        _c = new kjui(3140);
        GameRegistry.registerTileEntity(jxtc.class, "SavepointTile");
        GameRegistry.registerBlock(_c, "Savepoint");
    }

    static {
        _d = new qlgf();
    }
}

