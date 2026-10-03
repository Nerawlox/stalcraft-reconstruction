/*
 * Decompiled with CFR 0.152.
 */
package codechicken.lib.packet;

import codechicken.lib.data.MCDataInput;
import codechicken.lib.data.MCDataOutput;
import codechicken.lib.packet.MetaPacket;
import codechicken.lib.vec.BlockCoord;
import cpw.mods.fml.common.network.FMLNetworkHandler;
import cpw.mods.fml.common.network.IConnectionHandler;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.ITinyPacketHandler;
import cpw.mods.fml.common.network.NetworkModHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.Player;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.zip.Deflater;
import java.util.zip.Inflater;
import net.minecraft.client.xpzm;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fluids.FluidStack;

public final class PacketCustom
implements MCDataInput,
MCDataOutput {
    public static PacketAssembler assembler = new PacketAssembler();
    public static IPacketCarrier carrier250 = new Packet250Carrier();
    public static IPacketCarrier carrier131 = new Packet131Carrier();
    private static int assemblyID = 0;
    private Object channel;
    private int type;
    private boolean isChunkDataPacket;
    private ByteArrayOutputStream dataarrayout;
    private DataOutputStream dataout;
    private DataInputStream datain;
    private static HashMap<String, CustomPacketHandler> clienthandlermap = new HashMap();
    private static HashMap<String, CustomPacketHandler> serverhandlermap = new HashMap();

    public static IPacketCarrier carrierForChannel(Object object) {
        if (object instanceof String) {
            return carrier250;
        }
        if (FMLNetworkHandler.instance().findNetworkModHandler(object) != null) {
            return carrier131;
        }
        return null;
    }

    public static void writeInt(byte[] byArray, int n, int n2) {
        byArray[n++] = (byte)(n2 >>> 24);
        byArray[n++] = (byte)(n2 >> 16);
        byArray[n++] = (byte)(n2 >> 8);
        byArray[n++] = (byte)n2;
    }

    public static int readInt(byte[] byArray, int n) {
        return (byArray[n++] & 0xFF) << 24 | (byArray[n++] & 0xFF) << 16 | (byArray[n++] & 0xFF) << 8 | byArray[n++] & 0xFF;
    }

    private PacketCustom(Object object, int n, byte[] byArray) {
        this.channel = object;
        this.type = n;
        if (n > 128) {
            byArray = this.decompress(byArray);
        }
        this.datain = new DataInputStream(new ByteArrayInputStream(byArray));
    }

    public PacketCustom(Object object, int n) {
        if (n <= 0 || n >= 128) {
            throw new IllegalArgumentException("Packet type: " + n + " is not within required 0 < t < 0x80");
        }
        this.channel = object;
        this.type = n;
        this.isChunkDataPacket = false;
        this.dataarrayout = new ByteArrayOutputStream();
        this.dataout = new DataOutputStream(this.dataarrayout);
    }

    public boolean incoming() {
        return this.dataout == null;
    }

    public int getType() {
        return this.type & 0x7F;
    }

    public PacketCustom setChunkDataPacket() {
        this.isChunkDataPacket = true;
        return this;
    }

    private byte[] decompress(byte[] byArray) {
        if ((this.type & 0x80) == 0) {
            return byArray;
        }
        Inflater inflater = new Inflater();
        try {
            byte[] byArray2 = new byte[PacketCustom.readInt(byArray, 0)];
            inflater.setInput(byArray, 4, byArray.length - 4);
            inflater.inflate(byArray2);
            byte[] byArray3 = byArray2;
            return byArray3;
        }
        catch (Exception exception) {
            throw new RuntimeException(exception);
        }
        finally {
            inflater.end();
        }
    }

    public PacketCustom compressed() {
        if (this.incoming()) {
            throw new IllegalStateException("Tried to compress an incoming packet");
        }
        if ((this.type & 0x80) != 0) {
            throw new IllegalStateException("Packet already compressed");
        }
        this.type |= 0x80;
        return this;
    }

    private byte[] compress(byte[] byArray) {
        Deflater deflater = new Deflater();
        try {
            deflater.setInput(byArray, 0, byArray.length);
            deflater.finish();
            byte[] byArray2 = new byte[byArray.length];
            int n = deflater.deflate(byArray2, 0, byArray.length);
            if (n == byArray.length || !deflater.finished()) {
                this.type &= 0x7F;
                byte[] byArray3 = byArray;
                return byArray3;
            }
            byte[] byArray4 = new byte[n + 4];
            PacketCustom.writeInt(byArray4, 0, byArray.length);
            System.arraycopy(byArray2, 0, byArray4, 4, n);
            this.type |= 0x80;
            byte[] byArray5 = byArray4;
            return byArray5;
        }
        catch (Exception exception) {
            throw new RuntimeException(exception);
        }
        finally {
            deflater.end();
        }
    }

    public cezg toPacket() {
        if (this.incoming()) {
            throw new IllegalStateException("Tried to write an incoming packet");
        }
        try {
            this.dataout.close();
        }
        catch (IOException iOException) {
            throw new RuntimeException(iOException);
        }
        byte[] byArray = this.dataarrayout.toByteArray();
        if (byArray.length > 32000 || (this.type & 0x80) != 0) {
            byArray = this.compress(byArray);
        }
        IPacketCarrier iPacketCarrier = PacketCustom.carrierForChannel(this.channel);
        if (byArray.length > 32000 && iPacketCarrier.shortCapped()) {
            MetaPacket metaPacket = new MetaPacket(new cezg[0]);
            int n = assemblyID++;
            byte[] byArray2 = new byte[9];
            PacketCustom.writeInt(byArray2, 0, n);
            byArray2[4] = (byte)this.type;
            PacketCustom.writeInt(byArray2, 5, byArray.length);
            metaPacket.packets.add(iPacketCarrier.write(this.channel, this.isChunkDataPacket, 128, byArray2));
            for (int i = 0; i < byArray.length; i += 32000) {
                int n2 = Math.min(byArray.length - i, 32000);
                byte[] byArray3 = new byte[n2 + 4];
                PacketCustom.writeInt(byArray3, 0, n);
                System.arraycopy(byArray, i, byArray3, 4, n2);
                metaPacket.packets.add(iPacketCarrier.write(this.channel, this.isChunkDataPacket, 128, byArray3));
            }
            return metaPacket;
        }
        return iPacketCarrier.write(this.channel, this.isChunkDataPacket, this.type, byArray);
    }

    @Override
    public PacketCustom writeBoolean(boolean bl) {
        try {
            this.dataout.writeBoolean(bl);
        }
        catch (IOException iOException) {
            throw new RuntimeException(iOException);
        }
        return this;
    }

    @Override
    public PacketCustom writeByte(int n) {
        try {
            this.dataout.writeByte(n);
        }
        catch (IOException iOException) {
            throw new RuntimeException(iOException);
        }
        return this;
    }

    @Override
    public PacketCustom writeShort(int n) {
        try {
            this.dataout.writeShort(n);
        }
        catch (IOException iOException) {
            throw new RuntimeException(iOException);
        }
        return this;
    }

    @Override
    public PacketCustom writeInt(int n) {
        try {
            this.dataout.writeInt(n);
        }
        catch (IOException iOException) {
            throw new RuntimeException(iOException);
        }
        return this;
    }

    @Override
    public PacketCustom writeFloat(float f) {
        try {
            this.dataout.writeFloat(f);
        }
        catch (IOException iOException) {
            throw new RuntimeException(iOException);
        }
        return this;
    }

    @Override
    public PacketCustom writeDouble(double d) {
        try {
            this.dataout.writeDouble(d);
        }
        catch (IOException iOException) {
            throw new RuntimeException(iOException);
        }
        return this;
    }

    @Override
    public PacketCustom writeLong(long l) {
        try {
            this.dataout.writeLong(l);
        }
        catch (IOException iOException) {
            throw new RuntimeException(iOException);
        }
        return this;
    }

    @Override
    public PacketCustom writeChar(char c) {
        try {
            this.dataout.writeChar(c);
        }
        catch (IOException iOException) {
            throw new RuntimeException(iOException);
        }
        return this;
    }

    @Override
    public PacketCustom writeByteArray(byte[] byArray) {
        try {
            this.dataout.write(byArray);
        }
        catch (IOException iOException) {
            throw new RuntimeException(iOException);
        }
        return this;
    }

    @Override
    public PacketCustom writeCoord(int n, int n2, int n3) {
        this.writeInt(n);
        this.writeInt(n2);
        this.writeInt(n3);
        return this;
    }

    @Override
    public PacketCustom writeCoord(BlockCoord blockCoord) {
        this.writeInt(blockCoord.x);
        this.writeInt(blockCoord.y);
        this.writeInt(blockCoord.z);
        return this;
    }

    @Override
    public PacketCustom writeString(String string) {
        try {
            if (string.length() > 65535) {
                throw new IOException("String length: " + string.length() + "too long.");
            }
            this.dataout.writeShort(string.length());
            this.dataout.writeChars(string);
        }
        catch (IOException iOException) {
            throw new RuntimeException(iOException);
        }
        return this;
    }

    @Override
    public PacketCustom writeItemStack(cvzo cvzo2) {
        this.writeItemStack(cvzo2, false);
        return this;
    }

    public PacketCustom writeItemStack(cvzo cvzo2, boolean bl) {
        bl = true;
        if (cvzo2 == null) {
            this.writeShort(-1);
        } else {
            this.writeShort(cvzo2._d);
            if (bl) {
                this.writeInt(cvzo2._b);
            } else {
                this.writeByte(cvzo2._b);
            }
            this.writeShort(cvzo2._j());
            this.writeNBTTagCompound(cvzo2._e);
        }
        return this;
    }

    @Override
    public PacketCustom writeNBTTagCompound(qoac qoac2) {
        try {
            if (qoac2 == null) {
                this.writeShort(-1);
            } else {
                byte[] byArray = bsvf._a(qoac2);
                this.writeShort((short)byArray.length);
                this.writeByteArray(byArray);
            }
        }
        catch (IOException iOException) {
            throw new RuntimeException(iOException);
        }
        return this;
    }

    @Override
    public PacketCustom writeFluidStack(FluidStack fluidStack) {
        if (fluidStack == null) {
            this.writeShort(-1);
        } else {
            this.writeShort(fluidStack.fluidID);
            this.writeInt(fluidStack.amount);
            this.writeNBTTagCompound(fluidStack.tag);
        }
        return this;
    }

    @Override
    public boolean readBoolean() {
        try {
            return this.datain.readBoolean();
        }
        catch (IOException iOException) {
            throw new RuntimeException(iOException);
        }
    }

    @Override
    public int readUByte() {
        return this.readByte() & 0xFF;
    }

    @Override
    public int readUShort() {
        return this.readShort() & 0xFFFF;
    }

    @Override
    public byte readByte() {
        try {
            return this.datain.readByte();
        }
        catch (IOException iOException) {
            throw new RuntimeException(iOException);
        }
    }

    @Override
    public short readShort() {
        try {
            return this.datain.readShort();
        }
        catch (IOException iOException) {
            throw new RuntimeException(iOException);
        }
    }

    @Override
    public int readInt() {
        try {
            return this.datain.readInt();
        }
        catch (IOException iOException) {
            throw new RuntimeException(iOException);
        }
    }

    @Override
    public float readFloat() {
        try {
            return this.datain.readFloat();
        }
        catch (IOException iOException) {
            throw new RuntimeException(iOException);
        }
    }

    @Override
    public double readDouble() {
        try {
            return this.datain.readDouble();
        }
        catch (IOException iOException) {
            throw new RuntimeException(iOException);
        }
    }

    @Override
    public long readLong() {
        try {
            return this.datain.readLong();
        }
        catch (IOException iOException) {
            throw new RuntimeException(iOException);
        }
    }

    @Override
    public char readChar() {
        try {
            return this.datain.readChar();
        }
        catch (IOException iOException) {
            throw new RuntimeException(iOException);
        }
    }

    @Override
    public BlockCoord readCoord() {
        return new BlockCoord(this.readInt(), this.readInt(), this.readInt());
    }

    @Override
    public byte[] readByteArray(int n) {
        try {
            byte[] byArray = new byte[n];
            this.datain.readFully(byArray, 0, n);
            return byArray;
        }
        catch (IOException iOException) {
            throw new RuntimeException(iOException);
        }
    }

    @Override
    public String readString() {
        try {
            int n = this.datain.readUnsignedShort();
            char[] cArray = new char[n];
            for (int i = 0; i < n; ++i) {
                cArray[i] = this.readChar();
            }
            return new String(cArray);
        }
        catch (IOException iOException) {
            throw new RuntimeException(iOException);
        }
    }

    @Override
    public cvzo readItemStack() {
        return this.readItemStack(false);
    }

    public cvzo readItemStack(boolean bl) {
        bl = true;
        cvzo cvzo2 = null;
        short s = this.readShort();
        if (s >= 0) {
            int n = bl ? this.readInt() : (int)this.readByte();
            short s2 = this.readShort();
            cvzo2 = new cvzo(s, n, (int)s2);
            cvzo2._e = this.readNBTTagCompound();
        }
        return cvzo2;
    }

    @Override
    public qoac readNBTTagCompound() {
        try {
            short s = this.readShort();
            if (s < 0) {
                return null;
            }
            byte[] byArray = this.readByteArray(s);
            return bsvf._a(byArray);
        }
        catch (IOException iOException) {
            throw new RuntimeException(iOException);
        }
    }

    @Override
    public FluidStack readFluidStack() {
        FluidStack fluidStack = null;
        short s = this.readShort();
        if (s >= 0) {
            fluidStack = new FluidStack(s, this.readInt(), this.readNBTTagCompound());
        }
        return fluidStack;
    }

    public static void assignHandler(String string, int n, int n2, ICustomPacketHandler iCustomPacketHandler) {
        Side side = iCustomPacketHandler instanceof IClientPacketHandler ? Side.CLIENT : Side.SERVER;
        HashMap<String, CustomPacketHandler> hashMap = side.isClient() ? clienthandlermap : serverhandlermap;
        CustomPacketHandler customPacketHandler = hashMap.get(string);
        if (customPacketHandler == null) {
            customPacketHandler = side.isClient() ? new ClientPacketHandler(string) : new ServerPacketHandler(string);
            hashMap.put(string, customPacketHandler);
        }
        customPacketHandler.registerRange(n, n2, iCustomPacketHandler);
    }

    public static void assignHandler(Object object, ICustomPacketHandler iCustomPacketHandler) {
        NetworkModHandler networkModHandler = FMLNetworkHandler.instance().findNetworkModHandler(object);
        if (networkModHandler == null || networkModHandler.getTinyPacketHandler() == null || !(networkModHandler.getTinyPacketHandler() instanceof CustomTinyPacketHandler)) {
            throw new IllegalStateException("Invalid network tiny packet handler for mod: " + object);
        }
        ((CustomTinyPacketHandler)networkModHandler.getTinyPacketHandler()).registerSidedHandler(iCustomPacketHandler);
    }

    public void sendToPlayer(EntityPlayer entityPlayer) {
        PacketCustom.sendToPlayer(this.toPacket(), entityPlayer);
    }

    public static void sendToPlayer(cezg cezg2, EntityPlayer entityPlayer) {
        if (entityPlayer == null) {
            PacketCustom.sendToClients(cezg2);
        } else {
            ((EntityPlayerMP)entityPlayer).field_71135_a.func_72567_b(cezg2);
        }
    }

    public void sendToClients() {
        PacketCustom.sendToClients(this.toPacket());
    }

    public static void sendToClients(cezg cezg2) {
        dzfd._I().__ag()._a(cezg2);
    }

    public void sendPacketToAllAround(double d, double d2, double d3, double d4, int n) {
        PacketCustom.sendToAllAround(this.toPacket(), d, d2, d3, d4, n);
    }

    public static void sendToAllAround(cezg cezg2, double d, double d2, double d3, double d4, int n) {
        dzfd._I().__ag()._a(d, d2, d3, d4, n, cezg2);
    }

    public void sendToDimension(int n) {
        PacketCustom.sendToDimension(this.toPacket(), n);
    }

    public static void sendToDimension(cezg cezg2, int n) {
        dzfd._I().__ag()._a(cezg2, n);
    }

    public void sendToChunk(ozlu ozlu2, int n, int n2) {
        PacketCustom.sendToChunk(this.toPacket(), ozlu2, n, n2);
    }

    public static void sendToChunk(cezg cezg2, ozlu ozlu2, int n, int n2) {
        cwer cwer2 = ((yfgy)ozlu2).func_73040_p()._a(n, n2, false);
        if (cwer2 != null) {
            cwer2._a(cezg2);
        }
    }

    public void sendToOps() {
        PacketCustom.sendToOps(this.toPacket());
    }

    public static void sendToOps(cezg cezg2) {
        for (EntityPlayerMP entityPlayerMP : dzfd._I().__ag()._e) {
            if (!dzfd._I().__ag()._g(entityPlayerMP.field_71092_bJ)) continue;
            PacketCustom.sendToPlayer(cezg2, entityPlayerMP);
        }
    }

    @SideOnly(value=Side.CLIENT)
    public void sendToServer() {
        PacketCustom.sendToServer(this.toPacket());
    }

    @SideOnly(value=Side.CLIENT)
    public static void sendToServer(cezg cezg2) {
        xpzm._E()._z()._b(cezg2);
    }

    public static class Packet131Carrier
    implements IPacketCarrier {
        @Override
        public int readType(cezg cezg2) {
            return ((yexp)cezg2)._b & 0xFF;
        }

        @Override
        public byte[] readData(cezg cezg2) {
            return ((yexp)cezg2)._c;
        }

        @Override
        public Object readChannel(cezg cezg2) {
            return ((yexp)cezg2)._a;
        }

        @Override
        public cezg write(Object object, boolean bl, int n, byte[] byArray) {
            NetworkModHandler networkModHandler = FMLNetworkHandler.instance().findNetworkModHandler(object);
            yexp yexp2 = new yexp((short)networkModHandler.getNetworkId(), (short)n, byArray);
            yexp2.field_73287_r = bl;
            return yexp2;
        }

        @Override
        public boolean shortCapped() {
            return true;
        }
    }

    public static class Packet250Carrier
    implements IPacketCarrier {
        @Override
        public int readType(cezg cezg2) {
            return ((jjqf)cezg2).field_73629_c[0] & 0xFF;
        }

        @Override
        public byte[] readData(cezg cezg2) {
            byte[] byArray = ((jjqf)cezg2).field_73629_c;
            return Arrays.copyOfRange(byArray, 1, byArray.length);
        }

        @Override
        public Object readChannel(cezg cezg2) {
            return ((jjqf)cezg2).field_73630_a;
        }

        @Override
        public cezg write(Object object, boolean bl, int n, byte[] byArray) {
            byte[] byArray2 = new byte[byArray.length + 1];
            byArray2[0] = (byte)n;
            System.arraycopy(byArray, 0, byArray2, 1, byArray.length);
            jjqf jjqf2 = new jjqf();
            jjqf2.field_73630_a = (String)object;
            jjqf2.field_73287_r = bl;
            jjqf2.field_73629_c = byArray2;
            jjqf2.field_73628_b = jjqf2.field_73629_c.length;
            return jjqf2;
        }

        @Override
        public boolean shortCapped() {
            return true;
        }
    }

    public static interface IPacketCarrier {
        public int readType(cezg var1);

        public byte[] readData(cezg var1);

        public Object readChannel(cezg var1);

        public cezg write(Object var1, boolean var2, int var3, byte[] var4);

        public boolean shortCapped();
    }

    private static class NetClientHandlerHelper
    implements IConnectionHandler {
        private static boolean registered = false;
        public static bscn handler;

        private NetClientHandlerHelper() {
        }

        public static void register() {
            if (registered) {
                return;
            }
            NetworkRegistry.instance().registerConnectionHandler(new NetClientHandlerHelper());
            registered = true;
        }

        @Override
        public void connectionOpened(elai elai2, dzfd dzfd2, jjpj jjpj2) {
            handler = (bscn)elai2;
        }

        @Override
        public void connectionOpened(elai elai2, String string, int n, jjpj jjpj2) {
            handler = (bscn)elai2;
        }

        @Override
        public void connectionClosed(jjpj jjpj2) {
        }

        @Override
        public String connectionReceived(yezc yezc2, jjpj jjpj2) {
            return null;
        }

        @Override
        public void clientLoggedIn(elai elai2, jjpj jjpj2, txpf txpf2) {
        }

        @Override
        public void playerLoggedIn(Player player, elai elai2, jjpj jjpj2) {
        }
    }

    public static final class CustomTinyPacketHandler
    implements ITinyPacketHandler {
        private ClientTinyPacketHandler clientDelegate;
        private ServerTinyPacketHandler serverDelegate;

        @Override
        public void handle(elai elai2, yexp yexp2) {
            PacketCustom packetCustom = assembler.assemble(carrier131, yexp2);
            if (packetCustom == null) {
                return;
            }
            if (elai2 instanceof xbvu) {
                this.serverDelegate.handle(packetCustom, elai2);
            } else {
                this.clientDelegate.handle(packetCustom, elai2);
            }
        }

        private void registerSidedHandler(ICustomPacketHandler iCustomPacketHandler) {
            if (iCustomPacketHandler instanceof IClientPacketHandler) {
                if (this.clientDelegate != null) {
                    throw new IllegalStateException("Client handler already registered");
                }
                this.clientDelegate = new ClientTinyPacketHandler((IClientPacketHandler)iCustomPacketHandler);
            } else if (iCustomPacketHandler instanceof IServerPacketHandler) {
                if (this.serverDelegate != null) {
                    throw new IllegalStateException("Server handler already registered");
                }
                this.serverDelegate = new ServerTinyPacketHandler((IServerPacketHandler)iCustomPacketHandler);
            } else {
                throw new IllegalStateException("Handler is not a client or server handler");
            }
        }
    }

    private static class ClientTinyPacketHandler {
        IClientPacketHandler clientHandler;

        public ClientTinyPacketHandler(IClientPacketHandler iClientPacketHandler) {
            this.clientHandler = iClientPacketHandler;
        }

        public void handle(PacketCustom packetCustom, elai elai2) {
            this.clientHandler.handlePacket(packetCustom, (bscn)elai2, xpzm._E());
        }
    }

    private static class ServerTinyPacketHandler {
        IServerPacketHandler serverHandler;

        public ServerTinyPacketHandler(IServerPacketHandler iServerPacketHandler) {
            this.serverHandler = iServerPacketHandler;
        }

        public void handle(PacketCustom packetCustom, elai elai2) {
            this.serverHandler.handlePacket(packetCustom, (xbvu)elai2, ((xbvu)elai2).field_72574_e);
        }
    }

    private static class ServerPacketHandler
    extends CustomPacketHandler {
        public ServerPacketHandler(String string) {
            super(string);
        }

        @Override
        public Side getSide() {
            return Side.SERVER;
        }

        @Override
        public void handle(ICustomPacketHandler iCustomPacketHandler, PacketCustom packetCustom, Player player) {
            ((IServerPacketHandler)iCustomPacketHandler).handlePacket(packetCustom, ((EntityPlayerMP)player).field_71135_a, (EntityPlayerMP)player);
        }
    }

    private static class ClientPacketHandler
    extends CustomPacketHandler {
        public ClientPacketHandler(String string) {
            super(string);
            NetClientHandlerHelper.register();
        }

        @Override
        public Side getSide() {
            return Side.CLIENT;
        }

        @Override
        public void handle(ICustomPacketHandler iCustomPacketHandler, PacketCustom packetCustom, Player player) {
            ((IClientPacketHandler)iCustomPacketHandler).handlePacket(packetCustom, NetClientHandlerHelper.handler, xpzm._E());
        }
    }

    private static abstract class CustomPacketHandler
    implements IPacketHandler {
        HashMap<Integer, ICustomPacketHandler> handlermap = new HashMap();

        public CustomPacketHandler(String string) {
            NetworkRegistry.instance().registerChannel(this, string, this.getSide());
        }

        @Override
        public void onPacketData(jjpj jjpj2, jjqf jjqf2, Player player) {
            PacketCustom packetCustom = assembler.assemble(carrier250, jjqf2);
            if (packetCustom == null) {
                return;
            }
            ICustomPacketHandler iCustomPacketHandler = this.handlermap.get(packetCustom.getType());
            if (iCustomPacketHandler != null) {
                this.handle(iCustomPacketHandler, packetCustom, player);
            }
        }

        public void registerRange(int n, int n2, ICustomPacketHandler iCustomPacketHandler) {
            for (int i = n; i <= n2; ++i) {
                this.handlermap.put(i, iCustomPacketHandler);
            }
        }

        public abstract Side getSide();

        public abstract void handle(ICustomPacketHandler var1, PacketCustom var2, Player var3);
    }

    public static class PacketAssembler {
        public HashMap<Integer, AssemblyEntry> assemblerMap = new HashMap();

        public PacketCustom assemble(IPacketCarrier iPacketCarrier, cezg cezg2) {
            int n = iPacketCarrier.readType(cezg2);
            if (n != 128) {
                return new PacketCustom(iPacketCarrier.readChannel(cezg2), iPacketCarrier.readType(cezg2), iPacketCarrier.readData(cezg2));
            }
            byte[] byArray = iPacketCarrier.readData(cezg2);
            int n2 = PacketCustom.readInt(byArray, 0);
            AssemblyEntry assemblyEntry = this.assemblerMap.get(n2);
            if (assemblyEntry == null) {
                assemblyEntry = new AssemblyEntry(iPacketCarrier.readChannel(cezg2), byArray[4] & 0xFF, PacketCustom.readInt(byArray, 5));
                this.assemblerMap.put(n2, assemblyEntry);
                return null;
            }
            assemblyEntry.append(byArray, 4, byArray.length - 4);
            PacketCustom packetCustom = assemblyEntry.finished();
            if (packetCustom != null) {
                this.assemblerMap.remove(n2);
            }
            return packetCustom;
        }

        public class AssemblyEntry {
            Object channel;
            int type;
            int pos;
            byte[] data;

            public AssemblyEntry(Object object, int n, int n2) {
                this.channel = object;
                this.type = n;
                this.data = new byte[n2];
            }

            public void append(byte[] byArray, int n, int n2) {
                System.arraycopy(byArray, n, this.data, this.pos, n2);
                this.pos += n2;
            }

            public PacketCustom finished() {
                if (this.pos < this.data.length) {
                    return null;
                }
                return new PacketCustom(this.channel, this.type, this.data);
            }
        }
    }

    public static interface IServerPacketHandler
    extends ICustomPacketHandler {
        public void handlePacket(PacketCustom var1, xbvu var2, EntityPlayerMP var3);
    }

    public static interface IClientPacketHandler
    extends ICustomPacketHandler {
        public void handlePacket(PacketCustom var1, bscn var2, xpzm var3);
    }

    public static interface ICustomPacketHandler {
    }
}

