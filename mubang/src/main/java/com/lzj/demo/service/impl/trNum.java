package com.lzj.demo.service.impl;

import java.util.HashMap;
import java.util.Map;

public class trNum {
    public static void main(String[] args) {

        System.out.println(trNum.wordsToFigures("1234"));
    }
    public static String numberToChinese(String in) {
        /**
         * 阿拉伯数字转换汉语数字
         * @param 阿拉伯数字
         * @return 汉语数字
         */
        String[] ch = { "零", "一", "二", "三", "四", "五", "六", "七", "八", "九" };
        StringBuilder out = new StringBuilder();// 定义返回值变量
        StringBuilder integer = new StringBuilder(in);// 定义整数部分，假设传入参数为整数
        try {// 将所有异常统一设置为“传入参数错误”异常
            if (in.indexOf('.') != -1) {// 判断是否存在小数
                out.append(in.substring(in.indexOf('.') + 1));// 截取小数部分字符串
                integer.delete(in.indexOf('.'), in.length());// 整数部分删除“.”及后面部分字符串
                /**
                 * 分类转换小数部分
                 */
                for (int i = out.length() - 1; i >= 0; i--) {
                    if (i == out.length() - 1 && out.charAt(i) == '0') {
                        out.deleteCharAt(i);// 删除后缀“0”
                    } else {
                        out.setCharAt(i, ch[out.charAt(i) - '0'].charAt(0));
                    }
                }
                if (out.length() > 0) {
                    out.insert(0, '点');// 如果小数部分不为0则添加小数点
                }
            }
            ch[0] = "";// 转换整数部分时“零”显示为空字符串
            out.insert(0, numToCh(integer, ch));// 调用整数部分转换方法转换整数部分
        } catch (Exception e) {
            throw new IllegalArgumentException("For input string:" + in);
        }
        if (out.toString().equals("负零")) {
            out.deleteCharAt(0);
        }
        return out.toString();
    }

    public static String chineseToNumber(String in) {
        /**
         * 汉语数字转换阿拉伯数字
         * @param 汉语数字
         * @return 阿拉伯数字
         */
        Map<Character, Integer> nums = new HashMap<>();
        nums.put('〇', 0);
        nums.put('零', 0);
        nums.put('一', 1);
        nums.put('二', 2);
        nums.put('三', 3);
        nums.put('四', 4);
        nums.put('五', 5);
        nums.put('六', 6);
        nums.put('七', 7);
        nums.put('八', 8);
        nums.put('九', 9);
        StringBuilder out = new StringBuilder();// 定义返回值变量
        StringBuilder integer = new StringBuilder(in);// 定义整数部分，假设传入参数为整数
        try {// 将所有异常统一设置为“传入参数错误”异常
            if (in.indexOf('点') != -1) {// 判断是否存在小数
                out.append(in.substring(in.indexOf('点') + 1));// 截取小数部分字符串
                integer.delete(in.indexOf('点'), in.length());// 整数部分删除“点”及后面部分字符串
                /**
                 * 转换小数部分
                 */
                for (int i = out.length() - 1; i >= 0; i--) {
                    if (i == out.length() - 1 && out.charAt(i) == '零') {
                        out.deleteCharAt(i);// 删除后缀“0”
                    } else {
                        out.setCharAt(i, (char) (nums.get(out.charAt(i)) + '0'));
                    }
                }
                if (out.length() > 0) {
                    out.insert(0, '.');// 如果小数部分不为0则添加小数点
                }
            }
            out.insert(0, chToNum(integer, nums));// 调用整数部分转换方法转换整数部分
        } catch (Exception e) {
            throw new IllegalArgumentException("For input string:" + in);
        }
        if (out.toString().equals("-0")) {
            out.deleteCharAt(0);
        }
        return out.toString();
    }

