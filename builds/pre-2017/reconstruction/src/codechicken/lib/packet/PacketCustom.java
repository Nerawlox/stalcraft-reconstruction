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
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetServerHandler;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
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

    public Packet toPacket() {
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
            MetaPacket metaPacket = new MetaPacket(new Packet[0]);
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
    public PacketCustom writeItemStack(ItemStack itemStack) {
        this.writeItemStack(itemStack, false);
        return this;
    }

    public PacketCustom writeItemStack(ItemStack itemStack, boolean bl) {
        bl = true;
        if (itemStack == null) {
            this.writeShort(-1);
        } else {
            this.writeShort(itemStack._d);
            if (bl) {
                this.writeInt(itemStack._b);
            } else {
                this.writeByte(itemStack._b);
            }
            this.writeShort(itemStack._j());
            this.writeNBTTagCompound(itemStack._e);
        }
        return this;
    }

    @Override
    public PacketCustom writeNBTTagCompound(NBTTagCompound nBTTagCompound) {
        try {
            if (nBTTagCompound == null) {
                this.writeShort(-1);
            } else {
                byte[] byArray = bsvf._a(nBTTagCompound);
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
    public ItemStack readItemStack() {
        return this.readItemStack(false);
    }

    public ItemStack readItemStack(boolean bl) {
        bl = true;
        ItemStack itemStack = null;
        short s = this.readShort();
        if (s >= 0) {
            int n = bl ? this.readInt() : (int)this.readByte();
            short s2 = this.readShort();
            itemStack = new ItemStack(s, n, (int)s2);
            itemStack._e = this.readNBTTagCompound();
        }
        return itemStack;
    }

    @Override
    public NBTTagCompound readNBTTagCompound() {
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

    public static void sendToPlayer(Packet packet, EntityPlayer entityPlayer) {
        if (entityPlayer == null) {
            PacketCustom.sendToClients(packet);
        } else {
            ((EntityPlayerMP)entityPlayer).playerNetServerHandler.func_72567_b(packet);
        }
    }

    public void sendToClients() {
        PacketCustom.sendToClients(this.toPacket());
    }

    public static void sendToClients(Packet packet) {
        MinecraftServer._I().__ag()._a(packet);
    }

    public void sendPacketToAllAround(double d, double d2, double d3, double d4, int n) {
        PacketCustom.sendToAllAround(this.toPacket(), d, d2, d3, d4, n);
    }

    public static void sendToAllAround(Packet packet, double d, double d2, double d3, double d4, int n) {
        MinecraftServer._I().__ag()._a(d, d2, d3, d4, n, packet);
    }

    public void sendToDimension(int n) {
        PacketCustom.sendToDimension(this.toPacket(), n);
    }

    public static void sendToDimension(Packet packet, int n) {
        MinecraftServer._I().__ag()._a(packet, n);
    }

    public void sendToChunk(World world, int n, int n2) {
        PacketCustom.sendToChunk(this.toPacket(), world, n, n2);
    }

    public static void sendToChunk(Packet packet, World world, int n, int n2) {
        cwer cwer2 = ((WorldServer)world).getPlayerManager()._a(n, n2, false);
        if (cwer2 != null) {
            cwer2._a(packet);
        }
    }

    public void sendToOps() {
        PacketCustom.sendToOps(this.toPacket());
    }

    public static void sendToOps(Packet packet) {
        for (EntityPlayerMP entityPlayerMP : MinecraftServer._I().__ag()._e) {
            if (!MinecraftServer._I().__ag()._g(entityPlayerMP.username)) continue;
            PacketCustom.sendToPlayer(packet, entityPlayerMP);
        }
    }

    @SideOnly(value=Side.CLIENT)
    public void sendToServer() {
        PacketCustom.sendToServer(this.toPacket());
    }

    @SideOnly(value=Side.CLIENT)
    public static void sendToServer(Packet packet) {
        Minecraft._E()._z()._b(packet);
    }

    public static class Packet131Carrier
    implements IPacketCarrier {
        @Override
        public int readType(Packet packet) {
            return ((yexp)packet)._b & 0xFF;
        }

        @Override
        public byte[] readData(Packet packet) {
            return ((yexp)packet)._c;
        }

        @Override
        public Object readChannel(Packet packet) {
            return ((yexp)packet)._a;
        }

        @Override
        public Packet write(Object object, boolean bl, int n, byte[] byArray) {
            NetworkModHandler networkModHandler = FMLNetworkHandler.instance().findNetworkModHandler(object);
            yexp yexp2 = new yexp((short)networkModHandler.getNetworkId(), (short)n, byArray);
            yexp2.isChunkDataPacket = bl;
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
        public int readType(Packet packet) {
            return ((Packet250CustomPayload)packet).data[0] & 0xFF;
        }

        @Override
        public byte[] readData(Packet packet) {
            byte[] byArray = ((Packet250CustomPayload)packet).data;
            return Arrays.copyOfRange(byArray, 1, byArray.length);
        }

        @Override
        public Object readChannel(Packet packet) {
            return ((Packet250CustomPayload)packet).channel;
        }

        @Override
        public Packet write(Object object, boolean bl, int n, byte[] byArray) {
            byte[] byArray2 = new byte[byArray.length + 1];
            byArray2[0] = (byte)n;
            System.arraycopy(byArray, 0, byArray2, 1, byArray.length);
            Packet250CustomPayload packet250CustomPayload = new Packet250CustomPayload();
            packet250CustomPayload.channel = (String)object;
            packet250CustomPayload.isChunkDataPacket = bl;
            packet250CustomPayload.data = byArray2;
            packet250CustomPayload.length = packet250CustomPayload.data.length;
            return packet250CustomPayload;
        }

        @Override
        public boolean shortCapped() {
            return true;
        }
    }

    public static interface IPacketCarrier {
        public int readType(Packet var1);

        public byte[] readData(Packet var1);

        public Object readChannel(Packet var1);

        public Packet write(Object var1, boolean var2, int var3, byte[] var4);

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
        public void connectionOpened(NetHandler netHandler, MinecraftServer minecraftServer, jjpj jjpj2) {
            handler = (bscn)netHandler;
        }

        @Override
        public void connectionOpened(NetHandler netHandler, String string, int n, jjpj jjpj2) {
            handler = (bscn)netHandler;
        }

        @Override
        public void connectionClosed(jjpj jjpj2) {
        }

        @Override
        public String connectionReceived(yezc yezc2, jjpj jjpj2) {
            return null;
        }

        @Override
        public void clientLoggedIn(NetHandler netHandler, jjpj jjpj2, txpf txpf2) {
        }

        @Override
        public void playerLoggedIn(Player player, NetHandler netHandler, jjpj jjpj2) {
        }
    }

    public static final class CustomTinyPacketHandler
    implements ITinyPacketHandler {
        private ClientTinyPacketHandler clientDelegate;
        private ServerTinyPacketHandler serverDelegate;

        @Override
        public void handle(NetHandler netHandler, yexp yexp2) {
            PacketCustom packetCustom = assembler.assemble(carrier131, yexp2);
            if (packetCustom == null) {
                return;
            }
            if (netHandler instanceof NetServerHandler) {
                this.serverDelegate.handle(packetCustom, netHandler);
            } else {
                this.clientDelegate.handle(packetCustom, netHandler);
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

        public void handle(PacketCustom packetCustom, NetHandler netHandler) {
            this.clientHandler.handlePacket(packetCustom, (bscn)netHandler, Minecraft._E());
        }
    }

    private static class ServerTinyPacketHandler {
        IServerPacketHandler serverHandler;

        public ServerTinyPacketHandler(IServerPacketHandler iServerPacketHandler) {
            this.serverHandler = iServerPacketHandler;
        }

        public void handle(PacketCustom packetCustom, NetHandler netHandler) {
            this.serverHandler.handlePacket(packetCustom, (NetServerHandler)netHandler, ((NetServerHandler)netHandler).playerEntity);
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
            ((IServerPacketHandler)iCustomPacketHandler).handlePacket(packetCustom, ((EntityPlayerMP)player).playerNetServerHandler, (EntityPlayerMP)player);
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
            ((IClientPacketHandler)iCustomPacketHandler).handlePacket(packetCustom, NetClientHandlerHelper.handler, Minecraft._E());
        }
    }

    private static abstract class CustomPacketHandler
    implements IPacketHandler {
        HashMap<Integer, ICustomPacketHandler> handlermap = new HashMap();

        public CustomPacketHandler(String string) {
            NetworkRegistry.instance().registerChannel(this, string, this.getSide());
        }

        @Override
        public void onPacketData(jjpj jjpj2, Packet250CustomPayload packet250CustomPayload, Player player) {
            PacketCustom packetCustom = assembler.assemble(carrier250, packet250CustomPayload);
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

        public PacketCustom assemble(IPacketCarrier iPacketCarrier, Packet packet) {
            int n = iPacketCarrier.readType(packet);
            if (n != 128) {
                return new PacketCustom(iPacketCarrier.readChannel(packet), iPacketCarrier.readType(packet), iPacketCarrier.readData(packet));
            }
            byte[] byArray = iPacketCarrier.readData(packet);
            int n2 = PacketCustom.readInt(byArray, 0);
            AssemblyEntry assemblyEntry = this.assemblerMap.get(n2);
            if (assemblyEntry == null) {
                assemblyEntry = new AssemblyEntry(iPacketCarrier.readChannel(packet), byArray[4] & 0xFF, PacketCustom.readInt(byArray, 5));
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
        public void handlePacket(PacketCustom var1, NetServerHandler var2, EntityPlayerMP var3);
    }

    public static interface IClientPacketHandler
    extends ICustomPacketHandler {
        public void handlePacket(PacketCustom var1, bscn var2, Minecraft var3);
    }

    public static interface ICustomPacketHandler {
    }
}

