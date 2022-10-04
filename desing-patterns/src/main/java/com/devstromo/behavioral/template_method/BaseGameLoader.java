package com.devstromo.behavioral.template_method;

public abstract class BaseGameLoader {
    public void load() {
        byte[] data = loadLocalData();
        createObjects(data);
        downloadAdditionalFiles();
        cleanTempFiles();
        initializerProfiles();
    }

    protected abstract byte[] loadLocalData();

    protected abstract void createObjects(byte[] data);

    protected abstract void downloadAdditionalFiles();

    protected abstract void initializerProfiles();

    private void cleanTempFiles() {
        System.out.println("Cleaning temporary files...");
        // Some Code
    }
}
