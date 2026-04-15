# Osaka Treasure Adventure (大阪の宝物をさがそう)

 1. Giới thiệu

大阪の宝物を探そう là một game 2D tile-based được xây dựng bằng Java Swing, 
kết hợp giữa gameplay và hệ thống câu hỏi trắc nghiệm nhằm tạo trải nghiệm vừa chơi vừa học.

Người chơi điều khiển nhân vật di chuyển trên bản đồ, vượt qua các thử thách bằng cách trả lời câu hỏi trắc nghiệm.  
Mục tiêu là đến đích cuối cùng để hoàn thành game và đạt điểm cao nhất.

  Mục tiêu project

* Xây dựng game bằng Java thuần (không dùng game engine)
* Kết hợp giữa game và học tập (quiz)
* Quản lý trạng thái game: thời gian, điểm số, thắng/thua
* Lưu điểm người chơi vào database MySQL

---

 2. Tính năng chính

*  Di chuyển nhân vật trên bản đồ 2D
*  Hệ thống map dạng tile-based
*  Câu hỏi trắc nghiệm khi gặp “monster”
*  Bộ đếm thời gian (Timer)
*  Tính điểm khi trả lời đúng
*  Game Over khi sai hoặc hết thời gian
*  Game Clear khi đến đích
*  Reset game để chơi lại
*  Intro story với hiệu ứng typewriter
*  Hiển thị hình ảnh (tree, monster, decoration…)
*  Lưu điểm người chơi vào MySQL

---

 3. Công nghệ sử dụng

* Java (JDK 22+ – version 66.0)
* Java Swing (GUI)
* OOP (Object-Oriented Programming)
* Event-driven programming:
* KeyListener
* Swing Timer
* MySQL (database)
* JDBC (MySQL Connector)

---

 4. Cấu trúc project

```
MNTgame/
│
├── src/GameDemo
│   ├── DatabaseManager.java
│   ├── EndScreen.java
│   ├── GamePanel.java
│   ├── GameScreen.java
│   ├── IntroScreen.java
│   ├── IntroStory.java
│   ├── Main.java
│   ├── MCQuestion.java
│   ├── PlayerScore.java
│   └── ScoreFrame.java
│
├── images/
│   ├── daruma.png
│   ├── eki.png
│   ├── gate1.png
│   ├── hashi_left.png
│   ├── hashi_right.png
│   ├── hito.png
│   ├── momiji.png
│   ├── money.gif
│   ├── money.png
│   ├── monster.png
│   ├── monster1.png
│   ├── otera_1.png
│   ├── otera_2.png
│   ├── otera.png
│   ├── poster.png
│   ├── sand.png
│   ├── taki.png
│   ├── taki1.png
│   └── taki2.png
│
├── Screen Short Image/
│   
├── MNTGame.jar
├── database.txt
└── README.md
```

---

 📂 Giải thích các file chính

* `Main.java`            – Entry point của chương trình
* `GamePanel.java`       – Xử lý logic game và render
* `GameScreen.java`      – Màn hình chơi chính
* `IntroScreen.java`     – Màn hình bắt đầu
* `IntroStory.java`      – Hiệu ứng intro story
* `MCQuestion.java`      – Xử lý câu hỏi trắc nghiệm
* `DatabaseManager.java` – Kết nối MySQL
* `PlayerScore.java`     – Model lưu điểm
* `ScoreFrame.java`      – Hiển thị bảng điểm
* `EndScreen.java`       – Game Over / Game Clear

---

 5.  How to play

* Sử dụng phím mũi tên để di chuyển nhân vật
* Gặp monster → trả lời câu hỏi trắc nghiệm
* Trả lời đúng → tiếp tục và cộng điểm
* Trả lời sai hoặc hết thời gian → Game Over
* Đến đích cuối → Game Clear

---

 6.  Screenshots (có sẵn folder Screen Short Image)

![1](TONTHATMINHNHAT_GAME/Screen%20Short%20Image/1_Name_typing_Box.png)
![2](TONTHATMINHNHAT_GAME/Screen%20Short%20Image/2_Intro_Story.png)
![3](TONTHATMINHNHAT_GAME/Screen%20Short%20Image/3_Opening_Screen.png)
![4](TONTHATMINHNHAT_GAME/Screen%20Short%20Image/4_Rule_Screen.png)
![5](TONTHATMINHNHAT_GAME/Screen%20Short%20Image/5_Main_Screen.png)
![6](TONTHATMINHNHAT_GAME/Screen%20Short%20Image/6_Question_Box.png)
![7](TONTHATMINHNHAT_GAME/Screen%20Short%20Image/7_Correct_Answer_Box.png)
![8](TONTHATMINHNHAT_GAME/Screen%20Short%20Image/8_Incorrect_Answer_Box.png)
![9](TONTHATMINHNHAT_GAME/Screen%20Short%20Image/9_Questions_Explain_Box.png)
![10](TONTHATMINHNHAT_GAME/Screen%20Short%20Image/10_Winning_Box.png)
![11](TONTHATMINHNHAT_GAME/Screen%20Short%20Image/11_Results_Information_Box.png)
![12](TONTHATMINHNHAT_GAME/Screen%20Short%20Image/12_Ranking_Box.png)
![13](TONTHATMINHNHAT_GAME/Screen%20Short%20Image/13_Ending_Story.png)
![14](TONTHATMINHNHAT_GAME/Screen%20Short%20Image/14_Ending_Screen.png)


