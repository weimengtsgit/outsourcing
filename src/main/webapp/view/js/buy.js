function reduceNum() {
    var numValue = $("#num").val();
    if (!isNaN(Number(numValue))) {
        var num = Number(numValue);
        if (num > 1) {
            $("#num").val(num - 1);
        }
    }
    changePrice();
}

function addNum() {
    var numValue = $("#num").val();
    if (!isNaN(Number(numValue))) {
        var num = Number(numValue);
        $("#num").val(num + 1);
    } else {
        $("#num").val(1);
    }
    changePrice();
}

function numChange() {
    var numValue = $("#num").val();
    if (isNaN(Number(numValue))) {
        $("#num").val(1);
    }
    changePrice();
}

function changePrice() {
    var num = $("#num").val();
    var price = parseInt(num) * 179;
    $('#totalPrice').val(price);
}

function submit() {
    var id = "8aad14cd5b2247b3015b2248bd830000";
    var name = $('#name').val();
    var tel = $('#tel').val();
    var email = $('#email').val();
    var adress = $('#adress').val();
    var num = $("#num").val();
    var comment = $("#comment").val();
    if (name.length == 0) {
        alert("請輸入姓名");
        return;
    }
    if (tel.length == 0) {
        alert("請輸入手機號碼");
        return;
    }

    if (email.length == 0 || !validateEmail(email)) {
        alert("請輸入正確的E-mail地址");
        return;
    }
    if (adress.length == 0) {
        alert("請輸入詳細地址");
        return;
    }
    $.ajax({
        url : 'order',
        type : 'POST',
        data : {
            goodId : id,
            number : num,
            name : name,
            adress : adress,
            tel : tel,
            email : email,
            comment : comment
        },
        dataType : 'json',
        success : function(data, status) {
            if ("true" == data.result) {
//                alert("恭喜您, 訂單提交成功. 我們已經收到您的訂單,將盡快為您發寄出寶貝。");
                window.location.href = "success";
            } else {
                alert("訂單提交失敗，請稍後再試。");
            }
        },
        error : function(data, status) {
            alert("訂單提交失敗，請稍後再試。");
        }
    });
}

function validateEmail(email) {
    var search_str = /^[\w\-\.]+@[\w\-\.]+(\.\w+)+$/;
    if (!search_str.test(email)) {
        return false;
    } else {
        return true;
    }
}

var quotes = new Array("犰狳發聲玩具 NT$179");

var marquee = new Array("<p><span>[最新購買]：</span>張**（095***6831）在1分鐘前訂購了"
        + quotes[Math.floor((Math.random() * quotes.length))]
        + " <font color='#FF0000'>√</font></p>",
        "<p><span>[最新購買]：</span>李**（093***1685）在3分鐘前訂購了"
                + quotes[Math.floor((Math.random() * quotes.length))]
                + " <font color='#FF0000'>√</font></p>",
        "<p><span>[最新購買]：</span>趙**（091***8603）在5分鐘前訂購了"
                + quotes[Math.floor((Math.random() * quotes.length))]
                + " <font color='#FF0000'>√</font></p>",
        "<p><span>[最新購買]：</span>劉**（093***3943）在2分鐘前訂購了"
                + quotes[Math.floor((Math.random() * quotes.length))]
                + " <font color='#FF0000'>√</font></p>",
        "<p><span>[最新購買]：</span>張**（098***5500）在4分鐘前訂購了"
                + quotes[Math.floor((Math.random() * quotes.length))]
                + " <font color='#FF0000'>√</font></p>",
        "<p><span>[最新購買]：</span>王**（092***0214）在6分鐘前訂購了"
                + quotes[Math.floor((Math.random() * quotes.length))]
                + " <font color='#FF0000'>√</font></p>");
var wfgdaa = 0;
var wfgdbb = 1;
function marqueeL() {
    if (wfgdaa > (marquee.length - 1))
        wfgdaa = 0;
    if (wfgdbb > (marquee.length - 1))
        wfgdaa = 0;
    wfgdbb = wfgdaa + 1;
    var marHTML = marquee[wfgdaa] + marquee[wfgdbb];
    document.getElementById("fahuo").innerHTML = marHTML;
    wfgdaa += 1;
    wfgdbb += 1;
}
window.setInterval("marqueeL()", 3000);