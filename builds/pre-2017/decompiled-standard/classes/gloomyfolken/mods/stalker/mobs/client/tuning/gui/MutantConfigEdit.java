/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.mobs.client.tuning.gui;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import gloomyfolken.mods.stalker.mobs.client.StalkerMobsClient;
import gloomyfolken.mods.stalker.mobs.client.render.DebugDrawInfo;
import gloomyfolken.mods.stalker.mobs.client.tuning.EditorPropertyController;
import gloomyfolken.mods.stalker.mobs.client.tuning.EditorPropertyGroup;
import gloomyfolken.mods.stalker.mobs.client.tuning.SwingPropertyEditor;
import gloomyfolken.mods.stalker.mobs.client.tuning.gui.ClientConfigHelper;
import gloomyfolken.mods.stalker.mobs.client.tuning.gui.LootGroupEdit;
import gloomyfolken.mods.stalker.mobs.entity.MutantRegistry;
import gloomyfolken.mods.stalker.mobs.entity.config.ConfigEditPermissions;
import gloomyfolken.mods.stalker.mobs.entity.config.MutantConfigHelper;
import gloomyfolken.mods.stalker.mobs.entity.config.MutantConfiguration;
import gloomyfolken.mods.stalker.mobs.packet.PacketConfigAdd;
import gloomyfolken.mods.stalker.mobs.packet.PacketConfigDelete;
import gloomyfolken.mods.stalker.mobs.packet.PacketConfigList;
import gloomyfolken.mods.stalker.mobs.packet.PacketConfigTest;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.jetbrains.annotations.NotNull;
import org.lwjgl.opengl.Display;

public class MutantConfigEdit {
    private JList configList;
    private JButton spawnMutant;
    private JTextField configId;
    private JPanel propertyPanel;
    private JButton dropSettings;
    private JButton newConfig;
    private JButton deleteConfig;
    private JButton duplicateConfig;
    private JButton save;
    private JButton saveAll;
    private JPanel root;
    private JPanel basicPanel;
    private JPanel generatedSettings;
    private JPanel idLabel;
    private JButton cancelEdits;
    private JButton refresh;
    private JScrollPane settingsScrollPane;
    private JButton cloneSettings;
    private JPanel debugPanel;
    private static MutantConfigEdit instance;
    private boolean wasClosed;
    private ArrayList<ConfigEntry> configs = new ArrayList();
    private int selectedConfigIdx = -1;
    private Timer updateStateTimer;
    private ConfigEditPermissions perms;
    private boolean invokedFromListListener = false;
    private JComponent lastPropertyUser;
    private JComboBox<String> lastTypeComboBox;
    private boolean cloningConfig = false;

    private Font $$$getFont$$$(String string, int n, int n2, Font font) {
        Font font2;
        if (font == null) {
            return null;
        }
        String string2 = string == null ? font.getName() : ((font2 = new Font(string, 0, 10)).canDisplay('a') && font2.canDisplay('1') ? string : font.getName());
        return new Font(string2, n >= 0 ? n : font.getStyle(), n2 >= 0 ? n2 : font.getSize());
    }

