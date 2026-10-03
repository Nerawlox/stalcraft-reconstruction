/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei;

import codechicken.core.ClientUtils;
import codechicken.core.NetworkClosedException;
import codechicken.lib.lang.LangUtil;
import codechicken.lib.packet.PacketCustom;
import codechicken.nei.DefaultHighlightHandler;
import codechicken.nei.HUDRenderer;
import codechicken.nei.KeyManager;
import codechicken.nei.NEICPH;
import codechicken.nei.NEIClientConfig;
import codechicken.nei.NEIClientUtils;
import codechicken.nei.NEIController;
import codechicken.nei.TMIUninstaller;
import codechicken.nei.WorldOverlayRenderer;
import codechicken.nei.api.API;
import codechicken.nei.api.ItemInfo;
import cpw.mods.fml.client.CustomModLoadingErrorDisplayException;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiErrorScreen;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;

public class ClientHandler
implements ITickHandler {
    public static LangUtil lang = LangUtil.loadLangDir("nei");
    private static ClientHandler instance;
    private ArrayList<EntityItem> SMPmagneticItems = new ArrayList();
    private World lastworld;
    private GuiScreen lastGui;

    public void addSMPMagneticItem(int n, World world) {
        pkix pkix2 = (pkix)world;
        Entity entity = pkix2.getEntityByID(n);
        if (entity == null || !(entity instanceof EntityItem)) {
            return;
        }
        this.SMPmagneticItems.add((EntityItem)entity);
    }

    private void updateMagnetMode(World world, EntityPlayerSP entityPlayerSP) {
        if (!NEIClientConfig.getMagnetMode()) {
            return;
        }
        float f = 16.0f;
        float f2 = 8.0f;
        double d = 0.5;
        double d2 = 0.5;
        double d3 = 0.05;
        double d4 = 0.07;
        List<EntityItem> list = world.isRemote ? this.SMPmagneticItems : world.getEntitiesWithinAABB(EntityItem.class, entityPlayerSP.boundingBox._b(f, f2, f));
        Iterator iterator2 = list.iterator();
        while (iterator2.hasNext()) {
            double d5;
            EntityItem entityItem = (EntityItem)iterator2.next();
            if (entityItem.delayBeforeCanPickup > 0) continue;
            if (entityItem.isDead && world.isRemote) {
                iterator2.remove();
            }
            if (!NEIClientUtils.canItemFitInInventory(entityPlayerSP, entityItem.getEntityItem())) continue;
            double d6 = entityPlayerSP.posX - entityItem.posX;
            double d7 = entityPlayerSP.posY + (double)entityPlayerSP.getEyeHeight() - entityItem.posY;
            double d8 = entityPlayerSP.posZ - entityItem.posZ;
            double d9 = Math.sqrt(d6 * d6 + d8 * d8);
            double d10 = Math.abs(d7);
            if (d9 > (double)f) continue;
            if (d9 > 1.0) {
                d6 /= d9;
                d8 /= d9;
            }
            if (d10 > 1.0) {
                d7 /= d10;
            }
            double d11 = entityItem.motionX + d3 * d6;
            double d12 = entityItem.motionY + d4 * d7;
            double d13 = entityItem.motionZ + d3 * d8;
            double d14 = Math.sqrt(d11 * d11 + d13 * d13);
            double d15 = Math.abs(d12);
            double d16 = d14 / d;
            if (d16 > 1.0) {
                d11 /= d16;
                d13 /= d16;
            }
            if ((d5 = d15 / d2) > 1.0) {
                d12 /= d5;
            }
            if (d14 < 0.2 && d9 < 0.2 && world.isRemote) {
                entityItem.setDead();
            }
            entityItem.setVelocity(d11, d12, d13);
        }
    }

    public static void load() {
        try {
            TMIUninstaller.deleteTMIUninstaller();
            if (TMIUninstaller.TMIInstalled()) {
                TMIUninstaller.runTMIUninstaller();
                NEIClientUtils.mc()._h();
            }
        }
        catch (Exception exception) {
            System.err.println("Error with TMI Uninstaller");
            exception.printStackTrace();
        }
        instance = new ClientHandler();
        PacketCustom.assignHandler("NEI", 0, 255, new NEICPH());
        TickRegistry.registerTickHandler(instance, Side.CLIENT);
        MinecraftForge.EVENT_BUS.register(new WorldOverlayRenderer());
        LanguageRegistry.instance().addStringLocalization("entity.SnowMan.name", "Snow Golem");
        API.registerHighlightHandler(new DefaultHighlightHandler(), ItemInfo.Layout.HEADER);
        HUDRenderer.load();
    }

    @Override
    public void tickStart(EnumSet<TickType> enumSet, Object ... objectArray) {
        Minecraft minecraft = Minecraft._E();
        if (enumSet.contains((Object)TickType.CLIENT) && minecraft._r != null) {
            this.loadWorld(minecraft._r, false);
            if (!NEIClientConfig.isEnabled()) {
                return;
            }
            KeyManager.tickKeyStates();
            NEIController.updateUnlimitedItems(minecraft._t.inventory);
            if (minecraft._B == null) {
                NEIController.processCreativeCycling(minecraft._t.inventory);
            }
            this.updateMagnetMode(minecraft._r, minecraft._t);
        }
        if (enumSet.contains((Object)TickType.CLIENT)) {
            GuiScreen guiScreen = minecraft._B;
            if (guiScreen != this.lastGui) {
                if (guiScreen instanceof fngq) {
                    this.lastworld = null;
                } else if (guiScreen instanceof fnfu) {
                    NEIClientConfig.reloadSaves();
                }
            }
            this.lastGui = guiScreen;
        }
    }

    public void loadWorld(World world, boolean bl) {
        if (world != this.lastworld) {
            this.SMPmagneticItems.clear();
            WorldOverlayRenderer.reset();
            if (!bl) {
                NEIClientConfig.setHasSMPCounterPart(false);
                NEIClientConfig.setInternalEnabled(false);
                try {
                    if (ClientUtils.isLocal()) {
                        return;
                    }
                }
                catch (NetworkClosedException networkClosedException) {
                    return;
                }
                NEIClientConfig.loadWorld("remote/" + ClientUtils.getServerIP().replace(':', '~'));
            }
            this.lastworld = world;
        }
    }

    @Override
    public void tickEnd(EnumSet<TickType> enumSet, Object ... objectArray) {
        if (enumSet.contains((Object)TickType.RENDER) && NEIClientConfig.isEnabled()) {
            HUDRenderer.renderOverlay();
        }
    }

    @Override
    public EnumSet<TickType> ticks() {
        return EnumSet.of(TickType.CLIENT, TickType.RENDER);
    }

    @Override
    public String getLabel() {
        return "NEI Client";
    }

    public static ClientHandler instance() {
        return instance;
    }

    public static RuntimeException throwCME(final String string) {
        final GuiErrorScreen guiErrorScreen = new GuiErrorScreen(null, null){

            @Override
            public void handleMouseInput() {
            }

            @Override
            public void handleKeyboardInput() {
            }

            @Override
            public void drawScreen(int n, int n2, float f) {
                this.drawDefaultBackground();
                String[] stringArray = string.split("\n");
                for (int i = 0; i < stringArray.length; ++i) {
                    this.drawCenteredString(this.fontRenderer, stringArray[i], this.width / 2, this.height / 3 + 12 * i, -1);
                }
            }
        };
        CustomModLoadingErrorDisplayException customModLoadingErrorDisplayException = new CustomModLoadingErrorDisplayException(){

            @Override
            public void initGui(GuiErrorScreen guiErrorScreen2, FontRenderer fontRenderer) {
                Minecraft._E()._a(guiErrorScreen);
            }

            @Override
            public void drawScreen(GuiErrorScreen guiErrorScreen2, FontRenderer fontRenderer, int n, int n2, float f) {
            }
        };
        throw customModLoadingErrorDisplayException;
    }
}

