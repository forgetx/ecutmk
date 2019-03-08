// 根据 指定的 CSS 选择器 来获取页面匹配于该选择器的第一个元素
var image = document.querySelector( ".main .sign .identity span img" );
// 将 整个函数作为一个取值 赋值给 一个变量，以后再使用该变量时，它就表示一个函数
var listener = function( e ){
    console.log( e );
    // 当点击事件发生后，会执行该函数，浏览器会通过该函数第一次参数传递"事件"对象
    e.stopPropagation(); // 停止事件传播
    e.preventDefault(); // 阻止事件的默认行为

    var url = "/identity/code/" + Date.now() ;

    image.setAttribute( "src" , url ) ; // 等价于 image.src = url ;

}
// 为 image 表示的元素绑定 点击事件 ( click ) 处理函数 ( listener )
image.addEventListener( "click"  , listener , false );