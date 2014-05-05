default: guidelines.pdf

guidelines.dvi: aag10.sty

clean:
	rm -f *.aux *.log *.toc *.dvi guidelines.ps


GS7FLAGS=-dMaxSubsetPct=100 -dCompatibilityLevel=1.3 \
	-dSubsetFonts=true -dEmbedAllFonts=true \
	-dAutoFilterColorImages=false -dAutoFilterGrayImages=false \
	-dColorImageFilter=/FlateEncode -dGrayImageFilter=/FlateEncode \
	-dMonoImageFilter=/FlateEncode 

GS8FLAGS=-dPDFSETTINGS=/prepress -dCompatibilityLevel=1.3 \
	-dAutoFilterColorImages=false -dAutoFilterGrayImages=false \
	-dColorImageFilter=/FlateEncode -dGrayImageFilter=/FlateEncode \
	-dMonoImageFilter=/FlateEncode -dDownsampleColorImages=false \
	-dDownsampleGrayImages=false 

%.pdf: %.ps
	ps2pdf $(GS7FLAGS) $(GS8FLAGS) $< $@

%.ps: %.dvi
	dvips -Ppdf -G0 -t a4 -o $@ $<

%.dvi: %.tex
	latex $<
	bibtex $*
	latex $<
	latex $<

