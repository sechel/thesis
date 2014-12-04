d = read.table("quality_rand_points02.dat")
pdf('quality_rand_points02.pdf', width=12.0, height=3)
par(mfrow=c(1,3), mar=c(5.1, 5.0, 2.1, 2.1))
with(d, 
	plot(V2, V3, 
		log='xy', 
		xlim=c(100,3000), 
		ylim=c(5e-5,7e-3), 
		xlab=expression(n), 
		ylab=expression(group("|",tau-hat(tau),"|")),
		main='No quality filtering',
		pch=20, cex=0.5
	)
)
df = d[d$V14 < 0.03,]
with(df,
	plot(V2, V3, 
		log='xy', 
		xlim=c(100,3000), 
		ylim=c(5e-5,7e-3),
		xlab=expression(n), 
		ylab=expression(group("|",tau-hat(tau),"|")),
		main='Quality filtered MeanMultiRatio < 0.03',
		pch=20, cex=0.5
	)
)

df = df[order(df$V2),]
lm <- lm(log(df$V3) ~ log(df$V2))
lines(df$V2, exp(predict(lm)), type='l', col="red", lwd=2.0)
alpha=coefficients(lm)[2]
text(1000, 5e-3, labels=bquote(alpha == .(alpha)))

with(d[d$V14 < 0.2,], hist(V14, breaks=80, main='', xlim=c(0, 0.2), xlab='MeanMultiRatio'))
dev.off()
