/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.common.registry.LanguageRegistry;
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.core.main.GloomyCore;
import java.util.Random;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 %2\u00020\u0001:\u0002%&B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0003H\u0016J*\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0003H\u0016J\u001a\u0010\u0018\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0003H\u0017J\b\u0010\u001b\u001a\u00020\u0003H\u0017J\b\u0010\u001c\u001a\u00020\u0003H\u0016J\b\u0010\u001d\u001a\u00020\u000fH\u0016J\u0010\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0016R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u00a8\u0006'"}, d2={"Lgloomyfolken/mods/stalker/misc/sickness/BlockContamination;", "Lnet/minecraft/block/Block;", "blockID", "", "creativeIconName", "", "localizedName", "props", "Lgloomyfolken/mods/stalker/misc/sickness/BlockContamination$Props;", "(ILjava/lang/String;Ljava/lang/String;Lgloomyfolken/mods/stalker/misc/sickness/BlockContamination$Props;)V", "creativeIcon", "Lnet/minecraft/util/Icon;", "getProps", "()Lgloomyfolken/mods/stalker/misc/sickness/BlockContamination$Props;", "canRenderInPass", "", "pass", "getCollisionBoundingBoxFromPool", "Lnet/minecraft/util/AxisAlignedBB;", "world", "Lnet/minecraft/world/World;", "x", "y", "z", "getIcon", "side", "meta", "getRenderBlockPass", "getRenderType", "isOpaqueCube", "quantityDropped", "par1Random", "Ljava/util/Random;", "registerIcons", "", "par1IconRegister", "Lnet/minecraft/client/renderer/texture/IconRegister;", "Companion", "Props", "minecraft"})
public final class pjqv
extends Block {
    private Icon _b;
    private final String _c;
    @NotNull
    private final pidb _d;
    private static final pidb[] _e;
    public static final kjui _a;

    @Override
    public void registerIcons(@NotNull IconRegister iconRegister) {
        Intrinsics.checkParameterIsNotNull(iconRegister, "par1IconRegister");
        this.blockIcon = iconRegister._b("stalker:transparent");
        this._b = iconRegister._b("stalker:" + this._c);
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    @Nullable
    public Icon getIcon(int n, int n2) {
        EntityClientPlayerMP entityClientPlayerMP = Minecraft._E()._t;
        if (entityClientPlayerMP == null || !entityClientPlayerMP.capabilities._d) {
            return this.blockIcon;
        }
        return this._b;
    }

    @Override
    public int quantityDropped(@NotNull Random random) {
        Intrinsics.checkParameterIsNotNull(random, "par1Random");
        return 0;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    @Nullable
    public AxisAlignedBB getCollisionBoundingBoxFromPool(@NotNull World world, int n, int n2, int n3) {
        Intrinsics.checkParameterIsNotNull(world, "world");
        return null;
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    public int getRenderBlockPass() {
        return 1;
    }

    @Override
    public int getRenderType() {
        return GloomyCore.transparentsRenderType;
    }

    @Override
    public boolean canRenderInPass(int n) {
        return super.canRenderInPass(n) && this.getRenderType() != -1;
    }

    @NotNull
    public final pidb _a() {
        return this._d;
    }

    public pjqv(int n, @NotNull String string, @NotNull String string2, @NotNull pidb pidb2) {
        Intrinsics.checkParameterIsNotNull(string, "creativeIconName");
        Intrinsics.checkParameterIsNotNull(string2, "localizedName");
        Intrinsics.checkParameterIsNotNull(pidb2, "props");
        super(n, GloomyCore.fakeAir);
        this._c = string;
        this._d = pidb2;
        this.setUnlocalizedName("contamination" + n);
        LanguageRegistry.addName(this, string2);
        GloomyCore.instance.airBlocks.add(this.blockID);
        _a._a(n, this._d);
    }

    static {
        _a = new kjui(null);
        _e = new pidb[4096];
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0007R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0011"}, d2={"Lgloomyfolken/mods/stalker/misc/sickness/BlockContamination$Props;", "", "effectStrId", "", "effectPower", "", "effectRadius", "(Ljava/lang/String;FF)V", "effect", "Lgloomyfolken/mods/stalker/misc/sickness/SicknessType;", "getEffect", "()Lgloomyfolken/mods/stalker/misc/sickness/SicknessType;", "getEffectPower", "()F", "getEffectRadius", "getEffectStrId", "()Ljava/lang/String;", "minecraft"})
    public static final class pidb {
        @NotNull
        private final klcb _a;
        @NotNull
        private final String _b;
        private final float _c;
        private final float _d;

        @NotNull
        public final klcb _a() {
            return this._a;
        }

        @NotNull
        public final String _b() {
            return this._b;
        }

        public final float _c() {
            return this._c;
        }

        public final float _d() {
            return this._d;
        }

        public pidb(@NotNull String string, float f, float f2) {
            Intrinsics.checkParameterIsNotNull(string, "effectStrId");
            this._b = string;
            this._c = f;
            this._d = f2;
            this._a = klcb._f._a(this._b);
        }
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0005R\u001e\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u0082\u0004\u00a2\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u000f"}, d2={"Lgloomyfolken/mods/stalker/misc/sickness/BlockContamination$Companion;", "", "()V", "propsArray", "", "Lgloomyfolken/mods/stalker/misc/sickness/BlockContamination$Props;", "getPropsArray", "()[Lgloomyfolken/mods/stalker/misc/sickness/BlockContamination$Props;", "[Lgloomyfolken/mods/stalker/misc/sickness/BlockContamination$Props;", "getProps", "blockID", "", "registerContaminationBlock", "", "props", "minecraft"})
    public static final class kjui {
        private final pidb[] _a() {
            return _e;
        }

        public final void _a(int n, @NotNull pidb pidb2) {
            Intrinsics.checkParameterIsNotNull(pidb2, "props");
            this._a()[n] = pidb2;
        }

        @Nullable
        public final pidb _a(int n) {
            return this._a()[n];
        }

        private kjui() {
        }

        public /* synthetic */ kjui(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}

