
UML_SOURCES:= $(wildcard ucr-*.java)	

.PHONY:	all 

all:$(UML_SOURCES:.java=.png) touch cleanf
	
%.png: %.java
	umlgraph $* png

touch:func-spec.pdf

func-spec.pdf: func-spec.tex
	pdflatex func-spec.tex

cleanf:
	rm func-spec.log
	rm func-spec.toc
	rm func-spec.aux