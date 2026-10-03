/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jdesktop.layout.GroupLayout
 *  org.jdesktop.layout.GroupLayout$Group
 */
package com.bulletphysics.demos.applet;

import com.bulletphysics.demos.applet.DemoPanel;
import com.bulletphysics.demos.basic.BasicDemo;
import com.bulletphysics.demos.bsp.BspDemo;
import com.bulletphysics.demos.character.CharacterDemo;
import com.bulletphysics.demos.concave.ConcaveDemo;
import com.bulletphysics.demos.concaveconvexcast.ConcaveConvexcastDemo;
import com.bulletphysics.demos.dynamiccontrol.DynamicControlDemo;
import com.bulletphysics.demos.forklift.ForkLiftDemo;
import com.bulletphysics.demos.genericjoint.GenericJointDemo;
import com.bulletphysics.demos.movingconcave.MovingConcaveDemo;
import com.bulletphysics.demos.opengl.DemoApplication;
import com.bulletphysics.demos.opengl.IGL;
import com.bulletphysics.demos.vehicle.VehicleDemo;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import org.jdesktop.layout.GroupLayout;

public class JBulletApplet
extends JApplet {
    private DemoPanel demoPanel;
    private DemoEntry currentDemo;
    private JButton btnRestart;
    private JComboBox cmbDemos;
    private JLabel jLabel1;
    private JPanel mainPanel;
    private JPanel topPanel;

    @Override
    public void init() {
        try {
            EventQueue.invokeAndWait(new Runnable(){

                @Override
                public void run() {
                    try {
                        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    }
                    catch (Exception e) {
                        // empty catch block
                    }
                    JBulletApplet.this.initComponents();
                    JBulletApplet.this.topPanel.setBorder(new BevelBorder(0, new Color(0xCCCCCC), new Color(0xFFFFFF), new Color(0x333333), new Color(0x999999)));
                    final DefaultComboBoxModel model = (DefaultComboBoxModel)JBulletApplet.this.cmbDemos.getModel();
                    model.addElement("---");
                    model.addElement(new DemoEntry("Basic Demo", BasicDemo.class));
                    model.addElement(new DemoEntry("Generic Joint Demo", GenericJointDemo.class));
                    model.addElement(new DemoEntry("Bsp Demo", BspDemo.class));
                    model.addElement(new DemoEntry("Static Concave Mesh Demo", ConcaveDemo.class));
                    model.addElement(new DemoEntry("Vehicle Demo", VehicleDemo.class));
                    model.addElement(new DemoEntry("Dynamic Control Demo", DynamicControlDemo.class));
                    model.addElement(new DemoEntry("Moving Concave Demo", MovingConcaveDemo.class));
                    model.addElement(new DemoEntry("ForkLift Demo", ForkLiftDemo.class));
                    model.addElement(new DemoEntry("Concave Convexcast Demo", ConcaveConvexcastDemo.class));
                    model.addElement(new DemoEntry("Character Demo", CharacterDemo.class));
                    JBulletApplet.this.cmbDemos.addItemListener(new ItemListener(){

                        @Override
                        public void itemStateChanged(final ItemEvent e) {
                            if (e.getStateChange() == 1 && e.getItem() instanceof DemoEntry) {
                                EventQueue.invokeLater(new Runnable(){

                                    @Override
                                    public void run() {
                                        JBulletApplet.this.runDemo((DemoEntry)e.getItem());
                                    }
                                });
                                if (model.getElementAt(0) instanceof String) {
                                    model.removeElementAt(0);
                                    JBulletApplet.this.btnRestart.setEnabled(true);
                                }
                            }
                        }
                    });
                    JBulletApplet.this.btnRestart.addActionListener(new ActionListener(){

                        @Override
                        public void actionPerformed(ActionEvent e) {
                            JBulletApplet.this.currentDemo = null;
                            JBulletApplet.this.runDemo((DemoEntry)JBulletApplet.this.cmbDemos.getSelectedItem());
                        }
                    });
                    JBulletApplet.this.demoPanel = new DemoPanel();
                    JBulletApplet.this.mainPanel.add((Component)JBulletApplet.this.demoPanel, "Center");
                }
            });
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void runDemo(DemoEntry entry) {
        if (this.currentDemo == entry) {
            return;
        }
        this.currentDemo = entry;
        try {
            DemoApplication demoApp = entry.cls.getConstructor(IGL.class).newInstance(this.demoPanel.getGL());
            demoApp.initPhysics();
            this.demoPanel.runDemo(demoApp);
            this.demoPanel.requestFocusInWindow();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initComponents() {
        this.topPanel = new JPanel();
        this.jLabel1 = new JLabel();
        this.cmbDemos = new JComboBox();
        this.btnRestart = new JButton();
        this.mainPanel = new JPanel();
        this.topPanel.setBorder(BorderFactory.createBevelBorder(0, new Color(204, 204, 204), new Color(255, 255, 255), new Color(51, 51, 51), new Color(153, 153, 153)));
        this.jLabel1.setText("Choose demo:");
        this.btnRestart.setText("Restart");
        this.btnRestart.setEnabled(false);
        GroupLayout topPanelLayout = new GroupLayout((Container)this.topPanel);
        this.topPanel.setLayout((LayoutManager)topPanelLayout);
        topPanelLayout.setHorizontalGroup((GroupLayout.Group)topPanelLayout.createParallelGroup(1).add((GroupLayout.Group)topPanelLayout.createSequentialGroup().addContainerGap().add((Component)this.jLabel1).addPreferredGap(0).add((Component)this.cmbDemos, -2, 236, -2).addPreferredGap(0, 84, Short.MAX_VALUE).add((Component)this.btnRestart).addContainerGap()));
        topPanelLayout.setVerticalGroup((GroupLayout.Group)topPanelLayout.createParallelGroup(1).add((GroupLayout.Group)topPanelLayout.createSequentialGroup().addContainerGap().add((GroupLayout.Group)topPanelLayout.createParallelGroup(3, false).add((Component)this.jLabel1).add((Component)this.btnRestart).add((Component)this.cmbDemos, -2, -1, -2)).addContainerGap()));
        this.getContentPane().add((Component)this.topPanel, "North");
        this.mainPanel.setBackground(new Color(0, 0, 0));
        this.mainPanel.setLayout(new BorderLayout());
        this.getContentPane().add((Component)this.mainPanel, "Center");
    }

    public static void main(String[] args) {
        final JBulletApplet app = new JBulletApplet();
        app.init();
        EventQueue.invokeLater(new Runnable(){

            @Override
            public void run() {
                JFrame frm = new JFrame();
                frm.setDefaultCloseOperation(3);
                frm.add(app);
                frm.setSize(600, 500);
                frm.setVisible(true);
            }
        });
    }

    private static class DemoEntry {
        public String name;
        public Class<? extends DemoApplication> cls;

        public DemoEntry(String name2, Class<? extends DemoApplication> cls) {
            this.name = name2;
            this.cls = cls;
        }

        public String toString() {
            return this.name;
        }
    }
}

