/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.roles;

import gloomyfolken.bundle.common.core.InvokeSideOnly;
import java.util.List;
import net.minecraft.client.xpzm;
import net.minecraft.entity.player.EntityPlayer;
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
            this.mainhand = new cvzo(CustomItems.banjo);
            this.overrideOffHand = true;
            this.overrideMainHand = true;
        }
    }

    @Override
    public void writeEntityToNBT(qoac qoac2) {
        qoac2._a("BardSong", this.song);
        qoac2._a("BardMinRange", this.minRange);
        qoac2._a("BardMaxRange", this.maxRange);
        qoac2._a("BardInstrument", this.instrument.ordinal());
        qoac2._a("BardStreamer", this.isStreamer);
    }

    @Override
    public void readEntityFromNBT(qoac qoac2) {
        this.song = qoac2._j("BardSong");
        this.minRange = qoac2._f("BardMinRange");
        this.maxRange = qoac2._f("BardMaxRange");
        this.setInstrument(qoac2._f("BardInstrument"));
        this.isStreamer = qoac2._o("BardStreamer");
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
                    this.mainhand = new cvzo(CustomItems.banjo);
                    this.offhand = null;
                    break;
                }
                case 3: {
                    this.mainhand = new cvzo(CustomItems.violin);
                    this.offhand = new cvzo(CustomItems.violinbow);
                    break;
                }
                case 4: {
                    this.mainhand = new cvzo(CustomItems.guitar);
                    this.offhand = null;
                    break;
                }
                case 5: {
                    this.mainhand = new cvzo(CustomItems.harp);
                    this.offhand = null;
                }
            }
        }
    }

    public void onLivingUpdate() {
        InvokeSideOnly.client(this.npc.field_70170_p.field_72995_K, () -> {
            ++this.ticks;
            if (this.ticks % 10L == 0L && !this.song.isEmpty()) {
                boolean bl = MusicController.Instance.isStreaming();
                if (bl && this.song.equals(MusicController.Instance.playing)) {
                    List list2;
                    if (this.isStreamer && !(list2 = this.npc.field_70170_p.func_72872_a(EntityPlayer.class, this.npc.field_70121_D._b(this.maxRange, this.maxRange / 2, this.maxRange))).contains(xpzm._E()._t)) {
                        MusicController.Instance.stopMusic();
                    }
                } else {
                    List list3 = this.npc.field_70170_p.func_72872_a(EntityPlayer.class, this.npc.field_70121_D._b(this.minRange, this.minRange / 2, this.minRange));
                    if (!list3.contains(xpzm._E()._t)) {
                        return;
                    }
                    if (this.isStreamer) {
                        MusicController.Instance.playStreaming(this.song, (float)this.npc.field_70165_t, (float)this.npc.field_70163_u, (float)this.npc.field_70161_v);
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
        InvokeSideOnly.client(this.npc.field_70170_p.field_72995_K, () -> {
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

