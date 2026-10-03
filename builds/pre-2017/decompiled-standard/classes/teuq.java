/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.GuiHelper;
import gloomyfolken.mods.core.client.gui.engine.IActionHandler;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.action.GuiAction;
import gloomyfolken.mods.core.client.gui.engine.action.GuiActionButtonClick;
import gloomyfolken.mods.core.client.gui.screens.GuiItem;
import gloomyfolken.mods.effects.client.main.eidj;
import gloomyfolken.mods.effects.client.main.zwaw;
import gloomyfolken.mods.effects.client.mcsa.ezfa;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.imageio.ImageIO;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.xpzm;
import net.minecraft.entity.item.EntityItem;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.opengl.GL11;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0012B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0014R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2={"Lgloomyfolken/mods/stalker/misc/client/GuiArtefakt;", "Lgloomyfolken/mods/core/client/gui/screens/GuiItem;", "parentScreen", "Lnet/minecraft/client/gui/GuiScreen;", "stack", "Lnet/minecraft/item/ItemStack;", "renderer", "Lgloomyfolken/mods/core/client/render/RenderSimpleCustomItem;", "(Lnet/minecraft/client/gui/GuiScreen;Lnet/minecraft/item/ItemStack;Lgloomyfolken/mods/core/client/render/RenderSimpleCustomItem;)V", "artefaktPreviewConfig", "Lgloomyfolken/mods/core/client/render/ItemPreviewConfig;", "artefaktRenderer", "guiArtefakt", "Lgloomyfolken/mods/stalker/misc/client/GuiArtefakt$McGuiArtefakt;", "initGui", "", "initGuiItem", "Lgloomyfolken/mods/core/client/gui/screens/GuiItem$McGuiItem;", "McGuiArtefakt", "minecraft"})
public final class teuq
extends GuiItem {
    private kjui _a;
    private final anoq _b;
    private final uhib _c;

    @Override
    public void func_73866_w_() {
        super.func_73866_w_();
        if (xpzm._E()._t.field_71075_bZ._d) {
            GuiHelper.addButton(this, new Point(this.screenWidth - 200, this.screenHeight - 60), new Dimension(180, 40), "\u0421\u0434\u0435\u043b\u0430\u0442\u044c \u0441\u043a\u0440\u0438\u043d\u0448\u043e\u0442").onClick(new IActionHandler<GuiActionButtonClick>(){

                @Override
                public /* synthetic */ void processAction(GuiAction guiAction) {
                    this._a((GuiActionButtonClick)guiAction);
                }

                public final void _a(GuiActionButtonClick guiActionButtonClick) {
                    teuq._c(this)._a();
                }
            });
        }
    }

    @Override
    @NotNull
    protected GuiItem.McGuiItem initGuiItem() {
        cvzo cvzo2 = this.stack;
        Intrinsics.checkExpressionValueIsNotNull(cvzo2, "stack");
        kjui kjui2 = this._a = new kjui(this, cvzo2);
        if (kjui2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guiArtefakt");
        }
        return kjui2;
    }

    public teuq(@NotNull gqjz gqjz2, @NotNull cvzo cvzo2, @NotNull anoq anoq2) {
        Intrinsics.checkParameterIsNotNull(gqjz2, "parentScreen");
        Intrinsics.checkParameterIsNotNull(cvzo2, "stack");
        Intrinsics.checkParameterIsNotNull(anoq2, "renderer");
        super(gqjz2, cvzo2, anoq2);
        this._b = anoq2;
        this.previewConfig = new uhib(anoq2._c);
        this.previewConfig._b += 0.175f;
        uhib uhib2 = this.previewConfig;
        Intrinsics.checkExpressionValueIsNotNull(uhib2, "previewConfig");
        this._c = uhib2;
    }

    public static final /* synthetic */ xpzm _a() {
        return GuiItem.mc;
    }

    @NotNull
    public static final /* synthetic */ kjui _c(teuq teuq2) {
        kjui kjui2 = teuq2._a;
        if (kjui2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guiArtefakt");
        }
        return kjui2;
    }

    public static final /* synthetic */ void _a(teuq teuq2, @NotNull kjui kjui2) {
        teuq2._a = kjui2;
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u001a\u0010\u0018\u001a\u00020\u00192\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001a\u001a\u00020\u001bH\u0014J\u0006\u0010\u0017\u001a\u00020\u0019J\b\u0010\u001c\u001a\u00020\u0019H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0014R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2={"Lgloomyfolken/mods/stalker/misc/client/GuiArtefakt$McGuiArtefakt;", "Lgloomyfolken/mods/core/client/gui/screens/GuiItem$McGuiItem;", "guiArtefakt", "Lgloomyfolken/mods/stalker/misc/client/GuiArtefakt;", "stack", "Lnet/minecraft/item/ItemStack;", "(Lgloomyfolken/mods/stalker/misc/client/GuiArtefakt;Lnet/minecraft/item/ItemStack;)V", "animate", "", "artefaktItem", "Lnet/minecraft/entity/item/EntityItem;", "effectSystem", "Lgloomyfolken/mods/stalker/misc/client/particle/artefacts/ArtefaktEffectSystem;", "getGuiArtefakt", "()Lgloomyfolken/mods/stalker/misc/client/GuiArtefakt;", "itemAnimationHandler", "Lgloomyfolken/mods/core/client/render/EntityItemAnimationHandler;", "renderPasses", "", "", "[Ljava/lang/Integer;", "screenBuffer", "Ljava/nio/IntBuffer;", "takeScreenshot", "drawModel", "", "frame", "", "tick", "minecraft"})
    private static final class kjui
    extends GuiItem.McGuiItem {
        private final EntityItem _a;
        private oxkw _b;
        private final Integer[] _c;
        private final xqrn _d;
        private final boolean _e;
        private boolean _f;
        private IntBuffer _g;
        @NotNull
        private final teuq _h;

        public final void _a() {
            this._f = true;
        }

        @Override
        public void tick() {
            Object object;
            super.tick();
            if (this._e) {
                xqrn xqrn2 = this._d;
                if (xqrn2 != null) {
                    xqrn2._a();
                }
            }
            oxkw oxkw2 = this._b;
            if (oxkw2 != null) {
                oxkw2.tick();
            }
            if ((object = this._b) != null && (object = ((oxkw)object)._b()) != null) {
                Iterable iterable = (Iterable)object;
                for (Object t : iterable) {
                    cuib cuib2 = (cuib)t;
                    cuib2.tick();
                }
            }
        }

        @Override
        protected void drawModel(@Nullable cvzo cvzo2, float f) {
            int n;
            Object object;
            Iterable iterable;
            ivtm ivtm2;
            ogej ogej2;
            if (cvzo2 == null) {
                return;
            }
            boolean bl = this._b != null;
            xqrn xqrn2 = xqrn._a(this._a);
            ogej ogej3 = ogej2 = xqrn2 != null ? xqrn2._b : null;
            ivtm ivtm3 = ogej3 != null ? ogej3._a(this._e ? f : 0.0f) : (ivtm2 = null);
            if (this._f) {
                GL11.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
                GL11.glClear(16384);
            }
            ((teuq)this._h)._b._e((cvzo)cvzo2)._c.renderOnly(anoq._n, ivtm2);
            ezfa._a._a();
            eidj._a._c._a(true);
            ((teuq)this._h)._b._e((cvzo)cvzo2)._c.renderOnly(anoq._p, ivtm2);
            ezfa._a._a();
            eidj._a._c._a(!bl, !bl);
            Object object2 = this._b;
            if (object2 == null || (object2 = ((oxkw)object2)._b()) == null) {
                return;
            }
            Object object4 = object2;
            GL11.glPushMatrix();
            float f2 = jywc._a(this.prevZoom, this.zoom, f);
            float f3 = 1.0f / (3.6f * f2);
            GL11.glScalef(f3, f3, f3);
            eidj._a._c();
            Object[] objectArray = (Object[])object4;
            for (Object object22 : objectArray) {
                cuib cuib2 = (cuib)object22;
                cuib2.loadTransformMatrix();
                iterable = cuib2.particles;
                for (Object t : iterable) {
                    object = (ncyh)t;
                    cuib2.updateParticleRenderPosDefault((ncyh)object, f);
                    ((ncyh)object).distanceSq += 4.15f * f3;
                }
            }
            GL11.glPopMatrix();
            objectArray = this._c;
            for (n = 0; n < objectArray.length; ++n) {
                Object object3 = objectArray[n];
                int n2 = ((Number)object3).intValue();
                if (n2 == 2) {
                    eidj._a._c._a(false);
                }
                iterable = (Iterable)object4;
                for (Object t : iterable) {
                    object = (cuib)t;
                    Iterable iterable2 = ((tvlv)object).particles;
                    ejaq ejaq2 = eidj._a._b;
                    Iterable iterable3 = iterable2;
                    Collection collection = new ArrayList();
                    for (Object t2 : iterable3) {
                        ncyh ncyh2 = (ncyh)t2;
                        if (!ncyh2.shouldRenderInPass(n2)) continue;
                        collection.add(t2);
                    }
                    List list = (List)collection;
                    ejaq2._a(list, n2, f);
                }
                if (n2 != 2) continue;
                eidj._a._c._a(true, true);
            }
            if (this._f) {
                int n3 = zwaw._b();
                n = zwaw._d();
                this._f = false;
                this._g = ByteBuffer.allocateDirect(n3 * n * 4).order(ByteOrder.nativeOrder()).asIntBuffer();
                zwaw._a(16384, true);
                GL11.glReadBuffer(36064);
                GL11.glReadPixels(0, 0, n3, n, 32993, 33639, this._g);
                File file = new File("artifact_preview.png");
                BufferedImage bufferedImage = new BufferedImage(n3, n, 2);
                int n4 = 0;
                int n5 = n3 - 1;
                if (n4 <= n5) {
                    while (true) {
                        int n6;
                        int n7;
                        if ((n7 = 0) <= (n6 = n - 1)) {
                            while (true) {
                                IntBuffer intBuffer = this._g;
                                if (intBuffer == null) {
                                    Intrinsics.throwNpe();
                                }
                                bufferedImage.setRGB(n4, n7, intBuffer.get((n - n7 - 1) * n3 + n4));
                                if (n7 == n6) break;
                                ++n7;
                            }
                        }
                        if (n4 == n5) break;
                        ++n4;
                    }
                }
                ImageIO.write((RenderedImage)bufferedImage, "png", file);
            }
        }

        @NotNull
        public final teuq _b() {
            return this._h;
        }

        public kjui(@NotNull teuq teuq2, @NotNull cvzo cvzo2) {
            Intrinsics.checkParameterIsNotNull(teuq2, "guiArtefakt");
            Intrinsics.checkParameterIsNotNull(cvzo2, "stack");
            super(teuq2, new Point(0, 0), new Dimension(teuq._a()._n, teuq._a()._o));
            this._h = teuq2;
            Object object = new Integer[]{0, 2};
            kjui kjui2 = this;
            Object[] objectArray = object;
            kjui2._c = (Integer[])objectArray;
            this._e = ((teuq)this._h)._c._g;
            object = xpzm._E();
            this._a = new EntityItem(object._r, 0.0, 0.1, 0.0, cvzo2);
            fmsn fmsn2 = new fmsn(this._a);
            zgiu zgiu2 = fmsn2._c();
            if (zgiu2 != null) {
                zgiu zgiu3;
                zgiu zgiu4 = zgiu3 = zgiu2;
                this._b = fmsn2._b(zgiu4);
            }
            this._d = xqrn._a(this._a);
        }
    }
}

