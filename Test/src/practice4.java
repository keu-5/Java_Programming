import java.util.regex.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.IOException;
import java.util.stream.Stream;
import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.PrintWriter;

class re4{
    public static void main(String[] args){
        findReset();
        matchString("ABCₐSFa;ioegha;jaoieghr;e aoe;igar",null, "^ABC", "gar$", "\\baoe");

        System.out.println(re2.repeat("-", 20));

        matchString("apple", "(?i)", "apple");
        matchString("Apple", "(?i)", "apple");
        matchString("APPLE", "(?i)", "apple");

        System.out.println(re2.repeat("-", 20));

        matchString("apple", null, "apple");
        matchString("Apple", null, "apple");
        matchString("APPLE", null, "apple");
        
        System.out.println(re2.repeat("-", 20));
    }

    private static void findReset(){
        Pattern p = Pattern.compile("AA|BB|CC");
        Matcher m = p.matcher("AA BB CC");

        for (int i = 0; i < 2; i++){
            if (m.find()){
                System.out.println(m.group());
            }
        }
        m.reset();

        if (m.find()){
            System.out.println(m.group());
        }
    }
    
    //マッチ検索機
    public static void matchString(String match, String comp, String... regex ){
        for (int i = 0; i < regex.length; i++){
            if (comp != null){
                regex[i] = comp + regex[i];
            }

            Pattern p = Pattern.compile(regex[i]);
            Matcher m = p.matcher(match);
            
            if (m.find()){
                System.out.println(m.group() + "にマッチしました");
            }else{
                System.out.println("マッチしませんでした");
            }
        }
    }
}

//絶対パス読み取り機
class apath{
    public static void main(String[] args){
        getDirectory("va.class");
    }
    
    private static void getDirectory(String path){
        Path p = Paths.get(path);
        Path q1 = p.toAbsolutePath();

        System.out.println(q1);

        System.out.println(re2.repeat("-", 10));

        System.out.println(q1.getParent());

        System.out.println(re2.repeat("-", 10));

        System.out.println(q1.getRoot());

        System.out.println(re2.repeat("-", 10));

        System.out.println(q1.getNameCount());

    }
}

//カレントディレクトリ取得
class CurrentDirectory{
    public static void main(String[] args){
        Path p1 = Paths.get("");
        Path p2 = p1.toAbsolutePath();

        System.out.println(p2.toString());

        //ファイルサイズを取得
        try (Stream<Path> stream = Files.list(p2)){
            stream.forEach(p -> {
                try{
                    System.out.println(p2.getFileName() + ":");
                    System.out.println(Files.size(p2) + "byte");
                    
                }catch(IOException e){
                    System.out.println(e);
                }
            });
        }catch(IOException e){
            System.out.println(e);
        }
    }
}
//テキストファイルを読む
class text{
    public static void main(String[] args){
        reading();
    }


