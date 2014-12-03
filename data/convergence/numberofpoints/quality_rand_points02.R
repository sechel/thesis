d = read.table("quality_rand_points02.dat")
pdf('quality_rand_points02.pdf', width=12.0, height=3)
par(mfrow=c(1,3), mar=c(5.1, 5.0, 2.1, 2.1))
with(d, 
	plot(V2, V3, 
		log='xy', 
		xlim=c(100,3000), 
		ylim=c(1e-4,1e-2), 
		xlab=expression(n), 
		ylab=expression(group("|",tau-hat(tau),"|")),
		main='No quality filtering'
	)
)
with(
	d[d$V14 < 0.03,], 
	plot(V2, V3, 
		log='xy', 
		xlim=c(100,3000), 
		ylim=c(1e-4,1e-2), 
		xlab=expression(n), 
		ylab=expression(group("|",tau-hat(tau),"|")),
		main='Quality filtered MeanMultiRatio < 0.03'
	)
)
with(d[d$V14 < 0.2,], hist(V14, breaks=80, main='', xlim=c(0, 0.2), xlab='MeanMultiRatio'))
dev.off()
