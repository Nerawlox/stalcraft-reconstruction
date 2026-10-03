/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.mobs.client.tuning.gui;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.KeyboardFocusManager;
import java.awt.Window;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.ParseException;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;

public class LootItemEdit {
    private JButton ok;
    private JButton cancel;
    private JSpinner minQuantity;
    private JSpinner metadata;
    private JSpinner id;
    private JTextArea tag;
    private JLabel fine;
    private JPanel root;
    private JSpinner weight;
    private JSpinner maxQuantity;
    private boolean cancelled = false;
    private boolean valid = true;
    private static LootItemEdit lastWindow;

    public LootItemEdit() {
        this.$$$setupUI$$$();
        lastWindow = this;
        this.minQuantity.setModel(new SpinnerNumberModel(1, 1, 64, 1));
        this.metadata.setModel(new SpinnerNumberModel(0, 0, 15, 1));
        this.maxQuantity.setModel(new SpinnerNumberModel(1, 1, 64, 1));
        this.weight.setModel(new SpinnerNumberModel(1.0, 0.0, Double.POSITIVE_INFINITY, 0.5));
        this.id.setModel(new SpinnerNumberModel(0, 0, 64000, 1));
        this.ok.addActionListener(actionEvent -> this.close());
        this.cancel.addActionListener(actionEvent -> {
            this.cancel();
            this.close();
        });
        this.minQuantity.addChangeListener(changeEvent -> this.validateInput());
        this.maxQuantity.addChangeListener(changeEvent -> this.validateInput());
    }

    private boolean commitInput() {
        Component component = KeyboardFocusManager.getCurrentKeyboardFocusManager().getFocusOwner();
        if (component instanceof JFormattedTextField) {
            try {
                ((JFormattedTextField)component).commitEdit();
            }
            catch (ParseException parseException) {
                return false;
            }
        }
        return true;
    }

    private void validateInput() {
        boolean bl = (Integer)this.minQuantity.getValue() > (Integer)this.maxQuantity.getValue();
        this.valid = !bl;
        this.ok.setEnabled(this.valid);
        if (bl) {
            this.fine.setText("\u0423\u043a\u0430\u0437\u0430\u043d\u043e \u043d\u0435\u0432\u043e\u0437\u043c\u043e\u0436\u043d\u043e\u0435 \u043a\u043e\u043b-\u0432\u043e \u043f\u0440\u0435\u0434\u043c\u0435\u0442\u0430!");
        } else {
            this.fine.setText("\u0412\u0441\u0451 \u0445\u043e\u0440\u043e\u0448\u043e");
        }
    }

    private void close() {
        ((Window)SwingUtilities.getRoot(this.ok)).dispose();
    }

    public static void main(String[] stringArray) {
        JFrame jFrame = new JFrame("");
        LootItemEdit lootItemEdit = new LootItemEdit();
        jFrame.add(lootItemEdit.root);
        jFrame.setVisible(true);
        jFrame.pack();
    }

    private void cancel() {
        this.cancelled = true;
    }

    public void setFromItem(pzne pzne2) {
        if (pzne2 != null) {
            this.id.setValue(pzne2._c());
            this.metadata.setValue(pzne2._e());
            this.minQuantity.setValue(pzne2._d());
            this.maxQuantity.setValue(pzne2._d() + pzne2._g());
            this.tag.setText(ezob._a(pzne2._f()));
            this.weight.setValue(pzne2._h());
        }
    }

    public pzne getItem() {
        if (this.cancelled || !this.valid) {
            return null;
        }
        return new pzne((Integer)this.id.getValue(), (Integer)this.minQuantity.getValue(), (Integer)this.metadata.getValue(), ezob._a(this.tag.getText()), (Integer)this.maxQuantity.getValue() - (Integer)this.minQuantity.getValue(), (float)((Double)this.weight.getValue()).doubleValue());
    }