    private static void reading(){
        File file = new File("C:\\private\\Java_Programming\\画像認識アルゴリズム研究所 四宮.txt");
        Path p1 = Paths.get(file.toString());
        Path p2 = p1.toAbsolutePath();

        try (Stream<Path> stream = Files.list(p2)){
            stream.forEach(p -> {

                try{
                    if (check.checkFile(file)){
                        FileReader filereader = new FileReader(file);

                        int ch;
                        while ((ch = filereader.read()) != -1){
                            System.out.println((char)ch);
                        }

                        filereader.close(); 

                        System.out.println(re2.repeat("-", 20));

                        BufferedReader br = new BufferedReader(filereader);

                        String str;
                        while ((str = br.readLine()) != null){
                            System.out.println(str);
                        }

                        br.close();
                    }else{
                        System.out.println("ファイルが見つからないか開けません");
                    }

                }catch(FileNotFoundException e){
                    System.out.println(e);
                    
                }catch(IOException e){
                    System.out.println(e); //この2つをしないと赤エラー
                }                

            });
        }catch(IOException e){
            System.out.println(e);
        }
    }
}
//ファイルに記述
class writer{
    public static void main(String[] args){
        try{
            String filename = "C:\\private\\Java_Programming\\memo.txt";
            
            Path p = Paths.get(filename);

            if (!(Files.exists(p))){
                criateFiles.create(filename);

                File file = new File(filename);
                FileWriter filewriter = new FileWriter(file);  
                
                String message = 
                """
                    welcome to ようこそじゃぱりぱーく
                    今日もどったんばったん大騒ぎ
                    うーがお！
                    高らかに笑い笑えばフレンズ
                    喧嘩してすっちゃかめっちゃかしてもなかよし
                    わっはっは
                """;

                filewriter.write(message);

                filewriter.close();
            }else{
                System.out.println("ファイルまたはディレクトリがすでに存在しています。");
                System.out.println("元のデータを削除しますか? tまたはfを入力してください");


                for (int i = 0; i < 20 ; i++){
                    Scanner scan = new Scanner(System.in);
                    String target = scan.next();
                    System.out.println(target);

                    if (target.equals("t")){
                        deleteFiles.delete(filename);
                        System.out.println("削除しました");
                        break;

                    }else if (target.equals("f")){
                        System.out.println("取り消しました");
                        break;

                    }else{
                        System.out.println("tまたはfを入力してください");
                        if (i == 20){
                            System.out.println("同様の操作が続いたため自動で終了します");
                        }
                    }

                    scan.close();                 
                }
            }            

        }catch(IOException e){
            System.out.println(e);
        }
    }
}

class plusWriter{
    public static void main(String[] args){
        String filename = "C:\\private\\Java_Programming\\memo2.txt";
        Path p = Paths.get(filename);

        if (!(Files.exists(p))){
            criateFiles.create(filename);            
        }

        try{
            File file = new File(filename);

            if (check.checkBeforeWritefile(file)){
                FileWriter filewriter = new FileWriter(file, true); //trueにすることで追加で書き込むことができる

                filewriter.write("はい。元気です\r\n");
                filewriter.write("ではまた\r\n");

                filewriter.close();
            }else{
                System.out.println("ファイルに書き込めません");
            }
        }catch(IOException e){
            System.out.println(e);
        }
    }
}

class bfWriter{ //どのosでも対応できるfilewriter + シンプル化
    public static void main(String[] args){
        String filename = "C:\\private\\Java_Programming\\memo2.txt";
        Path p = Paths.get(filename);

        if (!(Files.exists(p))){
            criateFiles.create(filename);
        }

        try{
            File file = new File(filename);

            if (check.checkBeforeWritefile(file)){
                BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
                PrintWriter pw = new PrintWriter(bw);

                bw.write("こんにちは");
                bw.newLine();
                bw.write("お元気ですか");
                bw.newLine();

                pw.println("今日の最高気温は");
                pw.println("10");
                pw.println("度です");


                bw.close();
            }else{
                System.out.println("ファイルに書き込めません");
            }
        }catch(IOException e){
            System.out.println(e);
        }
    }
}

//ファイル作成
class criateFiles{
    public static void create(String paths){
        Path p = Paths.get(paths);

        try{
            Files.createFile(p);

        }catch (IOException e){
            System.out.println(e);
        }
    }
}

//ファイルの削除
class deleteFiles{
    public static void delete(String paths){
        Path p1 = Paths.get(paths);

        try{
            Files.deleteIfExists(p1);
        }catch(IOException e){
            System.out.println(e);
        }
    }
}

class check{
    //ファイルの事前確認メソッド
    public static boolean checkFile(File file){
        if (file.exists()){ //ファイルが存在するか
            if (file.isFile() && file.canRead()){ //それはファイルなのか、読めるのか
                return true;
            }
        }

        return false;
    }

    //書き込み可能メソッド
    public static boolean checkBeforeWritefile(File file){
        if (file.exists()){
            if (file.isFile() && file.canWrite()){
                return true;
            }
        }

        return false;
    }
}




