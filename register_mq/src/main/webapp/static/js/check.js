var check = {
    URL: {
        phoneUrl: "/register/checkRepeatPhone",
        mailUrl: "/register/checkRepeatMail"
    },
    checkName: function (uName) {
        if (uName == "") {
            return "用户名不能为空";
        }
        if (uName.length > 12) {
            return "用户名超过12位";
        }
        return "";
    },
    checkPwd: function (uPwd, confirmPwd) {
        if (uPwd == "") {
            return "密码不能为空";
        } else if (uPwd.length > 16) {
            return "密码小于17位";
        }
        if (uPwd != confirmPwd) {
            return "密码不一致";
        }
        return "";
    },
    checkRepeatPhone: function (uPhone) {
        var str="";
        $.ajax({
            url: check.URL.phoneUrl,
            type: "get",
            data: {phone: uPhone},
            async: false,
            success: function (result) {
                if (result) {
                    str= "手机号码重复";
                }
            }
        });
        return str;
    },
    checkPhone: function (uPhone) {
        var myreg = /^((13\d{9}$)|(15[0-9]\d{8}$)|(18[0-9]\d{8}$)|(147\d{8})$|(17\d{9}$))/;
        if (uPhone == "") {
            return "电话号码不能为空";
        } else if (uPhone.length != 11 || !myreg.test(uPhone)) {
            return "电话号码错误";
        } else {
            return check.checkRepeatPhone(uPhone);
        }
    },
    checkRepeatMail: function (uMail) {
        var str="";
        $.ajax({
            url: check.URL.mailUrl,
            type: "get",
            data: {mail: uMail},
            async: false,
            success: function (result) {
                if (result) {
                    str="邮箱重复";
                }
            }
        });
        return str;
    },
    checkMail: function (uMail) {
        var reg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((.[a-zA-Z0-9_-]{2,3}){1,2})$/;
        if (uMail == "") {
            return "邮箱不能为空";
        } else {
            if (!reg.test(uMail)) {
                return "邮箱错误";
            } else {
              return check.checkRepeatMail(uMail);
            }
        }
    },
    verify: function (uName, uPwd, confirmPwd, uPhone, uMail) {
        var nameInfo = check.checkName(uName);
        if (nameInfo != "") {
            var uNameInput = $("#uName-label");
            uNameInput.html(nameInfo);
            uNameInput.show();
            return false;
        } else {
            var pwdInfo = check.checkPwd(uPwd, confirmPwd);
            if (pwdInfo != "") {
                var uPwdInput = $("#uPwd-label");
                uPwdInput.html(pwdInfo);
                uPwdInput.show();
                return false;
            } else {
                var phoneInfo = check.checkPhone(uPhone);
                if (phoneInfo != "") {
                    var uPhoneInput = $("#uPhone-label");
                    uPhoneInput.html(phoneInfo);
                    uPhoneInput.show();
                    return false;
                } else {
                    var mailInfo = check.checkMail(uMail);
                    if (mailInfo != "") {
                        var uMailInput = $("#uMail-label");
                        uMailInput.html(mailInfo);
                        uMailInput.show();
                        return false;
                    } else {
                        return true;
                    }
                }
            }
        }
    }
}