function closeAllWindows(){
	list = getList("window.titles"); 
    for (i=0; i<list.length; i++){ 
    	winame = list[i]; 
    	selectWindow(winame); 
    	run("Close"); 
    } 
}

function isLogWithText(){
	logString = getInfo("log");
	length = lengthOf(logString);
	print ("\\Clear");
	
	var exists = length > 2;
	return exists;
}

function getDifference(imagem1, imagem2, nome_imagem1, nome_imagem2, i, tecnica){
	open(imagem1);
	open(imagem2);
	imageCalculator("Difference create", nome_imagem1, nome_imagem2);
	saveAs("tif", diferencas_dir + filename + "_pre_processada_" + tecnica + "_difference.tif");

	nBins = 256;
	getHistogram(values, counts, nBins);

	setResult("Image", row, tecnica);
	setResult("Quantidade em 0", row, counts[0]);
	setResult("Quantidade em 255", row, counts[255]);
	row++;
}
	
function action(original_dir, filename, i, tecnica) {
 	print ("\\Clear"); // limpa o log

	nome_imagem_pre_processada = filename + "_pre_processada.tif"; 

	open(original_dir + filename + ".tif");
	run("16-bit");
	saveAs("Jpeg", grayscale_dir + filename + "_grayscale");
	close();

	open(grayscale_dir + filename + "_grayscale" + ".jpg"); 
	run("Auto Threshold", "method=" + tecnica + " white");

    	if(isLogWithText()){ // se o log possui texto, existe erro.
       		return;
   	}
	
	saveAs("tif", limiarizada_dir + filename + "_" + tecnica);
	close();
	
	open(processadas_dir + nome_imagem_pre_processada);
	open(limiarizada_dir + filename + "_" + tecnica + ".tif");
	imageCalculator("Difference create", nome_imagem_pre_processada, filename + "_" + tecnica + ".tif");
	saveAs("tif", diferencas_dir + filename + "_pre_processada_" + tecnica + "_difference.tif");

	imagem_pre_processada = processadas_dir + nome_imagem_pre_processada;
	imagem_limiarizada = limiarizada_dir + filename + "_" + tecnica + ".tif"; 
	nome_imagem_limiarizada = filename + "_" + tecnica + ".tif";
	getDifference(imagem_limiarizada, imagem_pre_processada, nome_imagem_limiarizada, nome_imagem_pre_processada, i, tecnica);

}


var image_dir = "C:\\Users\\Rayane\\Desktop\\TCC\\Imagens\\macro\\"

original_dir = image_dir + "originais\\";
grayscale_dir = image_dir + "grayscale\\";
limiarizada_dir = image_dir + "limiarizadas\\";
otsu_particionado_dir = image_dir + "otsu_particionado\\";
diferencas_dir = image_dir + "diferencas\\";
analises_dir = image_dir + "analises\\";
processadas_dir = image_dir + "processadas\\";

var row = 0;

setBatchMode(true); 

list = getFileList(original_dir);
Array.sort(list);

for (i = 0; i < list.length; i++){

	filename = substring(list[i], 0, lengthOf(list[i]) - 4);

	action(original_dir, filename, i, "Default");
	action(original_dir, filename, i, "Huang");
	action(original_dir, filename, i, "Intermodes");
	action(original_dir, filename, i, "IsoData");
	action(original_dir, filename, i, "Li");
	action(original_dir, filename, i, "MaxEntropy");
	action(original_dir, filename, i, "Mean");
	action(original_dir, filename, i, "MinError(I) ignore_black ignore_white");
	action(original_dir, filename, i, "Minimum");
	action(original_dir, filename, i, "Moments");
	action(original_dir, filename, i, "Otsu");
	action(original_dir, filename, i, "Percentile");
	action(original_dir, filename, i, "RenyiEntropy");
	action(original_dir, filename, i, "Shanbhag");
	action(original_dir, filename, i, "Triangle");
	action(original_dir, filename, i, "Yen");

	nome_imagem_otsu = filename + "_otsu_particionado.tif";
	imagem_otsu = otsu_particionado_dir + nome_imagem_otsu;
	imagem_pre_processada = processadas_dir + filename + "_pre_processada.tif"; 
	nome_imagem_pre_processada = filename + "_pre_processada.tif"; 
	getDifference(imagem_otsu, imagem_pre_processada, nome_imagem_otsu, nome_imagem_pre_processada, i, "Otsu Particionado");

	updateResults();
	saveAs("Results", analises_dir + filename + ".xls");
	run("Clear Results");
	closeAllWindows();
	row = 0;
}

close('*');
setBatchMode(false);
closeAllWindows();