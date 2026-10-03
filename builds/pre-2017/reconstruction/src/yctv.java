/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.inventory.IInventory;

public interface yctv<T extends zwyn> {
    public T _a(EntityLivingBase var1, IInventory ... var2);

    public T _a(ccxr var1);

    @ezey(_a={eidj.CLIENT})
    public GuiContainer _a(T var1);

    public int _a();

    public int _b();
}

