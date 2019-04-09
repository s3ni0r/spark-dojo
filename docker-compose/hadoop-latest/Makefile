REPO=mnt

.DEFAULT_GOAL := help

help:

	@echo ""
	@echo "This is the make help for Apache hadoop (${VERSION}) docker image"

	@echo ""

.PHONY: all
all:
	make build

.PHONY: build
build:
	docker build --no-cache -t $(REPO)/hadoop-base:latest ./base
	docker build --no-cache -t $(REPO)/resourcemanager:latest ./resourcemanager
	docker build --no-cache -t $(REPO)/nodemanager:latest ./nodemanager

.PHONY: run
run:
	@docker run -it \
		--name hadoop-base \
		--hostname hadoop-base \
		$(REPO)/hadoop-base:latest

.PHONY: clear
clear:
	@docker stop hadoop-base resourcemanager nodemanager
	@docker rm hadoop-base resourcemanager nodemanager