# 2021研修SpringBoot講義

ソースのダウンロード

```
$ git clone https://<ユーザー名>@github.com/froide-kk/java-framework.git
```



## プロジェクト概要

講義で使用するプロジェクト、及びドキュメントを管理するリポジトリです。

講義日数は5日、予備知識について1日、テキストのチャプター1,5を1日、2-4を1日ずつで進めていく想定です。



## 講義の目標

* SpringBootの利用方法について理解する。
* フレームワークを使った開発への足がかりを作る。
* SpringBootを使用してWEBページの作成ができる。



## 使用テキスト

[現場至上主義 Spring Boot 2 徹底活用](https://www.amazon.co.jp/%E7%8F%BE%E5%A0%B4%E8%87%B3%E4%B8%8A%E4%B8%BB%E7%BE%A9-Spring-Boot2-%E5%BE%B9%E5%BA%95%E6%B4%BB%E7%94%A8-%E5%BB%A3%E6%9C%AB/dp/4802611854)



## 講義目次

0. Springの予備知識
   1. DI
   2. コンテナDI
   3. フレームワーク
   4. MVC
   5. テンプレートエンジン
   6. ORマッパー
   7. Spring Bean
1. SpringBootの構成
   1. Spring Initializrを使ったプロジェクト作成と構成の解説
   2. Spring MVCを使用したHello World
   3. GET/POSTパラメータの受け取り
   4. Lombokについて
2. 画面開発
   1. Thymeleafを利用した画面開発
3. Webアプリケーションにおける共通処理
   1. Beanバリデーション
   2. バリデーターを使用した相関バリデーション
   3. SLF4Jを使用したロギング
4. データアクセス
   1. Domaを使用したORマッピングとデータ操作
5. セキュリティ
   1. Spring Securityを利用した独自の認証システムの構築
   2. Spring Securityを利用した認可システムの構築

テキストのコード例は難解であったり初学者向けの内容が抜けていたりするため、基本的にそのまま使用せずに簡略化したものを用意します。



## プロジェクト構成

```
.
├--doc
|    └--練習問題
└--src
     ├--chapters
     └--exercise
```

`docs` フォルダ配下 に 参考資料、 練習問題を配置しています。

`src` > `chapters` 配下にテキスト章ごとのpackageを作成しています。

`src` > `exercise` 配下に練習問題のソースを作成しています。