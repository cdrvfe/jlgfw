#!/bin/bash

#sources以下の指定ファイルをバッファディレクトリにコピー
cd sources
mkdir build_buf/

for dir in `cat compile_dirs`
do
	#順番にバッファに入れてコンパイル
	for file in `cat "$dir"/compile_files`
	do
		cp "$dir"/"$file" build_buf/
		cd build_buf
		`javac "$file"`
		cd ../
	done
done

#app/にコピー後、バッファディレクトリ削除
cp build_buf/*.class ../app/
rm -rf build_buf/

#使用コア読み出し、Starter編集
cd ../
core=`cat sources/build_config | grep 'core=' | cut -d'=' -f2`
echo 'cd app/ ; java Starter '"$core"' ; cd ../'>run.sh
