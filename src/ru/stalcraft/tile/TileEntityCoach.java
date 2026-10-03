/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.ReflectionHelper
 */
package ru.stalcraft.tile;

import cpw.mods.fml.relauncher.ReflectionHelper;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import ru.stalcraft.Config;
import ru.stalcraft.StalkerDamage;
import ru.stalcraft.tile.TileEntityAnomaly;

public class TileEntityCoach
extends TileEntityAnomaly {
    private HashMap targets = new HashMap();
    private boolean isSoundActive;
    private String activeSound = "stalker:coach_active";
    private String playingSound;

    public void addTarget(uf player) {
        if (!this.targets.containsKey(player)) {
            this.targets.put(player, 0);
        }
    }

    public void removeTarget(uf player) {
        this.targets.remove(player);
    }

    @Override
    public void h() {
        block5: {
            block3: {
                bln entry;
                block4: {
                    super.h();
                    if (!this.k.I) break block3;
                    boolean it2 = this.targets.size() > 0;
                    entry = atv.w().v;
                    if (!it2 || this.playingSound != null && entry.b.playing(this.playingSound)) break block4;
                    int latestSoundID = (Integer)ReflectionHelper.getPrivateValue(bln.class, (Object)atv.w().v, (String[])new String[]{"latestSoundID", "field_77378_e", "g"});
                    this.playingSound = "sound_" + (latestSoundID + 1) % 256;
                    entry.a(this.activeSound, (float)this.l + 0.5f, (float)this.m + 0.5f, (float)this.n + 0.5f, 1.0f, 1.0f);
                    break block5;
                }
                if (this.playingSound == null || !entry.b.playing(this.playingSound) || this.isSoundActive) break block5;
                entry.b.stop(this.playingSound);
                break block5;
            }
            Iterator it1 = this.targets.entrySet().iterator();
            while (it1.hasNext()) {
                Map.Entry entry1 = it1.next();
                entry1.setValue(Math.max(0, (Integer)entry1.getValue() - 1));
                if (!((uf)entry1.getKey()).M && ((uf)entry1.getKey()).q == this.k) {
                    double distance = Math.sqrt(this.a(((uf)entry1.getKey()).u, ((uf)entry1.getKey()).v, ((uf)entry1.getKey()).w));
                    if (distance > 50.0) {
                        it1.remove();
                        continue;
                    }
                    if (!(distance > 5.0) || (Integer)entry1.getValue() >= 1) continue;
                    ((uf)entry1.getKey()).a(StalkerDamage.coach, (float)Config.coachDamage);
                    int distanceRate = 10 - (int)(distance / 5.0);
                    entry1.setValue(5 + distanceRate);
                    continue;
                }
                it1.remove();
            }
        }
    }

    @Override
    public boolean canUpdate() {
        return true;
    }

    @Override
    protected Class getEmitterClass() {
        return null;
    }
}

