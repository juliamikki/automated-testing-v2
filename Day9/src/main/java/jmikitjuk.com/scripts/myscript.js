var globalVar;

function hideValue(x){
	globalVar = x.value;
	x.value = "";
}

function setValue(x){
	x.value = globalVar;
}