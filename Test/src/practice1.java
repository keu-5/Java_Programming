import java.time.LocalDate; //java.timeパッケージに含まれるLocalDateクラス。全て欲しい場合は*にする
import java.util.Random;


// クラス →オブジェクト（3dゲームのイメージ）
// メソッド→ 処理 （関数）
// フィールド→ 情報、データ （変数定義）
// リテラル→ 変数

// 一行コメントアウト
/*
 * 複数行
 * コメントアウト
*/

public class practice1 {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}

class Hello{
    public static void main(String[] args){
        System.out.println("Hello");
    }
}

//ここから練習内容

class basic{
    public static void main(String[] args){
        System.out.println("study java"); 
        inp();
    }
    /*
    クラス内には必ず1つ以上mainメソッドが必要（cでいうmain関数と一緒）
    コンパイルエラーにはならないが実行エラーになる
    mainメソッドの作り方:
    public static void main(String[] args){}
    */

    // 予約語→ 特定の用途で用いられる単語。変数名やクラス名などとして使うことはできない

    //Systemはjava.lngパッケージで用意されたクラスの一つ
    //outはSystemクラスにあるフィールドの一つ、出力時に使用
    //println→メソッド

    public static void inp(){
        LocalDate Id = LocalDate.now();
        System.out.println(Id);
    }
    //他でもメソッドが使えるようにpublic static をつける
}

class enc{
    public static void main(String[] args){
        System.out.println(System.getProperty("file.encoding"));
    } //getPropertyメソッドでエンコーディングを確認できる
}

class lit{
    //リテラル→型
    public static void main(String[] args){
        let();
        st();
        in();
    }

    public static void let(){
        System.out.println('a');
        System.out.println(0x0061);
        System.out.println('\u0061');        
    }

    public static void st(){
        System.out.println("Hello World");
        System.out.println("こんにちは");
    }
    //数字がintの範囲外→数字の最後にLをつけてlongにする
    //このときのLやD,Fはサフィックスと呼ばれる
    public static void in(){
        System.out.println(2200000000L);

        //代入時にエラー出た場合これをしてみると良い
        float num;
        num = 7.8F;
        System.out.println(num);
    }
    //1,234,789 のように桁区切りしたいときかわりに_をつかう
}

class va{
    public static void main(String[] args){
        data();
        v();
        con();
        cha();
        lap();
    }
    
    public static void data(){

        //1文字目に数字は使用できない
        //記号は_と$のみ使用できる

        int n = 100;
        long l = 12345678910L;
        double d = 3.14;
        float f = 3.14F;
        char c = '花';
        boolean b = true;

        System.out.println("n=" + n);
        System.out.println("l=" + l);
        System.out.println("d=" + d);
        System.out.println("f=" + f);
        System.out.println("c=" + c);
        System.out.println("b=" + b);

        /*
         * 名付けのすすめ
         * for文などで使われる整数の変数はi,jなど
         * 定数はすべて大文字
         * 複数の文字列は_でつなげる
         * クラス名、インターフェース名は1文字目を大文字に
         * メソッドは基本小文字。複数の文字列はそれぞれ1文字目を大文字に
        */
    }
    
    public static void v(){
        //varを使って楽に変数宣言(型推論)
        var old = 24;
        var name = "Yamada";
        
        System.out.println("年齢:" + old);
        System.out.println("名前:" + name);
    }

    public static void con(){
        final float TAX = 0.1F;

        float price = 800 * (1 + TAX);
        System.out.println("料金は" + price + "です。");
    }

    public static void cha(){

        /*
        演算時の型変換のルール
        1. double型を含む場合double型均一にする
        2. float型を含む場合float型均一にする
        3. long型を含む場合long型均一にする
        4. 1から3に該当しない場合すべてint型にする

        4の場合エラーが起こる場合があるためキャスト演算子を使う
        */

        short s1 = 14;
        short s2 = 8;
        short s3 = (short)(s1 + s2);
        System.out.println(s3);
    }

