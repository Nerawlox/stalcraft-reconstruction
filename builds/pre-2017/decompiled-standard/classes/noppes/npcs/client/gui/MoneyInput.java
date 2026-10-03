/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui;

import gloomyfolken.mods.money.zwat;
import net.minecraft.entity.player.EntityPlayer;

public class MoneyInput
extends ifms {
    public long maxValue = Long.MAX_VALUE;
    public boolean playerMoneyIsMax = false;
    private EntityPlayer player;

    public MoneyInput(qncw qncw2, int n, int n2, int n3, int n4, EntityPlayer entityPlayer) {
        super(qncw2, n, n2, n3, n4);
        this.player = entityPlayer;
    }

    @Override
    public boolean func_73802_a(char c, int n) {
        boolean bl = super.func_73802_a(c, n);
        if (bl) {
            int n2 = this.func_73799_h();
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < this.func_73781_b().length(); ++i) {
                if (!Character.isDigit(this.func_73781_b().charAt(i))) continue;
                stringBuffer.append(this.func_73781_b().charAt(i));
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
                this.func_73782_a(String.valueOf(l2));
                this.func_73791_e(n2);
            }
            catch (Exception exception) {
                this.func_73782_a("0");
                long l = 0L;
            }
        }
        return bl;
    }

    public long getSum() {
        try {
            return Long.parseLong(this.func_73781_b());
        }
        catch (Exception exception) {
            this.func_73782_a("0");
            return 0L;
        }
    }

    public void setSum(long l) {
        this.func_73782_a(String.valueOf(l));
    }
}

