/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  ja
 *  jb
 *  jc
 *  jd
 *  jg
 *  net.minecraft.server.MinecraftServer
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.awt.event.WindowListener;
import java.util.logging.Handler;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import net.minecraft.server.MinecraftServer;

@SideOnly(value=Side.SERVER)
public class iz
extends JComponent {
    private static boolean a;
    private is b;

    public static void a(is par0DedicatedServer) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception exception) {
            // empty catch block
        }
        iz minecraftservergui = new iz(par0DedicatedServer);
        a = true;
        JFrame jframe = new JFrame("Minecraft server");
        jframe.add(minecraftservergui);
        jframe.pack();
        jframe.setLocationRelativeTo(null);
        jframe.setVisible(true);
        jframe.addWindowListener((WindowListener)new ja(par0DedicatedServer));
    }

    public iz(is par1DedicatedServer) {
        this.b = par1DedicatedServer;
        this.setPreferredSize(new Dimension(854, 480));
        this.setLayout(new BorderLayout());
        try {
            this.add((Component)this.d(), "Center");
            this.add((Component)this.b(), "West");
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private JComponent b() {
        JPanel jpanel = new JPanel(new BorderLayout());
        jpanel.add((Component)new je(this.b), "North");
        jpanel.add((Component)this.c(), "Center");
        jpanel.setBorder(new TitledBorder(new EtchedBorder(), "Stats"));
        return jpanel;
    }

    private JComponent c() {
        jd playerlistcomponent = new jd((MinecraftServer)this.b);
        JScrollPane jscrollpane = new JScrollPane((Component)playerlistcomponent, 22, 30);
        jscrollpane.setBorder(new TitledBorder(new EtchedBorder(), "Players"));
        return jscrollpane;
    }

    private JComponent d() {
        JPanel jpanel = new JPanel(new BorderLayout());
        JTextArea jtextarea = new JTextArea();
        this.b.an().a().addHandler((Handler)new jg(jtextarea));
        JScrollPane jscrollpane = new JScrollPane(jtextarea, 22, 30);
        jtextarea.setEditable(false);
        JTextField jtextfield = new JTextField();
        jtextfield.addActionListener((ActionListener)new jb(this, jtextfield));
        jtextarea.addFocusListener((FocusListener)new jc(this));
        jpanel.add((Component)jscrollpane, "Center");
        jpanel.add((Component)jtextfield, "South");
        jpanel.setBorder(new TitledBorder(new EtchedBorder(), "Log and chat"));
        return jpanel;
    }

    static is a(iz par0MinecraftServerGui) {
        return par0MinecraftServerGui.b;
    }
}

