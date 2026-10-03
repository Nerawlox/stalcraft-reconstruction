/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.mobs.entity;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import cpw.mods.fml.common.registry.IEntityAdditionalSpawnData;
import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.asm.Logger;
import gloomyfolken.mods.core.misc.jxtc;
import gloomyfolken.mods.ktcore.McExtensionsKt;
import gloomyfolken.mods.stalker.mobs.client.render.MutantAnimationHandler;
import gloomyfolken.mods.stalker.mobs.entity.DamageSourceMutant;
import gloomyfolken.mods.stalker.mobs.entity.EntityMutant;
import gloomyfolken.mods.stalker.mobs.entity.HomeInfo;
import gloomyfolken.mods.stalker.mobs.entity.MoveTurnDirection;
import gloomyfolken.mods.stalker.mobs.entity.MutantSkin;
import gloomyfolken.mods.stalker.mobs.entity.animation.AnimationProperty;
import gloomyfolken.mods.stalker.mobs.entity.animation.AnimationType;
import gloomyfolken.mods.stalker.mobs.entity.animation.state.AnimationState;
import gloomyfolken.mods.stalker.mobs.entity.animation.state.CustomAnimationState;
import gloomyfolken.mods.stalker.mobs.entity.animation.state.LogicState;
import gloomyfolken.mods.stalker.mobs.entity.config.MutantBaseConfig;
import gloomyfolken.mods.stalker.mobs.entity.config.MutantConfigHelper;
import gloomyfolken.mods.stalker.mobs.entity.config.MutantConfiguration;
import gloomyfolken.mods.stalker.mobs.entity.config.MutantSoundType;
import gloomyfolken.mods.stalker.mobs.entity.pathfind.PathHelper;
import gloomyfolken.mods.stalker.mobs.entity.pathfind.PathfindSenses;
import gloomyfolken.mods.stalker.mobs.packet.event.PacketGenericEffectEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import net.minecraft.entity.DataWatcher;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityMoveHelper;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.sajz;
import net.minecraft.entity.zwat;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Vec3;
import net.minecraft.util.sajh;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\u00ba\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000 \u00e8\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0002\u00e8\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010x\u001a\u00020(H\u0014J\b\u0010y\u001a\u00020(H\u0014J\b\u0010z\u001a\u00020(H\u0004J\u0010\u0010{\u001a\u00020(2\u0006\u0010|\u001a\u00020}H\u0016J\u0010\u0010~\u001a\u00020U2\u0006\u0010|\u001a\u00020}H\u0016J\u001d\u0010\u007f\u001a\u00020U2\n\u0010\u0080\u0001\u001a\u0005\u0018\u00010\u0081\u00012\u0007\u0010\u0082\u0001\u001a\u00020jH\u0016J\t\u0010\u0083\u0001\u001a\u00020UH\u0014J\u0007\u0010\u0084\u0001\u001a\u00020UJ\t\u0010\u0085\u0001\u001a\u00020(H\u0007J\u0012\u0010\u0086\u0001\u001a\u000b\u0012\u0006\b\u0001\u0012\u00020\u00000\u0087\u0001H\u0017J\n\u0010\u0088\u0001\u001a\u00030\u0089\u0001H\u0015J\u001c\u0010\u008a\u0001\u001a\u00020(2\b\u0010\u0080\u0001\u001a\u00030\u0081\u00012\u0007\u0010\u0082\u0001\u001a\u00020jH\u0014J\u001c\u0010\u008b\u0001\u001a\u00020U2\u0006\u0010|\u001a\u00020}2\t\b\u0002\u0010\u008c\u0001\u001a\u00020jH\u0016J\t\u0010\u008d\u0001\u001a\u00020(H\u0014J\u0012\u0010\u008e\u0001\u001a\u00020(2\u0007\u0010\u008f\u0001\u001a\u00020jH\u0014J\u001c\u0010\u0090\u0001\u001a\u0004\u0018\u0001012\b\u0010\u0091\u0001\u001a\u00030\u0092\u00012\u0007\u0010\u0093\u0001\u001a\u00020=J%\u0010\u0090\u0001\u001a\u0004\u0018\u0001012\b\u0010\u0091\u0001\u001a\u00030\u0092\u00012\u0007\u0010\u0093\u0001\u001a\u00020=2\u0007\u0010\u0094\u0001\u001a\u00020oJ\u0012\u0010\u0090\u0001\u001a\u0004\u0018\u0001012\u0007\u0010\u0095\u0001\u001a\u00020$J\u001b\u0010\u0096\u0001\u001a\u00020j2\u0007\u0010\u008f\u0001\u001a\u00020j2\u0007\u0010\u0082\u0001\u001a\u00020jH\u0014J\t\u0010\u0097\u0001\u001a\u00020\u0010H\u0016J\n\u0010\u0098\u0001\u001a\u00030\u0089\u0001H\u0007J\b\u0010\u0099\u0001\u001a\u00030\u009a\u0001J\t\u0010\u009b\u0001\u001a\u00020UH\u0016J\t\u0010\u009c\u0001\u001a\u00020$H\u0016J\t\u0010\u009d\u0001\u001a\u00020$H&J\t\u0010\u009e\u0001\u001a\u00020$H\u0016J\u000b\u0010\u009f\u0001\u001a\u0004\u0018\u00010$H\u0016J\t\u0010\u00a0\u0001\u001a\u00020\u0010H\u0016J\n\u0010\u00a1\u0001\u001a\u00030\u00a2\u0001H\u0007J\u000e\u0010\u00a3\u0001\u001a\t\u0012\u0004\u0012\u00020\u001f0\u00a4\u0001J\t\u0010\u00a5\u0001\u001a\u00020\u001fH\u0016J\u0007\u0010\u00a6\u0001\u001a\u00020\u001fJ\u0011\u0010\u00a7\u0001\u001a\u00020$2\b\u0010\u00a8\u0001\u001a\u00030\u00a9\u0001J\u0010\u0010\u00a7\u0001\u001a\u00020$2\u0007\u0010\u0095\u0001\u001a\u00020$J\t\u0010\u00aa\u0001\u001a\u00020jH\u0014J\u0007\u0010\u00ab\u0001\u001a\u00020\u0016J\t\u0010\u00ac\u0001\u001a\u00020$H\u0016J\t\u0010\u00ad\u0001\u001a\u00020$H\u0016J\u001a\u0010\u00ae\u0001\u001a\u00020U2\b\u0010\u0091\u0001\u001a\u00030\u0092\u00012\u0007\u0010\u0093\u0001\u001a\u00020=J\u0010\u0010\u00ae\u0001\u001a\u00020U2\u0007\u0010\u0095\u0001\u001a\u00020$J\u0007\u0010\u00af\u0001\u001a\u00020UJ\u0012\u0010\u00b0\u0001\u001a\u00020(2\u0007\u0010\u008f\u0001\u001a\u00020jH\u0016J\t\u0010\u00b1\u0001\u001a\u00020(H\u0005J\t\u0010\u00b2\u0001\u001a\u00020UH\u0014J\t\u0010\u00b3\u0001\u001a\u00020UH\u0016J0\u0010\u00b4\u0001\u001a\u00020(2\b\u0010|\u001a\u0004\u0018\u00010}2\u0007\u0010\u0082\u0001\u001a\u00020j2\b\u0010\u00b5\u0001\u001a\u00030\u00b6\u00012\b\u0010\u00b7\u0001\u001a\u00030\u00b6\u0001H\u0016J\u0015\u0010\u00b8\u0001\u001a\u00020(2\n\u0010\u00b9\u0001\u001a\u0005\u0018\u00010\u00ba\u0001H\u0016J\u0013\u0010\u00bb\u0001\u001a\u00020(2\b\u0010\u00b9\u0001\u001a\u00030\u00ba\u0001H\u0016J\u0015\u0010\u00bc\u0001\u001a\u00020(2\n\u0010\u0080\u0001\u001a\u0005\u0018\u00010\u0081\u0001H\u0016J\t\u0010\u00bd\u0001\u001a\u00020(H\u0014J\t\u0010\u00be\u0001\u001a\u00020(H\u0016J\u0011\u0010\u00bf\u0001\u001a\u00020(2\b\u0010\u0091\u0001\u001a\u00030\u00a9\u0001J\u0012\u0010\u00bf\u0001\u001a\u00020(2\u0007\u0010\u0095\u0001\u001a\u00020$H\u0002J&\u0010\u00bf\u0001\u001a\u00020(2\t\u0010\u0095\u0001\u001a\u0004\u0018\u00010$2\u0007\u0010\u00c0\u0001\u001a\u00020j2\u0007\u0010\u00c1\u0001\u001a\u00020jH\u0016J\t\u0010\u00c2\u0001\u001a\u00020(H\u0017J\u0010\u0010\u00c3\u0001\u001a\u00020(2\u0007\u0010\u0095\u0001\u001a\u00020$J\t\u0010\u00c4\u0001\u001a\u00020UH\u0004J\u0014\u0010\u00c5\u0001\u001a\u00020(2\t\u0010\u00c6\u0001\u001a\u0004\u0018\u00010'H\u0016J\u0013\u0010\u00c7\u0001\u001a\u00020(2\b\u0010\u00c8\u0001\u001a\u00030\u00c9\u0001H\u0016J\u0013\u0010\u00ca\u0001\u001a\u00020(2\b\u0010\u00cb\u0001\u001a\u00030\u00cc\u0001H\u0017J\t\u0010\u00cd\u0001\u001a\u00020(H\u0015J\t\u0010\u00ce\u0001\u001a\u00020(H\u0017J\t\u0010\u00cf\u0001\u001a\u00020(H\u0017J\u0012\u0010\u00d0\u0001\u001a\u00020(2\u0007\u0010\u008f\u0001\u001a\u00020jH\u0016J\u0010\u0010\u00d1\u0001\u001a\u00020(2\u0007\u0010\u00d2\u0001\u001a\u00020\u000eJ\u001b\u0010\u00d3\u0001\u001a\u00020U2\u0007\u0010\u00d4\u0001\u001a\u0002012\t\b\u0002\u0010\u00d5\u0001\u001a\u00020UJ\t\u0010\u00d6\u0001\u001a\u00020(H\u0016J\u0010\u0010\u00d7\u0001\u001a\u00020(2\u0007\u0010\u00d8\u0001\u001a\u00020\u001fJ\u001c\u0010\u00d9\u0001\u001a\u00020U2\b\u0010\u00da\u0001\u001a\u00030\u0092\u00012\t\b\u0002\u0010\u00d5\u0001\u001a\u00020UJ:\u0010\u00d9\u0001\u001a\u00020U2\b\u0010\u0091\u0001\u001a\u00030\u0092\u00012\t\b\u0002\u0010\u00d5\u0001\u001a\u00020U2\u001c\b\u0002\u0010\u00db\u0001\u001a\u0015\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020(0\u00dc\u0001\u00a2\u0006\u0003\b\u00dd\u0001J\u0011\u0010\u00de\u0001\u001a\u00020(2\u0006\u0010\u0015\u001a\u00020\u0016H\u0007J\t\u0010\u00df\u0001\u001a\u00020(H\u0004J\t\u0010\u00e0\u0001\u001a\u00020UH\u0016J\t\u0010\u00e1\u0001\u001a\u00020UH\u0017J\t\u0010\u00e2\u0001\u001a\u00020(H\u0014J\t\u0010\u00e3\u0001\u001a\u00020(H\u0007J\t\u0010\u00e4\u0001\u001a\u00020(H\u0005J\u0013\u0010\u00e5\u0001\u001a\u00020(2\b\u0010\u00c8\u0001\u001a\u00030\u00e6\u0001H\u0016J\u0014\u0010\u00e7\u0001\u001a\u00020U2\t\u0010\u00c6\u0001\u001a\u0004\u0018\u00010'H\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u0084.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0010X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eX\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010!RT\u0010\"\u001aB\u0012\u0004\u0012\u00020$\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020(0%0#j \u0012\u0004\u0012\u00020$\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020(0%`)X\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0011\u0010,\u001a\u00020-\u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u001c\u00100\u001a\u0004\u0018\u000101X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001a\u00106\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0012\"\u0004\b8\u0010\u0014R\u001a\u00109\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u0012\"\u0004\b;\u0010\u0014R$\u0010>\u001a\u00020=2\u0006\u0010<\u001a\u00020=@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u001a\u0010C\u001a\u00020DX\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u001a\u0010I\u001a\u00020\u001fX\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR!\u0010N\u001a\u0012\u0012\u0004\u0012\u00020P0Oj\b\u0012\u0004\u0012\u00020P`Q\u00a2\u0006\b\n\u0000\u001a\u0004\bR\u0010SR\u001a\u0010T\u001a\u00020UX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR\u0011\u0010Z\u001a\u00020[\u00a2\u0006\b\n\u0000\u001a\u0004\b\\\u0010]R\u0011\u0010^\u001a\u00020_\u00a2\u0006\b\n\u0000\u001a\u0004\b`\u0010aR$\u0010c\u001a\u00020U2\u0006\u0010b\u001a\u00020U@BX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bd\u0010W\"\u0004\be\u0010YR\u0011\u0010f\u001a\u00020\u000e8F\u00a2\u0006\u0006\u001a\u0004\bg\u0010hR\u001a\u0010i\u001a\u00020jX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bk\u0010l\"\u0004\bm\u0010nR$\u0010p\u001a\u00020o2\u0006\u0010<\u001a\u00020o@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bq\u0010r\"\u0004\bs\u0010tR\u001a\u0010u\u001a\u00020UX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bv\u0010W\"\u0004\bw\u0010Y\u00a8\u0006\u00e9\u0001"}, d2={"Lgloomyfolken/mods/stalker/mobs/entity/EntityMutant;", "Lnet/minecraft/entity/monster/EntityMob;", "Lcpw/mods/fml/common/registry/IEntityAdditionalSpawnData;", "Lgloomyfolken/mods/core/misc/FrontendMetrics$IEntityMetricsType;", "world", "Lnet/minecraft/world/World;", "(Lnet/minecraft/world/World;)V", "_animationHandler", "", "get_animationHandler", "()Ljava/lang/Object;", "set_animationHandler", "(Ljava/lang/Object;)V", "_properties", "Lgloomyfolken/mods/stalker/mobs/entity/config/MutantConfiguration;", "agroSoundTime", "", "getAgroSoundTime", "()I", "setAgroSoundTime", "(I)V", "animationState", "Lgloomyfolken/mods/stalker/mobs/entity/animation/state/AnimationState;", "baseConfig", "Lgloomyfolken/mods/stalker/mobs/entity/config/MutantBaseConfig;", "getBaseConfig", "()Lgloomyfolken/mods/stalker/mobs/entity/config/MutantBaseConfig;", "setBaseConfig", "(Lgloomyfolken/mods/stalker/mobs/entity/config/MutantBaseConfig;)V", "defaultSkins", "", "Lgloomyfolken/mods/stalker/mobs/entity/MutantSkin;", "getDefaultSkins", "()Ljava/util/List;", "effectRegistry", "Ljava/util/HashMap;", "", "Lkotlin/Function2;", "Lnet/minecraft/util/Vec3;", "Lnet/minecraft/nbt/NBTTagCompound;", "", "Lkotlin/collections/HashMap;", "getEffectRegistry", "()Ljava/util/HashMap;", "homeInfo", "Lgloomyfolken/mods/stalker/mobs/entity/HomeInfo;", "getHomeInfo", "()Lgloomyfolken/mods/stalker/mobs/entity/HomeInfo;", "lastPlayedAnimation", "Lgloomyfolken/mods/stalker/mobs/entity/animation/AnimationProperty;", "getLastPlayedAnimation", "()Lgloomyfolken/mods/stalker/mobs/entity/animation/AnimationProperty;", "setLastPlayedAnimation", "(Lgloomyfolken/mods/stalker/mobs/entity/animation/AnimationProperty;)V", "lastPlayerDamageReceive", "getLastPlayerDamageReceive", "setLastPlayerDamageReceive", "lastSeenTimer", "getLastSeenTimer", "setLastSeenTimer", "value", "Lgloomyfolken/mods/stalker/mobs/entity/animation/state/LogicState;", "logicState", "getLogicState", "()Lgloomyfolken/mods/stalker/mobs/entity/animation/state/LogicState;", "setLogicState", "(Lgloomyfolken/mods/stalker/mobs/entity/animation/state/LogicState;)V", "mind", "Lgloomyfolken/mods/stalker/mobs/entity/MutantMind;", "getMind", "()Lgloomyfolken/mods/stalker/mobs/entity/MutantMind;", "setMind", "(Lgloomyfolken/mods/stalker/mobs/entity/MutantMind;)V", "mutantSkin", "getMutantSkin", "()Lgloomyfolken/mods/stalker/mobs/entity/MutantSkin;", "setMutantSkin", "(Lgloomyfolken/mods/stalker/mobs/entity/MutantSkin;)V", "nearbyPlayers", "Ljava/util/ArrayList;", "Lnet/minecraft/entity/player/EntityPlayer;", "Lkotlin/collections/ArrayList;", "getNearbyPlayers", "()Ljava/util/ArrayList;", "nightCreature", "", "getNightCreature", "()Z", "setNightCreature", "(Z)V", "pathHelper", "Lgloomyfolken/mods/stalker/mobs/entity/pathfind/PathHelper;", "getPathHelper", "()Lgloomyfolken/mods/stalker/mobs/entity/pathfind/PathHelper;", "pathfindSenses", "Lgloomyfolken/mods/stalker/mobs/entity/pathfind/PathfindSenses;", "getPathfindSenses", "()Lgloomyfolken/mods/stalker/mobs/entity/pathfind/PathfindSenses;", "<set-?>", "preventDrop", "getPreventDrop", "setPreventDrop", "properties", "getProperties", "()Lgloomyfolken/mods/stalker/mobs/entity/config/MutantConfiguration;", "scale", "", "getScale", "()F", "setScale", "(F)V", "Lgloomyfolken/mods/stalker/mobs/entity/MoveTurnDirection;", "turnDirection", "getTurnDirection", "()Lgloomyfolken/mods/stalker/mobs/entity/MoveTurnDirection;", "setTurnDirection", "(Lgloomyfolken/mods/stalker/mobs/entity/MoveTurnDirection;)V", "wasDamagedThisTick", "getWasDamagedThisTick", "setWasDamagedThisTick", "addDefaultSkins", "addRandomArmor", "applyConfiguration", "applyEntityCollision", "par1Entity", "Lnet/minecraft/entity/Entity;", "attackEntityAsMob", "attackEntityFrom", "par1DamageSource", "Lnet/minecraft/util/DamageSource;", "par2", "canDespawn", "canMove", "checkSurroundings", "createAiConstructionInfo", "Lgloomyfolken/mods/stalker/mobs/entity/ai/AIConstructionInfo;", "createRenderHandler", "Lgloomyfolken/mods/stalker/mobs/client/render/MutantAnimationHandler;", "damageEntity", "doAttackEntity", "damage", "entityInit", "fall", "par1", "findAnimation", "type", "Lgloomyfolken/mods/stalker/mobs/entity/animation/AnimationType;", "stance", "direction", "name", "func_110146_f", "getAgroSoundInterval", "getAnimationHandler", "getAttackAabb", "Lnet/minecraft/util/AxisAlignedBB;", "getCanSpawnHere", "getDeathSound", "getEntityName", "getHurtSound", "getLivingSound", "getMaxSafePointTries", "getMoveHelperExt", "Lgloomyfolken/mods/stalker/mobs/entity/ai/MutantMoveHelper;", "getRandomSkins", "", "getRenderSkin", "getSkin", "getSound", "soundType", "Lgloomyfolken/mods/stalker/mobs/entity/config/MutantSoundType;", "getSoundVolume", "getState", "getTranslatedEntityName", "getType", "hasAnimation", "hasConfiguration", "heal", "initClientEntity", "isAIEnabled", "isValidLightLevel", "knockBack", "par3", "", "par5", "onAttackEnd", "target", "Lnet/minecraft/entity/EntityLivingBase;", "onAttackStart", "onDeath", "onDeathUpdate", "onUpdate", "playSound", "volume", "pitch", "playSounds", "playSpecialSound", "reactsToCollision", "readFromNBT", "par1NBTTagCompound", "readSpawnData", "data", "Lcom/google/common/io/ByteArrayDataInput;", "receiveGenericEffectEvent", "packet", "Lgloomyfolken/mods/stalker/mobs/packet/event/PacketGenericEffectEvent;", "registerBehaviors", "registerClientEffects", "serverUpdate", "setAIMoveSpeed", "setConfiguration", "configuration", "setCustomState", "animation", "force", "setInWeb", "setSkin", "skin", "setState", "animationType", "init", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "setStateClient", "setupHelpers", "spawnsCorpse", "tickDespawnLogic", "updateAITasks", "updateClientNetwork", "updateRegen", "writeSpawnData", "Lcom/google/common/io/ByteArrayDataOutput;", "writeToNBTOptional", "Companion", "minecraft"})
public abstract class EntityMutant
extends EntityMob
implements IEntityAdditionalSpawnData,
jxtc.pidb {
    private MutantConfiguration _properties;
    @NotNull
    protected Object _animationHandler;
    @NotNull
    private MutantBaseConfig baseConfig;
    private AnimationState animationState;
    @NotNull
    private LogicState logicState;
    private float scale;
    @NotNull
    private MoveTurnDirection turnDirection;
    @NotNull
    private final List<MutantSkin> defaultSkins;
    @NotNull
    private MutantSkin mutantSkin;
    private int lastPlayerDamageReceive;
    @NotNull
    private final HashMap<String, Function2<Vec3, NBTTagCompound, Unit>> effectRegistry;
    private boolean wasDamagedThisTick;
    @NotNull
    private final PathHelper pathHelper;
    @NotNull
    private final PathfindSenses pathfindSenses;
    @NotNull
    private final HomeInfo homeInfo;
    @Nullable
    private AnimationProperty lastPlayedAnimation;
    private int agroSoundTime;
    private boolean preventDrop;
    private boolean nightCreature;
    @NotNull
    private final ArrayList<EntityPlayer> nearbyPlayers;
    private int lastSeenTimer;
    private static final int LOGIC_STATE_ID = 17;
    private static final int TURN_DIR_ID = 12;
    public static final Companion Companion = new Companion(null);

    @NotNull
    public final MutantConfiguration getProperties() {
        MutantConfiguration mutantConfiguration = this._properties;
        if (mutantConfiguration == null) {
            Intrinsics.throwNpe();
        }
        return mutantConfiguration;
    }

    @NotNull
    protected final Object get_animationHandler() {
        Object object = this._animationHandler;
        if (object == null) {
            Intrinsics.throwUninitializedPropertyAccessException("_animationHandler");
        }
        return object;
    }

    protected final void set_animationHandler(@NotNull Object object) {
        Intrinsics.checkParameterIsNotNull(object, "<set-?>");
        this._animationHandler = object;
    }

    @NotNull
    public final MutantBaseConfig getBaseConfig() {
        return this.baseConfig;
    }

    public final void setBaseConfig(@NotNull MutantBaseConfig mutantBaseConfig) {
        Intrinsics.checkParameterIsNotNull(mutantBaseConfig, "<set-?>");
        this.baseConfig = mutantBaseConfig;
    }

    @NotNull
    public final LogicState getLogicState() {
        return this.logicState;
    }

    public final void setLogicState(@NotNull LogicState logicState) {
        Intrinsics.checkParameterIsNotNull((Object)logicState, "value");
        this.logicState = logicState;
        if (!this.worldObj.isRemote && this.dataWatcher != null) {
            this.dataWatcher._b(EntityMutant.Companion.getLOGIC_STATE_ID(), (byte)logicState.ordinal());
        }
    }

    public final float getScale() {
        return this.scale;
    }

    public final void setScale(float f) {
        this.scale = f;
    }

    @NotNull
    public final MoveTurnDirection getTurnDirection() {
        return this.turnDirection;
    }

    public final void setTurnDirection(@NotNull MoveTurnDirection moveTurnDirection) {
        Intrinsics.checkParameterIsNotNull((Object)moveTurnDirection, "value");
        this.turnDirection = moveTurnDirection;
        if (!this.worldObj.isRemote && this.dataWatcher != null) {
            this.dataWatcher._b(EntityMutant.Companion.getTURN_DIR_ID(), (byte)moveTurnDirection.ordinal());
        }
    }

    @NotNull
    protected final List<MutantSkin> getDefaultSkins() {
        return this.defaultSkins;
    }

    @NotNull
    protected final MutantSkin getMutantSkin() {
        return this.mutantSkin;
    }

    protected final void setMutantSkin(@NotNull MutantSkin mutantSkin) {
        Intrinsics.checkParameterIsNotNull(mutantSkin, "<set-?>");
        this.mutantSkin = mutantSkin;
    }

    public final int getLastPlayerDamageReceive() {
        return this.lastPlayerDamageReceive;
    }

    public final void setLastPlayerDamageReceive(int n) {
        this.lastPlayerDamageReceive = n;
    }

    @NotNull
    protected final HashMap<String, Function2<Vec3, NBTTagCompound, Unit>> getEffectRegistry() {
        return this.effectRegistry;
    }

    public final boolean getWasDamagedThisTick() {
        return this.wasDamagedThisTick;
    }

    public final void setWasDamagedThisTick(boolean bl) {
        this.wasDamagedThisTick = bl;
    }

    @NotNull
    public final PathHelper getPathHelper() {
        return this.pathHelper;
    }

    @NotNull
    public final PathfindSenses getPathfindSenses() {
        return this.pathfindSenses;
    }

    @NotNull
    public final HomeInfo getHomeInfo() {
        return this.homeInfo;
    }

    @Nullable
    public final AnimationProperty getLastPlayedAnimation() {
        return this.lastPlayedAnimation;
    }

    public final void setLastPlayedAnimation(@Nullable AnimationProperty animationProperty) {
        this.lastPlayedAnimation = animationProperty;
    }

    protected final int getAgroSoundTime() {
        return this.agroSoundTime;
    }

    protected final void setAgroSoundTime(int n) {
        this.agroSoundTime = n;
    }

    public final boolean getPreventDrop() {
        return this.preventDrop;
    }

    private final void setPreventDrop(boolean bl) {
        this.preventDrop = bl;
    }

    public final boolean getNightCreature() {
        return this.nightCreature;
    }

    public final void setNightCreature(boolean bl) {
        this.nightCreature = bl;
    }

    @NotNull
    public final ArrayList<EntityPlayer> getNearbyPlayers() {
        return this.nearbyPlayers;
    }

    public final int getLastSeenTimer() {
        return this.lastSeenTimer;
    }

    public final void setLastSeenTimer(int n) {
        this.lastSeenTimer = n;
    }

    @NotNull
    public final List<MutantSkin> getRandomSkins() {
        List<MutantSkin> list2 = this.getProperties().getOverrideSkins();
        if (list2 != null) {
            return list2;
        }
        return this.defaultSkins;
    }

    @NotNull
    public MutantSkin getRenderSkin() {
        return this.getSkin();
    }

    @NotNull
    public final MutantSkin getSkin() {
        return this.mutantSkin;
    }

    public final void setSkin(@NotNull MutantSkin mutantSkin) {
        Intrinsics.checkParameterIsNotNull(mutantSkin, "skin");
        this.mutantSkin = mutantSkin;
    }

    @Override
    protected void entityInit() {
        super.entityInit();
        this.dataWatcher._a(EntityMutant.Companion.getLOGIC_STATE_ID(), (Object)((byte)LogicState.STAND.ordinal()));
        this.dataWatcher._a(EntityMutant.Companion.getTURN_DIR_ID(), (Object)((byte)MoveTurnDirection.NONE.ordinal()));
        this.dataWatcher._a(18, Float.valueOf(0.0f));
    }

    @ezey(_a={eidj.CLIENT})
    public void registerClientEffects() {
    }

    @ezey(_a={eidj.CLIENT})
    public void receiveGenericEffectEvent(@NotNull PacketGenericEffectEvent packetGenericEffectEvent) {
        block0: {
            Intrinsics.checkParameterIsNotNull(packetGenericEffectEvent, "packet");
            Function2<Vec3, NBTTagCompound, Unit> function2 = this.effectRegistry.get(packetGenericEffectEvent.effectId);
            if (function2 == null) break block0;
            Vec3 vec3 = McExtensionsKt.vec3(this.worldObj, packetGenericEffectEvent.posX, packetGenericEffectEvent.posY, packetGenericEffectEvent.posZ);
            Intrinsics.checkExpressionValueIsNotNull(vec3, "worldObj.vec3(packet.pos\u2026packet.posY, packet.posZ)");
            NBTTagCompound nBTTagCompound = packetGenericEffectEvent.info;
            Intrinsics.checkExpressionValueIsNotNull(nBTTagCompound, "packet.info");
            function2.invoke(vec3, nBTTagCompound);
        }
    }

    public final boolean hasConfiguration() {
        return this._properties != null;
    }

    @Override
    public void writeSpawnData(@NotNull ByteArrayDataOutput byteArrayDataOutput) {
        Intrinsics.checkParameterIsNotNull(byteArrayDataOutput, "data");
        byteArrayDataOutput.writeUTF(this.mutantSkin.getSkinName());
        byteArrayDataOutput.writeUTF(this.getProperties().getCommon().getName());
    }

    public boolean spawnsCorpse() {
        return true;
    }

    @Override
    public int getMaxSafePointTries() {
        return 1;
    }

    @Override
    public void setInWeb() {
        this.fallDistance = 0.0f;
    }

    @Override
    public void readSpawnData(@NotNull ByteArrayDataInput byteArrayDataInput) {
        Intrinsics.checkParameterIsNotNull(byteArrayDataInput, "data");
        String string = byteArrayDataInput.readUTF();
        CharSequence charSequence = string;
        if (!(charSequence.length() == 0)) {
            String string2 = string;
            Intrinsics.checkExpressionValueIsNotNull(string2, "skin");
            this.mutantSkin = new MutantSkin(string2, 0.0f, 2, null);
        } else {
            this.mutantSkin = new MutantSkin("", 0.0f, 2, null);
        }
        CharSequence charSequence2 = charSequence = byteArrayDataInput.readUTF();
        Intrinsics.checkExpressionValueIsNotNull(charSequence2, "configName");
        MutantConfiguration mutantConfiguration = MutantConfigHelper.CLIENT.getMobConfiguration((String)charSequence2);
        if (mutantConfiguration != null) {
            this.setConfiguration(mutantConfiguration);
        } else {
            Logger.severe("Received non-existing entity config from connectedServer! This may cause severe problems!" + "Please report to devs. Configuration name is absent: \"" + (String)charSequence + "\". Current entity will be" + "despawned.", new Object[0]);
            this.isDead = true;
        }
    }

    public final void setConfiguration(@NotNull MutantConfiguration mutantConfiguration) {
        Intrinsics.checkParameterIsNotNull(mutantConfiguration, "configuration");
        if (this._properties != null) {
            Logger.warning("Mob Configuration was already set! Removing incorrect entity from world.", new Object[0]);
            Thread.dumpStack();
            this.isDead = true;
            return;
        }
        this._properties = mutantConfiguration;
        this.applyConfiguration();
        this.scale = mutantConfiguration.getCommon().getScale();
        this.setSize(this.width * this.scale, this.height * this.scale);
        InvokeSideOnly.frontend(!this.worldObj.isRemote, new InvokeSideOnly.InvokeFrontendOnly(this){
            final /* synthetic */ EntityMutant this$0;

            public final void run() {
            }
            {
                this.this$0 = entityMutant;
            }
        });
    }

    protected final void setupHelpers() {
        InvokeSideOnly.frontend(!this.worldObj.isRemote, new InvokeSideOnly.InvokeFrontendOnly(this){
            final /* synthetic */ EntityMutant this$0;

            public final void run() {
            }
            {
                this.this$0 = entityMutant;
            }
        });
    }

    protected final void applyConfiguration() {
        this.getEntityAttribute(sajz._b)._a(this.getProperties().getAi().getFollowRange());
        this.getEntityAttribute(sajz._d)._a(this.getProperties().getMovement().getMovementSpeed());
        this.getEntityAttribute(sajz._e)._a(this.getProperties().getAttack().getAttackStrength());
        this.getEntityAttribute(sajz._a)._a(this.getProperties().getHealth().getMaxHealthPoints());
        this.setHealth(this.getMaxHealth());
    }

    @Override
    public boolean writeToNBTOptional(@Nullable NBTTagCompound nBTTagCompound) {
        return false;
    }

    @Override
    public void readFromNBT(@Nullable NBTTagCompound nBTTagCompound) {
        if (!this.worldObj.isRemote) {
            throw (Throwable)new IllegalStateException("Shouldn't read mutants from NBT!");
        }
    }

    @Override
    public void setAIMoveSpeed(float f) {
        super.setAIMoveSpeed(f);
        this.moveForward = f > 0.0f ? 1.0f : 0.0f;
    }

    @Override
    protected void onDeathUpdate() {
        EntityMutant entityMutant = this;
        ++entityMutant.deathTime;
        int cfr_ignored_0 = entityMutant.deathTime;
        if (this.deathTime == 20) {
            this.setDead();
        }
    }

    @Override
    public void onDeath(@Nullable DamageSource damageSource) {
        this.preventDrop = damageSource == null || !(damageSource.getSourceOfDamage() instanceof EntityPlayer);
        super.onDeath(damageSource);
        if (!this.preventDrop) {
            InvokeSideOnly.frontend(!this.worldObj.isRemote, new InvokeSideOnly.InvokeFrontendOnly(this){
                final /* synthetic */ EntityMutant this$0;

                public final void run() {
                }
                {
                    this.this$0 = entityMutant;
                }
            });
        }
    }

    protected void addDefaultSkins() {
        Collection collection = this.defaultSkins;
        MutantSkin mutantSkin = new MutantSkin("", 1.0f);
        collection.add(mutantSkin);
    }

    @Override
    public boolean getCanSpawnHere() {
        int n = sajh._c(this.posX);
        int n2 = sajh._c(this.boundingBox._c);
        int n3 = sajh._c(this.posZ);
        return this.worldObj.checkNoEntityCollision(this.boundingBox) && this.worldObj.getCollidingBoundingBoxes(this, this.boundingBox).isEmpty() && !this.worldObj.isAnyLiquid(this.boundingBox) && (!McExtensionsKt.isBlockSolid(this.worldObj, n, n2, n3) || this.worldObj.isAirBlock(n, n2, n3));
    }

    @Override
    public boolean isValidLightLevel() {
        int n;
        int n2;
        int n3 = sajh._c(this.posX);
        return this.worldObj.getSavedLightValue(EnumSkyBlock._a, n3, n2 = sajh._c(this.boundingBox._c), n = sajh._c(this.posZ)) > 12;
    }

    @ezey(_a={eidj.CLIENT})
    @NotNull
    protected MutantAnimationHandler createRenderHandler() {
        return new MutantAnimationHandler(this);
    }

    @ezey(_a={eidj.CLIENT})
    @NotNull
    public final MutantAnimationHandler getAnimationHandler() {
        Object object = this._animationHandler;
        if (object == null) {
            Intrinsics.throwUninitializedPropertyAccessException("_animationHandler");
        }
        if (object == null) {
            throw new TypeCastException("null cannot be cast to non-null type gloomyfolken.mods.stalker.mobs.client.render.MutantAnimationHandler");
        }
        return (MutantAnimationHandler)object;
    }

    @ezey(_a={eidj.CLIENT})
    protected final void initClientEntity() {
        this._animationHandler = this.createRenderHandler();
        this.registerClientEffects();
    }

    @Nullable
    public final AnimationProperty findAnimation(@NotNull String string) {
        Intrinsics.checkParameterIsNotNull(string, "name");
        return this.baseConfig.getAnimations().get(string);
    }

    @Nullable
    public final AnimationProperty findAnimation(@NotNull AnimationType animationType, @NotNull LogicState logicState) {
        Intrinsics.checkParameterIsNotNull((Object)animationType, "type");
        Intrinsics.checkParameterIsNotNull((Object)logicState, "stance");
        String string = animationType.name();
        StringBuilder stringBuilder = new StringBuilder();
        Map<String, AnimationProperty> map = this.baseConfig.getAnimations();
        String string2 = string;
        if (string2 == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        String string3 = string2.toLowerCase();
        Intrinsics.checkExpressionValueIsNotNull(string3, "(this as java.lang.String).toLowerCase()");
        String string4 = string3;
        string = logicState.name();
        stringBuilder = stringBuilder.append(string4).append("_");
        String string5 = string;
        if (string5 == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        String string6 = string5.toLowerCase();
        Intrinsics.checkExpressionValueIsNotNull(string6, "(this as java.lang.String).toLowerCase()");
        string4 = string6;
        return map.get(stringBuilder.append(string4).toString());
    }

    @Nullable
    public final AnimationProperty findAnimation(@NotNull AnimationType animationType, @NotNull LogicState logicState, @NotNull MoveTurnDirection moveTurnDirection) {
        Intrinsics.checkParameterIsNotNull((Object)animationType, "type");
        Intrinsics.checkParameterIsNotNull((Object)logicState, "stance");
        Intrinsics.checkParameterIsNotNull((Object)moveTurnDirection, "direction");
        String string = animationType.name();
        StringBuilder stringBuilder = new StringBuilder();
        Map<String, AnimationProperty> map = this.baseConfig.getAnimations();
        String string2 = string;
        if (string2 == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        String string3 = string2.toLowerCase();
        Intrinsics.checkExpressionValueIsNotNull(string3, "(this as java.lang.String).toLowerCase()");
        String string4 = string3;
        string = logicState.name();
        stringBuilder = stringBuilder.append(string4).append("_");
        String string5 = string;
        if (string5 == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        String string6 = string5.toLowerCase();
        Intrinsics.checkExpressionValueIsNotNull(string6, "(this as java.lang.String).toLowerCase()");
        string4 = string6;
        return map.get(stringBuilder.append(string4).append(moveTurnDirection.getAnimSuffix()).toString());
    }

    public final boolean hasAnimation(@NotNull AnimationType animationType, @NotNull LogicState logicState) {
        Intrinsics.checkParameterIsNotNull((Object)animationType, "type");
        Intrinsics.checkParameterIsNotNull((Object)logicState, "stance");
        return this.findAnimation(animationType, logicState) != null;
    }

    public final boolean hasAnimation(@NotNull String string) {
        Intrinsics.checkParameterIsNotNull(string, "name");
        return this.findAnimation(string) != null;
    }

    @ezey(_a={eidj.CLIENT})
    public final void updateClientNetwork() {
        if (this.dataWatcher._a()) {
            float f = this.dataWatcher._d(18);
            if (f != 0.0f) {
                this.newPosY = this.posY = (double)f;
                this.serverPosY = owkq._t(f * (float)32);
            }
            this.setLogicState(LogicState.values()[this.dataWatcher._a(EntityMutant.Companion.getLOGIC_STATE_ID())]);
            this.setTurnDirection(MoveTurnDirection.values()[this.dataWatcher._a(EntityMutant.Companion.getTURN_DIR_ID())]);
        }
    }

    public final boolean setState(@NotNull AnimationType animationType, boolean bl, @NotNull Function1<? super AnimationState, Unit> function1) {
        Intrinsics.checkParameterIsNotNull((Object)animationType, "type");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        this.worldObj.theProfiler._a("stateset");
        boolean bl2 = false;
        if (this.animationState.isInterruptible() && Intrinsics.areEqual((Object)this.animationState.getAnimationType(), (Object)animationType) ^ true || bl) {
            AnimationState animationState = animationType.createState(this);
            animationState.setAnimationType(animationType);
            this.animationState = animationState;
            function1.invoke(animationState);
            animationState.execute();
            if (!this.worldObj.isRemote) {
                InvokeSideOnly.frontend(new InvokeSideOnly.InvokeFrontendOnly(this){
                    final /* synthetic */ EntityMutant this$0;

                    public final void run() {
                    }
                    {
                        this.this$0 = entityMutant;
                    }
                });
            }
            bl2 = true;
        }
        this.worldObj.theProfiler._b();
        return bl2;
    }

    public static /* synthetic */ boolean setState$default(EntityMutant entityMutant, AnimationType animationType, boolean bl, Function1 function1, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setState");
        }
        if ((n & 2) != 0) {
            bl = false;
        }
        if ((n & 4) != 0) {
            function1 = setState.1.INSTANCE;
        }
        return entityMutant.setState(animationType, bl, function1);
    }

    public final boolean setState(@NotNull AnimationType animationType, boolean bl) {
        Intrinsics.checkParameterIsNotNull((Object)animationType, "animationType");
        return this.setState(animationType, bl, setState.3.INSTANCE);
    }

    public static /* synthetic */ boolean setState$default(EntityMutant entityMutant, AnimationType animationType, boolean bl, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setState");
        }
        if ((n & 2) != 0) {
            bl = false;
        }
        return entityMutant.setState(animationType, bl);
    }

    public final boolean setCustomState(@NotNull AnimationProperty animationProperty, boolean bl) {
        Intrinsics.checkParameterIsNotNull(animationProperty, "animation");
        return this.setState(AnimationType.CUSTOM, bl, (Function1<? super AnimationState, Unit>)new Function1<AnimationState, Unit>(animationProperty){
            final /* synthetic */ AnimationProperty $animation;

            public final void invoke(@NotNull AnimationState animationState) {
                Intrinsics.checkParameterIsNotNull(animationState, "$receiver");
                ((CustomAnimationState)animationState).setCustomAnimation(this.$animation);
            }
            {
                this.$animation = animationProperty;
                super(1);
            }
        });
    }

    public static /* synthetic */ boolean setCustomState$default(EntityMutant entityMutant, AnimationProperty animationProperty, boolean bl, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setCustomState");
        }
        if ((n & 2) != 0) {
            bl = false;
        }
        return entityMutant.setCustomState(animationProperty, bl);
    }

    @NotNull
    public final AnimationState getState() {
        return this.animationState;
    }

    @ezey(_a={eidj.CLIENT})
    public final void setStateClient(@NotNull AnimationState animationState) {
        Intrinsics.checkParameterIsNotNull(animationState, "animationState");
        this.animationState = animationState;
    }

    @Override
    protected float func_110146_f(float f, float f2) {
        boolean bl;
        float f3 = f2;
        float f4 = sajh._g(f - this.renderYawOffset);
        this.renderYawOffset += f4 * 0.9f;
        float f5 = sajh._g(this.rotationYaw - this.renderYawOffset);
        boolean bl2 = bl = f5 < -90.0f || f5 >= 90.0f;
        if (f5 < -75.0f) {
            f5 = -75.0f;
        }
        if (f5 >= 75.0f) {
            f5 = 75.0f;
        }
        this.renderYawOffset = this.rotationYaw - f5;
        this.renderYawOffset += f5 * 0.8f;
        if (bl) {
            f3 *= -1.0f;
        }
        return f3;
    }

    @Override
    protected void updateAITasks() {
        EntityMutant entityMutant = this;
        ++entityMutant.entityAge;
        int cfr_ignored_0 = entityMutant.entityAge;
        this.worldObj.theProfiler._a("checkDespawn");
        this.despawnEntity();
        this.worldObj.theProfiler._b();
        this.worldObj.theProfiler._a("sensing");
        this.senses._a();
        this.worldObj.theProfiler._b();
        this.worldObj.theProfiler._a("targetSelector");
        this.targetTasks._a();
        this.worldObj.theProfiler._b();
        this.worldObj.theProfiler._a("goalSelector");
        this.tasks._a();
        this.worldObj.theProfiler._b();
        this.worldObj.theProfiler._a("navigation");
        this.navigator._e();
        this.worldObj.theProfiler._b();
        this.worldObj.theProfiler._a("mob tick");
        this.updateAITick();
        this.worldObj.theProfiler._b();
        this.worldObj.theProfiler._a("controls");
        this.worldObj.theProfiler._a("move");
        this.moveHelper._c();
        this.worldObj.theProfiler._c("look");
        this.lookHelper._a();
        this.worldObj.theProfiler._c("jump");
        this.jumpHelper._b();
        this.worldObj.theProfiler._b();
        this.worldObj.theProfiler._b();
    }

    public final boolean canMove() {
        return (this.animationState.isInterruptible() || !this.animationState.blocksMovement()) && this.isEntityAlive();
    }

    protected final boolean reactsToCollision() {
        return this.canMove();
    }

    @Override
    public void applyEntityCollision(@NotNull Entity entity) {
        double d;
        double d2;
        double d3;
        Intrinsics.checkParameterIsNotNull(entity, "par1Entity");
        if (entity.riddenByEntity != this && entity.ridingEntity != this && !(entity instanceof EntityPlayer) && (d3 = sajh._a(d2 = entity.posX - this.posX, d = entity.posZ - this.posZ) / (double)this.scale / (double)2) >= (double)0.01f) {
            boolean bl;
            d3 = sajh._a(d3);
            d2 /= d3;
            d /= d3;
            double d4 = 1.0 / d3;
            if (d4 > 1.0) {
                d4 = 1.0;
            }
            d2 *= d4;
            d *= d4;
            d2 *= 0.025000000074505806;
            d *= 0.025000000074505806;
            d2 *= (double)1.0f;
            d *= (double)1.0f;
            if (this.reactsToCollision() && entity.isEntityAlive()) {
                this.addVelocity(-d2, 0.0, -d);
            }
            boolean bl2 = bl = !(entity instanceof EntityMutant) || ((EntityMutant)entity).reactsToCollision() && this.isEntityAlive();
            if (bl) {
                entity.addVelocity(d2, 0.0, d);
            }
        }
    }

    @Override
    public boolean attackEntityFrom(@Nullable DamageSource damageSource, float f) {
        DamageSource damageSource2 = damageSource;
        if (damageSource2 == null) {
            return false;
        }
        DamageSource damageSource3 = damageSource2;
        float f2 = f;
        if (damageSource3 instanceof DamageSourceMutant) {
            f2 *= 4.0f;
        }
        return super.attackEntityFrom(damageSource3, f2 *= owkq._j(this.getProperties().getDamageFactor(damageSource3)));
    }

    @Override
    protected void damageEntity(@NotNull DamageSource damageSource, float f) {
        Intrinsics.checkParameterIsNotNull(damageSource, "par1DamageSource");
        super.damageEntity(damageSource, f);
        if (f >= 0.0f) {
            this.wasDamagedThisTick = true;
        }
        InvokeSideOnly.frontend(!this.worldObj.isRemote, new InvokeSideOnly.InvokeFrontendOnly(this, damageSource, f){
            final /* synthetic */ EntityMutant this$0;
            final /* synthetic */ DamageSource $par1DamageSource;
            final /* synthetic */ float $par2;

            public final void run() {
            }
            {
                this.this$0 = entityMutant;
                this.$par1DamageSource = damageSource;
                this.$par2 = f;
            }
        });
    }

    public void onAttackStart(@NotNull EntityLivingBase entityLivingBase) {
        Intrinsics.checkParameterIsNotNull(entityLivingBase, "target");
    }

    public void onAttackEnd(@Nullable EntityLivingBase entityLivingBase) {
    }

    @Override
    public void heal(float f) {
        Ref.FloatRef floatRef = new Ref.FloatRef();
        floatRef.element = this.getHealth();
        super.heal(f);
        floatRef.element -= this.getHealth();
        InvokeSideOnly.frontend(new InvokeSideOnly.InvokeFrontendOnly(this, floatRef){
            final /* synthetic */ EntityMutant this$0;
            final /* synthetic */ Ref.FloatRef $healAmount;

            public final void run() {
            }
            {
                this.this$0 = entityMutant;
                this.$healAmount = floatRef;
            }
        });
    }

    public boolean doAttackEntity(@NotNull Entity entity, float f) {
        Intrinsics.checkParameterIsNotNull(entity, "par1Entity");
        if (!this.isEntityAlive()) {
            return false;
        }
        float f2 = f;
        int n = entity.hurtResistantTime;
        if (entity instanceof EntityLivingBase) {
            Ref.FloatRef floatRef = new Ref.FloatRef();
            floatRef.element = ((EntityLivingBase)entity).getHealth();
            entity.hurtResistantTime = 0;
            boolean bl = entity.attackEntityFrom(new DamageSourceMutant(this), f2);
            entity.hurtResistantTime = n;
            floatRef.element -= ((EntityLivingBase)entity).getHealth();
            InvokeSideOnly.frontend(!this.worldObj.isRemote, new InvokeSideOnly.InvokeFrontendOnly(this, entity, bl, floatRef){
                final /* synthetic */ EntityMutant this$0;
                final /* synthetic */ Entity $par1Entity;
                final /* synthetic */ boolean $success;
                final /* synthetic */ Ref.FloatRef $damageDealt;

                public final void run() {
                }
                {
                    this.this$0 = entityMutant;
                    this.$par1Entity = entity;
                    this.$success = bl;
                    this.$damageDealt = floatRef;
                }
            });
            return bl;
        }
        return false;
    }

    public static /* synthetic */ boolean doAttackEntity$default(EntityMutant entityMutant, Entity entity, float f, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: doAttackEntity");
        }
        if ((n & 2) != 0) {
            f = entityMutant.getProperties().getAttack().getAttackStrength();
        }
        return entityMutant.doAttackEntity(entity, f);
    }

    @Override
    public boolean attackEntityAsMob(@NotNull Entity entity) {
        Intrinsics.checkParameterIsNotNull(entity, "par1Entity");
        return EntityMutant.doAttackEntity$default(this, entity, 0.0f, 2, null);
    }

    @NotNull
    public final AxisAlignedBB getAttackAabb() {
        double d = (this.getProperties().getAttack().getAttackDist() + (double)(this.width / (float)2)) * (double)this.scale;
        double d2 = this.posX + McExtensionsKt.cos(Math.toRadians(owkq._r(this.rotationYaw) + (double)90.0f)) * d;
        double d3 = this.posY + (double)(this.height / (float)2);
        double d4 = this.posZ + McExtensionsKt.sin(Math.toRadians(owkq._r(this.rotationYaw) + (double)90.0f)) * d;
        AxisAlignedBB axisAlignedBB = AxisAlignedBB._a()._a(d2, d3, d4, d2, d3, d4)._b(this.getProperties().getAttack().getAttackAabbWidth(), this.getProperties().getAttack().getAttackAabbHeight(), this.getProperties().getAttack().getAttackAabbWidth());
        Intrinsics.checkExpressionValueIsNotNull(axisAlignedBB, "AxisAlignedBB.getAABBPoo\u2026attackAabbWidth\n        )");
        return axisAlignedBB;
    }

    @Override
    public void onUpdate() {
        jxtc._a._a("mutant");
        this.worldObj.theProfiler._a("tick_mutant");
        try {
            super.onUpdate();
            InvokeSideOnly.client(this.worldObj.isRemote, new InvokeSideOnly.InvokeClientOnly(this){
                final /* synthetic */ EntityMutant this$0;

                public final void run() {
                    this.this$0.updateClientNetwork();
                }
                {
                    this.this$0 = entityMutant;
                }
            });
            InvokeSideOnly.frontend(!this.worldObj.isRemote, new InvokeSideOnly.InvokeFrontendOnly(this){
                final /* synthetic */ EntityMutant this$0;

                public final void run() {
                }
                {
                    this.this$0 = entityMutant;
                }
            });
            this.worldObj.theProfiler._a("stateupdate");
            this.animationState.updateState();
            this.worldObj.theProfiler._b();
            InvokeSideOnly.frontend(!this.worldObj.isRemote, new InvokeSideOnly.InvokeFrontendOnly(this){
                final /* synthetic */ EntityMutant this$0;

                public final void run() {
                }
                {
                    this.this$0 = entityMutant;
                }
            });
            InvokeSideOnly.client(this.worldObj.isRemote, new InvokeSideOnly.InvokeClientOnly(this){
                final /* synthetic */ EntityMutant this$0;

                public final void run() {
                    this.this$0.getAnimationHandler().tick();
                }
                {
                    this.this$0 = entityMutant;
                }
            });
            this.wasDamagedThisTick = false;
        }
        catch (Throwable throwable) {
            Logger.severe("Caught exception during mutant tick! Details below:", new Object[0]);
            throwable.printStackTrace();
        }
        this.worldObj.theProfiler._b();
        jxtc._a._b();
    }

    public int getAgroSoundInterval() {
        return 70;
    }

    @Override
    @NotNull
    public String getTranslatedEntityName() {
        return this.getEntityName();
    }

    @Override
    @NotNull
    public abstract String getEntityName();

    @Override
    public void playSound(@Nullable String string, float f, float f2) {
        if (string != null) {
            this.worldObj.playSoundAtEntity(this, string, f, f2);
        }
    }

    private final void playSound(String string) {
        this.playSound(string, this.getSoundVolume(), this.getSoundPitch());
    }

    public final void playSound(@NotNull MutantSoundType mutantSoundType) {
        Intrinsics.checkParameterIsNotNull((Object)mutantSoundType, "type");
        this.playSound(this.getSound(mutantSoundType));
    }

    public final void playSpecialSound(@NotNull String string) {
        Intrinsics.checkParameterIsNotNull(string, "name");
        this.playSound(this.getSound(string));
    }

    @Override
    @Nullable
    public String getLivingSound() {
        return null;
    }

    @Override
    protected void fall(float f) {
        float f2 = ForgeHooks.onLivingFall(this, f);
        if (f2 <= 0.0f) {
            return;
        }
        PotionEffect potionEffect = this.getActivePotionEffect(Potion._j);
        float f3 = potionEffect != null ? (float)(potionEffect._c() + 1) : 0.0f;
        int n = sajh._f(f2 - 3.0f - f3);
        if (n > 0) {
            if (n > 4) {
                this.playSound(this.getHurtSound(), 1.0f, 1.0f);
            } else {
                this.playSound(this.getHurtSound(), 1.0f, 1.0f);
            }
            this.attackEntityFrom(DamageSource.fall, n);
            int n2 = this.worldObj.getBlockId(sajh._c(this.posX), sajh._c(this.posY - (double)0.2f - (double)this.yOffset), sajh._c(this.posZ));
            if (n2 <= 0) {
                // empty if block
            }
        }
    }

    @Override
    protected float getSoundVolume() {
        return 1.0f;
    }

    @NotNull
    public final String getSound(@NotNull MutantSoundType mutantSoundType) {
        Intrinsics.checkParameterIsNotNull((Object)mutantSoundType, "soundType");
        String string = mutantSoundType.name();
        EntityMutant entityMutant = this;
        String string2 = string;
        if (string2 == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        String string3 = string2.toLowerCase();
        Intrinsics.checkExpressionValueIsNotNull(string3, "(this as java.lang.String).toLowerCase()");
        String string4 = string3;
        return entityMutant.getSound(string4);
    }

    @NotNull
    public final String getSound(@NotNull String string) {
        Intrinsics.checkParameterIsNotNull(string, "name");
        String string2 = this.baseConfig.getSounds().get(string);
        if (string2 == null) {
            string2 = "";
        }
        return string2;
    }

    @Override
    @NotNull
    public String getHurtSound() {
        return this.getSound(MutantSoundType.PAIN);
    }

    @Override
    @NotNull
    public String getDeathSound() {
        return this.getSound(MutantSoundType.DEATH);
    }

    @Override
    protected boolean isAIEnabled() {
        return true;
    }

    @Override
    public void knockBack(@Nullable Entity entity, float f, double d, double d2) {
    }

    @Override
    protected void addRandomArmor() {
    }

    @Override
    protected boolean canDespawn() {
        return false;
    }

    @Override
    @NotNull
    public String getType() {
        return "mutant";
    }

    public EntityMutant(@NotNull World world) {
        Intrinsics.checkParameterIsNotNull(world, "world");
        super(world);
        MutantBaseConfig mutantBaseConfig = MutantBaseConfig.Companion.getMobConfigurations().get(this.getClass());
        if (mutantBaseConfig == null) {
            throw (Throwable)new IllegalArgumentException("No base config found for mob " + this.getClass());
        }
        this.baseConfig = mutantBaseConfig;
        this.logicState = LogicState.STAND;
        this.scale = 1.0f;
        this.turnDirection = MoveTurnDirection.NONE;
        EntityMutant entityMutant = this;
        ArrayList arrayList = new ArrayList();
        entityMutant.defaultSkins = arrayList;
        this.mutantSkin = new MutantSkin("", 0.0f);
        this.lastPlayerDamageReceive = -1;
        entityMutant = this;
        arrayList = new HashMap();
        entityMutant.effectRegistry = arrayList;
        this.pathHelper = new PathHelper(this);
        this.pathfindSenses = new PathfindSenses(this);
        this.homeInfo = new HomeInfo(this);
        this.agroSoundTime = 1000;
        entityMutant = this;
        arrayList = new ArrayList();
        entityMutant.nearbyPlayers = arrayList;
        this.stepHeight = 1.0f;
        this.entityCollisionReduction = 1.0f;
        this.setSize(0.75f, 0.8f);
        if (world.isRemote) {
            InvokeSideOnly.client(new InvokeSideOnly.InvokeClientOnly(){

                @Override
                public final void run() {
                    this.initClientEntity();
                }
            });
        }
        this.animationState = AnimationType.IDLE.createState(this);
        this.animationState.execute();
    }

    static {
        LOGIC_STATE_ID = 17;
        TURN_DIR_ID = 12;
    }

    public static final /* synthetic */ EntityMoveHelper access$getMoveHelper$p(EntityMutant entityMutant) {
        return entityMutant.moveHelper;
    }

    public static final /* synthetic */ void access$setMoveHelper$p(EntityMutant entityMutant, EntityMoveHelper entityMoveHelper) {
        entityMutant.moveHelper = entityMoveHelper;
    }

    public static final /* synthetic */ zwat access$getBodyHelper$p(EntityMutant entityMutant) {
        return entityMutant.bodyHelper;
    }

    public static final /* synthetic */ void access$setBodyHelper$p(EntityMutant entityMutant, zwat zwat2) {
        entityMutant.bodyHelper = zwat2;
    }

    public static final /* synthetic */ DataWatcher access$getDataWatcher$p(EntityMutant entityMutant) {
        return entityMutant.dataWatcher;
    }

    public static final /* synthetic */ void access$setDataWatcher$p(EntityMutant entityMutant, DataWatcher dataWatcher) {
        entityMutant.dataWatcher = dataWatcher;
    }

    @NotNull
    public static final /* synthetic */ AnimationState access$getAnimationState$p(EntityMutant entityMutant) {
        return entityMutant.animationState;
    }

    public static final /* synthetic */ void access$setAnimationState$p(EntityMutant entityMutant, @NotNull AnimationState animationState) {
        entityMutant.animationState = animationState;
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0082D\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006\u00a8\u0006\t"}, d2={"Lgloomyfolken/mods/stalker/mobs/entity/EntityMutant$Companion;", "", "()V", "LOGIC_STATE_ID", "", "getLOGIC_STATE_ID", "()I", "TURN_DIR_ID", "getTURN_DIR_ID", "minecraft"})
    public static final class Companion {
        private final int getLOGIC_STATE_ID() {
            return LOGIC_STATE_ID;
        }

        private final int getTURN_DIR_ID() {
            return TURN_DIR_ID;
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}

