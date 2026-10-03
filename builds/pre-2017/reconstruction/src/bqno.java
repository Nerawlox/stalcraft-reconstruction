/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;
import cpw.mods.fml.relauncher.Side;
import java.util.EnumSet;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;

public class bqno
implements ITickHandler {
    private EnumSet<TickType> _a = EnumSet.of(TickType.CLIENT, TickType.RENDER, TickType.WORLD, TickType.PLAYER);

    @Override
    public void tickStart(EnumSet<TickType> enumSet, Object ... objectArray) {
        if (enumSet.contains((Object)TickType.RENDER)) {
            MinecraftForge.EVENT_BUS.post(new lnrm.ezey(lnrm.pidb._a, ((Float)objectArray[0]).floatValue()));
        }
        if (enumSet.contains((Object)TickType.CLIENT)) {
            MinecraftForge.EVENT_BUS.post(new lnrm.kjui(lnrm.pidb._a));
        }
        if (enumSet.contains((Object)TickType.WORLD)) {
            MinecraftForge.EVENT_BUS.post(new lnrm.zwaw(Side.CLIENT, lnrm.pidb._a, (World)objectArray[0]));
        }
        if (enumSet.contains((Object)TickType.PLAYER)) {
            MinecraftForge.EVENT_BUS.post(new lnrm.eidj(lnrm.pidb._a, (EntityPlayer)objectArray[0]));
        }
    }

    @Override
    public void tickEnd(EnumSet<TickType> enumSet, Object ... objectArray) {
        if (enumSet.contains((Object)TickType.RENDER)) {
            MinecraftForge.EVENT_BUS.post(new lnrm.ezey(lnrm.pidb._b, ((Float)objectArray[0]).floatValue()));
        }
        if (enumSet.contains((Object)TickType.CLIENT)) {
            MinecraftForge.EVENT_BUS.post(new lnrm.kjui(lnrm.pidb._b));
        }
        if (enumSet.contains((Object)TickType.WORLD)) {
            MinecraftForge.EVENT_BUS.post(new lnrm.zwaw(Side.CLIENT, lnrm.pidb._b, (World)objectArray[0]));
        }
        if (enumSet.contains((Object)TickType.PLAYER)) {
            MinecraftForge.EVENT_BUS.post(new lnrm.eidj(lnrm.pidb._b, (EntityPlayer)objectArray[0]));
        }
    }

    @Override
    public EnumSet<TickType> ticks() {
        return this._a;
    }

    @Override
    public String getLabel() {
        return "Gloomy Client Ticker";
    }
}

