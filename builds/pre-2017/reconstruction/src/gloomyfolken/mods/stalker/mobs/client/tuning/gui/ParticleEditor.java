/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.mobs.client.tuning.gui;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import gloomyfolken.mods.asm.MicInputStream;
import gloomyfolken.mods.core.misc.uxqz;
import gloomyfolken.mods.effects.client.main.eidj;
import gloomyfolken.mods.ktcore.McExtensionsKt;
import gloomyfolken.mods.ktcore.VecExtensionsKt;
import gloomyfolken.mods.stalker.misc.StalkerMiscMod;
import gloomyfolken.mods.stalker.mobs.client.tuning.EditorPropertyController;
import gloomyfolken.mods.stalker.mobs.client.tuning.EditorPropertyGroup;
import gloomyfolken.mods.stalker.mobs.client.tuning.SwingPropertyEditor;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.prefs.Preferences;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileFilter;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Vec3;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

public class ParticleEditor
implements ActionListener {
    public static ParticleEditor instance;
    public boolean wasClosed;
    private JPanel root;
    private JButton restartParticlesBtn;
    private JTabbedPane tabbedPane;
    private JTextField itemId;
    private JPanel spawnProps;
    private JPanel commonProps;
    private JPanel motionProps;
    private JPanel emitterProps;
    private JPanel colorProps;
    private JPanel emitterSettings;
    private JTabbedPane tabbedPane1;
    private JButton deleteEmitter;
    private JTextField emitterName;
    private JLabel icon;
    private JTextField texturePath;
    private JButton reloadAtlas;
    private JButton sortLeft;
    private JButton sortRight;
    private JButton clone;
    private JSpinner startFrame;
    private JSpinner endFrame;
    private JScrollPane lastSpawn;
    private JScrollPane lastCommon;
    private JScrollPane lastMotion;
    private JScrollPane lastColor;
    private JScrollPane lastEmitter;
    private final String LAST_IMPORT_FOLDER = "last_import_folder";
    private final String LAST_EXPORT_FOLDER = "last_export_folder";
    private ArrayList<ogjh> emitters = new ArrayList();
    private File assetsDir = new File("C:/Development/stalcraftassets/");
    private boolean ignoreTabEvents = false;
    private EntityItem effectSourceItem;
    private int autosaveCount = 0;

    public static boolean openEditor() {
        if (!ParticleEditor.isWindowOpened()) {
            ParticleEditor.createWindow();
            return true;
        }
        return false;
    }

    private static boolean isWindowOpened() {
        return instance != null && !ParticleEditor.instance.wasClosed;
    }

    private static void createWindow() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException exception) {
            exception.printStackTrace();
        }
        final ParticleEditor particleEditor = new ParticleEditor();
        try {
            SwingUtilities.invokeAndWait(() -> {
                JFrame jFrame = new JFrame("\u0420\u0435\u0434\u0430\u043a\u0442\u043e\u0440 \u044d\u0444\u0444\u0435\u043a\u0442\u043e\u0432 \u0430\u0440\u0442\u0435\u0444\u0430\u043a\u0442\u043e\u0432");
                jFrame.setDefaultCloseOperation(2);
                jFrame.addWindowListener(new WindowListener(){

                    @Override
                    public void windowClosing(WindowEvent windowEvent) {
                        particleEditor.saveToFile(new File(".", "effect_last_edited.json"));
                    }

                    @Override
                    public void windowClosed(WindowEvent windowEvent) {
                        particleEditor.wasClosed = true;
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
                jFrame.add(particleEditor.root);
                jFrame.setSize(455, 755);
                jFrame.setLocationRelativeTo(null);
                jFrame.setVisible(true);
                jFrame.requestFocus();
                jFrame.toFront();
                jFrame.setJMenuBar(particleEditor.createMenu(jFrame));
                SwingUtilities.updateComponentTreeUI(jFrame);
            });
        }
        catch (InterruptedException | InvocationTargetException exception) {
            exception.printStackTrace();
        }
    }

    public static void main(String[] stringArray) {
        ParticleEditor.createWindow();
    }

    private JMenuBar createMenu(JFrame jFrame) {
        JMenuBar jMenuBar = new JMenuBar();
        JMenu jMenu = new JMenu("\u0424\u0430\u0439\u043b");
        JMenuItem jMenuItem = new JMenuItem("\u041d\u043e\u0432\u044b\u0439 \u044d\u0444\u0444\u0435\u043a\u0442");
        JMenuItem jMenuItem2 = new JMenuItem("\u0418\u043c\u043f\u043e\u0440\u0442\u0438\u0440\u043e\u0432\u0430\u0442\u044c \u044d\u0444\u0444\u0435\u043a\u0442");
        JMenuItem jMenuItem3 = new JMenuItem("\u042d\u043a\u0441\u043f\u043e\u0440\u0442\u0438\u0440\u043e\u0432\u0430\u0442\u044c \u044d\u0444\u0444\u0435\u043a\u0442");
        jMenu.add(jMenuItem);
        jMenu.add(jMenuItem2);
        jMenu.add(jMenuItem3);
        jMenuBar.add(jMenu);
        jMenuItem.addActionListener(actionEvent -> this.openPreset(new zgiu(new ogjh())));
        FileFilter fileFilter = new FileFilter(){

            @Override
            public boolean accept(File file) {
                return file.getName().endsWith("json") || file.isDirectory();
            }

            @Override
            public String getDescription() {
                return "Open fx json file";
            }
        };
        Preferences preferences = Preferences.userRoot().node(this.getClass().getName());
        jMenuItem2.addActionListener(actionEvent -> {
            JFileChooser jFileChooser = new JFileChooser(preferences.get("last_import_folder", new File(".").getAbsolutePath()));
            jFileChooser.setFileFilter(fileFilter);
            int n = jFileChooser.showOpenDialog(null);
            if (n == 0) {
                preferences.put("last_import_folder", jFileChooser.getSelectedFile().getParent());
                File file = jFileChooser.getSelectedFile();
                if (file != null && file.exists()) {
                    try {
                        zgiu zgiu2 = uxqz._a(FileUtils.readFileToString(file), zgiu.class);
                        this.openPreset(zgiu2);
                        jFrame.setTitle(StringUtils.substringBeforeLast(jFileChooser.getSelectedFile().getName(), "."));
                    }
                    catch (Exception exception) {
                        exception.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Error loading effect: " + exception.getMessage());
                    }
                }
            }
        });
        jMenuItem3.addActionListener(actionEvent -> {
            zgiu zgiu2 = this.constructPreset();
            JFileChooser jFileChooser = new JFileChooser(preferences.get("last_export_folder", new File(".").getAbsolutePath()));
            jFileChooser.setFileFilter(fileFilter);
            jFileChooser.setSelectedFile(new File("basicArtifact.json"));
            int n = jFileChooser.showSaveDialog(null);
            if (n == 0) {
                preferences.put("last_export_folder", jFileChooser.getSelectedFile().getParent());
                this.saveToFile(jFileChooser.getSelectedFile());
            }
        });
        return jMenuBar;
    }

    private void saveToFile(File file) {
        if (!file.getName().endsWith(".json")) {
            file = new File(file + ".json");
        }
        if (file != null) {
            try {
                if (file.exists()) {
                    FileUtils.copyFile(file, new File(file + ".bck"));
                }
                FileUtils.writeStringToFile(file, uxqz._a(this.constructPreset()));
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
        }
    }

    private void updateGuiForEmitter(ogjh ogjh2) {
        JScrollPane jScrollPane = new SwingPropertyEditor().setup(new EditorPropertyController(new EditorPropertyGroup<ogjh.ezey>(ogjh2._c(), "")), Collections.emptyMap(), false);
        JScrollPane jScrollPane2 = new SwingPropertyEditor().setup(new EditorPropertyController(new EditorPropertyGroup<ogjh.pidb>(ogjh2._d(), "")), Collections.emptyMap(), false);
        JScrollPane jScrollPane3 = new SwingPropertyEditor().setup(new EditorPropertyController(new EditorPropertyGroup<ogjh.eidj>(ogjh2._e(), "")), Collections.emptyMap(), false);
        JScrollPane jScrollPane4 = new SwingPropertyEditor().setup(new EditorPropertyController(new EditorPropertyGroup<ogjh.kjui>(ogjh2._f(), "")), Collections.emptyMap(), false);
        JScrollPane jScrollPane5 = new SwingPropertyEditor().setup(new EditorPropertyController(new EditorPropertyGroup<ogjh>(ogjh2, "")), Collections.emptyMap(), false);
        try {
            this.spawnProps.remove(this.lastSpawn);
            this.commonProps.remove(this.lastCommon);
            this.colorProps.remove(this.lastColor);
            this.motionProps.remove(this.lastMotion);
            this.emitterProps.remove(this.lastEmitter);
        }
        catch (NullPointerException nullPointerException) {
            // empty catch block
        }
        this.spawnProps.add(jScrollPane);
        this.commonProps.add(jScrollPane2);
        this.motionProps.add(jScrollPane3);
        this.emitterProps.add(jScrollPane5);
        this.colorProps.add(jScrollPane4);
        this.lastSpawn = jScrollPane;
        this.lastCommon = jScrollPane2;
        this.lastMotion = jScrollPane3;
        this.lastEmitter = jScrollPane5;
        this.lastColor = jScrollPane4;
        this.emitterName.setText(ogjh2._b());
        this.texturePath.setText(ogjh2._d()._j());
        this.updateParticleTexture();
    }

    private File getTextureFile(String string) {
        if (Minecraft._E() == null) {
            return new File(this.assetsDir, string);
        }
        return new File(uyvo._b + "/", string);
    }

    private ogjh getCurrentEmitter() {
        return this.emitters.get(this.tabbedPane.getSelectedIndex());
    }

    private void selectEmitterAtIndex(int n) {
        if (n >= 0) {
            ogjh ogjh2 = this.emitters.get(n);
            this.updateGuiForEmitter(ogjh2);
            ((Container)this.tabbedPane.getSelectedComponent()).add(this.emitterSettings);
        }
        for (int i = 0; i < this.emitters.size(); ++i) {
            ogjh ogjh3 = this.emitters.get(i);
            this.tabbedPane.setTitleAt(i, ogjh3._b());
        }
    }

    private void updateParticleTexture() {
        File file = this.getTextureFile(this.texturePath.getText());
        this.icon.setIcon(null);
        this.icon.setText("(\u043d\u0435\u0442 \u0442\u0435\u043a\u0441\u0442\u0443\u0440\u044b)");
        if (file != null && file.exists()) {
            try {
                MicInputStream micInputStream = new MicInputStream(file, (InputStream)new FileInputStream(file));
                this.icon.setIcon(new ImageIcon(ImageIO.read(micInputStream).getScaledInstance(64, 64, 0)));
                this.icon.setText("");
            }
            catch (Exception exception) {
                exception.printStackTrace();
                JOptionPane.showMessageDialog(null, exception.getMessage());
            }
        }
    }

    private void openPreset(zgiu zgiu2) {
        this.emitters.clear();
        this.emitters.addAll(zgiu2._a());
        this.ignoreTabEvents = true;
        this.tabbedPane.removeAll();
        for (ogjh ogjh2 : zgiu2._a()) {
            JPanel jPanel = new JPanel();
            jPanel.setLayout(new BorderLayout(0, 0));
            this.tabbedPane.addTab(ogjh2._b(), jPanel);
        }
        this.createNewTab();
        this.ignoreTabEvents = false;
        this.selectEmitterAtIndex(0);
    }

    private zgiu constructPreset() {
        return new zgiu(this.emitters.toArray(new ogjh[this.emitters.size()]));
    }

    private void createNewTab() {
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BorderLayout());
        this.tabbedPane.addTab("+", jPanel);
    }

    private void spawnTestEffect() {
        try {
            qmdg._a._e(() -> {
                EntityClientPlayerMP entityClientPlayerMP = Minecraft._E()._t;
                if (entityClientPlayerMP != null) {
                    Vec3 vec3 = VecExtensionsKt.addVector(McExtensionsKt.getPos(entityClientPlayerMP), VecExtensionsKt.mul(entityClientPlayerMP.getLookVec(), 3.0));
                    if (this.effectSourceItem != null) {
                        this.effectSourceItem.setDead();
                    }
                    this.effectSourceItem = new EntityItem(entityClientPlayerMP.worldObj);
                    this.effectSourceItem.setEntityItemStack(new ItemStack(Integer.parseInt(this.itemId.getText()), 1, 0));
                    this.effectSourceItem.setPosition(vec3._c, vec3._d, vec3._e);
                    entityClientPlayerMP.worldObj.spawnEntityInWorld(this.effectSourceItem);
                    fmsn fmsn2 = new fmsn(this.effectSourceItem);
                    fmsn2._a(this.constructPreset());
                }
            });
        }
        catch (Exception exception) {
            exception.printStackTrace();
            JOptionPane.showMessageDialog(null, exception.getMessage());
        }
    }

    private void reloadParticleAtlas() {
        if (Minecraft._E() != null) {
            StalkerMiscMod.instance._a();
            StalkerMiscMod.instance.__as._a();
            for (ogjh ogjh2 : this.emitters) {
                StalkerMiscMod.instance.__as._a(ogjh2._d()._j());
            }
            eidj._a._g();
        }
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        this.saveToFile(new File(".", "effect_autosaved_" + this.autosaveCount + ".json"));
        ++this.autosaveCount;
        this.autosaveCount %= 5;
    }

    public ParticleEditor() {
        this.$$$setupUI$$$();
        instance = this;
        new Timer(15000, this).start();
        this.openPreset(new zgiu(new ogjh()));
        this.tabbedPane.addChangeListener(changeEvent -> {
            if (!this.ignoreTabEvents) {
                int n = this.tabbedPane.getSelectedIndex();
                if (n == this.tabbedPane.getTabCount() - 1) {
                    this.tabbedPane.setTitleAt(n, "\u041d\u0435\u0438\u0437\u0432\u0435\u0441\u0442\u043d\u044b\u0439 \u0441\u043b\u043e\u0439");
                    this.emitters.add(new ogjh());
                    this.createNewTab();
                }
                this.selectEmitterAtIndex(n);
            }
        });
        this.sortLeft.addActionListener(actionEvent -> {
            int n = this.tabbedPane.getSelectedIndex();
            if (n > 0) {
                this.emitters.add(n - 1, this.emitters.remove(n));
                this.tabbedPane.setSelectedIndex(this.tabbedPane.getSelectedIndex() - 1);
            }
            this.selectEmitterAtIndex(this.tabbedPane.getSelectedIndex());
        });
        this.sortRight.addActionListener(actionEvent -> {
            int n = this.tabbedPane.getSelectedIndex();
            if (n < this.tabbedPane.getTabCount() - 2) {
                this.emitters.add(n + 1, this.emitters.remove(n));
                this.tabbedPane.setSelectedIndex(this.tabbedPane.getSelectedIndex() + 1);
            }
            this.selectEmitterAtIndex(this.tabbedPane.getSelectedIndex());
        });
        this.clone.addActionListener(actionEvent -> {
            ogjh ogjh2 = this.getCurrentEmitter()._h();
            JPanel jPanel = new JPanel();
            jPanel.setLayout(new BorderLayout(0, 0));
            this.emitters.add(ogjh2);
            this.tabbedPane.insertTab(ogjh2._b(), null, jPanel, "", this.tabbedPane.getTabCount() - 1);
            this.tabbedPane.setSelectedIndex(this.tabbedPane.getTabCount() - 2);
            this.selectEmitterAtIndex(this.tabbedPane.getSelectedIndex());
        });
        this.reloadAtlas.addActionListener(actionEvent -> this.reloadParticleAtlas());
        this.texturePath.addActionListener(actionEvent -> {
            this.getCurrentEmitter()._d()._a(this.texturePath.getText());
            this.updateParticleTexture();
        });
        this.deleteEmitter.addActionListener(actionEvent -> {
            if (this.emitters.size() > 1) {
                String string = this.emitters.get(this.tabbedPane.getSelectedIndex())._b();
                if (JOptionPane.showConfirmDialog(null, String.format("\u0423\u0434\u0430\u043b\u0438\u0442\u044c \u0441\u043b\u043e\u0439 %s?", string), "\u041f\u043e\u0434\u0442\u0432\u0435\u0440\u0436\u0434\u0435\u043d\u0438\u0435", 2) == 0) {
                    int n = this.tabbedPane.getSelectedIndex();
                    if (n == this.tabbedPane.getTabCount() - 2) {
                        this.tabbedPane.setSelectedIndex(n - 1);
                    }
                    this.emitters.remove(n);
                    this.tabbedPane.remove(n);
                    this.selectEmitterAtIndex(this.tabbedPane.getSelectedIndex());
                }
            } else {
                JOptionPane.showMessageDialog(null, "\u041d\u0435\u043b\u044c\u0437\u044f \u0443\u0434\u0430\u043b\u0438\u0442\u044c \u0435\u0434\u0438\u043d\u0441\u0442\u0432\u0435\u043d\u043d\u044b\u0439 \u0441\u043b\u043e\u0439.", "\u041e\u0448\u0438\u0431\u043a\u0430", 0);
            }
        });
        this.emitterName.addActionListener(actionEvent -> {
            this.tabbedPane.setTitleAt(this.tabbedPane.getSelectedIndex(), this.emitterName.getText());
            this.getCurrentEmitter()._a(this.emitterName.getText());
        });
        this.restartParticlesBtn.addActionListener(actionEvent -> this.spawnTestEffect());
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
        this.root.setLayout(new GridLayoutManager(1, 1, new Insets(4, 4, 4, 4), -1, -1));
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new GridLayoutManager(2, 1, new Insets(0, 0, 0, 0), -1, -1));
        this.root.add((Component)jPanel, new GridConstraints(0, 0, 1, 1, 0, 3, 3, 3, null, null, null, 0, false));
        JPanel jPanel2 = new JPanel();
        jPanel2.setLayout(new GridLayoutManager(3, 1, new Insets(0, 0, 0, 0), -1, -1));
        jPanel.add((Component)jPanel2, new GridConstraints(1, 0, 1, 1, 0, 3, 3, 1, null, null, null, 0, false));
        JPanel jPanel3 = new JPanel();
        jPanel3.setLayout(new GridLayoutManager(1, 2, new Insets(0, 0, 0, 0), -1, -1));
        jPanel2.add((Component)jPanel3, new GridConstraints(0, 0, 1, 1, 0, 3, 3, 1, null, null, null, 0, false));
        jPanel3.setBorder(BorderFactory.createTitledBorder("\u041f\u0440\u0438\u0432\u044f\u0437\u043a\u0430"));
        JLabel jLabel = new JLabel();
        jLabel.setText("ID \u043f\u0440\u0435\u0434\u043c\u0435\u0442\u0430 \u0430\u0440\u0442\u0435\u0444\u0430\u043a\u0442\u0430");
        jPanel3.add((Component)jLabel, new GridConstraints(0, 0, 1, 1, 8, 0, 0, 0, null, null, null, 0, false));
        this.itemId = new JTextField();
        jPanel3.add((Component)this.itemId, new GridConstraints(0, 1, 1, 1, 8, 1, 4, 0, null, new Dimension(150, -1), null, 0, false));
        this.restartParticlesBtn = new JButton();
        this.restartParticlesBtn.setText("\u0417\u0430\u0441\u043f\u0430\u0432\u043d\u0438\u0442\u044c \u044d\u0444\u0444\u0435\u043a\u0442");
        jPanel2.add((Component)this.restartParticlesBtn, new GridConstraints(2, 0, 1, 1, 0, 1, 3, 0, null, null, null, 0, false));
        this.reloadAtlas = new JButton();
        this.reloadAtlas.setText("\u041f\u0435\u0440\u0435\u0437\u0430\u0433\u0440\u0443\u0437\u0438\u0442\u044c \u0430\u0442\u043b\u0430\u0441");
        jPanel2.add((Component)this.reloadAtlas, new GridConstraints(1, 0, 1, 1, 0, 1, 3, 0, null, null, null, 0, false));
        this.tabbedPane = new JTabbedPane();
        jPanel.add((Component)this.tabbedPane, new GridConstraints(0, 0, 1, 1, 0, 3, 3, 3, null, new Dimension(200, 200), null, 0, false));
        JPanel jPanel4 = new JPanel();
        jPanel4.setLayout(new BorderLayout(0, 0));
        this.tabbedPane.addTab("\u041d\u0435\u0438\u0437\u0432\u0435\u0441\u0442\u043d\u044b\u0439 \u0441\u043b\u043e\u0439", jPanel4);
        this.emitterSettings = new JPanel();
        this.emitterSettings.setLayout(new GridLayoutManager(5, 1, new Insets(0, 0, 0, 0), -1, -1));
        jPanel4.add((Component)this.emitterSettings, "Center");
        this.tabbedPane1 = new JTabbedPane();
        this.emitterSettings.add((Component)this.tabbedPane1, new GridConstraints(2, 0, 1, 1, 0, 3, 3, 3, null, new Dimension(200, 200), null, 0, false));
        JPanel jPanel5 = new JPanel();
        jPanel5.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        this.tabbedPane1.addTab("\u0421\u043f\u0430\u0432\u043d", jPanel5);
        JScrollPane jScrollPane = new JScrollPane();
        jPanel5.add((Component)jScrollPane, new GridConstraints(0, 0, 1, 1, 0, 3, 5, 5, null, null, null, 0, false));
        this.spawnProps = new JPanel();
        this.spawnProps.setLayout(new FlowLayout(1, 5, 5));
        jScrollPane.setViewportView(this.spawnProps);
        JPanel jPanel6 = new JPanel();
        jPanel6.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        this.tabbedPane1.addTab("\u041e\u0431\u0449\u0435\u0435", jPanel6);
        JScrollPane jScrollPane2 = new JScrollPane();
        jPanel6.add((Component)jScrollPane2, new GridConstraints(0, 0, 1, 1, 0, 3, 5, 5, null, null, null, 0, false));
        this.commonProps = new JPanel();
        this.commonProps.setLayout(new FlowLayout(1, 5, 5));
        jScrollPane2.setViewportView(this.commonProps);
        JPanel jPanel7 = new JPanel();
        jPanel7.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        this.tabbedPane1.addTab("\u0414\u0432\u0438\u0436\u0435\u043d\u0438\u0435", jPanel7);
        JScrollPane jScrollPane3 = new JScrollPane();
        jPanel7.add((Component)jScrollPane3, new GridConstraints(0, 0, 1, 1, 0, 3, 5, 5, null, null, null, 0, false));
        this.motionProps = new JPanel();
        this.motionProps.setLayout(new FlowLayout(1, 5, 5));
        jScrollPane3.setViewportView(this.motionProps);
        JScrollPane jScrollPane4 = new JScrollPane();
        this.tabbedPane1.addTab("\u0426\u0432\u0435\u0442", jScrollPane4);
        this.colorProps = new JPanel();
        this.colorProps.setLayout(new FlowLayout(1, 5, 5));
        jScrollPane4.setViewportView(this.colorProps);
        JPanel jPanel8 = new JPanel();
        jPanel8.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        this.emitterSettings.add((Component)jPanel8, new GridConstraints(4, 0, 1, 1, 0, 3, 3, 1, null, null, null, 0, false));
        this.deleteEmitter = new JButton();
        this.deleteEmitter.setText("\u0423\u0434\u0430\u043b\u0438\u0442\u044c \u0441\u043b\u043e\u0439");
        jPanel8.add((Component)this.deleteEmitter, new GridConstraints(0, 0, 1, 1, 0, 1, 3, 0, null, null, null, 0, false));
        JPanel jPanel9 = new JPanel();
        jPanel9.setLayout(new GridLayoutManager(1, 4, new Insets(0, 0, 0, 0), -1, -1));
        this.emitterSettings.add((Component)jPanel9, new GridConstraints(1, 0, 1, 1, 0, 3, 3, 1, null, null, null, 0, false));
        this.emitterProps = new JPanel();
        this.emitterProps.setLayout(new FlowLayout(1, 5, 5));
        jPanel9.add((Component)this.emitterProps, new GridConstraints(0, 0, 1, 1, 0, 3, 3, 3, null, null, null, 0, false));
        Spacer spacer = new Spacer();
        jPanel9.add((Component)spacer, new GridConstraints(0, 1, 1, 1, 0, 1, 4, 1, null, null, null, 0, false));
        this.emitterName = new JTextField();
        this.emitterName.setText("Untitled");
        jPanel9.add((Component)this.emitterName, new GridConstraints(0, 3, 1, 1, 8, 1, 4, 0, null, new Dimension(150, -1), null, 0, false));
        JLabel jLabel2 = new JLabel();
        jLabel2.setText("\u041d\u0430\u0437\u0432\u0430\u043d\u0438\u0435 \u0441\u043b\u043e\u044f");
        jPanel9.add((Component)jLabel2, new GridConstraints(0, 2, 1, 1, 8, 0, 0, 0, null, null, null, 0, false));
        JPanel jPanel10 = new JPanel();
        jPanel10.setLayout(new GridLayoutManager(2, 2, new Insets(0, 0, 0, 0), -1, -1));
        this.emitterSettings.add((Component)jPanel10, new GridConstraints(3, 0, 1, 1, 0, 3, 3, 1, null, null, null, 0, false));
        JLabel jLabel3 = new JLabel();
        jLabel3.setText("\u041f\u0443\u0442\u044c \u0434\u043e \u0442\u0435\u043a\u0441\u0442\u0443\u0440\u044b:");
        jPanel10.add((Component)jLabel3, new GridConstraints(0, 0, 1, 1, 8, 0, 0, 0, null, null, null, 0, false));
        this.texturePath = new JTextField();
        this.texturePath.setText("assets/stalker/textures/particles/smoke/smoke1.png");
        jPanel10.add((Component)this.texturePath, new GridConstraints(0, 1, 1, 1, 8, 1, 4, 0, null, new Dimension(150, -1), null, 0, false));
        this.icon = new JLabel();
        this.icon.setText("(\u043d\u0435\u0442 \u0442\u0435\u043a\u0441\u0442\u0443\u0440\u044b)");
        jPanel10.add((Component)this.icon, new GridConstraints(1, 0, 1, 1, 8, 0, 0, 0, null, null, null, 0, false));
        JPanel jPanel11 = new JPanel();
        jPanel11.setLayout(new GridLayoutManager(1, 3, new Insets(0, 0, 0, 0), -1, -1));
        this.emitterSettings.add((Component)jPanel11, new GridConstraints(0, 0, 1, 1, 0, 3, 3, 1, null, null, null, 0, false));
        this.sortLeft = new JButton();
        this.sortLeft.setText("\u041f\u0435\u0440\u0435\u043c\u0435\u0441\u0442\u0438\u0442\u044c \u0432\u043b\u0435\u0432\u043e");
        jPanel11.add((Component)this.sortLeft, new GridConstraints(0, 0, 1, 1, 0, 1, 3, 0, null, null, null, 0, false));
        this.sortRight = new JButton();
        this.sortRight.setText("\u041f\u0435\u0440\u0435\u043c\u0435\u0441\u0442\u0438\u0442\u044c \u0432\u043f\u0440\u0430\u0432\u043e");
        jPanel11.add((Component)this.sortRight, new GridConstraints(0, 2, 1, 1, 0, 1, 3, 0, null, null, null, 0, false));
        this.clone = new JButton();
        this.clone.setText("\u041a\u043b\u043e\u043d\u0438\u0440\u043e\u0432\u0430\u0442\u044c");
        jPanel11.add((Component)this.clone, new GridConstraints(0, 1, 1, 1, 0, 1, 3, 0, null, null, null, 0, false));
    }

    public JComponent $$$getRootComponent$$$() {
        return this.root;
    }
}

