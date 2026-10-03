/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.opengl.GL11
 */
package ru.stalcraft.client.models;

import org.lwjgl.opengl.GL11;
import ru.stalcraft.entity.EntityCorpse;

public class ModelCorpse
extends bbj {
    public float rotationFall;
    public float rotationRightHand;
    public float rotationLeftHand;

    public ModelCorpse(float par1, float par2, int par3, int par4) {
        super(par1, par2, par3, par4);
    }

    @Override
    public void a(nn par1Entity, float par2, float par3, float par4, float par5, float par6, float par7) {
        EntityCorpse corpse = (EntityCorpse)par1Entity;
        GL11.glPushMatrix();
        GL11.glTranslatef((float)0.0f, (float)1.35f, (float)0.0f);
        GL11.glRotatef((float)this.rotationFall, (float)1.0f, (float)0.0f, (float)0.0f);
        GL11.glTranslatef((float)0.0f, (float)-1.35f, (float)0.0f);
        if (corpse.isFallingFinished) {
            GL11.glTranslatef((float)0.0f, (float)0.9f, (float)0.0f);
        }
        super.a(par1Entity, par2, par3, par4, par5, par6, par7);
        GL11.glPopMatrix();
    }

    @Override
    public void a(float par1, float par2, float par3, float par4, float par5, float par6, nn par7Entity) {
        super.a(par1, par2, par3, par4, par5, par6, par7Entity);
        this.f.f = 0.0f;
        this.f.g = 0.0f;
        this.f.h = this.rotationRightHand / 180.0f * (float)Math.PI;
        this.g.f = 0.0f;
        this.g.g = 0.0f;
        this.g.h = this.rotationLeftHand / 180.0f * (float)Math.PI;
    }
}

