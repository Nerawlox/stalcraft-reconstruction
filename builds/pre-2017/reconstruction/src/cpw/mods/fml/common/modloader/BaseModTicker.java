/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common.modloader;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;
import cpw.mods.fml.common.modloader.BaseModProxy;
import java.util.EnumSet;

public class BaseModTicker
implements ITickHandler {
    private BaseModProxy mod;
    private EnumSet<TickType> ticks;
    private boolean clockTickTrigger;
    private boolean sendGuiTicks;

    BaseModTicker(BaseModProxy baseModProxy, boolean bl) {
        this.mod = baseModProxy;
        this.ticks = EnumSet.of(TickType.WORLDLOAD);
        this.sendGuiTicks = bl;
    }

    BaseModTicker(EnumSet<TickType> enumSet, boolean bl) {
        this.ticks = enumSet;
        this.sendGuiTicks = bl;
    }

    @Override
    public void tickStart(EnumSet<TickType> enumSet, Object ... objectArray) {
        this.tickBaseMod(enumSet, false, objectArray);
    }

    @Override
    public void tickEnd(EnumSet<TickType> enumSet, Object ... objectArray) {
        this.tickBaseMod(enumSet, true, objectArray);
    }

    private void tickBaseMod(EnumSet<TickType> enumSet, boolean bl, Object ... objectArray) {
        if (FMLCommonHandler.instance().getSide().isClient() && (this.ticks.contains((Object)TickType.CLIENT) || this.ticks.contains((Object)TickType.WORLDLOAD))) {
            EnumSet<TickType> enumSet2 = EnumSet.copyOf(enumSet);
            if (bl && enumSet.contains((Object)TickType.CLIENT) || enumSet.contains((Object)TickType.WORLDLOAD)) {
                this.clockTickTrigger = true;
                enumSet2.remove((Object)TickType.CLIENT);
                enumSet2.remove((Object)TickType.WORLDLOAD);
            }
            if (bl && this.clockTickTrigger && enumSet.contains((Object)TickType.RENDER)) {
                this.clockTickTrigger = false;
                enumSet2.remove((Object)TickType.RENDER);
                enumSet2.add(TickType.CLIENT);
            }
            this.sendTick(enumSet2, bl, objectArray);
        } else {
            this.sendTick(enumSet, bl, objectArray);
        }
    }

    private void sendTick(EnumSet<TickType> enumSet, boolean bl, Object ... objectArray) {
        for (TickType tickType : enumSet) {
            if (!this.ticks.contains((Object)tickType)) continue;
            boolean bl2 = true;
            bl2 = this.sendGuiTicks ? this.mod.doTickInGUI(tickType, bl, objectArray) : this.mod.doTickInGame(tickType, bl, objectArray);
            if (bl2) continue;
            this.ticks.remove((Object)tickType);
            this.ticks.removeAll(tickType.partnerTicks());
        }
    }

    @Override
    public EnumSet<TickType> ticks() {
        return this.clockTickTrigger ? EnumSet.of(TickType.RENDER) : this.ticks;
    }

    @Override
    public String getLabel() {
        return this.mod.getClass().getSimpleName();
    }

    public void setMod(BaseModProxy baseModProxy) {
        this.mod = baseModProxy;
    }
}