    public static String figuresToWords(String in) {
        /**
         * 人民币小写转换大写
         * @param 人民币小写数字
         * @return 人民币大写数字
         */
        String[] ch = { "零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖" };
        StringBuilder out = new StringBuilder();// 定义返回值变量
        StringBuilder integer = new StringBuilder(in);// 定义整数部分，假设传入参数为整数
        if (in.endsWith("元")) {
            integer.deleteCharAt(integer.length() - 1);// 删除末尾的“元”字
        }
        try {// 将所有异常统一设置为“传入参数错误”异常
            if (integer.indexOf(".") != -1) {// 按“.”分割整数和小数部分
                out.append(integer.substring(integer.indexOf(".") + 1));// 截取小数部分字符串
                integer.delete(integer.indexOf("."), in.length());// 整数部分删除“.”及后面部分字符串
                /**
                 * 分类转换小数部分
                 */
                switch (out.length()) {
                    case 1:// 一位小数
                        if (out.charAt(0) != '0') {
                            out.append(ch[out.charAt(0) - '0'] + '角');
                        }
                        out.deleteCharAt(0);
                        break;
                    case 2:// 两位小数
                        if (out.charAt(1) != '0') {
                            out.append(ch[out.charAt(1) - '0'] + '分');
                        }
                        out.deleteCharAt(1);
                        if (out.charAt(0) == '0') {
                            if (out.length() > 1) {
                                out.insert(1, '零');
                            }
                        } else {
                            out.insert(1, ch[out.charAt(0) - '0'] + '角');
                        }
                        out.deleteCharAt(0);
                        break;
                    default:// 超过两位小数则抛出“传入参数错误”异常
                        throw new Exception();
                }
            }
            ch[0] = "";// 转换整数部分时“零”显示为空字符串
            String integerOut = numToCh(integer, ch);// 转换整数部分
            switch (integerOut) {// 分类合并整数与小数部分
                case "零":// 整数为0时
                    if (out.length() == 0) {// 小数为0时
                        out.append("零元整");
                    } else if (out.charAt(0) == '零') {// 小数为0角X分时
                        out.deleteCharAt(0);
                    }
                    break;
                case "负零":// 整数为-0时
                    if (out.length() == 0) {// 小数为0时
                        out.append("零元整");
                    } else {
                        if (out.charAt(0) == '零') {// 小数为0角X分时
                            out.deleteCharAt(0);
                        }
                        out.insert(0, '负');
                    }
                    break;
                default:// 整数不为0时
                    if (out.length() == 0) {// 小数为0时
                        out.append(integerOut).append("元整");
                    } else {// 小数不为0时
                        out.insert(0, '元').insert(0, integerOut);
                    }

                    break;
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("For input string:" + in);
        }
        return out.toString();
    }

    public static String wordsToFigures(String in) {
        /**
         * 人民币大写转换小写
         * @param 人民币大写数字
         * @return 人民币小写数字
         */
        Map<Character, Integer> nums = new HashMap<>();
        nums.put('零', 0);
        nums.put('壹', 1);
        nums.put('贰', 2);
        nums.put('叁', 3);
        nums.put('肆', 4);
        nums.put('伍', 5);
        nums.put('陆', 6);
        nums.put('柒', 7);
        nums.put('捌', 8);
        nums.put('玖', 9);
        StringBuilder out = new StringBuilder();// 定义返回值变量
        StringBuilder integer = new StringBuilder(in);// 定义整数部分，假设传入参数为整数
        int decimalNum = 0;// 小数部分数值
        if (in.endsWith("整") || in.endsWith("正")) {
            integer.deleteCharAt(integer.length() - 1);// 删除末尾的“整”字
        }
        try {// 将所有异常统一设置为“传入参数错误”异常
            String decimal = new String();// 定义小数部分字符串
            if (integer.indexOf("元") != -1) {// 按“元”分割整数和小数部分
                decimal = integer.substring(integer.indexOf("元") + 1);// 截取小数部分字符串
                integer.delete(integer.indexOf("元"), integer.length());// 整数部分删除“元”及后面部分字符串
            } else if (integer.indexOf("角") != -1 || integer.indexOf("分") != -1) {
                if (integer.charAt(0) == '负' || integer.charAt(0) == '正') {// 带负不带负判断
                    decimal = integer.substring(1, integer.length());
                    integer.delete(1, integer.length());
                } else {
                    decimal = integer.toString();
                    integer.delete(0, integer.length());
                }
            }
            /**
             * 分类转换小数部分
             */
            switch (decimal.length()) {
                case 0:// 整数类型不执行任何操作
                    break;
                case 2:// X角或X分类型
                    if (decimal.charAt(1) == '角') {
                        decimalNum = nums.get(decimal.charAt(0)) * 10;
                    } else if (decimal.charAt(1) == '分') {
                        decimalNum = nums.get(decimal.charAt(0));
                    } else {
                        throw new Exception();
                    }
                    break;
                case 3:// 零X分类型:
                    if (decimal.charAt(0) == '零') {
                        if (decimal.charAt(2) == '分') {
                            decimalNum = nums.get(decimal.charAt(1));
                        } else {
                            throw new Exception();
                        }
                    } else {
                        throw new Exception();
                    }
                    break;
                case 4:// X角X分类型
                    if (decimal.charAt(1) == '角' && decimal.charAt(3) == '分') {
                        decimalNum = nums.get(decimal.charAt(0)) * 10 + nums.get(decimal.charAt(2));
                    } else {
                        throw new Exception();
                    }
                    break;
                default:// 其余类型则抛出“输入参数错误”异常
                    throw new Exception();
            }
            out.append(chToNum(integer, nums));// 调用整数部分转换方法转换整数部分
            if (decimalNum > 0) {
                out.append('.').append(String.format("%02d", decimalNum));// 如果小数部分不为0则添加小数部分
            }
            out.append('元');
        } catch (Exception e) {
            throw new IllegalArgumentException("For input string:" + in);
        }
        if (out.toString().equals("-0元")) {
            out.deleteCharAt(0);
        }
        return out.toString();
    }

    private static String numToCh(StringBuilder in, String[] ch) throws Exception {
        /**
         * 私有方法：阿拉伯整数数字转换汉语数字
         * @param 阿拉伯整数数字，汉语数字1-9名称的数组
         * @return 汉语数字
         */
        StringBuilder out = new StringBuilder();// 定义返回值变量
        if (in.indexOf("-") == 0 || in.indexOf("+") == 0) {// 正负数判断
            // 如果有正负号则用递归方法先转换数字部分，再添加正负号
            if (in.indexOf("-", 1) == -1 && in.indexOf("+", 1) == -1) {
                char sign = in.charAt(0);
                out.append(numToCh(in.deleteCharAt(0), ch));
                if (sign == '-') {
                    out.insert(0, '负');
                }
            } else {
                throw new Exception();
            }
        } else {// 转换整数部分
            int n = 0;// 计算单位“亿”的个数
            while (in.length() > 0) {
                int index = in.length() > 8 ? in.length() - 8 : 0;
                int intNum = Integer.parseInt(in.substring(index, in.length()));
                if (intNum > 0) {
                    if (intNum % 10 == 0 && out.length() > 0) {
                        if (out.charAt(0) != '零') {
                            out.insert(0, '零');
                        }
                    }
                    for (int i = 0; i < n; i++) {
                        out.insert(0, '亿');
                    }
                    out.insert(0, numToCh(intNum, ch));
                } else {
                    if (out.length() > 0 && out.charAt(0) != '零') {
                        out.insert(0, '零');
                    }
                }
                n++;
                in.delete(index, in.length());
            }
        }
        if (out.length() > 1) {
            if (out.charAt(0) == '零') {
                out.deleteCharAt(0);
            }
        } else if (out.length() == 0) {
            out.append('零');
        }
        return out.toString();
    }

    private static String numToCh(int in, String[] ch) throws Exception {
        /**
         * 私有方法：亿以下阿拉伯整数数字转换汉语数字
         * @param 亿以下数值型阿拉伯整数数字，汉语数字1-9名称的数组
         * @return 汉语数字
         */
        StringBuilder out = new StringBuilder();
        if (in < 10000) {// 万以下数字转换
            if (!ch[1].equals("壹") && in < 20 && in >= 10) {
                out.append('十').append(ch[in % 10]);
            } else {
                char[] num = String.valueOf(in).toCharArray();
                String[] units = { "", "十", "百", "千" };
                if (ch[1].equals("壹")) {
                    units[1] = "拾";
                    units[2] = "佰";
                    units[3] = "仟";
                }
                for (int i = 0; i < num.length; i++) {
                    if (num[num.length - i - 1] == '0') {
                        if (!(out.length() == 0 || out.charAt(0) == '零')) {
                            out.insert(0, '零');
                        }
                    } else {
                        out.insert(0, units[i]);
                        out.insert(0, ch[(int) num[num.length - i - 1] - (int) '0']);
                    }
                }
            }
        } else {// 万以上数字转换
            out.append(numToCh(in % 10000, ch));
            if (out.length() > 0 && (in % 10000 < 1000 || in / 10000 % 10 == 0)) {
                out.insert(0, '零');
            }
            out.insert(0, '万');
            out.insert(0, numToCh(in / 10000, ch));
        }
        return out.toString();
    }

    private static String chToNum(StringBuilder in, Map<Character, Integer> nums) throws Exception {
        /**
         * 私有方法：汉语整数数字转换阿拉伯数字
         * @param 汉语整数数字，1-9汉语和阿拉伯数字名称对照表集合
         * @return 阿拉伯整数数字
         */
        StringBuilder out = new StringBuilder();
        if (in.indexOf("负") == 0 || in.indexOf("正") == 0) {// 正负数判断
            // 如果有正负号则用递归方法先转换数字部分，再添加正负号
            if (in.indexOf("负", 1) == -1 && in.indexOf("正", 1) == -1) {
                char sign = in.charAt(0);
                out.append(chToNum(in.deleteCharAt(0), nums));
                if (sign == '负') {
                    out.insert(0, '-');
                }
            } else {
                throw new Exception();
            }
        } else {// 转换数字部分
            for (int i = 0; i < in.length(); i++) {
                if (in.charAt(i) == '零' && i != in.length() - 1) {
                    in.deleteCharAt(i);// 去掉所有前缀“零”
                    i--;
                } else if ((in.charAt(i) == '十') && (i == 0 || !nums.containsKey(in.charAt(i - 1)))) {
                    in.insert(i, '一');// 将“十”改为“一十”
                    i++;
                } else if ((in.charAt(i) == '拾') && (i == 0 || !nums.containsKey(in.charAt(i - 1)))) {
                    in.insert(i, '壹');// 将“拾”改为“壹拾”
                    i++;
                }
            }
            while (in.length() > 0) {// 从右到左以“亿”为界分段转换
                int n = 0;// 统计字符串尾部“亿”的个数
                while (in.charAt(in.length() - 1) == '亿') {
                    n++;
                    in.deleteCharAt(in.length() - 1);
                }
                while (out.length() < n * 8) {// 按“亿”的个数补足位数
                    out.insert(0, '0');
                }
                int index = in.lastIndexOf("亿");
                out.insert(0, chToNum(in.substring(index + 1), nums));
                in.delete(index + 1, in.length());
            }
        }
        if (out.length() == 0) {
            out.append('0');// 转换数字为空则转换为“零”
        }
        return out.toString();
    }

    private static int chToNum(String in, Map<Character, Integer> num) throws Exception {
        /**
         * 私有方法：亿以下汉语整数数字转换阿拉伯数字
         * @param 亿以下汉语整数数字，1-9汉语和阿拉伯数字名称对照表集合
         * @return 数值型阿拉伯整数数字
         */
        if (in.indexOf("万") != -1) {// 万以上数字转换
            String left = in.substring(0, in.indexOf("万"));
            String right = in.substring(in.indexOf("万") + 1);
            if ((right.indexOf("万") == -1)) {
                return chToNum(left, num) * 10000 + chToNum(right, num);
            } else {
                throw new Exception();
            }
        } else {// 万以下数字转换
            Map<Character, Integer> units = new HashMap<>();
            units.put('十', 10);
            units.put('拾', 10);
            units.put('百', 100);
            units.put('佰', 100);
            units.put('千', 1000);
            units.put('仟', 1000);
            int out = 0;// 定义返回值变量
            int unit = 1;// 单位
            for (int i = in.length() - 1; i >= 0; i--) {
                if (num.containsKey(in.charAt(i))) {
                    out += num.get(in.charAt(i)) * unit;
                } else {
                    unit = units.get(in.charAt(i));
                }
            }
            return out;
        }
    }
}