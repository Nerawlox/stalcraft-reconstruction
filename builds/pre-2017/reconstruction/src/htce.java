/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import java.util.List;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.MinecraftForgeClient;

public class htce
extends dxwc
implements tfdj {
    private String _i;
    private String _j;
    public final boolean _h;

    public htce(int n, String string, String string2, List<String> list, String string3, String string4, boolean bl) {
        super(n, string, string2, list, dxwc.eidj._e);
        this._i = string3;
        this._j = string4;
        this._h = bl;
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    public void _c() {
        super._c();
        if (this._i != null) {
            MinecraftForgeClient.registerItemRenderer(this.itemID, new pjvd(this._i, this._j));
        }
    }

    @Override
    public boolean _j(ItemStack itemStack) {
        return this._h;
    }

    @Override
    public boolean _b() {
        return false;
    }

    @Override
    public boolean onEntitySwing(EntityLivingBase entityLivingBase, ItemStack itemStack) {
        return true;
    }
}

