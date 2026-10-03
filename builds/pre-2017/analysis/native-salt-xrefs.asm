; Local aligned disassembly snippets from jvm-static-view.pe
; ImageBase 0x5A970000; displayed operands use module RVAs for data targets.

; Salt1: append literal to a candidate string, then MD5
00633dc3  inc      rax
00633dc6  cmp      byte ptr [rbx+rax], 0
00633dca  jne      00633dc3
00633dcc  or       rcx, -1
00633dd0  lea      rdx, [rip+0x266de9]       ; -> RVA 0x89ABC0 "2G5teW9TkteWdMSx"
00633dd7  inc      rcx
00633dda  cmp      byte ptr [rdx+rcx], 0
00633dde  jne      00633dd7
00633de0  inc      ecx
00633de2  add      eax, ecx
00633de4  movsxd   rcx, eax
00633de7  push     rbx
00633de8  call     alloc
00633e20  ; copy input and salt1 into new buffer
00633e54  lea      rcx, [rsp+0x20]            ; digest output
00633e59  call     RVA_0x5F0B00               ; MD5(data=RDI)

; Salt2: helper appends 16 bytes at RVA 0x89ABD9 then tail-calls MD5
003ad680  mov      qword ptr [rsp+8], rbx
003ad68a  mov      rbx, rdx                   ; input string
003ad697  cmp      byte ptr [rdx+rax], 0
003ad69d  add      eax, 0x11                  ; allocate len + 17
003ad6a5  call     alloc
003ad6c0  ; copy input, including its terminator
003ad6dd  movups   xmm0, [rip+0x4ed4f4]       ; -> RVA 0x89ABD8
003ad6e7  movups   [rcx], xmm0                ; full 16-byte salt2
003ad6ea  movzx    eax, byte ptr [rip+0x4ed4f7] ; -> RVA 0x89ABE8, NUL
003ad6f1  mov      byte ptr [rcx+0x10], al
003ad6f4  mov      rcx, rdi                   ; digest output
003ad6fc  pop      rdi
003ad701  jmp      RVA_0x5F0B00               ; MD5(data=RDX)

; Salt2 inline path: class/path string -> MD5 -> custom cipher
003ac3de  movups   xmm0, [rip+0x4ee7f3]       ; -> RVA 0x89ABD8
003ac3ed  movups   [r9], xmm0                 ; append effective salt2
003ac3f1  movzx    eax, byte ptr [rip+0x4ee7f0] ; -> RVA 0x89ABE8
003ac3f8  mov      byte ptr [r9+0x10], al
003ac3fc  call     RVA_0x5F0B00               ; MD5(input, output at rsp+0x20)
003ac401  lea      r9, [rsp+0x20]             ; MD5 hexdigest / IV-name parameter
003ac406  mov      r8d, ebp
003ac409  mov      rdx, rsi
003ac40c  mov      rcx, rdi
003ac40f  call     RVA_0x3AB230               ; custom 16-byte block cipher

; Class-file suffix is used in the cipher/key path
003ab300  movzx    eax, byte ptr [r8+rcx-6]
003ab306  lea      r9, [rip+0x4ef8df]         ; -> RVA 0x89ABEC ".class"
003ab310  cmp      al, byte ptr [r9+rcx-1]
003ab31c  cmp      rcx, 7
003ab320  jne      003ab300
003ab322  sub      edx, 6                      ; strip ".class"

; Cipher table references
003ab46b  lea      rsi, [rip-0x3ab472]        ; image base
003ab47d  movzx    r9d, byte ptr [rcx+rsi+0x89A6F0] ; custom S-box
003ab4a4  xor      r9b, byte ptr [rax+rsi+0x89AAF0] ; Rcon table, starts +1
003ab4fa  lea      rdi, [rip-0x3ab501]        ; image base
003ab5e7  movzx    eax, byte ptr [rax+rdi+0x89A7F0] ; inverse substitution
003ab63c  lea      r13, [rip-0x3ab643]        ; image base
003ab66c  movzx    ecx, byte ptr [rax+r13+0x89A9F0] ; GF log lookup
003ab680  add      ecx, 0xfd
003ab699  movzx    r10d, byte ptr [rax+r13+0x89A8F0] ; GF exp lookup

; The cipher consumes the final 16 ASCII bytes of the R9 string as IV state;
; local fixed constants feed its key schedule. Full dump: custom-cipher-function.asm.
