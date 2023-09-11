import java.util.Calendar;
import java.util.Scanner;
import java.util.InputMismatchException;

class math{
    public static void main(String[] args){
        int num = 30;

        //絶対値
        System.out.println("|-18| = " + Math.abs(-18));
        new line(num);

        //2数 の比較
        System.out.println("24と234とでは" + Math.max(24, 234) + "のほうが大きい");
        System.out.println("24と234とでは" + Math.min(24, 234) + "のほうが小さい");
        new line(num);

        //累乗(javaで**は使えない)
        System.out.println("-24 ** 233 =" + Math.pow(-24, 233));
        new line(num);
        
        //平方根と立方根(実数のみ)
        System.out.println("16 ** 1/2 =" + Math.sqrt(16));
        System.out.println("-16 ** 1/2 =" + Math.sqrt(-16));
        System.out.println("-64 ** 1/3" + Math.cbrt(-64));
        new line(num);

        //対数
        System.out.println("log e = " + Math.log(Math.E));
        System.out.println("log (10) 1000 = " + Math.log10(1000));
        System.out.println("log 0 + 1 = " + Math.log1p(0));
        new line(num);

        //切り上げ
        System.out.println(Math.ceil(-1.34));
        //切り捨て
        System.out.println(Math.floor(3.67));
        //四捨五入
        System.out.println(Math.round(-3.51));
        new line(num);

        //乱数
        for (int i = 0; i < 10; i++){
            //乱数の範囲は0-1
            System.out.println((int)Math.ceil(Math.random() * 10));
        }
        new line(num);

        //弧度法から度数法へ変換
        System.out.println((int)Math.ceil(Math.toDegrees(Math.PI / 6)));
        new line(num);
    }
}

//次回：カレンダークラス

class line{
    line(int num){
        String[] lines = new String[num];

        for (int i = 0; i < lines.length; i++){
            lines[i] = "-";
        }
        
        System.out.println(String.join("", lines));
    }
}

class test3{
    public static void main(String[] args){
        loop2.loop(10);
    }
}

class test33{
    public static void main(String[] args){
        int n = 10;
        int sum = Recursion.recursion(n);

        System.out.println(n + "+" + sum);
    }
}

//再帰
class Recursion{
    public static int recursion(int num){
        if (num == 0){
            return 0; //第0項
        }else if (num == 1){
            return 1; //第一項
        }else{
            return recursion(num -1) + recursion(num - 2); //ドミノ倒しみたいになってく、漸化式としてあらわす
        }
    }
}

//ループ
class loop2{
    public static void loop(int num){
        int term1 = 1;
        int term2 = 1;

        System.out.println("第1項は1");
        System.out.println("第2項は1");
        for (int i = 1; i <= (num - 2); i++){
            int s = term2;
            term2 = term1 + term2;
            term1 = s;
            System.out.println("第" + (i + 2) + "項は" + term2);
        }
        System.out.println("∴第" + num + "項は" + term2);
    }
}

class CALENDAR{
    public static void main(String[] args){
        Calendar[] arrCal = new Calendar[5];
        String[] dispCal = new String[5];
        Calendar calendar = Calendar.getInstance();

        calendar.set(2005, 11, 29);

        new line(30);

        for (int i = 0; i < 5; i++){
            calendar.add(Calendar.DAY_OF_MONTH, 1);
            arrCal[i] = Calendar.getInstance();

            System.out.println(date(calendar));
            dispCal[i] = date(calendar);
        }

        new line(30);

        for (int i = 0; i < 4; i++){
            int diff = arrCal[i].compareTo(arrCal[i + 1]);

            if (diff == 0){
                System.out.println(dispCal[i] + "=" + dispCal[i + 1]);
            }else if (diff > 0){
                System.out.println(dispCal[i] + ">" + dispCal[i + 1]);
            }else{
                System.out.println(dispCal[i] + "<" + dispCal[i + 1]);
            }
        }
    }

    private static String date(Calendar calendar){
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH)  + 1; //月は0スタート
        int day = calendar.get(Calendar.DATE);

        return (year + "/" + month + "/" + day);
    }
}

//stringbuilderクラス
class JSample3_1{
    public static void main(String[] args){
        StringBuilder sb = new StringBuilder();

        sb.append("サル");
        sb.append("ゴリラ");
        sb.append("チンパンジー");
        sb.append(2.71);

        System.out.println(sb.toString());
        new line(20);

        System.out.println("文字数" + sb.length() + ", 現在の容量" + sb.capacity());

        sb.insert(3, true);
        System.out.println(sb.toString());
        new line(20);

        System.out.println(sb.substring(3, 8));
        new line(20);

        sb.replace(2, 5, "8");
        System.out.println(sb.toString());
        new line(20);

        sb.delete(10, 15);
        System.out.println(sb.toString());
        new line(20);

        sb.reverse();
        System.out.println(sb.toString());
        new line(20);
    } 
}

class JSample1_1{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("年齢を入力してください");
        String old = scanner.next();

        //途中で空白を入れると処理が終了する
        System.out.println("年齢は" + old + "です");
        new line(20);
        
        //空白後は別文字列
        System.out.println("年齢と出身地を空白を挟んで入力してください");
        String old2 = scanner.next();
        String pref = scanner.next();

        System.out.println("年齢は" + old2 + "です");
        System.out.println("出身地は" + pref + "です");
        new line(20);

        //空白関係なく表示させる場合
        System.out.println("趣味を入力してください");

        String hobby = scanner.nextLine();
        System.out.println("趣味は" + hobby + "です");

        String[] tokens = hobby.split("\\s+");

        for (int i = 0; i < tokens.length; i++){
            System.out.println("[" + i + "]" + tokens[i]);
        }

        scanner.close();
    }
}

class JSample2_2{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        try{
            System.out.println("年齢を入力してください");
            int old = scanner.nextInt();

            System.out.println("年齢は" + old + "です");
        }catch (InputMismatchException e){
            System.out.println("数値を入力してください");
        }

        scanner.close();
    }
}