
SUBDIRS := ../models/.
PDFS := dwhd-design.pdf \
	    van-curso-archi-proposal.pdf

.PHONY:	all clean touch view $(SUBDIRS)

all: $(SUBDIRS) $(PDFS)

clean:
	rm -f *.{aux,bbl,bcf,blg,dvi,lof,log,lot,nav,out,run.xml,snm,tex~,toc,xwm}
	rm -rf _minted-*

view: 
	evince $< &> /dev/null &

touch:
	touch $(PDFS: .pdf=.tex)

$(SUBDIRS):
	+$(MAKE) -C $@


dwhd-design.pdf: common.tex design-changelog.tex

%.pdf: %.tex
	pdflatex -shell-escape $<
	pdflatex -shell-escape $<
