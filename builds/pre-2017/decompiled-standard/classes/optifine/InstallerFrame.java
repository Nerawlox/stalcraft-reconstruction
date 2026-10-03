/*
 * Decompiled with CFR 0.152.
 */
package optifine;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import optifine.Installer;
import optifine.Utils;

public class InstallerFrame
extends JFrame {
    private JLabel ivjLabelOfVersion = null;
    private JLabel ivjLabelMcVersion = null;
    private JPanel ivjPanelCenter = null;
    private JButton ivjButtonInstall = null;
    private JButton ivjButtonClose = null;
    private JPanel ivjPanelBottom = null;
    private JPanel ivjPanelContentPane = null;
    IvjEventHandler ivjEventHandler = new IvjEventHandler();
    private JTextArea ivjTextArea = null;

    public InstallerFrame() {
        this.initialize();
    }

    private void customInit() {
        try {
            this.setDefaultCloseOperation(3);
            this.getButtonInstall().setEnabled(false);
            String string = Installer.getOptiFineVersion();
            Utils.dbg("OptiFine Version: " + string);
            String[] stringArray = Utils.tokenize(string, "_");
            String string2 = stringArray[1];
            Utils.dbg("Minecraft Version: " + string2);
            String string3 = Installer.getOptiFineEdition(stringArray);
            Utils.dbg("OptiFine Edition: " + string3);
            String string4 = string3.replace("_", " ");
            string4 = string4.replace(" U ", " Ultra ");
            string4 = string4.replace("L ", "Light ");
            this.getLabelOfVersion().setText("OptiFine " + string4);
            this.getLabelMcVersion().setText("for Minecraft " + string2);
            this.getButtonInstall().setEnabled(true);
            this.getButtonInstall().requestFocus();
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static void main(String[] stringArray) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            InstallerFrame installerFrame = new InstallerFrame();
            Utils.centerWindow(installerFrame, null);
            installerFrame.show();
        }
        catch (Exception exception) {
            String string = exception.getMessage();
            if (string != null && string.equals("QUIET")) {
                return;
            }
            exception.printStackTrace();
            String string2 = Utils.getExceptionStackTrace(exception);
            string2 = string2.replace("\t", "  ");
            JTextArea jTextArea = new JTextArea(string2);
            jTextArea.setEditable(false);
            Font font = jTextArea.getFont();
            Font font2 = new Font("Monospaced", font.getStyle(), font.getSize());
            jTextArea.setFont(font2);
            JScrollPane jScrollPane = new JScrollPane(jTextArea);
            jScrollPane.setPreferredSize(new Dimension(600, 400));
            JOptionPane.showMessageDialog(null, jScrollPane, "Error", 0);
        }
    }

    private void handleException(Throwable throwable) {
        String string = throwable.getMessage();
        if (string == null || !string.equals("QUIET")) {
            throwable.printStackTrace();
            String string2 = Utils.getExceptionStackTrace(throwable);
            string2 = string2.replace("\t", "  ");
            JTextArea jTextArea = new JTextArea(string2);
            jTextArea.setEditable(false);
            Font font = jTextArea.getFont();
            Font font2 = new Font("Monospaced", font.getStyle(), font.getSize());
            jTextArea.setFont(font2);
            JScrollPane jScrollPane = new JScrollPane(jTextArea);
            jScrollPane.setPreferredSize(new Dimension(600, 400));
            JOptionPane.showMessageDialog(null, jScrollPane, "Error", 0);
        }
    }

    private JLabel getLabelOfVersion() {
        if (this.ivjLabelOfVersion == null) {
            try {
                this.ivjLabelOfVersion = new JLabel();
                this.ivjLabelOfVersion.setName("LabelOfVersion");
                this.ivjLabelOfVersion.setBounds(2, 5, 385, 42);
                this.ivjLabelOfVersion.setFont(new Font("Dialog", 1, 18));
                this.ivjLabelOfVersion.setHorizontalAlignment(0);
                this.ivjLabelOfVersion.setPreferredSize(new Dimension(385, 42));
                this.ivjLabelOfVersion.setText("OptiFine ...");
            }
            catch (Throwable throwable) {
                this.handleException(throwable);
            }
        }
        return this.ivjLabelOfVersion;
    }

    private JLabel getLabelMcVersion() {
        if (this.ivjLabelMcVersion == null) {
            try {
                this.ivjLabelMcVersion = new JLabel();
                this.ivjLabelMcVersion.setName("LabelMcVersion");
                this.ivjLabelMcVersion.setBounds(2, 38, 385, 25);
                this.ivjLabelMcVersion.setFont(new Font("Dialog", 1, 14));
                this.ivjLabelMcVersion.setHorizontalAlignment(0);
                this.ivjLabelMcVersion.setPreferredSize(new Dimension(385, 25));
                this.ivjLabelMcVersion.setText("for Minecraft ...");
            }
            catch (Throwable throwable) {
                this.handleException(throwable);
            }
        }
        return this.ivjLabelMcVersion;
    }

    private JPanel getPanelCenter() {
        if (this.ivjPanelCenter == null) {
            try {
                this.ivjPanelCenter = new JPanel();
                this.ivjPanelCenter.setName("PanelCenter");
                this.ivjPanelCenter.setLayout(null);
                this.ivjPanelCenter.add((Component)this.getLabelOfVersion(), this.getLabelOfVersion().getName());
                this.ivjPanelCenter.add((Component)this.getLabelMcVersion(), this.getLabelMcVersion().getName());
                this.ivjPanelCenter.add((Component)this.getTextArea(), this.getTextArea().getName());
            }
            catch (Throwable throwable) {
                this.handleException(throwable);
            }
        }
        return this.ivjPanelCenter;
    }

    private JButton getButtonInstall() {
        if (this.ivjButtonInstall == null) {
            try {
                this.ivjButtonInstall = new JButton();
                this.ivjButtonInstall.setName("ButtonInstall");
                this.ivjButtonInstall.setPreferredSize(new Dimension(100, 26));
                this.ivjButtonInstall.setText("Install");
            }
            catch (Throwable throwable) {
                this.handleException(throwable);
            }
        }
        return this.ivjButtonInstall;
    }

    private JButton getButtonClose() {
        if (this.ivjButtonClose == null) {
            try {
                this.ivjButtonClose = new JButton();
                this.ivjButtonClose.setName("ButtonClose");
                this.ivjButtonClose.setPreferredSize(new Dimension(100, 26));
                this.ivjButtonClose.setText("Cancel");
            }
            catch (Throwable throwable) {
                this.handleException(throwable);
            }
        }
        return this.ivjButtonClose;
    }

    private JPanel getPanelBottom() {
        if (this.ivjPanelBottom == null) {
            try {
                this.ivjPanelBottom = new JPanel();
                this.ivjPanelBottom.setName("PanelBottom");
                this.ivjPanelBottom.setLayout(new FlowLayout(1, 15, 10));
                this.ivjPanelBottom.setPreferredSize(new Dimension(390, 55));
                this.ivjPanelBottom.add((Component)this.getButtonInstall(), this.getButtonInstall().getName());
                this.ivjPanelBottom.add((Component)this.getButtonClose(), this.getButtonClose().getName());
            }
            catch (Throwable throwable) {
                this.handleException(throwable);
            }
        }
        return this.ivjPanelBottom;
    }

    private JPanel getPanelContentPane() {
        if (this.ivjPanelContentPane == null) {
            try {
                this.ivjPanelContentPane = new JPanel();
                this.ivjPanelContentPane.setName("PanelContentPane");
                this.ivjPanelContentPane.setLayout(new BorderLayout(5, 5));
                this.ivjPanelContentPane.add((Component)this.getPanelCenter(), "Center");
                this.ivjPanelContentPane.add((Component)this.getPanelBottom(), "South");
            }
            catch (Throwable throwable) {
                this.handleException(throwable);
            }
        }
        return this.ivjPanelContentPane;
    }

    private void initialize() {
        try {
            this.setName("InstallerFrame");
            this.setSize(400, 200);
            this.setDefaultCloseOperation(0);
            this.setTitle("OptiFine Installer");
            this.setContentPane(this.getPanelContentPane());
            this.initConnections();
        }
        catch (Throwable throwable) {
            this.handleException(throwable);
        }
        this.customInit();
    }

    public void onInstall() {
        try {
            Installer.doInstall();
            Utils.showMessage("OptiFine is successfully installed.");
            this.dispose();
        }
        catch (Exception exception) {
            this.handleException(exception);
        }
    }

    public void onClose() {
        this.dispose();
    }

    private void connEtoC1(ActionEvent actionEvent) {
        try {
            this.onInstall();
        }
        catch (Throwable throwable) {
            this.handleException(throwable);
        }
    }

    private void connEtoC2(ActionEvent actionEvent) {
        try {
            this.onClose();
        }
        catch (Throwable throwable) {
            this.handleException(throwable);
        }
    }

    private void initConnections() throws Exception {
        this.getButtonInstall().addActionListener(this.ivjEventHandler);
        this.getButtonClose().addActionListener(this.ivjEventHandler);
    }

    private JTextArea getTextArea() {
        if (this.ivjTextArea == null) {
            try {
                this.ivjTextArea = new JTextArea();
                this.ivjTextArea.setName("TextArea");
                this.ivjTextArea.setBounds(15, 66, 365, 44);
                this.ivjTextArea.setEditable(false);
                this.ivjTextArea.setEnabled(true);
                this.ivjTextArea.setFont(new Font("Dialog", 0, 12));
                this.ivjTextArea.setLineWrap(true);
                this.ivjTextArea.setOpaque(false);
                this.ivjTextArea.setPreferredSize(new Dimension(365, 44));
                this.ivjTextArea.setText("This installer will install OptiFine in the official Minecraft launcher and will create a new profile \"OptiFine\" for it.");
                this.ivjTextArea.setWrapStyleWord(true);
            }
            catch (Throwable throwable) {
                this.handleException(throwable);
            }
        }
        return this.ivjTextArea;
    }

    class IvjEventHandler
    implements ActionListener {
        IvjEventHandler() {
        }

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            if (actionEvent.getSource() == InstallerFrame.this.getButtonClose()) {
                InstallerFrame.this.connEtoC2(actionEvent);
            }
            if (actionEvent.getSource() == InstallerFrame.this.getButtonInstall()) {
                InstallerFrame.this.connEtoC1(actionEvent);
            }
        }
    }
}

