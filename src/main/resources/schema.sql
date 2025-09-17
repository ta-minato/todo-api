CREATE TABLE IF NOT EXISTS Task( --Taskテーブルを作成する。もし既に存在していたら、新しく作成しない。
    id INT AUTO_INCREMENT, --AUTO_INCREMENTをつけることで、新しいデータが追加されるたびに自動的に1ずつ増えていく。
    task_name VARCHAR(255) NOT NULL,
    task_detail VARCHAR(255) NOT NULL,
    PRIMARY KEY(id) --idをプライマリーキーに設定
);