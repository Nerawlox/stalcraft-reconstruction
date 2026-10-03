/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.mobs.client.tuning.gui;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import cpw.mods.fml.relauncher.FMLRelaunchLog;
import gloomyfolken.mods.effects.client.main.eidj;
import gloomyfolken.mods.effects.client.mcsa.kjui;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Insets;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.logging.Level;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JToolBar;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.PixelFormat;

public class GLViewer {
    private JButton button1;
    private JPanel appPanel;
    private JButton button3;
    private JTree tree1;
    private JPanel glPanel;
    private JPanel root;
    private JPanel glParentPanel;
    private JSplitPane splitPanel;
    private Canvas glCanvas;
    private boolean stopping = false;
    private boolean initialized = false;
    private Timer timer;
    private Runnable glRenderCycle = new Runnable(){

        @Override
        public void run() {
            GLViewer.this.initialize();
            float f = Display.getWidth();
            float f2 = Display.getHeight();
            GL11.glViewport(0, 0, (int)f, (int)f2);
            GL11.glMatrixMode(5889);
            GL11.glLoadIdentity();
            GL11.glOrtho(0.0, 1.0, 0.0, 1.0, -1.0, 1.0);
            GL11.glMatrixMode(5888);
            GL11.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
            GL11.glClear(16384);
            float f3 = (float)Math.sin((float)(System.currentTimeMillis() % 10000L) * 0.004f);
            float f4 = (float)Math.cos((float)(System.currentTimeMillis() % 10000L) * 0.004f);
            GL11.glBegin(7);
            GL11.glColor4f(1.0f, f3 * f3, 0.0f, 1.0f);
            GL11.glVertex2d(0.0, 0.0);
            GL11.glColor4f(1.0f, 1.0f, f4 * f4, 1.0f);
            GL11.glVertex2d(0.0, 1.0);
            GL11.glColor4f(0.0f, 1.0f, f3 * f3, 1.0f);
            GL11.glVertex2d(1.0, 1.0);
            GL11.glColor4f(0.0f, 0.0f, 0.0f, 1.0f);
            GL11.glVertex2d(1.0, 0.0);
            GL11.glEnd();
            GL11.glTranslated(0.5, 0.0, 0.0);
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            GL11.glEnable(3553);
            GL11.glDisable(2896);
            GLViewer.this.dog.renderAll();
            GL11.glDisable(3553);
            GL11.glTranslated(-0.5, 0.0, 0.0);
            Display.update();
            if (!GLViewer.this.stopping) {
                EventQueue.invokeLater(GLViewer.this.glRenderCycle);
            }
        }
    };
    private kjui dog;

    public static void main(String[] stringArray) {
        SwingUtilities.invokeLater(() -> {
            GLViewer gLViewer = GLViewer.createWindow();
            try {
                Display.create(new PixelFormat().withDepthBits(24));
            }
            catch (LWJGLException lWJGLException) {
                lWJGLException.printStackTrace();
            }
            EventQueue.invokeLater(gLViewer.glRenderCycle);
        });
    }

