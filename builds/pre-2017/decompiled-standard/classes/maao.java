/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.common.FMLCommonHandler;
import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.effects.client.main.pidb;

public class maao
extends hurg {
    @ezey(_a={eidj.CLIENT})
    private loco _a;
    private boolean _b = true;

    @Override
    public void func_70316_g() {
        if (this._b) {
            if (this.field_70331_k.field_72995_K) {
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
    public void func_70313_j() {
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

