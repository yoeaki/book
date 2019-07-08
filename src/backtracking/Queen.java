package backtracking;

import org.omg.CORBA.PUBLIC_MEMBER;

public class Queen {

    /**
     * 皇后问题
     *      1.定义一个N x N的方格
     *      2.规则（不能同一列、同一行、同斜线 ）
     * */

    /**
     * 1. num：累计方案
     * 2. MAXQUEEN：定义棋盘数
     * 3. cols = new int[MAXQUEEN];：表示8列存放的位置
     *
     * */

    public static final int num = 0;
    public static int MAXQUEEN = 8;
    public static int[] cols = new int[MAXQUEEN];

    public void getCount(int n){

        //记录每个放个是否可以放皇后
        boolean [] rows = new boolean[MAXQUEEN];

        for (int m = 0; m < n; m++) {
            rows[cols[m]] = true;
            //斜对角
            int d = n - m;
            //正斜方向

        }
    }
}
