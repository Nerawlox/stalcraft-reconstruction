/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.physics.core.client.world;

import com.bulletphysics.collision.shapes.BvhTriangleMeshShape;
import com.bulletphysics.collision.shapes.TriangleIndexVertexArray;
import gloomyfolken.mods.physics.core.client.utils.DynamicByteBuffer;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.material.Material;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\nH\u0002J@\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2={"Lgloomyfolken/mods/physics/core/client/world/TerrainMeshBuilder;", "", "()V", "centerX", "", "centerY", "centerZ", "indices", "Lgloomyfolken/mods/physics/core/client/utils/DynamicByteBuffer;", "infiniteAABB", "Lnet/minecraft/util/AxisAlignedBB;", "kotlin.jvm.PlatformType", "vertices", "addAABB", "", "aabb", "buildBlocksRange", "Lcom/bulletphysics/collision/shapes/BvhTriangleMeshShape;", "world", "Lnet/minecraft/world/World;", "rangeX", "rangeY", "rangeZ", "minecraft"})
public final class TerrainMeshBuilder {
    private static final AxisAlignedBB infiniteAABB;
    private static int centerX;
    private static int centerY;
    private static int centerZ;
    private static DynamicByteBuffer indices;
    private static DynamicByteBuffer vertices;
    public static final TerrainMeshBuilder INSTANCE;

    @Nullable
    public final BvhTriangleMeshShape buildBlocksRange(@NotNull World world, int n, int n2, int n3, int n4, int n5, int n6) {
        Intrinsics.checkParameterIsNotNull(world, "world");
        centerX = n;
        centerY = n2;
        centerZ = n3;
        indices = new DynamicByteBuffer(false, 2048);
        vertices = new DynamicByteBuffer(false, 1024);
        ArrayList arrayList = new ArrayList();
        int n7 = centerX - n4;
        int n8 = centerX + n4;
        if (n7 <= n8) {
            while (true) {
                int n9;
                int n10;
                if ((n10 = centerY - n5) <= (n9 = centerY + n5)) {
                    while (true) {
                        int n11;
                        int n12;
                        if ((n12 = centerZ - n6) <= (n11 = centerZ + n6)) {
                            while (true) {
                                Block block;
                                if ((block = Block.blocksList[world.getBlockId(n7, n10, n12)]) != null && Intrinsics.areEqual(block.blockMaterial, Material._j) ^ true && block.blockID > 0 && !(block instanceof BlockDoor)) {
                                    block.addCollisionBoxesToList(world, n7, n10, n12, infiniteAABB, arrayList, null);
                                    Iterator iterator2 = arrayList.iterator();
                                    while (iterator2.hasNext()) {
                                        AxisAlignedBB axisAlignedBB;
                                        AxisAlignedBB axisAlignedBB2 = axisAlignedBB = (AxisAlignedBB)iterator2.next();
                                        Intrinsics.checkExpressionValueIsNotNull(axisAlignedBB2, "aabb");
                                        this.addAABB(axisAlignedBB2);
                                    }
                                    arrayList.clear();
                                }
                                if (n12 == n11) break;
                                ++n12;
                            }
                        }
                        if (n10 == n9) break;
                        ++n10;
                    }
                }
                if (n7 == n8) break;
                ++n7;
            }
        }
        DynamicByteBuffer dynamicByteBuffer = indices;
        if (dynamicByteBuffer == null) {
            Intrinsics.throwNpe();
        }
        n7 = dynamicByteBuffer.position() / 12;
        DynamicByteBuffer dynamicByteBuffer2 = vertices;
        if (dynamicByteBuffer2 == null) {
            Intrinsics.throwNpe();
        }
        n8 = dynamicByteBuffer2.position() / 3;
        DynamicByteBuffer dynamicByteBuffer3 = indices;
        if (dynamicByteBuffer3 == null) {
            Intrinsics.throwNpe();
        }
        ByteBuffer byteBuffer = dynamicByteBuffer3.getBuf();
        if (byteBuffer == null) {
            Intrinsics.throwNpe();
        }
        ByteBuffer byteBuffer2 = byteBuffer;
        DynamicByteBuffer dynamicByteBuffer4 = vertices;
        if (dynamicByteBuffer4 == null) {
            Intrinsics.throwNpe();
        }
        ByteBuffer byteBuffer3 = dynamicByteBuffer4.getBuf();
        if (byteBuffer3 == null) {
            Intrinsics.throwNpe();
        }
        ByteBuffer byteBuffer4 = byteBuffer3;
        byteBuffer2.flip();
        byteBuffer4.flip();
        TriangleIndexVertexArray triangleIndexVertexArray = new TriangleIndexVertexArray(n7, byteBuffer2, 12, n8, byteBuffer4, 12);
        indices = null;
        vertices = null;
        if (n7 == 0) {
            return null;
        }
        return new BvhTriangleMeshShape(triangleIndexVertexArray, true);
    }

