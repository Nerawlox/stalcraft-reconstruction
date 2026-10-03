/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.anomaly.jxtc;
import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.GuiHelper;
import gloomyfolken.mods.core.client.gui.engine.GuiScreenAdvanced;
import gloomyfolken.mods.core.client.gui.engine.IActionHandler;
import gloomyfolken.mods.core.client.gui.engine.IAdvancedGui;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.action.GuiAction;
import gloomyfolken.mods.core.client.gui.engine.action.GuiActionButtonClick;
import gloomyfolken.mods.core.client.gui.engine.action.GuiActionCheckboxToggle;
import gloomyfolken.mods.core.client.gui.engine.action.GuiActionTextFieldChanged;
import gloomyfolken.mods.core.client.gui.engine.component.GuiComponent;
import gloomyfolken.mods.core.client.gui.engine.component.McCheckBox;
import gloomyfolken.mods.core.client.gui.engine.component.McLabel;
import gloomyfolken.mods.core.client.gui.engine.component.McNumberField;
import gloomyfolken.mods.core.client.gui.engine.component.McTextField;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\bJ7\u0010\u0014\u001a\u0002H\u0015\"\b\b\u0000\u0010\u0015*\u00020\u00162\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u0002H\u0015H\u0002\u00a2\u0006\u0002\u0010\u001aJ4\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u00052\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020 0\u001fH\u0002J<\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u00052\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020 0\u001fH\u0002J\b\u0010\"\u001a\u00020#H\u0002J\b\u0010$\u001a\u00020 H\u0016J\b\u0010%\u001a\u00020 H\u0002J\b\u0010&\u001a\u00020 H\u0016J\b\u0010'\u001a\u00020 H\u0002R\u000e\u0010\t\u001a\u00020\u0005X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011\u00a8\u0006("}, d2={"Lgloomyfolken/mods/anomaly/client/gui/GuiEditTeleport;", "Lgloomyfolken/mods/core/client/gui/engine/GuiScreenAdvanced;", "world", "Lnet/minecraft/world/World;", "x", "", "y", "z", "(Lnet/minecraft/world/World;III)V", "LABEL_OFFSET", "isBubbleSettings", "", "teleportSettings", "Lgloomyfolken/mods/anomaly/TeleportSettings;", "getWorld", "()Lnet/minecraft/world/World;", "getX", "()I", "getY", "getZ", "addGenericField", "T", "Lgloomyfolken/mods/core/client/gui/engine/component/GuiComponent;", "label", "", "component", "(IILjava/lang/String;Lgloomyfolken/mods/core/client/gui/engine/component/GuiComponent;)Lgloomyfolken/mods/core/client/gui/engine/component/GuiComponent;", "addNumberField", "Lgloomyfolken/mods/core/client/gui/engine/component/McNumberField;", "value", "updater", "Lkotlin/Function1;", "", "name", "getTile", "Lgloomyfolken/mods/anomaly/tile/TileEntityTeleport;", "initGui", "loadTileData", "onGuiClosed", "uploadTileData", "minecraft"})
public final class hayt
extends GuiScreenAdvanced {
    private final int _a = 150;
    private jxtc _b;
    private boolean _c;
    @NotNull
    private final World _d;
    private final int _e;
    private final int _f;
    private final int _g;

    @Override
    public void initGui() {
        super.initGui();
        Point point = new Point(this.screenWidth / 2, this.screenHeight / 2);
        GuiHelper.addBackground(this, point.x - 440, point.y - 240, 880, 480, true);
        this._f();
        int n = point.x - 200;
        int n2 = point.y - 190;
        int n3 = 0;
        McTextField mcTextField = (McTextField)this._a(n - 200, n2 + 30 * n3, "ID \u0443\u0441\u043b\u043e\u0432\u0438\u044f:", (GuiComponent)new McTextField(this, new Point(0, 0), new Dimension(100, 20), ""));
        Object object = this._b._c();
        if (object == null || (object = String.valueOf((Integer)object)) == null) {
            object = "";
        }
        mcTextField.setText((String)object);
        if (this._c) {
            McTextField object2 = (McTextField)this._a(n + 100, n2 + 30 * n3, "\u0420\u0430\u0434\u0438\u0443\u0441 \u0442\u0435\u043b\u0435\u043f\u043e\u0440\u0442\u0430:", (GuiComponent)new McTextField(this, new Point(0, 0), new Dimension(100, 20), ""));
            McCheckBox mcCheckBox = (McCheckBox)this._a(n + 300, n2 + 30 * n3, "", (GuiComponent)GuiHelper.createCheckBox(this, new Point(0, 0), "\u0412\u0438\u0434\u0438\u043c\u043e\u0441\u0442\u044c"));
            object2.setText(String.valueOf(this._b._b()));
            mcCheckBox.setActive(this._b._d());
            this.actionManager.registerActionHandler((GuiComponent)object2, GuiActionTextFieldChanged.class, new IActionHandler<GuiActionTextFieldChanged>(){

                @Override
                public /* synthetic */ void processAction(GuiAction guiAction) {
                    this._a((GuiActionTextFieldChanged)guiAction);
                }

                public final void _a(GuiActionTextFieldChanged guiActionTextFieldChanged) {
                    Double d = StringsKt.toDoubleOrNull(((McTextField)guiActionTextFieldChanged.component).getText());
                    _b._a(d != null ? d : 0.5);
                }
            });
            this.actionManager.registerActionHandler((GuiComponent)mcCheckBox, GuiActionCheckboxToggle.class, new IActionHandler<GuiActionCheckboxToggle>(){

                @Override
                public /* synthetic */ void processAction(GuiAction guiAction) {
                    this._a((GuiActionCheckboxToggle)guiAction);
                }

                public final void _a(GuiActionCheckboxToggle guiActionCheckboxToggle) {
                    _b._a(guiActionCheckboxToggle.newState);
                }
            });
        }
        GuiHelper.addButton(this, new Point(n + 490, n2 + 30 * ++n3), new Dimension(150, 30), "\u0414\u043e\u0431\u0430\u0432\u0438\u0442\u044c").onClick(new IActionHandler<GuiActionButtonClick>(){

            @Override
            public /* synthetic */ void processAction(GuiAction guiAction) {
                this._a((GuiActionButtonClick)guiAction);
            }

            public final void _a(GuiActionButtonClick guiActionButtonClick) {
                if (_b._a().size() < 10) {
                    _b._a().add(new jxtc.kjui(0, 0, 0, null, 0.0f, 31, null));
                    this.setWorldAndResolution(mc, width, height);
                }
            }
        });
        GuiHelper.addLabel((IAdvancedGui)this, "X", n - 200 + 25, n2 + 30 * n3);
        GuiHelper.addLabel((IAdvancedGui)this, "Y", n - 75 + 25, n2 + 30 * n3);
        GuiHelper.addLabel((IAdvancedGui)this, "Z", n + 50 + 25, n2 + 30 * n3);
        GuiHelper.addLabel((IAdvancedGui)this, "\u041b\u043e\u043a\u0430\u0446\u0438\u044f", n + 175 + 25, n2 + 30 * n3);
        GuiHelper.addLabel((IAdvancedGui)this, "\u0412\u0435\u0441", n + 375, n2 + 30 * n3);
        ++n3;
        for (final jxtc.kjui kjui2 : this._b._a()) {
            IAdvancedGui iAdvancedGui = this;
            Point point2 = new Point(n + 175, n2 + 30 * n3);
            Dimension dimension = new Dimension(150, 30);
            String string = kjui2._d();
            if (string == null) {
                string = "";
            }
            McTextField mcTextField2 = new McTextField(iAdvancedGui, point2, dimension, string);
            McTextField mcTextField3 = new McTextField(this, new Point(n + 375, n2 + 30 * n3), new Dimension(75, 30), String.valueOf(kjui2._e()));
            this._a(n - 200, n2 + 30 * n3, kjui2._a(), (Function1<? super Integer, Unit>)new Function1<Integer, Unit>(){

                @Override
                public /* synthetic */ Object invoke(Object object) {
                    this._a(((Number)object).intValue());
                    return Unit.INSTANCE;
                }

                public final void _a(int n) {
                    kjui2._a(n);
                }
            });
            this._a(n - 75, n2 + 30 * n3, kjui2._b(), (Function1<? super Integer, Unit>)new Function1<Integer, Unit>(){

                @Override
                public /* synthetic */ Object invoke(Object object) {
                    this._a(((Number)object).intValue());
                    return Unit.INSTANCE;
                }

                public final void _a(int n) {
                    kjui2._b(n);
                }
            });
            this._a(n + 50, n2 + 30 * n3, kjui2._c(), (Function1<? super Integer, Unit>)new Function1<Integer, Unit>(){

                @Override
                public /* synthetic */ Object invoke(Object object) {
                    this._a(((Number)object).intValue());
                    return Unit.INSTANCE;
                }

                public final void _a(int n) {
                    kjui2._c(n);
                }
            });
            this.addElement(mcTextField2);
            this.addElement(mcTextField3);
            GuiHelper.addButton(this, new Point(n + 490, n2 + 30 * n3), new Dimension(125, 30), "\u0423\u0434\u0430\u043b\u0438\u0442\u044c").onClick(new IActionHandler<GuiActionButtonClick>(){

                @Override
                public /* synthetic */ void processAction(GuiAction guiAction) {
                    this._a((GuiActionButtonClick)guiAction);
                }

                public final void _a(GuiActionButtonClick guiActionButtonClick) {
                    _b._a().remove(kjui2);
                    this.setWorldAndResolution(mc, width, height);
                }
            });
            this.actionManager.registerActionHandler((GuiComponent)mcTextField2, GuiActionTextFieldChanged.class, new IActionHandler<GuiActionTextFieldChanged>(){

                @Override
                public /* synthetic */ void processAction(GuiAction guiAction) {
                    this._a((GuiActionTextFieldChanged)guiAction);
                }

                public final void _a(GuiActionTextFieldChanged guiActionTextFieldChanged) {
                    String string = ((McTextField)guiActionTextFieldChanged.component).getText();
                    jxtc.kjui kjui22 = kjui2;
                    String string2 = string;
                    if (string2 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
                    }
                    String string3 = ((Object)StringsKt.trim((CharSequence)string2)).toString();
                    kjui22._a(owkq._a(string3));
                }
            });
            this.actionManager.registerActionHandler((GuiComponent)mcTextField3, GuiActionTextFieldChanged.class, new IActionHandler<GuiActionTextFieldChanged>(){

                @Override
                public /* synthetic */ void processAction(GuiAction guiAction) {
                    this._a((GuiActionTextFieldChanged)guiAction);
                }

                public final void _a(GuiActionTextFieldChanged guiActionTextFieldChanged) {
                    CharSequence charSequence;
                    Float f;
                    Float f2 = f = StringsKt.toFloatOrNull(((McTextField)guiActionTextFieldChanged.component).getText());
                    kjui2._a(f2 != null ? f2.floatValue() : 0.0f);
                    if (f == null && (charSequence = (CharSequence)((McTextField)guiActionTextFieldChanged.component).getText()).length() > 0) {
                        ((McTextField)guiActionTextFieldChanged.component).setText("");
                    }
                }
            });
            ++n3;
        }
        GuiHelper.addButton(this, point.add(-150, 175), new Dimension(150, 38), "\u0421\u043e\u0445\u0440\u0430\u043d\u0438\u0442\u044c").onClick(new IActionHandler<GuiActionButtonClick>(){

            @Override
            public /* synthetic */ void processAction(GuiAction guiAction) {
                this._a((GuiActionButtonClick)guiAction);
            }

            public final void _a(GuiActionButtonClick guiActionButtonClick) {
                this._g();
                this.closeScreen();
            }
        });
        GuiHelper.addButton(this, point.add(5, 175), new Dimension(150, 38), "\u041e\u0442\u043c\u0435\u043d\u0438\u0442\u044c").onClick(new IActionHandler<GuiActionButtonClick>(){

            @Override
            public /* synthetic */ void processAction(GuiAction guiAction) {
                this._a((GuiActionButtonClick)guiAction);
            }

            public final void _a(GuiActionButtonClick guiActionButtonClick) {
                this.closeScreen();
            }
        });
        this.actionManager.registerActionHandler((GuiComponent)mcTextField, GuiActionTextFieldChanged.class, new IActionHandler<GuiActionTextFieldChanged>(){

            @Override
            public /* synthetic */ void processAction(GuiAction guiAction) {
                this._a((GuiActionTextFieldChanged)guiAction);
            }

            public final void _a(GuiActionTextFieldChanged guiActionTextFieldChanged) {
                CharSequence charSequence;
                Integer n = StringsKt.toIntOrNull(((McTextField)guiActionTextFieldChanged.component).getText());
                _b._a(n);
                if (n == null && (charSequence = (CharSequence)((McTextField)guiActionTextFieldChanged.component).getText()).length() > 0) {
                    ((McTextField)guiActionTextFieldChanged.component).setText("");
                }
            }
        });
    }

    private final <T extends GuiComponent> T _a(int n, int n2, String string, T t) {
        this.addElement(new McLabel((IAdvancedGui)this, string, n, n2));
        t.setLocation(new Point(n + this._a, n2));
        this.addElement(t);
        return t;
    }

    private final McNumberField _a(int n, int n2, String string, int n3, Function1<? super Integer, Unit> function1) {
        this.addElement(new McLabel((IAdvancedGui)this, string, n, n2));
        return this._a(n + this._a, n2, n3, function1);
    }

    private final McNumberField _a(int n, int n2, int n3, final Function1<? super Integer, Unit> function1) {
        final McNumberField mcNumberField = GuiHelper.createNumberField(this, new Point(n, n2), new Dimension(75, 27), n3, Long.MAX_VALUE, Long.MIN_VALUE);
        this.addElement(mcNumberField);
        GuiHelper.addButton(this, new Point(n - 25, n2), new Dimension(20, 20), "-").onClick(new IActionHandler<GuiActionButtonClick>(){

            @Override
            public /* synthetic */ void processAction(GuiAction guiAction) {
                this._a((GuiActionButtonClick)guiAction);
            }

            public final void _a(GuiActionButtonClick guiActionButtonClick) {
                mcNumberField.setNumber(mcNumberField.getValue() - (long)1);
                function1.invoke((int)mcNumberField.getValue());
            }
        });
        GuiHelper.addButton(this, new Point(n + 75 + 5, n2), new Dimension(20, 20), "+").onClick(new IActionHandler<GuiActionButtonClick>(){

            @Override
            public /* synthetic */ void processAction(GuiAction guiAction) {
                this._a((GuiActionButtonClick)guiAction);
            }

            public final void _a(GuiActionButtonClick guiActionButtonClick) {
                mcNumberField.setNumber(mcNumberField.getValue() + (long)1);
                function1.invoke((int)mcNumberField.getValue());
            }
        });
        this.actionManager.registerActionHandler((GuiComponent)mcNumberField, GuiActionTextFieldChanged.class, new IActionHandler<GuiActionTextFieldChanged>(){

            @Override
            public /* synthetic */ void processAction(GuiAction guiAction) {
                this._a((GuiActionTextFieldChanged)guiAction);
            }

            public final void _a(GuiActionTextFieldChanged guiActionTextFieldChanged) {
                function1.invoke((int)mcNumberField.getValue());
            }
        });
        McNumberField mcNumberField2 = mcNumberField;
        Intrinsics.checkExpressionValueIsNotNull(mcNumberField2, "numberField");
        return mcNumberField2;
    }

    private final jydd _e() {
        TileEntity tileEntity = this._d.getBlockTileEntity(this._e, this._f, this._g);
        if (!(tileEntity instanceof jydd)) {
            tileEntity = null;
        }
        jydd jydd2 = (jydd)tileEntity;
        if (jydd2 == null) {
            throw (Throwable)new IllegalStateException("Existing tileentity at " + this._e + ' ' + this._f + ' ' + this._g + " is not a portal, aborting opening editor GUI!");
        }
        return jydd2;
    }

    private final void _f() {
        this._b = this._e()._i();
        this._c = this._e() instanceof ivab;
    }

    private final void _g() {
        jydd jydd2 = this._e();
        jydd2._a(this._b);
        new ntyw(jydd2, false).sendToServer();
    }

    @Override
    public void onGuiClosed() {
        new ntyw(this._e(), true).sendToServer();
        super.onGuiClosed();
    }

    @NotNull
    public final World _a() {
        return this._d;
    }

    public final int _b() {
        return this._e;
    }

    public final int _c() {
        return this._f;
    }

    public final int _d() {
        return this._g;
    }

    public hayt(@NotNull World world, int n, int n2, int n3) {
        Intrinsics.checkParameterIsNotNull(world, "world");
        super(GuiComponent.hdRenderer, 700, 500);
        this._d = world;
        this._e = n;
        this._f = n2;
        this._g = n3;
        this._a = 150;
        this._b = new jxtc();
    }

    public static final /* synthetic */ void _a(hayt hayt2, @NotNull jxtc jxtc2) {
        hayt2._b = jxtc2;
    }
}

