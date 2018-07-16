package com.project.ydy.arouter.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * **************************************************
 * 文件名称 : Person
 * 作    者 : Created by ydy
 * 创建时间 : 2018/7/16 10:08
 * 文件描述 :
 * 注意事项 :
 * 修改历史 : 2018/7/16 1.00 初始版本
 * **************************************************
 */
public class Person implements Parcelable {

    private String sex;
    private String job;

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.sex);
        dest.writeString(this.job);
    }

    public Person() {
    }

    protected Person(Parcel in) {
        this.sex = in.readString();
        this.job = in.readString();
    }

    public static final Parcelable.Creator<Person> CREATOR = new Parcelable.Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel source) {
            return new Person(source);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };
}
