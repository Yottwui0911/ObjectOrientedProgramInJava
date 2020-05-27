# ObjectOrientedProgramInJava

# 概要
以下の問題をJavaのコンソールに出力してみましょう  

# 目的
以下のような想定  
三角形の面積を計算するアプリケーションを作りたい。  
しかし、次第に長方形や円の面積も計算したいと要求は膨れる。  
それら要求、またはさらに未知なる追加要求を吸収するためにオブジェクト指向を駆使し、保守性、拡張性高いクラス設計を行う。  

# コミット単位
以下の課題1.2.3.....ごとにコミットをしてください。  
コミットメッセージは  
課題1 Triangleクラスの作成  
など、  
課題x message  
というルールでお願いします。  

# 課題
## 初期データセット
shapes.csv
に300組みデータを用意しているのでそれを使うこと

## 出力方式
### 形式
以下のように出力お願いします。

例：課題1つめ

========= 課題1 Start =========

// 答え

========= 課題1  End  =========

Booleanで答えが出る場合はtrue or falseを答えに記載してください。

### round処理
小数点以下は小数点1桁で。
小数点2桁目を四捨五入でよろしくお願いします。

## クラス作成編
1. 三角形クラス(Triangleクラス)を作って、図形の面積の数値を返すメソッドを持たせる  
   -> コンストラクタで底辺と高さを受け取り、フィールドに値をセット。
2. 100組の底辺と高さの組み合わせの数値列を読み込ませて、面積を計算して出力する

## Stream特訓編
参考：https://qiita.com/amay077/items/9d2941283c4a5f61f302

3. 2のデータで、面積が1000以上の三角形が存在するかを"Streamを用いず"判断する  
4. 2のデータで、面積が1000以上の三角形が存在するかを"Streamを用いて"判断する
5. 2のデータで、面積が1000を初めて超えるたときの三角形の面積を"Streamを用いて"出力  
   存在しない場0を出力
6. 2のデータで、面積が1000以上の三角形の数を"Streamを用いて"出力
7. 2のデータで、三角形の面積の平均値を"Streamを用いて"出力
8. 2のデータで、三角形の面積を降順に並べ、Top10を表示

## 疑似クラス作成編
9. 長方形クラス(Squareクラス)を作って、図形の面積の数値を返すメソッドを持たせる  
   -> コンストラクタで底辺と高さを受け取り、publicなプロパティに値をセットしてください。
10. 100組の底辺と高さの組み合わせの数値列を読み込ませて、面積を計算して出力する
11. 11のデータで、面積が1000以上の正方形が存在するかを"Streamを用いて"判断する
12. 円クラス(Circleクラス)を作って、図形の面積の数値を返すメソッドを持たせる  
   -> コンストラクタで半径を受け取り、publicなプロパティに値をセットしてください。  
13. 100組の半径の数値列を読み込ませて、面積を計算して出力する
14. 11のデータで、面積が1000以上の円が存在するかを"Streamを用いて"判断する

## インターフェース作成編
15. Shapeインターフェースを作成し、面積を計算するメソッドを用意し、Triangleクラス、Squareクラス、Circleクラスに継承させる

## ポリモーフィズム特訓編
16. 三角形クラス、長方形クラス、円クラスの面積の合計をまとめて計算してくれるメソッドを作成し、計300組みの面積をすべて合計した値を出力  
    -> メソッドの引数は `List<double>` ではなく、 `List<Shape>` を必ず用いるようにする
