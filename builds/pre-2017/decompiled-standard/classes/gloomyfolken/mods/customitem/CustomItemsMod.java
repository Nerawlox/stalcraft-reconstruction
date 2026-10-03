/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.customitem;

import com.google.common.reflect.TypeToken;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.asm.Logger;
import gloomyfolken.mods.core.main.GloomyAPI;
import java.lang.reflect.Type;
import java.util.Map;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid="GloomyItems", name="GloomyFolken's Blocks and Items Mod", version="2.4.47_[1.6.4]", dependencies="required-after:GloomyCore")
public class CustomItemsMod {
    private static Map<String, satl> _b;
    public static final String _a = "GloomyItems";

    @Mod.EventHandler
    public void onPreInit(FMLPreInitializationEvent fMLPreInitializationEvent) {
        GloomyAPI.registerAssetsDir("customitems", this.getClass());
        GloomyAPI.registerItemType(new rpgl());
        GloomyAPI.registerItemType(new jyql());
        GloomyAPI.registerItemType(new pjaj());
        GloomyAPI.registerItemType(new bqza());
        if (fMLPreInitializationEvent.getSide().isClient()) {
            InvokeSideOnly.client(() -> this._b());
        }
    }

    public static satl _a(String string) {
        CustomItemsMod._a();
        return _b.get(string);
    }

    private static void _a() {
        if (_b == null) {
            long l = System.currentTimeMillis();
            String string = srxe._b("/assets/customitems/loot.json");
            Type type = new TypeToken<Map<String, satl>>(){}.getType();
            _b = (Map)dwkx._b.fromJson(string, type);
            Logger.fine("Random loots parsed in " + (System.currentTimeMillis() - l) + " ms", new Object[0]);
        }
    }

    @Mod.EventHandler
    public void onInit(FMLInitializationEvent fMLInitializationEvent) {
        GameRegistry.registerTileEntity(uhov.class, "tileEntityCustomBlock");
        GameRegistry.registerTileEntity(hbio.class, "tileEntityCustomChest");
        if (fMLInitializationEvent.getSide().isClient()) {
            InvokeSideOnly.client(() -> this._c());
        }
    }

    @ezey(_a={eidj.CLIENT})
    private void _b() {
        new fmea();
        MinecraftForge.EVENT_BUS.register(uhoc._a);
    }

    @ezey(_a={eidj.CLIENT})
    private void _c() {
        ClientRegistry.bindTileEntitySpecialRenderer(uhov.class, fmea._a);
        ClientRegistry.bindTileEntitySpecialRenderer(hbio.class, fmea._a);
        MinecraftForge.EVENT_BUS.register(new sbia());
    }
}

