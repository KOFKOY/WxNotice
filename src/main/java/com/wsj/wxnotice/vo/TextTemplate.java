package com.wsj.wxnotice.vo;

import java.util.Calendar;

public class TextTemplate {
    private int agentid = 1000002;
    private String touser;
    private int enable_duplicate_check;
    private String totag;
    private TextcardEntity textcard;
    private int duplicate_check_interval;
    private String msgtype="textcard";
    private int enable_id_trans;
    private String toparty;

    /**
     *
     * @param touser 接受消息的人多人用 | 分隔
     * @param title  消息的标题
     * @param name   事件名称
     * @param tip    温馨提示
     */
    public TextTemplate(String touser, String title,String name,String tip) {
        this.touser=touser;
        this.textcard=new TextTemplate.TextcardEntity(title,name,tip);
    }

    public int getAgentid() {
        return agentid;
    }

    public void setAgentid(int agentid) {
        this.agentid = agentid;
    }

    public String getTouser() {
        return touser;
    }

    public void setTouser(String touser) {
        this.touser = touser;
    }

    public int getEnable_duplicate_check() {
        return enable_duplicate_check;
    }

    public void setEnable_duplicate_check(int enable_duplicate_check) {
        this.enable_duplicate_check = enable_duplicate_check;
    }

    public String getTotag() {
        return totag;
    }

    public void setTotag(String totag) {
        this.totag = totag;
    }

    public TextcardEntity getTextcard() {
        return textcard;
    }

    public void setTextcard(TextcardEntity textcard) {
        this.textcard = textcard;
    }

    public int getDuplicate_check_interval() {
        return duplicate_check_interval;
    }

    public void setDuplicate_check_interval(int duplicate_check_interval) {
        this.duplicate_check_interval = duplicate_check_interval;
    }

    public String getMsgtype() {
        return msgtype;
    }

    public void setMsgtype(String msgtype) {
        this.msgtype = msgtype;
    }

    public int getEnable_id_trans() {
        return enable_id_trans;
    }

    public void setEnable_id_trans(int enable_id_trans) {
        this.enable_id_trans = enable_id_trans;
    }

    public String getToparty() {
        return toparty;
    }

    public void setToparty(String toparty) {
        this.toparty = toparty;
    }

    public static class TextcardEntity {
        /**
         * btntxt : 更多
         * description : <div class="gray">2016年9月26日</div> <div class="normal">恭喜你抽中iPhone 7一台，领奖码：xxxx</div><div class="highlight">请于2016年10月10日前联系行政同事领取</div>
         * title : 领奖通知
         * url : URL
         */
        private  String btntxt="不要点我";
        private  String description;
        private  String title;
        private  String url="http://www.wsjcm.top";

        public TextcardEntity(String title,String name,String tip){
            this.title = title;
            Calendar ca = Calendar.getInstance();
            String date = ca.get(Calendar.YEAR) + "-" + (ca.get(Calendar.MONTH) + 1) + "-" + ca.get(Calendar.DATE) + " 星期" + ca.get(Calendar.DAY_OF_WEEK);
            int i = ca.get(Calendar.MINUTE);
            String time = ca.get(Calendar.HOUR_OF_DAY) + ":" +(i/10==0?"0":"") + ca.get(Calendar.MINUTE);
            this.description = "<div class=\"gray\">"+date+"</div>\n" +
                    "提醒时间:       "+time+"\n" +
                    "事件名称：      "+name+"\n" +
                    "温馨提示：      "+tip+"\n\n" +
                    "来自小常工作室";
        }

        public String getBtntxt() {
            return btntxt;
        }

        public void setBtntxt(String btntxt) {
            this.btntxt = btntxt;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
