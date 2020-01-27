package com.bloodnighttw;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Enumeration;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class JarLoaderTest {

    private final static String Path="/home/bbeenn1227/IdeaProjects/JarLoaderTest1/build/classes/java/main/";

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        //JarFile jar=new JarFile(Path);
        URL url=new URL("jar:file:"+Path+"JarLoaderTest1.jar/!/info.json");
        InputStream ip=url.openStream();
        Scanner sc=new Scanner(ip);
        String st="";
        for(int i=0;true;i++){
            try {
                st = st + sc.nextLine()+"\n";
            }catch (NoSuchElementException e){
                break;
            }
        }

        //st=st.replace("\t","");
        System.out.println(st);
        Gson gson=new Gson();
        infoObject fg=gson.fromJson(st,infoObject.class);
        System.out.println(fg.getMainClassPakagePath()+" "+fg.getPluginName()+" "+fg.getVersion());

        /*
         *      ClassLoade
         */

        URL[] urls={new URL("jar:file:"+Path+"JarLoaderTest1.jar/!/")};

        URLClassLoader  ucl=URLClassLoader.newInstance(urls);

        Class c=ucl.loadClass(fg.getMainClassPakagePath());

        ExtendPoint ep = null;

        try {
            ep= (ExtendPoint) c.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        ep.messanger();


    }
}