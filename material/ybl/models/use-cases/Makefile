
SUBDIRS := $(wildcard */.)

.PHONY: all $(SUBDIRS) $(SUBDIRSCLEAN)

all: $(SUBDIRS)
$(SUBDIRS):
	+$(MAKE) -C $@

clean: $(SUBDIRSCLEAN)
$(SUBDIRSCLEAN):
	+$(MAKE) -C $(subst clean,,$@) clean
