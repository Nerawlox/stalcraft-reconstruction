/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  wh
 *  wp
 *  xj
 *  zl
 */
public enum aav {
    a,
    b,
    c,
    d,
    e,
    f,
    g,
    h,
    i;


    public boolean a(yc par1Item) {
        if (this == a) {
            return true;
        }
        if (par1Item instanceof wh) {
            if (this == b) {
                return true;
            }
            wh itemarmor = (wh)par1Item;
            return itemarmor.b == 0 ? this == f : (itemarmor.b == 2 ? this == d : (itemarmor.b == 1 ? this == e : (itemarmor.b == 3 ? this == c : false)));
        }
        return par1Item instanceof zl ? this == g : (par1Item instanceof xj ? this == h : (par1Item instanceof wp ? this == i : false));
    }
}

