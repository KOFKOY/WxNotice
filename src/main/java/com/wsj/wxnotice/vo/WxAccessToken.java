package com.wsj.wxnotice.vo;

public class WxAccessToken {

    /**
     * errcode : 0
     * access_token : accesstoken000001
     * errmsg : ok
     * expires_in : 7200
     */
    private int errcode;
    private String access_token;
    private String errmsg;
    private int expires_in;

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }

    public int getErrcode() {
        return errcode;
    }

    public String getAccess_token() {
        return access_token;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public int getExpires_in() {
        return expires_in;
    }
}
