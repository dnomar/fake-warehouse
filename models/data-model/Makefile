
UML_SOURCES := $(wildcard ./*.java)
DOT_SOURCES := $(wildcard ./*.dot)
#VIEWS_SRC := db-physical-objects.java

.PHONY:	all clean view

all: $(UML_SOURCES:.java=.png) $(DOT_SOURCES:.dot=.png)

view: $(UML_SOURCES:.java=.png)
	eog $<

%.dot:	$(VIEWS_SRC)
	umlgraph $(basename $<) png -views

%.svg: %.java
	umlgraph $* svg

%.svg: %.dot
	dot -Tsvg -o $@ $<

%.png: %.java
	umlgraph $* png

%.png: %.dot
	dot -Tpng -o $@ $<

clean:
	rm -f  $(UML_SOURCES:.java=.svg) $(UML_SOURCES:.java=.png) $(DOT_SOURCES:.dot=.png)
	rm -f  *_View.{png,svg}
