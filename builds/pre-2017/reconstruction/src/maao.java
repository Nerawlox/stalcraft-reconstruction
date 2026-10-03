/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.common.FMLCommonHandler;
import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.effects.client.main.pidb;
import net.minecraft.tileentity.TileEntity;

public class maao
extends TileEntity {
    @ezey(_a={eidj.CLIENT})
    private loco _a;
    private boolean _b = true;

    @Override
    public void updateEntity() {
        if (this._b) {
            if (this.worldObj.isRemote) {
                InvokeSideOnly.client(() -> this._a());
            }
            this._b = false;
        }
    }

    @ezey(_a={eidj.CLIENT})
    private void _a() {
        this._a = new loco(this);
        pidb._a(this._a);
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    public void invalidate() {
        if (this._a != null) {
            this._a.isValid = false;
        }
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    public void onChunkUnload() {
        if (this._a != null) {
            this._a.isValid = false;
        }
    }

    @Override
    public boolean canUpdate() {
        return FMLCommonHandler.instance().getSide().isClient();
    }
}

