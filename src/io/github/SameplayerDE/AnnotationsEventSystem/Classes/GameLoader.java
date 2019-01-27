package io.github.SameplayerDE.AnnotationsEventSystem.Classes;

import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandlerFactory;

public class GameLoader extends URLClassLoader {


    public GameLoader(URL[] urls, ClassLoader parent) {
        super(urls, parent);
    }

    public GameLoader(URL[] urls) {
        super(urls);
    }

    public GameLoader(URL[] urls, ClassLoader parent, URLStreamHandlerFactory factory) {
        super(urls, parent, factory);
    }
}
