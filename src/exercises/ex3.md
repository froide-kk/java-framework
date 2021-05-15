# 研修課題３日目〜
1. Domaを使用しORマッパーの使用方法を理解する
- Domaの初期設定等を完了したch3_1プロジェクトをベースに学習をすすめる
- 原則DAOスタイルを使用する
- Selectの実装例とDomaリファレンスを参考にCRUD処理を実装する
- RestControllerを使用してJSON送ってCRUDする
```
curl -X GET "http://localhost:8080/users"
curl -X POST "http://localhost:8080/users" -F "name=sueoka" -F "password=pass" -F "passwordConfirm=pass"
curl -X PUT "http://localhost:8080/users/1" -F "name=sueokagouki" -F "password=pass" -F "passwordConfirm=pass"
curl -X DELETE "http://localhost:8080/users/1"
```
- 早期に実装完了したものがいればDSLスタイルで実装してもらう

2. Domaを使用し、画面から登録・参照・更新・削除ができるように実装する
