package com.example.myapplication;

public class cu {
    private String Imgurl;
    private String Imgurl1;
    private String location;
    private String Description;
    private String Usrid;
    private String type;
    private String reply;
    private String clkey;
    private String casenumber;
    private String ip;


    public cu(String Imgurl, String Imgurl1,String location, String Description,String Usrid,String type,String reply,String clkey,String casenumber,String ip) {
        this.Imgurl = Imgurl;
        this.Imgurl1 = Imgurl1;
        this.location = location;
        this.Description = Description;
        this.Usrid = Usrid;
        this.type=type;
        this.reply=reply;
        this.clkey=clkey;
        this.casenumber=casenumber;
        this.ip=ip;


    }


    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }
    public String getCasenumber() {
        return casenumber;
    }

    public void setCasenumber(String casenumber) {
        this.casenumber = casenumber;
    }

    public String getClkey() {
        return clkey;
    }

    public void setClkey(String clkey) {
        this.clkey = clkey;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public cu()
    {

    }
    public String getImgurl() {
        return Imgurl;
    }

    public void setImgurl(String Imgurl) {
        this.Imgurl = Imgurl;
    }



    public String getImgurl1() {
        return Imgurl1;
    }

    public void setImgurl1(String Imgurl1) {
        this.Imgurl1 = Imgurl1;
    }
    public void setUsrid(String Usrid) {
        this.Usrid = Usrid;
    }
    public String getUsrid() {
        return Usrid;
    }
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

}
