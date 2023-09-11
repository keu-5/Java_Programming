import java.util.Arrays;

class arr{
    public static void main(String[] args) {
        arr1();
        arrs();
        are();
        length();
        fill();
        multi();
        remulti();
        LenMulti();
        CopyArray1();
        CopyArray2();
        CopyArray3();
        CopyArray4();
        CopyArray5();
        ConbineArray();
        ConArray();
        arange();
        sort();
        ArrayOutput();
    }
    
    //配列の作り方
    public static void arr1(){
        int[] result = new int[3];  //int[]の[]は郡推論より不要
        result[0] = 75;
        result[1] = 88;
        result[2] = 82;

        for (int i = 0; i < 3; i++) {
            System.out.println(result[i]);
        }        
    }
    
    //配列の代入
    public static void arrs(){
        int[] data = new int[3];

        data[0] = 10;
        data[1] = 16;
        data[2] = 9;

        int[] other = data;

        System.out.println(data[1]);
        System.out.println(other[1]);
    }

    //配列の要素の初期化と規定値
    public static void are(){

        //初期化による配列の簡略化
        int[] num = {1, 2, 3};

        //郡推論
        var num1 = new int[]{4, 10,7};

        for (int i: num1){
            System.out.println(i);
        }

        for (int j: num){
            System.out.println(j);
        }
    }

    //配列の長さlength
    public static void length(){
        double[] num = new double[3];
        
        num[0] = 5.24;
        num[1] = 3.14;
        num[2] = 12.235;
        
        System.out.println(num.length);

        for (int i = 0; i < num.length; i++){
            System.out.println("num[" + i + "]" + num[i]);
        }
    }

    //配列のfill
    public static void fill(){
        int[] a = new int[3];
        Arrays.fill(a, 10);

        System.out.println(a[0]);
        System.out.println(a[1]);
        System.out.println(a[2]);
    }

    //多次元配列
    public static void multi(){
        int[][] num = new int[2][];

        num[0] = new int[3];
        num[0][0] = 10;
        num[0][1] = 20;
        num[0][2] = 30;

        num[1] = new int[3];
        num[1][0] = 40;
        num[1][1] = 50;
        num[1][2] = 60;

        for (int i = 0; i < 2; i++){
            for (int j = 0; j < 3; j++){
                System.out.println(num[i][j]);
            }
        }
    }

    //多次元配列の初期化
    public static void remulti(){
        int[][] num = {{87, 54, 67}, {76, 92, 48}};

        for (int i = 0; i < 2; i++){
            for (int j = 0; j < 3; j++){
                System.out.println(num[i][j]);
            }
        }
    }

    //多次元配列の長さ
    public static void LenMulti(){
        int[][] num = {{87, 54}, {76, 85, 6, 34, 32}};

        for (int i = 0; i < num.length; i++){
            for (int j = 0; j < num[i].length; j++){
                System.out.println(num[i][j]);
            }
        }
    }

    //配列のコピー
    //配列ごと代入
    public static void CopyArray1(){
        int[] src1 = {12, 24, 18};
        int[] dst1 = src1;

        for (int i = 0; i < dst1.length; i++){
            System.out.println(src1[i]);
            System.out.println(dst1[i]);
        }
    }
    //要素ごとにコピー
    public static void CopyArray2(){
        int[] src2 = {2, 4, 8};
        int[] dst2 = new int[3];

        for (int i = 0; i < dst2.length; i++){  
            dst2[i] = src2[i];
        }
        
        for (int i = 0; i < dst2.length; i++){
            System.out.println(src2[i]);
            System.out.println(dst2[i]);
        }
    }
    //Arrays.copyOfメソッドを使ってコピー
    public static void CopyArray3(){
        int[] src3 = {5, 25, 125};
        int[] dst3 = Arrays.copyOf(src3, 3);

        for (int i = 0; i < dst3.length; i++){
            System.out.println(src3[i]);
            System.out.println(dst3[i]);
        }
    }
    //別クラスからの参照を用いた場合
    public static void CopyArray4(){
        MyTest[] src4 = {new MyTest(28), new MyTest(32)};
        MyTest[] dst4 = new MyTest[2];

        for (int i = 0; i < dst4.length; i++){
            dst4[i] = new MyTest(src4[i].num);
        }
        
        for (int i = 0; i < dst4.length; i++){
            System.out.println(src4[i].num);
            System.out.println(dst4[i].num);
        }
    }

