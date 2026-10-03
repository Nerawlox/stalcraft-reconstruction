/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.common.registry.LanguageRegistry;
import gloomyfolken.mods.brushedit.eidj;
import gloomyfolken.mods.brushedit.pidb;
import net.minecraft.entity.player.EntityPlayer;

public class ctqc
extends tgdv {
    public ctqc(int n) {
        super(n - 256);
        this.func_77655_b("brush_maker");
        this.func_111206_d("stone_axe");
        this.func_77625_d(1);
        this.func_77664_n();
        LanguageRegistry.addName(this, "\u0421\u043e\u0437\u0434\u0430\u0442\u044c \u043a\u0438\u0441\u0442\u044c");
    }

    @Override
    public boolean onItemUseFirst(cvzo cvzo2, EntityPlayer entityPlayer, ozlu ozlu2, int n, int n2, int n3, int n4, float f, float f2, float f3) {
        if (!ozlu2.field_72995_K) {
            eidj eidj2;
            pidb pidb2 = pidb._a(entityPlayer);
            pidb2._c = eidj2 = new eidj(ozlu2, n, n2, n3);
            entityPlayer.func_71035_c("\u0422\u0435\u043f\u0435\u0440\u044c \u0438\u0441\u043f\u043e\u043b\u044c\u0437\u0443\u0439\u0442\u0435 \u043a\u043e\u043c\u0430\u043d\u0434\u0443 /newbrush <brush_name>");
            return true;
        }
        return false;
    }
}

