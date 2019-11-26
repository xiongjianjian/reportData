var issubmit = false;

function dosubmit() {
    if (issubmit == false) {
        issubmit = true;
        return true;
    } else {
        return false;
    }

}

function checkInfo() {
    //var checkCodeName = checkCodeNameNotAllNull();
    //var checkTelPhone = CheckMobile();
    //var checkRealName = checkRealNameNotNull();
    //var checkYourCard = checkMyIdcard();
    if (this.checkCodeNameNotAllNull() && this.CheckMobile() && this.checkRealNameNotNull() && this.checkMyIdcard()) {
        return true;
    } else {
        return false;
    }
}

function checkCodeNameNotAllNull() {
    //客户编号与销售员编号不能同时为空
    var customerCodeValue = document.getElementById('customerCode').value;
    var saleCodeValue = document.getElementById('saleCode').value;
    if (typeof customerCodeValue == "undefined" || customerCodeValue == null || customerCodeValue == "") {
        if (typeof saleCodeValue == "undefined" || saleCodeValue == null || saleCodeValue == "") {
            alert("客户编号与销售员编号不能同时为空！");
            return false;
        } else {
            return true;
        }
    } else {
        return true;
    }
}

function CheckMobile() {
    //手机号码有误，请重填
    var phone = document.getElementById('mobile').value;
    if (!(/^1(3|4|5|6|7|8|9)\d{9}$/.test(phone))) {
        alert("手机号码有误，请重填");
        return false;
    } else {
        return true;
    }
}

function checkRealNameNotNull() {
    //用户姓名不能为空
    var realName = document.getElementById('realName').value;
    if (typeof realName == "undefined" || realName == null || realName == "") {
        alert("姓名不可为空！");
        return false;
    } else {
        return true;
    }
}

function checkMyIdcard() {
    // 身份证号码为15位或者18位，15位时全为数字，18位前17位为数字，最后一位是校验位，可能为数字或字符X
    var card = document.getElementById('idCard').value;
    var reg = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
    if (typeof card == "undefined" || card == null || card == "") {
        return true;
    } else {
        if (!reg.test(card)) {
            alert("身份证输入不合法");

            return false;
        } else {
            return true;
        }
    }
}

function checkSaleCodeIsExist() {
    $("#saleCodeMsg").html("");
    var accSale = $("#saleCode").attr("name");
    var strSale = $("#saleCode").val();
    var value;
    if (typeof strSale == "undefined" || strSale == null || strSale == "") {
        return false;
    } else {
        value = accSale + ":" + strSale;
        $.ajax({
            //请求方式
            type: "GET",
            //请求的媒体类型
            //contentType: "application/json;charset=UTF-8",
            //请求地址
            url: "checkAccount?account=" + value,
            //数据，json字符串
            //data : JSON.stringify(list),
            //异步
            async: true,
            //请求成功
            success: function (result) {
                if (result == 1) {
                    $("#saleCodeMsg").html("账号 '"+strSale+"' 已存在!");
                    $("#saleCode").val("");
                } else {
                }
            },
            //请求失败，包含具体的错误信息
            error : function(e){
                console.log(e.status);
                console.log(e.responseText);
            }
        });
    }
}

function checkCustomerCodeIsExist() {
    $("#customerCodeMsg").html("");
    var accCust = $("#customerCode").attr("name");
    var strCust = $("#customerCode").val();
    var value;
    if (typeof strCust == "undefined" || strCust == null || strCust == "") {
        return false;
    } else {
        value = accCust + ":" + strCust;
        $.ajax({
            //请求方式
            type: "GET",
            //请求的媒体类型
            //contentType: "application/json;charset=UTF-8",
            //请求地址
            url: "checkAccount?account=" + value,
            //数据，json字符串
            //data : JSON.stringify(list),
            //异步
            async: true,
            //请求成功
            success: function (result) {
                //alert(result)
                if (result == 1) {
                    $("#customerCodeMsg").html("账号 '"+strCust+"' 已存在！");
                    $("#customerCode").val("");
                    //$("#customerCodeMsg").html("");
                } else {

                }
            },
             //请求失败，包含具体的错误信息
             error : function(e){
                 console.log(e.status);
                 console.log(e.responseText);
             }
        });
    }
}