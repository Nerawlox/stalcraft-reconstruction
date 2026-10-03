/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.util;

import gloomyfolken.mods.asm.GloomyHooks;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.util.kjwj;

public class samo
extends kjwj {
    public GameSettings _e;

    public samo(GameSettings gameSettings) {
        this._e = gameSettings;
    }

    @Override
    public void _a() {
        this._a = 0.0f;
        this._b = 0.0f;
        if (this._e.keyBindForward._e) {
            this._b += 1.0f;
        }
        if (this._e.keyBindBack._e) {
            this._b -= 1.0f;
        }
        if (this._e.keyBindLeft._e) {
            this._a += 1.0f;
        }
        if (this._e.keyBindRight._e) {
            this._a -= 1.0f;
        }
        this._c = this._e.keyBindJump._e;
        this._d = this._e.keyBindSneak._e;
        if (this._d) {
            this._a = (float)((double)this._a * 0.3);
            this._b = (float)((double)this._b * 0.3);
        }
        GloomyHooks.updatePlayerMoveState(this);
    }
}

