/* Static reconstruction for review; not the original source and not a runnable launcher.
   x64 java.exe: main range RVA 0x1038..0x1277, resolver RVA 0x1000..0x1035.
   Both original x86/x64 launchers reference the same six aliases.
   No target binary was executed to produce this file. */

/* Reconstructed from x64 register/data flow:
   rcx=module, rdx=normal_name, r8=obfuscated_name. */
FARPROC resolve_jli(HMODULE module, const char *normal_name,
                   const char *obfuscated_name) {
    FARPROC function = GetProcAddress(module, obfuscated_name);
    if (function == NULL)
        function = GetProcAddress(module, normal_name);
    return function;
}

/* Partial pseudocode: standard JLI argument handling below is omitted.
   The native bootstrap hands off to the protected JVM; it does not contain
   a visible Java class decryption algorithm. */
int reconstructed_bootstrap(void) {
    HMODULE module = LoadLibraryA("server\\jvm.dll");
    if (module == NULL) {
        DWORD error = GetLastError();
        printf("Can not load library: %d", error);
        return error;
    }
    FARPROC init_args = resolve_jli(module, "JLI_InitArgProcessing",
                                  "137bc867174a904f42a8efa61d836687");
    FARPROC cmd_to_args = resolve_jli(module, "JLI_CmdToArgs",
                                    "c37c45bdb56ed218e567719525bfad0e");
    FARPROC get_argc = resolve_jli(module, "JLI_GetStdArgc",
                                 "0e507ffc4f5371b5271f03ac97484fe0");
    FARPROC alloc = resolve_jli(module, "JLI_MemAlloc",
                              "1ee12e87292680737f1c121af6cabfe0");
    FARPROC get_args = resolve_jli(module, "JLI_GetStdArgs",
                                 "f5199c4078a19150bc6c85942e593153");
    FARPROC launch = resolve_jli(module, "JLI_Launch",
                               "9b490ffc0189e74ef6ca6c1079e09043");
    if (!init_args || !cmd_to_args || !get_argc || !alloc || !get_args || !launch)
        return 1;
    /* init_args(true, false);
       cmd_to_args(GetCommandLineA());
       Build argv from get_argc(), get_args(), alloc().
       launch(argc, argv, ...,
              "9-internal+0-adhoc.Folken.jdk9", "9-internal", ...);
       Argument details/return value require the JLI signature and complete flow. */
}
