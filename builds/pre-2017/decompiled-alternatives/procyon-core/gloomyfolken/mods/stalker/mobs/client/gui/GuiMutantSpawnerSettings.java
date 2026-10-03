// 
// Decompiled by Procyon v0.6.0
// 

package gloomyfolken.mods.stalker.mobs.client.gui;

import kotlin.collections.ArraysKt;
import gloomyfolken.mods.stalker.mobs.spawn.MutantSpawnEntryInfo;
import kotlin.text.StringsKt;
import kotlin.jvm.functions.Function0;
import java.util.Iterator;
import kotlin.jvm.functions.Function1;
import java.util.List;
import kotlin.collections.CollectionsKt;
import gloomyfolken.mods.stalker.mobs.spawn.MutantSpawnerConfiguration;
import java.util.Collection;
import gloomyfolken.mods.stalker.mobs.packet.PacketEditTileConfig;
import gloomyfolken.mods.core.client.gui.engine.ActionManager;
import gloomyfolken.mods.core.client.gui.engine.GuiRendererBuilder;
import gloomyfolken.mods.core.client.gui.engine.action.GuiActionCheckboxToggle;
import gloomyfolken.mods.core.client.gui.engine.component.McCheckBox;
import gloomyfolken.mods.core.client.gui.engine.style.ComponentStyle;
import gloomyfolken.mods.core.client.gui.engine.style.ComponentCheckboxStyle;
import gloomyfolken.mods.core.client.gui.engine.Point;
import kotlin.jvm.internal.Intrinsics;
import gloomyfolken.mods.core.client.gui.engine.action.GuiActionTextAreaChanged;
import gloomyfolken.mods.core.client.gui.engine.component.McTextArea;
import gloomyfolken.mods.core.client.gui.engine.action.GuiActionTextFieldChanged;
import gloomyfolken.mods.core.client.gui.engine.action.GuiAction;
import gloomyfolken.mods.core.client.gui.engine.IActionHandler;
import gloomyfolken.mods.core.client.gui.engine.action.GuiActionButtonClick;
import gloomyfolken.mods.core.client.gui.engine.component.GuiComponent;
import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.component.McLabel;
import gloomyfolken.mods.core.client.gui.engine.component.McNumberField;
import gloomyfolken.mods.core.client.gui.engine.IAdvancedGui;
import kotlin.jvm.internal.Ref$IntRef;
import org.lwjgl.input.Keyboard;
import gloomyfolken.mods.stalker.mobs.tile.TileEntityMutantSpawner;
import gloomyfolken.mods.stalker.mobs.tile.TileEntityMutantSpawnerSpecial;
import kotlin.TypeCastException;
import org.jetbrains.annotations.NotNull;
import gloomyfolken.mods.core.client.gui.engine.component.McButton;
import java.util.HashSet;
import java.util.ArrayList;
import kotlin.Metadata;
import gloomyfolken.mods.core.client.gui.engine.GuiScreenAdvanced;

@Metadata(mv = { 1, 1, 7 }, bv = { 1, 0, 2 }, k = 1, d1 = { "\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005?\u0006\u0002\u0010\bJ \u0010+\u001a\u00020,2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010-\u001a\u00020.H\u0016J\b\u0010/\u001a\u00020,H\u0016J\u0006\u00100\u001a\u00020\u000bJ\b\u00101\u001a\u00020,H\u0002J\b\u00102\u001a\u00020,H\u0016J\u000e\u00103\u001a\b\u0012\u0004\u0012\u00020504H\u0002J\u000e\u00106\u001a\b\u0012\u0004\u0012\u00020\u000504H\u0002J\b\u00107\u001a\u00020,H\u0002J\b\u00108\u001a\u00020\u000bH\u0002J\u001e\u00109\u001a\u00020\u000b2\u0006\u0010:\u001a\u00020\r2\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u000b0<H\u0002R\u000e\u0010\t\u001a\u00020\u0005X\u0082D?\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e?\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e?\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.?\u0006\u0002\n\u0000R\u001e\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\r0\u0011j\b\u0012\u0004\u0012\u00020\r`\u0012X\u0082\u0004?\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\rX\u0082\u000e?\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\rX\u0082\u000e?\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\r0\u0016X\u0082\u000e?\u0006\u0004\n\u0002\u0010\u0017R\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\u0016X\u0082\u0004?\u0006\u0004\n\u0002\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u000bX\u0082\u000e?\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u0082\u000e?\u0006\u0002\n\u0000R\u0018\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0016X\u0082\u000e?\u0006\u0004\n\u0002\u0010\u0017R\u001e\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u001f0\u001ej\b\u0012\u0004\u0012\u00020\u001f` X\u0082\u0004?\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u000bX\u0082\u000e?\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u000bX\u0082\u000e?\u0006\u0002\n\u0000R\u001e\u0010#\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u001ej\b\u0012\u0004\u0012\u00020\u0005` X\u0082\u0004?\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\rX\u0082\u000e?\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003?\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\u0004\u001a\u00020\u0005?\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010\u0006\u001a\u00020\u0005?\u0006\b\n\u0000\u001a\u0004\b)\u0010(R\u0011\u0010\u0007\u001a\u00020\u0005?\u0006\b\n\u0000\u001a\u0004\b*\u0010(?\u0006=" }, d2 = { "Lgloomyfolken/mods/stalker/mobs/client/gui/GuiMutantSpawnerSettings;", "Lgloomyfolken/mods/core/client/gui/engine/GuiScreenAdvanced;", "world", "Lnet/minecraft/world/World;", "x", "", "y", "z", "(Lnet/minecraft/world/World;III)V", "MAX_CONFIGURATIONS", "approved", "", "author", "", "confirmButton", "Lgloomyfolken/mods/core/client/gui/engine/component/McButton;", "dungeons", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "dungeonsStr", "errorString", "intLabels", "", "[Ljava/lang/String;", "intValues", "[Ljava/lang/Integer;", "isSpecial", "lowestY", "selectedConfigurationStrings", "selectedConfigurations", "Ljava/util/ArrayList;", "Lgloomyfolken/mods/core/spawn/EntitySpawnEntryInfo;", "Lkotlin/collections/ArrayList;", "shouldSendData", "spawnEnabled", "suitableBlocks", "suitableBlocksString", "getWorld", "()Lnet/minecraft/world/World;", "getX", "()I", "getY", "getZ", "drawScreen", "", "frame", "", "initGui", "isEditorOpped", "loadDataFromTile", "onGuiClosed", "parseConfigurationsStrings", "", "Lgloomyfolken/mods/stalker/mobs/spawn/MutantSpawnEntryInfo;", "parseSuitableBlocks", "updateTileAabb", "validateInputs", "verify", "message", "condition", "Lkotlin/Function0;", "minecraft" })
public final class GuiMutantSpawnerSettings extends GuiScreenAdvanced
{
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
    
