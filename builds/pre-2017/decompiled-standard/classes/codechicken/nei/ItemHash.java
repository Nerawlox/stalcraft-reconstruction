/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei;

public class ItemHash
implements Comparable<ItemHash> {
    public short item;
    public short damage;
    public qoac moreinfo;

    public ItemHash(int n, int n2, qoac qoac2) {
        this.item = (short)n;
        this.damage = (short)n2;
        this.moreinfo = qoac2;
    }

    public ItemHash(cvzo cvzo2) {
        this.item = (short)cvzo2._d;
        this.damage = (short)cvzo2._j();
        this.moreinfo = cvzo2._e;
    }

    public ItemHash(int n) {
        this(n, -1);
    }

    public ItemHash(int n, int n2) {
        this(n, n2, null);
    }

    public boolean equals(Object object) {
        if (object instanceof ItemHash) {
            ItemHash itemHash = (ItemHash)object;
            return itemHash.item == this.item && (itemHash.damage == this.damage || itemHash.damage == -1 || this.damage == -1) && (this.moreinfo == itemHash.moreinfo || this.moreinfo != null && this.moreinfo.equals(itemHash.moreinfo));
        }
        return false;
    }

    public int hashCode() {
        return this.item;
    }

    @Override
    public int compareTo(ItemHash itemHash) {
        if (itemHash.item != this.item) {
            return Integer.valueOf(this.item).compareTo(Integer.valueOf(itemHash.item));
        }
        if (itemHash.damage != this.damage) {
            return Integer.valueOf(this.damage).compareTo(Integer.valueOf(itemHash.damage));
        }
        return 0;
    }

    public cvzo toStack() {
        cvzo cvzo2 = new cvzo(this.item, 1, (int)this.damage);
        cvzo2._e = this.moreinfo;
        return cvzo2;
    }
}

