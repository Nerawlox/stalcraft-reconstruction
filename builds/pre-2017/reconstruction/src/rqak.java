/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.Icon;

public class rqak
extends nuuf {
    public Icon[] _a;

    public rqak(int n) {
        super(n);
    }

    @Override
    public Icon getIcon(int n, int n2) {
        if (n2 < 7) {
            if (n2 == 6) {
                n2 = 5;
            }
            return this._a[n2 >> 1];
        }
        return this._a[3];
    }

    @Override
    public int _a() {
        return Item.carrot.itemID;
    }

    @Override
    public int _b() {
        return Item.carrot.itemID;
    }

    @Override
    public void registerIcons(IconRegister iconRegister) {
        this._a = new Icon[4];
        for (int i = 0; i < this._a.length; ++i) {
            this._a[i] = iconRegister._b(this.getTextureName() + "_stage_" + i);
        }
    }
}

