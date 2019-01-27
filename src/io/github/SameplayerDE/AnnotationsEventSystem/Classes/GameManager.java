package io.github.SameplayerDE.AnnotationsEventSystem.Classes;

import io.github.SameplayerDE.AnnotationsEventSystem.Annotations.EventHandler;
import io.github.SameplayerDE.AnnotationsEventSystem.Events.Event;
import io.github.SameplayerDE.AnnotationsEventSystem.Events.Listener;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class GameManager {

    private ArrayList<Listener> listenerArrayList = new ArrayList<>();

    public void registerEvents(Listener listener) {
        listenerArrayList.add(listener);
    }

    public void callEvent(Event event) {
        for (Listener l : listenerArrayList) {
            Class c = l.getClass();
            //System.out.println(c.getName());
            for (Method m : c.getDeclaredMethods()) {
                //System.out.println(m.getName());
                for (Annotation a : m.getDeclaredAnnotations()) {
                    //System.out.println(a);
                    if (a instanceof EventHandler) {
                        //System.out.println(m.getParameterTypes()[0].getName());
                        //System.out.println(event.getClass().getName());
                        //System.out.println(String.valueOf(m.getParameterTypes()[0] == event.getClass()));
                        if (m.getParameterTypes()[0].equals(event.getClass())) {
                            try {
                                m.invoke(l, event);
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            } catch (InvocationTargetException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
    }

}
