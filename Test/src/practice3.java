import java.util.regex.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.IOException;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import java.util.stream.Stream;
import java.util.Scanner;

class method{
    public static void main(String[] args){

        String Subject[] = {"nlanguage","math","english"};
        int Grades[] = {72, 97, 80};

        for (int i = 0; i < Subject.length; i++){
            check(Subject[i], Grades[i]);
            System.out.println(judge(i));
        }

        test(6, 0);

        double d = plus(3.14, 7.4);
        int n = plus(1, 5);
        System.out.println("d=" + d + ",n=" + n);

        int sum1 = sum(2, 325, 512, 693);
        int sum2 = sum(6, 65);
        int sum3 = sum();
        System.out.println(sum1 + "," + sum2 + "," + sum3);

        disp("[", "]", 1, 2, 3, 4, 5, 6, 7);
        disp("<", ">", 1, 53, 35, 13);

    }

    //メソッドは関数と一緒
    public static void check(String subject, int grades){
        System.out.println(subject + "の試験結果は");
        if (grades > 80){
            System.out.println("合格です");
        }else{
            System.out.println("不合格です");
        }
    }

    private static String judge(int n){ 
        if (n % 2 == 0){
            return "偶数";
        }else{
            return "奇数";
        }
    }

    private static void test(int n1, int n2){
        if (n2 == 0){
            System.out.println("0で割ることはできません");
            return; //ここで処理終了
        }

        System.out.println(n1 + "/" + n2 + "=" + (n1 / n2));
        return;
    }

    //引数のデータ型や引数の数が同じでなければ異なるメソッドに同じメソッド名をつけることができる
    private static int plus(int n1, int n2){
        return n1 + n2;
    }
    private static double plus(double d1, double d2){
        return d1 + d2;
    }

    //変数の数を可変にする
    private static int sum(int... nums){
        int sum = 0;

        for (int i = 0; i < nums.length; i++){
            sum += nums[i];
        }

        return sum;
    }

    //固有引数と可変引数の組み合わせ
    private static void disp(String sb, String sa, int... num){
        for (int i = 0; i < num.length; i++){
            System.out.println(sb + num[i] + sa);
        }
    }
}

class mainMethod{ //左の実行ボタン→jsonでコマンドライン引数を設定
    public static void main(String[] args){
        System.out.println("コマンドライン引数は" + args[0] + "です");
    }
}

//try文でエラー処理
class error{
    public static void main(String[] args){
        int n[] = {16, 29, 36};

        try{
            System.out.println("開始します");

            for (int i = 0; i < 4; i++){
                System.out.println(n[i]);
            }
        }catch (ArrayIndexOutOfBoundsException en){
            System.out.println("配列の範囲を超えています");
        }
        
        System.out.println("終了しました");
    }
}

//正規表現
class re{
    public static void main(String[] args){

        String[] str = {"good", "goood", "better", "gand"};

        for (int i = 0; i < str.length; i++){
            System.out.println(try_catch(str[i]));
        }

        escape();

        System.out.println(match("profire.jpg", "jpg$"));
        System.out.println(match("Script", "S.*t"));
        System.out.println(match("Javacript", "S.*t"));
    }

    private static boolean try_catch(String n){
        Pattern p = Pattern.compile("g..d");
        Matcher m = p.matcher(n);

        return m.matches();
    }

    public static void escape(){
        String regex = Pattern.quote("A.B.C.D");
        Pattern p = Pattern.compile(regex);

        Matcher m1 = p.matcher("A.B.C.D");
        System.out.println(m1.matches());

        Matcher m2 = p.matcher("AABBCCDD");
        System.out.println(m2.matches());
    }

    //文字判定関数
    private static String match(String s_match, String s_regex){
        Pattern p = Pattern.compile(s_regex);
        Matcher m = p.matcher(s_match);

        if (m.find()){
            return "パターンにマッチします";
        }else{
            return "パターンにマッチしません";
        }
    }
}

//ファイルを管理する
class file{
    public static void main(String[] args){
        path();
    }

    private static void path(){

    Path p1 = Paths.get("C:\\code\\java\\file\\report.txt");
    Path p2 = Paths.get("C:", "code", "java", "file", "report.txt");
    Path p3 = Paths.get("C:/code/java/file/report.txt");
    Path p4 = Paths.get("C:/code/java/file/");
    Path p5 = Paths.get("C:/code/java/file");
    
    System.out.println(p1);
    System.out.println(p2);
    System.out.println(p3);
    System.out.println(p4);
    System.out.println(p5);
    }

}

