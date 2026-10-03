/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.packet;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import net.minecraft.item.ItemStack;
import net.minecraft.logging.ILogAgent;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet0KeepAlive;
import net.minecraft.network.packet.Packet101CloseWindow;
import net.minecraft.network.packet.Packet102WindowClick;
import net.minecraft.network.packet.Packet106Transaction;
import net.minecraft.network.packet.Packet107CreativeSetSlot;
import net.minecraft.network.packet.Packet108EnchantItem;
import net.minecraft.network.packet.Packet10Flying;
import net.minecraft.network.packet.Packet130UpdateSign;
import net.minecraft.network.packet.Packet14BlockDig;
import net.minecraft.network.packet.Packet15Place;
import net.minecraft.network.packet.Packet16BlockItemSwitch;
import net.minecraft.network.packet.Packet18Animation;
import net.minecraft.network.packet.Packet19EntityAction;
import net.minecraft.network.packet.Packet202PlayerAbilities;
import net.minecraft.network.packet.Packet203AutoComplete;
import net.minecraft.network.packet.Packet204ClientInfo;
import net.minecraft.network.packet.Packet205ClientCommand;
import net.minecraft.network.packet.Packet209SetPlayerTeam;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.network.packet.Packet252SharedKey;
import net.minecraft.network.packet.Packet254ServerPing;
import net.minecraft.network.packet.Packet255KickDisconnect;
import net.minecraft.network.packet.Packet27PlayerInput;
import net.minecraft.network.packet.Packet30Entity;
import net.minecraft.network.packet.Packet3Chat;
import net.minecraft.network.packet.Packet44UpdateAttributes;
import net.minecraft.network.packet.Packet52MultiBlockChange;
import net.minecraft.network.packet.Packet56MapChunks;
import net.minecraft.network.packet.Packet70GameEvent;
import net.minecraft.network.packet.Packet7UseEntity;
import net.minecraft.network.packet.Packet9Respawn;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.IntHashMap;

public abstract class Packet {
    public static IntHashMap packetIdToClassMap = new IntHashMap();
    public static Map packetClassToIdMap = new HashMap();
    public static Set clientPacketIdList = new HashSet();
    public static Set serverPacketIdList = new HashSet();
    public ILogAgent field_98193_m;
    public final long creationTimeMillis = MinecraftServer.__aq();
    public static long receivedID;
    public static long receivedSize;
    public static long sentID;
    public static long sentSize;
    public boolean isChunkDataPacket;

    public static void addIdClassMapping(int n, boolean bl, boolean bl2, Class clazz) {
        if (packetIdToClassMap._c(n)) {
            throw new IllegalArgumentException("Duplicate packet id:" + n);
        }
        if (packetClassToIdMap.containsKey(clazz)) {
            throw new IllegalArgumentException("Duplicate packet class:" + clazz);
        }
        packetIdToClassMap._a(n, clazz);
        packetClassToIdMap.put(clazz, n);
        if (bl) {
            clientPacketIdList.add(n);
        }
        if (bl2) {
            serverPacketIdList.add(n);
        }
    }

    public static Packet getNewPacket(ILogAgent iLogAgent, int n) {
        try {
            Class clazz = (Class)packetIdToClassMap._b(n);
            return clazz == null ? null : (Packet)clazz.newInstance();
        }
        catch (Exception exception) {
            exception.printStackTrace();
            iLogAgent._c("Skipping packet with id " + n);
            return null;
        }
    }

    public static void writeByteArray(DataOutput dataOutput, byte[] byArray) throws IOException {
        dataOutput.writeShort(byArray.length);
        dataOutput.write(byArray);
    }

    public static byte[] readBytesFromStream(DataInput dataInput) throws IOException {
        short s = dataInput.readShort();
        if (s < 0) {
            throw new IOException("Key was smaller than nothing!  Weird key!");
        }
        byte[] byArray = new byte[s];
        dataInput.readFully(byArray);
        return byArray;
    }

    public final int getPacketId() {
        return (Integer)packetClassToIdMap.get(this.getClass());
    }

    public static Packet readPacket(ILogAgent iLogAgent, DataInput dataInput, boolean bl, Socket socket) throws IOException {
        int n;
        boolean bl2 = false;
        Packet packet = null;
        int n2 = socket.getSoTimeout();
        try {
            n = dataInput.readUnsignedByte();
            if (bl && !serverPacketIdList.contains(n) || !bl && !clientPacketIdList.contains(n)) {
                throw new IOException("Bad packet id " + n);
            }
            packet = Packet.getNewPacket(iLogAgent, n);
            if (packet == null) {
                throw new IOException("Bad packet id " + n);
            }
            packet.field_98193_m = iLogAgent;
            if (packet instanceof Packet254ServerPing) {
                socket.setSoTimeout(1500);
            }
            packet.readPacketData(dataInput);
            ++receivedID;
            receivedSize += (long)packet.getPacketSize();
        }
        catch (EOFException eOFException) {
            iLogAgent._c("Reached end of stream for " + socket.getInetAddress());
            return null;
        }
        xbzc._a(n, packet.getPacketSize());
        ++receivedID;
        receivedSize += (long)packet.getPacketSize();
        socket.setSoTimeout(n2);
        return packet;
    }

