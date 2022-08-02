package com.wsj.wxnotice.vo;

import java.util.List;

public class WxUser {
    int errcode;
    String errmsg;
    List<User> userlist;

    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public List<User> getUserlist() {
        return userlist;
    }

    public void setUserlist(List<User> userlist) {
        this.userlist = userlist;
    }

    public static class User{
        private String name;
        private List<Integer> department;
        private String userid;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<Integer> getDepartment() {
            return department;
        }

        public void setDepartment(List<Integer> department) {
            this.department = department;
        }

        public String getUserid() {
            return userid;
        }

        public void setUserid(String userid) {
            this.userid = userid;
        }
    }
}

