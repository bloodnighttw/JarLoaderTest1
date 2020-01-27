package com.bloodnighttw;


public class infoObject {

    private final String MainClassPakagePath;
    private final String PluginName;
    //private final String[] loadBefore;
    private final String version;

    public infoObject(String mainClassPakagePath, String pluginName, String[] loadBefore, String version) {
        this.MainClassPakagePath = mainClassPakagePath;
        this.PluginName = pluginName;
        //this.loadBefore = loadBefore;
        this.version = version;
    }

    public String getMainClassPakagePath() {
        return MainClassPakagePath;
    }

    public String getPluginName() {
        return PluginName;
    }

    public String getVersion() {
        return version;
    }

    /*public String[] getLoadBefore() {
        return loadBefore;
    }

     */
}