---

 7. Cài đặt & chạy project  (Java + MySQL)

# . CLONE PROJECT

1. Clone từ GitHub: 
git clone https://github.com/tonthatminhnhat444/MNTgame
cd MNTgame

2. Hoặc tải ZIP:
- Vào GitHub → Code → Download ZIP
- Giải nén file

---

#  LƯU Ý 
1. File MNTGame.jar đã được build sẵn và đã cấu hình kết nối database.
Hãy đảm bảo bạn đã cài đặt JDK 22 và thiết lập môi trường database thành công thì mới có thể chạy game này.

2. Trong trường hợp chạy game nhưng không lưu được dữ liệu hoặc không hiển thị kết quả:
a. Kiểm tra MySQL Server đã chạy chưa  
b. Kiểm tra database và bảng đã được tạo đúng theo hướng dẫn  
c. Thực hiện cài đặt database thủ công nếu chưa có dữ liệu

# DATABASE SETUP

# 1. CÀI MySQL

a. Cài đặt
- Cài MySQL Server
- Cài MySQL Workbench

b. Tài khoản mặc định
- Username: root
- Password: (mật khẩu bạn đã đặt khi cài MySQL)

---

# 2. KIỂM TRA PORT MYSQL

MySQL không phải lúc nào cũng dùng port 3306. Cách kiểm tra port:

Cách 1: Trong MySQL Workbench
- Vào: Server Status
- Hoặc xem connection

Cách 2: SQL query
SHOW VARIABLES LIKE 'port';

Kết quả có thể là:
- 3306 (mặc định)
- 3307
- 66405 (MySQL instance khác)

Nếu sai port → game sẽ lỗi:
- Cannot connect to database
- Connection refused

* Cách sử dụng port trong project:

Mở file DatabaseManager.java và chỉnh lại:
jdbc:mysql://localhost:3306/gamedb

Nếu port khác:
jdbc:mysql://localhost:66405/gamedb
 
```sql
CREATE DATABASE gamedb;
USE gamedb;

CREATE TABLE player_scores (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50),
    score INT,
    time_played INT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

 3. MySQL Connector 
 Version mysql-connector-9.6.0.jar

Link tải trực tiếp (trang download):
https://dev.mysql.com/downloads/connector/j/

# CÀI ĐẶT JAVA

1. Kiểm tra Java
```bash
java -version
```

a. Yêu cầu: JDK 22 trở lên (class file version 66.0)

2. Cài Java (nếu chưa có)
 Tải JDK 22+ https://www.oracle.com/java/technologies/downloads/  


# CHẠY GAME

1. Chạy bằng file JAR (khuyên dùng)
```bash
java -jar JavaGame.jar
```
 Hoặc double click:
MNTGame.jar


2. Chạy bằng command line
```bash
java -cp "MNTGame.jar;lib/mysql-connector-9.6.0.jar" GameDemo.Main
```
 macOS/Linux thay `;` bằng `:`

# KIỂM TRA DATABASE

1. Mở MySQL Workbench  
2. Chạy:

```sql
SELECT * FROM player_scores;
```
 Nếu có dữ liệu → OK

# LƯU Ý

* MySQL phải đang chạy trước khi mở game  

* Không xóa các thư mục:
   image/  
   GameDemo/

* JDBC driver đã có sẵn trong project

* Nếu lỗi khi chạy JAR:
```bash
java --enable-preview -jar JavaGame.jar
```
* Nếu database sai:
   Game vẫn chạy bình thường  
   Nhưng KHÔNG lưu được điểm

 8. Troubleshooting

* Lỗi `No suitable driver` → chưa add MySQL Connector
* Lỗi `Access denied` → sai username/password MySQL
* Lỗi không load ảnh → sai đường dẫn
* Lỗi connect DB → kiểm tra database

---

 9. Tác giả

* Name: Ton That Minh Nhat
* GitHub: https://github.com/tonthatminhnhat444/MNTgame
* Email: tonthatminhnhat.japan@gmail.com

---

 10.  Hướng phát triển

* Thêm nhiều level, questions
* Thêm AI cho enemy
* Thêm âm thanh
* Tối ưu UI & animation
* Lưu leaderboard nâng cao
