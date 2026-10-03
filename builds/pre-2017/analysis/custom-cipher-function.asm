003ab230 48895c2420 mov      qword ptr [rsp + 0x20], rbx
003ab235 55 push     rbp
003ab236 56 push     rsi
003ab237 57 push     rdi
003ab238 4154 push     r12
003ab23a 4155 push     r13
003ab23c 4156 push     r14
003ab23e 4157 push     r15
003ab240 488d6c2490 lea      rbp, [rsp - 0x70]
003ab245 4881ec70010000 sub      rsp, 0x170
003ab24c 488b059ded6900 mov      rax, qword ptr [rip + 0x69ed9d]
003ab253 4833c4 xor      rax, rsp
003ab256 48894560 mov      qword ptr [rbp + 0x60], rax
003ab25a 498bd9 mov      rbx, r9
003ab25d 418bf8 mov      edi, r8d
003ab260 4889542460 mov      qword ptr [rsp + 0x60], rdx
003ab265 488bf1 mov      rsi, rcx
003ab268 e8a3ffffff call     0x3ab210
003ab26d 41b1e7 mov      r9b, 0xe7
003ab270 4863d0 movsxd   rdx, eax
003ab273 65488b042560000000 mov      rax, qword ptr gs:[0x60]
003ab27c 41b248 mov      r10b, 0x48
003ab27f 440fb64002 movzx    r8d, byte ptr [rax + 2]
003ab284 4803f2 add      rsi, rdx
003ab287 8bc7 mov      eax, edi
003ab289 99 cdq      
003ab28a 4889742450 mov      qword ptr [rsp + 0x50], rsi
003ab28f c74540e7488b84 mov      dword ptr [rbp + 0x40], 0x848b48e7
003ab296 2bc2 sub      eax, edx
003ab298 41b38b mov      r11b, 0x8b
003ab29b 40b65f mov      sil, 0x5f
003ab29e d1f8 sar      eax, 1
003ab2a0 c745445f71f6cc mov      dword ptr [rbp + 0x44], 0xccf6715f
003ab2a7 41b671 mov      r14b, 0x71
003ab2aa f7d8 neg      eax
003ab2ac 41b7f6 mov      r15b, 0xf6
003ab2af 41b4cc mov      r12b, 0xcc
003ab2b2 41b5cf mov      r13b, 0xcf
003ab2b5 c74548cfb8945c mov      dword ptr [rbp + 0x48], 0x5c94b8cf
003ab2bc c7454cc05d1f0d mov      dword ptr [rbp + 0x4c], 0xd1f5dc0
003ab2c3 440fafc0 imul     r8d, eax
003ab2c7 4103f8 add      edi, r8d
003ab2ca 48c7455000000000 mov      qword ptr [rbp + 0x50], 0
003ab2d2 48c7455800000000 mov      qword ptr [rbp + 0x58], 0
003ab2da 897c2424 mov      dword ptr [rsp + 0x24], edi
003ab2de 40b784 mov      dil, 0x84
003ab2e1 4883caff or       rdx, 0xffffffffffffffff
003ab2e5 48ffc2 inc      rdx
003ab2e8 803c1300 cmp      byte ptr [rbx + rdx], 0
003ab2ec 75f7 jne      0x3ab2e5
003ab2ee 33c9 xor      ecx, ecx
003ab2f0 48894c2438 mov      qword ptr [rsp + 0x38], rcx
003ab2f5 83fa06 cmp      edx, 6
003ab2f8 7c2b jl       0x3ab325
003ab2fa 4c63c2 movsxd   r8, edx
003ab2fd 4c03c3 add      r8, rbx
003ab300 410fb64408fa movzx    eax, byte ptr [r8 + rcx - 6]
003ab306 4c8d0ddff84e00 lea      r9, [rip + 0x4ef8df]
003ab30d 48ffc1 inc      rcx
003ab310 413a4409ff cmp      al, byte ptr [r9 + rcx - 1]
003ab315 440fb64d40 movzx    r9d, byte ptr [rbp + 0x40]
003ab31a 7509 jne      0x3ab325
003ab31c 4883f907 cmp      rcx, 7
003ab320 75de jne      0x3ab300
003ab322 83ea06 sub      edx, 6
003ab325 4863c2 movsxd   rax, edx
003ab328 4c8d4560 lea      r8, [rbp + 0x60]
003ab32c ba10000000 mov      edx, 0x10
003ab331 4c2bc0 sub      r8, rax
003ab334 488d48f0 lea      rcx, [rax - 0x10]
003ab338 4885c9 test     rcx, rcx
003ab33b 7808 js       0x3ab345
003ab33d 0fb60419 movzx    eax, byte ptr [rcx + rbx]
003ab341 41880408 mov      byte ptr [r8 + rcx], al
003ab345 48ffc1 inc      rcx
003ab348 48ffca dec      rdx
003ab34b 75eb jne      0x3ab338
003ab34d 488b442460 mov      rax, qword ptr [rsp + 0x60]
003ab352 488b5c2450 mov      rbx, qword ptr [rsp + 0x50]
003ab357 483bd8 cmp      rbx, rax
003ab35a 7535 jne      0x3ab391
003ab35c 48634c2424 movsxd   rcx, dword ptr [rsp + 0x24]
003ab361 e80a7d2e00 call     0x693070
003ab366 440fb66d48 movzx    r13d, byte ptr [rbp + 0x48]
003ab36b 440fb66547 movzx    r12d, byte ptr [rbp + 0x47]
003ab370 440fb67d46 movzx    r15d, byte ptr [rbp + 0x46]
003ab375 440fb67545 movzx    r14d, byte ptr [rbp + 0x45]
003ab37a 0fb67544 movzx    esi, byte ptr [rbp + 0x44]
003ab37e 0fb67d43 movzx    edi, byte ptr [rbp + 0x43]
003ab382 440fb65d42 movzx    r11d, byte ptr [rbp + 0x42]
003ab387 440fb65541 movzx    r10d, byte ptr [rbp + 0x41]
003ab38c 440fb64d40 movzx    r9d, byte ptr [rbp + 0x40]
003ab391 4889442458 mov      qword ptr [rsp + 0x58], rax
003ab396 4889442428 mov      qword ptr [rsp + 0x28], rax
003ab39b 488bcb mov      rcx, rbx
003ab39e 48895c2448 mov      qword ptr [rsp + 0x48], rbx
003ab3a3 488bd8 mov      rbx, rax
003ab3a6 8b442424 mov      eax, dword ptr [rsp + 0x24]
003ab3aa 250f000080 and      eax, 0x8000000f
003ab3af 89442430 mov      dword ptr [rsp + 0x30], eax
003ab3b3 7d0b jge      0x3ab3c0
003ab3b5 ffc8 dec      eax
003ab3b7 83c8f0 or       eax, 0xfffffff0
003ab3ba ffc0 inc      eax
003ab3bc 89442430 mov      dword ptr [rsp + 0x30], eax
003ab3c0 488d4540 lea      rax, [rbp + 0x40]
003ab3c4 4885c0 test     rax, rax
003ab3c7 0f8424010000 je       0x3ab4f1
003ab3cd 488d4540 lea      rax, [rbp + 0x40]
003ab3d1 4488542479 mov      byte ptr [rsp + 0x79], r10b
003ab3d6 44884c2478 mov      byte ptr [rsp + 0x78], r9b
003ab3db 48894528 mov      qword ptr [rbp + 0x28], rax
003ab3df 0fb64549 movzx    eax, byte ptr [rbp + 0x49]
003ab3e3 44885c247a mov      byte ptr [rsp + 0x7a], r11b
003ab3e8 884581 mov      byte ptr [rbp - 0x7f], al
003ab3eb 0fb6454a movzx    eax, byte ptr [rbp + 0x4a]
003ab3ef 40887c247b mov      byte ptr [rsp + 0x7b], dil
003ab3f4 884582 mov      byte ptr [rbp - 0x7e], al
003ab3f7 0fb6454b movzx    eax, byte ptr [rbp + 0x4b]
003ab3fb 408874247c mov      byte ptr [rsp + 0x7c], sil
003ab400 884583 mov      byte ptr [rbp - 0x7d], al
003ab403 0fb6454c movzx    eax, byte ptr [rbp + 0x4c]
003ab407 448874247d mov      byte ptr [rsp + 0x7d], r14b
003ab40c 884584 mov      byte ptr [rbp - 0x7c], al
003ab40f 0fb6454d movzx    eax, byte ptr [rbp + 0x4d]
003ab413 44887c247e mov      byte ptr [rsp + 0x7e], r15b
003ab418 884585 mov      byte ptr [rbp - 0x7b], al
003ab41b 0fb6454e movzx    eax, byte ptr [rbp + 0x4e]
003ab41f 448864247f mov      byte ptr [rsp + 0x7f], r12b
003ab424 884586 mov      byte ptr [rbp - 0x7a], al
003ab427 0fb6454f movzx    eax, byte ptr [rbp + 0x4f]
003ab42b 44886d80 mov      byte ptr [rbp - 0x80], r13b
003ab42f 41ba04000000 mov      r10d, 4
003ab435 4c8d442479 lea      r8, [rsp + 0x79]
003ab43a 884587 mov      byte ptr [rbp - 0x79], al
003ab43d 0f1f00 nop      dword ptr [rax]
003ab440 450fb6480b movzx    r9d, byte ptr [r8 + 0xb]
003ab445 410fb6480c movzx    ecx, byte ptr [r8 + 0xc]
003ab44a 410fb6580d movzx    ebx, byte ptr [r8 + 0xd]
003ab44f 410fb6780e movzx    edi, byte ptr [r8 + 0xe]
003ab454 418bc2 mov      eax, r10d
003ab457 99 cdq      
003ab458 83e203 and      edx, 3
003ab45b 03c2 add      eax, edx
003ab45d 448bd8 mov      r11d, eax
003ab460 83e003 and      eax, 3
003ab463 41c1fb02 sar      r11d, 2
003ab467 3bc2 cmp      eax, edx
003ab469 7541 jne      0x3ab4ac
003ab46b 488d358e4bc5ff lea      rsi, [rip - 0x3ab472]
003ab472 0fb6c9 movzx    ecx, cl
003ab475 400fb6c7 movzx    eax, dil
003ab479 410fb6d1 movzx    edx, r9b
003ab47d 440fb68c31f0a68900 movzx    r9d, byte ptr [rcx + rsi + 0x89a6f0]
003ab486 0fb6cb movzx    ecx, bl
003ab489 0fb69c30f0a68900 movzx    ebx, byte ptr [rax + rsi + 0x89a6f0]
003ab491 0fb68c31f0a68900 movzx    ecx, byte ptr [rcx + rsi + 0x89a6f0]
003ab499 0fb6bc32f0a68900 movzx    edi, byte ptr [rdx + rsi + 0x89a6f0]
003ab4a1 4963c3 movsxd   rax, r11d
003ab4a4 44328c30f0aa8900 xor      r9b, byte ptr [rax + rsi + 0x89aaf0]
003ab4ac 413208 xor      cl, byte ptr [r8]
003ab4af 410fb640ff movzx    eax, byte ptr [r8 - 1]
003ab4b4 41ffc2 inc      r10d
003ab4b7 4132c1 xor      al, r9b
003ab4ba 41884810 mov      byte ptr [r8 + 0x10], cl
003ab4be 4983c004 add      r8, 4
003ab4c2 4188400b mov      byte ptr [r8 + 0xb], al
003ab4c6 410fb640fd movzx    eax, byte ptr [r8 - 3]
003ab4cb 32c3 xor      al, bl
003ab4cd 4188400d mov      byte ptr [r8 + 0xd], al
003ab4d1 410fb640fe movzx    eax, byte ptr [r8 - 2]
003ab4d6 4032c7 xor      al, dil
003ab4d9 4188400e mov      byte ptr [r8 + 0xe], al
003ab4dd 4183fa2c cmp      r10d, 0x2c
003ab4e1 0f8c59ffffff jl       0x3ab440
003ab4e7 488b5c2428 mov      rbx, qword ptr [rsp + 0x28]
003ab4ec 488b4c2448 mov      rcx, qword ptr [rsp + 0x48]
003ab4f1 837c242400 cmp      dword ptr [rsp + 0x24], 0
003ab4f6 488d4550 lea      rax, [rbp + 0x50]
003ab4fa 488d3dff4ac5ff lea      rdi, [rip - 0x3ab501]
003ab501 4889442440 mov      qword ptr [rsp + 0x40], rax
003ab506 48894530 mov      qword ptr [rbp + 0x30], rax
003ab50a 0f8e1c070000 jle      0x3abc2c
003ab510 0f1001 movups   xmm0, xmmword ptr [rcx]
003ab513 4c8d4518 lea      r8, [rbp + 0x18]
003ab517 48895c2470 mov      qword ptr [rsp + 0x70], rbx
003ab51c 488bcb mov      rcx, rbx
003ab51f 41b904000000 mov      r9d, 4
003ab525 4c2bc3 sub      r8, rbx
003ab528 0f1103 movups   xmmword ptr [rbx], xmm0
003ab52b 0f1f440000 nop      dword ptr [rax + rax]
003ab530 ba04000000 mov      edx, 4
003ab535 6666660f1f840000000000 nop      word ptr [rax + rax]
003ab540 410fb60408 movzx    eax, byte ptr [r8 + rcx]
003ab545 48ffc1 inc      rcx
003ab548 3041ff xor      byte ptr [rcx - 1], al
003ab54b 48ffca dec      rdx
003ab54e 75f0 jne      0x3ab540
003ab550 49ffc9 dec      r9
003ab553 75db jne      0x3ab530
003ab555 4c8d7d08 lea      r15, [rbp + 8]
003ab559 c644242009 mov      byte ptr [rsp + 0x20], 9
003ab55e 4c8d5302 lea      r10, [rbx + 2]
003ab562 4c2bfb sub      r15, rbx
003ab565 6666660f1f840000000000 nop      word ptr [rax + rax]
003ab570 0fb64309 movzx    eax, byte ptr [rbx + 9]
003ab574 0fb64b0d movzx    ecx, byte ptr [rbx + 0xd]
003ab578 4c8bc3 mov      r8, rbx
003ab57b 88430d mov      byte ptr [rbx + 0xd], al
003ab57e 0fb64305 movzx    eax, byte ptr [rbx + 5]
003ab582 41b904000000 mov      r9d, 4
003ab588 884309 mov      byte ptr [rbx + 9], al
003ab58b 0fb64301 movzx    eax, byte ptr [rbx + 1]
003ab58f 884305 mov      byte ptr [rbx + 5], al
003ab592 884b01 mov      byte ptr [rbx + 1], cl
003ab595 0fb6430a movzx    eax, byte ptr [rbx + 0xa]
003ab599 410fb60a movzx    ecx, byte ptr [r10]
003ab59d 418802 mov      byte ptr [r10], al
003ab5a0 884b0a mov      byte ptr [rbx + 0xa], cl
003ab5a3 0fb6430e movzx    eax, byte ptr [rbx + 0xe]
003ab5a7 0fb64b06 movzx    ecx, byte ptr [rbx + 6]
003ab5ab 884306 mov      byte ptr [rbx + 6], al
003ab5ae 884b0e mov      byte ptr [rbx + 0xe], cl
003ab5b1 0fb64307 movzx    eax, byte ptr [rbx + 7]
003ab5b5 0fb64b03 movzx    ecx, byte ptr [rbx + 3]
003ab5b9 884303 mov      byte ptr [rbx + 3], al
003ab5bc 0fb6430b movzx    eax, byte ptr [rbx + 0xb]
003ab5c0 884307 mov      byte ptr [rbx + 7], al
003ab5c3 0fb6430f movzx    eax, byte ptr [rbx + 0xf]
003ab5c7 88430b mov      byte ptr [rbx + 0xb], al
003ab5ca 884b0f mov      byte ptr [rbx + 0xf], cl
003ab5cd 0f1f00 nop      dword ptr [rax]
003ab5d0 498bc8 mov      rcx, r8
003ab5d3 ba04000000 mov      edx, 4
003ab5d8 0f1f840000000000 nop      dword ptr [rax + rax]
003ab5e0 0fb601 movzx    eax, byte ptr [rcx]
003ab5e3 4883c104 add      rcx, 4
003ab5e7 0fb68438f0a78900 movzx    eax, byte ptr [rax + rdi + 0x89a7f0]
003ab5ef 8841fc mov      byte ptr [rcx - 4], al
003ab5f2 48ffca dec      rdx
003ab5f5 75e9 jne      0x3ab5e0
003ab5f7 49ffc0 inc      r8
003ab5fa 49ffc9 dec      r9
003ab5fd 75d1 jne      0x3ab5d0
003ab5ff 488bc3 mov      rax, rbx
003ab602 448d4204 lea      r8d, [rdx + 4]
003ab606 66660f1f840000000000 nop      word ptr [rax + rax]
003ab610 ba04000000 mov      edx, 4
003ab615 6666660f1f840000000000 nop      word ptr [rax + rax]
003ab620 410fb60c07 movzx    ecx, byte ptr [r15 + rax]
003ab625 48ffc0 inc      rax
003ab628 3048ff xor      byte ptr [rax - 1], cl
003ab62b 48ffca dec      rdx
003ab62e 75f0 jne      0x3ab620
003ab630 49ffc8 dec      r8
003ab633 75db jne      0x3ab610
003ab635 4d8bda mov      r11, r10
003ab638 448d6204 lea      r12d, [rdx + 4]
003ab63c 4c8d2dbd49c5ff lea      r13, [rip - 0x3ab643]
003ab643 0f1f4000 nop      dword ptr [rax]
003ab647 660f1f840000000000 nop      word ptr [rax + rax]
003ab650 410fb67bfe movzx    edi, byte ptr [r11 - 2]
003ab655 410fb65bff movzx    ebx, byte ptr [r11 - 1]
003ab65a 410fb633 movzx    esi, byte ptr [r11]
003ab65e 450fb67301 movzx    r14d, byte ptr [r11 + 1]
003ab663 4084ff test     dil, dil
003ab666 743c je       0x3ab6a4
003ab668 400fb6c7 movzx    eax, dil
003ab66c 420fb68c28f0a98900 movzx    ecx, byte ptr [rax + r13 + 0x89a9f0]
003ab675 b881808080 mov      eax, 0x80808081
003ab67a 81c1fd000000 add      ecx, 0xfd
003ab680 f7e9 imul     ecx
003ab682 03d1 add      edx, ecx
003ab684 c1fa07 sar      edx, 7
003ab687 8bc2 mov      eax, edx
003ab689 c1e81f shr      eax, 0x1f
003ab68c 03d0 add      edx, eax
003ab68e 69c2ff000000 imul     eax, edx, 0xff
003ab694 2bc8 sub      ecx, eax
003ab696 4863c1 movsxd   rax, ecx
003ab699 460fb69428f0a88900 movzx    r10d, byte ptr [rax + r13 + 0x89a8f0]
003ab6a2 eb03 jmp      0x3ab6a7
003ab6a4 4532d2 xor      r10b, r10b
003ab6a7 84db test     bl, bl
003ab6a9 743b je       0x3ab6e6
003ab6ab 0fb6c3 movzx    eax, bl
003ab6ae 420fb68c28f0a98900 movzx    ecx, byte ptr [rax + r13 + 0x89a9f0]
003ab6b7 b881808080 mov      eax, 0x80808081
003ab6bc 81c186000000 add      ecx, 0x86
003ab6c2 f7e9 imul     ecx
003ab6c4 03d1 add      edx, ecx
003ab6c6 c1fa07 sar      edx, 7
003ab6c9 8bc2 mov      eax, edx
003ab6cb c1e81f shr      eax, 0x1f
003ab6ce 03d0 add      edx, eax
003ab6d0 69c2ff000000 imul     eax, edx, 0xff
003ab6d6 2bc8 sub      ecx, eax
003ab6d8 4863c1 movsxd   rax, ecx
003ab6db 460fb68c28f0a88900 movzx    r9d, byte ptr [rax + r13 + 0x89a8f0]
003ab6e4 eb03 jmp      0x3ab6e9
003ab6e6 4532c9 xor      r9b, r9b
003ab6e9 4084f6 test     sil, sil
003ab6ec 743c je       0x3ab72a
003ab6ee 400fb6c6 movzx    eax, sil
003ab6f2 420fb68c28f0a98900 movzx    ecx, byte ptr [rax + r13 + 0x89a9f0]
003ab6fb b881808080 mov      eax, 0x80808081
003ab700 81c1ee000000 add      ecx, 0xee
003ab706 f7e9 imul     ecx
003ab708 03d1 add      edx, ecx
003ab70a c1fa07 sar      edx, 7
003ab70d 8bc2 mov      eax, edx
003ab70f c1e81f shr      eax, 0x1f
003ab712 03d0 add      edx, eax
003ab714 69c2ff000000 imul     eax, edx, 0xff
003ab71a 2bc8 sub      ecx, eax
003ab71c 4863c1 movsxd   rax, ecx
003ab71f 460fb68428f0a88900 movzx    r8d, byte ptr [rax + r13 + 0x89a8f0]
003ab728 eb03 jmp      0x3ab72d
003ab72a 4532c0 xor      r8b, r8b
003ab72d 4584f6 test     r14b, r14b
003ab730 7439 je       0x3ab76b
003ab732 410fb6c6 movzx    eax, r14b
003ab736 420fb68c28f0a98900 movzx    ecx, byte ptr [rax + r13 + 0x89a9f0]
003ab73f b881808080 mov      eax, 0x80808081
003ab744 83c17c add      ecx, 0x7c
003ab747 f7e9 imul     ecx
003ab749 03d1 add      edx, ecx
003ab74b c1fa07 sar      edx, 7
003ab74e 8bc2 mov      eax, edx
003ab750 c1e81f shr      eax, 0x1f
003ab753 03d0 add      edx, eax
003ab755 69c2ff000000 imul     eax, edx, 0xff
003ab75b 2bc8 sub      ecx, eax
003ab75d 4863c1 movsxd   rax, ecx
003ab760 420fb68c28f0a88900 movzx    ecx, byte ptr [rax + r13 + 0x89a8f0]
003ab769 eb02 jmp      0x3ab76d
003ab76b 32c9 xor      cl, cl
003ab76d 4132c8 xor      cl, r8b
003ab770 4132ca xor      cl, r10b
003ab773 4132c9 xor      cl, r9b
003ab776 41884bfe mov      byte ptr [r11 - 2], cl
003ab77a 4084ff test     dil, dil
003ab77d 7439 je       0x3ab7b8
003ab77f 400fb6c7 movzx    eax, dil
003ab783 420fb68c28f0a98900 movzx    ecx, byte ptr [rax + r13 + 0x89a9f0]
003ab78c b881808080 mov      eax, 0x80808081
003ab791 83c17c add      ecx, 0x7c
003ab794 f7e9 imul     ecx
003ab796 03d1 add      edx, ecx
003ab798 c1fa07 sar      edx, 7
003ab79b 8bc2 mov      eax, edx
003ab79d c1e81f shr      eax, 0x1f
003ab7a0 03d0 add      edx, eax
003ab7a2 69c2ff000000 imul     eax, edx, 0xff
003ab7a8 2bc8 sub      ecx, eax
003ab7aa 4863c1 movsxd   rax, ecx
003ab7ad 460fb69428f0a88900 movzx    r10d, byte ptr [rax + r13 + 0x89a8f0]
003ab7b6 eb03 jmp      0x3ab7bb
003ab7b8 4532d2 xor      r10b, r10b
003ab7bb 84db test     bl, bl
003ab7bd 743b je       0x3ab7fa
003ab7bf 0fb6c3 movzx    eax, bl
003ab7c2 420fb68c28f0a98900 movzx    ecx, byte ptr [rax + r13 + 0x89a9f0]
003ab7cb b881808080 mov      eax, 0x80808081
003ab7d0 81c1fd000000 add      ecx, 0xfd
003ab7d6 f7e9 imul     ecx
003ab7d8 03d1 add      edx, ecx
003ab7da c1fa07 sar      edx, 7
003ab7dd 8bc2 mov      eax, edx
003ab7df c1e81f shr      eax, 0x1f
003ab7e2 03d0 add      edx, eax
003ab7e4 69c2ff000000 imul     eax, edx, 0xff
003ab7ea 2bc8 sub      ecx, eax
003ab7ec 4863c1 movsxd   rax, ecx
003ab7ef 460fb68c28f0a88900 movzx    r9d, byte ptr [rax + r13 + 0x89a8f0]
003ab7f8 eb03 jmp      0x3ab7fd
003ab7fa 4532c9 xor      r9b, r9b
003ab7fd 4084f6 test     sil, sil
003ab800 743c je       0x3ab83e
003ab802 400fb6c6 movzx    eax, sil
003ab806 420fb68c28f0a98900 movzx    ecx, byte ptr [rax + r13 + 0x89a9f0]
003ab80f b881808080 mov      eax, 0x80808081
003ab814 81c186000000 add      ecx, 0x86
003ab81a f7e9 imul     ecx
003ab81c 03d1 add      edx, ecx
003ab81e c1fa07 sar      edx, 7
003ab821 8bc2 mov      eax, edx
003ab823 c1e81f shr      eax, 0x1f
003ab826 03d0 add      edx, eax
003ab828 69c2ff000000 imul     eax, edx, 0xff
003ab82e 2bc8 sub      ecx, eax
003ab830 4863c1 movsxd   rax, ecx
003ab833 460fb68428f0a88900 movzx    r8d, byte ptr [rax + r13 + 0x89a8f0]
003ab83c eb03 jmp      0x3ab841
003ab83e 4532c0 xor      r8b, r8b
003ab841 4584f6 test     r14b, r14b
003ab844 743c je       0x3ab882
003ab846 410fb6c6 movzx    eax, r14b
003ab84a 420fb68c28f0a98900 movzx    ecx, byte ptr [rax + r13 + 0x89a9f0]
003ab853 b881808080 mov      eax, 0x80808081
003ab858 81c1ee000000 add      ecx, 0xee
003ab85e f7e9 imul     ecx
003ab860 03d1 add      edx, ecx
003ab862 c1fa07 sar      edx, 7
003ab865 8bc2 mov      eax, edx
003ab867 c1e81f shr      eax, 0x1f
003ab86a 03d0 add      edx, eax
003ab86c 69c2ff000000 imul     eax, edx, 0xff
003ab872 2bc8 sub      ecx, eax
003ab874 4863c1 movsxd   rax, ecx
003ab877 420fb68c28f0a88900 movzx    ecx, byte ptr [rax + r13 + 0x89a8f0]
003ab880 eb02 jmp      0x3ab884
003ab882 32c9 xor      cl, cl
003ab884 4132c8 xor      cl, r8b
003ab887 4132c9 xor      cl, r9b
003ab88a 4132ca xor      cl, r10b
003ab88d 41884bff mov      byte ptr [r11 - 1], cl
003ab891 4084ff test     dil, dil
003ab894 743c je       0x3ab8d2
003ab896 400fb6c7 movzx    eax, dil
003ab89a 420fb68c28f0a98900 movzx    ecx, byte ptr [rax + r13 + 0x89a9f0]
003ab8a3 b881808080 mov      eax, 0x80808081
003ab8a8 81c1ee000000 add      ecx, 0xee
003ab8ae f7e9 imul     ecx
003ab8b0 03d1 add      edx, ecx
003ab8b2 c1fa07 sar      edx, 7
003ab8b5 8bc2 mov      eax, edx
003ab8b7 c1e81f shr      eax, 0x1f
003ab8ba 03d0 add      edx, eax
003ab8bc 69c2ff000000 imul     eax, edx, 0xff
003ab8c2 2bc8 sub      ecx, eax
003ab8c4 4863c1 movsxd   rax, ecx
003ab8c7 460fb69428f0a88900 movzx    r10d, byte ptr [rax + r13 + 0x89a8f0]
003ab8d0 eb03 jmp      0x3ab8d5
003ab8d2 4532d2 xor      r10b, r10b
003ab8d5 84db test     bl, bl
003ab8d7 7438 je       0x3ab911
003ab8d9 0fb6c3 movzx    eax, bl
003ab8dc 420fb68c28f0a98900 movzx    ecx, byte ptr [rax + r13 + 0x89a9f0]
003ab8e5 b881808080 mov      eax, 0x80808081
003ab8ea 83c17c add      ecx, 0x7c
003ab8ed f7e9 imul     ecx
003ab8ef 03d1 add      edx, ecx
003ab8f1 c1fa07 sar      edx, 7
003ab8f4 8bc2 mov      eax, edx
003ab8f6 c1e81f shr      eax, 0x1f
003ab8f9 03d0 add      edx, eax
003ab8fb 69c2ff000000 imul     eax, edx, 0xff
003ab901 2bc8 sub      ecx, eax
003ab903 4863c1 movsxd   rax, ecx
003ab906 460fb68c28f0a88900 movzx    r9d, byte ptr [rax + r13 + 0x89a8f0]
003ab90f eb03 jmp      0x3ab914
003ab911 4532c9 xor      r9b, r9b
003ab914 4084f6 test     sil, sil
003ab917 743c je       0x3ab955
003ab919 400fb6c6 movzx    eax, sil
003ab91d 420fb68c28f0a98900 movzx    ecx, byte ptr [rax + r13 + 0x89a9f0]
003ab926 b881808080 mov      eax, 0x80808081
003ab92b 81c1fd000000 add      ecx, 0xfd
003ab931 f7e9 imul     ecx
003ab933 03d1 add      edx, ecx
003ab935 c1fa07 sar      edx, 7
003ab938 8bc2 mov      eax, edx
003ab93a c1e81f shr      eax, 0x1f
003ab93d 03d0 add      edx, eax
003ab93f 69c2ff000000 imul     eax, edx, 0xff
003ab945 2bc8 sub      ecx, eax
003ab947 4863c1 movsxd   rax, ecx
003ab94a 460fb68428f0a88900 movzx    r8d, byte ptr [rax + r13 + 0x89a8f0]
003ab953 eb03 jmp      0x3ab958
003ab955 4532c0 xor      r8b, r8b
003ab958 4584f6 test     r14b, r14b
003ab95b 743c je       0x3ab999
003ab95d 410fb6c6 movzx    eax, r14b
003ab961 420fb68c28f0a98900 movzx    ecx, byte ptr [rax + r13 + 0x89a9f0]
003ab96a b881808080 mov      eax, 0x80808081
003ab96f 81c186000000 add      ecx, 0x86
003ab975 f7e9 imul     ecx
003ab977 03d1 add      edx, ecx
003ab979 c1fa07 sar      edx, 7
003ab97c 8bc2 mov      eax, edx
003ab97e c1e81f shr      eax, 0x1f
003ab981 03d0 add      edx, eax
003ab983 69c2ff000000 imul     eax, edx, 0xff
003ab989 2bc8 sub      ecx, eax
003ab98b 4863c1 movsxd   rax, ecx
003ab98e 420fb68c28f0a88900 movzx    ecx, byte ptr [rax + r13 + 0x89a8f0]
003ab997 eb02 jmp      0x3ab99b
003ab999 32c9 xor      cl, cl
003ab99b 4132c8 xor      cl, r8b
003ab99e 4132c9 xor      cl, r9b
003ab9a1 4132ca xor      cl, r10b
003ab9a4 41880b mov      byte ptr [r11], cl
003ab9a7 4084ff test     dil, dil
003ab9aa 743c je       0x3ab9e8
003ab9ac 400fb6c7 movzx    eax, dil
003ab9b0 420fb68c28f0a98900 movzx    ecx, byte ptr [rax + r13 + 0x89a9f0]
003ab9b9 b881808080 mov      eax, 0x80808081
003ab9be 81c186000000 add      ecx, 0x86
003ab9c4 f7e9 imul     ecx
003ab9c6 03d1 add      edx, ecx
003ab9c8 c1fa07 sar      edx, 7
003ab9cb 8bc2 mov      eax, edx
003ab9cd c1e81f shr      eax, 0x1f
003ab9d0 03d0 add      edx, eax
003ab9d2 69c2ff000000 imul     eax, edx, 0xff
003ab9d8 2bc8 sub      ecx, eax
003ab9da 4863c1 movsxd   rax, ecx
003ab9dd 460fb69428f0a88900 movzx    r10d, byte ptr [rax + r13 + 0x89a8f0]
003ab9e6 eb03 jmp      0x3ab9eb
003ab9e8 4532d2 xor      r10b, r10b
003ab9eb 84db test     bl, bl
003ab9ed 743b je       0x3aba2a
003ab9ef 0fb6c3 movzx    eax, bl
003ab9f2 420fb68c28f0a98900 movzx    ecx, byte ptr [rax + r13 + 0x89a9f0]
003ab9fb b881808080 mov      eax, 0x80808081
003aba00 81c1ee000000 add      ecx, 0xee
003aba06 f7e9 imul     ecx
003aba08 03d1 add      edx, ecx
003aba0a c1fa07 sar      edx, 7
003aba0d 8bc2 mov      eax, edx
003aba0f c1e81f shr      eax, 0x1f
003aba12 03d0 add      edx, eax
003aba14 69c2ff000000 imul     eax, edx, 0xff
003aba1a 2bc8 sub      ecx, eax
003aba1c 4863c1 movsxd   rax, ecx
003aba1f 460fb68c28f0a88900 movzx    r9d, byte ptr [rax + r13 + 0x89a8f0]
003aba28 eb03 jmp      0x3aba2d
003aba2a 4532c9 xor      r9b, r9b
003aba2d 4084f6 test     sil, sil
003aba30 7439 je       0x3aba6b
003aba32 400fb6c6 movzx    eax, sil
003aba36 420fb68c28f0a98900 movzx    ecx, byte ptr [rax + r13 + 0x89a9f0]
003aba3f b881808080 mov      eax, 0x80808081
003aba44 83c17c add      ecx, 0x7c
003aba47 f7e9 imul     ecx
003aba49 03d1 add      edx, ecx
003aba4b c1fa07 sar      edx, 7
003aba4e 8bc2 mov      eax, edx
003aba50 c1e81f shr      eax, 0x1f
003aba53 03d0 add      edx, eax
003aba55 69c2ff000000 imul     eax, edx, 0xff
003aba5b 2bc8 sub      ecx, eax
003aba5d 4863c1 movsxd   rax, ecx
003aba60 460fb68428f0a88900 movzx    r8d, byte ptr [rax + r13 + 0x89a8f0]
003aba69 eb03 jmp      0x3aba6e
003aba6b 4532c0 xor      r8b, r8b
003aba6e 4584f6 test     r14b, r14b
003aba71 743c je       0x3abaaf
003aba73 410fb6c6 movzx    eax, r14b
003aba77 420fb68c28f0a98900 movzx    ecx, byte ptr [rax + r13 + 0x89a9f0]
003aba80 b881808080 mov      eax, 0x80808081
003aba85 81c1fd000000 add      ecx, 0xfd
003aba8b f7e9 imul     ecx
003aba8d 03d1 add      edx, ecx
003aba8f c1fa07 sar      edx, 7
003aba92 8bc2 mov      eax, edx
003aba94 c1e81f shr      eax, 0x1f
003aba97 03d0 add      edx, eax
003aba99 69c2ff000000 imul     eax, edx, 0xff
003aba9f 2bc8 sub      ecx, eax
003abaa1 4863c1 movsxd   rax, ecx
003abaa4 420fb68c28f0a88900 movzx    ecx, byte ptr [rax + r13 + 0x89a8f0]
003abaad eb02 jmp      0x3abab1
003abaaf 32c9 xor      cl, cl
003abab1 4132c8 xor      cl, r8b
003abab4 4983c304 add      r11, 4
003abab8 4132c9 xor      cl, r9b
003ababb 4132ca xor      cl, r10b
003ababe 41884bfd mov      byte ptr [r11 - 3], cl
003abac2 49ffcc dec      r12
003abac5 0f8585fbffff jne      0x3ab650
003abacb 440fb66c2420 movzx    r13d, byte ptr [rsp + 0x20]
003abad1 488b5c2428 mov      rbx, qword ptr [rsp + 0x28]
003abad6 4983ef10 sub      r15, 0x10
003abada 4180c5ff add      r13b, 0xff
003abade 4c8d5302 lea      r10, [rbx + 2]
003abae2 488d3d1745c5ff lea      rdi, [rip - 0x3abae9]
003abae9 44886c2420 mov      byte ptr [rsp + 0x20], r13b
003abaee 4584ed test     r13b, r13b
003abaf1 0f8579faffff jne      0x3ab570
003abaf7 0fb64309 movzx    eax, byte ptr [rbx + 9]
003abafb 0fb64b0d movzx    ecx, byte ptr [rbx + 0xd]
003abaff 4c8bc3 mov      r8, rbx
003abb02 88430d mov      byte ptr [rbx + 0xd], al
003abb05 0fb64305 movzx    eax, byte ptr [rbx + 5]
003abb09 458d4c2404 lea      r9d, [r12 + 4]
003abb0e 884309 mov      byte ptr [rbx + 9], al
003abb11 0fb64301 movzx    eax, byte ptr [rbx + 1]
003abb15 488d3de444c5ff lea      rdi, [rip - 0x3abb1c]
003abb1c 884305 mov      byte ptr [rbx + 5], al
003abb1f 884b01 mov      byte ptr [rbx + 1], cl
003abb22 0fb6430a movzx    eax, byte ptr [rbx + 0xa]
003abb26 0fb64b02 movzx    ecx, byte ptr [rbx + 2]
003abb2a 884302 mov      byte ptr [rbx + 2], al
003abb2d 884b0a mov      byte ptr [rbx + 0xa], cl
003abb30 0fb6430e movzx    eax, byte ptr [rbx + 0xe]
003abb34 0fb64b06 movzx    ecx, byte ptr [rbx + 6]
003abb38 884306 mov      byte ptr [rbx + 6], al
003abb3b 884b0e mov      byte ptr [rbx + 0xe], cl
003abb3e 0fb64307 movzx    eax, byte ptr [rbx + 7]
003abb42 0fb64b03 movzx    ecx, byte ptr [rbx + 3]
003abb46 884303 mov      byte ptr [rbx + 3], al
003abb49 0fb6430b movzx    eax, byte ptr [rbx + 0xb]
003abb4d 884307 mov      byte ptr [rbx + 7], al
003abb50 0fb6430f movzx    eax, byte ptr [rbx + 0xf]
003abb54 88430b mov      byte ptr [rbx + 0xb], al
003abb57 884b0f mov      byte ptr [rbx + 0xf], cl
003abb5a 660f1f440000 nop      word ptr [rax + rax]
003abb60 498bc8 mov      rcx, r8
003abb63 ba04000000 mov      edx, 4
003abb68 0f1f840000000000 nop      dword ptr [rax + rax]
003abb70 0fb601 movzx    eax, byte ptr [rcx]
003abb73 488d4904 lea      rcx, [rcx + 4]
003abb77 0fb68438f0a78900 movzx    eax, byte ptr [rax + rdi + 0x89a7f0]
003abb7f 8841fc mov      byte ptr [rcx - 4], al
003abb82 48ffca dec      rdx
003abb85 75e9 jne      0x3abb70
003abb87 49ffc0 inc      r8
003abb8a 49ffc9 dec      r9
003abb8d 75d1 jne      0x3abb60
003abb8f 4c8d442478 lea      r8, [rsp + 0x78]
003abb94 488bcb mov      rcx, rbx
003abb97 448d4a04 lea      r9d, [rdx + 4]
003abb9b 4c2bc3 sub      r8, rbx
003abb9e 6690 nop      
003abba0 ba04000000 mov      edx, 4
003abba5 6666660f1f840000000000 nop      word ptr [rax + rax]
003abbb0 410fb60408 movzx    eax, byte ptr [r8 + rcx]
003abbb5 48ffc1 inc      rcx
003abbb8 3041ff xor      byte ptr [rcx - 1], al
003abbbb 48ffca dec      rdx
003abbbe 75f0 jne      0x3abbb0
003abbc0 49ffc9 dec      r9
003abbc3 75db jne      0x3abba0
003abbc5 48295c2440 sub      qword ptr [rsp + 0x40], rbx
003abbca 488bcb mov      rcx, rbx
003abbcd 488b5c2440 mov      rbx, qword ptr [rsp + 0x40]
003abbd2 418d5110 lea      edx, [r9 + 0x10]
003abbd6 66660f1f840000000000 nop      word ptr [rax + rax]
003abbe0 0fb6040b movzx    eax, byte ptr [rbx + rcx]
003abbe4 488d4901 lea      rcx, [rcx + 1]
003abbe8 3041ff xor      byte ptr [rcx - 1], al
003abbeb 48ffca dec      rdx
003abbee 75f0 jne      0x3abbe0
003abbf0 488b4c2448 mov      rcx, qword ptr [rsp + 0x48]
003abbf5 488b442438 mov      rax, qword ptr [rsp + 0x38]
003abbfa 488b5c2428 mov      rbx, qword ptr [rsp + 0x28]
003abbff 83c010 add      eax, 0x10
003abc02 4883c310 add      rbx, 0x10
003abc06 48894c2440 mov      qword ptr [rsp + 0x40], rcx
003abc0b 48894d30 mov      qword ptr [rbp + 0x30], rcx
003abc0f 4883c110 add      rcx, 0x10
003abc13 48895c2428 mov      qword ptr [rsp + 0x28], rbx
003abc18 4889442438 mov      qword ptr [rsp + 0x38], rax
003abc1d 48894c2448 mov      qword ptr [rsp + 0x48], rcx
003abc22 3b442424 cmp      eax, dword ptr [rsp + 0x24]
003abc26 0f8ce4f8ffff jl       0x3ab510
003abc2c 8b442430 mov      eax, dword ptr [rsp + 0x30]
003abc30 84c0 test     al, al
003abc32 0f84be060000 je       0x3ac2f6
003abc38 488bd1 mov      rdx, rcx
003abc3b 440fb6c0 movzx    r8d, al
003abc3f 488bcb mov      rcx, rbx
003abc42 e883283c00 call     0x76e4ca
003abc47 4c8d4518 lea      r8, [rbp + 0x18]
003abc4b 48895c2470 mov      qword ptr [rsp + 0x70], rbx
003abc50 4c2bc3 sub      r8, rbx
003abc53 488bcb mov      rcx, rbx
003abc56 41b904000000 mov      r9d, 4
003abc5c 0f1f4000 nop      dword ptr [rax]
003abc60 ba04000000 mov      edx, 4
003abc65 6666660f1f840000000000 nop      word ptr [rax + rax]
003abc70 410fb60408 movzx    eax, byte ptr [r8 + rcx]
003abc75 48ffc1 inc      rcx
003abc78 3041ff xor      byte ptr [rcx - 1], al
003abc7b 48ffca dec      rdx
003abc7e 75f0 jne      0x3abc70
003abc80 49ffc9 dec      r9
003abc83 75db jne      0x3abc60
003abc85 4c8d5302 lea      r10, [rbx + 2]
003abc89 4c8d7d08 lea      r15, [rbp + 8]
003abc8d c644242009 mov      byte ptr [rsp + 0x20], 9
003abc92 4c89542438 mov      qword ptr [rsp + 0x38], r10
003abc97 4c2bfb sub      r15, rbx
003abc9a 660f1f440000 nop      word ptr [rax + rax]
003abca0 0fb64309 movzx    eax, byte ptr [rbx + 9]
003abca4 0fb64b0d movzx    ecx, byte ptr [rbx + 0xd]
003abca8 4c8bc3 mov      r8, rbx
003abcab 88430d mov      byte ptr [rbx + 0xd], al
003abcae 0fb64305 movzx    eax, byte ptr [rbx + 5]
003abcb2 41b904000000 mov      r9d, 4
003abcb8 884309 mov      byte ptr [rbx + 9], al
003abcbb 0fb64301 movzx    eax, byte ptr [rbx + 1]
003abcbf 884305 mov      byte ptr [rbx + 5], al
003abcc2 884b01 mov      byte ptr [rbx + 1], cl
003abcc5 0fb6430a movzx    eax, byte ptr [rbx + 0xa]
003abcc9 410fb60a movzx    ecx, byte ptr [r10]
003abccd 418802 mov      byte ptr [r10], al
003abcd0 884b0a mov      byte ptr [rbx + 0xa], cl
003abcd3 0fb6430e movzx    eax, byte ptr [rbx + 0xe]
003abcd7 0fb64b06 movzx    ecx, byte ptr [rbx + 6]
003abcdb 884306 mov      byte ptr [rbx + 6], al
003abcde 884b0e mov      byte ptr [rbx + 0xe], cl
003abce1 0fb64307 movzx    eax, byte ptr [rbx + 7]
003abce5 0fb64b03 movzx    ecx, byte ptr [rbx + 3]
003abce9 884303 mov      byte ptr [rbx + 3], al
003abcec 0fb6430b movzx    eax, byte ptr [rbx + 0xb]
003abcf0 884307 mov      byte ptr [rbx + 7], al
003abcf3 0fb6430f movzx    eax, byte ptr [rbx + 0xf]
003abcf7 88430b mov      byte ptr [rbx + 0xb], al
003abcfa 884b0f mov      byte ptr [rbx + 0xf], cl
003abcfd 0f1f00 nop      dword ptr [rax]
003abd00 498bc8 mov      rcx, r8
003abd03 ba04000000 mov      edx, 4
003abd08 0f1f840000000000 nop      dword ptr [rax + rax]
003abd10 0fb601 movzx    eax, byte ptr [rcx]
003abd13 488d4904 lea      rcx, [rcx + 4]
003abd17 0fb68438f0a78900 movzx    eax, byte ptr [rax + rdi + 0x89a7f0]
003abd1f 8841fc mov      byte ptr [rcx - 4], al
003abd22 48ffca dec      rdx
003abd25 75e9 jne      0x3abd10
003abd27 49ffc0 inc      r8
003abd2a 49ffc9 dec      r9
003abd2d 75d1 jne      0x3abd00
003abd2f 488bcb mov      rcx, rbx
003abd32 448d4204 lea      r8d, [rdx + 4]
003abd36 66660f1f840000000000 nop      word ptr [rax + rax]
003abd40 ba04000000 mov      edx, 4
003abd45 6666660f1f840000000000 nop      word ptr [rax + rax]
003abd50 420fb60439 movzx    eax, byte ptr [rcx + r15]
003abd55 48ffc1 inc      rcx
003abd58 3041ff xor      byte ptr [rcx - 1], al
003abd5b 48ffca dec      rdx
003abd5e 75f0 jne      0x3abd50
003abd60 49ffc8 dec      r8
003abd63 75db jne      0x3abd40
003abd65 4d8bc2 mov      r8, r10
003abd68 448d6204 lea      r12d, [rdx + 4]
003abd6c 4c8d2d8d42c5ff lea      r13, [rip - 0x3abd73]
003abd73 0f1f4000 nop      dword ptr [rax]
003abd77 660f1f840000000000 nop      word ptr [rax + rax]
003abd80 410fb658fe movzx    ebx, byte ptr [r8 - 2]
003abd85 450fb650ff movzx    r10d, byte ptr [r8 - 1]
003abd8a 410fb630 movzx    esi, byte ptr [r8]
003abd8e 450fb67001 movzx    r14d, byte ptr [r8 + 1]
003abd93 84db test     bl, bl
003abd95 743b je       0x3abdd2
003abd97 0fb6c3 movzx    eax, bl
003abd9a 420fb68c28f0a98900 movzx    ecx, byte ptr [rax + r13 + 0x89a9f0]
003abda3 b881808080 mov      eax, 0x80808081
003abda8 81c1fd000000 add      ecx, 0xfd
003abdae f7e9 imul     ecx
003abdb0 03d1 add      edx, ecx
003abdb2 c1fa07 sar      edx, 7
003abdb5 8bc2 mov      eax, edx
003abdb7 c1e81f shr      eax, 0x1f
003abdba 03d0 add      edx, eax
003abdbc 69c2ff000000 imul     eax, edx, 0xff
003abdc2 2bc8 sub      ecx, eax
003abdc4 4863c1 movsxd   rax, ecx
003abdc7 420fb6bc28f0a88900 movzx    edi, byte ptr [rax + r13 + 0x89a8f0]
003abdd0 eb03 jmp      0x3abdd5
003abdd2 4032ff xor      dil, dil
003abdd5 4584d2 test     r10b, r10b
003abdd8 743c je       0x3abe16
003abdda 410fb6c2 movzx    eax, r10b
003abdde 420fb68c28f0a98900 movzx    ecx, byte ptr [rax + r13 + 0x89a9f0]
003abde7 b881808080 mov      eax, 0x80808081
003abdec 81c186000000 add      ecx, 0x86
003abdf2 f7e9 imul     ecx
003abdf4 03d1 add      edx, ecx
003abdf6 c1fa07 sar      edx, 7
003abdf9 8bc2 mov      eax, edx
003abdfb c1e81f shr      eax, 0x1f
003abdfe 03d0 add      edx, eax
003abe00 69c2ff000000 imul     eax, edx, 0xff
003abe06 2bc8 sub      ecx, eax
003abe08 4863c1 movsxd   rax, ecx
003abe0b 460fb69c28f0a88900 movzx    r11d, byte ptr [rax + r13 + 0x89a8f0]
003abe14 eb03 jmp      0x3abe19
003abe16 4532db xor      r11b, r11b
003abe19 4084f6 test     sil, sil
003abe1c 743c je       0x3abe5a
003abe1e 400fb6c6 movzx    eax, sil
003abe22 420fb68c28f0a98900 movzx    ecx, byte ptr [rax + r13 + 0x89a9f0]
003abe2b b881808080 mov      eax, 0x80808081
003abe30 81c1ee000000 add      ecx, 0xee
003abe36 f7e9 imul     ecx
003abe38 03d1 add      edx, ecx
003abe3a c1fa07 sar      edx, 7
003abe3d 8bc2 mov      eax, edx
003abe3f c1e81f shr      eax, 0x1f
003abe42 03d0 add      edx, eax
003abe44 69c2ff000000 imul     eax, edx, 0xff
003abe4a 2bc8 sub      ecx, eax
003abe4c 4863c1 movsxd   rax, ecx
003abe4f 460fb68c28f0a88900 movzx    r9d, byte ptr [rax + r13 + 0x89a8f0]
003abe58 eb03 jmp      0x3abe5d
003abe5a 4532c9 xor      r9b, r9b
003abe5d 4584f6 test     r14b, r14b
003abe60 7439 je       0x3abe9b
003abe62 410fb6c6 movzx    eax, r14b
003abe66 420fb68c28f0a98900 movzx    ecx, byte ptr [rax + r13 + 0x89a9f0]
003abe6f b881808080 mov      eax, 0x80808081
003abe74 83c17c add      ecx, 0x7c
003abe77 f7e9 imul     ecx
003abe79 03d1 add      edx, ecx
003abe7b c1fa07 sar      edx, 7
003abe7e 8bc2 mov      eax, edx
003abe80 c1e81f shr      eax, 0x1f
003abe83 03d0 add      edx, eax
003abe85 69c2ff000000 imul     eax, edx, 0xff
003abe8b 2bc8 sub      ecx, eax
003abe8d 4863c1 movsxd   rax, ecx
003abe90 420fb68c28f0a88900 movzx    ecx, byte ptr [rax + r13 + 0x89a8f0]
003abe99 eb02 jmp      0x3abe9d
003abe9b 32c9 xor      cl, cl
003abe9d 4132c9 xor      cl, r9b
003abea0 4032cf xor      cl, dil
003abea3 4132cb xor      cl, r11b
003abea6 418848fe mov      byte ptr [r8 - 2], cl
003abeaa 84db test     bl, bl
003abeac 7438 je       0x3abee6
003abeae 0fb6c3 movzx    eax, bl
003abeb1 420fb68c28f0a98900 movzx    ecx, byte ptr [rax + r13 + 0x89a9f0]
003abeba b881808080 mov      eax, 0x80808081
003abebf 83c17c add      ecx, 0x7c
003abec2 f7e9 imul     ecx
003abec4 03d1 add      edx, ecx
003abec6 c1fa07 sar      edx, 7
003abec9 8bc2 mov      eax, edx
003abecb c1e81f shr      eax, 0x1f
003abece 03d0 add      edx, eax
003abed0 69c2ff000000 imul     eax, edx, 0xff
003abed6 2bc8 sub      ecx, eax
003abed8 4863c1 movsxd   rax, ecx
003abedb 420fb6bc28f0a88900 movzx    edi, byte ptr [rax + r13 + 0x89a8f0]
003abee4 eb03 jmp      0x3abee9
003abee6 4032ff xor      dil, dil
003abee9 4584d2 test     r10b, r10b
003abeec 743c je       0x3abf2a
003abeee 410fb6c2 movzx    eax, r10b
003abef2 420fb68c28f0a98900 movzx    ecx, byte ptr [rax + r13 + 0x89a9f0]
003abefb b881808080 mov      eax, 0x80808081
003abf00 81c1fd000000 add      ecx, 0xfd
003abf06 f7e9 imul     ecx
003abf08 03d1 add      edx, ecx
003abf0a c1fa07 sar      edx, 7
003abf0d 8bc2 mov      eax, edx
003abf0f c1e81f shr      eax, 0x1f
003abf12 03d0 add      edx, eax
003abf14 69c2ff000000 imul     eax, edx, 0xff
003abf1a 2bc8 sub      ecx, eax
003abf1c 4863c1 movsxd   rax, ecx
003abf1f 460fb69c28f0a88900 movzx    r11d, byte ptr [rax + r13 + 0x89a8f0]
003abf28 eb03 jmp      0x3abf2d
003abf2a 4532db xor      r11b, r11b
003abf2d 4084f6 test     sil, sil
003abf30 743c je       0x3abf6e
003abf32 400fb6c6 movzx    eax, sil
003abf36 420fb68c28f0a98900 movzx    ecx, byte ptr [rax + r13 + 0x89a9f0]
003abf3f b881808080 mov      eax, 0x80808081
003abf44 81c186000000 add      ecx, 0x86
003abf4a f7e9 imul     ecx
003abf4c 03d1 add      edx, ecx
003abf4e c1fa07 sar      edx, 7
003abf51 8bc2 mov      eax, edx
003abf53 c1e81f shr      eax, 0x1f
003abf56 03d0 add      edx, eax
003abf58 69c2ff000000 imul     eax, edx, 0xff
003abf5e 2bc8 sub      ecx, eax
003abf60 4863c1 movsxd   rax, ecx
003abf63 460fb68c28f0a88900 movzx    r9d, byte ptr [rax + r13 + 0x89a8f0]
003abf6c eb03 jmp      0x3abf71
003abf6e 4532c9 xor      r9b, r9b
003abf71 4584f6 test     r14b, r14b
003abf74 743c je       0x3abfb2
003abf76 410fb6c6 movzx    eax, r14b
003abf7a 420fb68c28f0a98900 movzx    ecx, byte ptr [rax + r13 + 0x89a9f0]
003abf83 b881808080 mov      eax, 0x80808081
003abf88 81c1ee000000 add      ecx, 0xee
003abf8e f7e9 imul     ecx
003abf90 03d1 add      edx, ecx
003abf92 c1fa07 sar      edx, 7
003abf95 8bc2 mov      eax, edx
003abf97 c1e81f shr      eax, 0x1f
003abf9a 03d0 add      edx, eax
003abf9c 69c2ff000000 imul     eax, edx, 0xff
003abfa2 2bc8 sub      ecx, eax
003abfa4 4863c1 movsxd   rax, ecx
003abfa7 420fb68c28f0a88900 movzx    ecx, byte ptr [rax + r13 + 0x89a8f0]
003abfb0 eb02 jmp      0x3abfb4
003abfb2 32c9 xor      cl, cl
003abfb4 4132c9 xor      cl, r9b
003abfb7 4132cb xor      cl, r11b
003abfba 4032cf xor      cl, dil
003abfbd 418848ff mov      byte ptr [r8 - 1], cl
003abfc1 84db test     bl, bl
003abfc3 743b je       0x3ac000
003abfc5 0fb6c3 movzx    eax, bl
003abfc8 420fb68c28f0a98900 movzx    ecx, byte ptr [rax + r13 + 0x89a9f0]
003abfd1 b881808080 mov      eax, 0x80808081
003abfd6 81c1ee000000 add      ecx, 0xee
003abfdc f7e9 imul     ecx
003abfde 03d1 add      edx, ecx
003abfe0 c1fa07 sar      edx, 7
003abfe3 8bc2 mov      eax, edx
003abfe5 c1e81f shr      eax, 0x1f
003abfe8 03d0 add      edx, eax
003abfea 69c2ff000000 imul     eax, edx, 0xff
003abff0 2bc8 sub      ecx, eax
003abff2 4863c1 movsxd   rax, ecx
003abff5 420fb6bc28f0a88900 movzx    edi, byte ptr [rax + r13 + 0x89a8f0]
003abffe eb03 jmp      0x3ac003
003ac000 4032ff xor      dil, dil
003ac003 4584d2 test     r10b, r10b
003ac006 7439 je       0x3ac041
003ac008 410fb6c2 movzx    eax, r10b
003ac00c 420fb68c28f0a98900 movzx    ecx, byte ptr [rax + r13 + 0x89a9f0]
003ac015 b881808080 mov      eax, 0x80808081
003ac01a 83c17c add      ecx, 0x7c
003ac01d f7e9 imul     ecx
003ac01f 03d1 add      edx, ecx
003ac021 c1fa07 sar      edx, 7
003ac024 8bc2 mov      eax, edx
003ac026 c1e81f shr      eax, 0x1f
003ac029 03d0 add      edx, eax
003ac02b 69c2ff000000 imul     eax, edx, 0xff
003ac031 2bc8 sub      ecx, eax
003ac033 4863c1 movsxd   rax, ecx
003ac036 460fb69c28f0a88900 movzx    r11d, byte ptr [rax + r13 + 0x89a8f0]
003ac03f eb03 jmp      0x3ac044
003ac041 4532db xor      r11b, r11b
003ac044 4084f6 test     sil, sil
003ac047 743c je       0x3ac085
003ac049 400fb6c6 movzx    eax, sil
003ac04d 420fb68c28f0a98900 movzx    ecx, byte ptr [rax + r13 + 0x89a9f0]
003ac056 b881808080 mov      eax, 0x80808081
003ac05b 81c1fd000000 add      ecx, 0xfd
003ac061 f7e9 imul     ecx
003ac063 03d1 add      edx, ecx
003ac065 c1fa07 sar      edx, 7
003ac068 8bc2 mov      eax, edx
003ac06a c1e81f shr      eax, 0x1f
003ac06d 03d0 add      edx, eax
003ac06f 69c2ff000000 imul     eax, edx, 0xff
003ac075 2bc8 sub      ecx, eax
003ac077 4863c1 movsxd   rax, ecx
003ac07a 460fb68c28f0a88900 movzx    r9d, byte ptr [rax + r13 + 0x89a8f0]
003ac083 eb03 jmp      0x3ac088
003ac085 4532c9 xor      r9b, r9b
003ac088 4584f6 test     r14b, r14b
003ac08b 743c je       0x3ac0c9
003ac08d 410fb6c6 movzx    eax, r14b
003ac091 420fb68c28f0a98900 movzx    ecx, byte ptr [rax + r13 + 0x89a9f0]
003ac09a b881808080 mov      eax, 0x80808081
003ac09f 81c186000000 add      ecx, 0x86
003ac0a5 f7e9 imul     ecx
003ac0a7 03d1 add      edx, ecx
003ac0a9 c1fa07 sar      edx, 7
003ac0ac 8bc2 mov      eax, edx
003ac0ae c1e81f shr      eax, 0x1f
003ac0b1 03d0 add      edx, eax
003ac0b3 69c2ff000000 imul     eax, edx, 0xff
003ac0b9 2bc8 sub      ecx, eax
003ac0bb 4863c1 movsxd   rax, ecx
003ac0be 420fb68c28f0a88900 movzx    ecx, byte ptr [rax + r13 + 0x89a8f0]
003ac0c7 eb02 jmp      0x3ac0cb
003ac0c9 32c9 xor      cl, cl
003ac0cb 4132c9 xor      cl, r9b
003ac0ce 4132cb xor      cl, r11b
003ac0d1 4032cf xor      cl, dil
003ac0d4 418808 mov      byte ptr [r8], cl
003ac0d7 84db test     bl, bl
003ac0d9 743b je       0x3ac116
003ac0db 0fb6c3 movzx    eax, bl
003ac0de 420fb68c28f0a98900 movzx    ecx, byte ptr [rax + r13 + 0x89a9f0]
003ac0e7 b881808080 mov      eax, 0x80808081
003ac0ec 81c186000000 add      ecx, 0x86
003ac0f2 f7e9 imul     ecx
003ac0f4 03d1 add      edx, ecx
003ac0f6 c1fa07 sar      edx, 7
003ac0f9 8bc2 mov      eax, edx
003ac0fb c1e81f shr      eax, 0x1f
003ac0fe 03d0 add      edx, eax
003ac100 69c2ff000000 imul     eax, edx, 0xff
003ac106 2bc8 sub      ecx, eax
003ac108 4863c1 movsxd   rax, ecx
003ac10b 460fb69c28f0a88900 movzx    r11d, byte ptr [rax + r13 + 0x89a8f0]
003ac114 eb03 jmp      0x3ac119
003ac116 4532db xor      r11b, r11b
003ac119 4584d2 test     r10b, r10b
003ac11c 743c je       0x3ac15a