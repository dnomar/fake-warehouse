
UML_SOURCES := $(wildcard ./ucr-*.java ./ftr-*.java)

.PHONY:	all clean view

all: $(UML_SOURCES:.java=.png)

view: $(UML_SOURCES:.java=.png)
	eog $<

%.png: %.java
	umlgraph $* png

clean:
	rm -f {ucr,ftr}-*.png
