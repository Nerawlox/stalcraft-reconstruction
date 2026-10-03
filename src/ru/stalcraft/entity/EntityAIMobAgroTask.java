/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  asx
 *  re
 */
package ru.stalcraft.entity;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class EntityAIMobAgroTask
extends re {
    private static final float LOW_DISTANE_AGRO_PER_TICK = 2.5f;
    private static final float OWNER_DAMAGE_AGRO = 10.0f;
    private static final float AGRO_FACTOR_PER_TICK = 0.95f;
    private static final float ALLY_DAMAGE_AGRO = 2.0f;
    public of targetEntity;
    Class targetClass;
    float agroDistance;
    float maxDistance;
    private int checkDistance = 5;
    HashMap agro = new HashMap();

    public EntityAIMobAgroTask(on owner, float agroDistance, float maxDistance) {
        this(owner, uf.class, agroDistance, maxDistance);
    }

    public EntityAIMobAgroTask(on owner, Class targetClass, float agroDistance, float maxDistance) {
        super(owner, false, false);
        this.targetClass = targetClass;
        this.agroDistance = agroDistance;
        this.maxDistance = maxDistance;
        this.a(3);
    }

    public boolean a() {
        return true;
    }

    public boolean b() {
        return true;
    }

    public void d() {
        this.targetEntity = null;
        this.agro.clear();
    }

    public void onOwnerAttack(of enemy, float damage) {
        if (this.agro.containsKey(enemy)) {
            this.agro.put(enemy, Float.valueOf(((Float)this.agro.get(enemy)).floatValue() + 10.0f * damage));
        } else {
            this.agro.put(enemy, Float.valueOf(10.0f * damage));
        }
    }

    public void onAllyAttack(of enemy, float damage) {
        if (this.agro.containsKey(enemy)) {
            this.agro.put(enemy, Float.valueOf(((Float)this.agro.get(enemy)).floatValue() + 2.0f * damage));
        } else {
            this.agro.put(enemy, Float.valueOf(2.0f * damage));
        }
    }

    public void e() {
        this.removeUnsuitableTargets();
        if (--this.checkDistance <= 0) {
            float it2 = this.agroDistance * this.agroDistance;
            List newTarget = this.c.q.a(this.targetClass, asx.a((double)(this.c.u - (double)this.agroDistance), (double)(this.c.v - (double)this.agroDistance), (double)(this.c.w - (double)this.agroDistance), (double)(this.c.u + (double)this.agroDistance), (double)(this.c.v + (double)this.agroDistance), (double)(this.c.w + (double)this.agroDistance)));
            for (of it22 : newTarget) {
                if (!(this.c.e(it22) <= (double)it2) || it22 instanceof uf && ((uf)it22).bG.a) continue;
                if (this.agro.containsKey(it22)) {
                    this.agro.put(it22, Float.valueOf(((Float)this.agro.get(it22)).floatValue() + 2.5f));
                    continue;
                }
                this.agro.put(it22, Float.valueOf(2.5f));
            }
            this.checkDistance = 5;
        }
        Iterator var6 = this.agro.entrySet().iterator();
        while (var6.hasNext()) {
            Map.Entry var7 = var6.next();
            var7.setValue(Float.valueOf(((Float)var7.getValue()).floatValue() * 0.95f));
            if (!(((Float)var7.getValue()).floatValue() <= 0.0f)) continue;
            var6.remove();
        }
        of var8 = null;
        if (this.agro.size() > 0) {
            float var9 = -1.0f;
            for (Map.Entry entry : this.agro.entrySet()) {
                if (!(((Float)entry.getValue()).floatValue() > var9)) continue;
                var8 = (of)entry.getKey();
                var9 = ((Float)entry.getValue()).floatValue();
            }
        }
        this.targetEntity = var8;
        if (this.c.m() != this.targetEntity) {
            this.c.d(var8);
        }
    }

    private void removeUnsuitableTargets() {
        Iterator it2 = this.agro.entrySet().iterator();
        float distancesq = this.maxDistance * this.maxDistance;
        while (it2.hasNext()) {
            Map.Entry entry = it2.next();
            if (((Float)entry.getValue()).floatValue() != 0.0f && entry.getKey() != null && ((of)entry.getKey()).T() && !(this.c.e((nn)entry.getKey()) > (double)distancesq) && this.c.a(((of)entry.getKey()).getClass()) && entry.getKey() != this.c && ((of)entry.getKey()).ar == this.c.ar) continue;
            it2.remove();
        }
    }
}

