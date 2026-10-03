/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.entity;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.gomc;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.eidj;

public class kjui
extends gomc {
    private static final float _f = 2.5f;
    private static final float _g = 10.0f;
    private static final float _h = 0.95f;
    private static final float _i = 2.0f;
    public EntityLivingBase _a;
    Class _b;
    float _c;
    float _d;
    private int _j = 5;
    HashMap<EntityLivingBase, Float> _e = new HashMap();

    public kjui(EntityCreature entityCreature, float f, float f2) {
        this(entityCreature, EntityPlayer.class, f, f2);
    }

    public kjui(EntityCreature entityCreature, Class clazz, float f, float f2) {
        super(entityCreature, false, false);
        this._b = clazz;
        this._c = f;
        this._d = f2;
        this.func_75248_a(3);
    }

    @Override
    public boolean func_75250_a() {
        return true;
    }

    @Override
    public boolean func_75253_b() {
        return true;
    }

    @Override
    public void func_75251_c() {
        this._a = null;
        this._e.clear();
    }

    public void _a(EntityLivingBase entityLivingBase, float f) {
        if (this._e.containsKey(entityLivingBase)) {
            this._e.put(entityLivingBase, Float.valueOf(this._e.get(entityLivingBase).floatValue() + 10.0f * f));
        } else {
            this._e.put(entityLivingBase, Float.valueOf(10.0f * f));
        }
    }

    public void _b(EntityLivingBase entityLivingBase, float f) {
        if (this._e.containsKey(entityLivingBase)) {
            this._e.put(entityLivingBase, Float.valueOf(this._e.get(entityLivingBase).floatValue() + 2.0f * f));
        } else {
            this._e.put(entityLivingBase, Float.valueOf(2.0f * f));
        }
    }

    public void _c(EntityLivingBase entityLivingBase, float f) {
        if (this._e.containsKey(entityLivingBase)) {
            this._e.put(entityLivingBase, Float.valueOf(this._e.get(entityLivingBase).floatValue() + 2.0f * f));
        } else {
            this._e.put(entityLivingBase, Float.valueOf(2.0f * f));
        }
    }

    @Override
    public void func_75246_d() {
        Object object;
        this._a();
        if (--this._j <= 0) {
            float f = this._c * this._c;
            object = this.field_75299_d.field_70170_p.func_72872_a(this._b, eidj._a(this.field_75299_d.field_70165_t - (double)this._c, this.field_75299_d.field_70163_u - (double)this._c, this.field_75299_d.field_70161_v - (double)this._c, this.field_75299_d.field_70165_t + (double)this._c, this.field_75299_d.field_70163_u + (double)this._c, this.field_75299_d.field_70161_v + (double)this._c));
            Iterator iterator2 = object.iterator();
            while (iterator2.hasNext()) {
                EntityLivingBase entityLivingBase = (EntityLivingBase)iterator2.next();
                if (this.field_75299_d.func_70068_e(entityLivingBase) > (double)f) continue;
                if (this._e.containsKey(entityLivingBase)) {
                    this._e.put(entityLivingBase, Float.valueOf(this._e.get(entityLivingBase).floatValue() + 2.5f));
                    continue;
                }
                this._e.put(entityLivingBase, Float.valueOf(2.5f));
            }
            this._j = 5;
        }
        Iterator<Map.Entry<EntityLivingBase, Float>> iterator3 = this._e.entrySet().iterator();
        while (iterator3.hasNext()) {
            object = iterator3.next();
            object.setValue((Float)Float.valueOf(object.getValue().floatValue() * 0.95f));
            if (!(object.getValue().floatValue() <= 0.008f)) continue;
            iterator3.remove();
        }
        object = null;
        if (this._e.size() > 0) {
            float f = -1.0f;
            for (Map.Entry<EntityLivingBase, Float> entry : this._e.entrySet()) {
                if (!(entry.getValue().floatValue() > f)) continue;
                object = entry.getKey();
                f = entry.getValue().floatValue();
            }
        }
        this._a = object;
        if (this.field_75299_d.func_70638_az() != this._a) {
            this.field_75299_d.func_70624_b((EntityLivingBase)object);
        }
    }

    private void _a() {
        Iterator<Map.Entry<EntityLivingBase, Float>> iterator2 = this._e.entrySet().iterator();
        float f = this._d * this._d;
        while (iterator2.hasNext()) {
            Map.Entry<EntityLivingBase, Float> entry = iterator2.next();
            if (entry.getValue().floatValue() != 0.0f && entry.getKey() != null && entry.getKey().func_70089_S() && !(this.field_75299_d.func_70068_e(entry.getKey()) > (double)f) && this.field_75299_d.func_70686_a(entry.getKey().getClass()) && entry.getKey() != this.field_75299_d && entry.getKey().field_71093_bK == this.field_75299_d.field_71093_bK) continue;
            iterator2.remove();
        }
    }
}

