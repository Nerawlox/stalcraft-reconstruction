/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  dd
 *  de
 *  df
 *  dg
 *  dh
 *  di
 *  dj
 *  dk
 *  dl
 *  dm
 *  dn
 *  do
 *  dp
 *  dq
 *  dr
 *  ds
 *  dt
 *  du
 *  dv
 *  dw
 *  dx
 *  dy
 *  dz
 *  ea
 *  eb
 *  ec
 *  ed
 *  ee
 *  ef
 *  eg
 *  eh
 *  ei
 *  em
 *  en
 *  ep
 *  er
 *  es
 *  et
 *  eu
 *  ev
 *  ew
 *  ex
 *  ez
 *  fa
 *  fb
 *  fc
 *  fd
 *  fe
 *  ff
 *  fg
 *  fh
 *  fi
 *  fj
 *  fk
 *  fl
 *  fm
 *  fn
 *  fo
 *  fp
 *  fq
 *  fr
 *  fs
 *  ft
 *  fu
 *  fv
 *  fw
 *  fx
 *  fy
 *  fz
 *  ga
 *  gb
 *  gc
 *  gd
 *  ge
 *  gf
 *  gg
 *  gh
 *  gj
 *  gk
 *  lp
 *  lt
 *  net.minecraft.server.MinecraftServer
 */
import java.io.DataInput;
import java.io.DataOutput;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import net.minecraft.server.MinecraftServer;

public abstract class ey {
    public static lm l = new lm();
    private static Map a = new HashMap();
    private static Set b = new HashSet();
    private static Set c = new HashSet();
    protected lp m;
    public final long n = MinecraftServer.aq();
    public static long o;
    public static long p;
    public static long q;
    public static long r;
    public boolean s;

    public static void a(int par0, boolean par1, boolean par2, Class par3Class) {
        if (l.b(par0)) {
            throw new IllegalArgumentException("Duplicate packet id:" + par0);
        }
        if (a.containsKey(par3Class)) {
            throw new IllegalArgumentException("Duplicate packet class:" + par3Class);
        }
        l.a(par0, par3Class);
        a.put(par3Class, par0);
        if (par1) {
            b.add(par0);
        }
        if (par2) {
            c.add(par0);
        }
    }

    public static ey a(lp par0ILogAgent, int par1) {
        try {
            Class oclass = (Class)l.a(par1);
            return oclass == null ? null : (ey)oclass.newInstance();
        }
        catch (Exception exception) {
            exception.printStackTrace();
            par0ILogAgent.c("Skipping packet with id " + par1);
            return null;
        }
    }

    public static void a(DataOutput par0DataOutput, byte[] par1ArrayOfByte) throws IOException {
        par0DataOutput.writeShort(par1ArrayOfByte.length);
        par0DataOutput.write(par1ArrayOfByte);
    }

    public static byte[] b(DataInput par0DataInput) throws IOException {
        short short1 = par0DataInput.readShort();
        if (short1 < 0) {
            throw new IOException("Key was smaller than nothing!  Weird key!");
        }
        byte[] abyte = new byte[short1];
        par0DataInput.readFully(abyte);
        return abyte;
    }

    public final int n() {
        return (Integer)a.get(this.getClass());
    }

    public static ey a(lp par0ILogAgent, DataInput par1DataInput, boolean par2, Socket par3Socket) throws IOException {
        int j2;
        boolean flag1 = false;
        ey packet = null;
        int i2 = par3Socket.getSoTimeout();
        try {
            j2 = par1DataInput.readUnsignedByte();
            if (par2 && !c.contains(j2) || !par2 && !b.contains(j2)) {
                throw new IOException("Bad packet id " + j2);
            }
            packet = ey.a(par0ILogAgent, j2);
            if (packet == null) {
                throw new IOException("Bad packet id " + j2);
            }
            packet.m = par0ILogAgent;
            if (packet instanceof eg) {
                par3Socket.setSoTimeout(1500);
            }
            packet.a(par1DataInput);
            ++o;
            p += (long)packet.a();
        }
        catch (EOFException eofexception) {
            par0ILogAgent.c("Reached end of stream for " + par3Socket.getInetAddress());
            return null;
        }
        lt.a((int)j2, (long)packet.a());
        ++o;
        p += (long)packet.a();
        par3Socket.setSoTimeout(i2);
        return packet;
    }

    public static void a(ey par0Packet, DataOutput par1DataOutput) throws IOException {
        par1DataOutput.write(par0Packet.n());
        par0Packet.a(par1DataOutput);
        ++q;
        r += (long)par0Packet.a();
    }

    public static void a(String par0Str, DataOutput par1DataOutput) throws IOException {
        if (par0Str.length() > Short.MAX_VALUE) {
            throw new IOException("String too big");
        }
        par1DataOutput.writeShort(par0Str.length());
        par1DataOutput.writeChars(par0Str);
    }

    public static String a(DataInput par0DataInput, int par1) throws IOException {
        int short1 = par0DataInput.readShort();
        if (short1 > par1) {
            throw new IOException("Received string length longer than maximum allowed (" + short1 + " > " + par1 + ")");
        }
        if (short1 < 0) {
            throw new IOException("Received string length is less than zero! Weird string!");
        }
        StringBuilder stringbuilder = new StringBuilder();
        for (int j2 = 0; j2 < short1; ++j2) {
            stringbuilder.append(par0DataInput.readChar());
        }
        return stringbuilder.toString();
    }

    public abstract void a(DataInput var1) throws IOException;

    public abstract void a(DataOutput var1) throws IOException;

    public abstract void a(ez var1);

    public abstract int a();

