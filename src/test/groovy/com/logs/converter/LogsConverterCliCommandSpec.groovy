package com.logs.converter

import io.micronaut.configuration.picocli.PicocliRunner
import io.micronaut.context.ApplicationContext
import io.micronaut.context.env.Environment

import spock.lang.AutoCleanup
import spock.lang.Shared
import spock.lang.Specification

import java.io.ByteArrayOutputStream
import java.io.PrintStream

class LogsConverterCliCommandSpec extends Specification {

//    @Shared @AutoCleanup ApplicationContext ctx = ApplicationContext.run(Environment.CLI, Environment.TEST)
//
//    void "test logs-converter-cli converter logs file"() {
//        given:
//        ByteArrayOutputStream baos = new ByteArrayOutputStream()
//        System.setOut(new PrintStream(baos))
//
//        String[] args = ['-t','-o','java','--verbose'] as String[]
//        PicocliRunner.run(LogsConverterCliCommand, ctx, args)
//
//        expect:
//        baos.toString().contains('Hi!')
//    }
}

