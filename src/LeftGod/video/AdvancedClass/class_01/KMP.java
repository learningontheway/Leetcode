package LeftGod.video.AdvancedClass.class_01;

public class KMP {
    public static void main(String[] args){
        System.out.println(KMP("abcdefg","abc"));
    }
    //s代表主字符串，m代表子串
    public static int KMP(String s, String m){
        if(s==null||m==null||s.length()<m.length()){
            return -1;
        }
        if(m.length()<1){
            return 0;
        }
        int i=0;
        int j=0;
        int next[]=getNext(m);
        while (i<s.length()&&j<m.length()){
            //指向s的i位置和指向m的j位置字符相等，i,j同时向后移动匹配
            if(s.charAt(i)==m.charAt(j)){
                i++;
                j++;
            }
            else{
                //m跳到开头了，仍然和s配不上，只能让i指向下一个字符继续匹配
                if (next[j]==-1) i++;
                //m还可以向前跳，即从next数组中拿出向前跳的位置，继续跳下去
                else j=next[j];
            }

        }
        return j==m.length()?i-j:-1;

    }
    public static int[] getNext(String str){
        if(str.length()==1) return new int[]{-1};
        int next[]=new int[str.length()];
        next[0]=-1;
        next[1]=0;
        int i=2;
        //跳到的位置
        int jumpIndex=0;
        while (i<next.length){
            //跳到的位置和当前位置的前一个位置的字符相等，那么当前位置的next数组值为跳到的位置索引加一
            if(str.charAt(i-1)==str.charAt(jumpIndex))
                next[i++]=++jumpIndex;
            else {
                //还可以往前挑，继续跳
                if(jumpIndex>0){
                    jumpIndex=next[jumpIndex];
                }
                //不能继续跳了，当前next数组值为0
                else next[i++]=0;
            }
        }
        return next;
    }

}
