
UML_SOURCES := $(wildcard ./*.java)

.PHONY:	all clean view

all: $(UML_SOURCES:.java=.svg) $(UML_SOURCES:.java=.png)

view: $(UML_SOURCES:.java=.svg) $(UML_SOURCES:.java=.png)
	eog $<

%.svg: %.java
	umlgraph $* svg

%.png: %.java
	umlgraph $* png

clean:
	rm -f  $(UML_SOURCES:.java=.svg) $(UML_SOURCES:.java=.png)
