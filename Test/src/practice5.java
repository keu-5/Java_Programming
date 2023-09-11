
import java.util.ArrayList; //要素を絶対的に表現する
import java.util.LinkedList; //要素を相対的に表現する→ArrayListより処理が速い
import java.util.HashMap; //辞書式にできる
import java.util.Map;

class L{
    public static void main(String[] args){
        //ArrayListを作成
        ArrayList<String> listStrings = new ArrayList<>(); //ラッパークラスを使用
        ArrayList<Integer> listIntegers = new ArrayList<>();

        //要素を追加
        listStrings.add("Apple");
        listStrings.add("Orange");
        listStrings.add("Lemon");

        listIntegers.add(Integer.valueOf(16));
        listIntegers.add(Integer.valueOf(8));
        listIntegers.add(24);

        //要素を特定の位置に追加
        listStrings.add(1, "Grapes");
        listIntegers.add(2, 32);

        //リストを置換
        listStrings.set(2, "Grapes");

        //要素を削除
        listStrings.remove("Lemon"); //オブジェクトを含む要素を削除
        listIntegers.remove(2); //要素を削除

        //要素を検索
        System.out.println(listStrings.indexOf("Grapes")); //一番左の満たす要素番号を取得
        System.out.println(listIntegers.indexOf(22)); //要素を含まない場合-1を返す

        //要素内のオブジェクトを取得
        for (String s: listStrings){
            System.out.println(s);
        }
        for (int i: listIntegers){
            System.out.println(i);
        }

        //すべての要素を削除
        listStrings.clear();
        System.out.println(listStrings);
        
        //linkedlist
        LinkedList<Double> listDouble = new LinkedList<>();

        listDouble.add(3.14);
        listDouble.add(2.71);

        System.out.println(listDouble);


    }
}

//hashmap
class HM{
    public static void main(String[] args){
        String[] fruits = {"Apple", "Orange", "Grape"};
        Integer[] price = {80, 120, 90};
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < fruits.length; i++){
            map.put(fruits[i], price[i]);
        }

        System.out.println(map);
        System.out.println(map.get("Orange"));

        //値の更新
        map.put("Orange", 110);
        System.out.println(map.get("Orange"));

        //値がなければ追加する
        map.putIfAbsent("Orange", 20);
        System.out.println(map.get("Orange"));

        //マップのペア数
        System.out.println(map.size());

        //値を取得する
        System.out.println(map.get("Grape"));
        System.out.println(map.get("melon"));
        System.out.println(map.getOrDefault("melon", 0));

        //ペアの存在確認
        System.out.println(map.containsKey("Apple"));
        System.out.println(map.containsValue(1000));

        //ペア削除
        map.remove("Apple");
        System.out.println(map);

        map.clear();
        System.out.println(map);
    }
}

//メンバ変数→メソッドの中で代入する→代入できる条件をつけれる
class ctest{
    public static void main(String[] args){
        Television tv = new Television();

        tv.dispChannel();

        tv.setChannel(5); //値が更新されない
        tv.dispChannel();
        tv.setChannel(3);
        tv.dispChannel();
        tv.setBroadcaster("FujiTV");
        tv.dispChannel();
        
        //tv.channelNo = 2; //privateにしているので代入不可
        //tv.dispChannel();
        
    }
    ctest(){
        System.out.println("ctestのコンストラクタ");
    }
}

class T{
    public static void main(String[] args){
        new ctest(); //コンストラクタの呼び出し
    }
}

class Television{
    //メンバ変数
    private int channelNo; 
    String broadcaster;

    //特定の値のときのみメンバ変数に代入できる
    void setChannel(int newChannelNo){
        if (newChannelNo == 1){
            channelNo = 1;
            broadcaster = "FujiTV";

        }else if (newChannelNo == 3){
            channelNo = 3;
            broadcaster = "NHK";
        }
    }

    //これはメンバメソッド、というより基本的にみんなメンバメソッド
    void setBroadcaster(String newBroadcaster){
        if (newBroadcaster.equals("FujiTV")){
            channelNo = 1;
            broadcaster = "FujiTV";

        }else if (newBroadcaster.equals("NHK")){
            channelNo = 3;
            broadcaster = "NHK";
        }
    }

