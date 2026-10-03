/*
 * Decompiled with CFR 0.152.
 */
package poersch.minecraft.util.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.util.EnumChatFormatting;
import poersch.minecraft.util.gui.GuiButton;
import poersch.minecraft.util.options.Option;

@SideOnly(value=Side.CLIENT)
public class GuiOptionButton
extends GuiButton {
    public String caption;
    protected String[] options;
    protected int value = 0;

    public GuiOptionButton(int n, int n2, int n3, String string, String[] stringArray, String string2) {
        this(n, n2, n3, 150, 20, string, stringArray, string2);
    }

    public GuiOptionButton(int n, int n2, int n3, int n4, int n5, String string, String[] stringArray, String string2) {
        super(n, n2, n3, n4, n5, string);
        this.caption = string;
        this.options = stringArray;
        this.setValue(string2);
    }

    public void setValue(String string) {
        this.value = Option.getAllowedInteger(string, this.options);
        this.displayString = this.caption + ": " + (Object)((Object)EnumChatFormatting._o) + this.getValue();
    }

    public String getValue() {
        return this.options[this.value];
    }

    @Override
    public boolean mousePressed(Minecraft minecraft, int n, int n2) {
        if (super.mousePressed(minecraft, n, n2)) {
            if (++this.value >= this.options.length) {
                this.value = 0;
            }
            this.displayString = this.caption + ": " + (Object)((Object)EnumChatFormatting._o) + this.getValue();
            return true;
        }
        return false;
    }
}

