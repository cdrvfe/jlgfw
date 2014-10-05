しばらく離れたとき用のメモ

### 構成
* `build.sh`
  + ビルド用
* `run.sh`
  + 起動用
* `app/`
  + 全てのclassファイルが出力される場所
  + 必要素材もここに置く
  + こことrun.shがあれば起動可能
* `sources/`
  + ソースコード・コンパイル情報・設定の置き場
  + ソースコードは`sources/*/*.java`に置く
    - コンパイル・実行時は一つのディレクトリにまとめられる
  + `sources/compile_dirs`に、ソースのディレクトリを__コンパイル順に記述__する
  + `sources/*/compile_files`に、ソースファイル名を__コンパイル順に__記述する
  + `sources/config`は諸々追加予定
    - `core=コアクラス名`でコアクラス指定

### ビルド手順

1. `sources/conpile_dirs`に、コンパイルしたいソースがあるディレクトリをコンパイル順に記述  
2. `sources/*/conpile_files`に、ソースファイルをコンパイルしたい順に記述
3. `sources/build_config`の`core=`の後に、ゲームのコアクラスとして使うクラス名を記述
4. 無ければ`app/`ディレクトリを作成
5. `sh build.sh`を実行
6. 実行に必要な素材は、`app/`に入れる(classファイルは全てここ)
7. `sh run.sh`を実行

### コード的な実装手順
#### システム周り

1. `GameCore`を継承したクラスを作る
2. `public void update`に1フレームの動作を、`public void draw(Graphics2D)`に1フレームの描写を記述

### ゲームオブジェクト

1. `GameObject`を継承したクラスを作成
2. 初期設定`public void processActivate(HashMap<String, Object> params)`を実装する
  * このメソッドはインスタンス有効化時の初期か処理、インスタンスの使い回しを想定
  * 中で`x = params.get("x");`のような初期か処理を書く
  * `boolean isActive()`で、インスタンスの有効判定を取得可能
3. 必要があれば、無効果時の処理`public void processInactivate()`を実装
4. 1フレームあたりの動作`move`、描画`draw(Graphics2D)`を実装
  * 無効にしたい時は`inactivate()`を呼ぶ
5. コアクラスの`update`や`draw`に、このオブジェクトの処理を追加

### ゲームオブジェクト（インスタンスが多い場合）
1. `GamePoolObject`を継承したクラスを作成
2. `GameObject`を継承した場合と同じようにオブジェクトクラスを記述
3. コアクラスでは、`ObjectPool.prepareInstance("クラス名")`でactiveでないインスタンスを取得
  * `ObjectPool`が使い回したり増やしたりする
4. `ObjectPool.getActiveList`にクラス名のStringか、Classオブジェクトを渡すと、対応するクラスのactiveなインスタンスが格納されたArrayList<GameObject>を取得できる
  * `GamePoolObject`が`ObjectPool`のリストを操作する
