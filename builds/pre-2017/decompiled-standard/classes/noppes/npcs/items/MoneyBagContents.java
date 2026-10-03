/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.items;

import net.minecraft.entity.player.EntityPlayer;

public class MoneyBagContents {
    private EntityPlayer player;
    private int[] coinData = new int[]{0, 0, 0, 0, 0, 0, 0};

    public MoneyBagContents(EntityPlayer entityPlayer) {
        this.player = entityPlayer;
    }

    public void readNBT(qoac qoac2) {
        this.coinData = qoac2._l("coins");
    }

    public qoac writeNBT() {
        qoac qoac2 = new qoac();
        qoac2._a("coins", this.coinData);
        return qoac2;
    }

    public void AddCurrency(CoinType coinType, byte by, cvzo cvzo2) {
        int n = coinType.ordinal();
        this.coinData[n] = this.coinData[n] + by;
        cvzo2._e._a("contents", this.writeNBT());
    }

    public void WithdrawCurrencyByVal(CoinType coinType, short s, cvzo cvzo2) {
        int n = 0;
        int n2 = coinType.ordinal();
        this.coinData[n2] = this.coinData[n2] - n;
        cvzo2._e._a("contents", this.writeNBT());
    }

    public void WithdrawCurrencyByStack(CoinType coinType, byte by, cvzo cvzo2) {
        int n = 0;
        int n2 = coinType.ordinal();
        this.coinData[n2] = this.coinData[n2] - n;
        cvzo2._e._a("contents", this.writeNBT());
    }

    public static enum CoinType {
        WOOD("WOOD", 0),
        STONE("STONE", 1),
        IRON("IRON", 2),
        GOLD("GOLD", 3),
        DIAMOND("DIAMOND", 4),
        BRONZE("BRONZE", 5),
        EMERALD("EMERALD", 6);

        private static final CoinType[] $VALUES;

        private CoinType(String string2, int n2) {
        }

        static {
            $VALUES = new CoinType[]{WOOD, STONE, IRON, GOLD, DIAMOND, BRONZE, EMERALD};
        }
    }
}

