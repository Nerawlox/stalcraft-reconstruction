/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.client.gui.engine.component;

import gloomyfolken.mods.asm.Logger;
import gloomyfolken.mods.core.client.gui.engine.IAdvancedGui;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.component.GuiComponent;
import gloomyfolken.mods.core.client.gui.engine.component.McToolTip;
import java.util.ArrayList;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

public class McItemToolTip
extends McToolTip {
    public ItemStack stack;

    public McItemToolTip(IAdvancedGui iAdvancedGui, GuiComponent guiComponent, ItemStack itemStack) {
        super(iAdvancedGui, new ArrayList<String>(1), guiComponent);
        this.stack = itemStack;
    }

    @Override
    public void drawComponent(Point point, float f) {
        this.updateLines();
        super.drawComponent(point, f);
    }

    protected void updateLines() {
        this.lines.clear();
        if (this.stack == null) {
            return;
        }
        if (this.stack._a() != null) {
            this.lines.addAll(this.stack._a((EntityPlayer)Minecraft._E()._t, Minecraft._E()._M.advancedItemTooltips));
        } else {
            Logger.severe("Can not find item " + this.stack._d, new Object[0]);
        }
        for (int i = 0; i < this.lines.size(); ++i) {
            if (i == 0) {
                this.lines.set(i, "\u00a7" + Integer.toHexString(this.stack._w()._e) + this.lines.get(i));
                continue;
            }
            this.lines.set(i, (Object)((Object)EnumChatFormatting._h) + this.lines.get(i));
        }
    }
}

