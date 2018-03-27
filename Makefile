
#SUBDIRS := $(wildcard */.)
SUBDIRS := docs/. models/. code/.
SUBDIRSCLEAN=$(addsuffix clean,$(SUBDIRS))

.PHONY:	all clean $(SUBDIRS) $(SUBDIRSCLEAN)

all: $(SUBDIRS)
$(SUBDIRS):
	+$(MAKE) -C $@

clean: $(SUBDIRSCLEAN)
$(SUBDIRSCLEAN):
	+$(MAKE) -C $(subst clean,,$@) clean
