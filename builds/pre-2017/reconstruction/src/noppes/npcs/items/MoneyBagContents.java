/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class MoneyBagContents {
    private EntityPlayer player;
    private int[] coinData = new int[]{0, 0, 0, 0, 0, 0, 0};

    public MoneyBagContents(EntityPlayer entityPlayer) {
        this.player = entityPlayer;
    }

    public void readNBT(NBTTagCompound nBTTagCompound) {
        this.coinData = nBTTagCompound._l("coins");
    }

    public NBTTagCompound writeNBT() {
        NBTTagCompound nBTTagCompound = new NBTTagCompound();
        nBTTagCompound._a("coins", this.coinData);
        return nBTTagCompound;
    }

    public void AddCurrency(CoinType coinType, byte by, ItemStack itemStack) {
        int n = coinType.ordinal();
        this.coinData[n] = this.coinData[n] + by;
        itemStack._e._a("contents", this.writeNBT());
    }

    public void WithdrawCurrencyByVal(CoinType coinType, short s, ItemStack itemStack) {
        int n = 0;
        int n2 = coinType.ordinal();
        this.coinData[n2] = this.coinData[n2] - n;
        itemStack._e._a("contents", this.writeNBT());
    }

    public void WithdrawCurrencyByStack(CoinType coinType, byte by, ItemStack itemStack) {
        int n = 0;
        int n2 = coinType.ordinal();
        this.coinData[n2] = this.coinData[n2] - n;
        itemStack._e._a("contents", this.writeNBT());
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

