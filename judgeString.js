var jugdeString = function(e) {

    var nums = {"壹": 1, "贰": 2, "叁": 3, "肆": 4, "伍": 5, "陆": 6, "柒": 7, "捌": 8, "玖": 9};
    var keys = {"仟": 1000, "佰": 100, "拾": 10}
    var levels = {"万": 10000, "亿": 100000000} //3, 6

    if(Number.isInteger(e)) {
        console.log("小写转大写");
        return 1;

    } else {
        let str = toString(e)
        let sums = 0;
        let tempSums = 0;
        let temptempSums = 0;
        for(let i = 0; i < str.length-2; i++) {
            if(str.charAt(i) in nums) {
                temptempSums += nums[str.charAt(i)];
            } else if(str.charAt(i) in keys) {
                temptempSums *= keys[str.charAt(i)];
                tempsums += temptempSums;
                temptempSums = 0;
            } else if(str.charAt(i) in levels) {
                tempsums *= levels[str.charAt(i)];
                sums += tempSums;
                tempSums = 0;
            } else {
                return 0;
            }
        }
        sums = sums + tempSums + temptempSums;
        console.log(sums)
        let temp = digitUppercase(sums);
        if(temp == inputText.value) {
            return 2;
        } else {
            return 0;
        }
    }

}


var digitUppercase = function(n) {
    var fraction = ['角', '分'];

    var digit = [
        '零', '壹', '贰', '叁', '肆',
        '伍', '陆', '柒', '捌', '玖'
    ];

    var unit = [
        ['元', '万', '亿'],
        ['', '拾', '佰', '仟']
    ];
    var head = n < 0 ? '欠' : '';
    n = Math.abs(n);
    var s = '';
    for (var i = 0; i < fraction.length; i++) {
        s += (digit[Math.floor(n * 10 * Math.pow(10, i)) % 10] + fraction[i]).replace(/零./, '');
    }
    s = s || '整';
    n = Math.floor(n);
    for (var i = 0; i < unit[0].length && n > 0; i++) {
        var p = '';
        for (var j = 0; j < unit[1].length && n > 0; j++) {
            p = digit[n % 10] + unit[1][j] + p;

            n = Math.floor(n / 10);
        }
        s = p.replace(/(零.)*零$/, '').replace(/^$/, '零') + unit[0][i] + s;
    }
    return head + s.replace(/(零.)*零元/, '元')
        .replace(/(零.)+/g, '零')
        .replace(/^整$/, '零元整');
};