    //一部をコピー
    public static void CopyArray5(){
        int[] src5 = {12, 24, 18, 35, 21};
        int[] dst5 = Arrays.copyOfRange(src5, 1, 4);
        
        for (int i = 0; i < src5.length; i++){
            System.out.println(src5[i]);
        }
        for (int i = 0; i < dst5.length; i++){
            System.out.println(dst5[i]);
        }
    }

    //2つの配列を連結して新しい配列を作成する
    public static void ConbineArray(){
        int[] src6 = {28, 14, 35, 19};
        int[] src7 = {17, 40, 23};
        int[] dst6 = new int[src6.length + src7.length];

        System.arraycopy(src6, 0, dst6, 0, src6.length); 
        //元の配列をゼロから、ペースト先の配列をゼロから、入れたい配列
        System.arraycopy(src7, 0, dst6, src6.length, src7.length);

        System.out.println(Arrays.toString(src6)); //配列そのまま出力できる
        System.out.println(Arrays.toString(src7));
        System.out.println(Arrays.toString(dst6));
    }

    //Arrays.equalsメソッドを使って配列比較
    public static void ConArray(){
        int[]a = {85, 78, 92};
        int[]b = {85, 78, 92};

        System.out.println(a == b);
        System.out.println(Arrays.equals(a, b));

        /**
        多重配列を比較する場合、要素ではなく中身の配列を比較することになるので
        equalsメソッドではなくdeepEqualsメソッドで比較する
        **/
        int[][] c = {{85, 78},{92, 58}}; 
        int[][] d = {{85, 78},{92, 58}};

        System.out.println(Arrays.equals(c, d));
        System.out.println(Arrays.deepEquals(c, d));
    }

    //配列の並び替え
    //逆順にする方法（手動のみ）
    public static void arange(){
        int[] src = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51};
        System.out.println(Arrays.toString(src));

        for (int i = 0, j = src.length - 1; i < j; i++ , j-- ){
            int temp = src[i]; //値をtempに保存
            src[i] = src[j];  // i に j を代入
            src[j] = temp; // j に保存した i を代入
        }
        System.out.println(Arrays.toString(src));
    }

    public static void sort(){
        int[] src = {12, 24, 18, 35, 21};
        System.out.println(Arrays.toString(src));

        Arrays.sort(src);
        System.out.println(Arrays.toString(src));
    }

    public static void ArrayOutput(){
        int[][] src = {{25, 18},{12, 37}};

        System.out.println(src);
        System.out.println(Arrays.toString(src));
        System.out.println(Arrays.deepToString(src));
    }
}

//参照元
class MyTest{
    public int num;

    public MyTest(int n){
        num = n;
    }
}

//次回：文字列（stringクラス）
class string{

    public static void main(String[] args){
        assain();
        guess();
        con();
    }

    public static void assain(){ // static mainにぶちこめる
        //文字列の代入は配列の代入と同じ
        String msg1 = "Hello";
        char[] c = {'B','y','e'};

        String msg2 = new String(c);
        String msg3 = new String(msg1);

        System.out.println(msg1);
        System.out.println(msg2);
        System.out.println(msg3);
    }

    public static void guess(){
        String msg1 = "Hello";
        String msg2 = msg1;

        System.out.println(msg1);
        System.out.println(msg2);

        System.out.println("----");

        msg2 = "Bye!";

        System.out.println(msg1);
        System.out.println(msg2);
    }
    
    //次回：数値を文字列に変換する
    public static void con(){
        int sec = 12;
        String si = Integer.valueOf(sec).toString();
        System.out.println(si);
    }
    //他にも色々ある
}