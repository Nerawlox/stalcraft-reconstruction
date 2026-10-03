param(
    [ValidateSet('pack', 'forge', 'stalker')]
    [string]$Profile = 'pack',
    [switch]$ValidateOnly
)
$ErrorActionPreference = 'Stop'
$runtimeDir = Join-Path $PSScriptRoot '.cache\runtime'
$configPath = Join-Path $runtimeDir 'runtime-config.json'
if (-not (Test-Path -LiteralPath $configPath)) {
    throw 'Runtime is missing. Run scripts/prepare_runtime.py first.'
}
$config = Get-Content -LiteralPath $configPath -Raw | ConvertFrom-Json
if ((Get-FileHash -LiteralPath $config.client_jar -Algorithm SHA1).Hash.ToLowerInvariant() -ne '1703704407101cf72bd88e68579e3696ce733ecd') {
    throw 'Minecraft client does not match the original Mojang 1.6.4 artifact.'
}
$javaPath = Join-Path (Split-Path -Parent $config.java) 'javaw.exe'
if (-not (Test-Path -LiteralPath $javaPath)) { throw 'Portable Java is missing.' }
foreach ($library in $config.classpath) {
    if (-not (Test-Path -LiteralPath $library)) { throw "Missing library: $library" }
}
if ($Profile -eq 'pack') {
    $gameDir = $config.game_dir
} else {
    $gameDir = Join-Path $runtimeDir "profiles\$Profile"
    if (-not (Test-Path -LiteralPath $gameDir)) { throw 'Run the Python launcher to prepare this diagnostic profile first.' }
}
$runtimeFull = [IO.Path]::GetFullPath($runtimeDir).TrimEnd('\') + '\'
$gameFull = [IO.Path]::GetFullPath($gameDir)
if (-not $gameFull.StartsWith($runtimeFull, [StringComparison]::OrdinalIgnoreCase)) {
    throw 'The game directory must remain within the isolated runtime.'
}
$launchArgs = @(
    '-Xms512m', '-Xmx4g',
    '-Dfml.ignoreInvalidMinecraftCertificates=true',
    "-Djava.library.path=$($config.native_dir)",
    '-cp', ($config.classpath -join ';'), $config.main_class,
    '--username', 'LocalTest', '--session', '0', '--version', $config.version,
    '--gameDir', $gameDir, '--assetsDir', $config.assets_dir,
    '--width', '1024', '--height', '640',
    '--tweakClass', 'cpw.mods.fml.common.launcher.FMLTweaker'
)
if ($ValidateOnly) {
    Write-Output "Ready: $Profile; original client verified; $($config.classpath.Count) classpath entries."
    exit 0
}
# Every current argument is a constant or a validated path without embedded quotes.
if ($launchArgs | Where-Object { $_ -match '"' }) { throw 'Unexpected quote in a launch argument.' }
$quotedArgs = ($launchArgs | ForEach-Object { '"' + $_ + '"' }) -join ' '
$logDir = Join-Path $runtimeDir 'logs'
New-Item -ItemType Directory -Path $logDir -Force | Out-Null
$logStem = Join-Path $logDir ("manual-$Profile-" + [guid]::NewGuid().ToString('N'))
$clientProcess = Start-Process -FilePath $javaPath -ArgumentList $quotedArgs -WorkingDirectory $gameDir -WindowStyle Hidden -RedirectStandardOutput "$logStem.log" -RedirectStandardError "$logStem.stderr.log" -PassThru
Write-Output "Started local test client, PID $($clientProcess.Id)."
Write-Output "Log: $logStem.log"
