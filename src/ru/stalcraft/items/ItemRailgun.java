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
import ru.stalcraft.entity.EntityRail;
import ru.stalcraft.items.FireMode;
import ru.stalcraft.items.ItemWeapon;
import ru.stalcraft.server.network.ServerPacketSender;

public class ItemRailgun
extends ItemWeapon {
    public ItemRailgun(int id) {
        super(id, 20000, new FireMode[]{FireMode.SEMIAUTO}, 20, 100, 1, 200, 500, 8.0f, "\u0413\u0430\u0443\u0441\u0441-\u043f\u0443\u0448\u043a\u0430", "railgun", "railgun.obj", "railgun", new ArrayList(), null, "railgun_shoot", "railgun_hit", "railgun_reload", null, null, 0, 0, false, true, 1, 0.0f, 0.0f, 1.5f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, false, false, false, null, null, 1.0f, 100);
        if (FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT) {
            RenderWeapon render = new RenderWeapon(this);
            MinecraftForgeClient.registerItemRenderer((int)id, (IItemRenderer)render);
            ClientProxy.weaponRenders.put(id, render);
        }
    }

    @Override
    public void shoot(of shooter, ye stack, boolean leftClick, boolean hasFlash) {
        abw w2 = shooter.q;
        float yaw = shooter instanceof of ? shooter.aP : shooter.A;
        float pitch = shooter.B;
        if (leftClick) {
            yaw += (float)(Math.random() - 0.5) * 10.0f;
            pitch += (float)(Math.random() - 0.5) * 10.0f;
        }
        EntityRail bullet = new EntityRail(shooter, this.damage, leftClick, this.bulletSpeed, this.hitSound, yaw, pitch);
        if (!w2.I) {
            w2.a(shooter, this.shootSound, 1.0f, 0.9f + shooter.q.s.nextFloat() * 0.1f);
            ServerPacketSender.sendShoot(shooter, true);
            w2.d(bullet);
            ServerPacketSender.sendRotation(bullet, bullet.A, bullet.B);
        }
    }
}