    private final void addAABB(AxisAlignedBB axisAlignedBB) {
        DynamicByteBuffer dynamicByteBuffer = vertices;
        if (dynamicByteBuffer == null) {
            Intrinsics.throwNpe();
        }
        int n = dynamicByteBuffer.position() / 12;
        AxisAlignedBB axisAlignedBB2 = axisAlignedBB._e(0.1, 0.1, 0.1);
        DynamicByteBuffer dynamicByteBuffer2 = vertices;
        if (dynamicByteBuffer2 == null) {
            Intrinsics.throwNpe();
        }
        dynamicByteBuffer2.putFloat((float)(axisAlignedBB2._b - (double)centerX));
        DynamicByteBuffer dynamicByteBuffer3 = vertices;
        if (dynamicByteBuffer3 == null) {
            Intrinsics.throwNpe();
        }
        dynamicByteBuffer3.putFloat((float)(axisAlignedBB2._c - (double)centerY));
        DynamicByteBuffer dynamicByteBuffer4 = vertices;
        if (dynamicByteBuffer4 == null) {
            Intrinsics.throwNpe();
        }
        dynamicByteBuffer4.putFloat((float)(axisAlignedBB2._d - (double)centerZ));
        DynamicByteBuffer dynamicByteBuffer5 = vertices;
        if (dynamicByteBuffer5 == null) {
            Intrinsics.throwNpe();
        }
        dynamicByteBuffer5.putFloat((float)(axisAlignedBB2._b - (double)centerX));
        DynamicByteBuffer dynamicByteBuffer6 = vertices;
        if (dynamicByteBuffer6 == null) {
            Intrinsics.throwNpe();
        }
        dynamicByteBuffer6.putFloat((float)(axisAlignedBB2._c - (double)centerY));
        DynamicByteBuffer dynamicByteBuffer7 = vertices;
        if (dynamicByteBuffer7 == null) {
            Intrinsics.throwNpe();
        }
        dynamicByteBuffer7.putFloat((float)(axisAlignedBB2._g - (double)centerZ));
        DynamicByteBuffer dynamicByteBuffer8 = vertices;
        if (dynamicByteBuffer8 == null) {
            Intrinsics.throwNpe();
        }
        dynamicByteBuffer8.putFloat((float)(axisAlignedBB2._b - (double)centerX));
        DynamicByteBuffer dynamicByteBuffer9 = vertices;
        if (dynamicByteBuffer9 == null) {
            Intrinsics.throwNpe();
        }
        dynamicByteBuffer9.putFloat((float)(axisAlignedBB2._f - (double)centerY));
        DynamicByteBuffer dynamicByteBuffer10 = vertices;
        if (dynamicByteBuffer10 == null) {
            Intrinsics.throwNpe();
        }
        dynamicByteBuffer10.putFloat((float)(axisAlignedBB2._d - (double)centerZ));
        DynamicByteBuffer dynamicByteBuffer11 = vertices;
        if (dynamicByteBuffer11 == null) {
            Intrinsics.throwNpe();
        }
        dynamicByteBuffer11.putFloat((float)(axisAlignedBB2._b - (double)centerX));
        DynamicByteBuffer dynamicByteBuffer12 = vertices;
        if (dynamicByteBuffer12 == null) {
            Intrinsics.throwNpe();
        }
        dynamicByteBuffer12.putFloat((float)(axisAlignedBB2._f - (double)centerY));
        DynamicByteBuffer dynamicByteBuffer13 = vertices;
        if (dynamicByteBuffer13 == null) {
            Intrinsics.throwNpe();
        }
        dynamicByteBuffer13.putFloat((float)(axisAlignedBB2._g - (double)centerZ));
        DynamicByteBuffer dynamicByteBuffer14 = vertices;
        if (dynamicByteBuffer14 == null) {
            Intrinsics.throwNpe();
        }
        dynamicByteBuffer14.putFloat((float)(axisAlignedBB2._e - (double)centerX));
        DynamicByteBuffer dynamicByteBuffer15 = vertices;
        if (dynamicByteBuffer15 == null) {
            Intrinsics.throwNpe();
        }
        dynamicByteBuffer15.putFloat((float)(axisAlignedBB2._c - (double)centerY));
        DynamicByteBuffer dynamicByteBuffer16 = vertices;
        if (dynamicByteBuffer16 == null) {
            Intrinsics.throwNpe();
        }
        dynamicByteBuffer16.putFloat((float)(axisAlignedBB2._d - (double)centerZ));
        DynamicByteBuffer dynamicByteBuffer17 = vertices;
        if (dynamicByteBuffer17 == null) {
            Intrinsics.throwNpe();
        }
        dynamicByteBuffer17.putFloat((float)(axisAlignedBB2._e - (double)centerX));
        DynamicByteBuffer dynamicByteBuffer18 = vertices;
        if (dynamicByteBuffer18 == null) {
            Intrinsics.throwNpe();
        }
        dynamicByteBuffer18.putFloat((float)(axisAlignedBB2._c - (double)centerY));
        DynamicByteBuffer dynamicByteBuffer19 = vertices;
        if (dynamicByteBuffer19 == null) {
            Intrinsics.throwNpe();
        }
        dynamicByteBuffer19.putFloat((float)(axisAlignedBB2._g - (double)centerZ));
        DynamicByteBuffer dynamicByteBuffer20 = vertices;
        if (dynamicByteBuffer20 == null) {
            Intrinsics.throwNpe();
        }
        dynamicByteBuffer20.putFloat((float)(axisAlignedBB2._e - (double)centerX));
        DynamicByteBuffer dynamicByteBuffer21 = vertices;
        if (dynamicByteBuffer21 == null) {
            Intrinsics.throwNpe();
        }
        dynamicByteBuffer21.putFloat((float)(axisAlignedBB2._f - (double)centerY));
        DynamicByteBuffer dynamicByteBuffer22 = vertices;
        if (dynamicByteBuffer22 == null) {
            Intrinsics.throwNpe();
        }
        dynamicByteBuffer22.putFloat((float)(axisAlignedBB2._d - (double)centerZ));
        DynamicByteBuffer dynamicByteBuffer23 = vertices;
        if (dynamicByteBuffer23 == null) {
            Intrinsics.throwNpe();
        }
        dynamicByteBuffer23.putFloat((float)(axisAlignedBB2._e - (double)centerX));
        DynamicByteBuffer dynamicByteBuffer24 = vertices;
        if (dynamicByteBuffer24 == null) {
            Intrinsics.throwNpe();
        }
        dynamicByteBuffer24.putFloat((float)(axisAlignedBB2._f - (double)centerY));
        DynamicByteBuffer dynamicByteBuffer25 = vertices;
        if (dynamicByteBuffer25 == null) {
            Intrinsics.throwNpe();
        }
        dynamicByteBuffer25.putFloat((float)(axisAlignedBB2._g - (double)centerZ));
        DynamicByteBuffer dynamicByteBuffer26 = indices;
        if (dynamicByteBuffer26 == null) {
            Intrinsics.throwNpe();
        }
        dynamicByteBuffer26.putInt(n + 0);
        DynamicByteBuffer dynamicByteBuffer27 = indices;
        if (dynamicByteBuffer27 == null) {
            Intrinsics.throwNpe();
        }
        dynamicByteBuffer27.putInt(n + 1);
        DynamicByteBuffer dynamicByteBuffer28 = indices;
        if (dynamicByteBuffer28 == null) {
            Intrinsics.throwNpe();
        }
        dynamicByteBuffer28.putInt(n + 2);
        DynamicByteBuffer dynamicByteBuffer29 = indices;
        if (dynamicByteBuffer29 == null) {
            Intrinsics.throwNpe();
        }
        dynamicByteBuffer29.putInt(n + 3);
        DynamicByteBuffer dynamicByteBuffer30 = indices;
        if (dynamicByteBuffer30 == null) {
            Intrinsics.throwNpe();
        }
        dynamicByteBuffer30.putInt(n + 1);
        DynamicByteBuffer dynamicByteBuffer31 = indices;
        if (dynamicByteBuffer31 == null) {
            Intrinsics.throwNpe();
        }
        dynamicByteBuffer31.putInt(n + 2);
        DynamicByteBuffer dynamicByteBuffer32 = indices;
        if (dynamicByteBuffer32 == null) {
            Intrinsics.throwNpe();
        }
        dynamicByteBuffer32.putInt(n + 4);
        DynamicByteBuffer dynamicByteBuffer33 = indices;
        if (dynamicByteBuffer33 == null) {
            Intrinsics.throwNpe();
        }
        dynamicByteBuffer33.putInt(n + 5);
        DynamicByteBuffer dynamicByteBuffer34 = indices;
        if (dynamicByteBuffer34 == null) {
            Intrinsics.throwNpe();
        }
        dynamicByteBuffer34.putInt(n + 6);
        DynamicByteBuffer dynamicByteBuffer35 = indices;
        if (dynamicByteBuffer35 == null) {
            Intrinsics.throwNpe();
        }
        dynamicByteBuffer35.putInt(n + 7);
        DynamicByteBuffer dynamicByteBuffer36 = indices;
        if (dynamicByteBuffer36 == null) {
            Intrinsics.throwNpe();
        }
        dynamicByteBuffer36.putInt(n + 5);
        DynamicByteBuffer dynamicByteBuffer37 = indices;
        if (dynamicByteBuffer37 == null) {
            Intrinsics.throwNpe();
        }
        dynamicByteBuffer37.putInt(n + 6);
        DynamicByteBuffer dynamicByteBuffer38 = indices;
        if (dynamicByteBuffer38 == null) {
            Intrinsics.throwNpe();
        }
        dynamicByteBuffer38.putInt(n + 1);
        DynamicByteBuffer dynamicByteBuffer39 = indices;
        if (dynamicByteBuffer39 == null) {
            Intrinsics.throwNpe();
        }
        dynamicByteBuffer39.putInt(n + 5);
        DynamicByteBuffer dynamicByteBuffer40 = indices;
        if (dynamicByteBuffer40 == null) {
            Intrinsics.throwNpe();
        }
        dynamicByteBuffer40.putInt(n + 0);
        DynamicByteBuffer dynamicByteBuffer41 = indices;
        if (dynamicByteBuffer41 == null) {
            Intrinsics.throwNpe();
        }
        dynamicByteBuffer41.putInt(n + 4);
        DynamicByteBuffer dynamicByteBuffer42 = indices;
        if (dynamicByteBuffer42 == null) {
            Intrinsics.throwNpe();
        }
        dynamicByteBuffer42.putInt(n + 5);
        DynamicByteBuffer dynamicByteBuffer43 = indices;
        if (dynamicByteBuffer43 == null) {
            Intrinsics.throwNpe();
        }
        dynamicByteBuffer43.putInt(n + 0);
        DynamicByteBuffer dynamicByteBuffer44 = indices;
        if (dynamicByteBuffer44 == null) {
            Intrinsics.throwNpe();
        }
        dynamicByteBuffer44.putInt(n + 3);
        DynamicByteBuffer dynamicByteBuffer45 = indices;
        if (dynamicByteBuffer45 == null) {
            Intrinsics.throwNpe();
        }
        dynamicByteBuffer45.putInt(n + 7);
        DynamicByteBuffer dynamicByteBuffer46 = indices;
        if (dynamicByteBuffer46 == null) {
            Intrinsics.throwNpe();
        }
        dynamicByteBuffer46.putInt(n + 2);
        DynamicByteBuffer dynamicByteBuffer47 = indices;
        if (dynamicByteBuffer47 == null) {
            Intrinsics.throwNpe();
        }
        dynamicByteBuffer47.putInt(n + 6);
        DynamicByteBuffer dynamicByteBuffer48 = indices;
        if (dynamicByteBuffer48 == null) {
            Intrinsics.throwNpe();
        }
        dynamicByteBuffer48.putInt(n + 7);
        DynamicByteBuffer dynamicByteBuffer49 = indices;
        if (dynamicByteBuffer49 == null) {
            Intrinsics.throwNpe();
        }
        dynamicByteBuffer49.putInt(n + 2);
        DynamicByteBuffer dynamicByteBuffer50 = indices;
        if (dynamicByteBuffer50 == null) {
            Intrinsics.throwNpe();
        }
        dynamicByteBuffer50.putInt(n + 4);
        DynamicByteBuffer dynamicByteBuffer51 = indices;
        if (dynamicByteBuffer51 == null) {
            Intrinsics.throwNpe();
        }
        dynamicByteBuffer51.putInt(n + 0);
        DynamicByteBuffer dynamicByteBuffer52 = indices;
        if (dynamicByteBuffer52 == null) {
            Intrinsics.throwNpe();
        }
        dynamicByteBuffer52.putInt(n + 6);
        DynamicByteBuffer dynamicByteBuffer53 = indices;
        if (dynamicByteBuffer53 == null) {
            Intrinsics.throwNpe();
        }
        dynamicByteBuffer53.putInt(n + 2);
        DynamicByteBuffer dynamicByteBuffer54 = indices;
        if (dynamicByteBuffer54 == null) {
            Intrinsics.throwNpe();
        }
        dynamicByteBuffer54.putInt(n + 0);
        DynamicByteBuffer dynamicByteBuffer55 = indices;
        if (dynamicByteBuffer55 == null) {
            Intrinsics.throwNpe();
        }
        dynamicByteBuffer55.putInt(n + 6);
        DynamicByteBuffer dynamicByteBuffer56 = indices;
        if (dynamicByteBuffer56 == null) {
            Intrinsics.throwNpe();
        }
        dynamicByteBuffer56.putInt(n + 5);
        DynamicByteBuffer dynamicByteBuffer57 = indices;
        if (dynamicByteBuffer57 == null) {
            Intrinsics.throwNpe();
        }
        dynamicByteBuffer57.putInt(n + 1);
        DynamicByteBuffer dynamicByteBuffer58 = indices;
        if (dynamicByteBuffer58 == null) {
            Intrinsics.throwNpe();
        }
        dynamicByteBuffer58.putInt(n + 7);
        DynamicByteBuffer dynamicByteBuffer59 = indices;
        if (dynamicByteBuffer59 == null) {
            Intrinsics.throwNpe();
        }
        dynamicByteBuffer59.putInt(n + 3);
        DynamicByteBuffer dynamicByteBuffer60 = indices;
        if (dynamicByteBuffer60 == null) {
            Intrinsics.throwNpe();
        }
        dynamicByteBuffer60.putInt(n + 1);
        DynamicByteBuffer dynamicByteBuffer61 = indices;
        if (dynamicByteBuffer61 == null) {
            Intrinsics.throwNpe();
        }
        dynamicByteBuffer61.putInt(n + 7);
    }

    private TerrainMeshBuilder() {
        INSTANCE = this;
        infiniteAABB = AxisAlignedBB._a(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
    }

    static {
        new TerrainMeshBuilder();
    }
}

