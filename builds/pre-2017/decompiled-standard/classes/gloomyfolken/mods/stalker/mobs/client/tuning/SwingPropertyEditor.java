/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.mobs.client.tuning;

import com.google.gson.annotations.SerializedName;
import gloomyfolken.mods.stalker.mobs.client.tuning.EditorProperty;
import gloomyfolken.mods.stalker.mobs.client.tuning.EditorPropertyController;
import gloomyfolken.mods.stalker.mobs.client.tuning.EditorPropertyGroup;
import gloomyfolken.mods.stalker.mobs.client.tuning.SyntheticPropertyAnnotation;
import gloomyfolken.mods.stalker.mobs.entity.config.MutantConfigHelper;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.JTextComponent;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DoubleCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0004\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0005QRSTUB\u0005\u00a2\u0006\u0002\u0010\u0002J,\u0010&\u001a\u00020\n2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\r2\u0006\u0010*\u001a\u00020\u00142\n\u0010+\u001a\u0006\u0012\u0002\b\u00030\u0016H\u0002J\u0016\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010-\u001a\u00020\u0006H\u0002J\b\u0010.\u001a\u00020(H\u0002J0\u0010/\u001a\b\u0012\u0004\u0012\u0002000\u00162\u0006\u0010-\u001a\u0002012\u0006\u00102\u001a\u0002012\u0006\u00103\u001a\u0002012\b\b\u0002\u00104\u001a\u000201H\u0002J:\u00105\u001a\u00020(2\u0006\u00106\u001a\u0002002\n\u0010\u001b\u001a\u0006\u0012\u0002\b\u00030\u00042\u001c\u00107\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00160\t08H\u0002J \u00109\u001a\b\u0012\u0004\u0012\u00020:0\u00162\u0006\u0010-\u001a\u00020\u00142\b\b\u0002\u0010;\u001a\u00020\u0006H\u0002J$\u0010<\u001a\u0006\u0012\u0002\b\u00030\u00162\u0006\u0010=\u001a\u00020\u00142\u0006\u0010-\u001a\u00020\u00012\u0006\u0010>\u001a\u00020?H\u0002J\u0018\u0010@\u001a\u00020\n2\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020\u0006H\u0002J$\u0010D\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0016\u0018\u00010\t2\u0006\u0010>\u001a\u00020?2\u0006\u0010E\u001a\u00020FH\u0002J(\u0010G\u001a\u00020\n2\n\u0010+\u001a\u0006\u0012\u0002\b\u00030\u00162\u0006\u0010E\u001a\u00020F2\n\u0010H\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0002J$\u0010I\u001a\u00020\u00062\u0006\u0010E\u001a\u00020F2\u0006\u0010J\u001a\u00020\u00062\n\u0010H\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0002J$\u0010K\u001a\u00020L2\u0006\u0010E\u001a\u00020F2\u0006\u0010J\u001a\u00020L2\n\u0010H\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0002J$\u0010M\u001a\u00020\u00142\u0006\u0010E\u001a\u00020F2\u0006\u0010J\u001a\u00020\u00142\n\u0010H\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0002J8\u0010N\u001a\u00020 2\u0006\u0010\u000e\u001a\u00020\u000f2\u001e\b\u0002\u00107\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00160\t082\b\b\u0002\u0010\u0005\u001a\u00020\u0006JB\u0010N\u001a\u00020 2\u0006\u0010\u000e\u001a\u00020\u000f2\u001e\b\u0002\u00107\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00160\t082\b\b\u0002\u0010O\u001a\u00020\r2\b\b\u0002\u0010\u0005\u001a\u00020\u0006J8\u0010P\u001a\u00020 2\u0006\u0010\u000e\u001a\u00020\u000f2\u001e\b\u0002\u00107\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00160\t082\b\b\u0002\u0010O\u001a\u00020\rR\u0014\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R*\u0010\u0007\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bj\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t`\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000RM\u0010\u0012\u001a>\u0012\u0004\u0012\u00020\u0014\u0012\u0014\u0012\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0016\u0012\u0004\u0012\u00020\u00170\u00150\u0013j\u001e\u0012\u0004\u0012\u00020\u0014\u0012\u0014\u0012\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0016\u0012\u0004\u0012\u00020\u00170\u0015`\u0018\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001b\u001a\u0006\u0012\u0002\b\u00030\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R$\u0010!\u001a\u00020 2\u0006\u0010\u001f\u001a\u00020 @BX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%\u00a8\u0006V"}, d2={"Lgloomyfolken/mods/stalker/mobs/client/tuning/SwingPropertyEditor;", "", "()V", "_propertyGroup", "Lgloomyfolken/mods/stalker/mobs/client/tuning/EditorPropertyGroup;", "addInheritanceCheckboxes", "", "changeListeners", "Ljava/util/ArrayList;", "Lkotlin/Function0;", "", "Lkotlin/collections/ArrayList;", "columnCount", "", "controller", "Lgloomyfolken/mods/stalker/mobs/client/tuning/EditorPropertyController;", "initialized", "isTable", "populatedCheckboxes", "Ljava/util/HashMap;", "", "Lkotlin/Pair;", "Lgloomyfolken/mods/stalker/mobs/client/tuning/SwingPropertyEditor$ComponentWrapper;", "Ljavax/swing/JCheckBox;", "Lkotlin/collections/HashMap;", "getPopulatedCheckboxes", "()Ljava/util/HashMap;", "propertyGroup", "getPropertyGroup", "()Lgloomyfolken/mods/stalker/mobs/client/tuning/EditorPropertyGroup;", "registeringFieldName", "<set-?>", "Ljavax/swing/JScrollPane;", "scrollPane", "getScrollPane", "()Ljavax/swing/JScrollPane;", "setScrollPane", "(Ljavax/swing/JScrollPane;)V", "addElement", "toComponent", "Ljavax/swing/JComponent;", "index", "label", "element", "createBooleanHandler", "value", "createContainer", "createNumericHandler", "Ljavax/swing/JPanel;", "", "minValue", "maxValue", "unitValue", "createPropertyControllers", "panel", "customFactories", "", "createStringHandler", "Ljavax/swing/text/JTextComponent;", "textArea", "createValueHandler", "name", "ant", "Lgloomyfolken/mods/stalker/mobs/client/tuning/SyntheticPropertyAnnotation;", "enableComponents", "container", "Ljava/awt/Container;", "flag", "getSpecialFactory", "field", "Ljava/lang/reflect/Field;", "registerElementListeners", "group", "setFieldBooleanValue", "newValue", "setFieldNumericValue", "", "setFieldStringValue", "setup", "colCount", "setupTable", "BooleanWrapper", "ComponentWrapper", "DropDownListWrapper", "NumericWrapper", "StringWrapper", "minecraft"})
public final class SwingPropertyEditor {
    @NotNull
    private JScrollPane scrollPane = new JScrollPane();
    private EditorPropertyController controller;
    private boolean initialized;
    private final ArrayList<Function0<Unit>> changeListeners;
    private EditorPropertyGroup<?> _propertyGroup;
    private int columnCount;
    private boolean isTable;
    private String registeringFieldName;
    private boolean addInheritanceCheckboxes;
    @NotNull
    private final HashMap<String, Pair<ComponentWrapper<?>, JCheckBox>> populatedCheckboxes;

    @NotNull
    public final JScrollPane getScrollPane() {
        return this.scrollPane;
    }

    private final void setScrollPane(JScrollPane jScrollPane) {
        this.scrollPane = jScrollPane;
    }

    private final EditorPropertyGroup<?> getPropertyGroup() {
        EditorPropertyGroup<?> editorPropertyGroup = this._propertyGroup;
        if (editorPropertyGroup == null) {
            Intrinsics.throwNpe();
        }
        return editorPropertyGroup;
    }

    @NotNull
    public final HashMap<String, Pair<ComponentWrapper<?>, JCheckBox>> getPopulatedCheckboxes() {
        return this.populatedCheckboxes;
    }

    @NotNull
    public final JScrollPane setup(@NotNull EditorPropertyController editorPropertyController, @NotNull Map<String, ? extends Function0<? extends ComponentWrapper<?>>> map, boolean bl) {
        Intrinsics.checkParameterIsNotNull(editorPropertyController, "controller");
        Intrinsics.checkParameterIsNotNull(map, "customFactories");
        return this.setup(editorPropertyController, map, 1, bl);
    }

    @NotNull
    public static /* synthetic */ JScrollPane setup$default(SwingPropertyEditor swingPropertyEditor, EditorPropertyController editorPropertyController, Map map, boolean bl, int n, Object object) {
        if ((n & 2) != 0) {
            map = MapsKt.emptyMap();
        }
        if ((n & 4) != 0) {
            bl = false;
        }
        return swingPropertyEditor.setup(editorPropertyController, map, bl);
    }

    @NotNull
    public final JScrollPane setupTable(@NotNull EditorPropertyController editorPropertyController, @NotNull Map<String, ? extends Function0<? extends ComponentWrapper<?>>> map, int n) {
        Intrinsics.checkParameterIsNotNull(editorPropertyController, "controller");
        Intrinsics.checkParameterIsNotNull(map, "customFactories");
        this.isTable = true;
        JScrollPane jScrollPane = SwingPropertyEditor.setup$default(this, editorPropertyController, map, n, false, 8, null);
        this.isTable = false;
        return jScrollPane;
    }

    @NotNull
    public static /* synthetic */ JScrollPane setupTable$default(SwingPropertyEditor swingPropertyEditor, EditorPropertyController editorPropertyController, Map map, int n, int n2, Object object) {
        if ((n2 & 2) != 0) {
            map = MapsKt.emptyMap();
        }
        if ((n2 & 4) != 0) {
            n = 1;
        }
        return swingPropertyEditor.setupTable(editorPropertyController, map, n);
    }

    @NotNull
    public final JScrollPane setup(@NotNull EditorPropertyController editorPropertyController, @NotNull Map<String, ? extends Function0<? extends ComponentWrapper<?>>> map, int n, boolean bl) {
        Intrinsics.checkParameterIsNotNull(editorPropertyController, "controller");
        Intrinsics.checkParameterIsNotNull(map, "customFactories");
        this.populatedCheckboxes.clear();
        this.initialized = true;
        this.controller = editorPropertyController;
        this.columnCount = n;
        this.addInheritanceCheckboxes = bl;
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BoxLayout(jPanel, 1));
        for (EditorPropertyGroup<?> editorPropertyGroup : editorPropertyController.getPropertyGroups()) {
            this.createPropertyControllers(jPanel, editorPropertyGroup, map);
            this._propertyGroup = null;
        }
        this.scrollPane.setViewportView(jPanel);
        return this.scrollPane;
    }

    @NotNull
    public static /* synthetic */ JScrollPane setup$default(SwingPropertyEditor swingPropertyEditor, EditorPropertyController editorPropertyController, Map map, int n, boolean bl, int n2, Object object) {
        if ((n2 & 2) != 0) {
            map = MapsKt.emptyMap();
        }
        if ((n2 & 4) != 0) {
            n = 1;
        }
        if ((n2 & 8) != 0) {
            bl = false;
        }
        return swingPropertyEditor.setup(editorPropertyController, map, n, bl);
    }

    private final JComponent createContainer() {
        JComponent jComponent;
        if (this.isTable) {
            jComponent = new JTable(new DefaultTableModel(){

                @NotNull
                public Class<?> getColumnClass(int n) {
                    Class<?> clazz = super.getColumnClass(n);
                    Intrinsics.checkExpressionValueIsNotNull(clazz, "super.getColumnClass(columnIndex)");
                    return clazz;
                }
            });
        } else {
            jComponent = new JPanel();
            ((JPanel)jComponent).setLayout(new GridBagLayout());
        }
        return jComponent;
    }

    private final void addElement(JComponent jComponent, int n, String string, ComponentWrapper<?> componentWrapper) {
        if (this.isTable) {
            JComponent jComponent2 = jComponent;
            if (jComponent2 == null) {
                throw new TypeCastException("null cannot be cast to non-null type javax.swing.JTable");
            }
            JTable jTable = (JTable)jComponent2;
        } else {
            JComponent jComponent3 = jComponent;
            if (jComponent3 == null) {
                throw new TypeCastException("null cannot be cast to non-null type javax.swing.JPanel");
            }
            JPanel jPanel = (JPanel)jComponent3;
            JLabel jLabel = new JLabel(string);
            jLabel.setAlignmentX(1.0f);
            ((JComponent)componentWrapper.getComponent()).setAlignmentX(0.0f);
            String string2 = this.registeringFieldName;
            boolean bl = this.addInheritanceCheckboxes && string2 != null;
            int n2 = bl ? 3 : 2;
            GridBagConstraints gridBagConstraints = new GridBagConstraints();
            gridBagConstraints.gridx = n % this.columnCount * n2;
            gridBagConstraints.gridy = n / this.columnCount;
            gridBagConstraints.anchor = 22;
            gridBagConstraints.insets = new Insets(0, 0, 0, 10);
            jPanel.add((Component)jLabel, gridBagConstraints);
            gridBagConstraints.gridx = n % this.columnCount * n2 + 1;
            gridBagConstraints.gridy = n / this.columnCount;
            gridBagConstraints.anchor = 21;
            jPanel.add((Component)componentWrapper.getComponent(), gridBagConstraints);
            if (bl) {
                gridBagConstraints.gridx = n % this.columnCount * n2 + 2;
                gridBagConstraints.gridy = n / this.columnCount;
                gridBagConstraints.anchor = 22;
                JCheckBox jCheckBox = new JCheckBox("[Parent]");
                String string3 = string2;
                if (string3 == null) {
                    Intrinsics.throwNpe();
                }
                this.populatedCheckboxes.put(string3, TuplesKt.to(componentWrapper, jCheckBox));
                jPanel.add((Component)jCheckBox, gridBagConstraints);
            }
        }
    }

    private final void enableComponents(Container container, boolean bl) {
        Component[] componentArray = container.getComponents();
        for (int i = 0; i < componentArray.length; ++i) {
            Component component = componentArray[i];
            component.setEnabled(bl);
            if (!(component instanceof Container)) continue;
            this.enableComponents((Container)component, bl);
        }
    }

    private final JComponent createPropertyControllers(JPanel jPanel, EditorPropertyGroup<?> editorPropertyGroup, Map<String, ? extends Function0<? extends ComponentWrapper<?>>> map) {
        this._propertyGroup = editorPropertyGroup;
        JComponent jComponent = this.createContainer();
        int n = 0;
        for (Field field : editorPropertyGroup.getProperties().values()) {
            Function0<ComponentWrapper<?>> function0;
            ComponentWrapper<?> componentWrapper;
            SyntheticPropertyAnnotation syntheticPropertyAnnotation;
            EditorProperty editorProperty;
            Object object = (EditorProperty)ArraysKt.firstOrNull((Object[])field.getDeclaredAnnotationsByType(EditorProperty.class));
            if (object == null) {
                object = editorProperty = editorPropertyGroup.getSyntheticPropertyAnnotations().get(field.getName());
            }
            if (editorProperty instanceof EditorProperty) {
                syntheticPropertyAnnotation = new SyntheticPropertyAnnotation(editorProperty.name(), editorProperty.min(), editorProperty.max(), Intrinsics.areEqual(editorProperty.show(), "true"), editorProperty.special());
            } else if (editorProperty instanceof SyntheticPropertyAnnotation) {
                syntheticPropertyAnnotation = (SyntheticPropertyAnnotation)((Object)editorProperty);
            } else {
                throw (Throwable)new IllegalStateException("No annotation (synthetic) info was defined for field " + field.getName() + '!');
            }
            if (!syntheticPropertyAnnotation.getShow()) continue;
            SerializedName serializedName = (SerializedName)ArraysKt.firstOrNull((Object[])field.getDeclaredAnnotationsByType(SerializedName.class));
            this.registeringFieldName = serializedName != null ? serializedName.value() : null;
            Function0<ComponentWrapper<?>> function02 = map.get(syntheticPropertyAnnotation.getName());
            if (function02 == null) {
                Field field2 = field;
                Intrinsics.checkExpressionValueIsNotNull(field2, "field");
                function02 = this.getSpecialFactory(syntheticPropertyAnnotation, field2);
            }
            if ((componentWrapper = (function0 = function02)) == null || (componentWrapper = componentWrapper.invoke()) == null) {
                String string = syntheticPropertyAnnotation.getName();
                Object object2 = field.get(editorPropertyGroup.getObjectToEdit());
                Intrinsics.checkExpressionValueIsNotNull(object2, "field.get(propertyGroup.objectToEdit)");
                componentWrapper = this.createValueHandler(string, object2, syntheticPropertyAnnotation);
            }
            ComponentWrapper<?> componentWrapper2 = componentWrapper;
            Field field3 = field;
            Intrinsics.checkExpressionValueIsNotNull(field3, "field");
            this.registerElementListeners(componentWrapper2, field3, editorPropertyGroup);
            this.addElement(jComponent, n, syntheticPropertyAnnotation.getName() + ":", componentWrapper2);
            ++n;
            this.registeringFieldName = null;
        }
        jComponent.setBorder(BorderFactory.createTitledBorder(editorPropertyGroup.getGroupName()));
        jPanel.add(jComponent);
        return jComponent;
    }

    private final Function0<ComponentWrapper<?>> getSpecialFactory(SyntheticPropertyAnnotation syntheticPropertyAnnotation, Field field) {
        Function0 function0;
        String string = syntheticPropertyAnnotation.getSpecial();
        switch (string.hashCode()) {
            case 455600706: {
                if (string.equals("mobconfig")) {
                    JComboBox<String> jComboBox;
                    Collection<String> collection = (Collection<String>)MutantConfigHelper.CLIENT.getMobConfigs().keySet();
                    JComboBox<String> jComboBox2 = jComboBox;
                    JComboBox<String> jComboBox3 = jComboBox;
                    Collection<String> collection2 = collection;
                    if (collection2 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type java.util.Collection<T>");
                    }
                    Collection<String> collection3 = collection2;
                    String[] stringArray = collection3.toArray(new String[collection3.size()]);
                    if (stringArray == null) {
                        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
                    }
                    String[] stringArray2 = stringArray;
                    jComboBox2(stringArray2);
                    JComboBox<String> jComboBox4 = jComboBox3;
                    collection = tdws._a(jComboBox4);
                    if (!collection.isEmpty()) {
                        jComboBox4.setSelectedIndex(0);
                    }
                    function0 = new Function0<DropDownListWrapper>(jComboBox4){
                        final /* synthetic */ JComboBox $combobox;

                        @NotNull
                        public final DropDownListWrapper invoke() {
                            return new DropDownListWrapper(this.$combobox);
                        }
                        {
                            this.$combobox = jComboBox;
                            super(0);
                        }
                    };
                    break;
                }
            }
            default: {
                function0 = null;
            }
        }
        return function0;
    }

    private final void registerElementListeners(ComponentWrapper<?> componentWrapper, Field field, EditorPropertyGroup<?> editorPropertyGroup) {
        ComponentWrapper<?> componentWrapper2 = componentWrapper;
        if (componentWrapper2 instanceof NumericWrapper) {
            ((NumericWrapper)componentWrapper).getSlider().addChangeListener(new ChangeListener(this, componentWrapper, field, editorPropertyGroup){
                final /* synthetic */ SwingPropertyEditor this$0;
                final /* synthetic */ ComponentWrapper $element;
                final /* synthetic */ Field $field;
                final /* synthetic */ EditorPropertyGroup $group;

                public final void stateChanged(ChangeEvent changeEvent) {
                    if (((NumericWrapper)this.$element).getSlider().hasFocus()) {
                        double d = (double)((NumericWrapper)this.$element).getSlider().getValue() * ((NumericWrapper)this.$element).getUnitValue();
                        d = SwingPropertyEditor.access$setFieldNumericValue(this.this$0, this.$field, d, this.$group).doubleValue();
                        ((NumericWrapper)this.$element).getSpinner().setValue(d);
                    }
                }
                {
                    this.this$0 = swingPropertyEditor;
                    this.$element = componentWrapper;
                    this.$field = field;
                    this.$group = editorPropertyGroup;
                }
            });
            ((NumericWrapper)componentWrapper).getSpinner().addChangeListener(new ChangeListener(this, componentWrapper, field, editorPropertyGroup){
                final /* synthetic */ SwingPropertyEditor this$0;
                final /* synthetic */ ComponentWrapper $element;
                final /* synthetic */ Field $field;
                final /* synthetic */ EditorPropertyGroup $group;

                public final void stateChanged(ChangeEvent changeEvent) {
                    String string = ((NumericWrapper)this.$element).getSpinner().getValue().toString();
                    double d = Double.parseDouble(string);
                    double d2 = SwingPropertyEditor.access$setFieldNumericValue(this.this$0, this.$field, d, this.$group).doubleValue();
                    int n = owkq._k(d2 / ((NumericWrapper)this.$element).getUnitValue());
                    if (((NumericWrapper)this.$element).getSlider().getMaximum() < n) {
                        // empty if block
                    }
                    if (((NumericWrapper)this.$element).getSlider().getMinimum() > n) {
                        // empty if block
                    }
                    ((NumericWrapper)this.$element).getSlider().setValue(n);
                }
                {
                    this.this$0 = swingPropertyEditor;
                    this.$element = componentWrapper;
                    this.$field = field;
                    this.$group = editorPropertyGroup;
                }
            });
            JComponent jComponent = ((NumericWrapper)componentWrapper).getSpinner().getEditor();
            if (jComponent == null) {
                throw new TypeCastException("null cannot be cast to non-null type javax.swing.JSpinner.DefaultEditor");
            }
            ((JSpinner.DefaultEditor)jComponent).getTextField().addKeyListener(new KeyListener(){

                public void keyTyped(@Nullable KeyEvent keyEvent) {
                }

                public void keyPressed(@Nullable KeyEvent keyEvent) {
                }

                public void keyReleased(@NotNull KeyEvent keyEvent) {
                    Intrinsics.checkParameterIsNotNull(keyEvent, "e");
                    if (keyEvent.getKeyCode() != 10) {
                        // empty if block
                    }
                }
            });
        } else if (componentWrapper2 instanceof BooleanWrapper) {
            ((BooleanWrapper)componentWrapper).getCheckbox().addChangeListener(new ChangeListener(this, field, componentWrapper, editorPropertyGroup){
                final /* synthetic */ SwingPropertyEditor this$0;
                final /* synthetic */ Field $field;
                final /* synthetic */ ComponentWrapper $element;
                final /* synthetic */ EditorPropertyGroup $group;

                public final void stateChanged(ChangeEvent changeEvent) {
                    SwingPropertyEditor.access$setFieldBooleanValue(this.this$0, this.$field, ((BooleanWrapper)this.$element).getCheckbox().isSelected(), this.$group);
                }
                {
                    this.this$0 = swingPropertyEditor;
                    this.$field = field;
                    this.$element = componentWrapper;
                    this.$group = editorPropertyGroup;
                }
            });
        } else if (componentWrapper2 instanceof StringWrapper) {
            ((StringWrapper)componentWrapper).getTextComponent().getDocument().addDocumentListener(new DocumentListener(this, field, componentWrapper, editorPropertyGroup){
                final /* synthetic */ SwingPropertyEditor this$0;
                final /* synthetic */ Field $field;
                final /* synthetic */ ComponentWrapper $element;
                final /* synthetic */ EditorPropertyGroup $group;

                public void changedUpdate(@NotNull DocumentEvent documentEvent) {
                    Intrinsics.checkParameterIsNotNull(documentEvent, "e");
                    String string = ((StringWrapper)this.$element).getTextComponent().getText();
                    Intrinsics.checkExpressionValueIsNotNull(string, "element.textComponent.text");
                    SwingPropertyEditor.access$setFieldStringValue(this.this$0, this.$field, string, this.$group);
                }

                public void insertUpdate(@NotNull DocumentEvent documentEvent) {
                    Intrinsics.checkParameterIsNotNull(documentEvent, "e");
                    String string = ((StringWrapper)this.$element).getTextComponent().getText();
                    Intrinsics.checkExpressionValueIsNotNull(string, "element.textComponent.text");
                    SwingPropertyEditor.access$setFieldStringValue(this.this$0, this.$field, string, this.$group);
                }

                public void removeUpdate(@NotNull DocumentEvent documentEvent) {
                    Intrinsics.checkParameterIsNotNull(documentEvent, "e");
                    String string = ((StringWrapper)this.$element).getTextComponent().getText();
                    Intrinsics.checkExpressionValueIsNotNull(string, "element.textComponent.text");
                    SwingPropertyEditor.access$setFieldStringValue(this.this$0, this.$field, string, this.$group);
                }
                {
                    this.this$0 = swingPropertyEditor;
                    this.$field = field;
                    this.$element = componentWrapper;
                    this.$group = editorPropertyGroup;
                }
            });
        } else if (componentWrapper2 instanceof DropDownListWrapper) {
            ((DropDownListWrapper)componentWrapper).getComboBox().addActionListener(new ActionListener(this, componentWrapper, field, editorPropertyGroup){
                final /* synthetic */ SwingPropertyEditor this$0;
                final /* synthetic */ ComponentWrapper $element;
                final /* synthetic */ Field $field;
                final /* synthetic */ EditorPropertyGroup $group;

                public final void actionPerformed(ActionEvent actionEvent) {
                    if (((DropDownListWrapper)this.$element).getComboBox().getSelectedItem() != null) {
                        SwingPropertyEditor.access$setFieldStringValue(this.this$0, this.$field, ((DropDownListWrapper)this.$element).getComboBox().getSelectedItem().toString(), this.$group);
                    }
                }
                {
                    this.this$0 = swingPropertyEditor;
                    this.$element = componentWrapper;
                    this.$field = field;
                    this.$group = editorPropertyGroup;
                }
            });
        }
    }

    private final ComponentWrapper<?> createValueHandler(String string, Object object, SyntheticPropertyAnnotation syntheticPropertyAnnotation) {
        double d;
        double d2;
        double d3;
        ComponentWrapper<JComponent> componentWrapper;
        SwingPropertyEditor swingPropertyEditor;
        String string2;
        String string3 = syntheticPropertyAnnotation.getMin();
        String string4 = syntheticPropertyAnnotation.getMax();
        Object object2 = object;
        if (object2 instanceof Boolean) {
            string2 = object.toString();
            swingPropertyEditor = this;
            boolean bl = Boolean.parseBoolean(string2);
            componentWrapper = swingPropertyEditor.createBooleanHandler(bl);
        } else if (object2 instanceof Integer) {
            string2 = object.toString();
            swingPropertyEditor = this;
            d3 = Double.parseDouble(string2);
            string2 = string3;
            d2 = Double.parseDouble(string2);
            string2 = string4;
            d = Double.parseDouble(string2);
            componentWrapper = swingPropertyEditor.createNumericHandler(d3, d2, d, 1.0);
        } else if (object2 instanceof Float || object2 instanceof Double) {
            string2 = object.toString();
            swingPropertyEditor = this;
            d3 = Double.parseDouble(string2);
            string2 = string3;
            d2 = Double.parseDouble(string2);
            string2 = string4;
            d = Double.parseDouble(string2);
            componentWrapper = SwingPropertyEditor.createNumericHandler$default(swingPropertyEditor, d3, d2, d, 0.0, 8, null);
        } else if (object2 instanceof String) {
            componentWrapper = this.createStringHandler(object.toString(), Intrinsics.areEqual(syntheticPropertyAnnotation.getSpecial(), "area"));
        } else {
            throw (Throwable)new IllegalStateException("No handler found for type field " + string + " with type " + object.getClass() + '!');
        }
        ComponentWrapper<JCheckBox> componentWrapper2 = componentWrapper;
        return componentWrapper2;
    }

    private final Number setFieldNumericValue(Field field, Number number, EditorPropertyGroup<?> editorPropertyGroup) {
        Number number2 = number;
        Class<?> clazz = field.getType();
        if (Intrinsics.areEqual(clazz, Integer.TYPE) || Intrinsics.areEqual(clazz, Integer.class)) {
            number2 = number2.intValue();
        } else if (Intrinsics.areEqual(clazz, Float.TYPE) || Intrinsics.areEqual(clazz, Float.class)) {
            number2 = Float.valueOf(number2.floatValue());
        } else if (Intrinsics.areEqual(clazz, Double.TYPE) || Intrinsics.areEqual(clazz, Double.class)) {
            number2 = number2.doubleValue();
        }
        EditorPropertyController editorPropertyController = this.controller;
        if (editorPropertyController == null) {
            Intrinsics.throwUninitializedPropertyAccessException("controller");
        }
        String string = editorPropertyGroup.getGroupName();
        String string2 = field.getName();
        Intrinsics.checkExpressionValueIsNotNull(string2, "field.name");
        editorPropertyController.setValueForGroup(string, string2, number2);
        clazz = this.changeListeners;
        Iterator iterator = clazz.iterator();
        while (iterator.hasNext()) {
            Object t = iterator.next();
            Function0 function0 = (Function0)t;
            function0.invoke();
        }
        return number2;
    }

    private final boolean setFieldBooleanValue(Field field, boolean bl, EditorPropertyGroup<?> editorPropertyGroup) {
        EditorPropertyController editorPropertyController = this.controller;
        if (editorPropertyController == null) {
            Intrinsics.throwUninitializedPropertyAccessException("controller");
        }
        String string = editorPropertyGroup.getGroupName();
        String string2 = field.getName();
        Intrinsics.checkExpressionValueIsNotNull(string2, "field.name");
        editorPropertyController.setValueForGroup(string, string2, bl);
        Iterable iterable = this.changeListeners;
        for (Object t : iterable) {
            Function0 function0 = (Function0)t;
            function0.invoke();
        }
        return bl;
    }

    private final String setFieldStringValue(Field field, String string, EditorPropertyGroup<?> editorPropertyGroup) {
        EditorPropertyController editorPropertyController = this.controller;
        if (editorPropertyController == null) {
            Intrinsics.throwUninitializedPropertyAccessException("controller");
        }
        String string2 = editorPropertyGroup.getGroupName();
        String string3 = field.getName();
        Intrinsics.checkExpressionValueIsNotNull(string3, "field.name");
        editorPropertyController.setValueForGroup(string2, string3, string);
        Iterable iterable = this.changeListeners;
        for (Object t : iterable) {
            Function0 function0 = (Function0)t;
            function0.invoke();
        }
        return string;
    }

    private final ComponentWrapper<JTextComponent> createStringHandler(String string, boolean bl) {
        JTextComponent jTextComponent;
        if (bl) {
            JTextArea jTextArea = new JTextArea(string, 1, 22);
            jTextArea.setLineWrap(true);
            jTextComponent = jTextArea;
        } else {
            jTextComponent = new JTextField(string, 22);
        }
        JTextComponent jTextComponent2 = jTextComponent;
        jTextComponent2.setMaximumSize(new Dimension(jTextComponent2.getPreferredSize()));
        return new StringWrapper(jTextComponent2);
    }

    static /* synthetic */ ComponentWrapper createStringHandler$default(SwingPropertyEditor swingPropertyEditor, String string, boolean bl, int n, Object object) {
        if ((n & 2) != 0) {
            bl = false;
        }
        return swingPropertyEditor.createStringHandler(string, bl);
    }

    private final ComponentWrapper<JCheckBox> createBooleanHandler(boolean bl) {
        JCheckBox jCheckBox = new JCheckBox("", bl);
        jCheckBox.setMaximumSize(new Dimension(jCheckBox.getPreferredSize()));
        return new BooleanWrapper(jCheckBox);
    }

    private final ComponentWrapper<JPanel> createNumericHandler(double d, double d2, double d3, double d4) {
        SpinnerNumberModel spinnerNumberModel = new SpinnerNumberModel(d, DoubleCompanionObject.INSTANCE.getNEGATIVE_INFINITY(), DoubleCompanionObject.INSTANCE.getPOSITIVE_INFINITY(), d4);
        int n = owkq._k(d2 / d4);
        int n2 = owkq._k(d3 / d4);
        JSlider jSlider = new JSlider(0, n, n2, owkq._a(owkq._k(d / d4), n, n2));
        JSpinner jSpinner = new JSpinner(spinnerNumberModel);
        JPanel jPanel = new JPanel();
        jPanel.add(jSlider);
        jPanel.add(jSpinner);
        jSlider.setPreferredSize(new Dimension(160, 20));
        jSpinner.setPreferredSize(new Dimension(60, 20));
        jSlider.setMaximumSize(new Dimension(jSlider.getPreferredSize()));
        jSpinner.setMaximumSize(new Dimension(jSpinner.getPreferredSize()));
        return new NumericWrapper(jSlider, jSpinner, jPanel, d4);
    }

    static /* synthetic */ ComponentWrapper createNumericHandler$default(SwingPropertyEditor swingPropertyEditor, double d, double d2, double d3, double d4, int n, Object object) {
        if ((n & 8) != 0) {
            d4 = 0.0025;
        }
        return swingPropertyEditor.createNumericHandler(d, d2, d3, d4);
    }

    public SwingPropertyEditor() {
        SwingPropertyEditor swingPropertyEditor = this;
        Cloneable cloneable = new ArrayList();
        swingPropertyEditor.changeListeners = cloneable;
        this.columnCount = 1;
        swingPropertyEditor = this;
        cloneable = new HashMap();
        swingPropertyEditor.populatedCheckboxes = cloneable;
    }

    @NotNull
    public static final /* synthetic */ Number access$setFieldNumericValue(SwingPropertyEditor swingPropertyEditor, @NotNull Field field, @NotNull Number number, @NotNull EditorPropertyGroup editorPropertyGroup) {
        return swingPropertyEditor.setFieldNumericValue(field, number, editorPropertyGroup);
    }

    public static final /* synthetic */ boolean access$setFieldBooleanValue(SwingPropertyEditor swingPropertyEditor, @NotNull Field field, boolean bl, @NotNull EditorPropertyGroup editorPropertyGroup) {
        return swingPropertyEditor.setFieldBooleanValue(field, bl, editorPropertyGroup);
    }

    @NotNull
    public static final /* synthetic */ String access$setFieldStringValue(SwingPropertyEditor swingPropertyEditor, @NotNull Field field, @NotNull String string, @NotNull EditorPropertyGroup editorPropertyGroup) {
        return swingPropertyEditor.setFieldStringValue(field, string, editorPropertyGroup);
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\b&\u0018\u0000*\n\b\u0000\u0010\u0001 \u0001*\u00020\u00022\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00028\u0000\u00a2\u0006\u0002\u0010\u0005R\u0013\u0010\u0004\u001a\u00028\u0000\u00a2\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\t"}, d2={"Lgloomyfolken/mods/stalker/mobs/client/tuning/SwingPropertyEditor$ComponentWrapper;", "T", "Ljavax/swing/JComponent;", "", "component", "(Ljavax/swing/JComponent;)V", "getComponent", "()Ljavax/swing/JComponent;", "Ljavax/swing/JComponent;", "minecraft"})
    public static abstract class ComponentWrapper<T extends JComponent> {
        @NotNull
        private final T component;

        @NotNull
        public final T getComponent() {
            return this.component;
        }

        public ComponentWrapper(@NotNull T t) {
            Intrinsics.checkParameterIsNotNull(t, "component");
            this.component = t;
        }
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0013"}, d2={"Lgloomyfolken/mods/stalker/mobs/client/tuning/SwingPropertyEditor$NumericWrapper;", "Lgloomyfolken/mods/stalker/mobs/client/tuning/SwingPropertyEditor$ComponentWrapper;", "Ljavax/swing/JPanel;", "slider", "Ljavax/swing/JSlider;", "spinner", "Ljavax/swing/JSpinner;", "panel", "unitValue", "", "(Ljavax/swing/JSlider;Ljavax/swing/JSpinner;Ljavax/swing/JPanel;D)V", "getPanel", "()Ljavax/swing/JPanel;", "getSlider", "()Ljavax/swing/JSlider;", "getSpinner", "()Ljavax/swing/JSpinner;", "getUnitValue", "()D", "minecraft"})
    public static final class NumericWrapper
    extends ComponentWrapper<JPanel> {
        @NotNull
        private final JSlider slider;
        @NotNull
        private final JSpinner spinner;
        @NotNull
        private final JPanel panel;
        private final double unitValue;

        @NotNull
        public final JSlider getSlider() {
            return this.slider;
        }

        @NotNull
        public final JSpinner getSpinner() {
            return this.spinner;
        }

        @NotNull
        public final JPanel getPanel() {
            return this.panel;
        }

        public final double getUnitValue() {
            return this.unitValue;
        }

        public NumericWrapper(@NotNull JSlider jSlider, @NotNull JSpinner jSpinner, @NotNull JPanel jPanel, double d) {
            Intrinsics.checkParameterIsNotNull(jSlider, "slider");
            Intrinsics.checkParameterIsNotNull(jSpinner, "spinner");
            Intrinsics.checkParameterIsNotNull(jPanel, "panel");
            super((JComponent)jPanel);
            this.slider = jSlider;
            this.spinner = jSpinner;
            this.panel = jPanel;
            this.unitValue = d;
        }
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2={"Lgloomyfolken/mods/stalker/mobs/client/tuning/SwingPropertyEditor$BooleanWrapper;", "Lgloomyfolken/mods/stalker/mobs/client/tuning/SwingPropertyEditor$ComponentWrapper;", "Ljavax/swing/JCheckBox;", "checkbox", "(Ljavax/swing/JCheckBox;)V", "getCheckbox", "()Ljavax/swing/JCheckBox;", "minecraft"})
    public static final class BooleanWrapper
    extends ComponentWrapper<JCheckBox> {
        @NotNull
        private final JCheckBox checkbox;

        @NotNull
        public final JCheckBox getCheckbox() {
            return this.checkbox;
        }

        public BooleanWrapper(@NotNull JCheckBox jCheckBox) {
            Intrinsics.checkParameterIsNotNull(jCheckBox, "checkbox");
            super((JComponent)jCheckBox);
            this.checkbox = jCheckBox;
        }
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2={"Lgloomyfolken/mods/stalker/mobs/client/tuning/SwingPropertyEditor$StringWrapper;", "Lgloomyfolken/mods/stalker/mobs/client/tuning/SwingPropertyEditor$ComponentWrapper;", "Ljavax/swing/text/JTextComponent;", "textComponent", "(Ljavax/swing/text/JTextComponent;)V", "getTextComponent", "()Ljavax/swing/text/JTextComponent;", "minecraft"})
    public static final class StringWrapper
    extends ComponentWrapper<JTextComponent> {
        @NotNull
        private final JTextComponent textComponent;

        @NotNull
        public final JTextComponent getTextComponent() {
            return this.textComponent;
        }

        public StringWrapper(@NotNull JTextComponent jTextComponent) {
            Intrinsics.checkParameterIsNotNull(jTextComponent, "textComponent");
            super((JComponent)jTextComponent);
            this.textComponent = jTextComponent;
        }
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001B\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u00a2\u0006\u0002\u0010\u0005R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2={"Lgloomyfolken/mods/stalker/mobs/client/tuning/SwingPropertyEditor$DropDownListWrapper;", "Lgloomyfolken/mods/stalker/mobs/client/tuning/SwingPropertyEditor$ComponentWrapper;", "Ljavax/swing/JComboBox;", "", "comboBox", "(Ljavax/swing/JComboBox;)V", "getComboBox", "()Ljavax/swing/JComboBox;", "minecraft"})
    public static final class DropDownListWrapper
    extends ComponentWrapper<JComboBox<String>> {
        @NotNull
        private final JComboBox<String> comboBox;

        @NotNull
        public final JComboBox<String> getComboBox() {
            return this.comboBox;
        }

        public DropDownListWrapper(@NotNull JComboBox<String> jComboBox) {
            Intrinsics.checkParameterIsNotNull(jComboBox, "comboBox");
            super((JComponent)jComboBox);
            this.comboBox = jComboBox;
        }
    }
}

