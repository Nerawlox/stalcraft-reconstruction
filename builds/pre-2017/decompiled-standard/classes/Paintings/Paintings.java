/*
 * Decompiled with CFR 0.152.
 */
package Paintings;

import Paintings.CommonProxy;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import java.lang.reflect.Field;
import net.minecraft.util.ResourceLocation;

@Mod(modid="PaintingsMod", name="Paintings++", version="1.6.2")
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
public class Paintings {
    public static Paintings instance;
    @SidedProxy(serverSide="Paintings.CommonProxy", clientSide="Paintings.ClientProxy")
    public static CommonProxy proxy;
    private static final String CLASS_LOC = "com.mcf.davidee.paintinggui.gui.PaintingButton";

    @Mod.EventHandler
    public void load(FMLInitializationEvent fMLInitializationEvent) {
        proxy.registerRenderInformation();
        try {
            Class<?> clazz = Class.forName(CLASS_LOC);
            this.paintingGuiTextureHelper(clazz, "TEXTURE", new ResourceLocation("subaraki:art/gib.png"));
            this.paintingGuiHelper(clazz, "KZ_WIDTH", 256);
            this.paintingGuiHelper(clazz, "KZ_HEIGHT", 256);
        }
        catch (Exception exception) {
            FMLLog.getLogger().info("Davidees painting mod not installed or to old/new. Skipping");
        }
    }

    private void paintingGuiHelper(Class clazz, String string, int n) throws Exception {
        Field field = clazz.getField(string);
        field.setAccessible(true);
        field.set(null, n);
    }

    private void paintingGuiTextureHelper(Class clazz, String string, ResourceLocation resourceLocation) throws Exception {
        Field field = clazz.getField(string);
        field.setAccessible(true);
        field.set(null, resourceLocation);
    }
}

