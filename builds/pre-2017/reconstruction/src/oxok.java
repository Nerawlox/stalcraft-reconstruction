/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.stalker.misc.tupg;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedRange;
import kotlin.ranges.IntRange;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=2, d1={"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u001a\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000e\u001a<\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u00052\b\b\u0002\u0010\u0019\u001a\u00020\u00012\b\b\u0002\u0010\u001a\u001a\u00020\u00012\b\b\u0002\u0010\u001b\u001a\u00020\u0001\u001a\b\u0010\u001c\u001a\u00020\u0014H\u0007\u001a\u0010\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0003\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082D\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D\u00a2\u0006\u0002\n\u0000\"\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\b\"\u0014\u0010\t\u001a\u00020\u0003X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u000e\u0010\f\u001a\u00020\u0003X\u0082D\u00a2\u0006\u0002\n\u0000\"\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0007X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u000f\"\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2={"DETECTOR_FULL_RANGE", "Lkotlin/ranges/IntRange;", "DETECTOR_R", "", "DETECTOR_RADIUS_FACTOR", "", "DETECTOR_RANGES", "", "[Lkotlin/ranges/IntRange;", "R", "getR", "()I", "UPDATE_TICKS", "accumulations", "Lgloomyfolken/mods/stalker/misc/sickness/SicknessAccumulation;", "[Lgloomyfolken/mods/stalker/misc/sickness/SicknessAccumulation;", "lastDetectorSoundTicks", "", "totalAccumulation", "scanSickness", "", "player", "Lnet/minecraft/entity/player/EntityPlayer;", "accumulation", "radiusFactor", "xRange", "yRange", "zRange", "tickDetectors", "updateAccumulation", "minecraft"})
public final class oxok {
    private static final int _a = 5;
    private static final int _b = 4;
    private static final int _c = 8;
    private static final float _d = 1.5f;
    private static final IntRange _e;
    private static final IntRange[] _f;
    private static final yulf[] _g;
    private static final yulf _h;
    private static final long[] _i;

    public static final int _a() {
        return _a;
    }

    public static final void _a(@NotNull EntityPlayer entityPlayer, @NotNull yulf yulf2) {
        Intrinsics.checkParameterIsNotNull(entityPlayer, "player");
        Intrinsics.checkParameterIsNotNull(yulf2, "accumulation");
        oxok._a(entityPlayer, yulf2, 1.0f, null, null, null, 56, null);
    }

    public static final void _a(@NotNull EntityPlayer entityPlayer, @NotNull yulf yulf2, float f, @NotNull IntRange intRange, @NotNull IntRange intRange2, @NotNull IntRange intRange3) {
        Intrinsics.checkParameterIsNotNull(entityPlayer, "player");
        Intrinsics.checkParameterIsNotNull(yulf2, "accumulation");
        Intrinsics.checkParameterIsNotNull(intRange, "xRange");
        Intrinsics.checkParameterIsNotNull(intRange2, "yRange");
        Intrinsics.checkParameterIsNotNull(intRange3, "zRange");
        yulf2._c();
        int n = (int)entityPlayer.posX;
        int n2 = (int)entityPlayer.posY;
        int n3 = (int)entityPlayer.posZ;
        IntRange intRange4 = dwlr._a(intRange, n);
        int n4 = intRange4.getFirst();
        int n5 = intRange4.getLast();
        if (n4 <= n5) {
            while (true) {
                int n6;
                IntRange intRange5 = dwlr._a(intRange2, n2);
                int n7 = intRange5.getFirst();
                if (n7 <= (n6 = intRange5.getLast())) {
                    while (true) {
                        int n8;
                        IntRange intRange6 = dwlr._a(intRange3, n3);
                        int n9 = intRange6.getFirst();
                        if (n9 <= (n8 = intRange6.getLast())) {
                            while (true) {
                                pjqv.pidb pidb2;
                                if ((pidb2 = pjqv._a._a(entityPlayer.worldObj.getBlockId(n4, n7, n9))) != null) {
                                    double d = (double)n4 + 0.5 - entityPlayer.posX;
                                    double d2 = (double)n7 - entityPlayer.posY;
                                    double d3 = (double)n9 + 0.5 - entityPlayer.posZ;
                                    float f2 = (float)Math.sqrt(d * d + d2 * d2 + d3 * d3);
                                    float f3 = pidb2._d() * f;
                                    float f4 = owkq._b(owkq._j(-Math.log10(owkq._r(f2 / f3))), 0.0f, 1.0f);
                                    yulf yulf3 = yulf2;
                                    klcb klcb2 = pidb2._a();
                                    yulf3._a(klcb2, yulf3._a(klcb2) + pidb2._c() * f4);
                                }
                                if (n9 == n8) break;
                                ++n9;
                            }
                        }
                        if (n7 == n6) break;
                        ++n7;
                    }
                }
                if (n4 == n5) break;
                ++n4;
            }
        }
    }

    public static /* synthetic */ void _a(EntityPlayer entityPlayer, yulf yulf2, float f, IntRange intRange, IntRange intRange2, IntRange intRange3, int n, Object object) {
        int n2;
        if ((n & 8) != 0) {
            n2 = -_a;
            intRange = new IntRange(n2, _a);
        }
        if ((n & 0x10) != 0) {
            n2 = -_a;
            intRange2 = new IntRange(n2, _a);
        }
        if ((n & 0x20) != 0) {
            n2 = -_a;
            intRange3 = new IntRange(n2, _a);
        }
        oxok._a(entityPlayer, yulf2, f, intRange, intRange2, intRange3);
    }

    @ezey(_a={eidj.CLIENT})
    public static final void _b() {
        int n;
        ItemStack[] itemStackArray;
        Minecraft minecraft = Minecraft._E();
        EntityClientPlayerMP entityClientPlayerMP = minecraft._t;
        if (entityClientPlayerMP == null) {
            return;
        }
        EntityClientPlayerMP entityClientPlayerMP2 = entityClientPlayerMP;
        Minecraft._E().__ah._a("detectors");
        oxok._a(entityClientPlayerMP2);
        Object object4 = klcb.values();
        for (int i = 0; i < ((klcb[])object4).length; ++i) {
            itemStackArray = object4[i];
            tupg._a((EntityPlayer)((EntityPlayer)entityClientPlayerMP2))._w[itemStackArray.ordinal()] = _h._a((klcb)itemStackArray);
        }
        ItemStack[] itemStackArray2 = tupg._a((EntityPlayer)((EntityPlayer)entityClientPlayerMP2))._c._d();
        Intrinsics.checkExpressionValueIsNotNull(itemStackArray2, "StalkerHandler.getHandler(player).stInv.detectors");
        itemStackArray = itemStackArray2;
        Object object2 = object4 = (Object[])itemStackArray;
        Collection collection = new ArrayList();
        Object object3 = object2;
        for (n = 0; n < ((klcb[])object3).length; ++n) {
            klcb klcb2;
            ItemStack itemStack;
            klcb klcb3;
            klcb klcb4 = klcb3 = object3[n];
            ItemStack itemStack2 = itemStack = (ItemStack)((Object)klcb4);
            Item item = itemStack2 != null ? itemStack2._a() : null;
            if (!(item instanceof bafi)) {
                item = null;
            }
            bafi bafi2 = (bafi)item;
            klcb klcb5 = bafi2 != null ? bafi2._a : null;
            if (klcb5 == null) continue;
            klcb klcb6 = klcb2 = klcb5;
            collection.add(klcb6);
        }
        List list2 = (List)collection;
        for (Object object4 : list2) {
            int n2;
            float f;
            float f2 = _h._a((klcb)((Object)object4));
            if (uzav._a._a((klcb)((Object)object4))._a(f2) == null) {
                continue;
            }
            n = (int)(ntte._b - _i[((Enum)object4).ordinal()]);
            if (n < ((uzav.pidb)object3)._b().getStart() || !((f = owkq._n(dwlr._c(new IntRange(n2 = ((uzav.pidb)object3)._b().getStart().intValue(), n))) / (float)dwlr._c(((uzav.pidb)object3)._b())) > entityClientPlayerMP2.getRNG().nextFloat())) continue;
            minecraft._N._a("stalker:" + (String)dwlr._a((Collection)((uzav.pidb)object3)._e()), owkq._a((ClosedRange<Float>)((uzav.pidb)object3)._c()), owkq._a((ClosedRange<Float>)((uzav.pidb)object3)._d()));
            oxok._i[((Enum)object4).ordinal()] = ntte._b;
        }
        Minecraft._E().__ah._b();
    }

    @ezey(_a={eidj.CLIENT})
    private static final void _a(EntityPlayer entityPlayer) {
        int n = (int)(ntte._b % (long)_b);
        IntRange intRange = _f[n];
        oxok._a(entityPlayer, _g[n], _d, _e, intRange, _e);
        _h._c();
        yulf[] yulfArray = _g;
        for (int i = 0; i < yulfArray.length; ++i) {
            yulf yulf2 = yulfArray[i];
            _h._a(yulf2);
        }
    }

    static {
        _a = 5;
        _b = 4;
        _c = 8;
        _d = 1.5f;
        int n = -_c;
        _e = new IntRange(n, _c);
        _f = dwlr._b(_e, _b);
        n = _b;
        yulf[] yulfArray = new yulf[n];
        int n2 = 0;
        int n3 = n - 1;
        if (n2 <= n3) {
            do {
                yulf yulf2;
                int n4 = ++n2;
                int n5 = n2;
                yulf[] yulfArray2 = yulfArray;
                yulfArray2[n5] = yulf2 = new yulf();
            } while (n2 != n3);
        }
        _g = yulfArray;
        _h = new yulf();
        _i = new long[((Object[])klcb._f._a()).length];
    }
}

