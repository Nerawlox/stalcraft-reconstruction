/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei;

import codechicken.nei.NEIServerUtils;
import codechicken.nei.VisiblityData;
import codechicken.nei.api.INEIGuiHandler;
import codechicken.nei.api.TaggedInventoryArea;
import java.util.Arrays;
import java.util.List;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class GuiExtendedCreativeInv
extends zybc
implements INEIGuiHandler {
    public GuiExtendedCreativeInv(jjgc jjgc2) {
        super(jjgc2);
        this.field_74195_c = 198;
    }

    @Override
    protected void func_74185_a(float f, int n, int n2) {
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.field_73882_e._h._a(new ResourceLocation("nei:textures/gui/inv.png"));
        int n3 = this.field_74198_m;
        int n4 = this.field_74197_n - 4;
        this.func_73729_b(n3 - 23, n4, 0, 0, 199, 204);
    }

    @Override
    public VisiblityData modifyVisiblity(zybc zybc2, VisiblityData visiblityData) {
        return visiblityData;
    }

    @Override
    public int getItemSpawnSlot(zybc zybc2, cvzo cvzo2) {
        return NEIServerUtils.getSlotForStack(zybc2.field_74193_d, 0, 54, cvzo2);
    }

    @Override
    public List<TaggedInventoryArea> getInventoryAreas(zybc zybc2) {
        return Arrays.asList(new TaggedInventoryArea("ExtendedCreativeInv", 0, 54, this.field_74193_d));
    }

    @Override
    public boolean handleDragNDrop(zybc zybc2, int n, int n2, cvzo cvzo2, int n3) {
        return false;
    }

    @Override
    public boolean hideItemPanelSlot(zybc zybc2, int n, int n2, int n3, int n4) {
        return false;
    }
}