    public void func_73866_w_() {
        super.func_73866_w_();
        final int guiLeft = super.guiLeft;
        final int guiTop = super.guiTop;
        this.loadDataFromTile();
        final hurg func_72796_p = this.world.func_72796_p(this.x, this.y, this.z);
        if (func_72796_p == null) {
            throw new TypeCastException("null cannot be cast to non-null type gloomyfolken.mods.stalker.mobs.tile.TileEntityMutantSpawner");
        }
        this.isSpecial = (((TileEntityMutantSpawner)func_72796_p) instanceof TileEntityMutantSpawnerSpecial);
        Keyboard.enableRepeatEvents(true);
        final int n = guiLeft + 20;
        final int n2 = guiTop + 20;
        final int n3 = n + 260;
        final int n4 = 100;
        final int n5 = 20;
        final Ref$IntRef ref$IntRef = new Ref$IntRef();
        ref$IntRef.element = 20;
        final Object[] array = this.intValues;
        int n6 = 0;
        for (int i = 0; i < array.length; ++i) {
            final Object o = array[i];
            final int n7 = n6++;
            final int intValue = ((Number)o).intValue();
            final int n8 = n7;
            final McNumberField mcNumberField = new McNumberField((IAdvancedGui)this, n3, n2 + n8 * n5, n4, 20);
            mcNumberField.setNumber(intValue);
            if (n8 < 6) {
                mcNumberField.setMinValue(-128L);
                mcNumberField.setMaxValue(128L);
            }
            else {
                mcNumberField.setMinValue(0L);
            }
            if (n8 == 6) {
                mcNumberField.setMaxValue(256L);
            }
            ((GuiComponent)mcNumberField).userData = n8;
            final McButton mcButton = new McButton((IAdvancedGui)this, n3 - 22, n2 + n8 * n5, "-");
            final McButton mcButton2 = new McButton((IAdvancedGui)this, n3 + n4 + 2, n2 + n8 * n5, "+");
            final McLabel mcLabel = new McLabel((IAdvancedGui)this, this.intLabels[n8] + ":", n, n2 + n8 * n5);
            final Object[] array2 = { mcButton, mcButton2 };
            for (int j = 0; j < array2.length; ++j) {
                ((McButton)array2[j]).setSize(new Dimension(20, 20));
            }
            final Object[] array3 = { (GuiComponent)mcButton, (GuiComponent)mcButton2, (GuiComponent)mcNumberField, (GuiComponent)mcLabel };
            for (int k = 0; k < array3.length; ++k) {
                this.addElement((GuiComponent)array3[k]);
            }
            if (this.isSpecial && n8 < 7) {
                final Object[] array4 = { (GuiComponent)mcButton, (GuiComponent)mcButton2, (GuiComponent)mcNumberField, (GuiComponent)mcLabel };
                for (int l = 0; l < array4.length; ++l) {
                    ((GuiComponent)array4[l]).setEnabled(false);
                }
            }
            super.actionManager.registerActionHandler((GuiComponent)mcButton, (Class)GuiActionButtonClick.class, (IActionHandler)new IActionHandler<GuiActionButtonClick>(mcNumberField, this, n3, n2, n5, n4, n, ref$IntRef) {
                public final void processAction(final GuiActionButtonClick guiActionButtonClick) {
                    this.$component.setNumber(this.$component.getValue() - 1);
                    this.this$0.validateInputs();
                }
            });
            super.actionManager.registerActionHandler((GuiComponent)mcButton2, (Class)GuiActionButtonClick.class, (IActionHandler)new IActionHandler<GuiActionButtonClick>(mcNumberField, this, n3, n2, n5, n4, n, ref$IntRef) {
                public final void processAction(final GuiActionButtonClick guiActionButtonClick) {
                    this.$component.setNumber(this.$component.getValue() + 1);
                    this.this$0.validateInputs();
                }
            });
            super.actionManager.registerActionHandler((GuiComponent)mcNumberField, (Class)GuiActionTextFieldChanged.class, (IActionHandler)new IActionHandler<GuiActionTextFieldChanged>(this, n3, n2, n5, n4, n, ref$IntRef) {
                public final void processAction(final GuiActionTextFieldChanged guiActionTextFieldChanged) {
                    final GuiComponent component = ((GuiAction)guiActionTextFieldChanged).component;
                    if (component == null) {
                        throw new TypeCastException("null cannot be cast to non-null type gloomyfolken.mods.core.client.gui.engine.component.McNumberField");
                    }
                    final McNumberField mcNumberField = (McNumberField)component;
                    final Integer[] access$getIntValues$p = GuiMutantSpawnerSettings.access$getIntValues$p(this.this$0);
                    final Object userData = ((GuiComponent)mcNumberField).userData;
                    if (userData == null) {
                        throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
                    }
                    access$getIntValues$p[userData] = (int)mcNumberField.getValue();
                    this.this$0.validateInputs();
                    this.this$0.updateTileAabb();
                }
            });
            final Ref$IntRef ref$IntRef2 = ref$IntRef;
            ref$IntRef2.element += n5;
        }
        if (!this.isSpecial) {
            this.addElement((GuiComponent)new McLabel((IAdvancedGui)this, "\u0421\u043f\u0438\u0441\u043e\u043a id \u0440\u0430\u0437\u0440\u0435\u0448\u0435\u043d\u043d\u044b\u0445 \u0431\u043b\u043e\u043a\u043e\u0432 (\u0447\u0435\u0440\u0435\u0437 \u0437\u0430\u043f\u044f\u0442\u0443\u044e):", n, n2 + ref$IntRef.element));
            this.addElement((GuiComponent)new McLabel((IAdvancedGui)this, "\u041d\u0430 \u044d\u0442\u0438\u0445 \u0431\u043b\u043e\u043a\u0430\u0445 \u0441\u043c\u043e\u0433\u0443\u0442 \u0441\u043f\u0430\u0432\u043d\u0438\u0442\u044c\u0441\u044f \u0441\u0443\u0449\u043d\u043e\u0441\u0442\u0438:", n, n2 + ref$IntRef.element + 20));
            final McTextArea mcTextArea = new McTextArea((IAdvancedGui)this, n, n2 + ref$IntRef.element + 40, 350, 64);
            mcTextArea.setText(this.suitableBlocksString);
            super.actionManager.registerActionHandler((GuiComponent)mcTextArea, (Class)GuiActionTextAreaChanged.class, (IActionHandler)new GuiMutantSpawnerSettings$initGui.GuiMutantSpawnerSettings$initGui$2(this));
            mcTextArea.isEditable = true;
            this.addElement((GuiComponent)mcTextArea);
        }
        final int n9 = n3 + n4 + 70;
        int n10 = 0;
        final int n11 = this.MAX_CONFIGURATIONS - 1;
        if (n10 <= n11) {
            while (!this.isSpecial) {
                final GuiMutantSpawnerSettings$initGui$nameField.GuiMutantSpawnerSettings$initGui$nameField$1 guiMutantSpawnerSettings$initGui$nameField$1 = new GuiMutantSpawnerSettings$initGui$nameField.GuiMutantSpawnerSettings$initGui$nameField$1(this, n9, n2, n10, n5, (IAdvancedGui)this, n9, n2 + 40 + n10 * n5, 220, 20);
                ((GuiComponent)guiMutantSpawnerSettings$initGui$nameField$1).userData = n10;
                final GuiMutantSpawnerSettings$initGui$nameField.GuiMutantSpawnerSettings$initGui$nameField$1 guiMutantSpawnerSettings$initGui$nameField$2 = guiMutantSpawnerSettings$initGui$nameField$1;
                final String s = this.selectedConfigurationStrings[n10];
                final GuiMutantSpawnerSettings$initGui$nameField.GuiMutantSpawnerSettings$initGui$nameField$1 guiMutantSpawnerSettings$initGui$nameField$3 = guiMutantSpawnerSettings$initGui$nameField$2;
                String text;
                if ((text = s) == null) {
                    text = "";
                }
                guiMutantSpawnerSettings$initGui$nameField$3.setText(text);
                super.actionManager.registerActionHandler((GuiComponent)guiMutantSpawnerSettings$initGui$nameField$1, (Class)GuiActionTextFieldChanged.class, (IActionHandler)new GuiMutantSpawnerSettings$initGui.GuiMutantSpawnerSettings$initGui$3(this));
                this.addElement((GuiComponent)guiMutantSpawnerSettings$initGui$nameField$1);
                if (n10 == n11) {
                    break;
                }
                ++n10;
            }
        }
        this.lowestY = n2 + 40 + (this.MAX_CONFIGURATIONS - 1) * n5;
        this.lowestY += 20;
        this.confirmButton = new McButton((IAdvancedGui)this, n, this.lowestY, "\u041f\u043e\u0434\u0442\u0432\u0435\u0440\u0434\u0438\u0442\u044c");
        final ActionManager actionManager = super.actionManager;
        final McButton confirmButton = this.confirmButton;
        if (confirmButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("confirmButton");
        }
        actionManager.registerActionHandler((GuiComponent)confirmButton, (Class)GuiActionButtonClick.class, (IActionHandler)new GuiMutantSpawnerSettings$initGui.GuiMutantSpawnerSettings$initGui$4(this));
        final McButton confirmButton2 = this.confirmButton;
        if (confirmButton2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("confirmButton");
        }
        final int n12 = 160;
        final McButton confirmButton3 = this.confirmButton;
        if (confirmButton3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("confirmButton");
        }
        confirmButton2.setSize(new Dimension(n12, confirmButton3.getSize().height));
        final McButton confirmButton4 = this.confirmButton;
        if (confirmButton4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("confirmButton");
        }
        this.addElement((GuiComponent)confirmButton4);
        final McButton mcButton3 = new McButton((IAdvancedGui)this, n + 170, this.lowestY, "\u041e\u0442\u043c\u0435\u043d\u0438\u0442\u044c");
        super.actionManager.registerActionHandler((GuiComponent)mcButton3, (Class)GuiActionButtonClick.class, (IActionHandler)new GuiMutantSpawnerSettings$initGui.GuiMutantSpawnerSettings$initGui$5(this));
        mcButton3.setSize(new Dimension(160, mcButton3.getSize().height));
        this.addElement((GuiComponent)mcButton3);
        final McButton mcButton4 = new McButton((IAdvancedGui)this, n, this.lowestY + 60, "\u0423\u0431\u0438\u0442\u044c \u0437\u0430\u0441\u043f\u0430\u0432\u043d\u0435\u043d\u043d\u044b\u0445 \u0441\u0443\u0449\u043d\u043e\u0441\u0442\u0435\u0439");
        super.actionManager.registerActionHandler((GuiComponent)mcButton4, (Class)GuiActionButtonClick.class, (IActionHandler)new GuiMutantSpawnerSettings$initGui.GuiMutantSpawnerSettings$initGui$6(this));
        this.addElement((GuiComponent)mcButton4);
        this.addElement((GuiComponent)new McLabel((IAdvancedGui)this, "\u0421\u0435\u0440\u0432\u0435\u0440\u0430 \u0434\u043b\u044f \u0441\u043f\u0430\u0432\u043d\u0430 (\u0441\u043f\u0430\u0432\u043d \u0432\u0435\u0437\u0434\u0435 \u0435\u0441\u043b\u0438 \u043f\u0443\u0441\u0442\u043e):", n, this.lowestY - 90));
        final McTextArea mcTextArea2 = new McTextArea((IAdvancedGui)this, n, this.lowestY - 70, 350, 64);
        mcTextArea2.setText(this.dungeonsStr);
        super.actionManager.registerActionHandler((GuiComponent)mcTextArea2, (Class)GuiActionTextAreaChanged.class, (IActionHandler)new GuiMutantSpawnerSettings$initGui.GuiMutantSpawnerSettings$initGui$7(this));
        mcTextArea2.isEditable = true;
        this.addElement((GuiComponent)mcTextArea2);
        this.lowestY -= 20;
        final McButton mcButton5 = new McButton((IAdvancedGui)this, n9, guiTop - 40, "\u0421\u043f\u0438\u0441\u043e\u043a \u043a\u043e\u043d\u0444\u0438\u0433\u0443\u0440\u0430\u0446\u0438\u0439");
        super.actionManager.registerActionHandler((GuiComponent)mcButton5, (Class)GuiActionButtonClick.class, (IActionHandler)GuiMutantSpawnerSettings$initGui.GuiMutantSpawnerSettings$initGui$8.INSTANCE);
        mcButton5.setSize(new Dimension(200, mcButton5.getSize().height));
        this.addElement((GuiComponent)mcButton5);
        if (this.isSpecial) {
            mcButton5.setLocation(new Point(mcButton5.getLocation().x, mcButton5.getLocation().y + 50));
            final McButton mcButton6 = new McButton((IAdvancedGui)this, n9, guiTop + 60, "\u0420\u0435\u0434\u0430\u043a\u0442\u0438\u0440\u043e\u0432\u0430\u0442\u044c \u043a\u043e\u043d\u0444\u0438\u0433\u0443\u0440\u0430\u0446\u0438\u044e");
            super.actionManager.registerActionHandler((GuiComponent)mcButton6, (Class)GuiActionButtonClick.class, (IActionHandler)GuiMutantSpawnerSettings$initGui.GuiMutantSpawnerSettings$initGui$9.INSTANCE);
            mcButton6.setSize(new Dimension(220, mcButton6.getSize().height));
            this.addElement((GuiComponent)mcButton6);
        }
        else {
            this.addElement((GuiComponent)new McLabel((IAdvancedGui)this, "\u0418\u043c\u044f \u043a\u043e\u043d\u0444\u0438\u0433\u0443\u0440\u0430\u0446\u0438\u0438:\u0432\u0435\u0441", n9, n2));
            this.addElement((GuiComponent)new McLabel((IAdvancedGui)this, "\u041f\u0440\u0438\u043c\u0435\u0440: dog_weak:15", n9, n2 + 20));
        }
        final McCheckBox mcCheckBox = new McCheckBox((IAdvancedGui)this, "\u0422\u0435\u0441\u0442\u0438\u0440\u043e\u0432\u0430\u0442\u044c \u0441\u043f\u0430\u0432\u043d", n9, this.lowestY + 60, (ComponentCheckboxStyle)ComponentStyle.VANILLA.getComponentStyle((Class)McCheckBox.class));
        super.actionManager.registerActionHandler((GuiComponent)mcCheckBox, (Class)GuiActionCheckboxToggle.class, (IActionHandler)new GuiMutantSpawnerSettings$initGui.GuiMutantSpawnerSettings$initGui$10(this));
        this.addElement((GuiComponent)mcCheckBox);
        mcCheckBox.setActive(this.spawnEnabled);
        final McCheckBox mcCheckBox2 = new McCheckBox((IAdvancedGui)this, "\u0421\u043f\u0430\u0432\u043d\u0435\u0440 \u0432\u0435\u0440\u0438\u0444\u0438\u0446\u0438\u0440\u043e\u0432\u0430\u043d (OP only)", n9, this.lowestY + 90, (ComponentCheckboxStyle)ComponentStyle.VANILLA.getComponentStyle((Class)McCheckBox.class));
        super.actionManager.registerActionHandler((GuiComponent)mcCheckBox2, (Class)GuiActionCheckboxToggle.class, (IActionHandler)new GuiMutantSpawnerSettings$initGui.GuiMutantSpawnerSettings$initGui$11(this));
        mcCheckBox2.setEnabled(this.isEditorOpped());
        this.addElement((GuiComponent)mcCheckBox2);
        mcCheckBox2.setActive(this.approved);
        mcCheckBox.setRenderer(new GuiRendererBuilder().setTextureSize(256, 256).create());
        mcCheckBox2.setRenderer(new GuiRendererBuilder().setTextureSize(256, 256).create());
        final McTextArea mcTextArea3 = new McTextArea((IAdvancedGui)this, n9, this.lowestY + 115, 200, 20);
        mcTextArea3.setText(this.author);
        super.actionManager.registerActionHandler((GuiComponent)mcTextArea3, (Class)GuiActionTextAreaChanged.class, (IActionHandler)new GuiMutantSpawnerSettings$initGui.GuiMutantSpawnerSettings$initGui$12(this));
        mcTextArea3.setEnabled(this.isEditorOpped());
        mcTextArea3.isEditable = this.isEditorOpped();
        this.addElement((GuiComponent)mcTextArea3);
        final McButton confirmButton5 = this.confirmButton;
        if (confirmButton5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("confirmButton");
        }
        confirmButton5.setEnabled(this.validateInputs());
    }
    
