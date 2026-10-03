/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs;

import cpw.mods.fml.common.FMLLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.entity.player.EntityPlayer;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.controllers.RandomEquipState;

public class RandomEquipSettings
implements mssh {
    public boolean enabled = false;
    public Map<Integer, Skin> skins = new HashMap<Integer, Skin>();
    public Map<Integer, cvzo> stacks = new HashMap<Integer, cvzo>();
    public Map<Integer, Float> weights = new HashMap<Integer, Float>();

    public void reShuffleEquip(EntityNPCInterface entityNPCInterface) {
        RandomEquipState randomEquipState = entityNPCInterface.randomEquipState;
        if (this.enabled) {
            String string = this.selectWeightedSkin();
            randomEquipState.skin = string != null ? string : entityNPCInterface.display.texture;
            randomEquipState.weapon = this.selectWeightedItem(0, 12);
            randomEquipState.armor = this.selectWeightedItem(12, 12);
            randomEquipState.applied = true;
        } else {
            randomEquipState.applied = false;
            randomEquipState.skin = null;
            randomEquipState.weapon = null;
            randomEquipState.armor = null;
        }
    }

    private String selectWeightedSkin() {
        HashMap<String, Float> hashMap = new HashMap<String, Float>();
        for (Skin skin : this.skins.values()) {
            if (skin.texture.isEmpty()) continue;
            hashMap.put(skin.texture, Float.valueOf(skin.weight));
        }
        return (String)this.selectWeighted(hashMap);
    }

    private cvzo selectWeightedItem(int n, int n2) {
        HashMap<cvzo, Float> hashMap = new HashMap<cvzo, Float>();
        for (int i = n; i < n + n2; ++i) {
            if (!this.stacks.containsKey(i)) continue;
            hashMap.put(this.stacks.get(i), this.weights.getOrDefault(i, Float.valueOf(1.0f)));
        }
        return (cvzo)this.selectWeighted(hashMap);
    }

    private <T> T selectWeighted(Map<T, Float> map) {
        float f = 0.0f;
        Iterator<Object> iterator2 = map.values().iterator();
        while (iterator2.hasNext()) {
            float f2 = iterator2.next().floatValue();
            f += f2;
        }
        f *= ThreadLocalRandom.current().nextFloat();
        for (Map.Entry entry : map.entrySet()) {
            if (!((f -= ((Float)entry.getValue()).floatValue()) <= 0.0f)) continue;
            return (T)entry.getKey();
        }
        return null;
    }

    public void writeToNbt(qoac qoac2) {
        Object object;
        qoac qoac3 = new qoac();
        qoac3._a("Enabled", this.enabled);
        bsyv bsyv2 = new bsyv();
        for (Map.Entry<Integer, Skin> object22 : this.skins.entrySet()) {
            qoac qoac4 = new qoac();
            qoac4._a("Id", (int)object22.getKey());
            qoac4._a("Skin", object22.getValue().texture);
            qoac4._a("Weight", object22.getValue().weight);
            bsyv2._a(qoac4);
        }
        qoac3._a("Skins", bsyv2);
        bsyv bsyv3 = new bsyv();
        for (int n : this.stacks.keySet()) {
            qoac qoac5 = new qoac();
            qoac5._a("Slot", n);
            object = this.stacks.get(n);
            ((cvzo)object)._b(qoac5);
            bsyv3._a(qoac5);
        }
        qoac3._a("Stacks", bsyv3);
        bsyv bsyv4 = new bsyv();
        for (int n : this.weights.keySet()) {
            object = new qoac();
            ((qoac)object)._a("Slot", n);
            ((qoac)object)._a("Weight", this.weights.get(n).floatValue());
            bsyv4._a((huhy)object);
        }
        qoac3._a("Stacks", bsyv3);
        qoac3._a("Weights", bsyv4);
        qoac2._a("RandomEquipSettings", qoac3);
    }

    public void readFromNbt(qoac qoac2) {
        qoac qoac3 = qoac2._m("RandomEquipSettings");
        this.skins.clear();
        this.enabled = qoac3._o("Enabled");
        bsyv bsyv2 = qoac3._n("Skins");
        for (int i = 0; i < bsyv2._d(); ++i) {
            qoac qoac4 = (qoac)bsyv2._b(i);
            int n = qoac4._f("Id");
            String string = qoac4._j("Skin");
            float f = qoac4._h("Weight");
            this.skins.put(n, new Skin(string, f));
        }
        this.stacks.clear();
        bsyv bsyv3 = qoac3._n("Stacks");
        for (int i = 0; i < bsyv3._d(); ++i) {
            qoac qoac5 = (qoac)bsyv3._b(i);
            int n = qoac5._f("Slot");
            cvzo cvzo2 = cvzo._a(qoac5);
            if (cvzo2 != null) {
                this.stacks.put(n, cvzo2);
                continue;
            }
            FMLLog.warning("Failed to load ItemStack with id %d from stored random equip settings", qoac5._e("id"));
        }
        this.weights.clear();
        bsyv bsyv4 = qoac3._n("Weights");
        for (int i = 0; i < bsyv4._d(); ++i) {
            qoac qoac6 = (qoac)bsyv4._b(i);
            int n = qoac6._f("Slot");
            float f = qoac6._h("Weight");
            this.weights.put(n, Float.valueOf(f));
        }
    }

    @Override
    public int func_70302_i_() {
        return 24;
    }

    @Override
    public cvzo func_70301_a(int n) {
        return this.stacks.get(n);
    }

    @Override
    public cvzo func_70298_a(int n, int n2) {
        if (this.stacks.containsKey(n)) {
            if (this.stacks.get((Object)Integer.valueOf((int)n))._b <= n2) {
                cvzo cvzo2 = this.stacks.get(n);
                this.stacks.remove(n);
                this.func_70296_d();
                return cvzo2;
            }
            cvzo cvzo3 = this.stacks.get(n)._a(n2);
            if (this.stacks.get((Object)Integer.valueOf((int)n))._b == 0) {
                this.stacks.remove(n);
            }
            return cvzo3;
        }
        return null;
    }

    @Override
    public cvzo func_70304_b(int n) {
        if (this.stacks.containsKey(n) && this.stacks.get(n) != null) {
            cvzo cvzo2 = this.stacks.get(n);
            this.stacks.remove(n);
            return cvzo2;
        }
        return null;
    }

    @Override
    public void func_70299_a(int n, cvzo cvzo2) {
        if (cvzo2 == null) {
            this.stacks.remove(n);
        } else {
            this.stacks.put(n, cvzo2);
        }
    }

    @Override
    public String func_70303_b() {
        return "Random Equip";
    }

    @Override
    public boolean func_94042_c() {
        return false;
    }

    @Override
    public int func_70297_j_() {
        return 10000;
    }

    @Override
    public void func_70296_d() {
    }

    @Override
    public boolean func_70300_a(EntityPlayer entityPlayer) {
        return true;
    }

    @Override
    public void func_70295_k_() {
    }

    @Override
    public void func_70305_f() {
    }

    @Override
    public boolean func_94041_b(int n, cvzo cvzo2) {
        return n < 12 || cvzo2._a() instanceof lpno;
    }

    public static class Skin {
        public String texture;
        public float weight;

        public Skin(String string, float f) {
            this.texture = string;
            this.weight = f;
        }
    }
}

