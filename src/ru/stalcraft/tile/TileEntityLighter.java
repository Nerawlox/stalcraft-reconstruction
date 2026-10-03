/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  asx
 *  cpw.mods.fml.relauncher.ReflectionHelper
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  nb
 */
package ru.stalcraft.tile;

import atomicstryker.dynamiclights.client.DynamicLights;
import cpw.mods.fml.relauncher.ReflectionHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ru.stalcraft.Logger;
import ru.stalcraft.StalkerMain;
import ru.stalcraft.client.LighterLight;
import ru.stalcraft.client.gui.GuiSettingsStalker;
import ru.stalcraft.client.particles.LighterParticleEmitter;
import ru.stalcraft.entity.EntityGrenade;
import ru.stalcraft.entity.EntityLighterLight;
import ru.stalcraft.tile.TileEntityAnomaly;

public class TileEntityLighter
extends TileEntityAnomaly {
    public int activeTimer = 0;
    private String soundId = "";

    @Override
    public void h() {
        super.h();
        for (nn entity : this.az().a(nn.class, asx.a((double)((double)this.l - 1.5), (double)((double)this.m - 1.5), (double)((double)this.n - 1.5), (double)((double)this.l + 1.5), (double)((double)this.m + 1.5), (double)((double)this.n + 1.5)))) {
            if (!(entity instanceof of) && !(entity instanceof EntityGrenade)) continue;
            this.activeTimer = 300;
            Logger.console("test");
        }
        if (this.activeTimer > 0) {
            --this.activeTimer;
        }
        if (this.k.I) {
            this.clientUpdate();
        }
    }

    @SideOnly(value=Side.CLIENT)
    public void clientUpdate() {
        if (this.activeTimer > 0) {
            --this.activeTimer;
        }
    }

    @SideOnly(value=Side.CLIENT)
    public void onClientCollide() {
        bln sndManager = atv.w().v;
        if (!sndManager.b.playing(this.soundId)) {
            sndManager.a(StalkerMain.lighter.sound, (float)this.l + 0.5f, (float)this.m + 0.5f, (float)this.n + 0.5f, 1.0f, 1.0f);
            int latestSoundID = (Integer)ReflectionHelper.getPrivateValue(bln.class, (Object)atv.w().v, (String[])new String[]{"latestSoundID", "field_77378_e", "g"});
            this.soundId = "sound_" + latestSoundID;
        }
        if (this.activeTimer <= 0 && GuiSettingsStalker.dynamicLights) {
            EntityLighterLight entity = new EntityLighterLight(this);
            atv.w().f.d((nn)entity);
            DynamicLights.addLightSource(new LighterLight(entity));
        }
        this.activeTimer = 5;
    }

    public void onServerCollide(of entity) {
        this.activeTimer = 5;
        TileEntityAnomaly.damageEntityForce(entity, nb.a, 1.0f, true);
        entity.d(10);
    }

    @Override
    public boolean canUpdate() {
        return true;
    }

    @Override
    protected Class getEmitterClass() {
        return LighterParticleEmitter.class;
    }
}

