all: build-be build-fe run-be run-fe

build-be:
	docker build -t ae-test/be ./backend

build-fe:
	docker build -t ae-test/fe ./front-end

run-be:
	docker run -d -p 8080:8080 ae-test/be:latest

run-fe:
	docker run -d -p 80:80 ae-test/fe:latest