    public final boolean isEditorOpped() {
        return true;
    }
    
    private final void updateTileAabb() {
        final hurg func_72796_p = this.world.func_72796_p(this.x, this.y, this.z);
        if (func_72796_p == null) {
            throw new TypeCastException("null cannot be cast to non-null type gloomyfolken.mods.stalker.mobs.tile.TileEntityMutantSpawner");
        }
        final TileEntityMutantSpawner tileEntityMutantSpawner = (TileEntityMutantSpawner)func_72796_p;
        tileEntityMutantSpawner.setXMin((int)this.intValues[0]);
        tileEntityMutantSpawner.setYMin((int)this.intValues[1]);
        tileEntityMutantSpawner.setZMin((int)this.intValues[2]);
        tileEntityMutantSpawner.setXMax((int)this.intValues[3]);
        tileEntityMutantSpawner.setYMax((int)this.intValues[4]);
        tileEntityMutantSpawner.setZMax((int)this.intValues[5]);
    }
    
    public void func_73874_b() {
        super.func_73874_b();
        new PacketEditTileConfig(true).sendToServer();
        if (this.validateInputs() && this.shouldSendData) {
            final hurg func_72796_p = this.world.func_72796_p(this.x, this.y, this.z);
            if (func_72796_p == null) {
                throw new TypeCastException("null cannot be cast to non-null type gloomyfolken.mods.stalker.mobs.tile.TileEntityMutantSpawner");
            }
            final TileEntityMutantSpawner tileEntityMutantSpawner = (TileEntityMutantSpawner)func_72796_p;
            this.updateTileAabb();
            tileEntityMutantSpawner.getConfiguration().setMaxEntityCount((int)this.intValues[6]);
            tileEntityMutantSpawner.getConfiguration().setSpawnCooldownMin((long)this.intValues[7]);
            tileEntityMutantSpawner.getConfiguration().setSpawnCooldownMax((long)this.intValues[8]);
            tileEntityMutantSpawner.getConfiguration().getPossibleSpawnEntries().clear();
            tileEntityMutantSpawner.getConfiguration().getPossibleSpawnEntries().addAll(this.selectedConfigurations);
            tileEntityMutantSpawner.getConfiguration().getDungeons().clear();
            tileEntityMutantSpawner.getConfiguration().getDungeons().addAll(this.dungeons);
            final MutantSpawnerConfiguration configuration = tileEntityMutantSpawner.getConfiguration();
            final Collection collection = this.suitableBlocks;
            final MutantSpawnerConfiguration mutantSpawnerConfiguration = configuration;
            final Collection collection2 = collection;
            if (collection2 == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.util.Collection<T>");
            }
            final Collection collection3 = collection2;
            final Integer[] array = collection3.toArray(new Integer[collection3.size()]);
            if (array == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            mutantSpawnerConfiguration.setSufficientBlocks((Integer[])array);
            tileEntityMutantSpawner.getConfiguration().setDayOfTimeType((int)this.intValues[9]);
            tileEntityMutantSpawner.setSpawnEnabled(this.spawnEnabled);
            tileEntityMutantSpawner.setAuthor(this.author);
            tileEntityMutantSpawner.setWasApproved(this.approved);
            final qoac qoac = new qoac();
            tileEntityMutantSpawner.func_70310_b(qoac);
            new ncxk(qoac, this.x, this.y, this.z, 0).sendToServer();
        }
        new ncxk((qoac)null, this.x, this.y, this.z, 3).sendToServer();
    }
    
    private final void loadDataFromTile() {
        final hurg func_72796_p = this.world.func_72796_p(this.x, this.y, this.z);
        if (func_72796_p == null) {
            throw new TypeCastException("null cannot be cast to non-null type gloomyfolken.mods.stalker.mobs.tile.TileEntityMutantSpawner");
        }
        final TileEntityMutantSpawner tileEntityMutantSpawner = (TileEntityMutantSpawner)func_72796_p;
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
        this.selectedConfigurations.addAll(tileEntityMutantSpawner.getConfiguration().getPossibleSpawnEntries());
        this.dungeons.clear();
        this.dungeons.addAll((Collection<?>)tileEntityMutantSpawner.getConfiguration().getDungeons());
        final Iterable iterable;
        final Collection collection = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable = this.dungeons, 10));
        final Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            collection.add(iterator.next());
        }
        this.dungeonsStr = CollectionsKt.joinToString$default((Iterable)collection, (CharSequence)";", (CharSequence)null, (CharSequence)null, 0, (CharSequence)null, (Function1)GuiMutantSpawnerSettings$loadDataFromTile.GuiMutantSpawnerSettings$loadDataFromTile$2.INSTANCE, 30, (Object)null);
        final Iterable iterable2;
        final Collection collection2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable2 = this.suitableBlocks, 10));
        final Iterator iterator2 = iterable2.iterator();
        while (iterator2.hasNext()) {
            collection2.add("" + ((Number)iterator2.next()).intValue());
        }
        this.suitableBlocksString = CollectionsKt.joinToString$default((Iterable)collection2, (CharSequence)null, (CharSequence)null, (CharSequence)null, 0, (CharSequence)null, (Function1)GuiMutantSpawnerSettings$loadDataFromTile.GuiMutantSpawnerSettings$loadDataFromTile$4.INSTANCE, 31, (Object)null);
        this.selectedConfigurationStrings = new String[this.MAX_CONFIGURATIONS];
        final Iterable iterable3 = this.selectedConfigurations;
        int n = 0;
        for (final Object next : iterable3) {
            final int n2 = n++;
            final qman qman = (qman)next;
            this.selectedConfigurationStrings[n2] = "" + qman.getConfigurationName() + ':' + qman.getWeight();
        }
        this.spawnEnabled = tileEntityMutantSpawner.getSpawnEnabled();
        String author;
        if ((author = tileEntityMutantSpawner.getAuthor()) == null) {
            author = "";
        }
        this.author = author;
        this.approved = tileEntityMutantSpawner.getWasApproved();
    }
    
    public void func_73863_a(final int n, final int n2, final float n3) {
        final int guiLeft = super.guiLeft;
        final int guiTop = super.guiTop;
        super.renderer.drawRect(owkq._o(guiLeft), owkq._o(guiTop), 700.0, this.lowestY - owkq._o(guiTop) + 140, (int)2852126720L);
        super.func_73863_a(n, n2, n3);
        ((gqjz)this).field_73886_k._a(this.errorString, guiLeft / 2 + 10, (this.lowestY - 90) / 2, 210, 16711680);
        if (this.spawnEnabled) {
            ((gqjz)this).field_73886_k._a("\u0422\u0435\u0441\u0442\u0438\u0440\u043e\u0432\u0430\u043d\u0438\u0435 \u0441\u043f\u0430\u0432\u043d\u0430 \u0432\u043a\u043b\u044e\u0447\u0435\u043d\u043e", guiLeft / 2 + 225, this.lowestY / 2 + 40, 210, 16711680);
        }
    }
    
    private final boolean validateInputs() {
        this.errorString = "";
        final McButton confirmButton = this.confirmButton;
        if (confirmButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("confirmButton");
        }
        confirmButton.setEnabled(true);
        this.verify("\u041c\u0430\u043a\u0441\u0438\u043c\u0430\u043b\u044c\u043d\u044b\u0435 \u0437\u043d\u0430\u0447\u0435\u043d\u0438\u044f \u043d\u0435 \u043c\u043e\u0433\u0443\u0442 \u0431\u044b\u0442\u044c \u043c\u0435\u043d\u044c\u0448\u0435 \u043c\u0438\u043d\u0438\u043c\u0430\u043b\u044c\u043d\u044b\u0445!", (Function0<Boolean>)new GuiMutantSpawnerSettings$validateInputs.GuiMutantSpawnerSettings$validateInputs$1(this));
        this.verify("\u041c\u0430\u043a\u0441\u0438\u043c\u0430\u043b\u044c\u043d\u044b\u0435 \u0437\u043d\u0430\u0447\u0435\u043d\u0438\u044f \u043d\u0435 \u043c\u043e\u0433\u0443\u0442 \u0431\u044b\u0442\u044c \u043c\u0435\u043d\u044c\u0448\u0435 \u043c\u0438\u043d\u0438\u043c\u0430\u043b\u044c\u043d\u044b\u0445!", (Function0<Boolean>)new GuiMutantSpawnerSettings$validateInputs.GuiMutantSpawnerSettings$validateInputs$2(this));
        this.verify("\u041c\u0430\u043a\u0441\u0438\u043c\u0430\u043b\u044c\u043d\u044b\u0435 \u0437\u043d\u0430\u0447\u0435\u043d\u0438\u044f \u043d\u0435 \u043c\u043e\u0433\u0443\u0442 \u0431\u044b\u0442\u044c \u043c\u0435\u043d\u044c\u0448\u0435 \u043c\u0438\u043d\u0438\u043c\u0430\u043b\u044c\u043d\u044b\u0445!", (Function0<Boolean>)new GuiMutantSpawnerSettings$validateInputs.GuiMutantSpawnerSettings$validateInputs$3(this));
        this.verify("\u041c\u0430\u043a\u0441\u0438\u043c\u0430\u043b\u044c\u043d\u044b\u0435 \u0437\u043d\u0430\u0447\u0435\u043d\u0438\u044f \u043d\u0435 \u043c\u043e\u0433\u0443\u0442 \u0431\u044b\u0442\u044c \u043c\u0435\u043d\u044c\u0448\u0435 \u043c\u0438\u043d\u0438\u043c\u0430\u043b\u044c\u043d\u044b\u0445!", (Function0<Boolean>)new GuiMutantSpawnerSettings$validateInputs.GuiMutantSpawnerSettings$validateInputs$4(this));
        this.verify("\u0417\u043d\u0430\u0447\u0435\u043d\u0438\u0435 \u0442\u0438\u043f\u0430 \u0432\u0440\u0435\u043c\u0435\u043d\u0438 \u0441\u0443\u0442\u043e\u043a \u0434\u043e\u043b\u0436\u043d\u043e \u0431\u044b\u0442\u044c \u0432 \u043f\u0440\u0435\u0434\u0435\u043b\u0430\u0445 [1, 3]!", (Function0<Boolean>)new GuiMutantSpawnerSettings$validateInputs.GuiMutantSpawnerSettings$validateInputs$5(this));
        this.selectedConfigurations.clear();
        this.selectedConfigurations.addAll((Collection<? extends qman>)this.parseConfigurationsStrings());
        this.suitableBlocks.clear();
        this.suitableBlocks.addAll(this.parseSuitableBlocks());
        this.dungeons.clear();
        final HashSet<String> dungeons = this.dungeons;
        final Iterable iterable = StringsKt.split$default((CharSequence)this.dungeonsStr, new String[] { ";" }, false, 0, 6, (Object)null);
        final HashSet<String> set = dungeons;
        final Iterable iterable2 = iterable;
        final Collection collection = new ArrayList<String>();
        for (final String s : iterable2) {
            if (s == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
            }
            final String a = owkq._a(StringsKt.trim((CharSequence)s).toString());
            if (a == null) {
                continue;
            }
            collection.add(a);
        }
        set.addAll((Collection<?>)(List<?>)collection);
        this.verify("\u0423\u043a\u0430\u0436\u0438\u0442\u0435 \u0445\u043e\u0442\u044f \u0431\u044b \u043e\u0434\u0438\u043d \u0431\u043b\u043e\u043a, \u043d\u0430 \u043a\u043e\u0442\u043e\u0440\u043e\u043c \u043c\u043e\u0433\u0443\u0442 \u043f\u043e\u044f\u0432\u043b\u044f\u0442\u044c\u0441\u044f \u043c\u043e\u043d\u0441\u0442\u0440\u044b!", (Function0<Boolean>)new GuiMutantSpawnerSettings$validateInputs.GuiMutantSpawnerSettings$validateInputs$7(this));
        this.verify("\u0423\u043a\u0430\u0436\u0438\u0442\u0435 \u0445\u043e\u0442\u044f \u0431\u044b \u043e\u0434\u043d\u0443 \u043a\u043e\u043d\u0444\u0438\u0433\u0443\u0440\u0430\u0446\u0438\u044e \u0441\u043f\u0430\u0432\u043d\u0430.", (Function0<Boolean>)new GuiMutantSpawnerSettings$validateInputs.GuiMutantSpawnerSettings$validateInputs$8(this));
        final McButton confirmButton2 = this.confirmButton;
        if (confirmButton2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("confirmButton");
        }
        return confirmButton2.getEnabled();
    }
    
    private final List<Integer> parseSuitableBlocks() {
        final ArrayList list = new ArrayList();
        if (this.suitableBlocksString.length() > 0) {
            try {
                for (final String s : StringsKt.split$default((CharSequence)this.suitableBlocksString, new String[] { "," }, false, 0, 6, (Object)null)) {
                    final Collection collection = list;
                    final String s2 = s;
                    if (s2 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
                    }
                    collection.add(Integer.parseInt(StringsKt.trim((CharSequence)s2).toString()));
                }
            }
            catch (final Exception ex) {
                this.verify("\u041d\u0435\u043a\u043e\u0440\u0440\u0435\u043a\u0442\u043d\u044b\u0439 \u0444\u043e\u0440\u043c\u0430\u0442 \u0441\u0442\u0440\u043e\u043a\u0438 \u0441 \u043f\u0435\u0440\u0435\u0447\u0438\u0441\u043b\u0435\u043d\u0438\u0435\u043c ID \u0431\u043b\u043e\u043a\u043e\u0432, \u043d\u0430 \u043a\u043e\u0442\u043e\u0440\u044b\u0445 \u043c\u043e\u0433\u0443\u0442 \u043f\u043e\u044f\u0432\u043b\u044f\u0442\u044c\u0441\u044f \u043c\u043e\u043d\u0441\u0442\u0440\u044b.", (Function0<Boolean>)GuiMutantSpawnerSettings$parseSuitableBlocks.GuiMutantSpawnerSettings$parseSuitableBlocks$1.INSTANCE);
            }
        }
        return list;
    }
    
    private final List<MutantSpawnEntryInfo> parseConfigurationsStrings() {
        final ArrayList list = new ArrayList();
        boolean b = false;
        try {
            for (final String s : ArraysKt.filterNotNull((Object[])this.selectedConfigurationStrings)) {
                final String s2 = StringsKt.split$default((CharSequence)s, new String[] { ":" }, false, 0, 6, (Object)null).get(0);
                if (s2 == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
                }
                final String string = StringsKt.trim((CharSequence)s2).toString();
                final String s3 = (String)CollectionsKt.getOrNull(StringsKt.split$default((CharSequence)s, new String[] { ":" }, false, 0, 6, (Object)null), 1);
                float float1 = 0.0f;
                Label_0185: {
                    if (s3 != null) {
                        final String s4 = s3;
                        if (s4 == null) {
                            throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
                        }
                        final String string2 = StringsKt.trim((CharSequence)s4).toString();
                        if (string2 != null) {
                            float1 = Float.parseFloat(string2);
                            break Label_0185;
                        }
                    }
                    float1 = 1.0f;
                }
                final float n = float1;
                if (new MutantSpawnEntryInfo(string, n).getConfigurationClient() != null) {
                    list.add(new MutantSpawnEntryInfo(string, n));
                }
                else {
                    b = true;
                }
            }
            if (b) {
                throw new RuntimeException();
            }
        }
        catch (final Exception ex) {
            this.verify("\u041d\u0435\u043a\u043e\u0440\u0440\u0435\u043a\u0442\u043d\u044b\u0439 \u0444\u043e\u0440\u043c\u0430\u0442 \u0441\u0442\u0440\u043e\u043a\u0438 \u0441 \u043a\u043e\u043d\u0444\u0438\u0433\u0443\u0440\u0430\u0446\u0438\u044f\u043c\u0438 \u043c\u043e\u043d\u0441\u0442\u0440\u043e\u0432.", (Function0<Boolean>)GuiMutantSpawnerSettings$parseConfigurationsStrings.GuiMutantSpawnerSettings$parseConfigurationsStrings$1.INSTANCE);
        }
        return list;
    }
    
    private final boolean verify(final String errorString, final Function0<Boolean> function0) {
        if (!(boolean)function0.invoke()) {
            if (this.errorString.length() == 0) {
                this.errorString = errorString;
            }
            final McButton confirmButton = this.confirmButton;
            if (confirmButton == null) {
                Intrinsics.throwUninitializedPropertyAccessException("confirmButton");
            }
            confirmButton.setEnabled(false);
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
    
    public GuiMutantSpawnerSettings(@NotNull final ozlu world, final int x, final int y, final int z) {
        Intrinsics.checkParameterIsNotNull((Object)world, "world");
        super(GuiComponent.hdRenderer, 700, 500);
        this.world = world;
        this.x = x;
        this.y = y;
        this.z = z;
        this.intValues = new Integer[] { -2, -2, -2, 2, 2, 2, 8, 100, 1000, 3 };
        this.suitableBlocks = new ArrayList<Integer>();
        this.selectedConfigurations = new ArrayList<qman>();
        this.intLabels = new String[] { "\u041a\u043e\u0440\u043e\u0431\u043a\u0430 minX", "\u041a\u043e\u0440\u043e\u0431\u043a\u0430 minY", "\u041a\u043e\u0440\u043e\u0431\u043a\u0430 minZ", "\u041a\u043e\u0440\u043e\u0431\u043a\u0430 maxX", "\u041a\u043e\u0440\u043e\u0431\u043a\u0430 maxY", "\u041a\u043e\u0440\u043e\u0431\u043a\u0430 maxZ", "\u041c\u0430\u043a\u0441.\u0441\u0443\u0449\u043d\u043e\u0441\u0442\u0435\u0439", "\u041a\u0443\u043b\u0434\u0430\u0443\u043d \u0441\u043f\u0430\u0432\u043d\u0430 \u043c\u0438\u043d. (\u0432 \u0442\u0438\u043a\u0430\u0445)", "\u041a\u0443\u043b\u0434\u0430\u0443\u043d \u0441\u043f\u0430\u0432\u043d\u0430 \u043c\u0430\u043a\u0441. (\u0432 \u0442\u0438\u043a\u0430\u0445))", "\u0412\u0440\u0435\u043c\u044f (1 \u0434\u0435\u043d\u044c, 2 \u043d\u043e\u0447\u044c, 3 \u0432\u0441\u0435\u0433\u0434\u0430)" };
        this.dungeons = new HashSet<String>();
        this.dungeonsStr = "";
        this.suitableBlocksString = "";
        this.selectedConfigurationStrings = new String[this.MAX_CONFIGURATIONS];
        this.errorString = "";
        this.author = "";
    }
    
    @NotNull
    public static final /* synthetic */ Integer[] access$getIntValues$p(final GuiMutantSpawnerSettings guiMutantSpawnerSettings) {
        return guiMutantSpawnerSettings.intValues;
    }
}