    //ラッパークラスの利用(よくわからない)
    public static void lap(){
        Integer i = Integer.valueOf(10);
        int val = i.intValue();
        System.out.println("i =" + val);
    }
}

class cal{

    public static void main(String[] args){
        lo();
        lil();
        con();
        pls();
    };

    public static void lo(){
        //char型を2進数で考える

        int i = 85;
        int j = 15;
        String hexI = Integer.toBinaryString(i);
        String hexJ = Integer.toBinaryString(j);
        String hexIJ = Integer.toBinaryString(i & j);

        //論理積&(AND): 両方のビットがともに1の場合のみその位を1にする
        System.out.println("85 & 15 =" + (i & j));
        System.out.println(hexI + "&" + hexJ + "=" + hexIJ);

        //論理和|(OR): 少なくともどちらか一つのビットが1の場合その位を1にする
        System.out.println("85 | 15 =" + (i | j));
        System.out.println(hexI + "|" + hexJ + "=" + hexIJ);

        //排他的論理和^(XOR): どちらかのビット一つだけ1の場合その位を1にする
        System.out.println("85 ^ 15 =" + (i ^ j));
        System.out.println(hexI + "^" + hexJ + "=" + hexIJ);

        //反転~(NOT): 各ビットの値を反転させる
        System.out.println("~85 =" + ~i);

        String hexI2 = Integer.toBinaryString(~i);
        System.out.println("~" + hexI + "=" + hexI2);

        //シフト演算子 (桁をずらす) 右辺はずらす回数。2進数だから二倍ずつ増減する
        //<< >>: 左右へnビットシフト
        System.out.println(j << 3);
        System.out.println(-j >> 2);
        //>>>: 右シフト(符号なし)
        System.out.println(-j >>> 2);
    }
    
    public static void lil(){

        //配列は値が同じでもtrueにならない
        int [] a = {85, 78, 92};
        int [] b = {85, 78, 92};
        System.out.println(a == b);
        a = b;
        System.out.println(a == b);
    }

    public static void con(){

        //条件演算子 ? を使うことで単純なif文を作ることができる
        int score = 70;
        System.out.println("Score" + score + ":");
        System.out.println(score > 70 ? "OK" : "NG");

        score = 84;
        System.out.println("Score" + score + ":");
        System.out.println(score > 70? "OK" : "NG");
    }

    public static void pls(){

        //+演算子以外での文章の足し算
        StringBuilder sb = new StringBuilder();

        sb.append("XT");
        sb.append(3140);
        sb.append("-Y2");

        System.out.println(sb.toString());
    }
}

class lu{
    public static void main(String[] args){
        fo();
        whi();
        dow();
        exf();
        wboi();
        con();
        cono();
    }

    public static void fo(){
        int sum = 0;

        for (int i = 1; i <= 5; i++){
            System.out.println(i);
            sum += i;
        }
        
        //for内で宣言したiは外で使えない、中で宣言したiと外で宣言したiは別物
        System.out.println("合計=" + sum);

        //初期化式はfor文外に出せる、;を使って省略できる
        int i = 0;
        for (; i < 5; i++){
            System.out.println("i=" + i);
        }

        //条件式も省略できるがbreak文を作って無限ループを防いだほうが良い
        sum = 0;

        for (i = 1; ; i++){
            sum += i;
            if (sum > 5){
                break;
            }
        }
        System.out.println("合計=" + sum);

        //変化式も省略できるが途中で値を変化させて無限ループを防いだほうがいい
        i = 1;
        for (; i < 10;){
            System.out.println(i);
            i++;
        }

        System.out.println(i);

        //すべて省略する場合
        i = 1; //i定義

        for (;;){
            System.out.println(i);
            i *= 3; //変化式
            if (i > 100){
                break; // 終了
            }
        }
        System.out.println(i);

        //条件式以外なら複数の変数を用いても良い
        int j;
        double d; //違う型で行う場合はfor文外で変数定義
        for (j = 1, d = 2.4; j <= 5; j++, d -= 0.1){
            System.out.println("j=" + j + ", d=" + d);
        }

        //for文の中にfor文を入れる
        for (i = 1; i <3; i++){
            for (j = 1; j < 3; j++){
                for (int k = 1; k <3; k++){
                    System.out.println("i=" + i + ", j=" + j + ", k=" + k);
                }
            }
        }
    }
    
