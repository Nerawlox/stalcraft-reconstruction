/*
 * Decompiled with CFR 0.152.
 */
package net.smart.moving;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.Set;
import net.smart.moving.IEntityPlayerMP;
import net.smart.moving.IPacketReceiver;
import net.smart.moving.IPacketSender;
import net.smart.moving.Info;

public class SmartMovingPacketStream {
    public static final String Id;
    public static final Set errors;

    public static void receivePacket(jjqf jjqf2, IPacketReceiver iPacketReceiver, IEntityPlayerMP iEntityPlayerMP) {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(jjqf2.field_73629_c);
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            byte by = objectInputStream.readByte();
            switch (by) {
                case 0: {
                    int n = objectInputStream.readInt();
                    long l = objectInputStream.readLong();
                    iPacketReceiver.processStatePacket(jjqf2, iEntityPlayerMP, n, l);
                    break;
                }
                default: {
                    throw new RuntimeException("Unknown packet id '" + by + "' found");
                }
            }
        }
        catch (Throwable throwable) {
            if (errors.add(throwable.getStackTrace()[0])) {
                throwable.printStackTrace();
            }
            System.err.println(throwable.getClass().getName() + ": " + throwable.getMessage());
        }
    }

    public static jjqf genPacket(byte[] byArray) {
        jjqf jjqf2 = new jjqf();
        jjqf2.field_73630_a = Id;
        jjqf2.field_73629_c = byArray;
        jjqf2.field_73628_b = byArray.length;
        return jjqf2;
    }

    public static byte[] getStatePacket(int n, long l) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeByte(0);
            objectOutputStream.writeInt(n);
            objectOutputStream.writeLong(l);
            objectOutputStream.flush();
        }
        catch (Throwable throwable) {
            throw new RuntimeException(throwable);
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static void sendState(IPacketSender iPacketSender, int n, long l) {
        iPacketSender.sendPacket(SmartMovingPacketStream.getStatePacket(n, l));
    }

    public static void sendConfigInfo(IPacketSender iPacketSender, String string) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeByte(1);
            objectOutputStream.writeObject(string);
            objectOutputStream.flush();
        }
        catch (Throwable throwable) {
            throw new RuntimeException(throwable);
        }
        iPacketSender.sendPacket(byteArrayOutputStream.toByteArray());
    }

    public static void sendConfigContent(IPacketSender iPacketSender, String[] stringArray, String string) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeByte(2);
            objectOutputStream.writeObject(stringArray);
            objectOutputStream.writeObject(string);
            objectOutputStream.flush();
        }
        catch (Throwable throwable) {
            throw new RuntimeException(throwable);
        }
        iPacketSender.sendPacket(byteArrayOutputStream.toByteArray());
    }

    static {
        String string = Info.ModComId;
        if (string.length() > 15) {
            string = string.substring(0, 15);
        }
        Id = string;
        errors = new HashSet();
    }
}

