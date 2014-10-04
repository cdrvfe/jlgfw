#### ビルド手順

1. `sources/conpile_dirs`に、コンパイルしたいソースがあるディレクトリをコンパイル順に記述
2. `sources/*/conpile_files`に、ソースファイルをコンパイルしたい順に記述
3. `sources/build_config`の`core=`の後に、ゲームのコアクラスとして使うクラス名を記述
4. `sh build.sh`を実行
5. 実行に必要な素材は、`app/`に入れる(classファイルは全てここ)
6. `sh run.sh`を実行
