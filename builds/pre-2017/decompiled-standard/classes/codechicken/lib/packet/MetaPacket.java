/*
 * Decompiled with CFR 0.152.
 */
package codechicken.lib.packet;

import codechicken.lib.asm.ObfMapping;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public class MetaPacket
extends jjqf {
    public ArrayList<cezg> packets = new ArrayList();

    public MetaPacket(cezg ... cezgArray) {
        super("", null);
        for (cezg cezg2 : cezgArray) {
            this.packets.add(cezg2);
        }
    }

    public MetaPacket(Collection<? extends cezg> collection) {
        this.packets.addAll(collection);
    }

    @Override
    public void func_73267_a(DataInput dataInput) {
        throw new IllegalStateException("Meta packets can't be read");
    }

    @Override
    public void func_73273_a(DataOutput dataOutput) {
        try {
            super.func_73273_a(dataOutput);
            for (cezg cezg2 : this.packets) {
                cezg.func_73266_a(cezg2, dataOutput);
            }
            cezg.field_73289_q -= (long)(this.func_73284_a() - super.func_73284_a());
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    @Override
    public void func_73279_a(elai elai2) {
        for (cezg cezg2 : this.packets) {
            cezg2.func_73279_a(elai2);
        }
    }

    @Override
    public int func_73284_a() {
        int n = 0;
        for (cezg cezg2 : this.packets) {
            n += cezg2.func_73284_a() + 1;
        }
        return n;
    }

    static {
        try {
            String string = new ObfMapping((String)"ey", (String)"a", (String)"Ljava/util/Map;").toRuntime().s_name;
            Field field = cezg.class.getDeclaredField(string);
            field.setAccessible(true);
            Map map = (Map)field.get(null);
            map.put(MetaPacket.class, 250);
        }
        catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }
}

