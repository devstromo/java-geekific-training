package com.devtstromo.behavioral.template_method;

public class DiabloLoader extends BaseGameLoader{
    @Override
    protected byte[] loadLocalData() {
        System.out.println("Loading Diablo files ...");
        return new byte[0];
    }

    @Override
    protected void createObjects(byte[] data) {
        System.out.println("Creating Diablo objects ...");
    }

    @Override
    protected void downloadAdditionalFiles() {
        System.out.println("Downloading Diablo sounds ...");
    }

    @Override
    protected void initializerProfiles() {
        System.out.println("Loading Diablo profiles ...");
    }
}
