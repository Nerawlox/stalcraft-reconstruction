/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  beu
 *  cpw.mods.fml.common.ITickHandler
 *  cpw.mods.fml.common.TickType
 *  cpw.mods.fml.relauncher.ReflectionHelper
 */
package ru.stalcraft.client;

import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;
import cpw.mods.fml.relauncher.ReflectionHelper;
import java.util.EnumSet;
import ru.stalcraft.client.ClientProxy;
import ru.stalcraft.entity.EntityCorpse;
import ru.stalcraft.items.ItemSkin;

public class ClientRenderTicker
implements ITickHandler {
    public static int hitMarker = 0;

    public void tickStart(EnumSet type, Object ... tickData) {
        ClientProxy.modelManager.tick();
        atv mc = atv.w();
        if (mc.f != null) {
            int l2 = mc.f.e.size();
            nn entity = null;
            ye stack = null;
            for (int i2 = 0; i2 < l2; ++i2) {
                entity = (nn)mc.f.e.get(i2);
                if (entity instanceof uf) {
                    stack = ((uf)entity).bn.b[1];
                    if (stack != null && yc.g[stack.d] instanceof ItemSkin) {
                        ReflectionHelper.setPrivateValue(beu.class, (Object)((beu)entity), (Object)((ItemSkin)((Object)yc.g[stack.d])).texture, (String[])new String[]{"locationSkin", "field_110312_d", "d"});
                    } else {
                        ReflectionHelper.setPrivateValue(beu.class, (Object)((beu)entity), (Object)beu.b, (String[])new String[]{"locationSkin", "field_110312_d", "d"});
                    }
                }
                if (!(entity instanceof EntityCorpse)) continue;
                stack = ((EntityCorpse)entity).inventory.mainInventory[37];
                ((EntityCorpse)entity).locationSkin = stack != null && yc.g[stack.d] instanceof ItemSkin ? ((ItemSkin)((Object)yc.g[stack.d])).texture : beu.b;
            }
        }
    }

    public void tickEnd(EnumSet type, Object ... tickData) {
    }

    public EnumSet ticks() {
        return EnumSet.of(TickType.RENDER);
    }

    public String getLabel() {
        return "StalkerRenderTicker";
    }
}

