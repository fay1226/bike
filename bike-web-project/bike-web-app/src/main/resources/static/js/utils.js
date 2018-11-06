/**
 * 按钮是否可点击
 * @param that 操作的按钮
 * @param isClick 是否可点击
 * @param className 添加或删除的类名
 * */
function setBtnProps(that, text, isDisabled, className) {
    var $that = $(that);

    $that.text(text).prop('disabled', isDisabled);
    if(isDisabled)
        $that.addClass(className);
    else
        $that.removeClass(className);
}

/**
 * 显示提示toast
 * @param Ele 提示元素
 * @param childEle 内容区
 * @param inOptions 动画出现配置
 * @param outOptions 动画消失配置
 * @param time 动画时间
 * @param showTime 显示时间
 * @param text 显示文本
 * */
var animateTimer = null;
function animate(Ele, childEle, inOptions, outOptions, time, showTime, text) {
    var eleStr = "." + Ele,
        childEleStr = "." + childEle;
    $(eleStr).animate(inOptions, time, "ease-out").find(childEleStr).text(text);

    if(animateTimer)
        return;

    animateTimer = setTimeout(function () {
        $(eleStr).animate(outOptions, time, "ease-in").find(childEleStr).text('');
        animateTimer = null;
    }, showTime);
}

/**
 * 倒计时定时器
 * */
var timer = null;
function setTime(that, codeText, TIME_COUNT, times, className) {
    //设置按钮不可用
    // $(that).prop('disabled', true);

    timer && clearInterval(timer);
    timer = setInterval(function() {
        times--;
        $(that).text(times + 's');

        if(times <= 0) {
            times = TIME_COUNT;
            $(that).text(codeText);
            // $(that).prop('disabled', false);
            setBtnProps(that, codeText, false, className);

            timer && clearInterval(timer);
        }

    }, 1000);
}