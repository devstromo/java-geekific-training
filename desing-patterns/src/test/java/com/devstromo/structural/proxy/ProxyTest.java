package com.devstromo.structural.proxy;

import org.junit.jupiter.api.Test;

import com.devstromo.structural.proxy.cache.ProxyVideoDownloader;
import com.devstromo.structural.proxy.cache.VideoDownloader;

class ProxyTest {

    @Test
    public void testProxyInternet() {
        Internet internet = new ProxyInternet();
        internet.connectTo("google.com");
        internet.connectTo("banned.com");
    }

    @Test
    public void testProxyCache() {
        VideoDownloader videoDownloader = new ProxyVideoDownloader();
        videoDownloader.getVideo("geekific");
        videoDownloader.getVideo("geekific");
        videoDownloader.getVideo("likeNsub");
        videoDownloader.getVideo("likeNsub");
        videoDownloader.getVideo("geekific");
    }

}