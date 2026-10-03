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
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.xpzm;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraftforge.common.MinecraftForge;

public class ClientHandler
implements ITickHandler {
    public static LangUtil lang = LangUtil.loadLangDir("nei");
    private static ClientHandler instance;
    private ArrayList<EntityItem> SMPmagneticItems = new ArrayList();
    private ozlu lastworld;
    private gqjz lastGui;

    public void addSMPMagneticItem(int n, ozlu ozlu2) {
        pkix pkix2 = (pkix)ozlu2;
        Entity entity = pkix2.func_73045_a(n);
        if (entity == null || !(entity instanceof EntityItem)) {
            return;
        }
        this.SMPmagneticItems.add((EntityItem)entity);
    }

    private void updateMagnetMode(ozlu ozlu2, EntityPlayerSP entityPlayerSP) {
        if (!NEIClientConfig.getMagnetMode()) {
            return;
        }
        float f = 16.0f;
        float f2 = 8.0f;
        double d = 0.5;
        double d2 = 0.5;
        double d3 = 0.05;
        double d4 = 0.07;
        List<EntityItem> list = ozlu2.field_72995_K ? this.SMPmagneticItems : ozlu2.func_72872_a(EntityItem.class, entityPlayerSP.field_70121_D._b(f, f2, f));
        Iterator iterator2 = list.iterator();
        while (iterator2.hasNext()) {
            double d5;
            EntityItem entityItem = (EntityItem)iterator2.next();
            if (entityItem.field_70293_c > 0) continue;
            if (entityItem.field_70128_L && ozlu2.field_72995_K) {
                iterator2.remove();
            }
            if (!NEIClientUtils.canItemFitInInventory(entityPlayerSP, entityItem.func_92059_d())) continue;
            double d6 = entityPlayerSP.field_70165_t - entityItem.field_70165_t;
            double d7 = entityPlayerSP.field_70163_u + (double)entityPlayerSP.func_70047_e() - entityItem.field_70163_u;
            double d8 = entityPlayerSP.field_70161_v - entityItem.field_70161_v;
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
            double d11 = entityItem.field_70159_w + d3 * d6;
            double d12 = entityItem.field_70181_x + d4 * d7;
            double d13 = entityItem.field_70179_y + d3 * d8;
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
            if (d14 < 0.2 && d9 < 0.2 && ozlu2.field_72995_K) {
                entityItem.func_70106_y();
            }
            entityItem.func_70016_h(d11, d12, d13);
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
        xpzm xpzm2 = xpzm._E();
        if (enumSet.contains((Object)TickType.CLIENT) && xpzm2._r != null) {
            this.loadWorld(xpzm2._r, false);
            if (!NEIClientConfig.isEnabled()) {
                return;
            }
            KeyManager.tickKeyStates();
            NEIController.updateUnlimitedItems(xpzm2._t.field_71071_by);
            if (xpzm2._B == null) {
                NEIController.processCreativeCycling(xpzm2._t.field_71071_by);
            }
            this.updateMagnetMode(xpzm2._r, xpzm2._t);
        }
        if (enumSet.contains((Object)TickType.CLIENT)) {
            gqjz gqjz2 = xpzm2._B;
            if (gqjz2 != this.lastGui) {
                if (gqjz2 instanceof fngq) {
                    this.lastworld = null;
                } else if (gqjz2 instanceof fnfu) {
                    NEIClientConfig.reloadSaves();
                }
            }
            this.lastGui = gqjz2;
        }
    }

    public void loadWorld(ozlu ozlu2, boolean bl) {
        if (ozlu2 != this.lastworld) {
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
            this.lastworld = ozlu2;
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
        final hchw hchw2 = new hchw(null, null){

            @Override
            public void func_73867_d() {
            }

            @Override
            public void func_73860_n() {
            }

            @Override
            public void func_73863_a(int n, int n2, float f) {
                this.func_73873_v_();
                String[] stringArray = string.split("\n");
                for (int i = 0; i < stringArray.length; ++i) {
                    this.func_73732_a(this.field_73886_k, stringArray[i], this.field_73880_f / 2, this.field_73881_g / 3 + 12 * i, -1);
                }
            }
        };
        CustomModLoadingErrorDisplayException customModLoadingErrorDisplayException = new CustomModLoadingErrorDisplayException(){

            @Override
            public void initGui(hchw hchw22, qncw qncw2) {
                xpzm._E()._a(hchw2);
            }

            @Override
            public void drawScreen(hchw hchw22, qncw qncw2, int n, int n2, float f) {
            }
        };
        throw customModLoadingErrorDisplayException;
    }
}

