package com.example.springboot.demo.demo.domain.bean;

import java.io.Serializable;
import java.util.Date;

public class RedisDto implements Serializable{

    /** key **/
    private String key;

    /** hashKey **/
    private String hashKey;

    /** 保存的值或对象 **/
    private Object object;

    /** 过期分钟数 **/
    private Long minute;

    /** 过期日期 **/
    private Date date;




    /**
     *@return  the key
     */
    public String getKey() {
        return key;
    }
    /**
     * @param key the key to set
     */
    public void setKey(String key) {
        this.key = key;
    }
    /**
     *@return  the hashKey
     */
    public String getHashKey() {
        return hashKey;
    }
    /**
     * @param hashKey the hashKey to set
     */
    public void setHashKey(String hashKey) {
        this.hashKey = hashKey;
    }
    /**
     *@return  the object
     */
    public Object getObject() {
        return object;
    }
    /**
     * @param object the object to set
     */
    public void setObject(Object object) {
        this.object = object;
    }
    /**
     *@return  the minute
     */
    public Long getMinute() {
        return minute;
    }
    /**
     * @param minute the minute to set
     */
    public void setMinute(Long minute) {
        this.minute = minute;
    }
    /**
     *@return  the date
     */
    public Date getDate() {
        return date;
    }
    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }
}
