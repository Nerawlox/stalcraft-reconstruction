/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.roles;

import gloomyfolken.bundle.common.core.InvokeSideOnly;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import noppes.npcs.CustomItems;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.client.controllers.MusicController;
import noppes.npcs.constants.EnumBardInstrument;
import noppes.npcs.roles.JobInterface;

public class JobBard
extends JobInterface {
    public int minRange = 2;
    public int maxRange = 64;
    public boolean isStreamer = true;
    public String song = "";
    public String song2 = "";
    public String song3 = "";
    public String song4 = "";
    private EnumBardInstrument instrument = EnumBardInstrument.Banjo;
    private long ticks = 0L;

    public JobBard(EntityNPCInterface entityNPCInterface) {
        super(entityNPCInterface);
        if (CustomItems.banjo != null) {
            this.mainhand = new ItemStack(CustomItems.banjo);
            this.overrideOffHand = true;
            this.overrideMainHand = true;
        }
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nBTTagCompound) {
        nBTTagCompound._a("BardSong", this.song);
        nBTTagCompound._a("BardMinRange", this.minRange);
        nBTTagCompound._a("BardMaxRange", this.maxRange);
        nBTTagCompound._a("BardInstrument", this.instrument.ordinal());
        nBTTagCompound._a("BardStreamer", this.isStreamer);
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nBTTagCompound) {
        this.song = nBTTagCompound._j("BardSong");
        this.minRange = nBTTagCompound._f("BardMinRange");
        this.maxRange = nBTTagCompound._f("BardMaxRange");
        this.setInstrument(nBTTagCompound._f("BardInstrument"));
        this.isStreamer = nBTTagCompound._o("BardStreamer");
    }

    public EnumBardInstrument getInstrument() {
        return this.instrument;
    }

    public void setInstrument(int n) {
        if (CustomItems.banjo != null) {
            this.instrument = EnumBardInstrument.values()[n];
            this.overrideOffHand = this.instrument != EnumBardInstrument.None;
            this.overrideMainHand = this.overrideOffHand;
            switch (NamelessClass1216762099.$SwitchMap$noppes$npcs$constants$EnumBardInstrument[this.instrument.ordinal()]) {
                case 1: {
                    this.mainhand = null;
                    this.offhand = null;
                    break;
                }
                case 2: {
                    this.mainhand = new ItemStack(CustomItems.banjo);
                    this.offhand = null;
                    break;
                }
                case 3: {
                    this.mainhand = new ItemStack(CustomItems.violin);
                    this.offhand = new ItemStack(CustomItems.violinbow);
                    break;
                }
                case 4: {
                    this.mainhand = new ItemStack(CustomItems.guitar);
                    this.offhand = null;
                    break;
                }
                case 5: {
                    this.mainhand = new ItemStack(CustomItems.harp);
                    this.offhand = null;
                }
            }
        }
    }

    public void onLivingUpdate() {
        InvokeSideOnly.client(this.npc.worldObj.isRemote, () -> {
            ++this.ticks;
            if (this.ticks % 10L == 0L && !this.song.isEmpty()) {
                boolean bl = MusicController.Instance.isStreaming();
                if (bl && this.song.equals(MusicController.Instance.playing)) {
                    List list2;
                    if (this.isStreamer && !(list2 = this.npc.worldObj.getEntitiesWithinAABB(EntityPlayer.class, this.npc.boundingBox._b(this.maxRange, this.maxRange / 2, this.maxRange))).contains(Minecraft._E()._t)) {
                        MusicController.Instance.stopMusic();
                    }
                } else {
                    List list3 = this.npc.worldObj.getEntitiesWithinAABB(EntityPlayer.class, this.npc.boundingBox._b(this.minRange, this.minRange / 2, this.minRange));
                    if (!list3.contains(Minecraft._E()._t)) {
                        return;
                    }
                    if (this.isStreamer) {
                        MusicController.Instance.playStreaming(this.song, (float)this.npc.posX, (float)this.npc.posY, (float)this.npc.posZ);
                    } else {
                        MusicController.Instance.playMusic(this.song);
                    }
                }
            }
        });
    }

    @Override
    public void killed() {
        this.delete();
    }

    @Override
    public void delete() {
        InvokeSideOnly.client(this.npc.worldObj.isRemote, () -> {
            if (MusicController.Instance.isPlaying(this.song)) {
                MusicController.Instance.stopMusic();
            }
        });
    }

    static class NamelessClass1216762099 {
        static final int[] $SwitchMap$noppes$npcs$constants$EnumBardInstrument = new int[EnumBardInstrument.values().length];

        NamelessClass1216762099() {
        }

        static {
            try {
                NamelessClass1216762099.$SwitchMap$noppes$npcs$constants$EnumBardInstrument[EnumBardInstrument.None.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                NamelessClass1216762099.$SwitchMap$noppes$npcs$constants$EnumBardInstrument[EnumBardInstrument.Banjo.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                NamelessClass1216762099.$SwitchMap$noppes$npcs$constants$EnumBardInstrument[EnumBardInstrument.Violin.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                NamelessClass1216762099.$SwitchMap$noppes$npcs$constants$EnumBardInstrument[EnumBardInstrument.Guitar.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                NamelessClass1216762099.$SwitchMap$noppes$npcs$constants$EnumBardInstrument[EnumBardInstrument.Harp.ordinal()] = 5;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
        }
    }
}