    public static LootItemEdit createWindow(pzne pzne2) {
        final LootItemEdit lootItemEdit = new LootItemEdit();
        lootItemEdit.setFromItem(pzne2);
        JDialog jDialog = new JDialog();
        jDialog.setDefaultCloseOperation(2);
        jDialog.add(lootItemEdit.root);
        jDialog.setModal(true);
        jDialog.setLocationRelativeTo(null);
        jDialog.pack();
        jDialog.setVisible(true);
        jDialog.addWindowListener(new WindowListener(){

            @Override
            public void windowClosing(WindowEvent windowEvent) {
                lootItemEdit.cancel();
            }

            @Override
            public void windowOpened(WindowEvent windowEvent) {
            }

            @Override
            public void windowClosed(WindowEvent windowEvent) {
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
        });
        return lootItemEdit;
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
        this.root = new JPanel();
        this.root.setLayout(new GridLayoutManager(3, 1, new Insets(5, 5, 5, 5), -1, -1));
        this.root.setBorder(BorderFactory.createTitledBorder("\u0420\u0435\u0434\u0430\u043a\u0442\u043e\u0440 \u0432\u044b\u043f\u0430\u0434\u0430\u0435\u043c\u043e\u0433\u043e \u043f\u0440\u0435\u0434\u043c\u0435\u0442\u0430"));
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new GridLayoutManager(1, 3, new Insets(0, 0, 0, 0), -1, -1));
        this.root.add((Component)jPanel, new GridConstraints(2, 0, 1, 1, 0, 3, 3, 1, null, null, null, 0, false));
        Spacer spacer = new Spacer();
        jPanel.add((Component)spacer, new GridConstraints(0, 1, 1, 1, 0, 1, 4, 1, null, null, null, 0, false));
        this.cancel = new JButton();
        this.cancel.setText("\u041e\u0442\u043c\u0435\u043d\u0430");
        jPanel.add((Component)this.cancel, new GridConstraints(0, 2, 1, 1, 0, 1, 3, 0, null, null, null, 0, false));
        this.ok = new JButton();
        this.ok.setText("OK");
        jPanel.add((Component)this.ok, new GridConstraints(0, 0, 1, 1, 0, 1, 3, 0, null, null, null, 0, false));
        JPanel jPanel2 = new JPanel();
        jPanel2.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        this.root.add((Component)jPanel2, new GridConstraints(1, 0, 1, 1, 0, 3, 3, 1, null, null, null, 0, false));
        this.fine = new JLabel();
        this.fine.setEnabled(false);
        this.fine.setText("\u0412\u0441\u0451 \u0445\u043e\u0440\u043e\u0448\u043e");
        jPanel2.add((Component)this.fine, new GridConstraints(0, 0, 1, 1, 8, 0, 0, 0, null, null, null, 0, false));
        JPanel jPanel3 = new JPanel();
        jPanel3.setLayout(new GridLayoutManager(6, 2, new Insets(0, 0, 0, 0), -1, -1));
        this.root.add((Component)jPanel3, new GridConstraints(0, 0, 1, 1, 0, 3, 3, 3, null, null, null, 0, false));
        this.id = new JSpinner();
        jPanel3.add((Component)this.id, new GridConstraints(0, 1, 1, 1, 8, 1, 5, 0, null, null, null, 0, false));
        JLabel jLabel = new JLabel();
        jLabel.setText("ID");
        jPanel3.add((Component)jLabel, new GridConstraints(0, 0, 1, 1, 8, 0, 0, 0, null, null, null, 0, false));
        JLabel jLabel2 = new JLabel();
        jLabel2.setText("\u041c\u0435\u0442\u0430\u0434\u0430\u0442\u0430");
        jPanel3.add((Component)jLabel2, new GridConstraints(1, 0, 1, 1, 8, 0, 0, 0, null, null, null, 0, false));
        JLabel jLabel3 = new JLabel();
        jLabel3.setText("\u041c\u0438\u043d. \u043a\u043e\u043b-\u0432\u043e");
        jPanel3.add((Component)jLabel3, new GridConstraints(2, 0, 1, 1, 8, 0, 0, 0, null, null, null, 0, false));
        JLabel jLabel4 = new JLabel();
        jLabel4.setText("\u041c\u0430\u043a\u0441. \u043a\u043e\u043b-\u0432\u043e");
        jPanel3.add((Component)jLabel4, new GridConstraints(3, 0, 1, 1, 8, 0, 0, 0, null, null, null, 0, false));
        JLabel jLabel5 = new JLabel();
        jLabel5.setText("\u0412\u0437\u0432\u0435\u0448.\u0448\u0430\u043d\u0441 \u0432 \u0433\u0440\u0443\u043f\u043f\u0435");
        jPanel3.add((Component)jLabel5, new GridConstraints(4, 0, 1, 1, 8, 0, 0, 0, null, null, null, 0, false));
        JLabel jLabel6 = new JLabel();
        jLabel6.setText("\u0421\u043f\u0435\u0446.\u0442\u0435\u0433");
        jPanel3.add((Component)jLabel6, new GridConstraints(5, 0, 1, 1, 8, 0, 0, 0, null, null, null, 0, false));
        this.weight = new JSpinner();
        jPanel3.add((Component)this.weight, new GridConstraints(4, 1, 1, 1, 8, 1, 5, 0, null, null, null, 0, false));
        this.maxQuantity = new JSpinner();
        jPanel3.add((Component)this.maxQuantity, new GridConstraints(3, 1, 1, 1, 8, 1, 5, 0, null, null, null, 0, false));
        this.minQuantity = new JSpinner();
        jPanel3.add((Component)this.minQuantity, new GridConstraints(2, 1, 1, 1, 8, 1, 5, 0, null, null, null, 0, false));
        this.metadata = new JSpinner();
        jPanel3.add((Component)this.metadata, new GridConstraints(1, 1, 1, 1, 8, 1, 5, 0, null, null, null, 0, false));
        JScrollPane jScrollPane = new JScrollPane();
        jPanel3.add((Component)jScrollPane, new GridConstraints(5, 1, 1, 1, 0, 3, 5, 5, null, new Dimension(-1, 34), null, 0, false));
        this.tag = new JTextArea();
        Font font = this.$$$getFont$$$("Monospaced", -1, 12, this.tag.getFont());
        if (font != null) {
            this.tag.setFont(font);
        }
        this.tag.setLineWrap(true);
        this.tag.setRows(1);
        this.tag.setText("");
        this.tag.setWrapStyleWord(false);
        jScrollPane.setViewportView(this.tag);
    }

    public JComponent $$$getRootComponent$$$() {
        return this.root;
    }

    static {
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(keyEvent -> {
            if (lastWindow != null && keyEvent.getKeyCode() == 10 && lastWindow.commitInput()) {
                lastWindow.validateInput();
                if (LootItemEdit.lastWindow.valid) {
                    lastWindow.close();
                }
            }
            return false;
        });
    }
}

