$(function () {
    //注意：导航 依赖 element 模块，否则无法进行功能性操作
    layui.use('element', function () {
        var element = layui.element;
        //…
    });

    layui.use('flow', function(){
        var $ = layui.jquery; //不用额外加载jQuery，flow模块本身是有依赖jQuery的，直接用即可。
        var flow = layui.flow;
        flow.load({
            elem: '#demo01' //流加载容器
            ,scrollElem: '#demo01'
            ,isAuto: true
            ,isLazyimg: true
            ,done: function(page, next){ //加载下一页
                setTimeout(function(){
                    var lis = [];
                    $.get("/platListPage?limit=35&page="+page,function(res){
                        res.data.forEach(function(item,index){
                            var li = "<li><div class='u-cover'><img src='"+item.img_url+"'/>" +
                                "<a title='"+item.title+"' href='"+item.url+"'></a></div>" +
                                "<p class='dec'><a title='"+item.title+"' href='"+item.url+"'>"+item.title+"</a></p></li>";
                            lis.push(li);
                        })
                        next(lis.join(''), page < res.count/12);
                    })
                }, 500);
            }
        });
    });

    function swtichPlayButton() {
        debugger;
        var goOn_player = $("#goOn_player").css('display');
        var pause_player = $("#pause_player").css('display');
        if(goOn_player =="inline" && pause_player =="none"){
            $("#goOn_player").css("display","none");
            $("#pause_player").css("cssText","display:inline !important;");
        }else if(pause_player =="inline" && goOn_player =="none"){
            $("#pause_player").css("cssText","display:none !important;");
            $("#goOn_player").css("display","inline");
        }
    }
    $("#goOn_player").on("click",function () {
        swtichPlayButton();
    });
    $("#pause_player").on("click",function () {
        swtichPlayButton();
    });

})