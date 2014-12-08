d = read.table("quality_rand_points01.dat")
pdf('quality_rand_points01_maxmultiratio.pdf', width=12.0, height=3)
par(mfrow=c(1,3), mar=c(5.1, 5.0, 2.1, 2.1))
with(d, 
	plot(V2, V3, 
		log='xy', 
		xlim=c(20,1500), 
		ylim=c(1e-4,1e-2), 
		xlab=expression(n), 
		ylab=expression(group("|",tau-hat(tau),"|")),
		main='No quality filtering',
		pch=20, cex=0.5
	)
)
df = d[d$V13 < 0.3,]
with(df, 
	plot(V2, V3, 
		log='xy', 
		xlim=c(20,1500), 
		ylim=c(1e-4,1e-2), 
		xlab=expression(n), 
		ylab=expression(group("|",tau-hat(tau),"|")),
		main='Quality filtered MaxMultiRatio < 0.3',
		pch=20, cex=0.5
	)
)
df2 = df[df$V2 > 10,]
df2 = df2[order(df2$V2),]
lm <- lm(log(df2$V3) ~ log(df2$V2))
lines(df2$V2, exp(predict(lm)), type='l', col="red", lwd=2.0)
alpha=coefficients(lm)[2]
text(1000, 5e-3, labels=bquote(alpha == .(alpha)))

with(d[d$V13 < 1.5,], hist(V13, breaks=80, main='', xlab='MaxMultiRatio', xlim=c(0.0, 1.5)))
dev.off()
