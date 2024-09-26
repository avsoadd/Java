## Overview

Spring Web サービスの勉強プロジェクトです。


## 作業環境

- Windows11
- Eclipse
  - Version: 2023-12 (4.30.0)
  - Build id: 20231201-2043



## 環境構築

### 1. Eclipseセットアップ

1. Pleiades All in OneパッケージをDownloadして展開
2. ”HelloWorld”の確認


### 2. プロジェクト作成

1. [ファイル] - [新規] - [Springスターター・プロジェクト(Spring Initializer)]
2. 依存関係は以下を選択
    - Spring Boot DevTools
    - Spring Web
3. 「完了」


### 3. スケルトンの実行確認

- [実行] - [Spring Boot アプリケーション]で実行する
- http://localhost:8080/ へアクセスする
    - 「Whitelabel Error Page」が表示されればOK



### X. 上手く行かないときの対処

- おそらく多くの環境で、プロジェクト作成後の自動セットアップ時に以下の問題が出る
- それぞれ問題の対応後はEclipseを再起動するか、またはプロジェクトのフォルダでコマンドプロンプトを起動して以下のコマンドを実行する
```
./gradlew build
```


#### ▲「ツールチェーンのダウンロードリポジトリが構成されていません」

```
No locally installed toolchains match 
(see https://docs.gradle.org/8.0/userguide/toolchains.html#sec:auto_detection) 
and toolchain download repositories have not been configured 
(see https://docs.gradle.org/8.0/userguide/toolchains.html#sub:download_repositories).
```

settings.gradleを以下のように修正する
```
plugins {
    id 'org.gradle.toolchains.foojay-resolver-convention' version '0.8.0'
}
rootProject.name = '〇〇'
```
※pluginsの項目は先頭に記述する必要がある


#### ▲「ローカルにインストールされたツールチェーンまたは構成されたツールチェーンのダウンロード リポジトリに一致するツールチェーンが見つかりませんでした」

上記の問題を片付けると次はこれが出る可能性が高い
```
No matching toolchain could be found in the locally installed toolchains 
or the configured toolchain download repositories. 
Some toolchain resolvers had provisioning failures: 
```

1. 「build.gradle」を確認してJavaのバージョンをチェックする
```
java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}
```

2. [ここ](https://docs.gradle.org/current/userguide/compatibility.html) でJavaとGradleの対応バージョンを確認する
3. 「gradle-wrapper.properties」の `distributionUrl` の値を適切なバージョンへ変更する





