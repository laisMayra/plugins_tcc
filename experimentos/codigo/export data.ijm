
imageName=getTitle;

// get histogram values
nBins = 256;
run("Clear Results");
row = 0;
getHistogram(values, counts, nBins);

// put histogram values in the results window and save
for (i=0; i<nBins; i++) {
  setResult("Value", row, values[i]);
  setResult("Count", row, counts[i]);
  row++;
}
updateResults();
saveAs("Results","C:\\Users\\Rayane\\Desktop\\"+getTitle+".xls");

// close all windows
close("*");