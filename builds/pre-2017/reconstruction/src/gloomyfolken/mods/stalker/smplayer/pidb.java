/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.smplayer;

import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.stalker.smplayer.eidj;
import gloomyfolken.mods.stalker.smplayer.kjui;
import net.smart.render.ModelRotationRenderer;
import net.smart.render.SmartRenderModel;

@ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
public class pidb
extends kjui {
    public SmartRenderModel _b;

    public pidb(nuco nuco2, SmartRenderModel smartRenderModel) {
        super(nuco2);
        this._b = smartRenderModel;
    }

    protected ModelRotationRenderer _b(String string) {
        switch (string) {
            case "head": {
                return this._b.bipedHead;
            }
            case "neck": {
                return this._b.bipedNeck;
            }
            case "outer": {
                return this._b.bipedOuter;
            }
            case "torso": {
                return this._b.bipedTorso;
            }
            case "body": {
                return this._b.bipedBody;
            }
            case "breast": {
                return this._b.bipedBreast;
            }
            case "left_shoulder": {
                return this._b.bipedLeftShoulder;
            }
            case "right_shoulder": {
                return this._b.bipedRightShoulder;
            }
            case "left_arm": {
                return this._b.bipedLeftArm;
            }
            case "right_arm": {
                return this._b.bipedRightArm;
            }
            case "pelvic": {
                return this._b.bipedPelvic;
            }
            case "left_leg": {
                return this._b.bipedLeftLeg;
            }
            case "right_leg": {
                return this._b.bipedRightLeg;
            }
        }
        return null;
    }

    @Override
    protected /* synthetic */ eidj _a(String string) {
        return this._b(string);
    }
}