    public static void writePacket(Packet packet, DataOutput dataOutput) throws IOException {
        dataOutput.write(packet.getPacketId());
        packet.writePacketData(dataOutput);
        ++sentID;
        sentSize += (long)packet.getPacketSize();
    }

    public static void writeString(String string, DataOutput dataOutput) throws IOException {
        if (string.length() > Short.MAX_VALUE) {
            throw new IOException("String too big");
        }
        dataOutput.writeShort(string.length());
        dataOutput.writeChars(string);
    }

    public static String readString(DataInput dataInput, int n) throws IOException {
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

    public abstract void readPacketData(DataInput var1) throws IOException;

    public abstract void writePacketData(DataOutput var1) throws IOException;

    public abstract void processPacket(NetHandler var1);

    public abstract int getPacketSize();

    public boolean isRealPacket() {
        return false;
    }

    public boolean containsSameEntityIDAs(Packet packet) {
        return false;
    }

    public boolean canProcessAsync() {
        return false;
    }

    public String toString() {
        String string = this.getClass().getSimpleName();
        return string;
    }

    public static ItemStack readItemStack(DataInput dataInput) throws IOException {
        ItemStack itemStack = null;
        short s = dataInput.readShort();
        if (s >= 0) {
            byte by = dataInput.readByte();
            short s2 = dataInput.readShort();
            itemStack = new ItemStack(s, (int)by, (int)s2);
            itemStack._e = Packet.readNBTTagCompound(dataInput);
        }
        ItemStack itemStack2 = itemStack;
        owtc._a(null, dataInput, itemStack2);
        return itemStack2;
    }

    public static void writeItemStack(ItemStack itemStack, DataOutput dataOutput) throws IOException {
        if (itemStack == null) {
            dataOutput.writeShort(-1);
        } else {
            dataOutput.writeShort(itemStack._d);
            dataOutput.writeByte(itemStack._b);
            dataOutput.writeShort(itemStack._j());
            NBTTagCompound nBTTagCompound = null;
            if (itemStack._a().isDamageable() || itemStack._a().getShareTag()) {
                nBTTagCompound = itemStack._e;
            }
            Packet.writeNBTTagCompound(nBTTagCompound, dataOutput);
        }
        owtc._a(null, itemStack, dataOutput);
    }

    public static NBTTagCompound readNBTTagCompound(DataInput dataInput) throws IOException {
        short s = dataInput.readShort();
        if (s < 0) {
            return null;
        }
        byte[] byArray = new byte[s];
        dataInput.readFully(byArray);
        return bsvf._a(byArray);
    }

    public static void writeNBTTagCompound(NBTTagCompound nBTTagCompound, DataOutput dataOutput) throws IOException {
        if (nBTTagCompound == null) {
            dataOutput.writeShort(-1);
        } else {
            byte[] byArray = bsvf._a(nBTTagCompound);
            dataOutput.writeShort((short)byArray.length);
            dataOutput.write(byArray);
        }
    }

    static {
        Packet.addIdClassMapping(0, true, true, Packet0KeepAlive.class);
        Packet.addIdClassMapping(1, true, true, txpf.class);
        Packet.addIdClassMapping(2, false, true, yezn.class);
        Packet.addIdClassMapping(3, true, true, Packet3Chat.class);
        Packet.addIdClassMapping(4, true, false, rrld.class);
        Packet.addIdClassMapping(5, true, false, hdms.class);
        Packet.addIdClassMapping(6, true, false, xbzt.class);
        Packet.addIdClassMapping(7, false, true, Packet7UseEntity.class);
        Packet.addIdClassMapping(8, true, false, sdlz.class);
        Packet.addIdClassMapping(9, true, true, Packet9Respawn.class);
        Packet.addIdClassMapping(10, true, true, Packet10Flying.class);
        Packet.addIdClassMapping(11, true, true, tgjz.class);
        Packet.addIdClassMapping(12, true, true, ixmg.class);
        Packet.addIdClassMapping(13, true, true, xszx.class);
        Packet.addIdClassMapping(14, false, true, Packet14BlockDig.class);
        Packet.addIdClassMapping(15, false, true, Packet15Place.class);
        Packet.addIdClassMapping(16, true, true, Packet16BlockItemSwitch.class);
        Packet.addIdClassMapping(17, true, false, kmuh.class);
        Packet.addIdClassMapping(18, true, true, Packet18Animation.class);
        Packet.addIdClassMapping(19, false, true, Packet19EntityAction.class);
        Packet.addIdClassMapping(20, true, false, xsze.class);
        Packet.addIdClassMapping(22, true, false, bbyg.class);
        Packet.addIdClassMapping(23, true, false, ixor.class);
        Packet.addIdClassMapping(24, true, false, tgmo.class);
        Packet.addIdClassMapping(25, true, false, ixoa.class);
        Packet.addIdClassMapping(26, true, false, kmst.class);
        Packet.addIdClassMapping(27, false, true, Packet27PlayerInput.class);
        Packet.addIdClassMapping(28, true, false, fofa.class);
        Packet.addIdClassMapping(29, true, false, ixod.class);
        Packet.addIdClassMapping(30, true, false, Packet30Entity.class);
        Packet.addIdClassMapping(31, true, false, sukx.class);
        Packet.addIdClassMapping(32, true, false, ixoh.class);
        Packet.addIdClassMapping(33, true, false, xsyc.class);
        Packet.addIdClassMapping(34, true, false, txnr.class);
        Packet.addIdClassMapping(35, true, false, ragc.class);
        Packet.addIdClassMapping(38, true, false, bszz.class);
        Packet.addIdClassMapping(39, true, false, nwaj.class);
        Packet.addIdClassMapping(40, true, false, qoia.class);
        Packet.addIdClassMapping(41, true, false, cwaw.class);
        Packet.addIdClassMapping(42, true, false, zibp.class);
        Packet.addIdClassMapping(43, true, false, rajk.class);
        Packet.addIdClassMapping(44, true, false, Packet44UpdateAttributes.class);
        Packet.addIdClassMapping(51, true, false, ujsv.class);
        Packet.addIdClassMapping(52, true, false, Packet52MultiBlockChange.class);
        Packet.addIdClassMapping(53, true, false, cwan.class);
        Packet.addIdClassMapping(54, true, false, ujsb.class);
        Packet.addIdClassMapping(55, true, false, igpu.class);
        Packet.addIdClassMapping(56, true, false, Packet56MapChunks.class);
        Packet.addIdClassMapping(60, true, false, ozcz.class);
        Packet.addIdClassMapping(61, true, false, qohl.class);
        Packet.addIdClassMapping(62, true, false, lpza.class);
        Packet.addIdClassMapping(63, true, false, grll.class);
        Packet.addIdClassMapping(70, true, false, Packet70GameEvent.class);
        Packet.addIdClassMapping(71, true, false, dibg.class);
        Packet.addIdClassMapping(100, true, false, lpub.class);
        Packet.addIdClassMapping(101, true, true, Packet101CloseWindow.class);
        Packet.addIdClassMapping(102, false, true, Packet102WindowClick.class);
        Packet.addIdClassMapping(103, true, false, ixmv.class);
        Packet.addIdClassMapping(104, true, false, wptu.class);
        Packet.addIdClassMapping(105, true, false, neyc.class);
        Packet.addIdClassMapping(106, true, true, Packet106Transaction.class);
        Packet.addIdClassMapping(107, true, true, Packet107CreativeSetSlot.class);
        Packet.addIdClassMapping(108, false, true, Packet108EnchantItem.class);
        Packet.addIdClassMapping(130, true, true, Packet130UpdateSign.class);
        Packet.addIdClassMapping(131, true, true, yexp.class);
        Packet.addIdClassMapping(132, true, false, wpte.class);
        Packet.addIdClassMapping(133, true, false, wpwt.class);
        Packet.addIdClassMapping(200, true, false, dzcl.class);
        Packet.addIdClassMapping(201, true, false, bbzw.class);
        Packet.addIdClassMapping(202, true, true, Packet202PlayerAbilities.class);
        Packet.addIdClassMapping(203, true, true, Packet203AutoComplete.class);
        Packet.addIdClassMapping(204, false, true, Packet204ClientInfo.class);
        Packet.addIdClassMapping(205, false, true, Packet205ClientCommand.class);
        Packet.addIdClassMapping(206, true, false, sulv.class);
        Packet.addIdClassMapping(207, true, false, plcv.class);
        Packet.addIdClassMapping(208, true, false, txou.class);
        Packet.addIdClassMapping(209, true, false, Packet209SetPlayerTeam.class);
        Packet.addIdClassMapping(250, true, true, Packet250CustomPayload.class);
        Packet.addIdClassMapping(252, true, true, Packet252SharedKey.class);
        Packet.addIdClassMapping(253, true, false, ujpx.class);
        Packet.addIdClassMapping(254, false, true, Packet254ServerPing.class);
        Packet.addIdClassMapping(255, true, true, Packet255KickDisconnect.class);
    }
}

