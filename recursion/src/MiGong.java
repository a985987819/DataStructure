/**
 * @author laoduan
 * @create 2020-04-26-10:15
 */
public class MiGong {
    public static void main(String[] args) {
        //创建一个二维数组模拟迷宫
        int [][] map= new int[8][7];

        //初始化滴入
        for(int i=0;i<7;i++){
            map[0][i]=1;
            map[7][i]=1;
        }
        for (int i=1;i<8;i++){
            map[i][0]=1;
            map[i][6]=1;
        }
        map[3][1]=1;
        map[3][2]=1;

        //输出地图
        System.out.println("当前的地图为：");
        for (int i=0;i<8;i++){
            for(int j=0;j<7;j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }

        //使用递归回溯给小球找路
        setWay(map,2,1);
        //输出新的地图
        System.out.println("小球走过以后，当前的地图为：");
        for (int i=0;i<8;i++){
            for(int j=0;j<7;j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }

    /**
     *
     * @param map  地图
     * @param i 从哪开始找
     * @param j
     * @return  找到通路返回true，否则false
     */

    public static boolean setWay(int[][]map,int i,int j ){


        if (map[6][5]==2){
            return true;
        }else {
            if(map[i][j]==0){
                map[i][j]=2;
                if(setWay(map,i+1,j)){//向下走
                    return true;
                }else if(setWay(map,i,j+1)){//向右走
                    return true;
                }else if(setWay(map,i-1,j)){//向上走
                    return true;
                }else if(setWay(map,i,j-1)){//向左走
                    return true;
                }else{
                    map[i][j]=3;
                    return false;
                }
            }else{
                //如果map[i][j]!=0,可能是1,2,3
                return false;
            }
        }
    }

    //修改找路策略
    public static boolean setWay2(int[][]map,int i,int j ){


        if (map[6][5]==2){
            return true;
        }else {
            if(map[i][j]==0){
                map[i][j]=2;
                if(setWay2(map,i-1,j)){//向上走
                    return true;
                }else if(setWay2(map,i,j+1)){//向右走
                    return true;
                }else if(setWay2(map,i+1,j)){//向上走
                    return true;
                }else if(setWay2(map,i,j-1)){//向左走
                    return true;
                }else{
                    map[i][j]=3;
                    return false;
                }
            }else{
                //如果map[i][j]!=0,可能是1,2,3
                return false;
            }
        }
    }

}
