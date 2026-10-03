/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.player;

import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.stalker.player.eidj;
import gloomyfolken.mods.stalker.player.jxsn;
import gloomyfolken.mods.stalker.player.zwat;
import net.minecraft.client.model.ModelBiped;

@ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
public class kjui
extends eidj {
    public final ModelBiped _a;
    private final jxsn _b;
    private final jxsn _c;
    private final jxsn _d;
    private final jxsn _e;
    private final jxsn _f;
    private final jxsn _g;

    public kjui(nuco nuco2, ModelBiped modelBiped) {
        super(nuco2);
        this._a = modelBiped;
        this._b = new jxsn(modelBiped.field_78116_c);
        this._c = new jxsn(modelBiped.field_78115_e);
        this._d = new jxsn(modelBiped.field_78113_g);
        this._e = new jxsn(modelBiped.field_78112_f);
        this._f = new jxsn(modelBiped.field_78124_i);
        this._g = new jxsn(modelBiped.field_78123_h);
    }

    @Override
    protected zwat getRenderer(String string) {
        switch (string) {
            case "head": {
                return this._b;
            }
            case "body": {
                return this._c;
            }
            case "left_arm": {
                return this._d;
            }
            case "right_arm": {
                return this._e;
            }
            case "left_leg": {
                return this._f;
            }
            case "right_leg": {
                return this._g;
            }
        }
        return null;
    }
}

