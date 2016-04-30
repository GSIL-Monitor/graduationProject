var xhr ;

// 初始化 xhr 对象
// return value : 1 : IE , 2 , Mozila , 0 : create xhr error ;
function createXHR(){
    // 1,创建xhr 对象 .
    if( window.ActiveXObject ){
        xhr = new ActiveXObject( "Microsoft.XMLHTTP" ) ;
        return 1 ;
    }else if( window.XMLHttpRequest ){
        xhr = new XMLHttpRequest();
        return 2 ;
    }else{
        return 0 ;
    }
}


function onloadVal(){
    var ret = createXHR();
    if( ret == 0 ){
        alert( "create xhr error" ) ;
    }else{
        // 在xhr中注册用于处理应答的函数(handleCheck)
        xhr.onreadystatechange = handleCheck ;
        /*
         * //使用Get方式向服务器发送请求 .
         * var url = makeQueryString( "/ajax/reg.jsp" );
         * xhr.open( "get" , url ) ;
         * xhr.send( null );
         */

        // 通过Post 形式向服务器发送数据 .
        var url = "http://localhost:8080/adminAction_stuModifyVal" ;
        xhr.open( "post" , url ) ;
        xhr.setRequestHeader( "Content-Type" , "application/x-www-form-urlencoded" ) ;
        xhr.send( makeQueryString( null ) ) ;
    }
}

// 在指定的URL上添加参数
function makeQueryString( url ){
    return null
}

function handleCheck(){
    // 通信过程结束 .
    // readyState : 1: 初始化阶段 2 ：连接建立阶段 3 : 通信中阶段 4 ： 通信结束
    if( xhr.readyState == 4 ){
        // status==200,表示服务器运行正常,其他值代表错误
        if( xhr.status == 200 ){
            processResult();
        }else {
           alert("服务异常，请稍后重试")
        }
    }else{
    }
}

function processResult(){
    // 获得应答内容
    var result=xhr.responseText;
    var json=JSON.parse(result);
    alert(result);
    var stuNo=getElement("stuNo");
    stuNo.value=json.stuNo;
    var name=getElement("name");
    name.value=json.name;
    var className=getElement("className");
    className.value=json.className;

}
function getElement(elementId) {
    return document.getElementById(elementId)
}