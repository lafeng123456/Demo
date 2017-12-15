package com.example.springboot.demo.demo.util;

import com.thoughtworks.xstream.XStream;

public class XStreamUtil {

    private static XStream xStream;

    /**
     * 获取Xstream
     * @return
     */
    public static XStream getXStream() {
        if (null == xStream) {
            synchronized (XStream.class) {
                if (null == xStream) {
                    xStream = new XStream();
                }
            }
        }
        return xStream;
    }
}
