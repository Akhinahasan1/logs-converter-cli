package com.logs.converter.service;


import jakarta.inject.Singleton;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

import java.io.IOException;

@Singleton
public class ConverterEngineService {
    public void processFileConverterJson(String directory) throws IOException {
        try (LineIterator it = FileUtils.lineIterator(FileUtils.getFile(directory), "UTF-8")) {
            while (it.hasNext()) {
                String line = it.nextLine();
                //this convert to json
            }
        }
    }
}
