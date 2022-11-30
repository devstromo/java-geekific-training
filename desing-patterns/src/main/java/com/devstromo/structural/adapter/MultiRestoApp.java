package com.devstromo.structural.adapter;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MultiRestoApp implements IMultiRestoApp {
    @Override
    public void displayMenus(XmlData xmlData) {
        // Displays menus using XML data
    }

    @Override
    public void displayRecommendations(XmlData xmlData) {
        // Displays recommendations using XML data
    }
}
