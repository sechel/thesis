data = read.table("icosubdivision.dat")
pdf('icosubdivision.pdf', width=7.0, height=6.0)
par(mfrow=c(1,1))
x = data$V1
y = abs(data$V2)
plot(x, y, log="xy", pch=1, cex=1.0, xlim=c(12,41000), xlab=expression(n), ylab=expression(abs(tau)-hat(abs(tau))))
# create a linear model
lm = lm(log(y)~log(x))
print(lm)
yp = predict(lm, newdata=list(log(x)))
matlines(x, exp(yp))
dev.off()