/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.mobs.client.gui;

import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.GuiRendererBuilder;
import gloomyfolken.mods.core.client.gui.engine.GuiScreenAdvanced;
import gloomyfolken.mods.core.client.gui.engine.IActionHandler;
import gloomyfolken.mods.core.client.gui.engine.IAdvancedGui;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.action.GuiActionButtonClick;
import gloomyfolken.mods.core.client.gui.engine.action.GuiActionCheckboxToggle;
import gloomyfolken.mods.core.client.gui.engine.action.GuiActionTextAreaChanged;
import gloomyfolken.mods.core.client.gui.engine.action.GuiActionTextFieldChanged;
import gloomyfolken.mods.core.client.gui.engine.component.GuiComponent;
import gloomyfolken.mods.core.client.gui.engine.component.McAbstractButton;
import gloomyfolken.mods.core.client.gui.engine.component.McButton;
import gloomyfolken.mods.core.client.gui.engine.component.McCheckBox;
import gloomyfolken.mods.core.client.gui.engine.component.McLabel;
import gloomyfolken.mods.core.client.gui.engine.component.McNumberField;
import gloomyfolken.mods.core.client.gui.engine.component.McTextArea;
import gloomyfolken.mods.core.client.gui.engine.component.McTextField;
import gloomyfolken.mods.core.client.gui.engine.style.ComponentCheckboxStyle;
import gloomyfolken.mods.core.client.gui.engine.style.ComponentStyle;
import gloomyfolken.mods.stalker.mobs.client.gui.GuiMutantSpawnerSettings;
import gloomyfolken.mods.stalker.mobs.packet.PacketEditTileConfig;
import gloomyfolken.mods.stalker.mobs.spawn.MutantSpawnEntryInfo;
import gloomyfolken.mods.stalker.mobs.spawn.MutantSpawnerConfiguration;
import gloomyfolken.mods.stalker.mobs.tile.TileEntityMutantSpawner;
import gloomyfolken.mods.stalker.mobs.tile.TileEntityMutantSpawnerSpecial;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.lwjgl.input.Keyboard;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\bJ \u0010+\u001a\u00020,2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010-\u001a\u00020.H\u0016J\b\u0010/\u001a\u00020,H\u0016J\u0006\u00100\u001a\u00020\u000bJ\b\u00101\u001a\u00020,H\u0002J\b\u00102\u001a\u00020,H\u0016J\u000e\u00103\u001a\b\u0012\u0004\u0012\u00020504H\u0002J\u000e\u00106\u001a\b\u0012\u0004\u0012\u00020\u000504H\u0002J\b\u00107\u001a\u00020,H\u0002J\b\u00108\u001a\u00020\u000bH\u0002J\u001e\u00109\u001a\u00020\u000b2\u0006\u0010:\u001a\u00020\r2\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u000b0<H\u0002R\u000e\u0010\t\u001a\u00020\u0005X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\r0\u0011j\b\u0012\u0004\u0012\u00020\r`\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\r0\u0016X\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0017R\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\u0016X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0018\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0016X\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0017R\u001e\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u001f0\u001ej\b\u0012\u0004\u0012\u00020\u001f` X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010#\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u001ej\b\u0012\u0004\u0012\u00020\u0005` X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010(R\u0011\u0010\u0007\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010(\u00a8\u0006="}, d2={"Lgloomyfolken/mods/stalker/mobs/client/gui/GuiMutantSpawnerSettings;", "Lgloomyfolken/mods/core/client/gui/engine/GuiScreenAdvanced;", "world", "Lnet/minecraft/world/World;", "x", "", "y", "z", "(Lnet/minecraft/world/World;III)V", "MAX_CONFIGURATIONS", "approved", "", "author", "", "confirmButton", "Lgloomyfolken/mods/core/client/gui/engine/component/McButton;", "dungeons", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "dungeonsStr", "errorString", "intLabels", "", "[Ljava/lang/String;", "intValues", "[Ljava/lang/Integer;", "isSpecial", "lowestY", "selectedConfigurationStrings", "selectedConfigurations", "Ljava/util/ArrayList;", "Lgloomyfolken/mods/core/spawn/EntitySpawnEntryInfo;", "Lkotlin/collections/ArrayList;", "shouldSendData", "spawnEnabled", "suitableBlocks", "suitableBlocksString", "getWorld", "()Lnet/minecraft/world/World;", "getX", "()I", "getY", "getZ", "drawScreen", "", "frame", "", "initGui", "isEditorOpped", "loadDataFromTile", "onGuiClosed", "parseConfigurationsStrings", "", "Lgloomyfolken/mods/stalker/mobs/spawn/MutantSpawnEntryInfo;", "parseSuitableBlocks", "updateTileAabb", "validateInputs", "verify", "message", "condition", "Lkotlin/Function0;", "minecraft"})
public final class GuiMutantSpawnerSettings
extends GuiScreenAdvanced {
    private final int MAX_CONFIGURATIONS = 20;
    private final Integer[] intValues;
    private final ArrayList<Integer> suitableBlocks;
    private final ArrayList<qman> selectedConfigurations;
    private String[] intLabels;
    private final HashSet<String> dungeons;
    private String dungeonsStr;
    private String suitableBlocksString;
    private String[] selectedConfigurationStrings;
    private String errorString;
    private int lowestY;
    private McButton confirmButton;
    private boolean shouldSendData;
    private boolean spawnEnabled;
    private String author;
    private boolean approved;
    private boolean isSpecial;
    @NotNull
    private final ozlu world;
    private final int x;
    private final int y;
    private final int z;

    @Override
    public void func_73866_w_() {
        GuiComponent guiComponent;
        GuiComponent guiComponent2;
        Object object;
        int n;
        super.func_73866_w_();
        int n2 = this.guiLeft;
        int n3 = this.guiTop;
        this.loadDataFromTile();
        hurg hurg2 = this.world.func_72796_p(this.x, this.y, this.z);
        if (hurg2 == null) {
            throw new TypeCastException("null cannot be cast to non-null type gloomyfolken.mods.stalker.mobs.tile.TileEntityMutantSpawner");
        }
        TileEntityMutantSpawner tileEntityMutantSpawner = (TileEntityMutantSpawner)hurg2;
        this.isSpecial = tileEntityMutantSpawner instanceof TileEntityMutantSpawnerSpecial;
        Keyboard.enableRepeatEvents(true);
        int n4 = n2 + 20;
        int n5 = n3 + 20;
        int n6 = n4 + 260;
        int n7 = 100;
        int n8 = 20;
        Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = 20;
        Object object2 = this.intValues;
        int n9 = 0;
        for (n = 0; n < ((Object[])object2).length; ++n) {
            GuiComponent guiComponent3;
            Object object3;
            int n10;
            object = object2[n];
            int n11 = n9++;
            int n12 = ((Number)object).intValue();
            int n13 = n11;
            guiComponent2 = new McNumberField(this, n6, n5 + n13 * n8, n7, 20);
            ((McNumberField)guiComponent2).setNumber(n12);
            if (n13 < 6) {
                ((McNumberField)guiComponent2).setMinValue(-128L);
                ((McNumberField)guiComponent2).setMaxValue(128L);
            } else {
                ((McNumberField)guiComponent2).setMinValue(0L);
            }
            if (n13 == 6) {
                ((McNumberField)guiComponent2).setMaxValue(256L);
            }
            guiComponent2.userData = n13;
            guiComponent = new McButton((IAdvancedGui)this, n6 - 22, n5 + n13 * n8, "-");
            McButton mcButton = new McButton((IAdvancedGui)this, n6 + n7 + 2, n5 + n13 * n8, "+");
            McLabel mcLabel = new McLabel((IAdvancedGui)this, this.intLabels[n13] + ":", n4, n5 + n13 * n8);
            Object[] objectArray = new McButton[]{guiComponent, mcButton};
            for (n10 = 0; n10 < objectArray.length; ++n10) {
                object3 = objectArray[n10];
                guiComponent3 = (McButton)object3;
                ((McAbstractButton)guiComponent3).setSize(new Dimension(20, 20));
            }
            objectArray = new GuiComponent[]{guiComponent, mcButton, guiComponent2, mcLabel};
            for (n10 = 0; n10 < objectArray.length; ++n10) {
                object3 = objectArray[n10];
                guiComponent3 = (GuiComponent)object3;
                this.addElement(guiComponent3);
            }
            if (this.isSpecial && n13 < 7) {
                objectArray = new GuiComponent[]{guiComponent, mcButton, guiComponent2, mcLabel};
                for (n10 = 0; n10 < objectArray.length; ++n10) {
                    object3 = objectArray[n10];
                    guiComponent3 = (GuiComponent)object3;
                    guiComponent3.setEnabled(false);
                }
            }
            this.actionManager.registerActionHandler((GuiComponent)guiComponent, GuiActionButtonClick.class, new IActionHandler<GuiActionButtonClick>((McNumberField)guiComponent2, this, n6, n5, n8, n7, n4, intRef){
                final /* synthetic */ McNumberField $component;
                final /* synthetic */ GuiMutantSpawnerSettings this$0;
                final /* synthetic */ int $valuesXOffset$inlined;
                final /* synthetic */ int $baseYOffset$inlined;
                final /* synthetic */ int $rowHeight$inlined;
                final /* synthetic */ int $numberFieldWidth$inlined;
                final /* synthetic */ int $baseXOffset$inlined;
                final /* synthetic */ Ref.IntRef $col1YOffset$inlined;
                {
                    this.$component = mcNumberField;
                    this.this$0 = guiMutantSpawnerSettings;
                    this.$valuesXOffset$inlined = n;
                    this.$baseYOffset$inlined = n2;
                    this.$rowHeight$inlined = n3;
                    this.$numberFieldWidth$inlined = n4;
                    this.$baseXOffset$inlined = n5;
                    this.$col1YOffset$inlined = intRef;
                }

                public final void processAction(GuiActionButtonClick guiActionButtonClick) {
                    this.$component.setNumber(this.$component.getValue() - (long)1);
                    GuiMutantSpawnerSettings.access$validateInputs(this.this$0);
                }
            });
            this.actionManager.registerActionHandler((GuiComponent)mcButton, GuiActionButtonClick.class, new IActionHandler<GuiActionButtonClick>((McNumberField)guiComponent2, this, n6, n5, n8, n7, n4, intRef){
                final /* synthetic */ McNumberField $component;
                final /* synthetic */ GuiMutantSpawnerSettings this$0;
                final /* synthetic */ int $valuesXOffset$inlined;
                final /* synthetic */ int $baseYOffset$inlined;
                final /* synthetic */ int $rowHeight$inlined;
                final /* synthetic */ int $numberFieldWidth$inlined;
                final /* synthetic */ int $baseXOffset$inlined;
                final /* synthetic */ Ref.IntRef $col1YOffset$inlined;
                {
                    this.$component = mcNumberField;
                    this.this$0 = guiMutantSpawnerSettings;
                    this.$valuesXOffset$inlined = n;
                    this.$baseYOffset$inlined = n2;
                    this.$rowHeight$inlined = n3;
                    this.$numberFieldWidth$inlined = n4;
                    this.$baseXOffset$inlined = n5;
                    this.$col1YOffset$inlined = intRef;
                }

                public final void processAction(GuiActionButtonClick guiActionButtonClick) {
                    this.$component.setNumber(this.$component.getValue() + (long)1);
                    GuiMutantSpawnerSettings.access$validateInputs(this.this$0);
                }
            });
            this.actionManager.registerActionHandler((GuiComponent)guiComponent2, GuiActionTextFieldChanged.class, new IActionHandler<GuiActionTextFieldChanged>(this, n6, n5, n8, n7, n4, intRef){
                final /* synthetic */ GuiMutantSpawnerSettings this$0;
                final /* synthetic */ int $valuesXOffset$inlined;
                final /* synthetic */ int $baseYOffset$inlined;
                final /* synthetic */ int $rowHeight$inlined;
                final /* synthetic */ int $numberFieldWidth$inlined;
                final /* synthetic */ int $baseXOffset$inlined;
                final /* synthetic */ Ref.IntRef $col1YOffset$inlined;
                {
                    this.this$0 = guiMutantSpawnerSettings;
                    this.$valuesXOffset$inlined = n;
                    this.$baseYOffset$inlined = n2;
                    this.$rowHeight$inlined = n3;
                    this.$numberFieldWidth$inlined = n4;
                    this.$baseXOffset$inlined = n5;
                    this.$col1YOffset$inlined = intRef;
                }

                public final void processAction(GuiActionTextFieldChanged guiActionTextFieldChanged) {
                    T t = guiActionTextFieldChanged.component;
                    if (t == null) {
                        throw new TypeCastException("null cannot be cast to non-null type gloomyfolken.mods.core.client.gui.engine.component.McNumberField");
                    }
                    McNumberField mcNumberField = (McNumberField)t;
                    Object object = mcNumberField.userData;
                    if (object == null) {
                        throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
                    }
                    GuiMutantSpawnerSettings.access$getIntValues$p((GuiMutantSpawnerSettings)this.this$0)[((Integer)object).intValue()] = (int)mcNumberField.getValue();
                    GuiMutantSpawnerSettings.access$validateInputs(this.this$0);
                    GuiMutantSpawnerSettings.access$updateTileAabb(this.this$0);
                }
            });
            intRef.element += n8;
        }
        if (!this.isSpecial) {
            this.addElement(new McLabel((IAdvancedGui)this, "\u0421\u043f\u0438\u0441\u043e\u043a id \u0440\u0430\u0437\u0440\u0435\u0448\u0435\u043d\u043d\u044b\u0445 \u0431\u043b\u043e\u043a\u043e\u0432 (\u0447\u0435\u0440\u0435\u0437 \u0437\u0430\u043f\u044f\u0442\u0443\u044e):", n4, n5 + intRef.element));
            this.addElement(new McLabel((IAdvancedGui)this, "\u041d\u0430 \u044d\u0442\u0438\u0445 \u0431\u043b\u043e\u043a\u0430\u0445 \u0441\u043c\u043e\u0433\u0443\u0442 \u0441\u043f\u0430\u0432\u043d\u0438\u0442\u044c\u0441\u044f \u0441\u0443\u0449\u043d\u043e\u0441\u0442\u0438:", n4, n5 + intRef.element + 20));
            object2 = new McTextArea(this, n4, n5 + intRef.element + 40, 350, 64);
            ((McTextArea)object2).setText(this.suitableBlocksString);
            this.actionManager.registerActionHandler((GuiComponent)object2, GuiActionTextAreaChanged.class, new IActionHandler<GuiActionTextAreaChanged>(this){
                final /* synthetic */ GuiMutantSpawnerSettings this$0;

                public final void processAction(GuiActionTextAreaChanged guiActionTextAreaChanged) {
                    String string = ((McTextArea)guiActionTextAreaChanged.component).getText();
                    Intrinsics.checkExpressionValueIsNotNull(string, "it.component.text");
                    GuiMutantSpawnerSettings.access$setSuitableBlocksString$p(this.this$0, string);
                    GuiMutantSpawnerSettings.access$validateInputs(this.this$0);
                }
                {
                    this.this$0 = guiMutantSpawnerSettings;
                }
            });
            ((McTextArea)object2).isEditable = true;
            this.addElement((GuiComponent)object2);
        }
        int n14 = n6 + n7 + 70;
        n9 = 0;
        n = this.MAX_CONFIGURATIONS - 1;
        if (n9 <= n) {
            while (!this.isSpecial) {
                object = new McTextField(this, n14, n5, n9, n8, this, n14, n5 + 40 + n9 * n8, 220, 20){
                    final /* synthetic */ GuiMutantSpawnerSettings this$0;
                    final /* synthetic */ int $configurationsXOffset;
                    final /* synthetic */ int $baseYOffset;
                    final /* synthetic */ int $i;
                    final /* synthetic */ int $rowHeight;

                    @NotNull
                    public String getText() {
                        Double d;
                        if (!this.isFocused() && (d = StringsKt.toDoubleOrNull((String)CollectionsKt.last(StringsKt.split$default((CharSequence)super.getText(), new String[]{":"}, false, 0, 6, null)))) != null) {
                            String string;
                            String string2 = super.getText();
                            Intrinsics.checkExpressionValueIsNotNull(string2, "super.getText()");
                            String string3 = this.weightedChanceToLocal(string2);
                            String string4 = (StringsKt.contains$default((CharSequence)string3, "[", false, 2, null) ? "[" : "") + StringsKt.substringAfterLast$default(string3, "[", null, 2, null);
                            String string5 = StringsKt.substringBeforeLast$default(string3, "[", null, 2, null);
                            int n = this.renderer.getStringWidth(string4);
                            String string6 = string = this.renderer.trimToWidth(string5 + " ", this.getWidth() - n, false);
                            StringBuilder stringBuilder = new StringBuilder();
                            String string7 = string6;
                            if (string7 == null) {
                                throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
                            }
                            String string8 = ((Object)StringsKt.trim((CharSequence)string7)).toString();
                            String string9 = stringBuilder.append(string8).append(" ").append(string4).toString();
                            return string9;
                        }
                        String string = super.getText();
                        Intrinsics.checkExpressionValueIsNotNull(string, "super.getText()");
                        return string;
                    }

                    private final String weightedChanceToLocal(String string) {
                        Double d = StringsKt.toDoubleOrNull((String)CollectionsKt.last(StringsKt.split$default((CharSequence)string, new String[]{":"}, false, 0, 6, null)));
                        if (d != null) {
                            Object object = GuiMutantSpawnerSettings.access$getSelectedConfigurationStrings$p(this.this$0);
                            Object[] objectArray = object;
                            Collection collection = new ArrayList<E>();
                            Object object2 = objectArray;
                            for (int i = 0; i < ((Object[])object2).length; ++i) {
                                Double d2;
                                Object object3 = object2[i];
                                Object object4 = object3;
                                String string2 = (String)object4;
                                Object object5 = string2;
                                Double d3 = object5 != null && (object5 = StringsKt.split$default((CharSequence)object5, new String[]{":"}, false, 0, 6, null)) != null && (object5 = (String)CollectionsKt.getOrNull(object5, 1)) != null ? StringsKt.toDoubleOrNull((String)object5) : null;
                                if (d3 == null) continue;
                                Double d4 = d2 = d3;
                                collection.add(d4);
                            }
                            object = (List)collection;
                            object = (Iterable)object;
                            double d5 = 0.0;
                            object2 = object.iterator();
                            while (object2.hasNext()) {
                                E e = object2.next();
                                double d6 = ((Number)e).doubleValue();
                                double d7 = d5;
                                double d8 = d6;
                                d5 = d7 + d8;
                            }
                            double d9 = d5;
                            d = d / d9;
                            d = d * (double)100;
                            return "" + (String)StringsKt.split$default((CharSequence)string, new String[]{":"}, false, 0, 6, null).get(0) + " [" + owkq._a((double)d, 2) + "%]";
                        }
                        return string;
                    }
                    {
                        this.this$0 = guiMutantSpawnerSettings;
                        this.$configurationsXOffset = n;
                        this.$baseYOffset = n2;
                        this.$i = n3;
                        this.$rowHeight = n4;
                        super(iAdvancedGui, n5, n6, n7, n8);
                    }
                };
                ((GuiComponent)object).userData = n9;
                String string = this.selectedConfigurationStrings[n9];
                Object object4 = object;
                String string2 = string;
                if (string2 == null) {
                    string2 = "";
                }
                String string3 = string2;
                ((McTextField)object4).setText(string3);
                this.actionManager.registerActionHandler((GuiComponent)object, GuiActionTextFieldChanged.class, new IActionHandler<GuiActionTextFieldChanged>(this){
                    final /* synthetic */ GuiMutantSpawnerSettings this$0;

                    public final void processAction(GuiActionTextFieldChanged guiActionTextFieldChanged) {
                        Object object = ((McTextField)guiActionTextFieldChanged.component).userData;
                        if (object == null) {
                            throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
                        }
                        GuiMutantSpawnerSettings.access$getSelectedConfigurationStrings$p((GuiMutantSpawnerSettings)this.this$0)[((Integer)object).intValue()] = owkq._a(((McTextField)guiActionTextFieldChanged.component).getText());
                        GuiMutantSpawnerSettings.access$validateInputs(this.this$0);
                    }
                    {
                        this.this$0 = guiMutantSpawnerSettings;
                    }
                });
                this.addElement((GuiComponent)object);
                if (n9 == n) break;
                ++n9;
            }
        }
        this.lowestY = n5 + 40 + (this.MAX_CONFIGURATIONS - 1) * n8;
        this.lowestY += 20;
        McButton mcButton = this.confirmButton = new McButton((IAdvancedGui)this, n4, this.lowestY, "\u041f\u043e\u0434\u0442\u0432\u0435\u0440\u0434\u0438\u0442\u044c");
        if (mcButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("confirmButton");
        }
        this.actionManager.registerActionHandler((GuiComponent)mcButton, GuiActionButtonClick.class, new IActionHandler<GuiActionButtonClick>(this){
            final /* synthetic */ GuiMutantSpawnerSettings this$0;

            public final void processAction(GuiActionButtonClick guiActionButtonClick) {
                GuiMutantSpawnerSettings.access$setShouldSendData$p(this.this$0, true);
                this.this$0.closeScreen();
            }
            {
                this.this$0 = guiMutantSpawnerSettings;
            }
        });
        McButton mcButton2 = this.confirmButton;
        if (mcButton2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("confirmButton");
        }
        McButton mcButton3 = this.confirmButton;
        if (mcButton3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("confirmButton");
        }
        mcButton2.setSize(new Dimension(160, mcButton3.getSize().height));
        McButton mcButton4 = this.confirmButton;
        if (mcButton4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("confirmButton");
        }
        this.addElement(mcButton4);
        McButton mcButton5 = new McButton((IAdvancedGui)this, n4 + 170, this.lowestY, "\u041e\u0442\u043c\u0435\u043d\u0438\u0442\u044c");
        this.actionManager.registerActionHandler((GuiComponent)mcButton5, GuiActionButtonClick.class, new IActionHandler<GuiActionButtonClick>(this){
            final /* synthetic */ GuiMutantSpawnerSettings this$0;

            public final void processAction(GuiActionButtonClick guiActionButtonClick) {
                this.this$0.closeScreen();
            }
            {
                this.this$0 = guiMutantSpawnerSettings;
            }
        });
        mcButton5.setSize(new Dimension(160, mcButton5.getSize().height));
        this.addElement(mcButton5);
        McButton mcButton6 = new McButton((IAdvancedGui)this, n4, this.lowestY + 60, "\u0423\u0431\u0438\u0442\u044c \u0437\u0430\u0441\u043f\u0430\u0432\u043d\u0435\u043d\u043d\u044b\u0445 \u0441\u0443\u0449\u043d\u043e\u0441\u0442\u0435\u0439");
        this.actionManager.registerActionHandler((GuiComponent)mcButton6, GuiActionButtonClick.class, new IActionHandler<GuiActionButtonClick>(this){
            final /* synthetic */ GuiMutantSpawnerSettings this$0;

            public final void processAction(GuiActionButtonClick guiActionButtonClick) {
                new ncxk(null, this.this$0.getX(), this.this$0.getY(), this.this$0.getZ(), 1).sendToServer();
                new ncxk(null, this.this$0.getX(), this.this$0.getY(), this.this$0.getZ(), 2).sendToServer();
            }
            {
                this.this$0 = guiMutantSpawnerSettings;
            }
        });
        this.addElement(mcButton6);
        this.addElement(new McLabel((IAdvancedGui)this, "\u0421\u0435\u0440\u0432\u0435\u0440\u0430 \u0434\u043b\u044f \u0441\u043f\u0430\u0432\u043d\u0430 (\u0441\u043f\u0430\u0432\u043d \u0432\u0435\u0437\u0434\u0435 \u0435\u0441\u043b\u0438 \u043f\u0443\u0441\u0442\u043e):", n4, this.lowestY - 90));
        object = new McTextArea(this, n4, this.lowestY - 70, 350, 64);
        ((McTextArea)object).setText(this.dungeonsStr);
        this.actionManager.registerActionHandler((GuiComponent)object, GuiActionTextAreaChanged.class, new IActionHandler<GuiActionTextAreaChanged>(this){
            final /* synthetic */ GuiMutantSpawnerSettings this$0;

            public final void processAction(GuiActionTextAreaChanged guiActionTextAreaChanged) {
                String string = ((McTextArea)guiActionTextAreaChanged.component).getText();
                Intrinsics.checkExpressionValueIsNotNull(string, "it.component.text");
                GuiMutantSpawnerSettings.access$setDungeonsStr$p(this.this$0, string);
                GuiMutantSpawnerSettings.access$validateInputs(this.this$0);
            }
            {
                this.this$0 = guiMutantSpawnerSettings;
            }
        });
        ((McTextArea)object).isEditable = true;
        this.addElement((GuiComponent)object);
        this.lowestY -= 20;
        McButton mcButton7 = new McButton((IAdvancedGui)this, n14, n3 - 40, "\u0421\u043f\u0438\u0441\u043e\u043a \u043a\u043e\u043d\u0444\u0438\u0433\u0443\u0440\u0430\u0446\u0438\u0439");
        this.actionManager.registerActionHandler((GuiComponent)mcButton7, GuiActionButtonClick.class, initGui.8.INSTANCE);
        mcButton7.setSize(new Dimension(200, mcButton7.getSize().height));
        this.addElement(mcButton7);
        if (this.isSpecial) {
            mcButton7.setLocation(new Point(mcButton7.getLocation().x, mcButton7.getLocation().y + 50));
            McButton mcButton8 = new McButton((IAdvancedGui)this, n14, n3 + 60, "\u0420\u0435\u0434\u0430\u043a\u0442\u0438\u0440\u043e\u0432\u0430\u0442\u044c \u043a\u043e\u043d\u0444\u0438\u0433\u0443\u0440\u0430\u0446\u0438\u044e");
            this.actionManager.registerActionHandler((GuiComponent)mcButton8, GuiActionButtonClick.class, initGui.9.INSTANCE);
            mcButton8.setSize(new Dimension(220, mcButton8.getSize().height));
            this.addElement(mcButton8);
        } else {
            this.addElement(new McLabel((IAdvancedGui)this, "\u0418\u043c\u044f \u043a\u043e\u043d\u0444\u0438\u0433\u0443\u0440\u0430\u0446\u0438\u0438:\u0432\u0435\u0441", n14, n5));
            this.addElement(new McLabel((IAdvancedGui)this, "\u041f\u0440\u0438\u043c\u0435\u0440: dog_weak:15", n14, n5 + 20));
        }
        McCheckBox mcCheckBox = new McCheckBox(this, "\u0422\u0435\u0441\u0442\u0438\u0440\u043e\u0432\u0430\u0442\u044c \u0441\u043f\u0430\u0432\u043d", n14, this.lowestY + 60, (ComponentCheckboxStyle)ComponentStyle.VANILLA.getComponentStyle(McCheckBox.class));
        this.actionManager.registerActionHandler((GuiComponent)mcCheckBox, GuiActionCheckboxToggle.class, new IActionHandler<GuiActionCheckboxToggle>(this){
            final /* synthetic */ GuiMutantSpawnerSettings this$0;

            public final void processAction(GuiActionCheckboxToggle guiActionCheckboxToggle) {
                GuiMutantSpawnerSettings.access$setSpawnEnabled$p(this.this$0, guiActionCheckboxToggle.newState);
            }
            {
                this.this$0 = guiMutantSpawnerSettings;
            }
        });
        this.addElement(mcCheckBox);
        mcCheckBox.setActive(this.spawnEnabled);
        guiComponent2 = new McCheckBox(this, "\u0421\u043f\u0430\u0432\u043d\u0435\u0440 \u0432\u0435\u0440\u0438\u0444\u0438\u0446\u0438\u0440\u043e\u0432\u0430\u043d (OP only)", n14, this.lowestY + 90, (ComponentCheckboxStyle)ComponentStyle.VANILLA.getComponentStyle(McCheckBox.class));
        this.actionManager.registerActionHandler((GuiComponent)guiComponent2, GuiActionCheckboxToggle.class, new IActionHandler<GuiActionCheckboxToggle>(this){
            final /* synthetic */ GuiMutantSpawnerSettings this$0;

            public final void processAction(GuiActionCheckboxToggle guiActionCheckboxToggle) {
                GuiMutantSpawnerSettings.access$setApproved$p(this.this$0, guiActionCheckboxToggle.newState);
            }
            {
                this.this$0 = guiMutantSpawnerSettings;
            }
        });
        guiComponent2.setEnabled(this.isEditorOpped());
        this.addElement(guiComponent2);
        ((McCheckBox)guiComponent2).setActive(this.approved);
        mcCheckBox.setRenderer(new GuiRendererBuilder().setTextureSize(256, 256).create());
        guiComponent2.setRenderer(new GuiRendererBuilder().setTextureSize(256, 256).create());
        guiComponent = new McTextArea(this, n14, this.lowestY + 115, 200, 20);
        ((McTextArea)guiComponent).setText(this.author);
        this.actionManager.registerActionHandler(guiComponent, GuiActionTextAreaChanged.class, new IActionHandler<GuiActionTextAreaChanged>(this){
            final /* synthetic */ GuiMutantSpawnerSettings this$0;

            public final void processAction(GuiActionTextAreaChanged guiActionTextAreaChanged) {
                String string = ((McTextArea)guiActionTextAreaChanged.component).getText();
                Intrinsics.checkExpressionValueIsNotNull(string, "it.component.text");
                GuiMutantSpawnerSettings.access$setAuthor$p(this.this$0, string);
            }
            {
                this.this$0 = guiMutantSpawnerSettings;
            }
        });
        guiComponent.setEnabled(this.isEditorOpped());
        ((McTextArea)guiComponent).isEditable = this.isEditorOpped();
        this.addElement(guiComponent);
        McButton mcButton9 = this.confirmButton;
        if (mcButton9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("confirmButton");
        }
        mcButton9.setEnabled(this.validateInputs());
    }

    public final boolean isEditorOpped() {
        return true;
    }

    private final void updateTileAabb() {
        hurg hurg2 = this.world.func_72796_p(this.x, this.y, this.z);
        if (hurg2 == null) {
            throw new TypeCastException("null cannot be cast to non-null type gloomyfolken.mods.stalker.mobs.tile.TileEntityMutantSpawner");
        }
        TileEntityMutantSpawner tileEntityMutantSpawner = (TileEntityMutantSpawner)hurg2;
        tileEntityMutantSpawner.setXMin(this.intValues[0]);
        tileEntityMutantSpawner.setYMin(this.intValues[1]);
        tileEntityMutantSpawner.setZMin(this.intValues[2]);
        tileEntityMutantSpawner.setXMax(this.intValues[3]);
        tileEntityMutantSpawner.setYMax(this.intValues[4]);
        tileEntityMutantSpawner.setZMax(this.intValues[5]);
    }

    @Override
    public void func_73874_b() {
        super.func_73874_b();
        new PacketEditTileConfig(true).sendToServer();
        if (this.validateInputs() && this.shouldSendData) {
            hurg hurg2 = this.world.func_72796_p(this.x, this.y, this.z);
            if (hurg2 == null) {
                throw new TypeCastException("null cannot be cast to non-null type gloomyfolken.mods.stalker.mobs.tile.TileEntityMutantSpawner");
            }
            TileEntityMutantSpawner tileEntityMutantSpawner = (TileEntityMutantSpawner)hurg2;
            this.updateTileAabb();
            tileEntityMutantSpawner.getConfiguration().setMaxEntityCount(this.intValues[6]);
            tileEntityMutantSpawner.getConfiguration().setSpawnCooldownMin(this.intValues[7].intValue());
            tileEntityMutantSpawner.getConfiguration().setSpawnCooldownMax(this.intValues[8].intValue());
            tileEntityMutantSpawner.getConfiguration().getPossibleSpawnEntries().clear();
            tileEntityMutantSpawner.getConfiguration().getPossibleSpawnEntries().addAll((Collection<qman>)this.selectedConfigurations);
            tileEntityMutantSpawner.getConfiguration().getDungeons().clear();
            tileEntityMutantSpawner.getConfiguration().getDungeons().addAll((Collection<String>)this.dungeons);
            Object object = this.suitableBlocks;
            MutantSpawnerConfiguration mutantSpawnerConfiguration = tileEntityMutantSpawner.getConfiguration();
            Collection collection = object;
            if (collection == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.util.Collection<T>");
            }
            Collection collection2 = collection;
            Integer[] integerArray = collection2.toArray(new Integer[collection2.size()]);
            if (integerArray == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            Integer[] integerArray2 = integerArray;
            mutantSpawnerConfiguration.setSufficientBlocks(integerArray2);
            tileEntityMutantSpawner.getConfiguration().setDayOfTimeType(this.intValues[9]);
            tileEntityMutantSpawner.setSpawnEnabled(this.spawnEnabled);
            tileEntityMutantSpawner.setAuthor(this.author);
            tileEntityMutantSpawner.setWasApproved(this.approved);
            object = new qoac();
            tileEntityMutantSpawner.func_70310_b((qoac)object);
            new ncxk((qoac)object, this.x, this.y, this.z, 0).sendToServer();
        }
        new ncxk(null, this.x, this.y, this.z, 3).sendToServer();
    }

    private final void loadDataFromTile() {
        String string;
        Collection<String> collection;
        hurg hurg2 = this.world.func_72796_p(this.x, this.y, this.z);
        if (hurg2 == null) {
            throw new TypeCastException("null cannot be cast to non-null type gloomyfolken.mods.stalker.mobs.tile.TileEntityMutantSpawner");
        }
        TileEntityMutantSpawner tileEntityMutantSpawner = (TileEntityMutantSpawner)hurg2;
        this.intValues[0] = tileEntityMutantSpawner.getXMin();
        this.intValues[1] = tileEntityMutantSpawner.getYMin();
        this.intValues[2] = tileEntityMutantSpawner.getZMin();
        this.intValues[3] = tileEntityMutantSpawner.getXMax();
        this.intValues[4] = tileEntityMutantSpawner.getYMax();
        this.intValues[5] = tileEntityMutantSpawner.getZMax();
        this.intValues[6] = tileEntityMutantSpawner.getConfiguration().getMaxEntityCount();
        this.intValues[7] = (int)tileEntityMutantSpawner.getConfiguration().getSpawnCooldownMin();
        this.intValues[8] = (int)tileEntityMutantSpawner.getConfiguration().getSpawnCooldownMax();
        this.intValues[9] = tileEntityMutantSpawner.getConfiguration().getDayOfTimeType();
        this.suitableBlocks.clear();
        CollectionsKt.addAll((Collection)this.suitableBlocks, (Object[])tileEntityMutantSpawner.getConfiguration().getSufficientBlocks());
        this.selectedConfigurations.clear();
        this.selectedConfigurations.addAll((Collection<qman>)tileEntityMutantSpawner.getConfiguration().getPossibleSpawnEntries());
        this.dungeons.clear();
        this.dungeons.addAll((Collection<String>)tileEntityMutantSpawner.getConfiguration().getDungeons());
        Iterable iterable = this.dungeons;
        GuiMutantSpawnerSettings guiMutantSpawnerSettings = this;
        Iterable iterable2 = iterable;
        Object object = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (Object object2 : iterable2) {
            String string2 = (String)object2;
            collection = object;
            string = string2;
            collection.add(string);
        }
        collection = (List)object;
        guiMutantSpawnerSettings.dungeonsStr = CollectionsKt.joinToString$default(collection, ";", null, null, 0, null, loadDataFromTile.2.INSTANCE, 30, null);
        iterable = this.suitableBlocks;
        guiMutantSpawnerSettings = this;
        iterable2 = iterable;
        object = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (Object object2 : iterable2) {
            int n = ((Number)object2).intValue();
            collection = object;
            string = "" + n;
            collection.add(string);
        }
        collection = (List)object;
        guiMutantSpawnerSettings.suitableBlocksString = CollectionsKt.joinToString$default(collection, null, null, null, 0, null, loadDataFromTile.4.INSTANCE, 31, null);
        this.selectedConfigurationStrings = new String[this.MAX_CONFIGURATIONS];
        iterable = this.selectedConfigurations;
        int n = 0;
        for (Iterator<Object> iterator2 : iterable) {
            Object object2;
            int n2 = n++;
            object2 = (qman)((Object)iterator2);
            int n3 = n2;
            this.selectedConfigurationStrings[n3] = "" + ((qman)object2).getConfigurationName() + ':' + ((qman)object2).getWeight();
        }
        this.spawnEnabled = tileEntityMutantSpawner.getSpawnEnabled();
        String string3 = tileEntityMutantSpawner.getAuthor();
        if (string3 == null) {
            string3 = "";
        }
        this.author = string3;
        this.approved = tileEntityMutantSpawner.getWasApproved();
    }

    @Override
    public void func_73863_a(int n, int n2, float f) {
        int n3 = this.guiLeft;
        int n4 = this.guiTop;
        this.renderer.drawRect(owkq._o(n3), owkq._o(n4), 700.0, (double)this.lowestY - owkq._o(n4) + (double)140, (int)0xAA000000L);
        super.func_73863_a(n, n2, f);
        this.field_73886_k._a(this.errorString, n3 / 2 + 10, (this.lowestY - 90) / 2, 210, 0xFF0000);
        if (this.spawnEnabled) {
            this.field_73886_k._a("\u0422\u0435\u0441\u0442\u0438\u0440\u043e\u0432\u0430\u043d\u0438\u0435 \u0441\u043f\u0430\u0432\u043d\u0430 \u0432\u043a\u043b\u044e\u0447\u0435\u043d\u043e", n3 / 2 + 225, this.lowestY / 2 + 40, 210, 0xFF0000);
        }
    }

    private final boolean validateInputs() {
        this.errorString = "";
        McButton mcButton = this.confirmButton;
        if (mcButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("confirmButton");
        }
        mcButton.setEnabled(true);
        this.verify("\u041c\u0430\u043a\u0441\u0438\u043c\u0430\u043b\u044c\u043d\u044b\u0435 \u0437\u043d\u0430\u0447\u0435\u043d\u0438\u044f \u043d\u0435 \u043c\u043e\u0433\u0443\u0442 \u0431\u044b\u0442\u044c \u043c\u0435\u043d\u044c\u0448\u0435 \u043c\u0438\u043d\u0438\u043c\u0430\u043b\u044c\u043d\u044b\u0445!", new Function0<Boolean>(this){
            final /* synthetic */ GuiMutantSpawnerSettings this$0;

            public /* synthetic */ Object invoke() {
                return this.invoke();
            }

            public final boolean invoke() {
                return GuiMutantSpawnerSettings.access$getIntValues$p(this.this$0)[3] >= GuiMutantSpawnerSettings.access$getIntValues$p(this.this$0)[0];
            }
            {
                this.this$0 = guiMutantSpawnerSettings;
                super(0);
            }
        });
        this.verify("\u041c\u0430\u043a\u0441\u0438\u043c\u0430\u043b\u044c\u043d\u044b\u0435 \u0437\u043d\u0430\u0447\u0435\u043d\u0438\u044f \u043d\u0435 \u043c\u043e\u0433\u0443\u0442 \u0431\u044b\u0442\u044c \u043c\u0435\u043d\u044c\u0448\u0435 \u043c\u0438\u043d\u0438\u043c\u0430\u043b\u044c\u043d\u044b\u0445!", new Function0<Boolean>(this){
            final /* synthetic */ GuiMutantSpawnerSettings this$0;

            public /* synthetic */ Object invoke() {
                return this.invoke();
            }

            public final boolean invoke() {
                return GuiMutantSpawnerSettings.access$getIntValues$p(this.this$0)[4] >= GuiMutantSpawnerSettings.access$getIntValues$p(this.this$0)[1];
            }
            {
                this.this$0 = guiMutantSpawnerSettings;
                super(0);
            }
        });
        this.verify("\u041c\u0430\u043a\u0441\u0438\u043c\u0430\u043b\u044c\u043d\u044b\u0435 \u0437\u043d\u0430\u0447\u0435\u043d\u0438\u044f \u043d\u0435 \u043c\u043e\u0433\u0443\u0442 \u0431\u044b\u0442\u044c \u043c\u0435\u043d\u044c\u0448\u0435 \u043c\u0438\u043d\u0438\u043c\u0430\u043b\u044c\u043d\u044b\u0445!", new Function0<Boolean>(this){
            final /* synthetic */ GuiMutantSpawnerSettings this$0;

            public /* synthetic */ Object invoke() {
                return this.invoke();
            }

            public final boolean invoke() {
                return GuiMutantSpawnerSettings.access$getIntValues$p(this.this$0)[5] >= GuiMutantSpawnerSettings.access$getIntValues$p(this.this$0)[2];
            }
            {
                this.this$0 = guiMutantSpawnerSettings;
                super(0);
            }
        });
        this.verify("\u041c\u0430\u043a\u0441\u0438\u043c\u0430\u043b\u044c\u043d\u044b\u0435 \u0437\u043d\u0430\u0447\u0435\u043d\u0438\u044f \u043d\u0435 \u043c\u043e\u0433\u0443\u0442 \u0431\u044b\u0442\u044c \u043c\u0435\u043d\u044c\u0448\u0435 \u043c\u0438\u043d\u0438\u043c\u0430\u043b\u044c\u043d\u044b\u0445!", new Function0<Boolean>(this){
            final /* synthetic */ GuiMutantSpawnerSettings this$0;

            public /* synthetic */ Object invoke() {
                return this.invoke();
            }

            public final boolean invoke() {
                return GuiMutantSpawnerSettings.access$getIntValues$p(this.this$0)[8] >= GuiMutantSpawnerSettings.access$getIntValues$p(this.this$0)[7];
            }
            {
                this.this$0 = guiMutantSpawnerSettings;
                super(0);
            }
        });
        this.verify("\u0417\u043d\u0430\u0447\u0435\u043d\u0438\u0435 \u0442\u0438\u043f\u0430 \u0432\u0440\u0435\u043c\u0435\u043d\u0438 \u0441\u0443\u0442\u043e\u043a \u0434\u043e\u043b\u0436\u043d\u043e \u0431\u044b\u0442\u044c \u0432 \u043f\u0440\u0435\u0434\u0435\u043b\u0430\u0445 [1, 3]!", new Function0<Boolean>(this){
            final /* synthetic */ GuiMutantSpawnerSettings this$0;

            public /* synthetic */ Object invoke() {
                return this.invoke();
            }

            public final boolean invoke() {
                int n = GuiMutantSpawnerSettings.access$getIntValues$p(this.this$0)[9];
                return 1 <= n && n <= 3;
            }
            {
                this.this$0 = guiMutantSpawnerSettings;
                super(0);
            }
        });
        this.selectedConfigurations.clear();
        this.selectedConfigurations.addAll((Collection<qman>)this.parseConfigurationsStrings());
        this.suitableBlocks.clear();
        this.suitableBlocks.addAll((Collection<Integer>)this.parseSuitableBlocks());
        this.dungeons.clear();
        Iterable iterable = StringsKt.split$default((CharSequence)this.dungeonsStr, new String[]{";"}, false, 0, 6, null);
        HashSet<String> hashSet = this.dungeons;
        Iterable iterable2 = iterable;
        Collection collection = new ArrayList();
        Iterable iterable3 = iterable2;
        Iterator iterator2 = iterable3.iterator();
        while (iterator2.hasNext()) {
            String string;
            String string2;
            String string3;
            Object t;
            Object t2 = t = iterator2.next();
            String string4 = string3 = (string2 = (String)t2);
            if (string4 == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
            }
            if (owkq._a(((Object)StringsKt.trim((CharSequence)string4)).toString()) == null) continue;
            String string5 = string;
            collection.add(string5);
        }
        List list = (List)collection;
        hashSet.addAll(list);
        this.verify("\u0423\u043a\u0430\u0436\u0438\u0442\u0435 \u0445\u043e\u0442\u044f \u0431\u044b \u043e\u0434\u0438\u043d \u0431\u043b\u043e\u043a, \u043d\u0430 \u043a\u043e\u0442\u043e\u0440\u043e\u043c \u043c\u043e\u0433\u0443\u0442 \u043f\u043e\u044f\u0432\u043b\u044f\u0442\u044c\u0441\u044f \u043c\u043e\u043d\u0441\u0442\u0440\u044b!", new Function0<Boolean>(this){
            final /* synthetic */ GuiMutantSpawnerSettings this$0;

            public /* synthetic */ Object invoke() {
                return this.invoke();
            }

            public final boolean invoke() {
                Collection collection = GuiMutantSpawnerSettings.access$getSuitableBlocks$p(this.this$0);
                return !collection.isEmpty();
            }
            {
                this.this$0 = guiMutantSpawnerSettings;
                super(0);
            }
        });
        this.verify("\u0423\u043a\u0430\u0436\u0438\u0442\u0435 \u0445\u043e\u0442\u044f \u0431\u044b \u043e\u0434\u043d\u0443 \u043a\u043e\u043d\u0444\u0438\u0433\u0443\u0440\u0430\u0446\u0438\u044e \u0441\u043f\u0430\u0432\u043d\u0430.", new Function0<Boolean>(this){
            final /* synthetic */ GuiMutantSpawnerSettings this$0;

            public /* synthetic */ Object invoke() {
                return this.invoke();
            }

            public final boolean invoke() {
                Collection collection = GuiMutantSpawnerSettings.access$getSelectedConfigurations$p(this.this$0);
                return !collection.isEmpty() || GuiMutantSpawnerSettings.access$isSpecial$p(this.this$0);
            }
            {
                this.this$0 = guiMutantSpawnerSettings;
                super(0);
            }
        });
        McButton mcButton2 = this.confirmButton;
        if (mcButton2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("confirmButton");
        }
        return mcButton2.getEnabled();
    }

    private final List<Integer> parseSuitableBlocks() {
        ArrayList arrayList = new ArrayList();
        CharSequence charSequence2 = this.suitableBlocksString;
        if (charSequence2.length() > 0) {
            try {
                for (CharSequence charSequence2 : StringsKt.split$default((CharSequence)this.suitableBlocksString, new String[]{","}, false, 0, 6, null)) {
                    Collection collection = arrayList;
                    Object object = charSequence2;
                    CharSequence charSequence3 = object;
                    if (charSequence3 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
                    }
                    object = ((Object)StringsKt.trim(charSequence3)).toString();
                    object = Integer.parseInt((String)object);
                    collection.add(object);
                }
            }
            catch (Exception exception) {
                this.verify("\u041d\u0435\u043a\u043e\u0440\u0440\u0435\u043a\u0442\u043d\u044b\u0439 \u0444\u043e\u0440\u043c\u0430\u0442 \u0441\u0442\u0440\u043e\u043a\u0438 \u0441 \u043f\u0435\u0440\u0435\u0447\u0438\u0441\u043b\u0435\u043d\u0438\u0435\u043c ID \u0431\u043b\u043e\u043a\u043e\u0432, \u043d\u0430 \u043a\u043e\u0442\u043e\u0440\u044b\u0445 \u043c\u043e\u0433\u0443\u0442 \u043f\u043e\u044f\u0432\u043b\u044f\u0442\u044c\u0441\u044f \u043c\u043e\u043d\u0441\u0442\u0440\u044b.", parseSuitableBlocks.1.INSTANCE);
            }
        }
        return arrayList;
    }

    /*
     * Could not resolve type clashes
     * Unable to fully structure code
     */
    private final List<MutantSpawnEntryInfo> parseConfigurationsStrings() {
        var1_1 = new ArrayList<E>();
        var2_2 = false;
        try {
            for (String var4_4 : ArraysKt.filterNotNull((Object[])this.selectedConfigurationStrings)) {
                v0 = var5_7 = (String)StringsKt.split$default((CharSequence)var4_4, new String[]{":"}, false, 0, 6, null).get(0);
                if (v0 == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
                }
                var6_8 = StringsKt.trim((CharSequence)v0).toString();
                v1 = (String)CollectionsKt.getOrNull(StringsKt.split$default((CharSequence)var4_4, new String[]{":"}, false, 0, 6, null), 1);
                if (v1 == null) ** GOTO lbl-1000
                var7_9 = v1;
                v2 = var7_9;
                if (v2 == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
                }
                v1 = StringsKt.trim((CharSequence)v2).toString();
                if (v1 != null) {
                    var7_9 = v1;
                    v3 = Float.parseFloat((String)var7_9);
                } else lbl-1000:
                // 2 sources

                {
                    v3 = 1.0f;
                }
                var5_6 = v3;
                var7_9 = new MutantSpawnEntryInfo(var6_8, var5_6);
                if (var7_9.getConfigurationClient() != null) {
                    var8_10 = var1_1;
                    var9_11 = new MutantSpawnEntryInfo(var6_8, var5_6);
                    var8_10.add(var9_11);
                    continue;
                }
                var2_2 = true;
            }
            if (var2_2) {
                throw (Throwable)new RuntimeException();
            }
        }
        catch (Exception var4_5) {
            this.verify("\u041d\u0435\u043a\u043e\u0440\u0440\u0435\u043a\u0442\u043d\u044b\u0439 \u0444\u043e\u0440\u043c\u0430\u0442 \u0441\u0442\u0440\u043e\u043a\u0438 \u0441 \u043a\u043e\u043d\u0444\u0438\u0433\u0443\u0440\u0430\u0446\u0438\u044f\u043c\u0438 \u043c\u043e\u043d\u0441\u0442\u0440\u043e\u0432.", parseConfigurationsStrings.1.INSTANCE);
        }
        return var1_1;
    }

    private final boolean verify(String string, Function0<Boolean> function0) {
        if (!function0.invoke().booleanValue()) {
            CharSequence charSequence = this.errorString;
            if (charSequence.length() == 0) {
                this.errorString = string;
            }
            McButton mcButton = this.confirmButton;
            if (mcButton == null) {
                Intrinsics.throwUninitializedPropertyAccessException("confirmButton");
            }
            mcButton.setEnabled(false);
            return false;
        }
        return true;
    }

    @NotNull
    public final ozlu getWorld() {
        return this.world;
    }

    public final int getX() {
        return this.x;
    }

    public final int getY() {
        return this.y;
    }

    public final int getZ() {
        return this.z;
    }

    public GuiMutantSpawnerSettings(@NotNull ozlu ozlu2, int n, int n2, int n3) {
        Intrinsics.checkParameterIsNotNull(ozlu2, "world");
        super(GuiComponent.hdRenderer, 700, 500);
        this.world = ozlu2;
        this.x = n;
        this.y = n2;
        this.z = n3;
        this.MAX_CONFIGURATIONS = 20;
        Object[] objectArray = new Integer[]{-2, -2, -2, 2, 2, 2, 8, 100, 1000, 3};
        GuiMutantSpawnerSettings guiMutantSpawnerSettings = this;
        Object object = objectArray;
        guiMutantSpawnerSettings.intValues = (Integer[])object;
        guiMutantSpawnerSettings = this;
        guiMutantSpawnerSettings.suitableBlocks = object = new ArrayList();
        guiMutantSpawnerSettings = this;
        guiMutantSpawnerSettings.selectedConfigurations = object = new ArrayList();
        objectArray = new String[]{"\u041a\u043e\u0440\u043e\u0431\u043a\u0430 minX", "\u041a\u043e\u0440\u043e\u0431\u043a\u0430 minY", "\u041a\u043e\u0440\u043e\u0431\u043a\u0430 minZ", "\u041a\u043e\u0440\u043e\u0431\u043a\u0430 maxX", "\u041a\u043e\u0440\u043e\u0431\u043a\u0430 maxY", "\u041a\u043e\u0440\u043e\u0431\u043a\u0430 maxZ", "\u041c\u0430\u043a\u0441.\u0441\u0443\u0449\u043d\u043e\u0441\u0442\u0435\u0439", "\u041a\u0443\u043b\u0434\u0430\u0443\u043d \u0441\u043f\u0430\u0432\u043d\u0430 \u043c\u0438\u043d. (\u0432 \u0442\u0438\u043a\u0430\u0445)", "\u041a\u0443\u043b\u0434\u0430\u0443\u043d \u0441\u043f\u0430\u0432\u043d\u0430 \u043c\u0430\u043a\u0441. (\u0432 \u0442\u0438\u043a\u0430\u0445))", "\u0412\u0440\u0435\u043c\u044f (1 \u0434\u0435\u043d\u044c, 2 \u043d\u043e\u0447\u044c, 3 \u0432\u0441\u0435\u0433\u0434\u0430)"};
        guiMutantSpawnerSettings = this;
        object = objectArray;
        guiMutantSpawnerSettings.intLabels = (String[])object;
        guiMutantSpawnerSettings = this;
        guiMutantSpawnerSettings.dungeons = object = new HashSet();
        this.dungeonsStr = "";
        this.suitableBlocksString = "";
        this.selectedConfigurationStrings = new String[this.MAX_CONFIGURATIONS];
        this.errorString = "";
        this.author = "";
    }

    public static final /* synthetic */ boolean access$validateInputs(GuiMutantSpawnerSettings guiMutantSpawnerSettings) {
        return guiMutantSpawnerSettings.validateInputs();
    }

    @NotNull
    public static final /* synthetic */ Integer[] access$getIntValues$p(GuiMutantSpawnerSettings guiMutantSpawnerSettings) {
        return guiMutantSpawnerSettings.intValues;
    }

    public static final /* synthetic */ void access$updateTileAabb(GuiMutantSpawnerSettings guiMutantSpawnerSettings) {
        guiMutantSpawnerSettings.updateTileAabb();
    }

    @NotNull
    public static final /* synthetic */ String access$getSuitableBlocksString$p(GuiMutantSpawnerSettings guiMutantSpawnerSettings) {
        return guiMutantSpawnerSettings.suitableBlocksString;
    }

    public static final /* synthetic */ void access$setSuitableBlocksString$p(GuiMutantSpawnerSettings guiMutantSpawnerSettings, @NotNull String string) {
        guiMutantSpawnerSettings.suitableBlocksString = string;
    }

    @NotNull
    public static final /* synthetic */ String[] access$getSelectedConfigurationStrings$p(GuiMutantSpawnerSettings guiMutantSpawnerSettings) {
        return guiMutantSpawnerSettings.selectedConfigurationStrings;
    }

    public static final /* synthetic */ void access$setSelectedConfigurationStrings$p(GuiMutantSpawnerSettings guiMutantSpawnerSettings, @NotNull String[] stringArray) {
        guiMutantSpawnerSettings.selectedConfigurationStrings = stringArray;
    }

    public static final /* synthetic */ boolean access$getShouldSendData$p(GuiMutantSpawnerSettings guiMutantSpawnerSettings) {
        return guiMutantSpawnerSettings.shouldSendData;
    }

    public static final /* synthetic */ void access$setShouldSendData$p(GuiMutantSpawnerSettings guiMutantSpawnerSettings, boolean bl) {
        guiMutantSpawnerSettings.shouldSendData = bl;
    }

    @NotNull
    public static final /* synthetic */ String access$getDungeonsStr$p(GuiMutantSpawnerSettings guiMutantSpawnerSettings) {
        return guiMutantSpawnerSettings.dungeonsStr;
    }

    public static final /* synthetic */ void access$setDungeonsStr$p(GuiMutantSpawnerSettings guiMutantSpawnerSettings, @NotNull String string) {
        guiMutantSpawnerSettings.dungeonsStr = string;
    }

    public static final /* synthetic */ boolean access$getSpawnEnabled$p(GuiMutantSpawnerSettings guiMutantSpawnerSettings) {
        return guiMutantSpawnerSettings.spawnEnabled;
    }

    public static final /* synthetic */ void access$setSpawnEnabled$p(GuiMutantSpawnerSettings guiMutantSpawnerSettings, boolean bl) {
        guiMutantSpawnerSettings.spawnEnabled = bl;
    }

    public static final /* synthetic */ boolean access$getApproved$p(GuiMutantSpawnerSettings guiMutantSpawnerSettings) {
        return guiMutantSpawnerSettings.approved;
    }

    public static final /* synthetic */ void access$setApproved$p(GuiMutantSpawnerSettings guiMutantSpawnerSettings, boolean bl) {
        guiMutantSpawnerSettings.approved = bl;
    }

    @NotNull
    public static final /* synthetic */ String access$getAuthor$p(GuiMutantSpawnerSettings guiMutantSpawnerSettings) {
        return guiMutantSpawnerSettings.author;
    }

    public static final /* synthetic */ void access$setAuthor$p(GuiMutantSpawnerSettings guiMutantSpawnerSettings, @NotNull String string) {
        guiMutantSpawnerSettings.author = string;
    }

    @NotNull
    public static final /* synthetic */ ArrayList access$getSuitableBlocks$p(GuiMutantSpawnerSettings guiMutantSpawnerSettings) {
        return guiMutantSpawnerSettings.suitableBlocks;
    }

    public static final /* synthetic */ boolean access$isSpecial$p(GuiMutantSpawnerSettings guiMutantSpawnerSettings) {
        return guiMutantSpawnerSettings.isSpecial;
    }

    public static final /* synthetic */ void access$setSpecial$p(GuiMutantSpawnerSettings guiMutantSpawnerSettings, boolean bl) {
        guiMutantSpawnerSettings.isSpecial = bl;
    }

    @NotNull
    public static final /* synthetic */ ArrayList access$getSelectedConfigurations$p(GuiMutantSpawnerSettings guiMutantSpawnerSettings) {
        return guiMutantSpawnerSettings.selectedConfigurations;
    }
}

