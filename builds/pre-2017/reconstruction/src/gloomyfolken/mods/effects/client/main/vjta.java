/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.effects.client.main;

import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;
import gloomyfolken.mods.effects.client.main.eidj;
import java.util.EnumSet;
import net.minecraft.client.Minecraft;
import org.lwjgl.input.Keyboard;

public class vjta
implements ITickHandler {
    Minecraft _a = Minecraft._E();
    public static boolean _b = false;
    private boolean _c = false;
    private EnumSet<TickType> _d = EnumSet.of(TickType.CLIENT, TickType.RENDER);

    @Override
    public void tickStart(EnumSet<TickType> enumSet, Object ... objectArray) {
        if (enumSet.contains((Object)TickType.CLIENT)) {
            if (Keyboard.isKeyDown(82) && Keyboard.isKeyDown(54) && !this._c && this._a._t != null && this._a._t.capabilities._d) {
                _b = !_b;
            }
            boolean bl = this._c = Keyboard.isKeyDown(82) && Keyboard.isKeyDown(54);
        }
        if (enumSet.contains((Object)TickType.RENDER) && eidj._a != null) {
            eidj._a._a();
        }
    }

    @Override
    public void tickEnd(EnumSet<TickType> enumSet, Object ... objectArray) {
        if (enumSet.contains((Object)TickType.CLIENT) && !this._a._y) {
            eidj._a._f();
        }
        if (enumSet.contains((Object)TickType.RENDER) && eidj._a != null) {
            eidj._a._b();
        }
    }

    @Override
    public EnumSet<TickType> ticks() {
        return this._d;
    }

    @Override
    public String getLabel() {
        return "Effects Ticker";
    }
}

