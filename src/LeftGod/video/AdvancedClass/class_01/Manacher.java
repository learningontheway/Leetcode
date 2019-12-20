package LeftGod.video.AdvancedClass.class_01;

public class Manacher {
    public static void main(String[] args) {
        String s="abcdaba";
        System.out.println(Manacher(s));
    }
    public static String Manacher(String s) {
        if (s == null || s.length() < 1) return "";
        //在所有间隙间加上"#"字符进行分割
        StringBuilder sb = new StringBuilder();
        sb.append("#");
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            sb.append("#");
        }
        //-----------------------------------
        int rightIndex = 0;
        int currentIndex = 0;
       //记录最长的回文长度
        int MaxLength = 0;
        //记录最长的回文长度时对应的回文中心
        int MaxIndex = 0;
        int len[] = new int[sb.length() ];
        //这里i可以从1开始，因为sb.chartAt(0)的长度没有意义
        for (int i = 1; i < sb.length(); i++) {
            //当i在回文右边界内时，且i关于对称轴的对称点对应的回文包含或者超出回文右边界的对称点位置时
            //            限制len[i]的是rightIndex - i和len[2 * currentIndex - i]这两者的较小值，在coding时让其继续执行会自动停止
            //当i在回文右边界外以及i关于对称轴的对称点的回文正好在对应的左边界上时，暴力扩
            if (i<rightIndex) {
                //这里使用rightIndex - i+1和rightIndex - i结果竟然是一样的
                len[i] = Math.min(rightIndex - i, len[2 * currentIndex - i]);
            } else {
                len[i] = 1;
            }
            //一个一个匹配
            //此时要么是正好在右边界对称点上，要么是i > rightIndex，暴力扩，如果在右边界对称点外或者包含在对称点内，则无法进入这段代码
            while(i - len[i] >= 0 && i + len[i] < sb.length() && sb.charAt(i - len[i]) == sb.charAt(i + len[i])) {
                len[i]++;
            }
            //当 len[i] + i > rightIndex,我们需要更新centerIndex和rightIndex
            if(len[i] + i > rightIndex) {
                rightIndex = len[i] + i;
                currentIndex = i;
            }
            if(len[i] > MaxLength) {
                MaxLength = len[i];
                MaxIndex = i;
            }
        }
        //截取字符串
        //为什么MaxIndex - MaxLength + 1,因为len[i] - 1才是原来的回文字符串长度，而answer记录的是len中最大值
        return sb.substring(MaxIndex - MaxLength + 1, MaxIndex + MaxLength).replace("#", "");
    }
}
