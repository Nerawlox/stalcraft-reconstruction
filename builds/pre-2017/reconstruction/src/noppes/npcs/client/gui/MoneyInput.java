/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui;

import gloomyfolken.mods.money.zwat;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.entity.player.EntityPlayer;

public class MoneyInput
extends GuiTextField {
    public long maxValue = Long.MAX_VALUE;
    public boolean playerMoneyIsMax = false;
    private EntityPlayer player;

    public MoneyInput(FontRenderer fontRenderer, int n, int n2, int n3, int n4, EntityPlayer entityPlayer) {
        super(fontRenderer, n, n2, n3, n4);
        this.player = entityPlayer;
    }

    @Override
    public boolean textboxKeyTyped(char c, int n) {
        boolean bl = super.textboxKeyTyped(c, n);
        if (bl) {
            int n2 = this.getCursorPosition();
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < this.getText().length(); ++i) {
                if (!Character.isDigit(this.getText().charAt(i))) continue;
                stringBuffer.append(this.getText().charAt(i));
            }
            String string = stringBuffer.toString();
            if (string.isEmpty()) {
                string = "0";
            }
            try {
                long l;
                long l2 = Long.parseLong(string);
                if (l2 < 0L) {
                    l2 = 0L;
                }
                if (l2 > this.maxValue) {
                    l2 = this.maxValue;
                }
                if (this.playerMoneyIsMax && l2 > (l = zwat._a(this.player)._a())) {
                    l2 = l;
                }
                this.setText(String.valueOf(l2));
                this.setCursorPosition(n2);
            }
            catch (Exception exception) {
                this.setText("0");
                long l = 0L;
            }
        }
        return bl;
    }

    public long getSum() {
        try {
            return Long.parseLong(this.getText());
        }
        catch (Exception exception) {
            this.setText("0");
            return 0L;
        }
    }

    public void setSum(long l) {
        this.setText(String.valueOf(l));
    }
}

