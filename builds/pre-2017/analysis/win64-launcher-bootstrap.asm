
; Function range 0000000140001000..0000000140001035
0000000140001000: 48895c2408               mov      qword ptr [rsp + 8], rbx
0000000140001005: 57                       push     rdi
0000000140001006: 4883ec20                 sub      rsp, 0x20
000000014000100a: 488bfa                   mov      rdi, rdx
000000014000100d: 498bd0                   mov      rdx, r8
0000000140001010: 488bd9                   mov      rbx, rcx
0000000140001013: ff15f7cf0000             call     qword ptr [rip + 0xcff7] ; GetProcAddress
0000000140001019: 4885c0                   test     rax, rax
000000014000101c: 750c                     jne      0x14000102a
000000014000101e: 488bd7                   mov      rdx, rdi
0000000140001021: 488bcb                   mov      rcx, rbx
0000000140001024: ff15e6cf0000             call     qword ptr [rip + 0xcfe6] ; GetProcAddress
000000014000102a: 488b5c2430               mov      rbx, qword ptr [rsp + 0x30]
000000014000102f: 4883c420                 add      rsp, 0x20
0000000140001033: 5f                       pop      rdi
0000000140001034: c3                       ret      

; Function range 0000000140001038..0000000140001277
0000000140001038: 488bc4                   mov      rax, rsp
000000014000103b: 48895808                 mov      qword ptr [rax + 8], rbx
000000014000103f: 48896810                 mov      qword ptr [rax + 0x10], rbp
0000000140001043: 48897018                 mov      qword ptr [rax + 0x18], rsi
0000000140001047: 48897820                 mov      qword ptr [rax + 0x20], rdi
000000014000104b: 4154                     push     r12
000000014000104d: 4156                     push     r14
000000014000104f: 4157                     push     r15
0000000140001051: 4883ec70                 sub      rsp, 0x70
0000000140001055: 488d0d94d20000           lea      rcx, [rip + 0xd294] ; server\jvm.dll
000000014000105c: ff15b6cf0000             call     qword ptr [rip + 0xcfb6] ; LoadLibraryA
0000000140001062: 488bd8                   mov      rbx, rax
0000000140001065: 4885c0                   test     rax, rax
0000000140001068: 751d                     jne      0x140001087
000000014000106a: ff1598cf0000             call     qword ptr [rip + 0xcf98] ; GetLastError
0000000140001070: 488d0d89d20000           lea      rcx, [rip + 0xd289]
0000000140001077: 8bd0                     mov      edx, eax
0000000140001079: 8bd8                     mov      ebx, eax
000000014000107b: e820030000               call     0x1400013a0
0000000140001080: 8bc3                     mov      eax, ebx
0000000140001082: e9d1010000               jmp      0x140001258
0000000140001087: 4c8d0592d20000           lea      r8, [rip + 0xd292] ; 137bc867174a904f42a8efa61d836687
000000014000108e: 488d15b3d20000           lea      rdx, [rip + 0xd2b3] ; JLI_InitArgProcessing
0000000140001095: 488bc8                   mov      rcx, rax
0000000140001098: e863ffffff               call     0x140001000
000000014000109d: 488bf8                   mov      rdi, rax
00000001400010a0: 4885c0                   test     rax, rax
00000001400010a3: 750a                     jne      0x1400010af
00000001400010a5: b801000000               mov      eax, 1
00000001400010aa: e9a9010000               jmp      0x140001258
00000001400010af: 4c8d05aad20000           lea      r8, [rip + 0xd2aa] ; c37c45bdb56ed218e567719525bfad0e
00000001400010b6: 488d15cbd20000           lea      rdx, [rip + 0xd2cb] ; JLI_CmdToArgs
00000001400010bd: 488bcb                   mov      rcx, rbx
00000001400010c0: e83bffffff               call     0x140001000
00000001400010c5: 488bf0                   mov      rsi, rax
00000001400010c8: 4885c0                   test     rax, rax
00000001400010cb: 74d8                     je       0x1400010a5
00000001400010cd: 4c8d05c4d20000           lea      r8, [rip + 0xd2c4] ; 0e507ffc4f5371b5271f03ac97484fe0
00000001400010d4: 488d15e5d20000           lea      rdx, [rip + 0xd2e5] ; JLI_GetStdArgc
00000001400010db: 488bcb                   mov      rcx, rbx
00000001400010de: e81dffffff               call     0x140001000
00000001400010e3: 488be8                   mov      rbp, rax
00000001400010e6: 4885c0                   test     rax, rax
00000001400010e9: 74ba                     je       0x1400010a5
00000001400010eb: 4c8d05ded20000           lea      r8, [rip + 0xd2de] ; 1ee12e87292680737f1c121af6cabfe0
00000001400010f2: 488d15ffd20000           lea      rdx, [rip + 0xd2ff] ; JLI_MemAlloc
00000001400010f9: 488bcb                   mov      rcx, rbx
00000001400010fc: e8fffeffff               call     0x140001000
0000000140001101: 4c8bf0                   mov      r14, rax
0000000140001104: 4885c0                   test     rax, rax
0000000140001107: 749c                     je       0x1400010a5
0000000140001109: 4c8d05f8d20000           lea      r8, [rip + 0xd2f8] ; f5199c4078a19150bc6c85942e593153
0000000140001110: 488d1519d30000           lea      rdx, [rip + 0xd319] ; JLI_GetStdArgs
0000000140001117: 488bcb                   mov      rcx, rbx
000000014000111a: e8e1feffff               call     0x140001000
000000014000111f: 4c8d051ad30000           lea      r8, [rip + 0xd31a] ; 9b490ffc0189e74ef6ca6c1079e09043
0000000140001126: 488d153bd30000           lea      rdx, [rip + 0xd33b] ; JLI_Launch
000000014000112d: 488bcb                   mov      rcx, rbx
0000000140001130: 4c8be0                   mov      r12, rax
0000000140001133: e8c8feffff               call     0x140001000
0000000140001138: 4c8bf8                   mov      r15, rax
000000014000113b: 4885c0                   test     rax, rax
000000014000113e: 0f8461ffffff             je       0x1400010a5
0000000140001144: 33d2                     xor      edx, edx
0000000140001146: b101                     mov      cl, 1
0000000140001148: ffd7                     call     rdi
000000014000114a: 488d0d27d30000           lea      rcx, [rip + 0xd327]
0000000140001151: e8c6010000               call     0x14000131c
0000000140001156: 4885c0                   test     rax, rax
0000000140001159: 743f                     je       0x14000119a
000000014000115b: 488d0d2ed30000           lea      rcx, [rip + 0xd32e]
0000000140001162: e839020000               call     0x1400013a0
0000000140001167: 33db                     xor      ebx, ebx
0000000140001169: 391d8d540100             cmp      dword ptr [rip + 0x1548d], ebx
000000014000116f: 7e29                     jle      0x14000119a
0000000140001171: 33ff                     xor      edi, edi
0000000140001173: 4c8b0586540100           mov      r8, qword ptr [rip + 0x15486]
000000014000117a: 488d0d2fd30000           lea      rcx, [rip + 0xd32f]
0000000140001181: 8bd3                     mov      edx, ebx
0000000140001183: 4e8b0407                 mov      r8, qword ptr [rdi + r8]
0000000140001187: e814020000               call     0x1400013a0
000000014000118c: ffc3                     inc      ebx
000000014000118e: 488d7f08                 lea      rdi, [rdi + 8]
0000000140001192: 3b1d64540100             cmp      ebx, dword ptr [rip + 0x15464]
0000000140001198: 7cd9                     jl       0x140001173
000000014000119a: ff1560ce0000             call     qword ptr [rip + 0xce60] ; GetCommandLineA
00000001400011a0: 488bc8                   mov      rcx, rax
00000001400011a3: ffd6                     call     rsi
00000001400011a5: ffd5                     call     rbp
00000001400011a7: 4863f8                   movsxd   rdi, eax
00000001400011aa: 8d4f01                   lea      ecx, [rdi + 1]
00000001400011ad: 4863c9                   movsxd   rcx, ecx
00000001400011b0: 48c1e103                 shl      rcx, 3
00000001400011b4: 41ffd6                   call     r14
00000001400011b7: 488bd8                   mov      rbx, rax
00000001400011ba: 41ffd4                   call     r12
00000001400011bd: 4533c9                   xor      r9d, r9d
00000001400011c0: 33d2                     xor      edx, edx
00000001400011c2: 85ff                     test     edi, edi
00000001400011c4: 7e16                     jle      0x1400011dc
00000001400011c6: 448bcf                   mov      r9d, edi
00000001400011c9: 488b08                   mov      rcx, qword ptr [rax]
00000001400011cc: 488d4010                 lea      rax, [rax + 0x10]
00000001400011d0: 48890cd3                 mov      qword ptr [rbx + rdx*8], rcx
00000001400011d4: 48ffc2                   inc      rdx
00000001400011d7: 483bd7                   cmp      rdx, rdi
00000001400011da: 7ced                     jl       0x1400011c9
00000001400011dc: 488b0d253e0100           mov      rcx, qword ptr [rip + 0x13e25]
00000001400011e3: 4963c1                   movsxd   rax, r9d
00000001400011e6: 488324c300               and      qword ptr [rbx + rax*8], 0
00000001400011eb: 4885c9                   test     rcx, rcx
00000001400011ee: 7503                     jne      0x1400011f3
00000001400011f0: 488b0b                   mov      rcx, qword ptr [rbx]
00000001400011f3: 488b05063e0100           mov      rax, qword ptr [rip + 0x13e06]
00000001400011fa: 4885c0                   test     rax, rax
00000001400011fd: 7503                     jne      0x140001202
00000001400011ff: 488b03                   mov      rax, qword ptr [rbx]
0000000140001202: 8364246800               and      dword ptr [rsp + 0x68], 0
0000000140001207: 4c8b0dd2530100           mov      r9, qword ptr [rip + 0x153d2]
000000014000120e: c644246000               mov      byte ptr [rsp + 0x60], 0
0000000140001213: c644245801               mov      byte ptr [rsp + 0x58], 1
0000000140001218: c644245000               mov      byte ptr [rsp + 0x50], 0
000000014000121d: 48894c2448               mov      qword ptr [rsp + 0x48], rcx
0000000140001222: 4889442440               mov      qword ptr [rsp + 0x40], rax
0000000140001227: 488d0596d20000           lea      rax, [rip + 0xd296]
000000014000122e: 41b801000000             mov      r8d, 1
0000000140001234: 4889442438               mov      qword ptr [rsp + 0x38], rax
0000000140001239: 488d0588d20000           lea      rax, [rip + 0xd288] ; 9-internal+0-adhoc.Folken.jdk9
0000000140001240: 488bd3                   mov      rdx, rbx
0000000140001243: 4889442430               mov      qword ptr [rsp + 0x30], rax
0000000140001248: 488364242800             and      qword ptr [rsp + 0x28], 0
000000014000124e: 8364242000               and      dword ptr [rsp + 0x20], 0
0000000140001253: 8bcf                     mov      ecx, edi
0000000140001255: 41ffd7                   call     r15
0000000140001258: 4c8d5c2470               lea      r11, [rsp + 0x70]
000000014000125d: 498b5b20                 mov      rbx, qword ptr [r11 + 0x20]
0000000140001261: 498b6b28                 mov      rbp, qword ptr [r11 + 0x28]
0000000140001265: 498b7330                 mov      rsi, qword ptr [r11 + 0x30]
0000000140001269: 498b7b38                 mov      rdi, qword ptr [r11 + 0x38]
000000014000126d: 498be3                   mov      rsp, r11
0000000140001270: 415f                     pop      r15
0000000140001272: 415e                     pop      r14
0000000140001274: 415c                     pop      r12
0000000140001276: c3                       ret      
