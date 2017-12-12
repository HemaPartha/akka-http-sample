#!/usr/bin/env bash
sbt clean compile
sbt test
sbt "set test in assembly := {}" assembly