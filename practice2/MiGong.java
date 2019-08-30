package com.data;

public class MiGong {
    public static void main(String[] args){
        Map();

    }

    /**
     * @param map 表示地图
     * @param i  从哪个为止 触发
     * @param j
     * @return map[6][5] 位置说明通路 找到
     * 约定 map[i][j] 是0 改点没有走过，是1表示墙，2表示通路可以走，是3 改点已经走过，但是走不通
     * 策略 ：下 -》右-》上-》 左    该点走不通就回溯
     */
    public static boolean setWay(int[][] map,int i,int j){
        if(map[6][5]==2){
            //通路 已经找到
            return true;
        }else{
            if(map[i][j]==0){ //当前点没有走过
                map[i][j]=2; // 假定该点可以走通
                if(setWay(map,i+1,j))  //下
                    return true;
                else if(setWay(map,i,j+1)) //右
                    return true;
                else if(setWay(map,i-1,j)) //上
                    return true;
                else if (setWay(map,i,j-1)) //左
                    return true;
                else{
                    map[i][j]=3;  //死路
                    return false;
                }
            }else{
                // map可能是  1,2,3
                return false;
            }
        }
    }

    public static void Map(){
        int[][] map=new int[8][7];
        //墙 都设置为1
        for (int i=0;i<7;i++){
            map[0][i]=1;
            map[7][i]=1;
        }
        for (int i=0;i<8;i++){
            map[i][0]=1;
            map[i][6]=1;
        }
        //设置 挡板
        map[3][1]=1;
        map[3][2]=1;
       setWay(map,1,1);
        for(int i=0;i<8;i++){
            for(int j=0;j<7;j++){
                System.out.printf("%d\t",map[i][j]);
            }
            System.out.println();
        }
    }
}
