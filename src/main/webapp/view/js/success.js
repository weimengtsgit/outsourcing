$(function() {
    $.ajax({
        url : 'orderNum',
        type : 'POST',
        dataType : 'json',
        success : function(data, status) {
            if (null != data.orderNum && data.orderNum.length > 0) {
                $('#orderNum').html(data.orderNum);
                $('#goods').html(data.data.goodsList[0].name);
                $('#name').html(data.data.name);
                $('#tel').html(data.data.tel);
                $('#adress').html(data.data.adress);
            } else {
                $("#detail-div").hide();
            }
        },
        error : function(data, status) {
            alert("訂單提交失敗，請稍後再試。");
        }
    });
});

function returnIndex() {
    window.location.href = "index";
}