    public static GLViewer createWindow() {
        final GLViewer gLViewer = new GLViewer();
        JMenuBar jMenuBar = new JMenuBar();
        for (int i = 0; i < 7; ++i) {
            StringBuilder stringBuilder = new StringBuilder("P");
            JMenu jMenu = new JMenu();
            for (int j = 0; j < i; ++j) {
                stringBuilder.append("o");
                jMenu.add(new JMenuItem("Item #" + j));
            }
            stringBuilder.append("k");
            jMenu.setText(stringBuilder.toString());
            jMenuBar.add(jMenu);
        }
        JFrame jFrame = new JFrame("\u0419\u043e\u0431\u0430-\u0420\u0435\u0434\u0430\u043a\u0442\u043e\u0440");
        jFrame.setDefaultCloseOperation(2);
        jFrame.add(gLViewer.root);
        jFrame.setJMenuBar(jMenuBar);
        jFrame.pack();
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
        jFrame.setMinimumSize(jFrame.getSize());
        jFrame.addWindowListener(new WindowListener(){

            @Override
            public void windowOpened(WindowEvent windowEvent) {
            }

            @Override
            public void windowClosing(WindowEvent windowEvent) {
            }

            @Override
            public void windowClosed(WindowEvent windowEvent) {
                gLViewer.stopping = true;
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
        return gLViewer;
    }

    private GLViewer() {
        this.glCanvas = new Canvas();
        String string = "";
        this.$$$setupUI$$$();
        this.glCanvas.setIgnoreRepaint(true);
        this.glPanel.add(this.glCanvas);
        try {
            Display.setParent(this.glCanvas);
        }
        catch (LWJGLException lWJGLException) {
            lWJGLException.printStackTrace();
        }
    }

    private void initialize() {
        if (!this.initialized) {
            this.initialized = true;
            int n = Display.getWidth();
            int n2 = Display.getHeight();
            FMLRelaunchLog.minecraftHome = new File(".");
            FMLRelaunchLog.logFileNamePattern = "GLViewer-%g.log";
            FMLRelaunchLog.log(Level.FINE, "", new Object[0]);
            File file = new File(System.getProperty("mod_assets_dir", "modassets"));
            try {
                GLViewer.addSoftwareLibrary(file);
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
            new eidj();
            iefv iefv2 = new iefv(new ResourceLocation("stalkermobs", "models\\boar\\boar.mcsa"), null);
            this.dog = iefv2._b();
        }
    }

    private static void addSoftwareLibrary(File file) throws Exception {
        Method method = URLClassLoader.class.getDeclaredMethod("addURL", URL.class);
        method.setAccessible(true);
        method.invoke(ClassLoader.getSystemClassLoader(), file.toURI().toURL());
    }

    private void createUIComponents() {
        this.splitPanel = new JSplitPane(1){
            private long lastForcedValidate;
            private long TIME_SINCE_LAST_VALIDATE;
            {
                this.lastForcedValidate = 0L;
                this.TIME_SINCE_LAST_VALIDATE = 150L;
            }

            @Override
            public void validate() {
                super.validate();
                if (System.currentTimeMillis() > this.lastForcedValidate + this.TIME_SINCE_LAST_VALIDATE) {
                    this.lastForcedValidate = System.currentTimeMillis();
                    SwingUtilities.updateComponentTreeUI(GLViewer.this.root);
                }
            }
        };
    }

    private void $$$setupUI$$$() {
        this.createUIComponents();
        this.root = new JPanel();
        this.root.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        this.appPanel = new JPanel();
        this.appPanel.setLayout(new BorderLayout(0, 0));
        this.root.add((Component)this.appPanel, new GridConstraints(0, 0, 1, 1, 0, 3, 3, 3, null, null, null, 0, false));
        JToolBar jToolBar = new JToolBar();
        this.appPanel.add((Component)jToolBar, "South");
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new GridLayoutManager(1, 2, new Insets(0, 0, 0, 0), -1, -1));
        jToolBar.add(jPanel);
        this.button1 = new JButton();
        this.button1.setText("Button");
        jPanel.add((Component)this.button1, new GridConstraints(0, 0, 1, 1, 0, 1, 3, 0, null, null, null, 0, false));
        Spacer spacer = new Spacer();
        jPanel.add((Component)spacer, new GridConstraints(0, 1, 1, 1, 0, 1, 4, 1, null, null, null, 0, false));
        JPanel jPanel2 = new JPanel();
        jPanel2.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        this.appPanel.add((Component)jPanel2, "Center");
        this.splitPanel.setContinuousLayout(false);
        this.splitPanel.setOneTouchExpandable(false);
        this.splitPanel.setOpaque(true);
        jPanel2.add((Component)this.splitPanel, new GridConstraints(0, 0, 1, 1, 0, 3, 3, 3, null, new Dimension(200, 200), null, 0, false));
        JPanel jPanel3 = new JPanel();
        jPanel3.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        this.splitPanel.setLeftComponent(jPanel3);
        this.tree1 = new JTree();
        jPanel3.add((Component)this.tree1, new GridConstraints(0, 0, 1, 1, 0, 3, 4, 4, null, new Dimension(150, 50), null, 0, false));
        this.glParentPanel = new JPanel();
        this.glParentPanel.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        this.splitPanel.setRightComponent(this.glParentPanel);
        this.glPanel = new JPanel();
        this.glPanel.setLayout(new BorderLayout(0, 0));
        this.glParentPanel.add((Component)this.glPanel, new GridConstraints(0, 0, 1, 1, 0, 3, 5, 5, new Dimension(256, 256), null, null, 0, false));
        JToolBar jToolBar2 = new JToolBar();
        jToolBar2.setOrientation(1);
        this.appPanel.add((Component)jToolBar2, "West");
        this.button3 = new JButton();
        this.button3.setText("Button");
        jToolBar2.add(this.button3);
    }

    public JComponent $$$getRootComponent$$$() {
        return this.root;
    }
}

