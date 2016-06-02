;~ ------------------------------------------------------------
;~ Save_Dialog_IE.au3
;~ To handle the Authentication Dialogbox
;~ Create By: Jayanta Saha
;~ Usage: Login_dialog.au3 "Dialog Title" "User Name" "Password"
;~ In java Program you have to write
;~ String[] dialog  = new String[]{"c:\\Login_dialog.exe","Connect to windchillperfdmz","AkamaiTestuser@delltest.com","Wc90user{!}"};
;~ Runtime.getRuntime().exec(dialog);
;~ ------------------------------------------------------------
AutoItSetOption("WinTitleMatchMode","2")

For $i = 1 To 100
	Sleep(1000)
	If WinExists($CmdLine[1]) Then
		ExitLoop
	EndIf
Next

if $CmdLine[0] < 2	then
msgbox(0,"Error","Supply all the Arguments, Dialog title User Name, Passwor")
Exit
EndIf

$title = WinGetTitle($CmdLine[1]) ; retrives whole window title


WinWait($title) ; match the window with substring
ControlFocus($title,"","&Save")
;MsgBox(0,"Test","Test")
;
;ControlSend($title,"","Edit1",$CmdLine[2]);Sets User Name
;ControlSend("Windows Security","","Edit2","password");Sets Password
;ControlFocus($title,"","Edit2")
;MsgBox(0,"Test","Test")

;ControlSend($title,"","Edit2",$CmdLine[3])

;MsgBox(0,"Test","Test")
;ControlClick(
;Send("{ENTER}")

ControlClick($CmdLine[1],"","&Save");
WinWait($CmdLine[3])
Sleep(5000)
ControlFocus($CmdLine[3],"","Edit1")
ControlSend($CmdLine[3],"","Edit1",$CmdLine[2])
ControlFocus($CmdLine[3],"","&Save")
ControlClick($CmdLine[3],"","&Save");
;WinWait($CmdLine[3])
;ControlFocus($CmdLine[3],"","&Save")
;ControlClick($CmdLine[3],"","&Save");


;~ Sleep(5000)

;~ If(WinExists("Download complete")) Then
;~ 	WinWait("Download complete")
;~ 	WinActivate("Download complete")
;~ 	ControlFocus("Download complete","","Close")
;~ 	ControlClick("Download complete","","Close");
;~ ElseIf(WinExists($CmdLine[1])) Then
;~ 	WinWait($CmdLine[1])
;~ 	WinActivate($CmdLine[1])
;~ 	ControlFocus($CmdLine[1],"","Close")
;~ 	ControlClick($CmdLine[1],"","Close");
;~ EndIf





