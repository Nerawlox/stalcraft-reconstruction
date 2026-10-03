/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.client.gui.engine.component;

import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.IAdvancedGui;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.component.McGuiEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.item.ItemStack;
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
        Minecraft minecraft = Minecraft._E();
        EntityPlayerSP entityPlayerSP = new EntityPlayerSP(minecraft, minecraft._r, new hanr("Fake", ""), 0);
        entityPlayerSP.movementInput = new kjwj();
        return entityPlayerSP;
    }

    public void setPreviewItem(int n, ItemStack itemStack) {
        ((EntityPlayerSP)this.entity).inventory.setInventorySlotContents(n, itemStack);
    }

    public void clearPreviewItems() {
        ((EntityPlayerSP)this.entity).inventory._b(-1, -1);
    }
}