    void dispChannel(){
        System.out.println("現在のチャンネルは" + channelNo + "です");
    }

    //コンストラクタ→defaultみたいなイメージ
    Television(){
        channelNo = 1;
        broadcaster = "FujiTV";
    }
}

//スーパークラス→同じメソッドが複数のクラスにある場合まとめることができる
class circuit{
    public static void main(String[] args){
        //
    }
}

class car1{
    public static void accele(){
        System.out.println("アクセル搭載");
    }

    public static void brake(){
        System.out.println("ブレーキ搭載");
    }
}

class carA extends car1{
    public static void hybrid(){
        System.out.println("ハイブリッド車");
    }
}

class carB extends car1{
    public static void openRoof(){
        System.out.println("オープンカー仕様");
    }
}

class ctest11{
    public static void main(String[] args){
        Soarer soarer = new Soarer();

        soarer.openRoof();
        if (soarer.roofOpenFlag){
            System.out.println("屋根が開いています");
        }else{
            System.out.println("屋根が閉じています");
        }

        soarer.accele(); //extendsすればスーパークラスを使うことができる
        System.out.println("現在の速度は" + soarer.speed + "キロです");
    }
}

class Car{ //スーパークラス
    int speed = 0;

    public void accele(){ //privateにすると動かなくなる
        speed += 5;
    }

    public void brake(){
        speed -= 5;
    }
}


class Soarer extends Car{ //サブクラス
    boolean roofOpenFlag = false;

    public void openRoof(){
        roofOpenFlag = true;
    }

    public void closeRoof(){
        roofOpenFlag = false;
    }
}
/**-----------------------------------------------------------------------------------------
//スーパークラスにある引数ありのコンストラクタ
class ctest15{
    public static void main(String[] args){
        new B(); //クラスの呼び出し
    }
}

class A{
    //コンストラクタ→一番はじめに勝手に呼ばれる
    A(){ //コンストラクタ（引数なし）
        System.out.println("クラスAのコンストラクタ");
    }
    A(int num){ //引数が違えば同じメソッド名でも可
        System.out.println("クラスAの引数ありコンストラクタ");
    }

    public static void test(){
        System.out.println("テスト");
    }
}

class B extends A{
    B(){
        super(10); //スーパークラスのコンストラクタの呼び出し
        System.out.println("クラスBのコンストラクタ");
    }
}
--------------------------------------------------------------------------------------------------**/
class ctest16{
    public static void main(String[] args){
        b1 b1 = new b1();
        b1.disp();

        b2 b2 = new b2();
        b2.disp();
    }
}

class a{
    public void disp(){
        System.out.println("電化製品です");
    }
}

class b1 extends a{ //disp()のオーバーライド
    public void disp(){
        System.out.println("エアコンです");
    }
}

class b2 extends a{} //オーバーライドしない場合

class ctest19{
    public static void main(String[] args){
        superClass obj[] = new superClass[3];

        obj[0] = new subClassA();
        obj[1] = new subClassB();
        obj[2] = new subClassC();

        for (int i = 0; i < 3; i++){
            obj[i].dispName();
        }

        superClass abj = new subClassA();
        abj.dispName();
    }
}

class superClass{
    public void dispName(){
        System.out.println("未定義です");
    }
}

class subClassA extends superClass{
    public void dispName(){
        System.out.println("製品名はxxxです");
    }
}

class subClassB extends superClass{
    public void dispName(){
        System.out.println("製品名はyyyです");
    }
}

class subClassC extends superClass{
    public void dispName(){
        System.out.println("製品名はzzzです");
    }
}


class ctest20{
    public static void main(String[] args){
        productionA pa = new productionA();
        pa.dispName();
    }
}

abstract class base{
    abstract public void dispName();
}

class productionA extends base{
    public void dispName(){
        System.out.println("製品名はxxxです");
    }

    public void dispVersion(){
        System.out.println("バージョンは1.0です");
    }
}

class testc{
    public static void main(String[] args){
        int k = 144;
        do{
            k = k / 3;
        }while (k % 3 == 0);

        System.out.println(k);
    }

}

