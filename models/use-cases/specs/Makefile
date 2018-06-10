
UML4DOT=~\scripts\
UML_SOURCES := $(wildcard ./*.u4d)

.PHONY:	all clean view

all: $(UML_SOURCES:.u4d=.svg) $(UML_SOURCES:.u4d=.png)

view: $(UML_SOURCES:.u4d=.svg)
	eog $<

%.svg: %.u4d
	$(UML4DOT) $< | dot -Tsvg -o$@

%.svg: %.dot
	dot -Tsvg -o$@ $<

%.png: %.u4d
	$(UML4DOT) $< | dot -Tpng -o$@

%.png: %.dot
	dot -Tpng -o$@ $<

clean:
	find . -maxdepth 1 -! -name "*.tex" -! -name "*.dot" -! -name "*.u4d" -! -name Makefile -! -name "actor.svg" -! -name "boundary.svg" -! -name "control.svg" -! -name "entity.svg" -delete