    private void $$$setupUI$$$() {
        this.root = new JPanel();
        this.root.setLayout(new GridLayoutManager(2, 1, new Insets(5, 5, 5, 5), -1, -1));
        this.root.setInheritsPopupMenu(false);
        JSplitPane jSplitPane = new JSplitPane();
        this.root.add((Component)jSplitPane, new GridConstraints(0, 0, 1, 1, 0, 3, 3, 3, null, new Dimension(200, 200), null, 0, false));
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new GridLayoutManager(2, 1, new Insets(0, 0, 0, 0), -1, -1));
        jSplitPane.setRightComponent(jPanel);
        jPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(), null));
        JPanel jPanel2 = new JPanel();
        jPanel2.setLayout(new GridLayoutManager(2, 1, new Insets(0, 0, 0, 0), -1, -1));
        jPanel.add((Component)jPanel2, new GridConstraints(0, 0, 1, 1, 0, 3, 3, 3, null, null, null, 0, false));
        this.generatedSettings = new JPanel();
        this.generatedSettings.setLayout(new BorderLayout(0, 0));
        jPanel2.add((Component)this.generatedSettings, new GridConstraints(1, 0, 1, 1, 0, 3, 3, 3, null, null, null, 0, false));
        this.generatedSettings.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "\u0421\u0433\u0435\u043d\u0435\u0440\u0438\u0440\u043e\u0432\u0430\u043d\u043d\u044b\u0435 \u043d\u0430\u0441\u0442\u0440\u043e\u0439\u043a\u0438"));
        this.settingsScrollPane = new JScrollPane();
        this.generatedSettings.add((Component)this.settingsScrollPane, "Center");
        this.settingsScrollPane.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(), null));
        this.propertyPanel = new JPanel();
        this.propertyPanel.setLayout(new FlowLayout(1, 5, 5));
        this.settingsScrollPane.setViewportView(this.propertyPanel);
        this.basicPanel = new JPanel();
        this.basicPanel.setLayout(new GridLayoutManager(2, 1, new Insets(4, 4, 4, 4), -1, -1));
        jPanel2.add((Component)this.basicPanel, new GridConstraints(0, 0, 1, 1, 0, 3, 3, 1, null, null, null, 0, false));
        this.basicPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "\u041e\u0441\u043d\u043e\u0432\u043d\u043e\u0435"));
        JPanel jPanel3 = new JPanel();
        jPanel3.setLayout(new GridLayoutManager(2, 2, new Insets(0, 0, 0, 0), -1, -1));
        this.basicPanel.add((Component)jPanel3, new GridConstraints(1, 0, 1, 1, 0, 3, 3, 3, null, null, null, 0, false));
        this.dropSettings = new JButton();
        this.dropSettings.setText("\u041d\u0430\u0441\u0442\u0440\u043e\u0439\u043a\u0438 \u0434\u0440\u043e\u043f\u0430");
        jPanel3.add((Component)this.dropSettings, new GridConstraints(0, 0, 1, 1, 0, 1, 3, 0, null, null, null, 0, false));
        this.save = new JButton();
        this.save.setIcon(new ImageIcon(this.getClass().getResource("/com/sun/java/swing/plaf/windows/icons/FloppyDrive.gif")));
        this.save.setIconTextGap(4);
        this.save.setInheritsPopupMenu(true);
        this.save.setMargin(new Insets(2, 2, 2, 14));
        this.save.setText("\u0421\u043e\u0445\u0440\u0430\u043d\u0438\u0442\u044c");
        jPanel3.add((Component)this.save, new GridConstraints(0, 1, 1, 1, 0, 1, 3, 0, null, null, null, 0, false));
        this.cancelEdits = new JButton();
        this.cancelEdits.setText("\u041e\u0442\u043c\u0435\u043d\u0438\u0442\u044c \u043f\u0440\u0430\u0432\u043a\u0438");
        jPanel3.add((Component)this.cancelEdits, new GridConstraints(1, 1, 1, 1, 0, 1, 3, 0, null, null, null, 0, false));
        this.cloneSettings = new JButton();
        this.cloneSettings.setText("\u041a\u043b\u043e\u043d\u0438\u0440\u043e\u0432\u0430\u0442\u044c \u043d\u0430\u0441\u0442\u0440\u043e\u0439\u043a\u0438 \u0438\u0437...");
        jPanel3.add((Component)this.cloneSettings, new GridConstraints(1, 0, 1, 1, 0, 1, 3, 0, null, null, null, 0, false));
        this.idLabel = new JPanel();
        this.idLabel.setLayout(new GridLayoutManager(1, 2, new Insets(0, 0, 0, 0), -1, -1));
        this.basicPanel.add((Component)this.idLabel, new GridConstraints(0, 0, 1, 1, 0, 3, 3, 3, null, null, null, 0, false));
        this.configId = new JTextField();
        this.idLabel.add((Component)this.configId, new GridConstraints(0, 1, 1, 1, 8, 1, 4, 0, null, new Dimension(150, -1), null, 0, false));
        JLabel jLabel = new JLabel();
        jLabel.setText("ID");
        this.idLabel.add((Component)jLabel, new GridConstraints(0, 0, 1, 1, 8, 0, 0, 0, null, null, null, 0, false));
        JPanel jPanel4 = new JPanel();
        jPanel4.setLayout(new GridLayoutManager(1, 1, new Insets(4, 4, 4, 4), -1, -1));
        jPanel.add((Component)jPanel4, new GridConstraints(1, 0, 1, 1, 0, 3, 3, 1, null, null, null, 0, false));
        this.spawnMutant = new JButton();
        this.spawnMutant.setText("\u0417\u0430\u0441\u043f\u0430\u0432\u043d\u0438\u0442\u044c \u043c\u0443\u0442\u0430\u043d\u0442\u0430");
        jPanel4.add((Component)this.spawnMutant, new GridConstraints(0, 0, 1, 1, 0, 1, 3, 0, null, null, null, 0, false));
        JPanel jPanel5 = new JPanel();
        jPanel5.setLayout(new GridLayoutManager(3, 1, new Insets(4, 4, 4, 4), -1, -1));
        jSplitPane.setLeftComponent(jPanel5);
        jPanel5.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(), null));
        JScrollPane jScrollPane = new JScrollPane();
        jPanel5.add((Component)jScrollPane, new GridConstraints(2, 0, 1, 1, 0, 3, 5, 5, new Dimension(150, -1), null, null, 0, false));
        jScrollPane.setBorder(BorderFactory.createTitledBorder("\u0421\u043f\u0438\u0441\u043e\u043a \u043a\u043e\u043d\u0444\u0438\u0433\u0443\u0440\u0430\u0446\u0438\u0439"));
        this.configList = new JList();
        DefaultListModel defaultListModel = new DefaultListModel();
        this.configList.setModel(defaultListModel);
        jScrollPane.setViewportView(this.configList);
        JPanel jPanel6 = new JPanel();
        jPanel6.setLayout(new GridLayoutManager(2, 2, new Insets(0, 0, 0, 0), -1, -1));
        jPanel5.add((Component)jPanel6, new GridConstraints(0, 0, 1, 1, 0, 3, 3, 3, null, null, null, 0, false));
        this.newConfig = new JButton();
        this.newConfig.setText("\u0414\u043e\u0431\u0430\u0432\u0438\u0442\u044c");
        jPanel6.add((Component)this.newConfig, new GridConstraints(0, 0, 1, 1, 0, 1, 3, 0, null, null, null, 0, false));
        this.deleteConfig = new JButton();
        this.deleteConfig.setText("\u0423\u0434\u0430\u043b\u0438\u0442\u044c");
        jPanel6.add((Component)this.deleteConfig, new GridConstraints(0, 1, 1, 1, 0, 1, 3, 0, null, null, null, 0, false));
        this.duplicateConfig = new JButton();
        this.duplicateConfig.setText("\u0414\u0443\u0431\u043b\u0438\u0440\u043e\u0432\u0430\u0442\u044c");
        jPanel6.add((Component)this.duplicateConfig, new GridConstraints(1, 0, 1, 1, 0, 1, 3, 0, null, null, null, 0, false));
        this.refresh = new JButton();
        this.refresh.setHorizontalTextPosition(11);
        this.refresh.setInheritsPopupMenu(true);
        this.refresh.setMargin(new Insets(2, 14, 2, 14));
        this.refresh.setText("\u041e\u0431\u043d\u043e\u0432\u0438\u0442\u044c");
        jPanel6.add((Component)this.refresh, new GridConstraints(1, 1, 1, 1, 0, 1, 3, 0, null, null, null, 0, false));
        this.saveAll = new JButton();
        this.saveAll.setText("\u0421\u043e\u0445\u0440\u0430\u043d\u0438\u0442\u044c \u0432\u0441\u0435");
        jPanel5.add((Component)this.saveAll, new GridConstraints(1, 0, 1, 1, 0, 1, 3, 0, null, null, null, 0, false));
        JPanel jPanel7 = new JPanel();
        jPanel7.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        this.root.add((Component)jPanel7, new GridConstraints(1, 0, 1, 1, 0, 3, 3, 1, null, null, null, 0, false));
        jPanel7.setBorder(BorderFactory.createTitledBorder("\u041e\u0442\u043b\u0430\u0434\u043a\u0430"));
        this.debugPanel = new JPanel();
        this.debugPanel.setLayout(new FlowLayout(1, 5, 5));
        jPanel7.add((Component)this.debugPanel, new GridConstraints(0, 0, 1, 1, 0, 3, 3, 3, null, null, null, 0, false));
    }

    public JComponent $$$getRootComponent$$$() {
        return this.root;
    }

    private MutantConfigEdit(ConfigEditPermissions configEditPermissions) {
        this.$$$setupUI$$$();
        instance = this;
        this.perms = configEditPermissions;
        this.updateStateTimer = new Timer(200, actionEvent -> {
            boolean bl = false;
            ArrayList<ConfigEntry> arrayList = new ArrayList<ConfigEntry>();
            arrayList.addAll(this.configs);
            for (ConfigEntry configEntry : arrayList) {
                if (configEntry.isDirty == configEntry.hasChanges()) continue;
                configEntry.isDirty = configEntry.hasChanges();
                bl = true;
            }
            if (bl) {
                SwingUtilities.invokeLater(() -> SwingUtilities.updateComponentTreeUI(this.configList));
            }
        });
        this.dropSettings.addActionListener(actionEvent -> {
            LootGroupEdit lootGroupEdit = LootGroupEdit.createWindow(this.getActiveEntry().config.getCommon().getLootConfig(), true);
            this.getActiveEntry().config.getCommon().setLootConfig(lootGroupEdit.getLootConfiguration());
        });
        this.configList.setSelectionMode(0);
        this.configList.addListSelectionListener(listSelectionEvent -> {
            this.invokedFromListListener = true;
            this.selectConfigIndex(this.configList.getSelectedIndex(), false);
            this.invokedFromListListener = false;
        });
        this.configList.setCellRenderer(new DefaultListCellRenderer(){

            @Override
            public Component getListCellRendererComponent(JList jList, Object object, int n, boolean bl, boolean bl2) {
                ConfigEntry configEntry = (ConfigEntry)MutantConfigEdit.this.configs.get(n);
                return super.getListCellRendererComponent((JList<?>)jList, object.toString() + (configEntry.isDirty ? "*" : ""), n, bl, bl2);
            }
        });
        this.configId.addActionListener(actionEvent -> {
            if (this.validateConfigName(this.configId.getText(), this.getActiveEntry())) {
                this.updateConfigName(this.getActiveEntry());
            } else {
                Toolkit.getDefaultToolkit().beep();
            }
        });
        this.deleteConfig.addActionListener(actionEvent -> {
            if (this.confirm("\u042d\u0442\u0430 \u043e\u043f\u0435\u0440\u0430\u0446\u0438\u044f \u0443\u0434\u0430\u043b\u0438\u0442 \u0432\u044b\u0431\u0440\u0430\u043d\u043d\u0443\u044e \u043a\u043e\u043d\u0444\u0438\u0433\u0443\u0440\u0430\u0446\u0438\u044e. \u041f\u0440\u043e\u0434\u043e\u043b\u0436\u0438\u0442\u044c?")) {
                this.deleteConfig();
            }
        });
        this.newConfig.addActionListener(actionEvent -> {
            MutantConfiguration mutantConfiguration = this.createConfig(null);
            if (mutantConfiguration != null) {
                this.addConfig(mutantConfiguration, false);
            }
        });
        this.duplicateConfig.addActionListener(actionEvent -> {
            MutantConfiguration mutantConfiguration = this.createConfig(this.getActiveEntry().config);
            if (mutantConfiguration != null) {
                this.addConfig(mutantConfiguration, false);
            }
        });
        this.cloneSettings.addActionListener(actionEvent -> {
            MutantConfiguration mutantConfiguration;
            String string = this.getActiveEntry().config.getCommon().getName();
            Set<String> set = MutantConfigHelper.CLIENT.getEditableMobConfigs().keySet();
            Object[] objectArray = set.toArray(new String[set.size()]);
            String string2 = (String)JOptionPane.showInputDialog(null, "\u0412\u044b\u0431\u0435\u0440\u0438\u0442\u0435 \u043a\u043e\u043d\u0444\u0438\u0433\u0443\u0440\u0430\u0446\u0438\u044e \u0434\u043b\u044f \u043a\u043b\u043e\u043d\u0438\u0440\u043e\u0432\u0430\u043d\u0438\u044f", "\u0412\u044b\u0431\u043e\u0440", 3, null, objectArray, objectArray[0]);
            if (string2 != null && (mutantConfiguration = MutantConfigHelper.CLIENT.getMobConfiguration(string2)) != null) {
                this.getActiveEntry().config.cloneFrom(mutantConfiguration);
                this.getActiveEntry().config.getCommon().setName(string);
                this.getActiveEntry().config.setParentConfiguration(mutantConfiguration);
                for (Map.Entry<String, Boolean> entry : this.getActiveEntry().config.getInheritField().entrySet()) {
                    this.getActiveEntry().config.getInheritField().put(entry.getKey(), true);
                }
                tdws._a(this.lastTypeComboBox, this.getActiveEntry().config.getCommon().getEntityClass());
            }
        });
        this.cancelEdits.addActionListener(actionEvent -> {
            if (this.confirm("\u042d\u0442\u0430 \u043e\u043f\u0435\u0440\u0430\u0446\u0438\u044f \u043e\u0442\u043c\u0435\u043d\u0438\u0442 \u0432\u0441\u0435 \u0438\u0437\u043c\u0435\u043d\u0435\u043d\u0438\u044f \u0434\u043b\u044f \u0434\u0430\u043d\u043d\u043e\u0439 \u043a\u043e\u043d\u0444\u0438\u0433\u0443\u0440\u0430\u0446\u0438\u0438. \u041f\u0440\u043e\u0434\u043e\u043b\u0436\u0438\u0442\u044c?")) {
                this.getActiveEntry().resetConfig();
                this.selectConfigIndex(this.selectedConfigIdx, true);
            }
        });
        this.save.addActionListener(actionEvent -> {
            if (this.confirm("\u042d\u0442\u0430 \u043e\u043f\u0435\u0440\u0430\u0446\u0438\u044f \u0441\u043e\u0445\u0440\u0430\u043d\u0438\u0442 \u0432\u0441\u0435 \u0438\u0437\u043c\u0435\u043d\u0435\u043d\u0438\u044f \u0434\u043b\u044f \u0434\u0430\u043d\u043d\u043e\u0439 \u043a\u043e\u043d\u0444\u0438\u0433\u0443\u0440\u0430\u0446\u0438\u0438. \u041f\u0440\u043e\u0434\u043e\u043b\u0436\u0438\u0442\u044c?")) {
                this.saveConfig(this.getActiveEntry());
                SwingUtilities.invokeLater(() -> SwingUtilities.updateComponentTreeUI(this.root));
            }
        });
        this.saveAll.addActionListener(actionEvent -> {
            if (this.confirm("\u042d\u0442\u0430 \u043e\u043f\u0435\u0440\u0430\u0446\u0438\u044f \u0441\u043e\u0445\u0440\u0430\u043d\u0438\u0442 \u0412\u0421\u0415 \u043a\u043e\u043d\u0444\u0438\u0433\u0443\u0440\u0430\u0446\u0438\u0438. \u041f\u0440\u043e\u0434\u043e\u043b\u0436\u0438\u0442\u044c?")) {
                for (ConfigEntry configEntry : this.configs) {
                    this.saveConfig(configEntry);
                }
                SwingUtilities.invokeLater(() -> SwingUtilities.updateComponentTreeUI(this.root));
            }
        });
        this.refresh.addActionListener(actionEvent -> {
            if (this.confirm("\u042d\u0442\u0430 \u043e\u043f\u0435\u0440\u0430\u0446\u0438\u044f \u0441\u043a\u0430\u0447\u0430\u0435\u0442 \u0432\u0441\u0435 \u0438\u0437\u043c\u0435\u043d\u0435\u043d\u0438\u044f \u0441 \u0441\u0435\u0440\u0432\u0435\u0440\u0430 \u0438 \u043f\u0435\u0440\u0435\u0437\u0430\u043f\u0438\u0448\u0435\u0442 \u0432\u0441\u0435 \u043a\u043e\u043d\u0444\u0438\u0433\u0443\u0440\u0430\u0446\u0438\u0438. \n\u0412\u0441\u0435 \u0432\u0430\u0448\u0438 \u0438\u0437\u043c\u0435\u043d\u0435\u043d\u0438\u044f \u043f\u0440\u043e\u043f\u0430\u0434\u0443\u0442. \u041f\u0440\u043e\u0434\u043e\u043b\u0436\u0438\u0442\u044c?")) {
                new PacketConfigList(Collections.emptyMap(), true).sendToServer();
            }
        });
        this.spawnMutant.addActionListener(actionEvent -> new PacketConfigTest(this.getActiveEntry().config).sendToServer());
        if (configEditPermissions != ConfigEditPermissions.VIEWER) {
            EditorPropertyGroup<DebugDrawInfo> editorPropertyGroup = new EditorPropertyGroup<DebugDrawInfo>(StalkerMobsClient.getInstance().getDebugInfo(), "");
            EditorPropertyController editorPropertyController = new EditorPropertyController(editorPropertyGroup);
            SwingPropertyEditor swingPropertyEditor = new SwingPropertyEditor();
            this.debugPanel.add(swingPropertyEditor.setup(editorPropertyController, Collections.emptyMap(), 3, false));
        }
        if (configEditPermissions != ConfigEditPermissions.SPECIAL_CONFIG_EDIT) {
            new PacketConfigList(Collections.emptyMap(), true).sendToServer();
        }
    }

    private void uploadConfigAdd(ConfigEntry configEntry) {
        MutantConfiguration mutantConfiguration = configEntry.config.cloned();
        MutantConfigHelper.CLIENT.addMobConfig(mutantConfiguration);
        new PacketConfigAdd(mutantConfiguration).sendToServer();
    }

    private void uploadConfigDelete(String string) {
        MutantConfigHelper.CLIENT.deleteMobConfig(string);
        new PacketConfigDelete(string).sendToServer();
    }

    private boolean confirm(String string) {
        return JOptionPane.showConfirmDialog(null, string, "\u041f\u043e\u0434\u0442\u0432\u0435\u0440\u0434\u0438\u0442\u044c", 0) == 0;
    }

    private void uploadConfigDelete(ConfigEntry configEntry) {
        this.uploadConfigDelete(configEntry.config.getCommon().getName());
    }

    private void startTimer() {
        this.updateStateTimer.start();
    }

    private void onConfigSelected() {
        this.configId.setText("");
        if (this.selectedConfigIdx >= 0) {
            MutantConfiguration mutantConfiguration = this.getActiveEntry().config;
            this.configId.setText(mutantConfiguration.getCommon().getName());
            this.lastTypeComboBox = new JComboBox<Object>(MutantRegistry.INSTANCE.getRegisteredMobs().keySet().toArray());
            this.lastTypeComboBox.addActionListener(actionEvent -> this.updateProperties(mutantConfiguration));
            tdws._a(this.lastTypeComboBox, this.getActiveEntry().config.getCommon().getEntityClass());
        } else if (this.lastPropertyUser != null) {
            this.propertyPanel.remove(this.lastPropertyUser);
            this.lastPropertyUser = null;
        }
    }

    private void updateProperties(MutantConfiguration mutantConfiguration) {
        SwingUtilities.invokeLater(() -> {
            Object object;
            if (this.lastPropertyUser != null) {
                this.propertyPanel.remove(this.lastPropertyUser);
            }
            if (mutantConfiguration.getParentConfigurationName() != null && (object = MutantConfigHelper.CLIENT.getMobConfiguration(mutantConfiguration.getParentConfigurationName())) != null) {
                mutantConfiguration.setParentConfiguration((MutantConfiguration)object);
                mutantConfiguration.extractInheritedValues();
            }
            object = new SwingPropertyEditor();
            this.lastPropertyUser = ((SwingPropertyEditor)object).setup(this.getActiveEntry().createController(), ImmutableMap.of("\u041a\u043b\u0430\u0441\u0441 \u0441\u0443\u0449\u043d\u043e\u0441\u0442\u0438", () -> new SwingPropertyEditor.DropDownListWrapper(this.lastTypeComboBox)), true);
            ((SwingPropertyEditor)object).getPopulatedCheckboxes().forEach((string, pair) -> {
                Boolean bl = mutantConfiguration.getInheritField().get(string);
                if (bl == null) {
                    bl = false;
                }
                ((JCheckBox)pair.component2()).setSelected(bl);
                SwingUtilities.invokeLater(() -> {
                    ((JCheckBox)pair.component2()).addActionListener(actionEvent -> {
                        mutantConfiguration.getInheritField().put((String)string, ((JCheckBox)pair.component2()).isSelected());
                        this.enableComponents((Container)((SwingPropertyEditor.ComponentWrapper)pair.component1()).getComponent(), !((JCheckBox)pair.component2()).isSelected());
                        try {
                            mutantConfiguration.extractInheritedValues();
                        }
                        catch (Exception exception) {
                            exception.printStackTrace();
                        }
                    });
                    this.enableComponents((Container)((SwingPropertyEditor.ComponentWrapper)pair.component1()).getComponent(), !((JCheckBox)pair.component2()).isSelected());
                });
            });
            this.propertyPanel.add(this.lastPropertyUser);
            String string2 = mutantConfiguration.getParentConfigurationName();
            if (string2 == null) {
                string2 = "";
            }
            this.propertyPanel.setBorder(BorderFactory.createTitledBorder(mutantConfiguration.getCommon().getName() + ":" + string2));
            this.enableComponents(this.propertyPanel, this.perms != ConfigEditPermissions.VIEWER);
            SwingUtilities.updateComponentTreeUI(this.root);
        });
    }

    private void enableComponents(Container container, boolean bl) {
        Component[] componentArray;
        for (Component component : componentArray = container.getComponents()) {
            component.setEnabled(bl);
            if (!(component instanceof Container)) continue;
            this.enableComponents((Container)component, bl);
        }
    }

    private void selectConfigIndex(int n, boolean bl) {
        if (!this.invokedFromListListener) {
            this.configList.setSelectedIndex(n);
        }
        if (this.invokedFromListListener || bl) {
            this.selectedConfigIdx = n;
            this.onConfigSelected();
            this.updateUiEnabledState();
        }
    }

    private void updateUiEnabledState() {
        boolean bl;
        boolean bl2 = bl = this.selectedConfigIdx >= 0;
        if (this.perms == ConfigEditPermissions.VIEWER) {
            bl = false;
        }
        this.duplicateConfig.setEnabled(bl);
        this.save.setEnabled(bl);
        this.cloneSettings.setEnabled(bl);
        this.deleteConfig.setEnabled(bl);
        this.spawnMutant.setEnabled(bl);
        this.configId.setEnabled(bl);
        this.dropSettings.setEnabled(bl);
        this.basicPanel.setEnabled(bl);
        this.generatedSettings.setEnabled(bl);
        this.idLabel.setEnabled(bl);
        this.cancelEdits.setEnabled(bl);
        this.refresh.setEnabled(bl);
        this.cloneSettings.setEnabled(bl);
        this.updateUiPermissions();
        SwingUtilities.invokeLater(() -> SwingUtilities.updateComponentTreeUI(this.root));
    }

    private void updateUiPermissions() {
        if (this.perms == ConfigEditPermissions.SPECIAL_CONFIG_EDIT || this.perms == ConfigEditPermissions.VIEWER) {
            this.spawnMutant.setEnabled(false);
            this.duplicateConfig.setEnabled(false);
            this.newConfig.setEnabled(false);
            this.deleteConfig.setEnabled(false);
            this.configId.setEnabled(false);
            this.configList.setEnabled(false);
            this.refresh.setEnabled(false);
            this.saveAll.setEnabled(false);
            if (this.perms == ConfigEditPermissions.VIEWER) {
                this.newConfig.setEnabled(false);
                this.saveAll.setEnabled(false);
                this.configList.setEnabled(true);
            }
        }
    }

    private void clearConfigs() {
        this.configs.clear();
        this.getListModel().removeAllElements();
        this.selectConfigIndex(-1, true);
    }

    public static void setup(MutantConfiguration mutantConfiguration) {
        MutantConfigEdit.setup(ImmutableList.of(mutantConfiguration));
    }

    public static void setup(Collection<MutantConfiguration> collection) {
        if (instance != null) {
            instance.clearConfigs();
            for (MutantConfiguration mutantConfiguration : collection) {
                instance.addConfig(mutantConfiguration, true);
            }
            SwingUtilities.invokeLater(() -> instance.selectConfigIndex(MutantConfigEdit.instance.configs.size() - 1, false));
        }
    }

    private MutantConfiguration createConfig(MutantConfiguration mutantConfiguration) {
        String string = JOptionPane.showInputDialog(null, "\u0412\u0432\u0435\u0434\u0438\u0442\u0435 \u0438\u043c\u044f \u043d\u043e\u0432\u043e\u0439 \u043a\u043e\u043d\u0444\u0438\u0433\u0443\u0440\u0430\u0446\u0438\u0438", "\u0421\u043e\u0437\u0434\u0430\u043d\u0438\u0435 \u043a\u043e\u043d\u0444\u0438\u0433\u0443\u0440\u0430\u0446\u0438\u0438", -1);
        if (string != null) {
            while (!this.validateConfigName(string, null) && (string = JOptionPane.showInputDialog(null, "\u041a\u043e\u043d\u0444\u0438\u0433\u0443\u0440\u0430\u0446\u0438\u044f \u0441 \u0442\u0430\u043a\u0438\u043c \u0438\u043c\u0435\u043d\u0435\u043c \u0443\u0436\u0435 \u0441\u0443\u0449\u0435\u0441\u0442\u0432\u0443\u0435\u0442, \u043b\u0438\u0431\u043e \u0432\u0432\u0435\u0434\u0435\u043d\u043e\u0435 \u0441\u043e\u0434\u0435\u0440\u0436\u0438\u0442 \u043d\u0435\u0434\u043e\u043f\u0443\u0441\u0442\u0438\u043c\u044b\u0435 \u0441\u0438\u043c\u0432\u043e\u043b\u044b. \u0422\u0430\u043a\u0436\u0435, \u0438\u043c\u044f \u043a\u043e\u043d\u0444\u0438\u0433\u0443\u0440\u0430\u0446\u0438\u0438 \u0434\u043e\u043b\u0436\u043d\u043e \u0438\u043c\u0435\u0442\u044c \u043d\u0435\u043d\u0443\u043b\u0435\u0432\u0443\u044e \u0434\u043b\u0438\u043d\u0443. \u0412\u0432\u0435\u0434\u0438\u0442\u0435 \u0438\u043c\u044f \u043d\u043e\u0432\u043e\u0439 \u043a\u043e\u043d\u0444\u0438\u0433\u0443\u0440\u0430\u0446\u0438\u0438", "\u0421\u043e\u0437\u0434\u0430\u043d\u0438\u0435 \u043a\u043e\u043d\u0444\u0438\u0433\u0443\u0440\u0430\u0446\u0438\u0438", 2)) != null) {
            }
            if (string != null) {
                MutantConfiguration mutantConfiguration2 = mutantConfiguration != null ? mutantConfiguration.cloned() : new MutantConfiguration();
                mutantConfiguration2.getCommon().setName(string);
                return mutantConfiguration2;
            }
        }
        return null;
    }

    private void saveConfig(ConfigEntry configEntry) {
        if (this.perms == ConfigEditPermissions.VIEWER) {
            return;
        }
        boolean bl = true;
        for (ConfigEntry configEntry2 : this.configs) {
            if (!Objects.equals(configEntry2.config.getCommon().getName(), configEntry.initialConfig.getCommon().getName())) continue;
            bl = false;
            break;
        }
        if (bl) {
            this.uploadConfigDelete(configEntry.initialConfig.getCommon().getName());
        }
        configEntry.updateConfigDirtyness();
        this.uploadConfigAdd(configEntry);
    }

    private void addConfig(MutantConfiguration mutantConfiguration, boolean bl) {
        ConfigEntry configEntry = new ConfigEntry(mutantConfiguration.cloned());
        this.configs.add(configEntry);
        this.sortConfigs();
        if (!bl) {
            this.uploadConfigAdd(configEntry);
            SwingUtilities.invokeLater(() -> this.selectConfigIndex(this.configs.indexOf(configEntry), false));
        }
    }

    private void sortConfigs() {
        Collections.sort(this.configs);
        this.getListModel().removeAllElements();
        for (ConfigEntry configEntry : this.configs) {
            this.getListModel().addElement(configEntry.config.getCommon().getName());
        }
    }

    private void deleteConfig() {
        int n = this.selectedConfigIdx;
        ConfigEntry configEntry = this.configs.remove(this.selectedConfigIdx);
        this.uploadConfigDelete(configEntry);
        this.getListModel().remove(this.selectedConfigIdx);
        if (n > this.getListModel().size() - 1) {
            n = this.getListModel().size() - 1;
        }
        this.selectConfigIndex(n, false);
    }

    private boolean validateConfigName(String string, ConfigEntry configEntry) {
        for (ConfigEntry configEntry2 : this.configs) {
            if (configEntry2 == configEntry || !string.equalsIgnoreCase(configEntry2.config.getCommon().getName())) continue;
            return false;
        }
        return ClientConfigHelper.INSTANCE.validateName(string);
    }

    private void updateConfigName(ConfigEntry configEntry) {
        if (this.validateConfigName(this.configId.getText(), configEntry)) {
            configEntry.config.getCommon().setName(this.configId.getText());
        }
        this.getListModel().setElementAt(configEntry.config.getCommon().getName(), this.selectedConfigIdx);
        this.propertyPanel.setBorder(BorderFactory.createTitledBorder(configEntry.config.getCommon().getName()));
        this.sortConfigs();
        this.selectConfigIndex(this.configs.indexOf(configEntry), false);
    }

    private List<ConfigEntry> changedConfigs() {
        ArrayList<ConfigEntry> arrayList = new ArrayList<ConfigEntry>();
        for (ConfigEntry configEntry : this.configs) {
            if (!configEntry.isDirty) continue;
            arrayList.add(configEntry);
        }
        return arrayList;
    }

    private boolean hasChanges() {
        for (ConfigEntry configEntry : this.configs) {
            if (!configEntry.isDirty) continue;
            return true;
        }
        return false;
    }

    private DefaultListModel<String> getListModel() {
        return (DefaultListModel)this.configList.getModel();
    }

    private ConfigEntry getActiveEntry() {
        return this.configs.get(this.selectedConfigIdx);
    }

    private void createUIComponents() {
    }

    public static boolean openEditor(ConfigEditPermissions configEditPermissions) {
        if (!MutantConfigEdit.isWindowOpened()) {
            MutantConfigEdit.createWindow(configEditPermissions);
            return true;
        }
        return false;
    }

    public static boolean isWindowOpened() {
        return instance != null && !MutantConfigEdit.instance.wasClosed;
    }

    private static MutantConfigEdit createWindow(final ConfigEditPermissions configEditPermissions) {
        final MutantConfigEdit mutantConfigEdit = new MutantConfigEdit(configEditPermissions);
        try {
            SwingUtilities.invokeAndWait(() -> {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                }
                catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException exception) {
                    exception.printStackTrace();
                }
                final JFrame jFrame = new JFrame("\u0420\u0435\u0434\u0430\u043a\u0442\u043e\u0440 \u043a\u043e\u043d\u0444\u0438\u0433\u0443\u0440\u0430\u0446\u0438\u0439");
                jFrame.setDefaultCloseOperation(0);
                jFrame.addWindowListener(new WindowListener(){

                    @Override
                    public void windowClosing(WindowEvent windowEvent) {
                        boolean bl = true;
                        if (mutantConfigEdit.hasChanges() && configEditPermissions != ConfigEditPermissions.VIEWER) {
                            Object[] objectArray = new String[]{"\u0414\u0430", "\u041d\u0435\u0442", "\u0414\u0430 (\u043a\u043e \u0432\u0441\u0435\u043c \u043a\u043e\u043d\u0444\u0438\u0433\u0443\u0440\u0430\u0446\u0438\u044f\u043c)", "\u041e\u0442\u043c\u0435\u043d\u0430"};
                            List list2 = mutantConfigEdit.changedConfigs();
                            for (int i = 0; i < list2.size(); ++i) {
                                ConfigEntry configEntry = (ConfigEntry)list2.get(i);
                                Integer n = JOptionPane.showOptionDialog(null, "\u0418\u043c\u0435\u044e\u0442\u0441\u044f \u043d\u0435\u0441\u043e\u0445\u0440\u0430\u043d\u0435\u043d\u043d\u044b\u0435 \u0438\u0437\u043c\u0435\u043d\u0435\u043d\u0438\u044f. \u0421\u043e\u0445\u0440\u0430\u043d\u0438\u0442\u044c \u043a\u043e\u043d\u0444\u0438\u0433\u0443\u0440\u0430\u0446\u0438\u044e " + configEntry.config.getCommon().getName() + "?", "\u041f\u043e\u0434\u0442\u0432\u0435\u0440\u0436\u0434\u0435\u043d\u0438\u0435", -1, 3, null, objectArray, objectArray[3]);
                                if (n == 0) {
                                    mutantConfigEdit.saveConfig(configEntry);
                                    continue;
                                }
                                if (n == 2) {
                                    for (ConfigEntry configEntry2 : mutantConfigEdit.configs) {
                                        mutantConfigEdit.saveConfig(configEntry2);
                                    }
                                    break;
                                }
                                if (n == 3) {
                                    bl = false;
                                    break;
                                }
                                if (n == 1) continue;
                                bl = false;
                                --i;
                            }
                        }
                        if (bl) {
                            jFrame.dispose();
                        }
                    }

                    @Override
                    public void windowClosed(WindowEvent windowEvent) {
                        if (mutantConfigEdit.updateStateTimer != null) {
                            mutantConfigEdit.updateStateTimer.stop();
                            mutantConfigEdit.updateStateTimer = null;
                        }
                        mutantConfigEdit.wasClosed = true;
                    }

                    @Override
                    public void windowIconified(WindowEvent windowEvent) {
                    }

                    @Override
                    public void windowDeiconified(WindowEvent windowEvent) {
                    }

                    @Override
                    public void windowActivated(WindowEvent windowEvent) {
                    }

                    @Override
                    public void windowDeactivated(WindowEvent windowEvent) {
                    }

                    @Override
                    public void windowOpened(WindowEvent windowEvent) {
                    }
                });
                jFrame.add(mutantConfigEdit.root);
                jFrame.setLocationRelativeTo(null);
                mutantConfigEdit.updateUiEnabledState();
                mutantConfigEdit.startTimer();
                int n = 800;
                int n2 = 700;
                jFrame.setSize(n, n2);
                jFrame.setLocation(Math.max(Display.getX(), 0), Math.min(Display.getY(), Display.getDesktopDisplayMode().getHeight() - n2));
                jFrame.setVisible(true);
                jFrame.requestFocus();
                jFrame.toFront();
                SwingUtilities.updateComponentTreeUI(jFrame);
            });
        }
        catch (InterruptedException | InvocationTargetException exception) {
            exception.printStackTrace();
        }
        return mutantConfigEdit;
    }

    private class ConfigEntry
    implements Comparable<ConfigEntry> {
        MutantConfiguration initialConfig;
        String initialConfigJson;
        MutantConfiguration config;
        boolean isDirty = false;
        private EditorPropertyController _controller;

        ConfigEntry(MutantConfiguration mutantConfiguration) {
            this.config = mutantConfiguration;
            this.initialConfig = mutantConfiguration.cloned();
            this.initialConfigJson = this.initialConfig.toJson();
        }

        boolean hasChanges() {
            return !Objects.equals(this.config.toJson(), this.initialConfigJson);
        }

        void resetConfig() {
            this.config = this.initialConfig.cloned();
        }

        void updateConfigDirtyness() {
            this.initialConfig = this.config.cloned();
            this.initialConfigJson = this.initialConfig.toJson();
        }

        EditorPropertyController createController() {
            this._controller = ClientConfigHelper.INSTANCE.getConfigController(this.config);
            return this._controller;
        }

        @Override
        public int compareTo(@NotNull ConfigEntry configEntry) {
            if (configEntry == null) {
                ConfigEntry.$$$reportNull$$$0(0);
            }
            return this.config.getCommon().getName().compareTo(configEntry.config.getCommon().getName());
        }

        private static /* synthetic */ void $$$reportNull$$$0(int n) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "o", "gloomyfolken/mods/stalker/mobs/client/tuning/gui/MutantConfigEdit$ConfigEntry", "compareTo"));
        }
    }
}

