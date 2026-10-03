/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.item;

import java.util.ArrayList;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityHanging;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ugqi;

public class EntityPainting
extends EntityHanging {
    public ugqi field_70522_e;

    public EntityPainting(ozlu ozlu2) {
        super(ozlu2);
    }

    public EntityPainting(ozlu ozlu2, int n, int n2, int n3, int n4) {
        super(ozlu2, n, n2, n3, n4);
        ArrayList<ugqi> arrayList = new ArrayList<ugqi>();
        ugqi[] ugqiArray = ugqi.values();
        int n5 = ugqiArray.length;
        for (int i = 0; i < n5; ++i) {
            ugqi ugqi2;
            this.field_70522_e = ugqi2 = ugqiArray[i];
            this.func_82328_a(n4);
            if (!this.func_70518_d()) continue;
            arrayList.add(ugqi2);
        }
        if (!arrayList.isEmpty()) {
            this.field_70522_e = (ugqi)((Object)arrayList.get(this.field_70146_Z.nextInt(arrayList.size())));
        }
        this.func_82328_a(n4);
    }

    public EntityPainting(ozlu ozlu2, int n, int n2, int n3, int n4, String string) {
        this(ozlu2, n, n2, n3, n4);
        for (ugqi ugqi2 : ugqi.values()) {
            if (!ugqi2.__aK.equals(string)) continue;
            this.field_70522_e = ugqi2;
            break;
        }
        this.func_82328_a(n4);
    }

    @Override
    public void func_70014_b(qoac qoac2) {
        qoac2._a("Motive", this.field_70522_e.__aK);
        super.func_70014_b(qoac2);
    }

    @Override
    public void func_70037_a(qoac qoac2) {
        String string = qoac2._j("Motive");
        for (ugqi ugqi2 : ugqi.values()) {
            if (!ugqi2.__aK.equals(string)) continue;
            this.field_70522_e = ugqi2;
        }
        if (this.field_70522_e == null) {
            this.field_70522_e = ugqi._a;
        }
        super.func_70037_a(qoac2);
    }

    @Override
    public int func_82329_d() {
        return this.field_70522_e.__aL;
    }

    @Override
    public int func_82330_g() {
        return this.field_70522_e.__aM;
    }

    @Override
    public void func_110128_b(Entity entity) {
        if (entity instanceof EntityPlayer) {
            EntityPlayer entityPlayer = (EntityPlayer)entity;
            if (entityPlayer.field_71075_bZ._d) {
                return;
            }
        }
        this.func_70099_a(new cvzo(tgdv.field_77780_as), 0.0f);
    }
}

