
; Function range 0000000000400fa5..000000000040129f
0000000000401000: ff74240c                 push     dword ptr [esp + 0xc]
0000000000401004: ff742408                 push     dword ptr [esp + 8]
0000000000401008: ff1508d04000             call     dword ptr [0x40d008] ; GetProcAddress
000000000040100e: 85c0                     test     eax, eax
0000000000401010: 750e                     jne      0x401020
0000000000401012: ff742408                 push     dword ptr [esp + 8]
0000000000401016: ff742408                 push     dword ptr [esp + 8]
000000000040101a: ff1508d04000             call     dword ptr [0x40d008] ; GetProcAddress
0000000000401020: c3                       ret      
0000000000401021: 83ec0c                   sub      esp, 0xc
0000000000401024: 56                       push     esi
0000000000401025: 688cd14000               push     0x40d18c ; server\jvm.dll
000000000040102a: ff150cd04000             call     dword ptr [0x40d00c] ; LoadLibraryA
0000000000401030: 8bf0                     mov      esi, eax
0000000000401032: 85f6                     test     esi, esi
0000000000401034: 751c                     jne      0x401052
0000000000401036: ff1504d04000             call     dword ptr [0x40d004] ; GetLastError
000000000040103c: 8bf0                     mov      esi, eax
000000000040103e: 56                       push     esi
000000000040103f: 689cd14000               push     0x40d19c
0000000000401044: e88c020000               call     0x4012d5
0000000000401049: 59                       pop      ecx
000000000040104a: 59                       pop      ecx
000000000040104b: 8bc6                     mov      eax, esi
000000000040104d: e965010000               jmp      0x4011b7
0000000000401052: 57                       push     edi
0000000000401053: 68b8d14000               push     0x40d1b8 ; 137bc867174a904f42a8efa61d836687
0000000000401058: 68dcd14000               push     0x40d1dc ; JLI_InitArgProcessing
000000000040105d: 56                       push     esi
000000000040105e: e89dffffff               call     0x401000
0000000000401063: 8bf8                     mov      edi, eax
0000000000401065: 83c40c                   add      esp, 0xc
0000000000401068: 85ff                     test     edi, edi
000000000040106a: 7506                     jne      0x401072
000000000040106c: 40                       inc      eax
000000000040106d: e944010000               jmp      0x4011b6
0000000000401072: 53                       push     ebx
0000000000401073: 68f4d14000               push     0x40d1f4 ; c37c45bdb56ed218e567719525bfad0e
0000000000401078: 6818d24000               push     0x40d218 ; JLI_CmdToArgs
000000000040107d: 56                       push     esi
000000000040107e: e87dffffff               call     0x401000
0000000000401083: 8bd8                     mov      ebx, eax
0000000000401085: 83c40c                   add      esp, 0xc
0000000000401088: 85db                     test     ebx, ebx
000000000040108a: 7506                     jne      0x401092
000000000040108c: 40                       inc      eax
000000000040108d: e923010000               jmp      0x4011b5
0000000000401092: 55                       push     ebp
0000000000401093: 6828d24000               push     0x40d228 ; 0e507ffc4f5371b5271f03ac97484fe0
0000000000401098: 684cd24000               push     0x40d24c ; JLI_GetStdArgc
000000000040109d: 56                       push     esi
000000000040109e: e85dffffff               call     0x401000
00000000004010a3: 8be8                     mov      ebp, eax
00000000004010a5: 83c40c                   add      esp, 0xc
00000000004010a8: 85ed                     test     ebp, ebp
00000000004010aa: 744a                     je       0x4010f6
00000000004010ac: 685cd24000               push     0x40d25c ; 1ee12e87292680737f1c121af6cabfe0
00000000004010b1: 6880d24000               push     0x40d280 ; JLI_MemAlloc
00000000004010b6: 56                       push     esi
00000000004010b7: e844ffffff               call     0x401000
00000000004010bc: 83c40c                   add      esp, 0xc
00000000004010bf: 89442410                 mov      dword ptr [esp + 0x10], eax
00000000004010c3: 85c0                     test     eax, eax
00000000004010c5: 742f                     je       0x4010f6
00000000004010c7: 6890d24000               push     0x40d290 ; f5199c4078a19150bc6c85942e593153
00000000004010cc: 68b4d24000               push     0x40d2b4 ; JLI_GetStdArgs
00000000004010d1: 56                       push     esi
00000000004010d2: e829ffffff               call     0x401000
00000000004010d7: 68c4d24000               push     0x40d2c4 ; 9b490ffc0189e74ef6ca6c1079e09043
00000000004010dc: 68e8d24000               push     0x40d2e8 ; JLI_Launch
00000000004010e1: 56                       push     esi
00000000004010e2: 8944242c                 mov      dword ptr [esp + 0x2c], eax
00000000004010e6: e815ffffff               call     0x401000
00000000004010eb: 83c418                   add      esp, 0x18
00000000004010ee: 89442418                 mov      dword ptr [esp + 0x18], eax
00000000004010f2: 85c0                     test     eax, eax
00000000004010f4: 7508                     jne      0x4010fe
00000000004010f6: 33c0                     xor      eax, eax
00000000004010f8: 40                       inc      eax
00000000004010f9: e9b6000000               jmp      0x4011b4
00000000004010fe: 6a00                     push     0
0000000000401100: 6a01                     push     1
0000000000401102: ffd7                     call     edi
0000000000401104: 68f4d24000               push     0x40d2f4
0000000000401109: e832010000               call     0x401240
000000000040110e: 59                       pop      ecx
000000000040110f: 85c0                     test     eax, eax
0000000000401111: 7434                     je       0x401147
0000000000401113: 680cd34000               push     0x40d30c
0000000000401118: e8b8010000               call     0x4012d5
000000000040111d: 33f6                     xor      esi, esi
000000000040111f: 59                       pop      ecx
0000000000401120: 3935f0304100             cmp      dword ptr [0x4130f0], esi
0000000000401126: 7e1f                     jle      0x401147
0000000000401128: a1f4304100               mov      eax, dword ptr [0x4130f4]
000000000040112d: ff34b0                   push     dword ptr [eax + esi*4]
0000000000401130: 56                       push     esi
0000000000401131: 682cd34000               push     0x40d32c
0000000000401136: e89a010000               call     0x4012d5
000000000040113b: 83c40c                   add      esp, 0xc
000000000040113e: 46                       inc      esi
000000000040113f: 3b35f0304100             cmp      esi, dword ptr [0x4130f0]
0000000000401145: 7ce1                     jl       0x401128
0000000000401147: ff1500d04000             call     dword ptr [0x40d000] ; GetCommandLineA
000000000040114d: 50                       push     eax
000000000040114e: ffd3                     call     ebx
0000000000401150: ffd5                     call     ebp
0000000000401152: 8bf8                     mov      edi, eax
0000000000401154: 8d0cbd04000000           lea      ecx, [edi*4 + 4]
000000000040115b: 51                       push     ecx
000000000040115c: ff542414                 call     dword ptr [esp + 0x14]
0000000000401160: 8bf0                     mov      esi, eax
0000000000401162: ff542414                 call     dword ptr [esp + 0x14]
0000000000401166: 33db                     xor      ebx, ebx
0000000000401168: 8bd3                     mov      edx, ebx
000000000040116a: 85ff                     test     edi, edi
000000000040116c: 7e0b                     jle      0x401179
000000000040116e: 8b0cd0                   mov      ecx, dword ptr [eax + edx*8]
0000000000401171: 890c96                   mov      dword ptr [esi + edx*4], ecx
0000000000401174: 42                       inc      edx
0000000000401175: 3bd7                     cmp      edx, edi
0000000000401177: 7cf5                     jl       0x40116e
0000000000401179: 8b0d04204100             mov      ecx, dword ptr [0x412004]
000000000040117f: 891c96                   mov      dword ptr [esi + edx*4], ebx
0000000000401182: 85c9                     test     ecx, ecx
0000000000401184: 7502                     jne      0x401188
0000000000401186: 8b0e                     mov      ecx, dword ptr [esi]
0000000000401188: a100204100               mov      eax, dword ptr [0x412000]
000000000040118d: 85c0                     test     eax, eax
000000000040118f: 7502                     jne      0x401193
0000000000401191: 8b06                     mov      eax, dword ptr [esi]
0000000000401193: 53                       push     ebx
0000000000401194: 53                       push     ebx
0000000000401195: 6a01                     push     1
0000000000401197: 53                       push     ebx
0000000000401198: 51                       push     ecx
0000000000401199: 50                       push     eax
000000000040119a: 6840d34000               push     0x40d340
000000000040119f: 6844d34000               push     0x40d344 ; 9-internal+0-adhoc.Folken.jdk9
00000000004011a4: 53                       push     ebx
00000000004011a5: 53                       push     ebx
00000000004011a6: ff35e0304100             push     dword ptr [0x4130e0]
00000000004011ac: 6a01                     push     1
00000000004011ae: 56                       push     esi
00000000004011af: 57                       push     edi
00000000004011b0: ff542450                 call     dword ptr [esp + 0x50]
00000000004011b4: 5d                       pop      ebp
00000000004011b5: 5b                       pop      ebx
00000000004011b6: 5f                       pop      edi
00000000004011b7: 5e                       pop      esi
00000000004011b8: 83c40c                   add      esp, 0xc
00000000004011bb: c3                       ret      
00000000004011bc: 55                       push     ebp
00000000004011bd: 8bec                     mov      ebp, esp
00000000004011bf: 833d404f410000           cmp      dword ptr [0x414f40], 0
00000000004011c6: 56                       push     esi
00000000004011c7: 8b35fc304100             mov      esi, dword ptr [0x4130fc]
00000000004011cd: 7504                     jne      0x4011d3
00000000004011cf: 33c0                     xor      eax, eax
00000000004011d1: eb63                     jmp      0x401236
00000000004011d3: 57                       push     edi
00000000004011d4: 85f6                     test     esi, esi
00000000004011d6: 751b                     jne      0x4011f3
00000000004011d8: 393500314100             cmp      dword ptr [0x413100], esi
00000000004011de: 7453                     je       0x401233
00000000004011e0: e8400a0000               call     0x401c25
00000000004011e5: 85c0                     test     eax, eax
00000000004011e7: 754a                     jne      0x401233
00000000004011e9: 8b35fc304100             mov      esi, dword ptr [0x4130fc]
00000000004011ef: 85f6                     test     esi, esi
00000000004011f1: 7440                     je       0x401233
00000000004011f3: 837d0800                 cmp      dword ptr [ebp + 8], 0
00000000004011f7: 743a                     je       0x401233
00000000004011f9: ff7508                   push     dword ptr [ebp + 8]
00000000004011fc: e8ff070000               call     0x401a00
0000000000401201: 59                       pop      ecx
0000000000401202: 8bf8                     mov      edi, eax
0000000000401204: eb27                     jmp      0x40122d
0000000000401206: 51                       push     ecx
0000000000401207: e8f4070000               call     0x401a00
000000000040120c: 59                       pop      ecx
000000000040120d: 3bc7                     cmp      eax, edi
000000000040120f: 7619                     jbe      0x40122a
0000000000401211: 8b06                     mov      eax, dword ptr [esi]
0000000000401213: 803c383d                 cmp      byte ptr [eax + edi], 0x3d
0000000000401217: 7511                     jne      0x40122a
0000000000401219: 57                       push     edi
000000000040121a: ff7508                   push     dword ptr [ebp + 8]
000000000040121d: 50                       push     eax
000000000040121e: e8a10b0000               call     0x401dc4
0000000000401223: 83c40c                   add      esp, 0xc
0000000000401226: 85c0                     test     eax, eax
0000000000401228: 740f                     je       0x401239
000000000040122a: 83c604                   add      esi, 4
000000000040122d: 8b0e                     mov      ecx, dword ptr [esi]
000000000040122f: 85c9                     test     ecx, ecx
0000000000401231: 75d3                     jne      0x401206
0000000000401233: 33c0                     xor      eax, eax
0000000000401235: 5f                       pop      edi
0000000000401236: 5e                       pop      esi
0000000000401237: 5d                       pop      ebp
0000000000401238: c3                       ret      
0000000000401239: 8b06                     mov      eax, dword ptr [esi]
000000000040123b: 40                       inc      eax
000000000040123c: 03c7                     add      eax, edi
000000000040123e: ebf5                     jmp      0x401235
0000000000401240: 6a0c                     push     0xc
0000000000401242: 68c0104100               push     0x4110c0
0000000000401247: e8540c0000               call     0x401ea0
000000000040124c: 8365e400                 and      dword ptr [ebp - 0x1c], 0
0000000000401250: 33c0                     xor      eax, eax
0000000000401252: 8b7508                   mov      esi, dword ptr [ebp + 8]
0000000000401255: 85f6                     test     esi, esi
0000000000401257: 0f95c0                   setne    al
000000000040125a: 85c0                     test     eax, eax
000000000040125c: 7514                     jne      0x401272
000000000040125e: e8850a0000               call     0x401ce8
0000000000401263: c70016000000             mov      dword ptr [eax], 0x16
0000000000401269: e8f9060000               call     0x401967
000000000040126e: 33c0                     xor      eax, eax
0000000000401270: eb3c                     jmp      0x4012ae
0000000000401272: bfff7f0000               mov      edi, 0x7fff
0000000000401277: 57                       push     edi
0000000000401278: 56                       push     esi
0000000000401279: e80d080000               call     0x401a8b
000000000040127e: 59                       pop      ecx
000000000040127f: 59                       pop      ecx
0000000000401280: 3bc7                     cmp      eax, edi
0000000000401282: 1bc0                     sbb      eax, eax
0000000000401284: f7d8                     neg      eax
0000000000401286: 74d6                     je       0x40125e
0000000000401288: 6a07                     push     7
000000000040128a: e817080000               call     0x401aa6
000000000040128f: 59                       pop      ecx
0000000000401290: 8365fc00                 and      dword ptr [ebp - 4], 0
0000000000401294: 56                       push     esi
0000000000401295: e822ffffff               call     0x4011bc
000000000040129a: 59                       pop      ecx
000000000040129b: 8bf0                     mov      esi, eax
000000000040129d: 8975e4                   mov      dword ptr [ebp - 0x1c], esi
