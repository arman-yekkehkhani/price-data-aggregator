package com.trivago.casestudy.services.dataloader;

public class FileDataLoaderFactory {

    FileDataLoader createLoader(FileType fileType) {
        return switch (fileType) {
            case json -> new JsonLoader();
            case yaml -> new YamlLoader();
        };
    }
}
