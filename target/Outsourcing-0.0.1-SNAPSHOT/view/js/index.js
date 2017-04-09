var interval = 1000;

$(function() {
    percent();
});

function ShowCountDown(year, month, day, divname) {
    var now = new Date();
    var endDate = new Date(year, month - 1, day, now.getHours() + 8);
    var leftTime = endDate.getTime() - now.getTime();
    var leftsecond = parseInt(leftTime / 1000);
    var day1 = Math.floor(leftsecond / (60 * 60 * 24));
    var hour = Math.floor((leftsecond - day1 * 24 * 60 * 60) / 3600);
    var minute = Math
            .floor((leftsecond - day1 * 24 * 60 * 60 - hour * 3600) / 60);
    var second = Math.floor(leftsecond - day1 * 24 * 60 * 60 - hour * 3600
            - minute * 60);
    var cc = document.getElementById(divname);
    cc.innerHTML = "<span id='h'>" + 0 + hour + "</span>"
            + "<span class='colon'>時</span>" + "<span id='m'>" + minute
            + "</span>" + "<span class='colon'>分</span>" + "<span id='s'>"
            + second + "</span>" + "<span class='colon'>秒</span>";
}
window.setInterval(function() {
    ShowCountDown(2018, 4, 20, 'timer');
}, interval);

// 百分比
function percent() {
    // 获取时间点
    var curhour = 6541;
    var base = 0, range = 0;
    var percent = document.getElementById("percentNum");
    var progress = document.getElementById("progress");
    var soldNum = document.getElementById("soldNum");
    if (curhour <= 1000) {
        base = 70;
        range = 5;
    } else if (curhour <= 2000) {
        base = 70;
        range = 10;
    } else if (curhour <= 4000) {
        base = 70;
        range = 15;
    } else if (curhour <= 6000) {
        base = 70;
        range = 20;
    } else if (curhour <= 8000) {
        base = 70;
        range = 25;
    } else if (curhour < 10000) {
        base = 70;
        range = 28;
    }
    var opercent = Math.floor(range + base);
    progress.style.width = percent.innerHTML = opercent + "%";
}

$(function() {
    var demo = document.getElementById("demo");
    var demo1 = document.getElementById("demo1");
    var demo2 = document.getElementById("demo2");
    var speed = 40;// 设置向上轮动的速度
    demo2.innerHTML = demo1.innerHTML;// 复制节点
    var myFunction = setInterval("moveTop()", speed);
});

function moveTop() {
    if (demo.scrollTop >= demo2.offsetTop) {
        demo.scrollTop -= demo1.offsetHeight;
    } else {
        demo.scrollTop += 1;
    }
}

function buy() {
    window.location.href = "buy.html";
}

