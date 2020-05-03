package com.jyp.studydemo.main;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ：jiyuepeng
 * @date ：Created in 2020/5/1 18:44
 * @description:
 */
public class MetaSpaceOOM {

    public static void main(String[] args){
        URL url = null;
        List<ClassLoader> classLoaderList = new ArrayList<ClassLoader>();
        try {
            url = new File("/tmp").toURI().toURL();
            URL[] urls = {url};
            while (true){
                ClassLoader loader = new URLClassLoader(urls);
                classLoaderList.add(loader);
                loader.loadClass("com.jyp.studydemo.main.Test");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


//    Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
}
