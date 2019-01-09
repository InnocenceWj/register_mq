package com.wj.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class User implements Serializable {
    private Long uId;

    private String uName;

    private String uPwd;

    private Date uCreateTime;

    private String uMail;

    private String uPhone;

    private Boolean uState;

    private String uCode;

    private String uCity;

    private static final long serialVersionUID = 1L;

}