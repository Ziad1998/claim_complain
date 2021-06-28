package com.example.myapplication;

public class Complaint {
    private String Imgurl;
    private String location;
    private String Description;
    private String Usrid;
    private String type;
    private String reply;
    private String compkey;
    private String ip;


    public Complaint(String Imgurl, String location, String Description,String Usrid,String type,String reply,String compkey,String ip) {
        this.Imgurl = Imgurl;
        this.location = location;
        this.Description = Description;
        this.Usrid = Usrid;
        this.type=type;
        this.reply=reply;
        this.compkey=compkey;
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

    public String getCompkey() {
        return compkey;
    }

    public void setCompkey(String compkey) {
        this.compkey = compkey;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public Complaint()
    {

    }
    public String getImgurl() {
        return Imgurl;
    }

    public void setImgurl(String Imgurl) {
       this.Imgurl = Imgurl;
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
