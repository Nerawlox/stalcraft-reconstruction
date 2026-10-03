/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.client.gui.engine.component;

import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.IAdvancedGui;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.component.McGuiEntity;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.xpzm;
import net.minecraft.util.hanr;
import net.minecraft.util.kjwj;

public class McGuiPlayer
extends McGuiEntity<EntityPlayerSP> {
    public McGuiPlayer(IAdvancedGui iAdvancedGui, int n, int n2, int n3, int n4, float f) {
        this(iAdvancedGui, new Point(n, n2), new Dimension(n3, n4), f);
    }

    public McGuiPlayer(IAdvancedGui iAdvancedGui, Point point, Dimension dimension, float f) {
        super(iAdvancedGui, point, dimension, f);
        this.entity = this.createFakePlayer();
    }

    private EntityPlayerSP createFakePlayer() {
        xpzm xpzm2 = xpzm._E();
        EntityPlayerSP entityPlayerSP = new EntityPlayerSP(xpzm2, xpzm2._r, new hanr("Fake", ""), 0);
        entityPlayerSP.field_71158_b = new kjwj();
        return entityPlayerSP;
    }

    public void setPreviewItem(int n, cvzo cvzo2) {
        ((EntityPlayerSP)this.entity).field_71071_by.func_70299_a(n, cvzo2);
    }

    public void clearPreviewItems() {
        ((EntityPlayerSP)this.entity).field_71071_by._b(-1, -1);
    }
}

