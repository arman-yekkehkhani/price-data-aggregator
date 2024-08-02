package com.trivago.casestudy.services.dataloader;

import com.trivago.casestudy.models.AdvertiserInfo;

import java.net.URL;

public interface FileDataLoader {
    AdvertiserInfo loadFrom(URL resource);
}
