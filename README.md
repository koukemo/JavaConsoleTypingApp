# typing app

コンソールタイピングアプリケーション

## 構成

---

```
JavaConoleTypingApp
└── typing_app
        ├── figures/
        ├── resources
        │      ├── easy.csv
        │      ├── nornmal.csv
        │      ├── hard.csv
        │      └── ranking.csv
        ├── utility/
        ├── GameMode.java
        ├── Ranking*.java
        └── MainMenu.java
```

## 実行手順

---

`JavaConoleTypingApp`ディレクトリにて以下を実行し, コンパイル <br>

```bash
javac typing_app/utility/ConvertListType.java
javac typing_app/utility/StandardCsvOperator.java
javac typing_app/utility/StandardInputReader.java
javac typing_app/utility/StopWatch.java

javac typing_app/GameMode.java
javac typing_app/Ranking.java
javac typing_app/RankingList.java
javac typing_app/RankingMenu.java
```

以下コマンドにて実行 <br>

```bash
java typing_app/MainMenu.java
```

もしくは <br>

```bash
javac typing_app/MainMenu.java
java typing_app.MainMenu
```

## 実行結果

---

<img src="./figures/typing_app_demo.png" width=75%>