//ファイルの作成
class criateFile{
    public static void main(String[] args){
        Path p = Paths.get("C:/Users/81907/OneDrive - 静岡理工科大学/個人用/Java_Programming/testfile.txt");

        try{
            Files.createFile(p);

        }catch (IOException e){
            System.out.println(e);
        }
    }
}

//ファイルの削除
class deleteFile{
    public static void main(String[] args){
        Path p1 = Paths.get("C:/Users/81907/OneDrive - 静岡理工科大学/個人用/Java_Programming/testfile.txt");
        Path p2 = Paths.get("C:/Users/81907/OneDrive - 静岡理工科大学/個人用/Java_Programming/testfile2.txt");

        try{
            Files.deleteIfExists(p1);
        }catch(IOException e){
            System.out.println(e);
        }

        try{
            Files.deleteIfExists(p2);
        }catch(IOException e){
            System.out.println(e);
        }
    }
}

//ファイルの存在確認
class existPath{
    public static void main(String[] args){
        Path p = Paths.get("C:/Users/81907/OneDrive - 静岡理工科大学/個人用/Java_Programming/testfile.txt");
        
        if (Files.exists(p)){
            System.out.println("ファイルまたはディレクトリは存在します");
        }else{
            System.out.println("ファイルまたはディレクトリは存在しません");
        }
    }
}

//ファイルのコピー
class copyPath{
    public static void main(String[] args){
        Path p1 = Paths.get("C:/Users/81907/OneDrive - 静岡理工科大学/個人用/Java_Programming/testfile.txt");     
        Path p2 = Paths.get("C:/Users/81907/OneDrive - 静岡理工科大学/個人用/Java_Programming/testfile2.txt");
        
        try{
            Files.copy(p1, p2, REPLACE_EXISTING);
        }catch (IOException e){
            System.out.println("ファイルまたはディレクトリが存在しません");
        }
    }
}

//ディレクトリに含まれるファイルやディレクトリの一覧を取得する
class confirmPath{
    public static void main(String[] args){
        Path dirpath = Paths.get("C:/Users/81907/OneDrive - 静岡理工科大学/個人用/Java_Programming");

        try (Stream<Path> stream = Files.list(dirpath)){
            stream.forEach(p -> System.out.println(p.toString()));
        }catch (IOException e){
            System.out.println(e);
        } 
    }
}

//ディレクトリ変換器
class replaceDirectory{
    public static void main(String[] args){
        System.out.println("ディレクトリを入力してください");

        Scanner scan = new Scanner(System.in);
        String target = scan.next();
        System.out.println(target);
        
        System.out.println(target.replace("\\", "/"));
        scan.close();
    }
}

class test2{
    public static void main(String[] args){
        System.out.println("キーボードから入力してください");

        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();

        System.out.println("入力された文字は：" + str);

        scanner.close();
    }
}

class re2{
    public static void main(String[] args){
        //. 自由一文字、[] うち一文字 ^ ノット - から まで
        String[] reStrings1 = {"ABC", "A..B", "A[DEF]B", "A[^DEF]B", "[3-8]"};
        
        for (int i = 0; i < reStrings1.length; i++){
            String regex = reStrings1[i];
            Pattern p = Pattern.compile(regex);

            Matcher m = p.matcher("AasBdkfAFB3BalfABC345678");

            if (m.find()){
                System.out.println(m.group() + "を含みます");
            }else{
                System.out.println("マッチしていません");
            }
        }
        
        System.out.println(repeat("-", 20));

        String[] reStrings2 = {"[0-9a-zA-Z]", "[A-C[D-F]]", "[A-F&&[D-F]]", "[A-H&&[^D-F]]"};
        
        for (int i = 0; i < reStrings2.length; i++){
            Pattern p = Pattern.compile(reStrings2[i]);
            Matcher m = p.matcher("unkonow4545");

            System.out.println(m.find());
        }
        
        System.out.println(repeat("-", 20));

        String[] reStrings3 = {"\\d", "\\D", "\\s", "\\S", "\\w", "\\W"};

        for (int i = 0; i < reStrings3.length; i++){
            Pattern p = Pattern.compile(reStrings3[i]);
            Matcher m = p.matcher("aisdhfaeiuh a;fehgaipua;s w@feoiiofh");

            System.out.println(m.find());
        }
    }

    //文字列繰り返し機
    public static String repeat(String str, int n){
        var sb = new StringBuilder();
        while (n-- > 0){
            sb.append(str);
        }
        return sb.toString();
    }
}