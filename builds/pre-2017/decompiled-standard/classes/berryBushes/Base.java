/*
 * Decompiled with CFR 0.152.
 */
package berryBushes;

import berryBushes.Berry;
import berryBushes.BerryConfig;
import berryBushes.BerryCrops;
import berryBushes.Bush;
import berryBushes.BushGen;
import berryBushes.proxy.Bsproxy;
import berryBushes.te.BushTE;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid="BerryBushes", name="Berry Bushes", version="1.0")
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
public class Base {
    public static tgdv berry;
    public static tgdv berryII;
    public static tgdv berryIII;
    public static tgdv berryIV;
    public static twgu bushI;
    public static twgu bushII;
    public static twgu bushIII;
    public static twgu bushIV;
    public static twgu berryCrop;
    @SidedProxy(serverSide="berryBushes.proxy.Bsproxy", clientSide="berryBushes.proxy.Bcproxy")
    public static Bsproxy proxy;

    @Mod.EventHandler
    public void load(FMLPreInitializationEvent fMLPreInitializationEvent) {
        BerryConfig.instance.loadConfig(fMLPreInitializationEvent.getSuggestedConfigurationFile());
    }

    @Mod.EventHandler
    public void load(FMLInitializationEvent fMLInitializationEvent) {
        GameRegistry.registerTileEntity(BushTE.class, "bushtileentity");
        berry = new Berry(BerryConfig.instance.berryI, 1, 0.5f, 0).func_77655_b("berryI");
        berryII = new Berry(BerryConfig.instance.berryII, 3, 0.5f, 1).func_77655_b("berryII");
        berryIII = new Berry(BerryConfig.instance.berryIII, 4, 0.5f, 2).func_77655_b("berryIII");
        berryIV = new Berry(BerryConfig.instance.berryIV, 6, 0.5f, 3).func_77655_b("berryIV");
        bushI = new Bush(745, 0).func_71864_b("BerryBush").func_71849_a(tgbl.field_78030_b);
        bushII = new Bush(746, 1).func_71864_b("BerryBushi").func_71849_a(tgbl.field_78030_b);
        bushIII = new Bush(747, 2).func_71864_b("BerryBushii").func_71849_a(tgbl.field_78030_b);
        bushIV = new Bush(748, 3).func_71864_b("BerryBushiii").func_71849_a(tgbl.field_78030_b);
        berryCrop = new BerryCrops(749).func_71864_b("berryCrops").func_71848_c(0.5f).func_71894_b(0.2f);
        LanguageRegistry.addName(berry, "Juicy Berry");
        LanguageRegistry.addName(berryII, "Sweet Berry");
        LanguageRegistry.addName(berryIII, "Luscious Berry");
        LanguageRegistry.addName(berryIV, "Nectarous Berry");
        LanguageRegistry.addName(bushI, "Small BerryBush");
        LanguageRegistry.addName(bushII, "BerryBush");
        LanguageRegistry.addName(bushIII, "Medium BerryBush");
        LanguageRegistry.addName(bushIV, "Bigger BerryBush");
        GameRegistry.registerBlock(bushI, "berryBush");
        GameRegistry.registerBlock(bushII, "berryBushII");
        GameRegistry.registerBlock(bushIII, "berryBushIII");
        GameRegistry.registerBlock(bushIV, "berryBushIV");
        GameRegistry.registerWorldGenerator(new BushGen());
        proxy.init();
    }
}

