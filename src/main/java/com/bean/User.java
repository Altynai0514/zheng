/*
 * file name:  User.java
 * copyright:  Unis Cloud Information Technology Co., Ltd. Copyright 2015,  All rights reserved
 * description:  <description>
 * mofidy staff:  zheng
 * mofidy time:  2015年8月2日
 */
package com.bean;

/**
 * <Simple feature description >
 * <Detailed feature description>
 * 
 * @author  zheng
 * @version  [version, 2015年8月2日]
 * @see  [about class/method]
 * @since  [product/module version]
 */
public class User {
    private int id;
    
    private String name;
    
    private int age;
    
    private String hobby;
    
    private String address;

    /**
     * @return returns id
     */
    public int getId() {
        return id;
    }

    /**
     * @param assgin values to id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return returns name
     */
    public String getName() {
        return name;
    }

    /**
     * @param assgin values to name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return returns age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param assgin values to age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * @return returns hobby
     */
    public String getHobby() {
        return hobby;
    }

    /**
     * @param assgin values to hobby
     */
    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    /**
     * @return returns address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param assgin values to address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((address == null) ? 0 : address.hashCode());
        result = prime * result + age;
        result = prime * result + ((hobby == null) ? 0 : hobby.hashCode());
        result = prime * result + id;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    /**
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        if (address == null) {
            if (other.address != null)
                return false;
        }
        else if (!address.equals(other.address))
            return false;
        if (age != other.age)
            return false;
        if (hobby == null) {
            if (other.hobby != null)
                return false;
        }
        else if (!hobby.equals(other.hobby))
            return false;
        if (id != other.id)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        }
        else if (!name.equals(other.name))
            return false;
        return true;
    }

    /**
     * @return
     */
    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", age=" + age
                + ", hobby=" + hobby + ", address=" + address + "]";
    }
    
}
