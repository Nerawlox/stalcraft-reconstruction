/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.mobs.client.tuning.gui;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import gloomyfolken.mods.stalker.mobs.client.tuning.gui.LootItemEdit;
import gloomyfolken.mods.stalker.mobs.client.tuning.gui.TableColumnAdjuster;
import gloomyfolken.mods.stalker.mobs.client.tuning.gui.TextTransfer;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SpinnerNumberModel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import org.jetbrains.annotations.Nullable;

public class LootGroupEdit {
    private JPanel root;
    private JButton addGroup;
    private JButton removeGroup;
    private JButton groupAddItem;
    private JList itemGroups;
    private JButton groupEditItem;
    private JButton groupDeleteItem;
    private JSpinner groupChance;
    private JTable groupItems;
    private JPanel itemGroupPanel;
    private JTextField groupName;
    private JButton pasteFromClipboard;
    private List<flpm> lootItemGroups = new ArrayList<flpm>();
    private int currentGroupIdx = -1;

    public static void main(String[] stringArray) throws UnsupportedLookAndFeelException, IllegalAccessException, ClassNotFoundException, InstantiationException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        LootGroupEdit.createWindow(null, false);
    }

    public LootGroupEdit() {
        this.$$$setupUI$$$();
        this.groupChance.setModel(new SpinnerNumberModel(0.0, 0.0, Double.POSITIVE_INFINITY, 0.5));
        this.groupAddItem.addActionListener(actionEvent -> this.editItemAndAdd(null));
        this.groupEditItem.addActionListener(actionEvent -> this.editCurrentItem());
        this.groupDeleteItem.addActionListener(actionEvent -> {
            int n = this.groupItems.getSelectedRow();
            if (n >= 0) {
                this.getEditingGroup()._b.remove(n);
                this.showGroupItems(this.getEditingGroup());
                if (n >= this.getEditingGroup()._b.size()) {
                    n = this.getEditingGroup()._b.size() - 1;
                }
                if (n >= 0) {
                    this.groupItems.setRowSelectionInterval(n, n);
                } else {
                    this.groupItems.clearSelection();
                }
            }
        });
        this.addGroup.addActionListener(actionEvent -> this.addNewItemGroup(null));
        this.removeGroup.addActionListener(actionEvent -> {
            if (this.itemGroups.getSelectedIndex() >= 0 && JOptionPane.showConfirmDialog(null, "\u0412\u044b \u0442\u043e\u0447\u043d\u043e \u0445\u043e\u0442\u0438\u0442\u0435 \u0443\u0434\u0430\u043b\u0438\u0442\u044c \u044d\u0442\u0443 \u0433\u0440\u0443\u043f\u043f\u0443 \u043f\u0440\u0435\u0434\u043c\u0435\u0442\u043e\u0432?", "\u041f\u043e\u0434\u0442\u0432\u0435\u0440\u0436\u0434\u0435\u043d\u0438\u0435", 0) == 0) {
                this.removeItemGroup(this.itemGroups.getSelectedIndex());
                this.showGroupWithIndex(this.itemGroups.getSelectedIndex());
            }
        });
        this.groupsModel().removeAllElements();
        this.itemGroups.setSelectionMode(0);
        this.groupItems.setSelectionMode(0);
        this.itemGroups.addListSelectionListener(listSelectionEvent -> {
            this.currentGroupIdx = this.itemGroups.getSelectedIndex();
            this.showGroupWithIndex(this.currentGroupIdx);
        });
        this.groupChance.addChangeListener(changeEvent -> {
            this.getEditingGroup()._c = (float)((Double)this.groupChance.getValue()).doubleValue();
        });
        this.groupName.addActionListener(actionEvent -> {
            this.getEditingGroup()._a = this.groupName.getText();
            this.groupsModel().setElementAt(this.groupName.getText(), this.currentGroupIdx);
        });
        this.groupItems.addMouseListener(new MouseAdapter(){

            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                if (mouseEvent.getClickCount() == 2) {
                    LootGroupEdit.this.editCurrentItem();
                }
            }
        });
        AbstractAction abstractAction = new AbstractAction(){

            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                LootGroupEdit.this.pasteItemFromClipboard();
            }
        };
        this.pasteFromClipboard.addActionListener(actionEvent -> this.pasteItemFromClipboard());
        KeyStroke keyStroke = KeyStroke.getKeyStroke(86, 128);
        this.groupItems.getActionMap().put("Paste Tag", abstractAction);
        this.groupItems.getInputMap(1).put(keyStroke, "Paste Tag");
        this.enableComponents(this.itemGroupPanel, false);
    }

    private void editCurrentItem() {
        pzne pzne2;
        int n = this.groupItems.getSelectedRow();
        if (n >= 0 && (pzne2 = this.openItemEditor(this.getEditingGroup()._b.get(n))) != null) {
            this.getEditingGroup()._b.set(n, pzne2);
            this.showGroupItems(this.getEditingGroup());
        }
    }

    private void testInput() {
        pzne pzne2 = new pzne(2, 2, 0, null, 0, 1.0f);
        pzne pzne3 = new pzne(3, 5, 0, null, 0, 1.0f);
        pzne pzne4 = new pzne(4, 2, 0, null, 0, 5.0f);
        ArrayList<pzne> arrayList = new ArrayList<pzne>();
        ArrayList<pzne> arrayList2 = new ArrayList<pzne>();
        arrayList.add(pzne2);
        arrayList2.add(pzne3);
        arrayList2.add(pzne4);
        flpm flpm2 = new flpm("kok", arrayList, 1.0f);
        flpm flpm3 = new flpm("kok2", arrayList2, 1.0f);
        satl satl2 = new satl();
        satl2._a(flpm2);
        satl2._a(flpm3);
        this.setFromLoot(satl2);
    }

    private void pasteItemFromClipboard() {
        if (this.currentGroupIdx >= 0) {
            try {
                this.editItemAndAdd(dwkx._b.fromJson(TextTransfer.getInstance().getClipboardContents(), pzne.class));
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    private void editItemAndAdd(@Nullable pzne pzne2) {
        pzne pzne3 = this.openItemEditor(pzne2);
        if (pzne3 != null) {
            this.getEditingGroup()._b.add(pzne3);
            this.showGroupItems(this.getEditingGroup());
        }
    }

    private pzne openItemEditor(pzne pzne2) {
        LootItemEdit lootItemEdit = LootItemEdit.createWindow(pzne2);
        return lootItemEdit.getItem();
    }

    private flpm getEditingGroup() {
        return this.lootItemGroups.get(this.currentGroupIdx);
    }

    private void addNewItemGroup(flpm flpm2) {
        if (flpm2 == null) {
            flpm2 = new flpm("Unnamed group", new ArrayList<pzne>(), 1.0f);
        }
        this.currentGroupIdx = this.groupsModel().getSize();
        this.groupsModel().addElement(flpm2._a);
        this.lootItemGroups.add(flpm2);
        this.itemGroups.setSelectedIndex(this.currentGroupIdx);
    }

    private void removeItemGroup(int n) {
        if (n >= 0) {
            this.lootItemGroups.remove(n);
            this.groupsModel().removeElementAt(n);
            if (n >= this.groupsModel().size()) {
                n = this.groupsModel().size() - 1;
            }
            this.itemGroups.setSelectedIndex(n);
        }
    }

    private void showGroupWithIndex(int n) {
        this.enableComponents(this.itemGroupPanel, false);
        if (n >= 0) {
            flpm flpm2 = this.lootItemGroups.get(n);
            if (flpm2 != null) {
                this.showGroupItems(flpm2);
                this.enableComponents(this.itemGroupPanel, true);
            }
        } else {
            this.itemsModel().setRowCount(0);
        }
    }

    private void enableComponents(Container container, boolean bl) {
        Component[] componentArray;
        for (Component component : componentArray = container.getComponents()) {
            component.setEnabled(bl);
            if (!(component instanceof Container)) continue;
            this.enableComponents((Container)component, bl);
        }
    }

    private void showGroupItems(flpm flpm2) {
        this.itemsModel().setRowCount(flpm2._b.size());
        int n = 0;
        for (pzne pzne2 : flpm2._b) {
            String string;
            int n2 = 0;
            try {
                string = pzne2._k()._s();
            }
            catch (NullPointerException nullPointerException) {
                string = "invalid";
            }
            this.itemsModel().setValueAt(string, n, n2++);
            this.itemsModel().setValueAt(pzne2._c(), n, n2++);
            this.itemsModel().setValueAt(pzne2._e(), n, n2++);
            this.itemsModel().setValueAt(pzne2._d(), n, n2++);
            this.itemsModel().setValueAt(pzne2._d() + pzne2._g(), n, n2++);
            this.itemsModel().setValueAt(ezob._a(pzne2._f()), n, n2++);
            this.itemsModel().setValueAt(String.format("%.2f%%", Float.valueOf(pzne2._h() / flpm2._a() * 100.0f)), n, n2++);
            ++n;
        }
        this.groupChance.setValue(flpm2._c);
        this.groupName.setText(flpm2._a);
    }

    private DefaultListModel groupsModel() {
        return (DefaultListModel)this.itemGroups.getModel();
    }

    private DefaultTableModel itemsModel() {
        return (DefaultTableModel)this.groupItems.getModel();
    }

    public satl getLootConfiguration() {
        satl satl2 = new satl();
        satl2._a.addAll(this.lootItemGroups);
        return satl2;
    }

    public void setFromLoot(satl satl2) {
        this.lootItemGroups.clear();
        this.groupsModel().removeAllElements();
        this.enableComponents(this.itemGroupPanel, false);
        if (satl2 != null) {
            satl2._a.forEach(this::addNewItemGroup);
        }
    }

    public static LootGroupEdit createWindow(satl satl2, Boolean bl) {
        LootGroupEdit lootGroupEdit = new LootGroupEdit();
        lootGroupEdit.setFromLoot(satl2);
        JDialog jDialog = new JDialog((Frame)null, "\u0420\u0435\u0434\u0430\u043a\u0442\u043e\u0440 \u0434\u0440\u043e\u043f\u0430");
        jDialog.setModal(bl);
        jDialog.setDefaultCloseOperation(2);
        jDialog.add(lootGroupEdit.root);
        jDialog.pack();
        jDialog.setLocationRelativeTo(null);
        jDialog.setVisible(true);
        return lootGroupEdit;
    }

    private void createUIComponents() {
        this.groupItems = new JTable(new DefaultTableModel(new String[]{"\u041d\u0430\u0437\u0432\u0430\u043d\u0438\u0435 \u043f\u0440\u0435\u0434\u043c\u0435\u0442\u0430", "ID  ", "\u041c\u0435\u0442\u0430\u0434\u0430\u0442\u0430", "\u041c\u0438\u043d.\u0448\u0442", "\u041c\u0430\u043a\u0441.\u0448\u0442", "\u0422\u0435\u0433      ", "\u0428\u0430\u043d\u0441"}, 0)){

            @Override
            public boolean isCellEditable(int n, int n2) {
                return false;
            }
        };
        TableColumnAdjuster tableColumnAdjuster = new TableColumnAdjuster(this.groupItems);
        tableColumnAdjuster.setColumnHeaderIncluded(true);
        tableColumnAdjuster.adjustColumns();
    }

    private Font $$$getFont$$$(String string, int n, int n2, Font font) {
        Font font2;
        if (font == null) {
            return null;
        }
        String string2 = string == null ? font.getName() : ((font2 = new Font(string, 0, 10)).canDisplay('a') && font2.canDisplay('1') ? string : font.getName());
        return new Font(string2, n >= 0 ? n : font.getStyle(), n2 >= 0 ? n2 : font.getSize());
    }

    private void $$$setupUI$$$() {
        this.createUIComponents();
        this.root = new JPanel();
        this.root.setLayout(new GridLayoutManager(2, 1, new Insets(0, 0, 0, 0), -1, -1));
        this.root.setBorder(BorderFactory.createTitledBorder("\u0420\u0435\u0434\u0430\u043a\u0442\u043e\u0440 \u0432\u044b\u043f\u0430\u0434\u0430\u0435\u043c\u044b\u0445 \u043f\u0440\u0435\u0434\u043c\u0435\u0442\u043e\u0432"));
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new GridLayoutManager(1, 2, new Insets(0, 0, 0, 0), -1, -1));
        this.root.add((Component)jPanel, new GridConstraints(1, 0, 1, 1, 0, 3, 3, 0, null, null, null, 0, false));
        this.addGroup = new JButton();
        this.addGroup.setText("\u0414\u043e\u0431\u0430\u0432\u0438\u0442\u044c \u0433\u0440\u0443\u043f\u043f\u0443");
        jPanel.add((Component)this.addGroup, new GridConstraints(0, 0, 1, 1, 0, 1, 3, 0, null, null, null, 0, false));
        this.removeGroup = new JButton();
        this.removeGroup.setText("\u0423\u0434\u0430\u043b\u0438\u0442\u044c \u0433\u0440\u0443\u043f\u043f\u0443");
        jPanel.add((Component)this.removeGroup, new GridConstraints(0, 1, 1, 1, 0, 1, 3, 0, null, null, null, 0, false));
        JSplitPane jSplitPane = new JSplitPane();
        this.root.add((Component)jSplitPane, new GridConstraints(0, 0, 1, 1, 0, 3, 3, 3, null, new Dimension(200, 200), null, 0, false));
        JPanel jPanel2 = new JPanel();
        jPanel2.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        jSplitPane.setLeftComponent(jPanel2);
        jPanel2.setBorder(BorderFactory.createTitledBorder("\u0413\u0440\u0443\u043f\u043f\u044b \u043f\u0440\u0435\u0434\u043c\u0435\u0442\u043e\u0432"));
        JScrollPane jScrollPane = new JScrollPane();
        jPanel2.add((Component)jScrollPane, new GridConstraints(0, 0, 1, 1, 0, 3, 5, 5, new Dimension(200, -1), null, null, 0, false));
        JPanel jPanel3 = new JPanel();
        jPanel3.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        jScrollPane.setViewportView(jPanel3);
        this.itemGroups = new JList();
        DefaultListModel<String> defaultListModel = new DefaultListModel<String>();
        defaultListModel.addElement("");
        this.itemGroups.setModel(defaultListModel);
        jPanel3.add((Component)this.itemGroups, new GridConstraints(0, 0, 1, 1, 0, 3, 2, 4, null, new Dimension(150, 50), null, 0, false));
        this.itemGroupPanel = new JPanel();
        this.itemGroupPanel.setLayout(new GridLayoutManager(4, 4, new Insets(0, 0, 0, 0), -1, -1));
        jSplitPane.setRightComponent(this.itemGroupPanel);
        this.itemGroupPanel.setBorder(BorderFactory.createTitledBorder("\u0420\u0435\u0434\u0430\u043a\u0442\u043e\u0440 \u0433\u0440\u0443\u043f\u043f\u044b \u043f\u0440\u0435\u0434\u043c\u0435\u0442\u043e\u0432"));
        JPanel jPanel4 = new JPanel();
        jPanel4.setLayout(new GridLayoutManager(1, 5, new Insets(0, 0, 0, 0), -1, -1));
        this.itemGroupPanel.add((Component)jPanel4, new GridConstraints(3, 0, 1, 4, 0, 3, 3, 3, null, null, null, 0, false));
        this.groupAddItem = new JButton();
        this.groupAddItem.setText("\u0414\u043e\u0431\u0430\u0432\u0438\u0442\u044c \u043f\u0440\u0435\u0434\u043c\u0435\u0442");
        jPanel4.add((Component)this.groupAddItem, new GridConstraints(0, 0, 1, 1, 0, 1, 3, 0, null, null, null, 0, false));
        Spacer spacer = new Spacer();
        jPanel4.add((Component)spacer, new GridConstraints(0, 4, 1, 1, 0, 1, 4, 1, null, null, null, 0, false));
        this.groupEditItem = new JButton();
        this.groupEditItem.setText("\u0420\u0435\u0434\u0430\u043a\u0442\u0438\u0440\u043e\u0432\u0430\u0442\u044c");
        jPanel4.add((Component)this.groupEditItem, new GridConstraints(0, 1, 1, 1, 0, 1, 3, 0, null, null, null, 0, false));
        this.groupDeleteItem = new JButton();
        this.groupDeleteItem.setText("\u0423\u0434\u0430\u043b\u0438\u0442\u044c");
        jPanel4.add((Component)this.groupDeleteItem, new GridConstraints(0, 2, 1, 1, 0, 1, 3, 0, null, null, null, 0, false));
        this.pasteFromClipboard = new JButton();
        this.pasteFromClipboard.setText("\u0412\u0441\u0442\u0430\u0432\u0438\u0442\u044c \u0438\u0437 \u0431\u0443\u0444\u0435\u0440\u0430");
        jPanel4.add((Component)this.pasteFromClipboard, new GridConstraints(0, 3, 1, 1, 0, 1, 3, 0, null, null, null, 0, false));
        JPanel jPanel5 = new JPanel();
        jPanel5.setLayout(new GridLayoutManager(1, 2, new Insets(0, 0, 0, 0), -1, -1));
        this.itemGroupPanel.add((Component)jPanel5, new GridConstraints(2, 0, 1, 2, 8, 2, 1, 3, null, null, null, 0, false));
        JLabel jLabel = new JLabel();
        jLabel.setText("\u0428\u0430\u043d\u0441 \u0432\u044b\u043f\u0430\u0434\u0435\u043d\u0438\u044f \u0433\u0440\u0443\u043f\u043f\u044b \u043f\u0440\u0435\u0434\u043c\u0435\u0442\u043e\u0432");
        jPanel5.add((Component)jLabel, new GridConstraints(0, 1, 1, 1, 8, 0, 0, 0, null, null, null, 0, false));
        this.groupChance = new JSpinner();
        jPanel5.add((Component)this.groupChance, new GridConstraints(0, 0, 1, 1, 0, 1, 0, 4, null, new Dimension(60, -1), null, 0, false));
        JScrollPane jScrollPane2 = new JScrollPane();
        this.itemGroupPanel.add((Component)jScrollPane2, new GridConstraints(1, 0, 1, 4, 0, 3, 5, 5, null, null, null, 0, false));
        this.groupItems.setPreferredScrollableViewportSize(new Dimension(450, 120));
        jScrollPane2.setViewportView(this.groupItems);
        JLabel jLabel2 = new JLabel();
        jLabel2.setText("\u041d\u0430\u0437\u0432\u0430\u043d\u0438\u0435 \u0433\u0440\u0443\u043f\u043f\u044b");
        this.itemGroupPanel.add((Component)jLabel2, new GridConstraints(0, 0, 1, 1, 8, 0, 0, 0, null, null, null, 0, false));
        this.groupName = new JTextField();
        this.groupName.setText("");
        this.groupName.setToolTipText("\u0418\u043c\u044f \u0433\u0440\u0443\u043f\u043f\u044b");
        this.itemGroupPanel.add((Component)this.groupName, new GridConstraints(0, 1, 1, 1, 8, 1, 4, 0, null, new Dimension(150, -1), null, 0, false));
    }

    public JComponent $$$getRootComponent$$$() {
        return this.root;
    }
}