    //while文
    public static void whi(){
        int num = 1;

        while (num < 100){
            System.out.println("num = " + num);
            num *= 2;
        }

        while (true){
            System.out.println(num);
            num *= 2;
            if (num > 1000){
                break;
            }
        }
    }

    //do-while文
    public static void dow(){
        int num;
        Random rand = new Random();
        System.out.println("６が出たら終わりです");

        do{
            num = rand.nextInt(6) + 1;
            System.out.println("no = " + num);
        }while (num != 6);

        //break文
        do{
            System.out.println("num = " + num);
            num -= 2;

            if (num < 0){
                break;
            }
        }while (true);
    }

    //拡張for文 (配列をfor文に適用)
    public static void exf(){
        String pref[] = {"北海道", "東京都", "神奈川県"};

        for (String nam: pref){
            System.out.println(nam);
        }
    }

    //while と break と outer と inner
    public static void wboi(){

        Outer:
        for (int i = 1; i < 5; i++){

            for (int j = 1; j < 5; j++){
                System.out.println("i * j =" + i * j);

                if (i * j > 10){
                    break Outer;
                }
            }

            System.out.println("next");
        }

        System.out.println("end");
    }

    //continue文
    public static void con(){
        for (int i = 1; i < 5; i++){
            if (i % 3 == 0){
                continue;
            }

            System.out.println("i = " + i);
        }

        System.out.println("End");
    }
    
    //ラベル付きcontinue文
    public static void cono(){
        Outer:
        for (int i = 1; i < 6; i++){

            for (int j = 1; j < 6; j++){
                if (i * j % 4 == 0){
                    continue Outer;
                }

                System.out.println(i + "*" + j + "=" + i * j);
            }

            System.out.println("next");
        }

        System.out.println("end");
    }
}

class i{
    public static void main(String[] args){
        ifb();
        ife();
        swd();
        swm();
    }

    public static void ifb(){
        for (int i = 1; i <= 10; i++){
            System.out.println(i + "は");

            if (i % 2 == 0){
                System.out.println("偶数です");
            }else{
                System.out.println("奇数です");
            }
        }
    }

    public static void ife(){
        int[] point = {75, 94, 68};
        String[] name = {"鈴木", "本田", "遠藤"};

        for (int i = 0; i < 3; i++){
            System.out.println(name[i] + "さんは");

            if (point[i] > 90){
                System.out.println("判定Aです");
            }else if (point[i] > 70){
                System.out.println("判定Bです");
            }else{
                System.out.println("判定Cです");
            }
        }
    }

    public static void sw(){
        int[] classcode = {1, 3, 2};
        String[] name = {"鈴木", "本田", "遠藤"};

        for (int i = 0; i < 3; i++){
            System.out.println(name[i] + "さんは");

            switch(classcode[i]){
                case 1:
                    System.out.println("Aクラスです");
                    break;
                case 2:
                    System.out.println("Bクラスです");
                case 3:
                    System.out.println("Cクラスです");
            }
        }
    }
    
    //default
    public static void swd(){
        int num = 2;
        switch(num){
            case 5:
                System.out.println("一等賞");
                break;
            case 2:
                System.out.println("二等賞");
                break;
            default:
                System.out.println("残念賞");
        }
    }

    //複数のラベルに対して同じ処理をする
    public static void swm(){
        int num = 2;
        switch(num){
            case 1:
            case 3:
            case 5:
                System.out.println("大当たり");
                break;
            case 2:
            case 4:
                System.out.println("残念賞");
        }
    }
}

class test{
    public static void main(String[] args){
        System.out.println(exp(1));   
    }

    public static double exp(double x){
        double e = 1;
        double E = 1;
        for (int i = 0; i <= 10; i++){
            E *= x/(i + 1);
            e += E;
        } 
        return e;       
    }

}

