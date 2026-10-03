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
    public float onGround;
    public boolean isRiding;
    public List boxList = new ArrayList();
    public boolean isChild = true;
    public Map modelTextureMap = new HashMap();
    public int textureWidth = 64;
    public int textureHeight = 32;

    public void render(Entity entity, float f, float f2, float f3, float f4, float f5, float f6) {
    }

    public void setRotationAngles(float f, float f2, float f3, float f4, float f5, float f6, Entity entity) {
    }

    public void setLivingAnimations(EntityLivingBase entityLivingBase, float f, float f2, float f3) {
    }

    public ModelRenderer getRandomModelBox(Random random) {
        return (ModelRenderer)this.boxList.get(random.nextInt(this.boxList.size()));
    }

    public void setTextureOffset(String string, int n, int n2) {
        this.modelTextureMap.put(string, new TextureOffset(n, n2));
    }

    public TextureOffset getTextureOffset(String string) {
        return (TextureOffset)this.modelTextureMap.get(string);
    }
}

