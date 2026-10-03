/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.ktcore;

import javax.vecmath.Quat4f;
import javax.vecmath.Vector3f;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DoubleCompanionObject;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.util.Vec3;
import net.minecraft.util.sajh;
import org.jetbrains.annotations.NotNull;
import org.lwjgl.util.vector.Quaternion;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=2, d1={"\u0000P\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0013\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b2\u001a \u0010\u001b\u001a\u00020\u001c2\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0002\u001a \u0010\u001d\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\bH\u0002\u001a \u0010\u001e\u001a\u00020\u001f2\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0002\u001a\u0018\u0010 \u001a\u00020\b2\u0006\u0010!\u001a\u00020\b2\u0006\u0010 \u001a\u00020\bH\u0002\u001a\u0018\u0010 \u001a\u00020\u00012\u0006\u0010!\u001a\u00020\u00012\u0006\u0010 \u001a\u00020\u0001H\u0002\u001a0\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\u00012\u0006\u0010&\u001a\u00020\u00012\u0006\u0010'\u001a\u00020\u00012\u0006\u0010(\u001a\u00020\u0001H\u0002\u001a\u0010\u0010)\u001a\u00020\b2\u0006\u0010*\u001a\u00020\bH\u0002\u001a\u0010\u0010)\u001a\u00020\u00012\u0006\u0010*\u001a\u00020\u0001H\u0002\u001a\u000e\u0010+\u001a\n ,*\u0004\u0018\u00010\t0\t\u001a\u0016\u0010+\u001a\n ,*\u0004\u0018\u00010\t0\t2\u0006\u0010*\u001a\u00020\b\u001a&\u0010+\u001a\n ,*\u0004\u0018\u00010\t0\t2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\b\u001a\u0016\u0010+\u001a\n ,*\u0004\u0018\u00010\t0\t2\u0006\u0010-\u001a\u00020\t\u001a\"\u0010.\u001a\u00020\u001f*\u00020\u001f2\u0006\u0010/\u001a\u00020\u00012\u0006\u00100\u001a\u00020\u00012\u0006\u00101\u001a\u00020\u0001\u001a\"\u0010.\u001a\u00020\t*\u00020\t2\u0006\u0010/\u001a\u00020\b2\u0006\u00100\u001a\u00020\b2\u0006\u00101\u001a\u00020\b\u001a*\u0010.\u001a\n ,*\u0004\u0018\u00010\t0\t*\u00020\t2\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001\u001a\"\u0010.\u001a\u00020\u001c*\u00020\u001c2\u0006\u0010/\u001a\u00020\u00012\u0006\u00100\u001a\u00020\u00012\u0006\u00101\u001a\u00020\u0001\u001a\u0012\u00102\u001a\u00020\u001f*\u00020\u001f2\u0006\u0010-\u001a\u00020\u001f\u001a\u0012\u00102\u001a\u00020\t*\u00020\t2\u0006\u0010-\u001a\u00020\t\u001a\u0012\u00102\u001a\u00020\u001c*\u00020\u001c2\u0006\u0010-\u001a\u00020\u001c\u001a\u0012\u00103\u001a\u00020\u001f*\u00020\u001f2\u0006\u0010-\u001a\u00020\u001f\u001a\"\u00103\u001a\u00020\u001f*\u00020\u001f2\u0006\u0010/\u001a\u00020\u00012\u0006\u00100\u001a\u00020\u00012\u0006\u00101\u001a\u00020\u0001\u001a\"\u00103\u001a\u00020\t*\u00020\t2\u0006\u0010/\u001a\u00020\b2\u0006\u00100\u001a\u00020\b2\u0006\u00101\u001a\u00020\b\u001a\u0012\u00103\u001a\u00020\t*\u00020\t2\u0006\u0010-\u001a\u00020\t\u001a\"\u00103\u001a\u00020#*\u00020\u001c2\u0006\u0010/\u001a\u00020\u00012\u0006\u00100\u001a\u00020\u00012\u0006\u00101\u001a\u00020\u0001\u001a\u0012\u00103\u001a\u00020#*\u00020\u001c2\u0006\u0010-\u001a\u00020\u001c\u001a\u0012\u00104\u001a\u00020\u0001*\u00020\u001f2\u0006\u0010-\u001a\u00020\u001f\u001a\u0012\u00104\u001a\u00020\b*\u00020\t2\u0006\u0010-\u001a\u00020\t\u001a\u0012\u00104\u001a\u00020\u0001*\u00020\u001c2\u0006\u0010-\u001a\u00020\u001c\u001a4\u00105\u001a\u00020\u001c\"\u0004\b\u0000\u00106*\n\u0012\u0006\b\u0001\u0012\u0002H6072\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u0002H6\u0012\u0004\u0012\u00020\u001c09H\u0086\b\u00a2\u0006\u0002\u0010:\u001a\n\u0010;\u001a\u00020\u0004*\u00020\u0006\u001a\u0012\u0010<\u001a\u00020\u001f*\u00020\u001f2\u0006\u0010-\u001a\u00020\u001f\u001a\"\u0010<\u001a\u00020\u001f*\u00020\u001f2\u0006\u0010=\u001a\u00020\u00012\u0006\u0010>\u001a\u00020\u00012\u0006\u0010?\u001a\u00020\u0001\u001a\"\u0010<\u001a\u00020\t*\u00020\t2\u0006\u0010=\u001a\u00020\b2\u0006\u0010>\u001a\u00020\b2\u0006\u0010?\u001a\u00020\b\u001a\u0012\u0010<\u001a\u00020\t*\u00020\t2\u0006\u0010-\u001a\u00020\t\u001a\"\u0010<\u001a\u00020\u001c*\u00020\u001c2\u0006\u0010=\u001a\u00020\u00012\u0006\u0010>\u001a\u00020\u00012\u0006\u0010?\u001a\u00020\u0001\u001a\u0012\u0010<\u001a\u00020\u001c*\u00020\u001c2\u0006\u0010-\u001a\u00020\u001c\u001a\u0012\u0010@\u001a\u00020\u001f*\u00020\u001f2\u0006\u0010-\u001a\u00020\u001f\u001a\"\u0010@\u001a\u00020\u001f*\u00020\u001f2\u0006\u0010=\u001a\u00020\u00012\u0006\u0010>\u001a\u00020\u00012\u0006\u0010?\u001a\u00020\u0001\u001a\"\u0010@\u001a\u00020\t*\u00020\t2\u0006\u0010=\u001a\u00020\b2\u0006\u0010>\u001a\u00020\b2\u0006\u0010?\u001a\u00020\b\u001a\u0012\u0010@\u001a\u00020\t*\u00020\t2\u0006\u0010-\u001a\u00020\t\u001a\"\u0010@\u001a\u00020\u001c*\u00020\u001c2\u0006\u0010=\u001a\u00020\u00012\u0006\u0010>\u001a\u00020\u00012\u0006\u0010?\u001a\u00020\u0001\u001a\u0012\u0010@\u001a\u00020\u001c*\u00020\u001c2\u0006\u0010-\u001a\u00020\u001c\u001a\u0012\u0010A\u001a\u00020\u001f*\u00020\u001f2\u0006\u0010-\u001a\u00020\u001f\u001a\u0012\u0010A\u001a\u00020\t*\u00020\t2\u0006\u0010-\u001a\u00020\t\u001a\u0012\u0010A\u001a\u00020\u001c*\u00020\u001c2\u0006\u0010-\u001a\u00020\u001c\u001a\u0012\u0010B\u001a\u00020#*\u00020\u001c2\u0006\u0010-\u001a\u00020\u001c\u001a\u0012\u0010C\u001a\u00020\u0001*\u00020\u001f2\u0006\u0010-\u001a\u00020\u001f\u001a\u0012\u0010C\u001a\u00020\b*\u00020\t2\u0006\u0010-\u001a\u00020\t\u001a\u0012\u0010C\u001a\u00020\u0001*\u00020\u001c2\u0006\u0010-\u001a\u00020\u001c\u001a\u0012\u0010D\u001a\u00020\u0001*\u00020\u001f2\u0006\u0010-\u001a\u00020\u001f\u001a\u0012\u0010D\u001a\u00020\b*\u00020\t2\u0006\u0010-\u001a\u00020\t\u001a\u0012\u0010D\u001a\u00020\u0001*\u00020\u001c2\u0006\u0010-\u001a\u00020\u001c\u001a\u0015\u0010E\u001a\u00020\u001f*\u00020\u001f2\u0006\u0010F\u001a\u00020\u001fH\u0086\u0002\u001a\u0015\u0010E\u001a\u00020\u001f*\u00020\u001f2\u0006\u0010G\u001a\u00020\u0001H\u0086\u0002\u001a\"\u0010E\u001a\u00020\u001f*\u00020\u001f2\u0006\u0010/\u001a\u00020\u00012\u0006\u00100\u001a\u00020\u00012\u0006\u00101\u001a\u00020\u0001\u001a\u0015\u0010E\u001a\u00020\t*\u00020\t2\u0006\u0010G\u001a\u00020\bH\u0086\u0002\u001a\"\u0010E\u001a\u00020\t*\u00020\t2\u0006\u0010/\u001a\u00020\b2\u0006\u00100\u001a\u00020\b2\u0006\u00101\u001a\u00020\b\u001a\u0015\u0010E\u001a\u00020\t*\u00020\t2\u0006\u0010F\u001a\u00020\tH\u0086\u0002\u001a\u0015\u0010E\u001a\u00020\u001c*\u00020\u001c2\u0006\u0010G\u001a\u00020\u0001H\u0086\u0002\u001a\"\u0010E\u001a\u00020\u001c*\u00020\u001c2\u0006\u0010/\u001a\u00020\u00012\u0006\u00100\u001a\u00020\u00012\u0006\u00101\u001a\u00020\u0001\u001a\u0015\u0010E\u001a\u00020\u001c*\u00020\u001c2\u0006\u0010F\u001a\u00020\u001cH\u0086\u0002\u001a\u0015\u0010H\u001a\u00020#*\u00020\u001f2\u0006\u0010F\u001a\u00020\u001fH\u0086\u0002\u001a\u0015\u0010H\u001a\u00020#*\u00020\u001f2\u0006\u0010G\u001a\u00020\u0001H\u0086\u0002\u001a\u0015\u0010H\u001a\u00020#*\u00020\t2\u0006\u0010G\u001a\u00020\bH\u0086\u0002\u001a\u0015\u0010H\u001a\u00020#*\u00020\t2\u0006\u0010F\u001a\u00020\tH\u0086\u0002\u001a\u0015\u0010H\u001a\u00020#*\u00020\u001c2\u0006\u0010G\u001a\u00020\u0001H\u0086\u0002\u001a\u0015\u0010H\u001a\u00020#*\u00020\u001c2\u0006\u0010F\u001a\u00020\u001cH\u0086\u0002\u001a\u0012\u0010I\u001a\u00020\u001f*\u00020\u001f2\u0006\u0010-\u001a\u00020\u001f\u001a\u0012\u0010I\u001a\u00020\t*\u00020\t2\u0006\u0010-\u001a\u00020\t\u001a\u0012\u0010I\u001a\u00020\u001c*\u00020\u001c2\u0006\u0010-\u001a\u00020\u001c\u001a\u0012\u0010J\u001a\u00020\u001f*\u00020\u001f2\u0006\u0010-\u001a\u00020\u001f\u001a\"\u0010J\u001a\u00020\u001f*\u00020\u001f2\u0006\u0010/\u001a\u00020\u00012\u0006\u00100\u001a\u00020\u00012\u0006\u00101\u001a\u00020\u0001\u001a\"\u0010J\u001a\u00020\t*\u00020\t2\u0006\u0010/\u001a\u00020\b2\u0006\u00100\u001a\u00020\b2\u0006\u00101\u001a\u00020\b\u001a\u0012\u0010J\u001a\u00020\t*\u00020\t2\u0006\u0010-\u001a\u00020\t\u001a\"\u0010J\u001a\u00020#*\u00020\u001c2\u0006\u0010/\u001a\u00020\u00012\u0006\u00100\u001a\u00020\u00012\u0006\u00101\u001a\u00020\u0001\u001a\u0012\u0010J\u001a\u00020#*\u00020\u001c2\u0006\u0010-\u001a\u00020\u001c\u001a\u0012\u0010K\u001a\u00020\u0001*\u00020\u001f2\u0006\u0010-\u001a\u00020\u001f\u001a\u0012\u0010K\u001a\u00020\b*\u00020\t2\u0006\u0010-\u001a\u00020\t\u001a\u0012\u0010K\u001a\u00020\u0001*\u00020\u001c2\u0006\u0010-\u001a\u00020\u001c\u001a\n\u0010L\u001a\u00020\u001f*\u00020\u001f\u001a\n\u0010L\u001a\u00020\t*\u00020\t\u001a\n\u0010L\u001a\u00020\u001c*\u00020\u001c\u001a\n\u0010M\u001a\u00020\u001f*\u00020\u001f\u001a\n\u0010M\u001a\u00020\t*\u00020\t\u001a\n\u0010M\u001a\u00020\u001c*\u00020\u001c\u001a\n\u0010N\u001a\u00020\u001f*\u00020\u001f\u001a\n\u0010N\u001a\u00020\t*\u00020\t\u001a\n\u0010N\u001a\u00020#*\u00020\u001c\u001a\n\u0010O\u001a\u00020\u001f*\u00020\u001f\u001a\n\u0010O\u001a\u00020\t*\u00020\t\u001a\n\u0010O\u001a\u00020#*\u00020\u001c\u001a\n\u0010P\u001a\u00020\u0006*\u00020\u0006\u001a\u0012\u0010Q\u001a\u00020R*\u00020\u001f2\u0006\u0010-\u001a\u00020\u001f\u001a\u0012\u0010Q\u001a\u00020R*\u00020\t2\u0006\u0010-\u001a\u00020\t\u001a\u0012\u0010Q\u001a\u00020R*\u00020\u001c2\u0006\u0010-\u001a\u00020\u001c\u001a\n\u0010S\u001a\u00020R*\u00020\u001f\u001a\n\u0010S\u001a\u00020R*\u00020\t\u001a\n\u0010S\u001a\u00020R*\u00020\u001c\u001a\n\u0010T\u001a\u00020R*\u00020\u001f\u001a\n\u0010T\u001a\u00020R*\u00020\t\u001a\n\u0010T\u001a\u00020R*\u00020\u001c\u001a\n\u0010U\u001a\u00020\b*\u00020\t\u001a\n\u0010V\u001a\u00020\b*\u00020\t\u001a\u001a\u0010W\u001a\u00020\t*\u00020\u00012\u0006\u0010X\u001a\u00020\t2\u0006\u0010Y\u001a\u00020\t\u001a\u001a\u0010Z\u001a\u00020\u0006*\u00020\u00062\u0006\u0010[\u001a\u00020\u001c2\u0006\u0010\\\u001a\u00020\u001c\u001a\u0015\u0010]\u001a\u00020\u001f*\u00020\u001f2\u0006\u0010F\u001a\u00020\u001fH\u0086\u0002\u001a\u0015\u0010]\u001a\u00020\u001f*\u00020\u001f2\u0006\u0010G\u001a\u00020\u0001H\u0086\u0002\u001a\u0015\u0010]\u001a\u00020\t*\u00020\t2\u0006\u0010G\u001a\u00020\bH\u0086\u0002\u001a\u0015\u0010]\u001a\u00020\t*\u00020\t2\u0006\u0010F\u001a\u00020\tH\u0086\u0002\u001a\u0015\u0010]\u001a\u00020\u001c*\u00020\u001c2\u0006\u0010G\u001a\u00020\u0001H\u0086\u0002\u001a\u0015\u0010]\u001a\u00020\u001c*\u00020\u001c2\u0006\u0010F\u001a\u00020\u001cH\u0086\u0002\u001a\u0015\u0010^\u001a\u00020#*\u00020\u001f2\u0006\u0010F\u001a\u00020\u001fH\u0086\u0002\u001a\u0015\u0010^\u001a\u00020#*\u00020\u001f2\u0006\u0010G\u001a\u00020\u0001H\u0086\u0002\u001a\u0015\u0010^\u001a\u00020#*\u00020\t2\u0006\u0010G\u001a\u00020\bH\u0086\u0002\u001a\u0015\u0010^\u001a\u00020#*\u00020\t2\u0006\u0010F\u001a\u00020\tH\u0086\u0002\u001a\u0015\u0010^\u001a\u00020#*\u00020\u001c2\u0006\u0010G\u001a\u00020\u0001H\u0086\u0002\u001a\u0015\u0010^\u001a\u00020#*\u00020\u001c2\u0006\u0010F\u001a\u00020\u001cH\u0086\u0002\u001a\u0012\u0010_\u001a\u00020\u001f*\u00020\u001f2\u0006\u0010*\u001a\u00020\u0001\u001a\"\u0010_\u001a\u00020\u001f*\u00020\u001f2\u0006\u0010/\u001a\u00020\u00012\u0006\u00100\u001a\u00020\u00012\u0006\u00101\u001a\u00020\u0001\u001a\u0012\u0010_\u001a\u00020\t*\u00020\t2\u0006\u0010*\u001a\u00020\b\u001a\"\u0010_\u001a\u00020\t*\u00020\t2\u0006\u0010/\u001a\u00020\b2\u0006\u00100\u001a\u00020\b2\u0006\u00101\u001a\u00020\b\u001a\u0012\u0010_\u001a\u00020\u001c*\u00020\u001c2\u0006\u0010*\u001a\u00020\u0001\u001a\"\u0010_\u001a\u00020\u001c*\u00020\u001c2\u0006\u0010/\u001a\u00020\u00012\u0006\u00100\u001a\u00020\u00012\u0006\u00101\u001a\u00020\u0001\u001a\u0012\u0010`\u001a\u00020\u001f*\u00020\u001f2\u0006\u0010-\u001a\u00020\u001f\u001a\u0012\u0010`\u001a\u00020\t*\u00020\t2\u0006\u0010-\u001a\u00020\t\u001a\u0012\u0010`\u001a\u00020\u001c*\u00020\u001c2\u0006\u0010-\u001a\u00020\u001c\u001a\u0012\u0010a\u001a\u00020\u001f*\u00020\u001f2\u0006\u0010-\u001a\u00020\u001f\u001a\u0012\u0010a\u001a\u00020\u001f*\u00020\u001f2\u0006\u0010*\u001a\u00020\u0001\u001a\"\u0010a\u001a\u00020\u001f*\u00020\u001f2\u0006\u0010/\u001a\u00020\u00012\u0006\u00100\u001a\u00020\u00012\u0006\u00101\u001a\u00020\u0001\u001a\u0012\u0010a\u001a\u00020\t*\u00020\t2\u0006\u0010*\u001a\u00020\b\u001a\"\u0010a\u001a\u00020\t*\u00020\t2\u0006\u0010/\u001a\u00020\b2\u0006\u00100\u001a\u00020\b2\u0006\u00101\u001a\u00020\b\u001a\u0012\u0010a\u001a\u00020\t*\u00020\t2\u0006\u0010-\u001a\u00020\t\u001a\u0012\u0010a\u001a\u00020#*\u00020\u001c2\u0006\u0010*\u001a\u00020\u0001\u001a\"\u0010a\u001a\u00020#*\u00020\u001c2\u0006\u0010/\u001a\u00020\u00012\u0006\u00100\u001a\u00020\u00012\u0006\u00101\u001a\u00020\u0001\u001a\u0012\u0010a\u001a\u00020#*\u00020\u001c2\u0006\u0010-\u001a\u00020\u001c\u001a\n\u0010b\u001a\u00020\u0001*\u00020\u001f\u001a\n\u0010b\u001a\u00020\b*\u00020\t\u001a\n\u0010b\u001a\u00020\u0001*\u00020\u001c\u001a\n\u0010c\u001a\u00020\u001f*\u00020\u001f\u001a\n\u0010c\u001a\u00020\t*\u00020\t\u001a\n\u0010c\u001a\u00020\u001c*\u00020\u001c\u001a\n\u0010d\u001a\u00020\u001f*\u00020\u001f\u001a\n\u0010d\u001a\u00020\t*\u00020\t\u001a\n\u0010d\u001a\u00020#*\u00020\u001c\u001a\u0012\u0010e\u001a\u00020\u001f*\u00020\u001f2\u0006\u0010G\u001a\u00020\u0001\u001a\u0012\u0010e\u001a\u00020\t*\u00020\t2\u0006\u0010G\u001a\u00020\b\u001a\u0012\u0010e\u001a\u00020\u001c*\u00020\u001c2\u0006\u0010G\u001a\u00020\u0001\u001a\u0012\u0010f\u001a\u00020\u001f*\u00020\u001f2\u0006\u0010G\u001a\u00020\u0001\u001a\u0012\u0010f\u001a\u00020\t*\u00020\t2\u0006\u0010G\u001a\u00020\b\u001a\u0012\u0010f\u001a\u00020#*\u00020\u001c2\u0006\u0010G\u001a\u00020\u0001\u001a\u0015\u0010g\u001a\u00020\u001f*\u00020\u001f2\u0006\u0010F\u001a\u00020\u001fH\u0086\u0002\u001a\u0015\u0010g\u001a\u00020\u001f*\u00020\u001f2\u0006\u0010G\u001a\u00020\u0001H\u0086\u0002\u001a\u0015\u0010g\u001a\u00020\t*\u00020\t2\u0006\u0010G\u001a\u00020\bH\u0086\u0002\u001a\u0015\u0010g\u001a\u00020\t*\u00020\t2\u0006\u0010F\u001a\u00020\tH\u0086\u0002\u001a\u0015\u0010g\u001a\u00020\u001c*\u00020\u001c2\u0006\u0010G\u001a\u00020\u0001H\u0086\u0002\u001a\u0015\u0010g\u001a\u00020\u001c*\u00020\u001c2\u0006\u0010F\u001a\u00020\u001cH\u0086\u0002\u001a\u0015\u0010h\u001a\u00020#*\u00020\u001f2\u0006\u0010F\u001a\u00020\u001fH\u0086\u0002\u001a\u0015\u0010h\u001a\u00020#*\u00020\u001f2\u0006\u0010G\u001a\u00020\u0001H\u0086\u0002\u001a\u0015\u0010h\u001a\u00020#*\u00020\t2\u0006\u0010G\u001a\u00020\bH\u0086\u0002\u001a\u0015\u0010h\u001a\u00020#*\u00020\t2\u0006\u0010F\u001a\u00020\tH\u0086\u0002\u001a\u0015\u0010h\u001a\u00020#*\u00020\u001c2\u0006\u0010G\u001a\u00020\u0001H\u0086\u0002\u001a\u0015\u0010h\u001a\u00020#*\u00020\u001c2\u0006\u0010F\u001a\u00020\u001cH\u0086\u0002\u001a\"\u0010 \u001a\u00020\u001f*\u00020\u001f2\u0006\u0010/\u001a\u00020\u00012\u0006\u00100\u001a\u00020\u00012\u0006\u00101\u001a\u00020\u0001\u001a\"\u0010 \u001a\u00020\t*\u00020\t2\u0006\u0010/\u001a\u00020\b2\u0006\u00100\u001a\u00020\b2\u0006\u00101\u001a\u00020\b\u001a\"\u0010 \u001a\u00020\u001c*\u00020\u001c2\u0006\u0010/\u001a\u00020\u00012\u0006\u00100\u001a\u00020\u00012\u0006\u00101\u001a\u00020\u0001\u001a\u0012\u0010i\u001a\u00020\u001f*\u00020\u001f2\u0006\u0010-\u001a\u00020\u001f\u001a\u0012\u0010i\u001a\u00020\t*\u00020\t2\u0006\u0010-\u001a\u00020\t\u001a\u0012\u0010i\u001a\u00020\u001c*\u00020\u001c2\u0006\u0010-\u001a\u00020\u001c\u001a\u0012\u0010j\u001a\u00020\u001f*\u00020\u001f2\u0006\u0010-\u001a\u00020\u001f\u001a\"\u0010j\u001a\u00020\u001f*\u00020\u001f2\u0006\u0010/\u001a\u00020\u00012\u0006\u00100\u001a\u00020\u00012\u0006\u00101\u001a\u00020\u0001\u001a\"\u0010j\u001a\u00020\t*\u00020\t2\u0006\u0010/\u001a\u00020\b2\u0006\u00100\u001a\u00020\b2\u0006\u00101\u001a\u00020\b\u001a\u0012\u0010j\u001a\u00020\t*\u00020\t2\u0006\u0010-\u001a\u00020\t\u001a\"\u0010j\u001a\u00020#*\u00020\u001c2\u0006\u0010/\u001a\u00020\u00012\u0006\u00100\u001a\u00020\u00012\u0006\u00101\u001a\u00020\u0001\u001a\u0012\u0010j\u001a\u00020#*\u00020\u001c2\u0006\u0010-\u001a\u00020\u001c\u001a\n\u0010k\u001a\u00020#*\u00020\t\u001a\n\u0010l\u001a\u00020\u001f*\u00020\u001f\u001a\n\u0010l\u001a\u00020\t*\u00020\t\u001a\n\u0010l\u001a\u00020#*\u00020\u001c\u001a\n\u0010m\u001a\u00020\u001f*\u00020\u001f\u001a\n\u0010m\u001a\u00020\t*\u00020\t\u001a\n\u0010m\u001a\u00020\u001c*\u00020\u001c\u001a\n\u0010n\u001a\u00020\u001f*\u00020\u001f\u001a\n\u0010n\u001a\u00020\t*\u00020\t\u001a\n\u0010n\u001a\u00020#*\u00020\u001c\u001a\u0012\u0010o\u001a\u00020\u0004*\u00020\u00042\u0006\u0010$\u001a\u00020\u0006\u001a\u0012\u0010o\u001a\u00020\u001f*\u00020\u001f2\u0006\u0010-\u001a\u00020\t\u001a\u0012\u0010o\u001a\u00020\u001f*\u00020\u001f2\u0006\u0010-\u001a\u00020\u001c\u001a\u0012\u0010o\u001a\u00020\t*\u00020\t2\u0006\u0010-\u001a\u00020\u001f\u001a\"\u0010o\u001a\u00020#*\u00020\t2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\b\u001a\u0012\u0010o\u001a\u00020#*\u00020\t2\u0006\u0010-\u001a\u00020\t\u001a\u0012\u0010o\u001a\u00020\t*\u00020\t2\u0006\u0010-\u001a\u00020\u001c\u001a\u0012\u0010o\u001a\u00020\u0006*\u00020\u00062\u0006\u0010$\u001a\u00020\u0004\u001a\u0012\u0010o\u001a\u00020#*\u00020\u001c2\u0006\u0010-\u001a\u00020\u001f\u001a\u0012\u0010o\u001a\u00020#*\u00020\u001c2\u0006\u0010-\u001a\u00020\t\u001a\"\u0010p\u001a\u00020#*\u00020\u00062\u0006\u0010q\u001a\u00020\u00012\u0006\u0010r\u001a\u00020\u00012\u0006\u0010s\u001a\u00020\u0001\u001a\u0012\u0010t\u001a\u00020#*\u00020\t2\u0006\u0010-\u001a\u00020\t\u001a*\u0010u\u001a\u00020#*\u00020\t2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010v\u001a\u00020\b\u001a\"\u0010u\u001a\u00020#*\u00020\t2\u0006\u0010w\u001a\u00020\t2\u0006\u0010x\u001a\u00020\t2\u0006\u0010v\u001a\u00020\b\u001a\"\u0010y\u001a\u00020\u001f*\u00020\u001f2\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001\u001a\"\u0010y\u001a\u00020\t*\u00020\t2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\b\u001a\"\u0010y\u001a\u00020#*\u00020\u001c2\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001\u001a\"\u0010z\u001a\u00020\u001f*\u00020\u001f2\u0006\u0010/\u001a\u00020\u00012\u0006\u00100\u001a\u00020\u00012\u0006\u00101\u001a\u00020\u0001\u001a\"\u0010z\u001a\u00020\t*\u00020\t2\u0006\u0010/\u001a\u00020\b2\u0006\u00100\u001a\u00020\b2\u0006\u00101\u001a\u00020\b\u001a*\u0010z\u001a\n ,*\u0004\u0018\u00010\t0\t*\u00020\t2\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001\u001a\"\u0010z\u001a\u00020\u001c*\u00020\u001c2\u0006\u0010/\u001a\u00020\u00012\u0006\u00100\u001a\u00020\u00012\u0006\u00101\u001a\u00020\u0001\u001a*\u0010{\u001a\n ,*\u0004\u0018\u00010\t0\t*\u00020\t2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\b\u001a*\u0010{\u001a\n ,*\u0004\u0018\u00010\t0\t*\u00020\t2\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001\u001a\u001a\u0010{\u001a\n ,*\u0004\u0018\u00010\t0\t*\u00020\t2\u0006\u0010-\u001a\u00020\t\u001a\u0012\u0010|\u001a\u00020\u001f*\u00020\u001f2\u0006\u0010-\u001a\u00020\u001f\u001a\u0012\u0010|\u001a\u00020\t*\u00020\t2\u0006\u0010-\u001a\u00020\t\u001a\u0012\u0010|\u001a\u00020\u001c*\u00020\u001c2\u0006\u0010-\u001a\u00020\u001c\u001a\u0012\u0010}\u001a\u00020\u001f*\u00020\u001f2\u0006\u0010-\u001a\u00020\u001f\u001a\"\u0010}\u001a\u00020\u001f*\u00020\u001f2\u0006\u0010/\u001a\u00020\u00012\u0006\u00100\u001a\u00020\u00012\u0006\u00101\u001a\u00020\u0001\u001a\"\u0010}\u001a\u00020\t*\u00020\t2\u0006\u0010/\u001a\u00020\b2\u0006\u00100\u001a\u00020\b2\u0006\u00101\u001a\u00020\b\u001a\u0012\u0010}\u001a\u00020\t*\u00020\t2\u0006\u0010-\u001a\u00020\t\u001a\"\u0010}\u001a\u00020#*\u00020\u001c2\u0006\u0010/\u001a\u00020\u00012\u0006\u00100\u001a\u00020\u00012\u0006\u00101\u001a\u00020\u0001\u001a\u0012\u0010}\u001a\u00020#*\u00020\u001c2\u0006\u0010-\u001a\u00020\u001c\u001a4\u0010~\u001a\u00020\u001c\"\u0004\b\u0000\u00106*\n\u0012\u0006\b\u0001\u0012\u0002H6072\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u0002H6\u0012\u0004\u0012\u00020\u001c09H\u0086\b\u00a2\u0006\u0002\u0010:\u001a\u0015\u0010\u007f\u001a\u00020\u001f*\u00020\u001f2\u0006\u0010F\u001a\u00020\u001fH\u0086\u0002\u001a\u0015\u0010\u007f\u001a\u00020\u001f*\u00020\u001f2\u0006\u0010G\u001a\u00020\u0001H\u0086\u0002\u001a\u0015\u0010\u007f\u001a\u00020\t*\u00020\t2\u0006\u0010G\u001a\u00020\bH\u0086\u0002\u001a\u0015\u0010\u007f\u001a\u00020\t*\u00020\t2\u0006\u0010F\u001a\u00020\tH\u0086\u0002\u001a\u0015\u0010\u007f\u001a\u00020\u001c*\u00020\u001c2\u0006\u0010G\u001a\u00020\u0001H\u0086\u0002\u001a\u0015\u0010\u007f\u001a\u00020\u001c*\u00020\u001c2\u0006\u0010F\u001a\u00020\u001cH\u0086\u0002\u001a\u0016\u0010\u0080\u0001\u001a\u00020#*\u00020\u001f2\u0006\u0010F\u001a\u00020\u001fH\u0086\u0002\u001a\u0016\u0010\u0080\u0001\u001a\u00020#*\u00020\u001f2\u0006\u0010G\u001a\u00020\u0001H\u0086\u0002\u001a\u0016\u0010\u0080\u0001\u001a\u00020#*\u00020\t2\u0006\u0010G\u001a\u00020\bH\u0086\u0002\u001a\u0016\u0010\u0080\u0001\u001a\u00020#*\u00020\t2\u0006\u0010F\u001a\u00020\tH\u0086\u0002\u001a\u0016\u0010\u0080\u0001\u001a\u00020#*\u00020\u001c2\u0006\u0010G\u001a\u00020\u0001H\u0086\u0002\u001a\u0016\u0010\u0080\u0001\u001a\u00020#*\u00020\u001c2\u0006\u0010F\u001a\u00020\u001cH\u0086\u0002\u001a\u000b\u0010\u0081\u0001\u001a\u00020\u001c*\u00020\u001f\u001a\u000b\u0010\u0081\u0001\u001a\u00020\u001c*\u00020\t\u001a\u000b\u0010\u0082\u0001\u001a\u00020\t*\u00020\u001f\u001a\u000b\u0010\u0082\u0001\u001a\u00020\t*\u00020\u001c\u001a\u000b\u0010\u0083\u0001\u001a\u00020\u001f*\u00020\t\u001a\u000b\u0010\u0083\u0001\u001a\u00020\u001f*\u00020\u001c\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082D\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082D\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\"\u0015\u0010\u0007\u001a\u00020\b*\u00020\t8F\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000b\"\u0015\u0010\f\u001a\u00020\b*\u00020\t8F\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000b\"\u0015\u0010\u000e\u001a\u00020\u0001*\u00020\t8F\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\"\u0015\u0010\u0011\u001a\u00020\b*\u00020\t8F\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u000b\"\u0015\u0010\u0013\u001a\u00020\b*\u00020\t8F\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u000b\"\u0015\u0010\u0015\u001a\u00020\u0001*\u00020\t8F\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0010\"\u0015\u0010\u0017\u001a\u00020\b*\u00020\t8F\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u000b\"\u0015\u0010\u0019\u001a\u00020\u0001*\u00020\t8F\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u0010\u00a8\u0006\u0084\u0001"}, d2={"DOT_EPSILON", "", "EPSILON", "_q", "Ljavax/vecmath/Quat4f;", "q1", "Lorg/lwjgl/util/vector/Quaternion;", "lengthSq", "", "Lnet/minecraft/util/Vec3;", "getLengthSq", "(Lnet/minecraft/util/Vec3;)D", "x", "getX", "xf", "getXf", "(Lnet/minecraft/util/Vec3;)F", "xzLengthSq", "getXzLengthSq", "y", "getY", "yf", "getYf", "z", "getZ", "zf", "getZf", "createVec3gl", "Lorg/lwjgl/util/vector/Vector3f;", "createVec3mc", "createVec3vm", "Ljavax/vecmath/Vector3f;", "pow", "base", "rotate", "", "q", "angle", "ax", "ay", "az", "sqrt", "f", "vec3", "kotlin.jvm.PlatformType", "v", "add", "dx", "dy", "dz", "addVector", "addl", "angleBetween", "averageBy", "T", "", "selector", "Lkotlin/Function1;", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Lorg/lwjgl/util/vector/Vector3f;", "bltQuat", "clampMax", "vx", "vy", "vz", "clampMaxl", "cross", "crossl", "distance", "distanceSq", "div", "vec", "scalar", "divAssign", "divVector", "dividel", "dot", "floor", "floor_double", "floor_doublel", "floorl", "inverse", "isEqual", "", "isNan", "isUnit", "length", "lengthSquared", "lerp", "v0", "v1", "lookRotation", "forward", "up", "minus", "minusAssign", "mul", "mulVector", "mull", "nonZeroLength", "normalized", "normalizel", "offseted", "offsetl", "plus", "plusAssign", "powVector", "powl", "reset", "resetl", "round", "roundl", "set", "setFromEuler", "pitch", "yaw", "roll", "setMax", "setMix", "lerpValue", "from", "to", "setl", "sub", "subInv", "subVector", "subl", "sumBy", "times", "timesAssign", "toGl", "toMc", "toVm", "minecraft"})
public final class VecExtensionsKt {
    private static final Quat4f _q = new Quat4f();
    private static final Quaternion q1 = new Quaternion();
    private static final float EPSILON = 1.0E-4f;
    private static final float DOT_EPSILON = 0.9995f;

    private static final float pow(float f, float f2) {
        return (float)Math.pow(f, f2);
    }

    private static final float sqrt(float f) {
        return (float)Math.sqrt(f);
    }

    private static final double pow(double d, double d2) {
        return Math.pow(d, d2);
    }

    private static final double sqrt(double d) {
        return Math.sqrt(d);
    }

    @NotNull
    public static final Quaternion lookRotation(@NotNull Quaternion quaternion, @NotNull org.lwjgl.util.vector.Vector3f vector3f, @NotNull org.lwjgl.util.vector.Vector3f vector3f2) {
        org.lwjgl.util.vector.Vector3f vector3f3;
        Intrinsics.checkParameterIsNotNull(quaternion, "$receiver");
        Intrinsics.checkParameterIsNotNull(vector3f, "forward");
        Intrinsics.checkParameterIsNotNull(vector3f2, "up");
        if (VecExtensionsKt.isEqual(vector3f, vector3f2)) {
            Quaternion quaternion2 = quaternion.setIdentity();
            Intrinsics.checkExpressionValueIsNotNull(quaternion2, "setIdentity()");
            return quaternion2;
        }
        org.lwjgl.util.vector.Vector3f vector3f4 = vector3f3 = vector3f.normalise(null);
        Intrinsics.checkExpressionValueIsNotNull(vector3f4, "vector");
        float f = VecExtensionsKt.dot(vector3f2, vector3f4);
        if (owkq._e(f) > DOT_EPSILON) {
            Quaternion quaternion3 = quaternion.setIdentity();
            Intrinsics.checkExpressionValueIsNotNull(quaternion3, "setIdentity()");
            return quaternion3;
        }
        org.lwjgl.util.vector.Vector3f vector3f5 = org.lwjgl.util.vector.Vector3f.cross(vector3f2, vector3f3, null);
        vector3f5.normalise();
        org.lwjgl.util.vector.Vector3f vector3f6 = org.lwjgl.util.vector.Vector3f.cross(vector3f3, vector3f5, null);
        float f2 = vector3f5.x;
        float f3 = vector3f5.y;
        float f4 = vector3f5.z;
        float f5 = vector3f6.x;
        float f6 = vector3f6.y;
        float f7 = vector3f6.z;
        float f8 = vector3f3.x;
        float f9 = vector3f3.y;
        float f10 = vector3f3.z;
        double d = f2 + f6 + f10;
        if (d > 0.0) {
            float f11 = owkq._j(Math.sqrt(d + 1.0));
            quaternion.w = f11 * 0.5f;
            f11 = 0.5f / f11;
            quaternion.x = (f7 - f9) * f11;
            quaternion.y = (f8 - f4) * f11;
            quaternion.z = (f3 - f5) * f11;
            return quaternion;
        }
        if (f2 >= f6 && f2 >= f10) {
            float f12 = owkq._j(Math.sqrt(1.0 + (double)f2 - (double)f6 - (double)f10));
            float f13 = 0.5f / f12;
            quaternion.x = 0.5f * f12;
            quaternion.y = (f3 + f5) * f13;
            quaternion.z = (f4 + f8) * f13;
            quaternion.w = (f7 - f9) * f13;
            return quaternion;
        }
        if (f6 > f10) {
            float f14 = owkq._j(Math.sqrt(1.0 + (double)f6 - (double)f2 - (double)f10));
            float f15 = 0.5f / f14;
            quaternion.x = (f5 + f3) * f15;
            quaternion.y = 0.5f * f14;
            quaternion.z = (f9 + f7) * f15;
            quaternion.w = (f8 - f4) * f15;
            return quaternion;
        }
        float f16 = owkq._j(Math.sqrt(1.0 + (double)f10 - (double)f2 - (double)f6));
        float f17 = 0.5f / f16;
        quaternion.x = (f8 + f4) * f17;
        quaternion.y = (f9 + f7) * f17;
        quaternion.z = 0.5f * f16;
        quaternion.w = (f3 - f5) * f17;
        return quaternion;
    }

    @NotNull
    public static final Quat4f set(@NotNull Quat4f quat4f, @NotNull Quaternion quaternion) {
        Intrinsics.checkParameterIsNotNull(quat4f, "$receiver");
        Intrinsics.checkParameterIsNotNull(quaternion, "q");
        quat4f.set(quaternion.x, quaternion.y, quaternion.z, quaternion.w);
        return quat4f;
    }

    @NotNull
    public static final Quaternion set(@NotNull Quaternion quaternion, @NotNull Quat4f quat4f) {
        Intrinsics.checkParameterIsNotNull(quaternion, "$receiver");
        Intrinsics.checkParameterIsNotNull(quat4f, "q");
        quaternion.set(quat4f.x, quat4f.y, quat4f.z, quat4f.w);
        return quaternion;
    }

    @NotNull
    public static final Quat4f bltQuat(@NotNull Quaternion quaternion) {
        Intrinsics.checkParameterIsNotNull(quaternion, "$receiver");
        return VecExtensionsKt.set(new Quat4f(), quaternion);
    }

    @NotNull
    public static final Quaternion inverse(@NotNull Quaternion quaternion) {
        Intrinsics.checkParameterIsNotNull(quaternion, "$receiver");
        VecExtensionsKt.set(_q, quaternion);
        _q.inverse();
        VecExtensionsKt.set(quaternion, _q);
        return quaternion;
    }

    public static final void setFromEuler(@NotNull Quaternion quaternion, float f, float f2, float f3) {
        Intrinsics.checkParameterIsNotNull(quaternion, "$receiver");
        quaternion.setIdentity();
        VecExtensionsKt.rotate(quaternion, f, 1.0f, 0.0f, 0.0f);
        VecExtensionsKt.rotate(quaternion, f2, 0.0f, 1.0f, 0.0f);
        VecExtensionsKt.rotate(quaternion, f3, 0.0f, 0.0f, 1.0f);
    }

    @NotNull
    public static final Vec3 lerp(float f, @NotNull Vec3 vec3, @NotNull Vec3 vec32) {
        Intrinsics.checkParameterIsNotNull(vec3, "v0");
        Intrinsics.checkParameterIsNotNull(vec32, "v1");
        Vec3 vec33 = VecExtensionsKt.vec3();
        vec33._c = owkq._a(f, vec3._c, vec32._c);
        vec33._d = owkq._a(f, vec3._d, vec32._d);
        vec33._e = owkq._a(f, vec3._e, vec32._e);
        Vec3 vec34 = vec33;
        Intrinsics.checkExpressionValueIsNotNull(vec34, "v");
        return vec34;
    }

    private static final void rotate(Quaternion quaternion, float f, float f2, float f3, float f4) {
        float f5 = f;
        f5 = f5 * (float)Math.PI / 180.0f;
        float f6 = sajh._a(f5 / (float)2);
        float f7 = sajh._b(f5 / (float)2);
        q1.set(f2 * f6, f3 * f6, f4 * f6, f7);
        Quaternion.mul(quaternion, q1, quaternion);
    }

    public static final void set(@NotNull org.lwjgl.util.vector.Vector3f vector3f, @NotNull Vector3f vector3f2) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        Intrinsics.checkParameterIsNotNull(vector3f2, "v");
        VecExtensionsKt.setl(vector3f, vector3f2.x, vector3f2.y, vector3f2.z);
    }

    public static final void set(@NotNull org.lwjgl.util.vector.Vector3f vector3f, @NotNull Vec3 vec3) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        Intrinsics.checkParameterIsNotNull(vec3, "v");
        VecExtensionsKt.setl(vector3f, VecExtensionsKt.getXf(vec3), VecExtensionsKt.getYf(vec3), VecExtensionsKt.getZf(vec3));
    }

    @NotNull
    public static final Vector3f set(@NotNull Vector3f vector3f, @NotNull Vec3 vec3) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        Intrinsics.checkParameterIsNotNull(vec3, "v");
        return VecExtensionsKt.setl(vector3f, VecExtensionsKt.getXf(vec3), VecExtensionsKt.getYf(vec3), VecExtensionsKt.getZf(vec3));
    }

    @NotNull
    public static final Vector3f set(@NotNull Vector3f vector3f, @NotNull org.lwjgl.util.vector.Vector3f vector3f2) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        Intrinsics.checkParameterIsNotNull(vector3f2, "v");
        return VecExtensionsKt.setl(vector3f, vector3f2.x, vector3f2.y, vector3f2.z);
    }

    @NotNull
    public static final Vec3 set(@NotNull Vec3 vec3, @NotNull Vector3f vector3f) {
        Intrinsics.checkParameterIsNotNull(vec3, "$receiver");
        Intrinsics.checkParameterIsNotNull(vector3f, "v");
        return VecExtensionsKt.setl(vec3, (double)vector3f.x, (double)vector3f.y, (double)vector3f.z);
    }

    @NotNull
    public static final Vec3 set(@NotNull Vec3 vec3, @NotNull org.lwjgl.util.vector.Vector3f vector3f) {
        Intrinsics.checkParameterIsNotNull(vec3, "$receiver");
        Intrinsics.checkParameterIsNotNull(vector3f, "v");
        return VecExtensionsKt.setl(vec3, (double)vector3f.x, (double)vector3f.y, (double)vector3f.z);
    }

    @NotNull
    public static final org.lwjgl.util.vector.Vector3f toGl(@NotNull Vec3 vec3) {
        Intrinsics.checkParameterIsNotNull(vec3, "$receiver");
        return VecExtensionsKt.createVec3gl(VecExtensionsKt.getXf(vec3), VecExtensionsKt.getYf(vec3), VecExtensionsKt.getZf(vec3));
    }

    @NotNull
    public static final Vector3f toVm(@NotNull Vec3 vec3) {
        Intrinsics.checkParameterIsNotNull(vec3, "$receiver");
        return VecExtensionsKt.createVec3vm(VecExtensionsKt.getXf(vec3), VecExtensionsKt.getYf(vec3), VecExtensionsKt.getZf(vec3));
    }

    @NotNull
    public static final Vec3 toMc(@NotNull org.lwjgl.util.vector.Vector3f vector3f) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        return VecExtensionsKt.createVec3mc(vector3f.x, vector3f.y, vector3f.z);
    }

    @NotNull
    public static final Vector3f toVm(@NotNull org.lwjgl.util.vector.Vector3f vector3f) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        return VecExtensionsKt.createVec3vm(vector3f.x, vector3f.y, vector3f.z);
    }

    @NotNull
    public static final Vec3 toMc(@NotNull Vector3f vector3f) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        return VecExtensionsKt.createVec3mc(vector3f.x, vector3f.y, vector3f.z);
    }

    @NotNull
    public static final org.lwjgl.util.vector.Vector3f toGl(@NotNull Vector3f vector3f) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        return VecExtensionsKt.createVec3gl(vector3f.x, vector3f.y, vector3f.z);
    }

    public static final double getX(@NotNull Vec3 vec3) {
        Intrinsics.checkParameterIsNotNull(vec3, "$receiver");
        return vec3._c;
    }

    public static final float getXf(@NotNull Vec3 vec3) {
        Intrinsics.checkParameterIsNotNull(vec3, "$receiver");
        return owkq._j(vec3._c);
    }

    public static final double getY(@NotNull Vec3 vec3) {
        Intrinsics.checkParameterIsNotNull(vec3, "$receiver");
        return vec3._d;
    }

    public static final float getYf(@NotNull Vec3 vec3) {
        Intrinsics.checkParameterIsNotNull(vec3, "$receiver");
        return owkq._j(vec3._d);
    }

    public static final double getZ(@NotNull Vec3 vec3) {
        Intrinsics.checkParameterIsNotNull(vec3, "$receiver");
        return vec3._e;
    }

    public static final float getZf(@NotNull Vec3 vec3) {
        Intrinsics.checkParameterIsNotNull(vec3, "$receiver");
        return owkq._j(vec3._e);
    }

    public static final double getLengthSq(@NotNull Vec3 vec3) {
        Intrinsics.checkParameterIsNotNull(vec3, "$receiver");
        return VecExtensionsKt.getX(vec3) * VecExtensionsKt.getX(vec3) + VecExtensionsKt.getY(vec3) * VecExtensionsKt.getY(vec3) + VecExtensionsKt.getZ(vec3) * VecExtensionsKt.getZ(vec3);
    }

    public static final double getXzLengthSq(@NotNull Vec3 vec3) {
        Intrinsics.checkParameterIsNotNull(vec3, "$receiver");
        return VecExtensionsKt.getX(vec3) * VecExtensionsKt.getX(vec3) + VecExtensionsKt.getZ(vec3) * VecExtensionsKt.getZ(vec3);
    }

    public static final void reset(@NotNull Vec3 vec3) {
        Intrinsics.checkParameterIsNotNull(vec3, "$receiver");
        VecExtensionsKt.set(vec3, 0.0, 0.0, 0.0);
    }

    public static final Vec3 add(@NotNull Vec3 vec3, float f, float f2, float f3) {
        Intrinsics.checkParameterIsNotNull(vec3, "$receiver");
        return Vec3._a(VecExtensionsKt.getX(vec3) + (double)f, VecExtensionsKt.getY(vec3) + (double)f2, VecExtensionsKt.getZ(vec3) + (double)f3);
    }

    public static final Vec3 sub(@NotNull Vec3 vec3, float f, float f2, float f3) {
        Intrinsics.checkParameterIsNotNull(vec3, "$receiver");
        return Vec3._a(VecExtensionsKt.getX(vec3) - (double)f, VecExtensionsKt.getY(vec3) - (double)f2, VecExtensionsKt.getZ(vec3) - (double)f3);
    }

    public static final void setMix(@NotNull Vec3 vec3, @NotNull Vec3 vec32, @NotNull Vec3 vec33, double d) {
        Intrinsics.checkParameterIsNotNull(vec3, "$receiver");
        Intrinsics.checkParameterIsNotNull(vec32, "from");
        Intrinsics.checkParameterIsNotNull(vec33, "to");
        VecExtensionsKt.set(vec3, vec32);
        VecExtensionsKt.setMix(vec3, VecExtensionsKt.getX(vec33), VecExtensionsKt.getY(vec33), VecExtensionsKt.getZ(vec33), d);
    }

    public static final void setMix(@NotNull Vec3 vec3, double d, double d2, double d3, double d4) {
        Intrinsics.checkParameterIsNotNull(vec3, "$receiver");
        vec3._c = owkq._c(d4, vec3._c, d);
        vec3._d = owkq._c(d4, vec3._d, d2);
        vec3._e = owkq._c(d4, vec3._e, d3);
    }

    public static final Vec3 subInv(@NotNull Vec3 vec3, @NotNull Vec3 vec32) {
        Intrinsics.checkParameterIsNotNull(vec3, "$receiver");
        Intrinsics.checkParameterIsNotNull(vec32, "v");
        return VecExtensionsKt.subInv(vec3, VecExtensionsKt.getX(vec32), VecExtensionsKt.getY(vec32), VecExtensionsKt.getZ(vec32));
    }

    public static final Vec3 subInv(@NotNull Vec3 vec3, double d, double d2, double d3) {
        Intrinsics.checkParameterIsNotNull(vec3, "$receiver");
        return Vec3._a(d - VecExtensionsKt.getX(vec3), d2 - VecExtensionsKt.getY(vec3), d3 - VecExtensionsKt.getZ(vec3));
    }

    public static final Vec3 subInv(@NotNull Vec3 vec3, float f, float f2, float f3) {
        Intrinsics.checkParameterIsNotNull(vec3, "$receiver");
        return Vec3._a((double)f - VecExtensionsKt.getX(vec3), (double)f2 - VecExtensionsKt.getY(vec3), (double)f3 - VecExtensionsKt.getZ(vec3));
    }

    public static final void set(@NotNull Vec3 vec3, @NotNull Vec3 vec32) {
        Intrinsics.checkParameterIsNotNull(vec3, "$receiver");
        Intrinsics.checkParameterIsNotNull(vec32, "v");
        vec3._c = VecExtensionsKt.getX(vec32);
        vec3._d = VecExtensionsKt.getY(vec32);
        vec3._e = VecExtensionsKt.getZ(vec32);
    }

    public static final void set(@NotNull Vec3 vec3, double d, double d2, double d3) {
        Intrinsics.checkParameterIsNotNull(vec3, "$receiver");
        vec3._c = d;
        vec3._d = d2;
        vec3._e = d3;
    }

    public static final void setMax(@NotNull Vec3 vec3, @NotNull Vec3 vec32) {
        Intrinsics.checkParameterIsNotNull(vec3, "$receiver");
        Intrinsics.checkParameterIsNotNull(vec32, "v");
        vec3._c = Math.max(vec3._c, vec32._c);
        vec3._d = Math.max(vec3._d, vec32._d);
        vec3._e = Math.max(vec3._e, vec32._e);
    }

    public static final Vec3 vec3() {
        return Vec3._a(0.0, 0.0, 0.0);
    }

    public static final Vec3 vec3(double d) {
        return Vec3._a(d, d, d);
    }

    public static final Vec3 vec3(double d, double d2, double d3) {
        return Vec3._a(d, d2, d3);
    }

    public static final Vec3 vec3(@NotNull Vec3 vec3) {
        Intrinsics.checkParameterIsNotNull(vec3, "v");
        return Vec3._a(VecExtensionsKt.getX(vec3), VecExtensionsKt.getY(vec3), VecExtensionsKt.getZ(vec3));
    }

    private static final org.lwjgl.util.vector.Vector3f createVec3gl(float f, float f2, float f3) {
        return new org.lwjgl.util.vector.Vector3f(f, f2, f3);
    }

    public static final void setl(@NotNull org.lwjgl.util.vector.Vector3f vector3f, float f, float f2, float f3) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        vector3f.set(f, f2, f3);
    }

    public static final void resetl(@NotNull org.lwjgl.util.vector.Vector3f vector3f) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        VecExtensionsKt.setl(vector3f, 0.0f, 0.0f, 0.0f);
    }

    public static final void addl(@NotNull org.lwjgl.util.vector.Vector3f vector3f, float f, float f2, float f3) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        VecExtensionsKt.setl(vector3f, vector3f.x + f, vector3f.y + f2, vector3f.z + f3);
    }

    public static final void addl(@NotNull org.lwjgl.util.vector.Vector3f vector3f, @NotNull org.lwjgl.util.vector.Vector3f vector3f2) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        Intrinsics.checkParameterIsNotNull(vector3f2, "v");
        VecExtensionsKt.setl(vector3f, vector3f.x + vector3f2.x, vector3f.y + vector3f2.y, vector3f.z + vector3f2.z);
    }

    public static final void offsetl(@NotNull org.lwjgl.util.vector.Vector3f vector3f, float f) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        VecExtensionsKt.setl(vector3f, vector3f.x + f, vector3f.y + f, vector3f.z + f);
    }

    public static final void subl(@NotNull org.lwjgl.util.vector.Vector3f vector3f, float f, float f2, float f3) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        VecExtensionsKt.setl(vector3f, vector3f.x - f, vector3f.y - f2, vector3f.z - f3);
    }

    public static final void subl(@NotNull org.lwjgl.util.vector.Vector3f vector3f, @NotNull org.lwjgl.util.vector.Vector3f vector3f2) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        Intrinsics.checkParameterIsNotNull(vector3f2, "v");
        VecExtensionsKt.setl(vector3f, vector3f.x - vector3f2.x, vector3f.y - vector3f2.y, vector3f.z - vector3f2.z);
    }

    public static final void mull(@NotNull org.lwjgl.util.vector.Vector3f vector3f, float f, float f2, float f3) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        VecExtensionsKt.setl(vector3f, vector3f.x * f, vector3f.y * f2, vector3f.z * f3);
    }

    public static final void mull(@NotNull org.lwjgl.util.vector.Vector3f vector3f, @NotNull org.lwjgl.util.vector.Vector3f vector3f2) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        Intrinsics.checkParameterIsNotNull(vector3f2, "v");
        VecExtensionsKt.setl(vector3f, vector3f.x * vector3f2.x, vector3f.y * vector3f2.y, vector3f.z * vector3f2.z);
    }

    public static final void mull(@NotNull org.lwjgl.util.vector.Vector3f vector3f, float f) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        VecExtensionsKt.setl(vector3f, vector3f.x * f, vector3f.y * f, vector3f.z * f);
    }

    public static final void dividel(@NotNull org.lwjgl.util.vector.Vector3f vector3f, float f, float f2, float f3) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        VecExtensionsKt.setl(vector3f, vector3f.x / f, vector3f.y / f2, vector3f.z / f3);
    }

    public static final void dividel(@NotNull org.lwjgl.util.vector.Vector3f vector3f, @NotNull org.lwjgl.util.vector.Vector3f vector3f2) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        Intrinsics.checkParameterIsNotNull(vector3f2, "v");
        VecExtensionsKt.setl(vector3f, vector3f.x / vector3f2.x, vector3f.y / vector3f2.y, vector3f.z / vector3f2.z);
    }

    public static final void powl(@NotNull org.lwjgl.util.vector.Vector3f vector3f, float f, float f2, float f3) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        VecExtensionsKt.setl(vector3f, VecExtensionsKt.pow(vector3f.x, f), VecExtensionsKt.pow(vector3f.y, f2), VecExtensionsKt.pow(vector3f.z, f3));
    }

    public static final void powl(@NotNull org.lwjgl.util.vector.Vector3f vector3f, @NotNull org.lwjgl.util.vector.Vector3f vector3f2) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        Intrinsics.checkParameterIsNotNull(vector3f2, "v");
        VecExtensionsKt.setl(vector3f, VecExtensionsKt.pow(vector3f.x, vector3f2.x), VecExtensionsKt.pow(vector3f.y, vector3f2.y), VecExtensionsKt.pow(vector3f.z, vector3f2.z));
    }

    public static final void normalizel(@NotNull org.lwjgl.util.vector.Vector3f vector3f) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        if ((double)vector3f.lengthSquared() < 1.0E-4) {
            VecExtensionsKt.setl(vector3f, 0.0f, 0.0f, 0.0f);
        } else {
            VecExtensionsKt.mull(vector3f, 1.0f / VecExtensionsKt.nonZeroLength(vector3f));
        }
    }

    public static final void floor_doublel(@NotNull org.lwjgl.util.vector.Vector3f vector3f) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        VecExtensionsKt.setl(vector3f, (float)sajh._c((double)vector3f.x), (float)sajh._c((double)vector3f.y), (float)sajh._c((double)vector3f.z));
    }

    public static final void floorl(@NotNull org.lwjgl.util.vector.Vector3f vector3f) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        VecExtensionsKt.setl(vector3f, (float)Math.floor(vector3f.x), (float)Math.floor(vector3f.y), (float)Math.floor(vector3f.z));
    }

    public static final void roundl(@NotNull org.lwjgl.util.vector.Vector3f vector3f) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        VecExtensionsKt.setl(vector3f, (float)Math.round((double)vector3f.x), (float)Math.round((double)vector3f.y), (float)Math.round((double)vector3f.z));
    }

    @NotNull
    public static final org.lwjgl.util.vector.Vector3f clampMaxl(@NotNull org.lwjgl.util.vector.Vector3f vector3f, @NotNull org.lwjgl.util.vector.Vector3f vector3f2) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        Intrinsics.checkParameterIsNotNull(vector3f2, "v");
        return VecExtensionsKt.clampMaxl(vector3f, vector3f2.x, vector3f2.y, vector3f2.z);
    }

    @NotNull
    public static final org.lwjgl.util.vector.Vector3f clampMaxl(@NotNull org.lwjgl.util.vector.Vector3f vector3f, float f, float f2, float f3) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        float f4 = vector3f.x;
        float f5 = vector3f.y;
        float f6 = vector3f.z;
        if (owkq._e(vector3f.x) > f) {
            f4 = f * owkq._h(vector3f.x);
        }
        if (owkq._e(vector3f.y) > f2) {
            f5 = f2 * owkq._h(vector3f.y);
        }
        if (owkq._e(vector3f.z) > f3) {
            f6 = f3 * owkq._h(vector3f.z);
        }
        vector3f.set(f4, f5, f6);
        return vector3f;
    }

    public static final void plusAssign(@NotNull org.lwjgl.util.vector.Vector3f vector3f, float f) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        VecExtensionsKt.addl(vector3f, f, f, f);
    }

    public static final void minusAssign(@NotNull org.lwjgl.util.vector.Vector3f vector3f, float f) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        VecExtensionsKt.subl(vector3f, f, f, f);
    }

    public static final void timesAssign(@NotNull org.lwjgl.util.vector.Vector3f vector3f, float f) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        VecExtensionsKt.mull(vector3f, f, f, f);
    }

    public static final void divAssign(@NotNull org.lwjgl.util.vector.Vector3f vector3f, float f) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        VecExtensionsKt.dividel(vector3f, f, f, f);
    }

    public static final void plusAssign(@NotNull org.lwjgl.util.vector.Vector3f vector3f, @NotNull org.lwjgl.util.vector.Vector3f vector3f2) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        Intrinsics.checkParameterIsNotNull(vector3f2, "vec");
        VecExtensionsKt.addl(vector3f, vector3f2);
    }

    public static final void minusAssign(@NotNull org.lwjgl.util.vector.Vector3f vector3f, @NotNull org.lwjgl.util.vector.Vector3f vector3f2) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        Intrinsics.checkParameterIsNotNull(vector3f2, "vec");
        VecExtensionsKt.subl(vector3f, vector3f2);
    }

    public static final void timesAssign(@NotNull org.lwjgl.util.vector.Vector3f vector3f, @NotNull org.lwjgl.util.vector.Vector3f vector3f2) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        Intrinsics.checkParameterIsNotNull(vector3f2, "vec");
        VecExtensionsKt.mull(vector3f, vector3f2);
    }

    public static final void divAssign(@NotNull org.lwjgl.util.vector.Vector3f vector3f, @NotNull org.lwjgl.util.vector.Vector3f vector3f2) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        Intrinsics.checkParameterIsNotNull(vector3f2, "vec");
        VecExtensionsKt.dividel(vector3f, vector3f2);
    }

    @NotNull
    public static final org.lwjgl.util.vector.Vector3f add(@NotNull org.lwjgl.util.vector.Vector3f vector3f, float f, float f2, float f3) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        return VecExtensionsKt.createVec3gl(vector3f.x + f, vector3f.y + f2, vector3f.z + f3);
    }

    @NotNull
    public static final org.lwjgl.util.vector.Vector3f addVector(@NotNull org.lwjgl.util.vector.Vector3f vector3f, @NotNull org.lwjgl.util.vector.Vector3f vector3f2) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        Intrinsics.checkParameterIsNotNull(vector3f2, "v");
        return VecExtensionsKt.createVec3gl(vector3f.x + vector3f2.x, vector3f.y + vector3f2.y, vector3f.z + vector3f2.z);
    }

    @NotNull
    public static final org.lwjgl.util.vector.Vector3f offseted(@NotNull org.lwjgl.util.vector.Vector3f vector3f, float f) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        return VecExtensionsKt.createVec3gl(vector3f.x + f, vector3f.y + f, vector3f.z + f);
    }

    @NotNull
    public static final org.lwjgl.util.vector.Vector3f sub(@NotNull org.lwjgl.util.vector.Vector3f vector3f, float f, float f2, float f3) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        return VecExtensionsKt.createVec3gl(vector3f.x - f, vector3f.y - f2, vector3f.z - f3);
    }

    @NotNull
    public static final org.lwjgl.util.vector.Vector3f subVector(@NotNull org.lwjgl.util.vector.Vector3f vector3f, @NotNull org.lwjgl.util.vector.Vector3f vector3f2) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        Intrinsics.checkParameterIsNotNull(vector3f2, "v");
        return VecExtensionsKt.createVec3gl(vector3f.x - vector3f2.x, vector3f.y - vector3f2.y, vector3f.z - vector3f2.z);
    }

    @NotNull
    public static final org.lwjgl.util.vector.Vector3f mul(@NotNull org.lwjgl.util.vector.Vector3f vector3f, float f, float f2, float f3) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        return VecExtensionsKt.createVec3gl(vector3f.x * f, vector3f.y * f2, vector3f.z * f3);
    }

    @NotNull
    public static final org.lwjgl.util.vector.Vector3f mulVector(@NotNull org.lwjgl.util.vector.Vector3f vector3f, @NotNull org.lwjgl.util.vector.Vector3f vector3f2) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        Intrinsics.checkParameterIsNotNull(vector3f2, "v");
        return VecExtensionsKt.createVec3gl(vector3f.x * vector3f2.x, vector3f.y * vector3f2.y, vector3f.z * vector3f2.z);
    }

    @NotNull
    public static final org.lwjgl.util.vector.Vector3f mul(@NotNull org.lwjgl.util.vector.Vector3f vector3f, float f) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        return VecExtensionsKt.createVec3gl(vector3f.x * f, vector3f.y * f, vector3f.z * f);
    }

    @NotNull
    public static final org.lwjgl.util.vector.Vector3f div(@NotNull org.lwjgl.util.vector.Vector3f vector3f, float f, float f2, float f3) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        return VecExtensionsKt.createVec3gl(vector3f.x / f, vector3f.y / f2, vector3f.z / f3);
    }

    @NotNull
    public static final org.lwjgl.util.vector.Vector3f divVector(@NotNull org.lwjgl.util.vector.Vector3f vector3f, @NotNull org.lwjgl.util.vector.Vector3f vector3f2) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        Intrinsics.checkParameterIsNotNull(vector3f2, "v");
        return VecExtensionsKt.createVec3gl(vector3f.x / vector3f2.x, vector3f.y / vector3f2.y, vector3f.z / vector3f2.z);
    }

    @NotNull
    public static final org.lwjgl.util.vector.Vector3f pow(@NotNull org.lwjgl.util.vector.Vector3f vector3f, float f, float f2, float f3) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        return VecExtensionsKt.createVec3gl(VecExtensionsKt.pow(vector3f.x, f), VecExtensionsKt.pow(vector3f.y, f2), VecExtensionsKt.pow(vector3f.z, f3));
    }

    @NotNull
    public static final org.lwjgl.util.vector.Vector3f powVector(@NotNull org.lwjgl.util.vector.Vector3f vector3f, @NotNull org.lwjgl.util.vector.Vector3f vector3f2) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        Intrinsics.checkParameterIsNotNull(vector3f2, "v");
        return VecExtensionsKt.createVec3gl(VecExtensionsKt.pow(vector3f.x, vector3f2.x), VecExtensionsKt.pow(vector3f.y, vector3f2.y), VecExtensionsKt.pow(vector3f.z, vector3f2.z));
    }

    @NotNull
    public static final org.lwjgl.util.vector.Vector3f normalized(@NotNull org.lwjgl.util.vector.Vector3f vector3f) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        return (double)vector3f.lengthSquared() < 1.0E-4 ? VecExtensionsKt.createVec3gl(0.0f, 0.0f, 0.0f) : VecExtensionsKt.mul(vector3f, 1.0f / VecExtensionsKt.nonZeroLength(vector3f));
    }

    @NotNull
    public static final org.lwjgl.util.vector.Vector3f floor_double(@NotNull org.lwjgl.util.vector.Vector3f vector3f) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        return VecExtensionsKt.createVec3gl(sajh._c((double)vector3f.x), sajh._c((double)vector3f.y), sajh._c((double)vector3f.z));
    }

    @NotNull
    public static final org.lwjgl.util.vector.Vector3f floor(@NotNull org.lwjgl.util.vector.Vector3f vector3f) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        return VecExtensionsKt.createVec3gl((float)Math.floor(vector3f.x), (float)Math.floor(vector3f.y), (float)Math.floor(vector3f.z));
    }

    @NotNull
    public static final org.lwjgl.util.vector.Vector3f round(@NotNull org.lwjgl.util.vector.Vector3f vector3f) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        return VecExtensionsKt.createVec3gl(Math.round((double)vector3f.x), Math.round((double)vector3f.y), Math.round((double)vector3f.z));
    }

    @NotNull
    public static final org.lwjgl.util.vector.Vector3f clampMax(@NotNull org.lwjgl.util.vector.Vector3f vector3f, @NotNull org.lwjgl.util.vector.Vector3f vector3f2) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        Intrinsics.checkParameterIsNotNull(vector3f2, "v");
        return VecExtensionsKt.clampMaxl(VecExtensionsKt.createVec3gl(vector3f.x, vector3f.y, vector3f.z), vector3f2);
    }

    @NotNull
    public static final org.lwjgl.util.vector.Vector3f clampMax(@NotNull org.lwjgl.util.vector.Vector3f vector3f, float f, float f2, float f3) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        return VecExtensionsKt.clampMaxl(VecExtensionsKt.createVec3gl(vector3f.x, vector3f.y, vector3f.z), f, f2, f3);
    }

    @NotNull
    public static final org.lwjgl.util.vector.Vector3f plus(@NotNull org.lwjgl.util.vector.Vector3f vector3f, float f) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        return VecExtensionsKt.add(vector3f, f, f, f);
    }

    @NotNull
    public static final org.lwjgl.util.vector.Vector3f minus(@NotNull org.lwjgl.util.vector.Vector3f vector3f, float f) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        return VecExtensionsKt.sub(vector3f, f, f, f);
    }

    @NotNull
    public static final org.lwjgl.util.vector.Vector3f times(@NotNull org.lwjgl.util.vector.Vector3f vector3f, float f) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        return VecExtensionsKt.mul(vector3f, f, f, f);
    }

    @NotNull
    public static final org.lwjgl.util.vector.Vector3f div(@NotNull org.lwjgl.util.vector.Vector3f vector3f, float f) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        return VecExtensionsKt.div(vector3f, f, f, f);
    }

    @NotNull
    public static final org.lwjgl.util.vector.Vector3f plus(@NotNull org.lwjgl.util.vector.Vector3f vector3f, @NotNull org.lwjgl.util.vector.Vector3f vector3f2) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        Intrinsics.checkParameterIsNotNull(vector3f2, "vec");
        return VecExtensionsKt.addVector(vector3f, vector3f2);
    }

    @NotNull
    public static final org.lwjgl.util.vector.Vector3f minus(@NotNull org.lwjgl.util.vector.Vector3f vector3f, @NotNull org.lwjgl.util.vector.Vector3f vector3f2) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        Intrinsics.checkParameterIsNotNull(vector3f2, "vec");
        return VecExtensionsKt.subVector(vector3f, vector3f2);
    }

    @NotNull
    public static final org.lwjgl.util.vector.Vector3f times(@NotNull org.lwjgl.util.vector.Vector3f vector3f, @NotNull org.lwjgl.util.vector.Vector3f vector3f2) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        Intrinsics.checkParameterIsNotNull(vector3f2, "vec");
        return VecExtensionsKt.mulVector(vector3f, vector3f2);
    }

    @NotNull
    public static final org.lwjgl.util.vector.Vector3f div(@NotNull org.lwjgl.util.vector.Vector3f vector3f, @NotNull org.lwjgl.util.vector.Vector3f vector3f2) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        Intrinsics.checkParameterIsNotNull(vector3f2, "vec");
        return VecExtensionsKt.divVector(vector3f, vector3f2);
    }

    public static final float distanceSq(@NotNull org.lwjgl.util.vector.Vector3f vector3f, @NotNull org.lwjgl.util.vector.Vector3f vector3f2) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        Intrinsics.checkParameterIsNotNull(vector3f2, "v");
        return (vector3f2.x - vector3f.x) * (vector3f2.x - vector3f.x) + (vector3f2.y - vector3f.y) * (vector3f2.y - vector3f.y) + (vector3f2.z - vector3f.z) * (vector3f2.z - vector3f.z);
    }

    public static final float distance(@NotNull org.lwjgl.util.vector.Vector3f vector3f, @NotNull org.lwjgl.util.vector.Vector3f vector3f2) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        Intrinsics.checkParameterIsNotNull(vector3f2, "v");
        return VecExtensionsKt.sqrt(VecExtensionsKt.distanceSq(vector3f, vector3f2));
    }

    public static final float dot(@NotNull org.lwjgl.util.vector.Vector3f vector3f, @NotNull org.lwjgl.util.vector.Vector3f vector3f2) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        Intrinsics.checkParameterIsNotNull(vector3f2, "v");
        return vector3f.x * vector3f2.x + vector3f.y * vector3f2.y + vector3f.z * vector3f2.z;
    }

    @NotNull
    public static final org.lwjgl.util.vector.Vector3f cross(@NotNull org.lwjgl.util.vector.Vector3f vector3f, @NotNull org.lwjgl.util.vector.Vector3f vector3f2) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        Intrinsics.checkParameterIsNotNull(vector3f2, "v");
        return VecExtensionsKt.createVec3gl(vector3f.y * vector3f2.z - vector3f.z * vector3f2.y, vector3f.z * vector3f2.x - vector3f.x * vector3f2.z, vector3f.x * vector3f2.y - vector3f.y * vector3f2.x);
    }

    public static final void crossl(@NotNull org.lwjgl.util.vector.Vector3f vector3f, @NotNull org.lwjgl.util.vector.Vector3f vector3f2) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        Intrinsics.checkParameterIsNotNull(vector3f2, "v");
        VecExtensionsKt.setl(vector3f, vector3f.y * vector3f2.z - vector3f.z * vector3f2.y, vector3f.z * vector3f2.x - vector3f.x * vector3f2.z, vector3f.x * vector3f2.y - vector3f.y * vector3f2.x);
    }

    public static final float angleBetween(@NotNull org.lwjgl.util.vector.Vector3f vector3f, @NotNull org.lwjgl.util.vector.Vector3f vector3f2) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        Intrinsics.checkParameterIsNotNull(vector3f2, "v");
        float f = VecExtensionsKt.dot(vector3f, vector3f2) / (vector3f.length() * vector3f2.length());
        if (f < -1.0f) {
            f = -1.0f;
        } else if (f > 1.0f) {
            f = 1.0f;
        }
        return (float)Math.acos(f);
    }

    public static final float nonZeroLength(@NotNull org.lwjgl.util.vector.Vector3f vector3f) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        float f = vector3f.length();
        if (f == 0.0f) {
            throw (Throwable)new IllegalStateException("Zero length vector");
        }
        return f;
    }

    public static final boolean isUnit(@NotNull org.lwjgl.util.vector.Vector3f vector3f) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        return vector3f.lengthSquared() == 1.0f;
    }

    public static final boolean isEqual(@NotNull org.lwjgl.util.vector.Vector3f vector3f, @NotNull org.lwjgl.util.vector.Vector3f vector3f2) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        Intrinsics.checkParameterIsNotNull(vector3f2, "v");
        return Intrinsics.areEqual(vector3f2, vector3f) || owkq._e(vector3f2.x - vector3f.x) < EPSILON && owkq._e(vector3f2.y - vector3f.y) < EPSILON && owkq._e(vector3f2.z - vector3f.z) < EPSILON;
    }

    public static final boolean isNan(@NotNull org.lwjgl.util.vector.Vector3f vector3f) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        float f = vector3f.x;
        return Float.isNaN(f) || vector3f.x == FloatCompanionObject.INSTANCE.getNaN() || Float.isNaN(f = vector3f.y) || vector3f.y == FloatCompanionObject.INSTANCE.getNaN() || Float.isNaN(f = vector3f.z) || vector3f.z == FloatCompanionObject.INSTANCE.getNaN();
    }

    @NotNull
    public static final <T> org.lwjgl.util.vector.Vector3f sumBy(@NotNull T[] TArray, @NotNull Function1<? super T, ? extends org.lwjgl.util.vector.Vector3f> function1) {
        Intrinsics.checkParameterIsNotNull(TArray, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "selector");
        org.lwjgl.util.vector.Vector3f vector3f = new org.lwjgl.util.vector.Vector3f();
        for (int i = 0; i < TArray.length; ++i) {
            T t = TArray[i];
            VecExtensionsKt.plusAssign(vector3f, function1.invoke(t));
        }
        return vector3f;
    }

    @NotNull
    public static final <T> org.lwjgl.util.vector.Vector3f averageBy(@NotNull T[] TArray, @NotNull Function1<? super T, ? extends org.lwjgl.util.vector.Vector3f> function1) {
        Intrinsics.checkParameterIsNotNull(TArray, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "selector");
        org.lwjgl.util.vector.Vector3f vector3f = new org.lwjgl.util.vector.Vector3f();
        for (int i = 0; i < TArray.length; ++i) {
            T t = TArray[i];
            VecExtensionsKt.plusAssign(vector3f, function1.invoke(t));
        }
        VecExtensionsKt.divAssign(vector3f, (float)TArray.length);
        return vector3f;
    }

    private static final Vector3f createVec3vm(float f, float f2, float f3) {
        return new Vector3f(f, f2, f3);
    }

    @NotNull
    public static final Vector3f setl(@NotNull Vector3f vector3f, float f, float f2, float f3) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        vector3f.set(f, f2, f3);
        return vector3f;
    }

    @NotNull
    public static final Vector3f resetl(@NotNull Vector3f vector3f) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        return VecExtensionsKt.setl(vector3f, 0.0f, 0.0f, 0.0f);
    }

    @NotNull
    public static final Vector3f addl(@NotNull Vector3f vector3f, float f, float f2, float f3) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        return VecExtensionsKt.setl(vector3f, vector3f.x + f, vector3f.y + f2, vector3f.z + f3);
    }

    @NotNull
    public static final Vector3f addl(@NotNull Vector3f vector3f, @NotNull Vector3f vector3f2) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        Intrinsics.checkParameterIsNotNull(vector3f2, "v");
        return VecExtensionsKt.setl(vector3f, vector3f.x + vector3f2.x, vector3f.y + vector3f2.y, vector3f.z + vector3f2.z);
    }

    @NotNull
    public static final Vector3f offsetl(@NotNull Vector3f vector3f, float f) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        return VecExtensionsKt.setl(vector3f, vector3f.x + f, vector3f.y + f, vector3f.z + f);
    }

    @NotNull
    public static final Vector3f subl(@NotNull Vector3f vector3f, float f, float f2, float f3) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        return VecExtensionsKt.setl(vector3f, vector3f.x - f, vector3f.y - f2, vector3f.z - f3);
    }

    @NotNull
    public static final Vector3f subl(@NotNull Vector3f vector3f, @NotNull Vector3f vector3f2) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        Intrinsics.checkParameterIsNotNull(vector3f2, "v");
        return VecExtensionsKt.setl(vector3f, vector3f.x - vector3f2.x, vector3f.y - vector3f2.y, vector3f.z - vector3f2.z);
    }

    @NotNull
    public static final Vector3f mull(@NotNull Vector3f vector3f, float f, float f2, float f3) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        return VecExtensionsKt.setl(vector3f, vector3f.x * f, vector3f.y * f2, vector3f.z * f3);
    }

    @NotNull
    public static final Vector3f mull(@NotNull Vector3f vector3f, @NotNull Vector3f vector3f2) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        Intrinsics.checkParameterIsNotNull(vector3f2, "v");
        return VecExtensionsKt.setl(vector3f, vector3f.x * vector3f2.x, vector3f.y * vector3f2.y, vector3f.z * vector3f2.z);
    }

    @NotNull
    public static final Vector3f mull(@NotNull Vector3f vector3f, float f) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        return VecExtensionsKt.setl(vector3f, vector3f.x * f, vector3f.y * f, vector3f.z * f);
    }

    @NotNull
    public static final Vector3f dividel(@NotNull Vector3f vector3f, float f, float f2, float f3) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        return VecExtensionsKt.setl(vector3f, vector3f.x / f, vector3f.y / f2, vector3f.z / f3);
    }

    @NotNull
    public static final Vector3f dividel(@NotNull Vector3f vector3f, @NotNull Vector3f vector3f2) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        Intrinsics.checkParameterIsNotNull(vector3f2, "v");
        return VecExtensionsKt.setl(vector3f, vector3f.x / vector3f2.x, vector3f.y / vector3f2.y, vector3f.z / vector3f2.z);
    }

    @NotNull
    public static final Vector3f powl(@NotNull Vector3f vector3f, float f, float f2, float f3) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        return VecExtensionsKt.setl(vector3f, VecExtensionsKt.pow(vector3f.x, f), VecExtensionsKt.pow(vector3f.y, f2), VecExtensionsKt.pow(vector3f.z, f3));
    }

    @NotNull
    public static final Vector3f powl(@NotNull Vector3f vector3f, @NotNull Vector3f vector3f2) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        Intrinsics.checkParameterIsNotNull(vector3f2, "v");
        return VecExtensionsKt.setl(vector3f, VecExtensionsKt.pow(vector3f.x, vector3f2.x), VecExtensionsKt.pow(vector3f.y, vector3f2.y), VecExtensionsKt.pow(vector3f.z, vector3f2.z));
    }

    @NotNull
    public static final Vector3f normalizel(@NotNull Vector3f vector3f) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        return (double)vector3f.lengthSquared() < 1.0E-4 ? VecExtensionsKt.setl(vector3f, 0.0f, 0.0f, 0.0f) : VecExtensionsKt.mull(vector3f, 1.0f / VecExtensionsKt.nonZeroLength(vector3f));
    }

    @NotNull
    public static final Vector3f floor_doublel(@NotNull Vector3f vector3f) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        return VecExtensionsKt.setl(vector3f, (float)sajh._c((double)vector3f.x), (float)sajh._c((double)vector3f.y), (float)sajh._c((double)vector3f.z));
    }

    @NotNull
    public static final Vector3f floorl(@NotNull Vector3f vector3f) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        return VecExtensionsKt.setl(vector3f, (float)Math.floor(vector3f.x), (float)Math.floor(vector3f.y), (float)Math.floor(vector3f.z));
    }

    @NotNull
    public static final Vector3f roundl(@NotNull Vector3f vector3f) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        return VecExtensionsKt.setl(vector3f, (float)Math.round((double)vector3f.x), (float)Math.round((double)vector3f.y), (float)Math.round((double)vector3f.z));
    }

    @NotNull
    public static final Vector3f clampMaxl(@NotNull Vector3f vector3f, @NotNull Vector3f vector3f2) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        Intrinsics.checkParameterIsNotNull(vector3f2, "v");
        return VecExtensionsKt.clampMaxl(vector3f, vector3f2.x, vector3f2.y, vector3f2.z);
    }

    @NotNull
    public static final Vector3f clampMaxl(@NotNull Vector3f vector3f, float f, float f2, float f3) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        float f4 = vector3f.x;
        float f5 = vector3f.y;
        float f6 = vector3f.z;
        if (owkq._e(vector3f.x) > f) {
            f4 = f * owkq._h(vector3f.x);
        }
        if (owkq._e(vector3f.y) > f2) {
            f5 = f2 * owkq._h(vector3f.y);
        }
        if (owkq._e(vector3f.z) > f3) {
            f6 = f3 * owkq._h(vector3f.z);
        }
        vector3f.set(f4, f5, f6);
        return vector3f;
    }

    public static final void plusAssign(@NotNull Vector3f vector3f, float f) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        VecExtensionsKt.addl(vector3f, f, f, f);
    }

    public static final void minusAssign(@NotNull Vector3f vector3f, float f) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        VecExtensionsKt.subl(vector3f, f, f, f);
    }

    public static final void timesAssign(@NotNull Vector3f vector3f, float f) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        VecExtensionsKt.mull(vector3f, f, f, f);
    }

    public static final void divAssign(@NotNull Vector3f vector3f, float f) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        VecExtensionsKt.dividel(vector3f, f, f, f);
    }

    public static final void plusAssign(@NotNull Vector3f vector3f, @NotNull Vector3f vector3f2) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        Intrinsics.checkParameterIsNotNull(vector3f2, "vec");
        VecExtensionsKt.addl(vector3f, vector3f2);
    }

    public static final void minusAssign(@NotNull Vector3f vector3f, @NotNull Vector3f vector3f2) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        Intrinsics.checkParameterIsNotNull(vector3f2, "vec");
        VecExtensionsKt.subl(vector3f, vector3f2);
    }

    public static final void timesAssign(@NotNull Vector3f vector3f, @NotNull Vector3f vector3f2) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        Intrinsics.checkParameterIsNotNull(vector3f2, "vec");
        VecExtensionsKt.mull(vector3f, vector3f2);
    }

    public static final void divAssign(@NotNull Vector3f vector3f, @NotNull Vector3f vector3f2) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        Intrinsics.checkParameterIsNotNull(vector3f2, "vec");
        VecExtensionsKt.dividel(vector3f, vector3f2);
    }

    @NotNull
    public static final Vector3f add(@NotNull Vector3f vector3f, float f, float f2, float f3) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        return VecExtensionsKt.createVec3vm(vector3f.x + f, vector3f.y + f2, vector3f.z + f3);
    }

    @NotNull
    public static final Vector3f addVector(@NotNull Vector3f vector3f, @NotNull Vector3f vector3f2) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        Intrinsics.checkParameterIsNotNull(vector3f2, "v");
        return VecExtensionsKt.createVec3vm(vector3f.x + vector3f2.x, vector3f.y + vector3f2.y, vector3f.z + vector3f2.z);
    }

    @NotNull
    public static final Vector3f offseted(@NotNull Vector3f vector3f, float f) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        return VecExtensionsKt.createVec3vm(vector3f.x + f, vector3f.y + f, vector3f.z + f);
    }

    @NotNull
    public static final Vector3f sub(@NotNull Vector3f vector3f, float f, float f2, float f3) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        return VecExtensionsKt.createVec3vm(vector3f.x - f, vector3f.y - f2, vector3f.z - f3);
    }

    @NotNull
    public static final Vector3f subVector(@NotNull Vector3f vector3f, @NotNull Vector3f vector3f2) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        Intrinsics.checkParameterIsNotNull(vector3f2, "v");
        return VecExtensionsKt.createVec3vm(vector3f.x - vector3f2.x, vector3f.y - vector3f2.y, vector3f.z - vector3f2.z);
    }

    @NotNull
    public static final Vector3f mul(@NotNull Vector3f vector3f, float f, float f2, float f3) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        return VecExtensionsKt.createVec3vm(vector3f.x * f, vector3f.y * f2, vector3f.z * f3);
    }

    @NotNull
    public static final Vector3f mulVector(@NotNull Vector3f vector3f, @NotNull Vector3f vector3f2) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        Intrinsics.checkParameterIsNotNull(vector3f2, "v");
        return VecExtensionsKt.createVec3vm(vector3f.x * vector3f2.x, vector3f.y * vector3f2.y, vector3f.z * vector3f2.z);
    }

    @NotNull
    public static final Vector3f mul(@NotNull Vector3f vector3f, float f) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        return VecExtensionsKt.createVec3vm(vector3f.x * f, vector3f.y * f, vector3f.z * f);
    }

    @NotNull
    public static final Vector3f div(@NotNull Vector3f vector3f, float f, float f2, float f3) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        return VecExtensionsKt.createVec3vm(vector3f.x / f, vector3f.y / f2, vector3f.z / f3);
    }

    @NotNull
    public static final Vector3f divVector(@NotNull Vector3f vector3f, @NotNull Vector3f vector3f2) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        Intrinsics.checkParameterIsNotNull(vector3f2, "v");
        return VecExtensionsKt.createVec3vm(vector3f.x / vector3f2.x, vector3f.y / vector3f2.y, vector3f.z / vector3f2.z);
    }

    @NotNull
    public static final Vector3f pow(@NotNull Vector3f vector3f, float f, float f2, float f3) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        return VecExtensionsKt.createVec3vm(VecExtensionsKt.pow(vector3f.x, f), VecExtensionsKt.pow(vector3f.y, f2), VecExtensionsKt.pow(vector3f.z, f3));
    }

    @NotNull
    public static final Vector3f powVector(@NotNull Vector3f vector3f, @NotNull Vector3f vector3f2) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        Intrinsics.checkParameterIsNotNull(vector3f2, "v");
        return VecExtensionsKt.createVec3vm(VecExtensionsKt.pow(vector3f.x, vector3f2.x), VecExtensionsKt.pow(vector3f.y, vector3f2.y), VecExtensionsKt.pow(vector3f.z, vector3f2.z));
    }

    @NotNull
    public static final Vector3f normalized(@NotNull Vector3f vector3f) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        return (double)vector3f.lengthSquared() < 1.0E-4 ? VecExtensionsKt.createVec3vm(0.0f, 0.0f, 0.0f) : VecExtensionsKt.mul(vector3f, 1.0f / VecExtensionsKt.nonZeroLength(vector3f));
    }

    @NotNull
    public static final Vector3f floor_double(@NotNull Vector3f vector3f) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        return VecExtensionsKt.createVec3vm(sajh._c((double)vector3f.x), sajh._c((double)vector3f.y), sajh._c((double)vector3f.z));
    }

    @NotNull
    public static final Vector3f floor(@NotNull Vector3f vector3f) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        return VecExtensionsKt.createVec3vm((float)Math.floor(vector3f.x), (float)Math.floor(vector3f.y), (float)Math.floor(vector3f.z));
    }

    @NotNull
    public static final Vector3f round(@NotNull Vector3f vector3f) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        return VecExtensionsKt.createVec3vm(Math.round((double)vector3f.x), Math.round((double)vector3f.y), Math.round((double)vector3f.z));
    }

    @NotNull
    public static final Vector3f clampMax(@NotNull Vector3f vector3f, @NotNull Vector3f vector3f2) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        Intrinsics.checkParameterIsNotNull(vector3f2, "v");
        return VecExtensionsKt.clampMaxl(VecExtensionsKt.createVec3vm(vector3f.x, vector3f.y, vector3f.z), vector3f2);
    }

    @NotNull
    public static final Vector3f clampMax(@NotNull Vector3f vector3f, float f, float f2, float f3) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        return VecExtensionsKt.clampMaxl(VecExtensionsKt.createVec3vm(vector3f.x, vector3f.y, vector3f.z), f, f2, f3);
    }

    @NotNull
    public static final Vector3f plus(@NotNull Vector3f vector3f, float f) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        return VecExtensionsKt.add(vector3f, f, f, f);
    }

    @NotNull
    public static final Vector3f minus(@NotNull Vector3f vector3f, float f) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        return VecExtensionsKt.sub(vector3f, f, f, f);
    }

    @NotNull
    public static final Vector3f times(@NotNull Vector3f vector3f, float f) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        return VecExtensionsKt.mul(vector3f, f, f, f);
    }

    @NotNull
    public static final Vector3f div(@NotNull Vector3f vector3f, float f) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        return VecExtensionsKt.div(vector3f, f, f, f);
    }

    @NotNull
    public static final Vector3f plus(@NotNull Vector3f vector3f, @NotNull Vector3f vector3f2) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        Intrinsics.checkParameterIsNotNull(vector3f2, "vec");
        return VecExtensionsKt.addVector(vector3f, vector3f2);
    }

    @NotNull
    public static final Vector3f minus(@NotNull Vector3f vector3f, @NotNull Vector3f vector3f2) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        Intrinsics.checkParameterIsNotNull(vector3f2, "vec");
        return VecExtensionsKt.subVector(vector3f, vector3f2);
    }

    @NotNull
    public static final Vector3f times(@NotNull Vector3f vector3f, @NotNull Vector3f vector3f2) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        Intrinsics.checkParameterIsNotNull(vector3f2, "vec");
        return VecExtensionsKt.mulVector(vector3f, vector3f2);
    }

    @NotNull
    public static final Vector3f div(@NotNull Vector3f vector3f, @NotNull Vector3f vector3f2) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        Intrinsics.checkParameterIsNotNull(vector3f2, "vec");
        return VecExtensionsKt.divVector(vector3f, vector3f2);
    }

    public static final float distanceSq(@NotNull Vector3f vector3f, @NotNull Vector3f vector3f2) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        Intrinsics.checkParameterIsNotNull(vector3f2, "v");
        return (vector3f2.x - vector3f.x) * (vector3f2.x - vector3f.x) + (vector3f2.y - vector3f.y) * (vector3f2.y - vector3f.y) + (vector3f2.z - vector3f.z) * (vector3f2.z - vector3f.z);
    }

    public static final float distance(@NotNull Vector3f vector3f, @NotNull Vector3f vector3f2) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        Intrinsics.checkParameterIsNotNull(vector3f2, "v");
        return VecExtensionsKt.sqrt(VecExtensionsKt.distanceSq(vector3f, vector3f2));
    }

    public static final float dot(@NotNull Vector3f vector3f, @NotNull Vector3f vector3f2) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        Intrinsics.checkParameterIsNotNull(vector3f2, "v");
        return vector3f.x * vector3f2.x + vector3f.y * vector3f2.y + vector3f.z * vector3f2.z;
    }

    @NotNull
    public static final Vector3f cross(@NotNull Vector3f vector3f, @NotNull Vector3f vector3f2) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        Intrinsics.checkParameterIsNotNull(vector3f2, "v");
        return VecExtensionsKt.createVec3vm(vector3f.y * vector3f2.z - vector3f.z * vector3f2.y, vector3f.z * vector3f2.x - vector3f.x * vector3f2.z, vector3f.x * vector3f2.y - vector3f.y * vector3f2.x);
    }

    public static final float angleBetween(@NotNull Vector3f vector3f, @NotNull Vector3f vector3f2) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        Intrinsics.checkParameterIsNotNull(vector3f2, "v");
        float f = vector3f.dot(vector3f2) / (vector3f.length() * vector3f2.length());
        if (f < -1.0f) {
            f = -1.0f;
        } else if (f > 1.0f) {
            f = 1.0f;
        }
        return (float)Math.acos(f);
    }

    public static final float nonZeroLength(@NotNull Vector3f vector3f) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        float f = vector3f.length();
        if (f == 0.0f) {
            throw (Throwable)new IllegalStateException("Zero length vector");
        }
        return f;
    }

    public static final boolean isUnit(@NotNull Vector3f vector3f) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        return vector3f.lengthSquared() == 1.0f;
    }

    public static final boolean isEqual(@NotNull Vector3f vector3f, @NotNull Vector3f vector3f2) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        Intrinsics.checkParameterIsNotNull(vector3f2, "v");
        return Intrinsics.areEqual(vector3f2, vector3f) || owkq._e(vector3f2.x - vector3f.x) < EPSILON && owkq._e(vector3f2.y - vector3f.y) < EPSILON && owkq._e(vector3f2.z - vector3f.z) < EPSILON;
    }

    public static final boolean isNan(@NotNull Vector3f vector3f) {
        Intrinsics.checkParameterIsNotNull(vector3f, "$receiver");
        float f = vector3f.x;
        return Float.isNaN(f) || vector3f.x == FloatCompanionObject.INSTANCE.getNaN() || Float.isNaN(f = vector3f.y) || vector3f.y == FloatCompanionObject.INSTANCE.getNaN() || Float.isNaN(f = vector3f.z) || vector3f.z == FloatCompanionObject.INSTANCE.getNaN();
    }

    private static final Vec3 createVec3mc(double d, double d2, double d3) {
        Vec3 vec3 = Vec3._a(d, d2, d3);
        Intrinsics.checkExpressionValueIsNotNull(vec3, "Vec3mc.createVectorHelper(x, y, z)");
        return vec3;
    }

    @NotNull
    public static final Vec3 setl(@NotNull Vec3 vec3, double d, double d2, double d3) {
        Intrinsics.checkParameterIsNotNull(vec3, "$receiver");
        VecExtensionsKt.set(vec3, d, d2, d3);
        return vec3;
    }

    @NotNull
    public static final Vec3 resetl(@NotNull Vec3 vec3) {
        Intrinsics.checkParameterIsNotNull(vec3, "$receiver");
        return VecExtensionsKt.setl(vec3, 0.0, 0.0, 0.0);
    }

    @NotNull
    public static final Vec3 addl(@NotNull Vec3 vec3, double d, double d2, double d3) {
        Intrinsics.checkParameterIsNotNull(vec3, "$receiver");
        return VecExtensionsKt.setl(vec3, VecExtensionsKt.getX(vec3) + d, VecExtensionsKt.getY(vec3) + d2, VecExtensionsKt.getZ(vec3) + d3);
    }

    @NotNull
    public static final Vec3 addl(@NotNull Vec3 vec3, @NotNull Vec3 vec32) {
        Intrinsics.checkParameterIsNotNull(vec3, "$receiver");
        Intrinsics.checkParameterIsNotNull(vec32, "v");
        return VecExtensionsKt.setl(vec3, VecExtensionsKt.getX(vec3) + VecExtensionsKt.getX(vec32), VecExtensionsKt.getY(vec3) + VecExtensionsKt.getY(vec32), VecExtensionsKt.getZ(vec3) + VecExtensionsKt.getZ(vec32));
    }

    @NotNull
    public static final Vec3 offsetl(@NotNull Vec3 vec3, double d) {
        Intrinsics.checkParameterIsNotNull(vec3, "$receiver");
        return VecExtensionsKt.setl(vec3, VecExtensionsKt.getX(vec3) + d, VecExtensionsKt.getY(vec3) + d, VecExtensionsKt.getZ(vec3) + d);
    }

    @NotNull
    public static final Vec3 subl(@NotNull Vec3 vec3, double d, double d2, double d3) {
        Intrinsics.checkParameterIsNotNull(vec3, "$receiver");
        return VecExtensionsKt.setl(vec3, VecExtensionsKt.getX(vec3) - d, VecExtensionsKt.getY(vec3) - d2, VecExtensionsKt.getZ(vec3) - d3);
    }

    @NotNull
    public static final Vec3 subl(@NotNull Vec3 vec3, @NotNull Vec3 vec32) {
        Intrinsics.checkParameterIsNotNull(vec3, "$receiver");
        Intrinsics.checkParameterIsNotNull(vec32, "v");
        return VecExtensionsKt.setl(vec3, VecExtensionsKt.getX(vec3) - VecExtensionsKt.getX(vec32), VecExtensionsKt.getY(vec3) - VecExtensionsKt.getY(vec32), VecExtensionsKt.getZ(vec3) - VecExtensionsKt.getZ(vec32));
    }

    @NotNull
    public static final Vec3 mull(@NotNull Vec3 vec3, double d, double d2, double d3) {
        Intrinsics.checkParameterIsNotNull(vec3, "$receiver");
        return VecExtensionsKt.setl(vec3, VecExtensionsKt.getX(vec3) * d, VecExtensionsKt.getY(vec3) * d2, VecExtensionsKt.getZ(vec3) * d3);
    }

    @NotNull
    public static final Vec3 mull(@NotNull Vec3 vec3, @NotNull Vec3 vec32) {
        Intrinsics.checkParameterIsNotNull(vec3, "$receiver");
        Intrinsics.checkParameterIsNotNull(vec32, "v");
        return VecExtensionsKt.setl(vec3, VecExtensionsKt.getX(vec3) * VecExtensionsKt.getX(vec32), VecExtensionsKt.getY(vec3) * VecExtensionsKt.getY(vec32), VecExtensionsKt.getZ(vec3) * VecExtensionsKt.getZ(vec32));
    }

    @NotNull
    public static final Vec3 mull(@NotNull Vec3 vec3, double d) {
        Intrinsics.checkParameterIsNotNull(vec3, "$receiver");
        return VecExtensionsKt.setl(vec3, VecExtensionsKt.getX(vec3) * d, VecExtensionsKt.getY(vec3) * d, VecExtensionsKt.getZ(vec3) * d);
    }

    @NotNull
    public static final Vec3 dividel(@NotNull Vec3 vec3, double d, double d2, double d3) {
        Intrinsics.checkParameterIsNotNull(vec3, "$receiver");
        return VecExtensionsKt.setl(vec3, VecExtensionsKt.getX(vec3) / d, VecExtensionsKt.getY(vec3) / d2, VecExtensionsKt.getZ(vec3) / d3);
    }

    @NotNull
    public static final Vec3 dividel(@NotNull Vec3 vec3, @NotNull Vec3 vec32) {
        Intrinsics.checkParameterIsNotNull(vec3, "$receiver");
        Intrinsics.checkParameterIsNotNull(vec32, "v");
        return VecExtensionsKt.setl(vec3, VecExtensionsKt.getX(vec3) / VecExtensionsKt.getX(vec32), VecExtensionsKt.getY(vec3) / VecExtensionsKt.getY(vec32), VecExtensionsKt.getZ(vec3) / VecExtensionsKt.getZ(vec32));
    }

    @NotNull
    public static final Vec3 powl(@NotNull Vec3 vec3, double d, double d2, double d3) {
        Intrinsics.checkParameterIsNotNull(vec3, "$receiver");
        return VecExtensionsKt.setl(vec3, VecExtensionsKt.pow(VecExtensionsKt.getX(vec3), d), VecExtensionsKt.pow(VecExtensionsKt.getY(vec3), d2), VecExtensionsKt.pow(VecExtensionsKt.getZ(vec3), d3));
    }

    @NotNull
    public static final Vec3 powl(@NotNull Vec3 vec3, @NotNull Vec3 vec32) {
        Intrinsics.checkParameterIsNotNull(vec3, "$receiver");
        Intrinsics.checkParameterIsNotNull(vec32, "v");
        return VecExtensionsKt.setl(vec3, VecExtensionsKt.pow(VecExtensionsKt.getX(vec3), VecExtensionsKt.getX(vec32)), VecExtensionsKt.pow(VecExtensionsKt.getY(vec3), VecExtensionsKt.getY(vec32)), VecExtensionsKt.pow(VecExtensionsKt.getZ(vec3), VecExtensionsKt.getZ(vec32)));
    }

    @NotNull
    public static final Vec3 normalizel(@NotNull Vec3 vec3) {
        Intrinsics.checkParameterIsNotNull(vec3, "$receiver");
        return VecExtensionsKt.lengthSquared(vec3) < 1.0E-4 ? VecExtensionsKt.setl(vec3, 0.0, 0.0, 0.0) : VecExtensionsKt.mull(vec3, 1.0 / VecExtensionsKt.nonZeroLength(vec3));
    }

    @NotNull
    public static final Vec3 floor_doublel(@NotNull Vec3 vec3) {
        Intrinsics.checkParameterIsNotNull(vec3, "$receiver");
        return VecExtensionsKt.setl(vec3, (double)sajh._c(VecExtensionsKt.getX(vec3)), (double)sajh._c(VecExtensionsKt.getY(vec3)), (double)sajh._c(VecExtensionsKt.getZ(vec3)));
    }

    @NotNull
    public static final Vec3 floorl(@NotNull Vec3 vec3) {
        Intrinsics.checkParameterIsNotNull(vec3, "$receiver");
        return VecExtensionsKt.setl(vec3, Math.floor(VecExtensionsKt.getX(vec3)), Math.floor(VecExtensionsKt.getY(vec3)), Math.floor(VecExtensionsKt.getZ(vec3)));
    }

    @NotNull
    public static final Vec3 roundl(@NotNull Vec3 vec3) {
        Intrinsics.checkParameterIsNotNull(vec3, "$receiver");
        return VecExtensionsKt.setl(vec3, (double)Math.round(VecExtensionsKt.getX(vec3)), (double)Math.round(VecExtensionsKt.getY(vec3)), (double)Math.round(VecExtensionsKt.getZ(vec3)));
    }

    @NotNull
    public static final Vec3 clampMaxl(@NotNull Vec3 vec3, @NotNull Vec3 vec32) {
        Intrinsics.checkParameterIsNotNull(vec3, "$receiver");
        Intrinsics.checkParameterIsNotNull(vec32, "v");
        return VecExtensionsKt.clampMaxl(vec3, VecExtensionsKt.getX(vec32), VecExtensionsKt.getY(vec32), VecExtensionsKt.getZ(vec32));
    }

    @NotNull
    public static final Vec3 clampMaxl(@NotNull Vec3 vec3, double d, double d2, double d3) {
        Intrinsics.checkParameterIsNotNull(vec3, "$receiver");
        double d4 = VecExtensionsKt.getX(vec3);
        double d5 = VecExtensionsKt.getY(vec3);
        double d6 = VecExtensionsKt.getZ(vec3);
        if (owkq._e(VecExtensionsKt.getX(vec3)) > d) {
            d4 = d * owkq._h(VecExtensionsKt.getX(vec3));
        }
        if (owkq._e(VecExtensionsKt.getY(vec3)) > d2) {
            d5 = d2 * owkq._h(VecExtensionsKt.getY(vec3));
        }
        if (owkq._e(VecExtensionsKt.getZ(vec3)) > d3) {
            d6 = d3 * owkq._h(VecExtensionsKt.getZ(vec3));
        }
        VecExtensionsKt.set(vec3, d4, d5, d6);
        return vec3;
    }

    public static final void plusAssign(@NotNull Vec3 vec3, double d) {
        Intrinsics.checkParameterIsNotNull(vec3, "$receiver");
        VecExtensionsKt.addl(vec3, d, d, d);
    }

    public static final void minusAssign(@NotNull Vec3 vec3, double d) {
        Intrinsics.checkParameterIsNotNull(vec3, "$receiver");
        VecExtensionsKt.subl(vec3, d, d, d);
    }

    public static final void timesAssign(@NotNull Vec3 vec3, double d) {
        Intrinsics.checkParameterIsNotNull(vec3, "$receiver");
        VecExtensionsKt.mull(vec3, d, d, d);
    }

    public static final void divAssign(@NotNull Vec3 vec3, double d) {
        Intrinsics.checkParameterIsNotNull(vec3, "$receiver");
        VecExtensionsKt.dividel(vec3, d, d, d);
    }

    public static final void plusAssign(@NotNull Vec3 vec3, @NotNull Vec3 vec32) {
        Intrinsics.checkParameterIsNotNull(vec3, "$receiver");
        Intrinsics.checkParameterIsNotNull(vec32, "vec");
        VecExtensionsKt.addl(vec3, vec32);
    }

    public static final void minusAssign(@NotNull Vec3 vec3, @NotNull Vec3 vec32) {
        Intrinsics.checkParameterIsNotNull(vec3, "$receiver");
        Intrinsics.checkParameterIsNotNull(vec32, "vec");
        VecExtensionsKt.subl(vec3, vec32);
    }

    public static final void timesAssign(@NotNull Vec3 vec3, @NotNull Vec3 vec32) {
        Intrinsics.checkParameterIsNotNull(vec3, "$receiver");
        Intrinsics.checkParameterIsNotNull(vec32, "vec");
        VecExtensionsKt.mull(vec3, vec32);
    }

    public static final void divAssign(@NotNull Vec3 vec3, @NotNull Vec3 vec32) {
        Intrinsics.checkParameterIsNotNull(vec3, "$receiver");
        Intrinsics.checkParameterIsNotNull(vec32, "vec");
        VecExtensionsKt.dividel(vec3, vec32);
    }

    @NotNull
    public static final Vec3 add(@NotNull Vec3 vec3, double d, double d2, double d3) {
        Intrinsics.checkParameterIsNotNull(vec3, "$receiver");
        return VecExtensionsKt.createVec3mc(VecExtensionsKt.getX(vec3) + d, VecExtensionsKt.getY(vec3) + d2, VecExtensionsKt.getZ(vec3) + d3);
    }

    @NotNull
    public static final Vec3 addVector(@NotNull Vec3 vec3, @NotNull Vec3 vec32) {
        Intrinsics.checkParameterIsNotNull(vec3, "$receiver");
        Intrinsics.checkParameterIsNotNull(vec32, "v");
        return VecExtensionsKt.createVec3mc(VecExtensionsKt.getX(vec3) + VecExtensionsKt.getX(vec32), VecExtensionsKt.getY(vec3) + VecExtensionsKt.getY(vec32), VecExtensionsKt.getZ(vec3) + VecExtensionsKt.getZ(vec32));
    }

    @NotNull
    public static final Vec3 offseted(@NotNull Vec3 vec3, double d) {
        Intrinsics.checkParameterIsNotNull(vec3, "$receiver");
        return VecExtensionsKt.createVec3mc(VecExtensionsKt.getX(vec3) + d, VecExtensionsKt.getY(vec3) + d, VecExtensionsKt.getZ(vec3) + d);
    }

    @NotNull
    public static final Vec3 sub(@NotNull Vec3 vec3, double d, double d2, double d3) {
        Intrinsics.checkParameterIsNotNull(vec3, "$receiver");
        return VecExtensionsKt.createVec3mc(VecExtensionsKt.getX(vec3) - d, VecExtensionsKt.getY(vec3) - d2, VecExtensionsKt.getZ(vec3) - d3);
    }

    @NotNull
    public static final Vec3 subVector(@NotNull Vec3 vec3, @NotNull Vec3 vec32) {
        Intrinsics.checkParameterIsNotNull(vec3, "$receiver");
        Intrinsics.checkParameterIsNotNull(vec32, "v");
        return VecExtensionsKt.createVec3mc(VecExtensionsKt.getX(vec3) - VecExtensionsKt.getX(vec32), VecExtensionsKt.getY(vec3) - VecExtensionsKt.getY(vec32), VecExtensionsKt.getZ(vec3) - VecExtensionsKt.getZ(vec32));
    }

    @NotNull
    public static final Vec3 mul(@NotNull Vec3 vec3, double d, double d2, double d3) {
        Intrinsics.checkParameterIsNotNull(vec3, "$receiver");
        return VecExtensionsKt.createVec3mc(VecExtensionsKt.getX(vec3) * d, VecExtensionsKt.getY(vec3) * d2, VecExtensionsKt.getZ(vec3) * d3);
    }

    @NotNull
    public static final Vec3 mulVector(@NotNull Vec3 vec3, @NotNull Vec3 vec32) {
        Intrinsics.checkParameterIsNotNull(vec3, "$receiver");
        Intrinsics.checkParameterIsNotNull(vec32, "v");
        return VecExtensionsKt.createVec3mc(VecExtensionsKt.getX(vec3) * VecExtensionsKt.getX(vec32), VecExtensionsKt.getY(vec3) * VecExtensionsKt.getY(vec32), VecExtensionsKt.getZ(vec3) * VecExtensionsKt.getZ(vec32));
    }

    @NotNull
    public static final Vec3 mul(@NotNull Vec3 vec3, double d) {
        Intrinsics.checkParameterIsNotNull(vec3, "$receiver");
        return VecExtensionsKt.createVec3mc(VecExtensionsKt.getX(vec3) * d, VecExtensionsKt.getY(vec3) * d, VecExtensionsKt.getZ(vec3) * d);
    }

    @NotNull
    public static final Vec3 div(@NotNull Vec3 vec3, double d, double d2, double d3) {
        Intrinsics.checkParameterIsNotNull(vec3, "$receiver");
        return VecExtensionsKt.createVec3mc(VecExtensionsKt.getX(vec3) / d, VecExtensionsKt.getY(vec3) / d2, VecExtensionsKt.getZ(vec3) / d3);
    }

    @NotNull
    public static final Vec3 divVector(@NotNull Vec3 vec3, @NotNull Vec3 vec32) {
        Intrinsics.checkParameterIsNotNull(vec3, "$receiver");
        Intrinsics.checkParameterIsNotNull(vec32, "v");
        return VecExtensionsKt.createVec3mc(VecExtensionsKt.getX(vec3) / VecExtensionsKt.getX(vec32), VecExtensionsKt.getY(vec3) / VecExtensionsKt.getY(vec32), VecExtensionsKt.getZ(vec3) / VecExtensionsKt.getZ(vec32));
    }

    @NotNull
    public static final Vec3 pow(@NotNull Vec3 vec3, double d, double d2, double d3) {
        Intrinsics.checkParameterIsNotNull(vec3, "$receiver");
        return VecExtensionsKt.createVec3mc(VecExtensionsKt.pow(VecExtensionsKt.getX(vec3), d), VecExtensionsKt.pow(VecExtensionsKt.getY(vec3), d2), VecExtensionsKt.pow(VecExtensionsKt.getZ(vec3), d3));
    }

    @NotNull
    public static final Vec3 powVector(@NotNull Vec3 vec3, @NotNull Vec3 vec32) {
        Intrinsics.checkParameterIsNotNull(vec3, "$receiver");
        Intrinsics.checkParameterIsNotNull(vec32, "v");
        return VecExtensionsKt.createVec3mc(VecExtensionsKt.pow(VecExtensionsKt.getX(vec3), VecExtensionsKt.getX(vec32)), VecExtensionsKt.pow(VecExtensionsKt.getY(vec3), VecExtensionsKt.getY(vec32)), VecExtensionsKt.pow(VecExtensionsKt.getZ(vec3), VecExtensionsKt.getZ(vec32)));
    }

    @NotNull
    public static final Vec3 normalized(@NotNull Vec3 vec3) {
        Intrinsics.checkParameterIsNotNull(vec3, "$receiver");
        return VecExtensionsKt.lengthSquared(vec3) < 1.0E-4 ? VecExtensionsKt.createVec3mc(0.0, 0.0, 0.0) : VecExtensionsKt.mul(vec3, 1.0 / VecExtensionsKt.nonZeroLength(vec3));
    }

    @NotNull
    public static final Vec3 floor_double(@NotNull Vec3 vec3) {
        Intrinsics.checkParameterIsNotNull(vec3, "$receiver");
        return VecExtensionsKt.createVec3mc(sajh._c(VecExtensionsKt.getX(vec3)), sajh._c(VecExtensionsKt.getY(vec3)), sajh._c(VecExtensionsKt.getZ(vec3)));
    }

    @NotNull
    public static final Vec3 floor(@NotNull Vec3 vec3) {
        Intrinsics.checkParameterIsNotNull(vec3, "$receiver");
        return VecExtensionsKt.createVec3mc(Math.floor(VecExtensionsKt.getX(vec3)), Math.floor(VecExtensionsKt.getY(vec3)), Math.floor(VecExtensionsKt.getZ(vec3)));
    }

    @NotNull
    public static final Vec3 round(@NotNull Vec3 vec3) {
        Intrinsics.checkParameterIsNotNull(vec3, "$receiver");
        return VecExtensionsKt.createVec3mc(Math.round(VecExtensionsKt.getX(vec3)), Math.round(VecExtensionsKt.getY(vec3)), Math.round(VecExtensionsKt.getZ(vec3)));
    }

    @NotNull
    public static final Vec3 clampMax(@NotNull Vec3 vec3, @NotNull Vec3 vec32) {
        Intrinsics.checkParameterIsNotNull(vec3, "$receiver");
        Intrinsics.checkParameterIsNotNull(vec32, "v");
        return VecExtensionsKt.clampMaxl(VecExtensionsKt.createVec3mc(VecExtensionsKt.getX(vec3), VecExtensionsKt.getY(vec3), VecExtensionsKt.getZ(vec3)), vec32);
    }

    @NotNull
    public static final Vec3 clampMax(@NotNull Vec3 vec3, double d, double d2, double d3) {
        Intrinsics.checkParameterIsNotNull(vec3, "$receiver");
        return VecExtensionsKt.clampMaxl(VecExtensionsKt.createVec3mc(VecExtensionsKt.getX(vec3), VecExtensionsKt.getY(vec3), VecExtensionsKt.getZ(vec3)), d, d2, d3);
    }

    @NotNull
    public static final Vec3 plus(@NotNull Vec3 vec3, double d) {
        Intrinsics.checkParameterIsNotNull(vec3, "$receiver");
        return VecExtensionsKt.add(vec3, d, d, d);
    }

    @NotNull
    public static final Vec3 minus(@NotNull Vec3 vec3, double d) {
        Intrinsics.checkParameterIsNotNull(vec3, "$receiver");
        return VecExtensionsKt.sub(vec3, d, d, d);
    }

    @NotNull
    public static final Vec3 times(@NotNull Vec3 vec3, double d) {
        Intrinsics.checkParameterIsNotNull(vec3, "$receiver");
        return VecExtensionsKt.mul(vec3, d, d, d);
    }

    @NotNull
    public static final Vec3 div(@NotNull Vec3 vec3, double d) {
        Intrinsics.checkParameterIsNotNull(vec3, "$receiver");
        return VecExtensionsKt.div(vec3, d, d, d);
    }

    @NotNull
    public static final Vec3 plus(@NotNull Vec3 vec3, @NotNull Vec3 vec32) {
        Intrinsics.checkParameterIsNotNull(vec3, "$receiver");
        Intrinsics.checkParameterIsNotNull(vec32, "vec");
        return VecExtensionsKt.addVector(vec3, vec32);
    }

    @NotNull
    public static final Vec3 minus(@NotNull Vec3 vec3, @NotNull Vec3 vec32) {
        Intrinsics.checkParameterIsNotNull(vec3, "$receiver");
        Intrinsics.checkParameterIsNotNull(vec32, "vec");
        return VecExtensionsKt.subVector(vec3, vec32);
    }

    @NotNull
    public static final Vec3 times(@NotNull Vec3 vec3, @NotNull Vec3 vec32) {
        Intrinsics.checkParameterIsNotNull(vec3, "$receiver");
        Intrinsics.checkParameterIsNotNull(vec32, "vec");
        return VecExtensionsKt.mulVector(vec3, vec32);
    }

    @NotNull
    public static final Vec3 div(@NotNull Vec3 vec3, @NotNull Vec3 vec32) {
        Intrinsics.checkParameterIsNotNull(vec3, "$receiver");
        Intrinsics.checkParameterIsNotNull(vec32, "vec");
        return VecExtensionsKt.divVector(vec3, vec32);
    }

    public static final double distanceSq(@NotNull Vec3 vec3, @NotNull Vec3 vec32) {
        Intrinsics.checkParameterIsNotNull(vec3, "$receiver");
        Intrinsics.checkParameterIsNotNull(vec32, "v");
        return (VecExtensionsKt.getX(vec32) - VecExtensionsKt.getX(vec3)) * (VecExtensionsKt.getX(vec32) - VecExtensionsKt.getX(vec3)) + (VecExtensionsKt.getY(vec32) - VecExtensionsKt.getY(vec3)) * (VecExtensionsKt.getY(vec32) - VecExtensionsKt.getY(vec3)) + (VecExtensionsKt.getZ(vec32) - VecExtensionsKt.getZ(vec3)) * (VecExtensionsKt.getZ(vec32) - VecExtensionsKt.getZ(vec3));
    }

    public static final double distance(@NotNull Vec3 vec3, @NotNull Vec3 vec32) {
        Intrinsics.checkParameterIsNotNull(vec3, "$receiver");
        Intrinsics.checkParameterIsNotNull(vec32, "v");
        return VecExtensionsKt.sqrt(VecExtensionsKt.distanceSq(vec3, vec32));
    }

    public static final double dot(@NotNull Vec3 vec3, @NotNull Vec3 vec32) {
        Intrinsics.checkParameterIsNotNull(vec3, "$receiver");
        Intrinsics.checkParameterIsNotNull(vec32, "v");
        return VecExtensionsKt.getX(vec3) * VecExtensionsKt.getX(vec32) + VecExtensionsKt.getY(vec3) * VecExtensionsKt.getY(vec32) + VecExtensionsKt.getZ(vec3) * VecExtensionsKt.getZ(vec32);
    }

    @NotNull
    public static final Vec3 cross(@NotNull Vec3 vec3, @NotNull Vec3 vec32) {
        Intrinsics.checkParameterIsNotNull(vec3, "$receiver");
        Intrinsics.checkParameterIsNotNull(vec32, "v");
        return VecExtensionsKt.createVec3mc(VecExtensionsKt.getY(vec3) * VecExtensionsKt.getZ(vec32) - VecExtensionsKt.getZ(vec3) * VecExtensionsKt.getY(vec32), VecExtensionsKt.getZ(vec3) * VecExtensionsKt.getX(vec32) - VecExtensionsKt.getX(vec3) * VecExtensionsKt.getZ(vec32), VecExtensionsKt.getX(vec3) * VecExtensionsKt.getY(vec32) - VecExtensionsKt.getY(vec3) * VecExtensionsKt.getX(vec32));
    }

    public static final double angleBetween(@NotNull Vec3 vec3, @NotNull Vec3 vec32) {
        Intrinsics.checkParameterIsNotNull(vec3, "$receiver");
        Intrinsics.checkParameterIsNotNull(vec32, "v");
        double d = VecExtensionsKt.dot(vec3, vec32) / (VecExtensionsKt.length(vec3) * VecExtensionsKt.length(vec32));
        if (d < -1.0) {
            d = -1.0;
        } else if (d > 1.0) {
            d = 1.0;
        }
        return Math.acos(d);
    }

    public static final double nonZeroLength(@NotNull Vec3 vec3) {
        Intrinsics.checkParameterIsNotNull(vec3, "$receiver");
        double d = VecExtensionsKt.length(vec3);
        if (d == 0.0) {
            throw (Throwable)new IllegalStateException("Zero length vector");
        }
        return d;
    }

    public static final boolean isUnit(@NotNull Vec3 vec3) {
        Intrinsics.checkParameterIsNotNull(vec3, "$receiver");
        return VecExtensionsKt.lengthSquared(vec3) == 1.0;
    }

    public static final boolean isEqual(@NotNull Vec3 vec3, @NotNull Vec3 vec32) {
        Intrinsics.checkParameterIsNotNull(vec3, "$receiver");
        Intrinsics.checkParameterIsNotNull(vec32, "v");
        return Intrinsics.areEqual(vec32, vec3) || owkq._e(VecExtensionsKt.getX(vec32) - VecExtensionsKt.getX(vec3)) < (double)EPSILON && owkq._e(VecExtensionsKt.getY(vec32) - VecExtensionsKt.getY(vec3)) < (double)EPSILON && owkq._e(VecExtensionsKt.getZ(vec32) - VecExtensionsKt.getZ(vec3)) < (double)EPSILON;
    }

    public static final boolean isNan(@NotNull Vec3 vec3) {
        Intrinsics.checkParameterIsNotNull(vec3, "$receiver");
        double d = VecExtensionsKt.getX(vec3);
        return Double.isNaN(d) || VecExtensionsKt.getX(vec3) == DoubleCompanionObject.INSTANCE.getNaN() || Double.isNaN(d = VecExtensionsKt.getY(vec3)) || VecExtensionsKt.getY(vec3) == DoubleCompanionObject.INSTANCE.getNaN() || Double.isNaN(d = VecExtensionsKt.getZ(vec3)) || VecExtensionsKt.getZ(vec3) == DoubleCompanionObject.INSTANCE.getNaN();
    }

    public static final double lengthSquared(@NotNull Vec3 vec3) {
        Intrinsics.checkParameterIsNotNull(vec3, "$receiver");
        return VecExtensionsKt.getX(vec3) * VecExtensionsKt.getX(vec3) + VecExtensionsKt.getY(vec3) * VecExtensionsKt.getY(vec3) + VecExtensionsKt.getZ(vec3) * VecExtensionsKt.getZ(vec3);
    }

    public static final double length(@NotNull Vec3 vec3) {
        Intrinsics.checkParameterIsNotNull(vec3, "$receiver");
        return VecExtensionsKt.sqrt(VecExtensionsKt.lengthSquared(vec3));
    }

    static {
        EPSILON = 1.0E-4f;
        DOT_EPSILON = 0.9995f;
    }
}

