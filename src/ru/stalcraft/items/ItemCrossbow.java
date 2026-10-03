/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.common.FMLCommonHandler
 *  cpw.mods.fml.relauncher.Side
 *  net.minecraftforge.client.IItemRenderer
 *  net.minecraftforge.client.MinecraftForgeClient
 */
package ru.stalcraft.items;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import java.util.ArrayList;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;
import ru.stalcraft.client.ClientProxy;
import ru.stalcraft.client.render.RenderWeapon;
import ru.stalcraft.items.FireMode;
import ru.stalcraft.items.ItemWeapon;

public class ItemCrossbow
extends ItemWeapon {
    public ItemCrossbow(int id) {
        super(id, yc.n.cv, new FireMode[]{FireMode.BOLT}, 10, 0, 1, 60, 300, 0.0f, "\u0410\u0440\u0431\u0430\u043b\u0435\u0442", "crossbow", "crossbow.obj", "crossbow", new ArrayList(), null, "", "", "crossbow_reload", null, null, 0, 0, false, true, 1, 0.0f, 0.0f, 1.5f, 15.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, false, false, false, null, null, 1.0f, 100);
        if (FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT) {
            RenderWeapon render = new RenderWeapon(this);
            MinecraftForgeClient.registerItemRenderer((int)id, (IItemRenderer)render);
            ClientProxy.weaponRenders.put(id, render);
        }
    }

    @Override
    public void shoot(of shooter, ye stack, boolean leftClick, boolean hasFlash) {
        abw w2 = shooter.q;
        uh entityarrow = new uh(w2, shooter, 2.0f);
        entityarrow.b(20.0);
        w2.a(shooter, "random.bow", 1.0f, 1.0f / (yc.f.nextFloat() * 0.4f + 1.2f) + 0.5f);
        w2.d(entityarrow);
    }
}

