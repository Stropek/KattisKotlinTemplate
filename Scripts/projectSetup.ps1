$baseUrl = "https://open.kattis.com/problems/"

# Download the file to a specific location
$clnt = new-object System.Net.WebClient

$workingDir = ".\Kotlin\" + $args[0]
Set-Location $workingDir
$workingDir = Get-Location
Write-Host "Working dir " $workingDir

# https://open.kattis.com/problems/{problem}/file/statement/samples.zip
$url = $baseUrl + $args[0].ToString().ToLower() + "/file/statement/samples.zip"
$file = $workingDir.ToString() + "\sampledata.zip"
$clnt.DownloadFile($url,$file)
Write-Host "File downloaded to " $file

# Unzip the file to specified location
$shell_app=new-object -com shell.application
$zip_file = $shell_app.namespace($file)
$destination = $shell_app.namespace($workingDir.ToString())
$destination.Copyhere($zip_file.items())
Write-Host "Unzipped:" $zip_file

if ((Test-Path -Path TestFiles) -eq $true) {
    Remove-Item -Recurse -Force TestFiles
}

New-Item TestFiles -type directory
Move-Item *.in TestFiles
Move-Item *.ans TestFiles

# delete zip file
Remove-Item $file

# substitute TEST_DATA_DIRECTORY path
$testDataDirectory = Join-Path $workingDir TestFiles
$fileInputPath = Join-Path $workingDir src\test\kotlin\FileInput.kt
(Get-Content $fileInputPath).replace('{TEST_DATA_DIRECTORY}', $testDataDirectory.Replace("\", "\\")) | Set-Content $fileInputPath

# prepare submit script
(Get-Content submit.bat).replace('{project_id}', $args[0].ToLower()) | Set-Content submit.bat

Start-Process idea64 $workingDir.ToString()

Remove-Item .git -Recurse -Force