$(function() {
    var date = new Date();
    var year = date.getFullYear();
    var month = date.getMonth() + 1;
    var date = date.getDate();
    var htmlList = "<li><div class=\"pl-name\">" + year + "/" + month + "/" + date + "&nbsp;陈****&nbsp;&nbsp;<span>滿意度：</span>★★★★★</div><div class=\"pl-content\">毛绒的好可爱，好大一只</div></li>"
                 + "<li><div class=\"pl-name\">" + year + "/" + month + "/" + date + "&nbsp;郑****&nbsp;&nbsp;<span>滿意度：</span>★★★★★</div><div class=\"pl-content\">卖家挺细心的，精致包装，东西很满意</div></li>"
                 + "<li><div class=\"pl-name\">" + year + "/" + month + "/" + date + "&nbsp;周****&nbsp;&nbsp;<span>滿意度：</span>★★★★★</div><div class=\"pl-content\">我家毛毛好喜欢，已经玩上了</div></li>"
                 + "<li><div class=\"pl-name\">" + year + "/" + month + "/" + date + "&nbsp;王****&nbsp;&nbsp;<span>滿意度：</span>★★★★★</div><div class=\"pl-content\">像个穿山甲一样，质量非常好，谢谢卖家</div></li>"
                 + "<li><div class=\"pl-name\">" + year + "/" + month + "/" + date + "&nbsp;李****&nbsp;&nbsp;<span>滿意度：</span>★★★★★</div><div class=\"pl-content\">捏肚子那里会发声，我家狗狗一开始挺害怕的，后来就不怕了。。。它很喜欢</div></li>"
                 + "<li><div class=\"pl-name\">" + year + "/" + month + "/" + date + "&nbsp;吴****&nbsp;&nbsp;<span>滿意度：</span>★★★★★</div><div class=\"pl-content\">还可以吧。。。价格算便宜</div></li>";
//                 + "<li><div class=\"pl-name\">" + year + "/" + month + "/" + date + "&nbsp;邹****&nbsp;&nbsp;<span>滿意度：</span>★★★★★</div><div class=\"pl-content\">特意用了幾天才來評價的，真的很棒，喜歡的朋友們趕緊下手吧……?</div></li>"
//                 + "<li><div class=\"pl-name\">" + year + "/" + month + "/" + date + "&nbsp;林****&nbsp;&nbsp;<span>滿意度：</span>★★★★★</div><div class=\"pl-content\">特意用了幾天才來評價的，真的很棒，喜歡的朋友們趕緊下手吧……?</div></li>"
//                 + "<li><div class=\"pl-name\">" + year + "/" + month + "/" + date + "&nbsp;蒋****&nbsp;&nbsp;<span>滿意度：</span>★★★★★</div><div class=\"pl-content\">特意用了幾天才來評價的，真的很棒，喜歡的朋友們趕緊下手吧……?</div></li>"
//                 + "<li><div class=\"pl-name\">" + year + "/" + month + "/" + date + "&nbsp;夏****&nbsp;&nbsp;<span>滿意度：</span>★★★★★</div><div class=\"pl-content\">特意用了幾天才來評價的，真的很棒，喜歡的朋友們趕緊下手吧……?</div></li>"
//                 + "<li><div class=\"pl-name\">" + year + "/" + month + "/" + date + "&nbsp;潘****&nbsp;&nbsp;<span>滿意度：</span>★★★★★</div><div class=\"pl-content\">特意用了幾天才來評價的，真的很棒，喜歡的朋友們趕緊下手吧……?</div></li>"
//                 + "<li><div class=\"pl-name\">" + year + "/" + month + "/" + date + "&nbsp;潘****&nbsp;&nbsp;<span>滿意度：</span>★★★★★</div><div class=\"pl-content\">特意用了幾天才來評價的，真的很棒，喜歡的朋友們趕緊下手吧……?</div></li>"
//                 + "<li><div class=\"pl-name\">" + year + "/" + month + "/" + date + "&nbsp;潘****&nbsp;&nbsp;<span>滿意度：</span>★★★★★</div><div class=\"pl-content\">特意用了幾天才來評價的，真的很棒，喜歡的朋友們趕緊下手吧……?</div></li>"
//                 + "<li><div class=\"pl-name\">" + year + "/" + month + "/" + date + "&nbsp;潘****&nbsp;&nbsp;<span>滿意度：</span>★★★★★</div><div class=\"pl-content\">特意用了幾天才來評價的，真的很棒，喜歡的朋友們趕緊下手吧……?</div></li>"
//                 + "<li><div class=\"pl-name\">" + year + "/" + month + "/" + date + "&nbsp;潘****&nbsp;&nbsp;<span>滿意度：</span>★★★★★</div><div class=\"pl-content\">特意用了幾天才來評價的，真的很棒，喜歡的朋友們趕緊下手吧……?</div></li>"
//                 + "<li><div class=\"pl-name\">" + year + "/" + month + "/" + date + "&nbsp;潘****&nbsp;&nbsp;<span>滿意度：</span>★★★★★</div><div class=\"pl-content\">特意用了幾天才來評價的，真的很棒，喜歡的朋友們趕緊下手吧……?</div></li>"
//                 + "<li><div class=\"pl-name\">" + year + "/" + month + "/" + date + "&nbsp;潘****&nbsp;&nbsp;<span>滿意度：</span>★★★★★</div><div class=\"pl-content\">特意用了幾天才來評價的，真的很棒，喜歡的朋友們趕緊下手吧……?</div></li>"
//                 + "<li><div class=\"pl-name\">" + year + "/" + month + "/" + date + "&nbsp;潘****&nbsp;&nbsp;<span>滿意度：</span>★★★★★</div><div class=\"pl-content\">特意用了幾天才來評價的，真的很棒，喜歡的朋友們趕緊下手吧……?</div></li>"
//                 + "<li><div class=\"pl-name\">" + year + "/" + month + "/" + date + "&nbsp;潘****&nbsp;&nbsp;<span>滿意度：</span>★★★★★</div><div class=\"pl-content\">特意用了幾天才來評價的，真的很棒，喜歡的朋友們趕緊下手吧……?</div></li>"
//                 + "<li><div class=\"pl-name\">" + year + "/" + month + "/" + date + "&nbsp;潘****&nbsp;&nbsp;<span>滿意度：</span>★★★★★</div><div class=\"pl-content\">特意用了幾天才來評價的，真的很棒，喜歡的朋友們趕緊下手吧……?</div></li>"
//                 + "<li><div class=\"pl-name\">" + year + "/" + month + "/" + date + "&nbsp;潘****&nbsp;&nbsp;<span>滿意度：</span>★★★★★</div><div class=\"pl-content\">特意用了幾天才來評價的，真的很棒，喜歡的朋友們趕緊下手吧……?</div></li>"
//                 + "<li><div class=\"pl-name\">" + year + "/" + month + "/" + date + "&nbsp;潘****&nbsp;&nbsp;<span>滿意度：</span>★★★★★</div><div class=\"pl-content\">特意用了幾天才來評價的，真的很棒，喜歡的朋友們趕緊下手吧……?</div></li>"
//                 + "<li><div class=\"pl-name\">" + year + "/" + month + "/" + date + "&nbsp;潘****&nbsp;&nbsp;<span>滿意度：</span>★★★★★</div><div class=\"pl-content\">特意用了幾天才來評價的，真的很棒，喜歡的朋友們趕緊下手吧……?</div></li>";
    
    $('#express').html(htmlList);
});