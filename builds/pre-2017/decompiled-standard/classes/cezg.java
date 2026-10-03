/*
 * Decompiled with CFR 0.152.
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
import net.minecraft.util.amxi;

public abstract class cezg {
    public static amxi field_73294_l = new amxi();
    public static Map field_73291_a = new HashMap();
    public static Set field_73286_b = new HashSet();
    public static Set field_73288_c = new HashSet();
    public jjmf field_98193_m;
    public final long field_73295_m = dzfd.__aq();
    public static long field_73292_n;
    public static long field_73293_o;
    public static long field_73290_p;
    public static long field_73289_q;
    public boolean field_73287_r;

    public static void func_73285_a(int n, boolean bl, boolean bl2, Class clazz) {
        if (field_73294_l._c(n)) {
            throw new IllegalArgumentException("Duplicate packet id:" + n);
        }
        if (field_73291_a.containsKey(clazz)) {
            throw new IllegalArgumentException("Duplicate packet class:" + clazz);
        }
        field_73294_l._a(n, clazz);
        field_73291_a.put(clazz, n);
        if (bl) {
            field_73286_b.add(n);
        }
        if (bl2) {
            field_73288_c.add(n);
        }
    }

    public static cezg func_73269_d(jjmf jjmf2, int n) {
        try {
            Class clazz = (Class)field_73294_l._b(n);
            return clazz == null ? null : (cezg)clazz.newInstance();
        }
        catch (Exception exception) {
            exception.printStackTrace();
            jjmf2._c("Skipping packet with id " + n);
            return null;
        }
    }

    public static void func_73274_a(DataOutput dataOutput, byte[] byArray) throws IOException {
        dataOutput.writeShort(byArray.length);
        dataOutput.write(byArray);
    }

    public static byte[] func_73280_b(DataInput dataInput) throws IOException {
        short s = dataInput.readShort();
        if (s < 0) {
            throw new IOException("Key was smaller than nothing!  Weird key!");
        }
        byte[] byArray = new byte[s];
        dataInput.readFully(byArray);
        return byArray;
    }

    public final int func_73281_k() {
        return (Integer)field_73291_a.get(this.getClass());
    }

    public static cezg func_73272_a(jjmf jjmf2, DataInput dataInput, boolean bl, Socket socket) throws IOException {
        int n;
        boolean bl2 = false;
        cezg cezg2 = null;
        int n2 = socket.getSoTimeout();
        try {
            n = dataInput.readUnsignedByte();
            if (bl && !field_73288_c.contains(n) || !bl && !field_73286_b.contains(n)) {
                throw new IOException("Bad packet id " + n);
            }
            cezg2 = cezg.func_73269_d(jjmf2, n);
            if (cezg2 == null) {
                throw new IOException("Bad packet id " + n);
            }
            cezg2.field_98193_m = jjmf2;
            if (cezg2 instanceof kmtn) {
                socket.setSoTimeout(1500);
            }
            cezg2.func_73267_a(dataInput);
            ++field_73292_n;
            field_73293_o += (long)cezg2.func_73284_a();
        }
        catch (EOFException eOFException) {
            jjmf2._c("Reached end of stream for " + socket.getInetAddress());
            return null;
        }
        xbzc._a(n, cezg2.func_73284_a());
        ++field_73292_n;
        field_73293_o += (long)cezg2.func_73284_a();
        socket.setSoTimeout(n2);
        return cezg2;
    }

    public static void func_73266_a(cezg cezg2, DataOutput dataOutput) throws IOException {
        dataOutput.write(cezg2.func_73281_k());
        cezg2.func_73273_a(dataOutput);
        ++field_73290_p;
        field_73289_q += (long)cezg2.func_73284_a();
    }

    public static void func_73271_a(String string, DataOutput dataOutput) throws IOException {
        if (string.length() > Short.MAX_VALUE) {
            throw new IOException("String too big");
        }
        dataOutput.writeShort(string.length());
        dataOutput.writeChars(string);
    }

    public static String func_73282_a(DataInput dataInput, int n) throws IOException {
        int n2 = dataInput.readShort();
        if (n2 > n) {
            throw new IOException("Received string length longer than maximum allowed (" + n2 + " > " + n + ")");
        }
        if (n2 < 0) {
            throw new IOException("Received string length is less than zero! Weird string!");
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n2; ++i) {
            stringBuilder.append(dataInput.readChar());
        }
        return stringBuilder.toString();
    }

    public abstract void func_73267_a(DataInput var1) throws IOException;

    public abstract void func_73273_a(DataOutput var1) throws IOException;

    public abstract void func_73279_a(elai var1);

    public abstract int func_73284_a();

    public boolean func_73278_e() {
        return false;
    }

    public boolean func_73268_a(cezg cezg2) {
        return false;
    }

    public boolean func_73277_a_() {
        return false;
    }

    public String toString() {
        String string = this.getClass().getSimpleName();
        return string;
    }

    public static cvzo func_73276_c(DataInput dataInput) throws IOException {
        cvzo cvzo2 = null;
        short s = dataInput.readShort();
        if (s >= 0) {
            byte by = dataInput.readByte();
            short s2 = dataInput.readShort();
            cvzo2 = new cvzo(s, (int)by, (int)s2);
            cvzo2._e = cezg.func_73283_d(dataInput);
        }
        cvzo cvzo3 = cvzo2;
        owtc._a(null, dataInput, cvzo3);
        return cvzo3;
    }

    public static void func_73270_a(cvzo cvzo2, DataOutput dataOutput) throws IOException {
        if (cvzo2 == null) {
            dataOutput.writeShort(-1);
        } else {
            dataOutput.writeShort(cvzo2._d);
            dataOutput.writeByte(cvzo2._b);
            dataOutput.writeShort(cvzo2._j());
            qoac qoac2 = null;
            if (cvzo2._a().func_77645_m() || cvzo2._a().func_77651_p()) {
                qoac2 = cvzo2._e;
            }
            cezg.func_73275_a(qoac2, dataOutput);
        }
        owtc._a(null, cvzo2, dataOutput);
    }

    public static qoac func_73283_d(DataInput dataInput) throws IOException {
        short s = dataInput.readShort();
        if (s < 0) {
            return null;
        }
        byte[] byArray = new byte[s];
        dataInput.readFully(byArray);
        return bsvf._a(byArray);
    }

    public static void func_73275_a(qoac qoac2, DataOutput dataOutput) throws IOException {
        if (qoac2 == null) {
            dataOutput.writeShort(-1);
        } else {
            byte[] byArray = bsvf._a(qoac2);
            dataOutput.writeShort((short)byArray.length);
            dataOutput.write(byArray);
        }
    }

    static {
        cezg.func_73285_a(0, true, true, cezd.class);
        cezg.func_73285_a(1, true, true, txpf.class);
        cezg.func_73285_a(2, false, true, yezn.class);
        cezg.func_73285_a(3, true, true, cwaz.class);
        cezg.func_73285_a(4, true, false, rrld.class);
        cezg.func_73285_a(5, true, false, hdms.class);
        cezg.func_73285_a(6, true, false, xbzt.class);
        cezg.func_73285_a(7, false, true, sdlx.class);
        cezg.func_73285_a(8, true, false, sdlz.class);
        cezg.func_73285_a(9, true, true, hdmk.class);
        cezg.func_73285_a(10, true, true, yvzj.class);
        cezg.func_73285_a(11, true, true, tgjz.class);
        cezg.func_73285_a(12, true, true, ixmg.class);
        cezg.func_73285_a(13, true, true, xszx.class);
        cezg.func_73285_a(14, false, true, sdkq.class);
        cezg.func_73285_a(15, false, true, kmuc.class);
        cezg.func_73285_a(16, true, true, jjre.class);
        cezg.func_73285_a(17, true, false, kmuh.class);
        cezg.func_73285_a(18, true, true, jjrh.class);
        cezg.func_73285_a(19, false, true, diaa.class);
        cezg.func_73285_a(20, true, false, xsze.class);
        cezg.func_73285_a(22, true, false, bbyg.class);
        cezg.func_73285_a(23, true, false, ixor.class);
        cezg.func_73285_a(24, true, false, tgmo.class);
        cezg.func_73285_a(25, true, false, ixoa.class);
        cezg.func_73285_a(26, true, false, kmst.class);
        cezg.func_73285_a(27, false, true, lpvs.class);
        cezg.func_73285_a(28, true, false, fofa.class);
        cezg.func_73285_a(29, true, false, ixod.class);
        cezg.func_73285_a(30, true, false, vmsk.class);
        cezg.func_73285_a(31, true, false, sukx.class);
        cezg.func_73285_a(32, true, false, ixoh.class);
        cezg.func_73285_a(33, true, false, xsyc.class);
        cezg.func_73285_a(34, true, false, txnr.class);
        cezg.func_73285_a(35, true, false, ragc.class);
        cezg.func_73285_a(38, true, false, bszz.class);
        cezg.func_73285_a(39, true, false, nwaj.class);
        cezg.func_73285_a(40, true, false, qoia.class);
        cezg.func_73285_a(41, true, false, cwaw.class);
        cezg.func_73285_a(42, true, false, zibp.class);
        cezg.func_73285_a(43, true, false, rajk.class);
        cezg.func_73285_a(44, true, false, tgpn.class);
        cezg.func_73285_a(51, true, false, ujsv.class);
        cezg.func_73285_a(52, true, false, txrg.class);
        cezg.func_73285_a(53, true, false, cwan.class);
        cezg.func_73285_a(54, true, false, ujsb.class);
        cezg.func_73285_a(55, true, false, igpu.class);
        cezg.func_73285_a(56, true, false, xbzz.class);
        cezg.func_73285_a(60, true, false, ozcz.class);
        cezg.func_73285_a(61, true, false, qohl.class);
        cezg.func_73285_a(62, true, false, lpza.class);
        cezg.func_73285_a(63, true, false, grll.class);
        cezg.func_73285_a(70, true, false, tgph.class);
        cezg.func_73285_a(71, true, false, dibg.class);
        cezg.func_73285_a(100, true, false, lpub.class);
        cezg.func_73285_a(101, true, true, txlx.class);
        cezg.func_73285_a(102, false, true, kmrj.class);
        cezg.func_73285_a(103, true, false, ixmv.class);
        cezg.func_73285_a(104, true, false, wptu.class);
        cezg.func_73285_a(105, true, false, neyc.class);
        cezg.func_73285_a(106, true, true, ixma.class);
        cezg.func_73285_a(107, true, true, bsye.class);
        cezg.func_73285_a(108, false, true, lptv.class);
        cezg.func_73285_a(130, true, true, gaet.class);
        cezg.func_73285_a(131, true, true, yexp.class);
        cezg.func_73285_a(132, true, false, wpte.class);
        cezg.func_73285_a(133, true, false, wpwt.class);
        cezg.func_73285_a(200, true, false, dzcl.class);
        cezg.func_73285_a(201, true, false, bbzw.class);
        cezg.func_73285_a(202, true, true, ragy.class);
        cezg.func_73285_a(203, true, true, hdkt.class);
        cezg.func_73285_a(204, false, true, grje.class);
        cezg.func_73285_a(205, false, true, hdkw.class);
        cezg.func_73285_a(206, true, false, sulv.class);
        cezg.func_73285_a(207, true, false, plcv.class);
        cezg.func_73285_a(208, true, false, txou.class);
        cezg.func_73285_a(209, true, false, lpxb.class);
        cezg.func_73285_a(250, true, true, jjqf.class);
        cezg.func_73285_a(252, true, true, hulv.class);
        cezg.func_73285_a(253, true, false, ujpx.class);
        cezg.func_73285_a(254, false, true, kmtn.class);
        cezg.func_73285_a(255, true, true, vmsc.class);
    }
}

