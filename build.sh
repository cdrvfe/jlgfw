#!/bin/bash

home_dir=`pwd`

#sources以下の指定ファイルをバッファディレクトリにコピー
cd "$home_dir"/sources/
mkdir build_buf/
 
cd "$home_dir"/sources/
for dir in `cat compile_dirs`
do
	#順番にバッファディレクトリにコピー
	for file in `cat "$dir"/compile_files`
	do
		cp "$dir"/"$file" build_buf/
		# -a オプションでコピーの度にコンパイル
		if test "$1" = "-a" ; then
			cd build_buf
			javac "$file"
			cd ../
		fi
	done
done

#使用コア読み出し、run編集
cd "$home_dir"/
core=`cat sources/build_config | grep 'core=' | cut -d'=' -f2`
echo 'cd app/ ; java Starter '"$core"' ; cd ../'>run.sh

cd "$home_dir"/sources/build_buf
javac Starter.java
javac "$core".java
cd ../

#app/にコピー後、バッファディレクトリ削除
cd "$home_dir"/sources/
cp build_buf/*.class ../app/
rm -rf build_buf/
