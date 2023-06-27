Set WshShell = CreateObject("WScript.Shell" ) 
WshShell.Run """C:\Program Files (x86)\MhmdSAbdlh\Cedros y Narjes\Cedros.exe""", 0 'Must quote command if it has spaces; must escape quotes
Set WshShell = Nothing