    public boolean e() {
        return false;
    }

    public boolean a(ey par1Packet) {
        return false;
    }

    public boolean a_() {
        return false;
    }

    public String toString() {
        String s2 = this.getClass().getSimpleName();
        return s2;
    }

    public static ye c(DataInput par0DataInput) throws IOException {
        ye itemstack = null;
        short short1 = par0DataInput.readShort();
        if (short1 >= 0) {
            byte b0 = par0DataInput.readByte();
            short short2 = par0DataInput.readShort();
            itemstack = new ye(short1, (int)b0, (int)short2);
            itemstack.e = ey.d(par0DataInput);
        }
        return itemstack;
    }

    public static void a(ye par0ItemStack, DataOutput par1DataOutput) throws IOException {
        if (par0ItemStack == null) {
            par1DataOutput.writeShort(-1);
        } else {
            par1DataOutput.writeShort(par0ItemStack.d);
            par1DataOutput.writeByte(par0ItemStack.b);
            par1DataOutput.writeShort(par0ItemStack.k());
            by nbttagcompound = null;
            if (par0ItemStack.b().p() || par0ItemStack.b().s()) {
                nbttagcompound = par0ItemStack.e;
            }
            ey.a(nbttagcompound, par1DataOutput);
        }
    }

    public static by d(DataInput par0DataInput) throws IOException {
        short short1 = par0DataInput.readShort();
        if (short1 < 0) {
            return null;
        }
        byte[] abyte = new byte[short1];
        par0DataInput.readFully(abyte);
        return ci.a(abyte);
    }

    protected static void a(by par0NBTTagCompound, DataOutput par1DataOutput) throws IOException {
        if (par0NBTTagCompound == null) {
            par1DataOutput.writeShort(-1);
        } else {
            byte[] abyte = ci.a(par0NBTTagCompound);
            par1DataOutput.writeShort((short)abyte.length);
            par1DataOutput.write(abyte);
        }
    }

    static {
        ey.a(0, true, true, ei.class);
        ey.a(1, true, true, ep.class);
        ey.a(2, false, true, dq.class);
        ey.a(3, true, true, dm.class);
        ey.a(4, true, false, fx.class);
        ey.a(5, true, false, fq.class);
        ey.a(6, true, false, fw.class);
        ey.a(7, false, true, eh.class);
        ey.a(8, true, false, fs.class);
        ey.a(9, true, true, fh.class);
        ey.a(10, true, true, eu.class);
        ey.a(11, true, true, ev.class);
        ey.a(12, true, true, ex.class);
        ey.a(13, true, true, ew.class);
        ey.a(14, false, true, fb.class);
        ey.a(15, false, true, gk.class);
        ey.a(16, true, true, fk.class);
        ey.a(17, true, false, ec.class);
        ey.a(18, true, true, dj.class);
        ey.a(19, false, true, fc.class);
        ey.a(20, true, false, di.class);
        ey.a(22, true, false, ga.class);
        ey.a(23, true, false, dd.class);
        ey.a(24, true, false, dg.class);
        ey.a(25, true, false, dh.class);
        ey.a(26, true, false, de.class);
        ey.a(27, false, true, fe.class);
        ey.a(28, true, false, fp.class);
        ey.a(29, true, false, ff.class);
        ey.a(30, true, false, eq.class);
        ey.a(31, true, false, er.class);
        ey.a(32, true, false, et.class);
        ey.a(33, true, false, es.class);
        ey.a(34, true, false, gb.class);
        ey.a(35, true, false, fi.class);
        ey.a(38, true, false, ed.class);
        ey.a(39, true, false, fo.class);
        ey.a(40, true, false, fn.class);
        ey.a(41, true, false, gj.class);
        ey.a(42, true, false, fg.class);
        ey.a(43, true, false, fr.class);
        ey.a(44, true, false, gh.class);
        ey.a(51, true, false, ej.class);
        ey.a(52, true, false, dn.class);
        ey.a(53, true, false, gg.class);
        ey.a(54, true, false, gf.class);
        ey.a(55, true, false, gc.class);
        ey.a(56, true, false, el.class);
        ey.a(60, true, false, ee.class);
        ey.a(61, true, false, em.class);
        ey.a(62, true, false, eo.class);
        ey.a(63, true, false, en.class);
        ey.a(70, true, false, ef.class);
        ey.a(71, true, false, df.class);
        ey.a(100, true, false, dw.class);
        ey.a(101, true, true, dv.class);
        ey.a(102, false, true, du.class);
        ey.a(103, true, false, dz.class);
        ey.a(104, true, false, dx.class);
        ey.a(105, true, false, dy.class);
        ey.a(106, true, true, ds.class);
        ey.a(107, true, true, fl.class);
        ey.a(108, false, true, dt.class);
        ey.a(130, true, true, fz.class);
        ey.a(131, true, true, dr.class);
        ey.a(132, true, false, ge.class);
        ey.a(133, true, false, gd.class);
        ey.a(200, true, false, dk.class);
        ey.a(201, true, false, fd.class);
        ey.a(202, true, true, fa.class);
        ey.a(203, true, true, dl.class);
        ey.a(204, false, true, dp.class);
        ey.a(205, false, true, do.class);
        ey.a(206, true, false, ft.class);
        ey.a(207, true, false, fv.class);
        ey.a(208, true, false, fm.class);
        ey.a(209, true, false, fu.class);
        ey.a(250, true, true, ea.class);
        ey.a(252, true, true, fy.class);
        ey.a(253, true, false, fj.class);
        ey.a(254, false, true, eg.class);
        ey.a(255, true, true, eb.class);
    }
}

