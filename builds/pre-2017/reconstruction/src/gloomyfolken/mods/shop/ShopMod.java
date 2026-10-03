/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.shop;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLLoadCompleteEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.mods.asm.GloomyLoadingPlugin;
import gloomyfolken.mods.asm.Logger;
import gloomyfolken.mods.core.main.GloomyAPI;
import gloomyfolken.mods.core.main.GloomyCore;
import gloomyfolken.mods.core.misc.hanr;
import gloomyfolken.mods.core.misc.kjui;
import gloomyfolken.mods.core.misc.pidb;
import gloomyfolken.mods.shop.data.CaseData;
import gloomyfolken.mods.shop.data.ShopData;
import gloomyfolken.mods.shop.data.ShopEntry;
import gloomyfolken.mods.shop.data.ShopItem;
import gloomyfolken.mods.shop.data.ShopKit;
import gloomyfolken.mods.shop.ezey;
import gloomyfolken.mods.shop.zwaw;
import java.io.IOException;
import java.lang.reflect.Type;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid="GloomyShop", name="GloomyFolken's Shop Mod", version="2.4.47_[1.6.4]", dependencies="required-after:GloomyCore")
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
public class ShopMod {
    public static final Gson _a = dwkx._a.registerTypeAdapter((Type)((Object)hanr.class), new TypeAdapter<hanr>(){

        public void _a(JsonWriter jsonWriter, hanr hanr2) throws IOException {
            jsonWriter.value(hanr2._i);
        }

        public hanr _a(JsonReader jsonReader) throws IOException {
            return hanr._h.get(jsonReader.nextString());
        }

        @Override
        public /* synthetic */ Object read(JsonReader jsonReader) throws IOException {
            return this._a(jsonReader);
        }

        @Override
        public /* synthetic */ void write(JsonWriter jsonWriter, Object object) throws IOException {
            this._a(jsonWriter, (hanr)((Object)object));
        }
    }).create();
    public static final String _b = "GloomyShop";
    private static ShopData _e;
    private static CaseData _f;
    public static zwaw _c;
    public static ShopMod _d;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent fMLPreInitializationEvent) {
        _d = this;
        GloomyAPI.registerAssetsDir("shop", this.getClass());
        Configuration configuration = new Configuration(fMLPreInitializationEvent.getSuggestedConfigurationFile());
        _c = new zwaw(configuration);
        configuration.save();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent fMLInitializationEvent) {
        MinecraftForge.EVENT_BUS.register(new ezey());
        ncwh._a = new ncwh.kjui(){

            @Override
            public void _a(EntityPlayer entityPlayer, ItemStack itemStack) {
                InvokeSideOnly.frontend(() -> {});
            }
        };
        pidb._a.add(new kjui(){

            @Override
            public boolean isInventoryPersonal(IInventory iInventory) {
                return iInventory instanceof dghc;
            }
        });
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent fMLPostInitializationEvent) {
        if (fMLPostInitializationEvent.getSide().isClient()) {
            InvokeSideOnly.client(() -> this._d());
        } else {
            InvokeSideOnly.frontend(() -> {});
        }
    }

    private static void _c() {
        _e = new ShopData();
        try {
            long l = System.currentTimeMillis();
            String string = srxe._b("/assets/shop/shop.json");
            Gson gson2 = new GsonBuilder().registerTypeAdapter((Type)((Object)ShopEntry.class), (jsonElement, type, jsonDeserializationContext) -> jsonElement.getAsJsonObject().has("stacks") ? jsonDeserializationContext.deserialize(jsonElement, (Type)((Object)ShopKit.class)) : jsonDeserializationContext.deserialize(jsonElement, (Type)((Object)ShopItem.class))).registerTypeAdapter((Type)((Object)wnce.class), new ncgb()).registerTypeAdapter((Type)((Object)NBTTagCompound.class), new tdxg()).create();
            _e = gson2.fromJson(string, ShopData.class);
            _e._a();
            l = System.currentTimeMillis() - l;
            Logger.finest("Shop data loaded in " + l + " ms.", new Object[0]);
        }
        catch (JsonParseException jsonParseException) {
            jsonParseException.printStackTrace();
        }
    }

    @Mod.EventHandler
    public void loadComplete(FMLLoadCompleteEvent fMLLoadCompleteEvent) {
    }

    @gloomyfolken.bundle.common.core.ezey(_a={eidj.CLIENT})
    private void _d() {
        MinecraftForge.EVENT_BUS.register(new sbna());
    }

    private void _e() {
    }

    public static ShopData _a() {
        if (_e == null) {
            ShopMod._c();
        }
        return _e;
    }

    public static CaseData _b() {
        if (_f == null && (GloomyCore.side.isServer() || GloomyLoadingPlugin._a)) {
            InvokeSideOnly.frontend(() -> {});
        }
        return _f;
    }

    public static void _a(CaseData caseData) {
        _f = caseData;
    }
}

