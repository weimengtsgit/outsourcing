var sensorTable;
var globalOrderNum;

$(function() {
    initTable();
});

function confirmBuy() {
    $.ajax({
        url : 'confirmBuy',
        type : 'POST',
        data : {
            orderNum : globalOrderNum
        },
        dataType : 'json',
        success : function(data, status) {
            if ("success" == data.result) {
                reloadTable();
                $('#myModal').modal('hide');
            }
        },
        error : function(data, status) {
            alert("服务器异常。");
        }
    });
}

function confirmSend() {
    $.ajax({
        url : 'confirmSend',
        type : 'POST',
        data : {
            orderNum : globalOrderNum
        },
        dataType : 'json',
        success : function(data, status) {
            if ("success" == data.result) {
                reloadTable();
                $('#myModal').modal('hide');
            }
        },
        error : function(data, status) {
            alert("服务器异常。");
        }
    });
}

function confirmFinish() {
    $.ajax({
        url : 'confirmFinish',
        type : 'POST',
        data : {
            orderNum : globalOrderNum
        },
        dataType : 'json',
        success : function(data, status) {
            if ("success" == data.result) {
                reloadTable();
                $('#myModal').modal('hide');
            }
        },
        error : function(data, status) {
            alert("服务器异常。");
        }
    });
}

function detail(orderNum, type) {
    globalOrderNum = orderNum;
    
    // clear
    $('#name-span').html("");
    $('#name-tel').html("");
    $('#name-email').html("");
    $('#name-adress').html("");
    $('#name-comment').html("");
    $("#goods-table tbody").html("");
    
    if ("show" == type) {
        $('#show-div').show();
        $('#buy-div').hide();
        $('#send-div').hide();
        $('#finish-div').hide();
    } else if ("buy" == type) {
        $('#show-div').hide();
        $('#buy-div').show();
        $('#send-div').hide();
        $('#finish-div').hide();
    } else if ("send" == type) {
        $('#show-div').hide();
        $('#buy-div').hide();
        $('#send-div').show();
        $('#finish-div').hide();
    } else if ("finish" == type) {
        $('#show-div').hide();
        $('#buy-div').hide();
        $('#send-div').hide();
        $('#finish-div').show();
    }
    $('#myModal').modal('show');
    $.ajax({
        url : 'detail',
        type : 'POST',
        data : {
            orderNum : orderNum
        },
        dataType : 'json',
        success : function(data, status) {
            if ("success" == data.result) {
                $('#name-span').html(data.data.name);
                $('#name-tel').html(data.data.tel);
                $('#name-email').html(data.data.email);
                $('#name-adress').html(data.data.adress);
                $('#name-comment').html(data.data.comment);
                var list = data.data.goodsList;
                if (list.length > 0) {
                    for (i = 0; i < list.length; i++) {
                        var num = $("#goods-table tr").length;
                        $('#goods-table tbody').append(
                                "<tr><td>" + num + "</td><td>" + list[i].name
                                        + "</td><td>" + list[i].num
                                        + "</td><td>" + list[i].price
                                        + "</td></tr>");
                    }
                }
            }
        },
        error : function(data, status) {
            alert("服务器异常。");
        }
    });
}

function reloadTable() {
    sensorTable.ajax.reload();
}

function initTable() {
    sensorTable = $('#orderTable')
            .DataTable(
                    {
                        ajax : {
                            url : "search",
                            type : "post",
                            data : function(d) {
                                d.orderNum = $('#orderNum').val();
                                d.tel = $('#tel').val();
                                d.status = $('#status').val()
                            }
                        },
                        language : {
                            "sProcessing" : "处理中...",
                            "sLengthMenu" : "每页显示 _MENU_ 条,",
                            "sZeroRecords" : "没有匹配结果",
                            "sInfo" : "共 _TOTAL_ 条",
                            "sInfoEmpty" : "显示第 0 至 0 项结果，共 0 项",
                            "sInfoFiltered" : "(由 _MAX_ 项结果过滤)",
                            "sInfoPostFix" : "",
                            "sSearch" : "搜索:",
                            "sUrl" : "",
                            "sEmptyTable" : "表中数据为空",
                            "sLoadingRecords" : "载入中...",
                            "sInfoThousands" : ",",
                            "oPaginate" : {
                                "sFirst" : "首页",
                                "sPrevious" : "上一页",
                                "sNext" : "下一页",
                                "sLast" : "尾页"
                            },
                            "oAria" : {
                                "sSortAscending" : ": 以升序排列此列",
                                "sSortDescending" : ": 以降序排列此列"
                            }
                        },
                        responsive : true,
                        "dom" : 't<"table-length"l><"table-total"i><"table-page"p>',
                        "order" : [ [ 0, "asc" ] ],
                        "info" : true,
                        "paging" : true,
                        "pagingType" : "full",
                        "ordering" : true,
                        "searching" : false,
                        "bAutoWidth" : true,
                        // "data" : dataList,
                        "columns" : [
                                {
                                    data : function(data) {
                                        return '<a href=\"javascript:\" onclick=\"detail('
                                                + data.orderNum
                                                + ',\'show\');\" class=\"order-num-href\">'
                                                + data.orderNum + '</a>';
                                    }
                                },
                                {
                                    data : function(data) {
                                        return data.tel;
                                    }
                                },
                                {
                                    data : function(data) {
                                        return data.date;
                                    }
                                },
                                {
                                    data : function(data) {
                                        return data.price;
                                    }
                                },
                                {
                                    data : function(data) {
                                        return data.status;
                                    }
                                },
                                {
                                    data : function(data) {
                                        if ("下单成功" == data.status) {
                                            return '<button class=\"btn btn-primary\" onclick=\"detail('
                                                    + data.orderNum
                                                    + ',\'buy\');\">采购</button>';
                                        } else if ("采购中" == data.status) {
                                            return '<button class=\"btn btn-primary\" onclick=\"detail('
                                                    + data.orderNum
                                                    + ',\'send\');\">发货</button>';
                                        } else if ("已发货" == data.status) {
                                            return '<button class=\"btn btn-primary\" onclick=\"detail('
                                                    + data.orderNum
                                                    + ',\'finish\');\">完成</button>';
                                        } else if ("订单完成" == data.status) {
                                            return '<button class=\"btn btn-primary\" onclick=\"detail('
                                                    + data.orderNum
                                                    + ',\'show\');\">查看</button>';
                                        } else {
                                            return '<button class=\"btn btn-primary\" onclick=\"detail('
                                                    + data.orderNum
                                                    + ',\'show\');\">查看</button>';
                                        }
                                    }
                                } ]
                    });
}
