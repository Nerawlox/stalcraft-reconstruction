/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.entity;

import net.minecraft.entity.EntityLiving;

public abstract class EntityImmovableLiving
extends EntityLiving {
    public EntityImmovableLiving(ozlu ozlu2) {
        super(ozlu2);
    }

    @Override
    protected void func_70679_bo() {
    }

    @Override
    protected void func_85033_bc() {
    }

    @Override
    public boolean func_70058_J() {
        return false;
    }

    @Override
    public boolean func_70072_I() {
        return false;
    }

    @Override
    public boolean func_70104_M() {
        return false;
    }

    @Override
    protected boolean func_70610_aX() {
        return true;
    }

    @Override
    protected boolean func_70041_e_() {
        return false;
    }

    @Override
    public boolean func_85032_ar() {
        return true;
    }

    @Override
    protected void func_82164_bB() {
    }

    @Override
    protected boolean func_70650_aV() {
        return false;
    }

    public void fallDown() {
        super.func_70612_e(0.0f, 0.0f);
    }

    @Override
    public void func_70612_e(float f, float f2) {
    }
}

