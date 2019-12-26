package com.example.springweb.dao;

import java.io.Serializable;

public class AppInfo implements Serializable  {
    private String Id;
    private String Name;
    private String Audit_status;
    private String Classification;
    private String Name_conforms;
    private String Security_level;

    public AppInfo() {
        Id = null;
        Name = null;
        Audit_status = null;
        Classification = null;
        Name_conforms = null;
        Security_level = null;
    }

    public AppInfo(String id, String name, String audit_status, String classification, String name_conforms, String security_level) {
        Id = id;
        Name = name;
        Audit_status = audit_status;
        Classification = classification;
        Name_conforms = name_conforms;
        Security_level = security_level;
    }

    public String getId() { return Id; };

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAudit_status() {
        return Audit_status;
    }

    public void setAudit_status(String audit_status) {
        Audit_status = audit_status;
    }

    public String getClassification() {
        return Classification;
    }

    public void setClassification(String classification) {
        Classification = classification;
    }

    public String getName_conforms() {
        return Name_conforms;
    }

    public void setName_conforms(String name_conforms) {
        Name_conforms = name_conforms;
    }

    public String getSecurity_level() {
        return Security_level;
    }

    public void setSecurity_level(String security_level) {
        Security_level = security_level;
    }

    @Override
    public String toString() {
        return Id + "       " + Name + "       " + Audit_status + "       " + Classification + "       " + Name_conforms + "       " + Security_level;
    }
}
