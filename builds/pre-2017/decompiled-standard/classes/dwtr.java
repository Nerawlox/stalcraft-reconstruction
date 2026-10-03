/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.client.registry.KeyBindingRegistry;
import cpw.mods.fml.common.TickType;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import net.minecraft.client.settings.eidj;
import net.minecraft.client.xpzm;

public class dwtr
extends KeyBindingRegistry.KeyHandler {
    private EnumSet<TickType> _b = EnumSet.of(TickType.CLIENT);
    private HashMap<eidj, ofux> _c = new HashMap();
    public boolean _a = false;

    public dwtr(eidj[] eidjArray, boolean[] blArray, List<ofux> list2) {
        super(eidjArray, blArray);
        if (eidjArray.length != list2.size()) {
            throw new RuntimeException("The number of key bindings does not match the number of key handlers!");
        }
        for (int i = 0; i < eidjArray.length; ++i) {
            this._c.put(eidjArray[i], list2.get(i));
        }
    }

    @Override
    public String getLabel() {
        return "StalkerKey";
    }

    @Override
    public void keyDown(EnumSet<TickType> enumSet, eidj eidj2, boolean bl, boolean bl2) {
        ofux ofux2 = this._c.get(eidj2);
        if (ofux2 == null) {
            return;
        }
        if (!bl && this._a(ofux2)) {
            if (!bl2) {
                ofux2.onKeyDownRepeat();
            } else {
                ofux2.onKeyDown();
            }
        }
    }

    private boolean _a(ofux ofux2) {
        return !this._a && xpzm._E().__ab || ofux2.processOnGui();
    }

    @Override
    public void keyUp(EnumSet<TickType> enumSet, eidj eidj2, boolean bl) {
        ofux ofux2 = this._c.get(eidj2);
        if (ofux2 == null) {
            return;
        }
        if (!bl && this._a(ofux2)) {
            ofux2.onKeyUp();
        }
    }

    @Override
    public EnumSet<TickType> ticks() {
        return this._b;
    }
}

