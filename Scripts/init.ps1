Set-Location -Path .. -PassThru

$cloneParams = "clone -v https://github.com/Stropek/KattisKotlinTemplate.git " +  "Kotlin/" + $args[0]
Start-Process git -ArgumentList $cloneParams -wait -NoNewWindow -PassThru

$expression = ".\Kotlin\projectSetup.ps1 " + $args[0]
Invoke-Expression $expression