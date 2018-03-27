
SUBDIRS := $(wildcard */.)
SUBDIRSCLEAN=$(addsuffix clean,$(SUBDIRS))

.PHONY: all $(SUBDIRS) $(SUBDIRSCLEAN)

all: $(SUBDIRS)
$(SUBDIRS):
	+$(MAKE) -C $@

clean: $(SUBDIRSCLEAN)
$(SUBDIRSCLEAN):
	+$(MAKE) -C $(subst clean,,$@) clean
