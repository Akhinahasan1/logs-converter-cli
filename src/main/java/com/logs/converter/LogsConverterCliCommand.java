package com.logs.converter;

import com.logs.converter.comman.ConverterCommand;
import io.micronaut.configuration.picocli.PicocliRunner;
import io.micronaut.context.ApplicationContext;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.io.File;
import java.io.IOException;

@Command(name = "convertLog", mixinStandardHelpOptions = true, version = "convertLog 0.1",
        description = "untuk mengambil memproses file log pada file system.")
public class LogsConverterCliCommand implements Runnable {

    @Option(names = {"-v", "--verbose"}, description = "...")
    boolean verbose;

    @Parameters(index = "0", description = "The log file whose convert to process.", defaultValue = "/var/log")
    private File file = new File("/var/log");

    @Parameters(index = "1", description = "The log file whose convert to process.", defaultValue = "/var/log")
    private String output = "/var/log";

    @Option(names = {"-t", "--type"}, description = "Available values: json, text. Default: text.")
    private String type = "text";

    public static void main(String[] args) throws Exception {
        PicocliRunner.run(LogsConverterCliCommand.class, args);
    }


    public void run() {
        // business logic here
        try {
            processConverter(file,type,output);
        } catch (IOException e) {
            System.out.println("error :" + e);
        }
        if (verbose) {
            System.out.println("Hi!");
        }
    }

    private void processConverter(File file, String type, String output) throws IOException {
        if("text".equals(type)){
            String newFilename = FilenameUtils.removeExtension(file.getName());
            String outputPath = output.concat(newFilename).concat(".txt");
            FileUtils.copyFile(file, new File(outputPath));
        }else{
            String newFilename = FilenameUtils.removeExtension(file.getName());
            String outputPath = output.concat(newFilename).concat(".json");
            FileUtils.copyFile(file, new File(outputPath));
        }
        System.out.printf("path file log" + file.getPath()
                + " \n convert type "
                + "output file path"+output);
    }
}
