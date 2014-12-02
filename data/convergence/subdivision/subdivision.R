plotSubdivision <- function(data, name, write_pdf=FALSE) { 
	if (write_pdf) {
		pdfFilename = paste(name, "pdf", sep=".")
		pdf(pdfFilename, width=7.0, height=5.0)
	}
	par(mfrow=c(1,1), mar=c(5.1, 5.0, 2.1, 2.1))
	x = data$V1
	y = abs(data$V2)
	plot(x, y, log="xy", pch=1, cex=1.0, xlab=expression(n), ylab=expression(abs(tau-hat(tau))), main=name)
	# create a linear model
	xlm = tail(x, 5)
	ylm = tail(y, 5)
	lm = lm(log(ylm) ~ log(xlm))
	ylmp = predict(lm)
	matlines(xlm, exp(ylmp))
	alpha=coefficients(lm)[2]
	text(x[6],y[4],labels=bquote(alpha == .(alpha)))
	if (write_pdf) dev.off()
}

print('plotting...')
files <- list.files(pattern=".*\\.dat") 
for (file in files) {
	print(paste('creating plot for data in', file))
	data = read.table(file)
	name = unlist(strsplit(file, "\\."))[1]
	plotSubdivision(data, name, TRUE)
}
