/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  jf
 *  net.minecraft.server.MinecraftServer
 *  net.minecraftforge.common.DimensionManager
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.JComponent;
import javax.swing.Timer;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.common.DimensionManager;

@SideOnly(value=Side.SERVER)
public class je
extends JComponent {
    private static final DecimalFormat a = new DecimalFormat("########0.000");
    private int[] b = new int[256];
    private int c;
    private String[] d = new String[11];
    private final MinecraftServer e;

    public je(MinecraftServer par1MinecraftServer) {
        this.e = par1MinecraftServer;
        this.setPreferredSize(new Dimension(456, 246));
        this.setMinimumSize(new Dimension(456, 246));
        this.setMaximumSize(new Dimension(456, 246));
        new Timer(500, (ActionListener)new jf(this)).start();
        this.setBackground(Color.BLACK);
    }

    private void a() {
        this.d = new String[5 + DimensionManager.getIDs().length];
        long i2 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.gc();
        this.d[0] = "Memory use: " + i2 / 1024L / 1024L + " mb (" + Runtime.getRuntime().freeMemory() * 100L / Runtime.getRuntime().maxMemory() + "% free)";
        this.d[1] = "Threads: " + co.a.get() + " + " + co.b.get();
        this.d[2] = "Avg tick: " + a.format(this.a(this.e.j) * 1.0E-6) + " ms";
        this.d[3] = "Avg sent: " + (int)this.a(this.e.f) + ", Avg size: " + (int)this.a(this.e.g);
        this.d[4] = "Avg rec: " + (int)this.a(this.e.h) + ", Avg size: " + (int)this.a(this.e.i);
        if (this.e.b != null) {
            int j2 = 0;
            for (Integer id : DimensionManager.getIDs()) {
                this.d[5 + j2] = "Lvl " + id + " tick: " + a.format(this.a((long[])this.e.worldTickTimes.get(id)) * 1.0E-6) + " ms";
                js world = DimensionManager.getWorld((int)id);
                if (world != null && world.b != null) {
                    this.d[5 + j2] = this.d[5 + j2] + ", " + world.b.e();
                    this.d[5 + j2] = this.d[5 + j2] + ", Vec3: " + world.V().d() + " / " + world.V().c();
                }
                ++j2;
            }
        }
        double d0 = 12500.0;
        this.b[this.c++ & 0xFF] = (int)(this.a(this.e.g) * 100.0 / 12500.0);
        this.repaint();
    }

    private double a(long[] par1ArrayOfLong) {
        long i2 = 0L;
        for (int j2 = 0; j2 < par1ArrayOfLong.length; ++j2) {
            i2 += par1ArrayOfLong[j2];
        }
        return (double)i2 / (double)par1ArrayOfLong.length;
    }

    @Override
    public void paint(Graphics par1Graphics) {
        int i2;
        par1Graphics.setColor(new Color(0xFFFFFF));
        par1Graphics.fillRect(0, 0, 456, 246);
        for (i2 = 0; i2 < 256; ++i2) {
            int j2 = this.b[i2 + this.c & 0xFF];
            par1Graphics.setColor(new Color(j2 + 28 << 16));
            par1Graphics.fillRect(i2, 100 - j2, 1, j2);
        }
        par1Graphics.setColor(Color.BLACK);
        for (i2 = 0; i2 < this.d.length; ++i2) {
            String s2 = this.d[i2];
            if (s2 == null) continue;
            par1Graphics.drawString(s2, 32, 116 + i2 * 16);
        }
    }

    static void a(je par0StatsComponent) {
        par0StatsComponent.a();
    }
}

