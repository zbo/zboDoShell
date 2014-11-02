#!/bin/sh
http://localhost:8080/helloApp-world?name=zbo
http://localhost:8081/healthcheck

192.168.33.10:8080/dummyServer?path=zbo
192.168.33.10:8080/dummyServer/ls?path=zbo&name=bob.txt
http://192.168.33.10:8080/dummyServer/touch?path=zbo&name=bob.txt