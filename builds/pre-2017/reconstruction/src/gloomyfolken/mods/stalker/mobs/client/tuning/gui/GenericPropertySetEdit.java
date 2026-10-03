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
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSeparator;

public class GenericPropertySetEdit<T> {
    private JPanel panel1;
    private JButton moveRight;
    private JButton moveLeft;
    private JButton allLeft;
    private JButton allRight;
    private JList leftList;
    private JList rightList;

    public GenericPropertySetEdit() {
        this.$$$setupUI$$$();
        this.moveLeft.addActionListener(actionEvent -> {});
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
        this.panel1 = new JPanel();
        this.panel1.setLayout(new GridLayoutManager(2, 1, new Insets(6, 6, 6, 6), -1, -1));
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new GridLayoutManager(2, 1, new Insets(0, 0, 0, 0), -1, -1));
        this.panel1.add((Component)jPanel, new GridConstraints(0, 0, 1, 1, 0, 3, 3, 1, null, null, null, 0, false));
        JLabel jLabel = new JLabel();
        Font font = this.$$$getFont$$$(null, 1, -1, jLabel.getFont());
        if (font != null) {
            jLabel.setFont(font);
        }
        jLabel.setText("\u0421\u043a\u0438\u043d\u044b");
        jPanel.add((Component)jLabel, new GridConstraints(0, 0, 1, 1, 8, 0, 0, 0, null, null, null, 0, false));
        JSeparator jSeparator = new JSeparator();
        Font font2 = this.$$$getFont$$$(null, 1, -1, jSeparator.getFont());
        if (font2 != null) {
            jSeparator.setFont(font2);
        }
        jPanel.add((Component)jSeparator, new GridConstraints(1, 0, 1, 1, 0, 3, 4, 4, null, null, null, 0, false));
        JPanel jPanel2 = new JPanel();
        jPanel2.setLayout(new GridLayoutManager(1, 3, new Insets(0, 0, 0, 0), -1, -1));
        this.panel1.add((Component)jPanel2, new GridConstraints(1, 0, 1, 1, 0, 3, 3, 3, null, null, null, 0, false));
        JPanel jPanel3 = new JPanel();
        jPanel3.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        jPanel2.add((Component)jPanel3, new GridConstraints(0, 0, 1, 1, 0, 3, 3, 3, null, null, null, 0, false));
        jPanel3.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLoweredBevelBorder(), null));
        this.leftList = new JList();
        jPanel3.add((Component)this.leftList, new GridConstraints(0, 0, 1, 1, 0, 3, 2, 4, null, new Dimension(150, 50), null, 0, false));
        JPanel jPanel4 = new JPanel();
        jPanel4.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        jPanel2.add((Component)jPanel4, new GridConstraints(0, 2, 1, 1, 0, 3, 3, 3, null, null, null, 0, false));
        jPanel4.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLoweredBevelBorder(), null));
        this.rightList = new JList();
        jPanel4.add((Component)this.rightList, new GridConstraints(0, 0, 1, 1, 0, 3, 2, 4, null, new Dimension(150, 50), null, 0, false));
        JPanel jPanel5 = new JPanel();
        jPanel5.setLayout(new GridLayoutManager(6, 1, new Insets(0, 0, 0, 0), -1, -1));
        jPanel2.add((Component)jPanel5, new GridConstraints(0, 1, 1, 1, 0, 3, 1, 3, null, null, null, 0, false));
        this.moveRight = new JButton();
        this.moveRight.setText(">");
        jPanel5.add((Component)this.moveRight, new GridConstraints(2, 0, 1, 1, 0, 1, 3, 0, null, null, null, 0, false));
        this.moveLeft = new JButton();
        this.moveLeft.setText("<");
        jPanel5.add((Component)this.moveLeft, new GridConstraints(1, 0, 1, 1, 0, 1, 3, 0, null, null, null, 0, false));
        Spacer spacer = new Spacer();
        jPanel5.add((Component)spacer, new GridConstraints(5, 0, 1, 1, 0, 2, 1, 4, null, null, null, 0, false));
        Spacer spacer2 = new Spacer();
        jPanel5.add((Component)spacer2, new GridConstraints(0, 0, 1, 1, 0, 2, 1, 4, null, null, null, 0, false));
        this.allLeft = new JButton();
        this.allLeft.setText("<<");
        jPanel5.add((Component)this.allLeft, new GridConstraints(3, 0, 1, 1, 0, 1, 3, 0, null, null, null, 0, false));
        this.allRight = new JButton();
        this.allRight.setText(">>");
        jPanel5.add((Component)this.allRight, new GridConstraints(4, 0, 1, 1, 0, 1, 3, 0, null, null, null, 0, false));
    }

    public JComponent $$$getRootComponent$$$() {
        return this.panel1;
    }
}

