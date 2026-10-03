/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.TextureOffset;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;

public abstract class ModelBase {
    public float field_78095_p;
    public boolean field_78093_q;
    public List field_78092_r = new ArrayList();
    public boolean field_78091_s = true;
    public Map field_78094_a = new HashMap();
    public int field_78090_t = 64;
    public int field_78089_u = 32;

    public void func_78088_a(Entity entity, float f, float f2, float f3, float f4, float f5, float f6) {
    }

    public void func_78087_a(float f, float f2, float f3, float f4, float f5, float f6, Entity entity) {
    }

    public void func_78086_a(EntityLivingBase entityLivingBase, float f, float f2, float f3) {
    }

    public ModelRenderer func_85181_a(Random random) {
        return (ModelRenderer)this.field_78092_r.get(random.nextInt(this.field_78092_r.size()));
    }

    public void func_78085_a(String string, int n, int n2) {
        this.field_78094_a.put(string, new TextureOffset(n, n2));
    }

    public TextureOffset func_78084_a(String string) {
        return (TextureOffset)this.field_78094_a.get(string);
    }
}

