/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common.event;

import cpw.mods.fml.common.LoaderState;
import cpw.mods.fml.common.ModClassLoader;
import cpw.mods.fml.common.discovery.ASMDataTable;
import cpw.mods.fml.common.event.FMLStateEvent;

public class FMLConstructionEvent
extends FMLStateEvent {
    private ModClassLoader modClassLoader;
    private ASMDataTable asmData;

    public FMLConstructionEvent(Object ... objectArray) {
        super(new Object[0]);
        this.modClassLoader = (ModClassLoader)objectArray[0];
        this.asmData = (ASMDataTable)objectArray[1];
    }

    public ModClassLoader getModClassLoader() {
        return this.modClassLoader;
    }

    @Override
    public LoaderState.ModState getModState() {
        return LoaderState.ModState.CONSTRUCTED;
    }

    public ASMDataTable getASMHarvestedData() {
        return this.asmData;
    }
}

