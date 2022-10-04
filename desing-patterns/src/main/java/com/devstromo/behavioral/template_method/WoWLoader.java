package com.devstromo.behavioral.template_method;

public class WoWLoader extends BaseGameLoader{
    @Override
    protected byte[] loadLocalData() {
        System.out.println("Loading WoW files ...");
        return new byte[0];
    }

    @Override
    protected void createObjects(byte[] data) {
        System.out.println("Creating WoW objects ...");
    }

    @Override
    protected void downloadAdditionalFiles() {
        System.out.println("Downloading WoW sounds ...");
    }

    @Override
    protected void initializerProfiles() {
        System.out.println("Loading WoW profiles ...");
    }
}
