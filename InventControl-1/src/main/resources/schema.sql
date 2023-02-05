/* 資材テーブル*/
CREATE TABLE IF NOT EXISTS materials (
    name VARCHAR(50) PRIMARY KEY
  , tekisei INT
  , zaiko INT
  , price INT
  , detail VARCHAR(50)
  , kosuu INT
  , goukei INT
  ,orderDay DATE
);

/*発注情報テーブル*/
CREATE TABLE IF NOT EXISTS orderList (
    name VARCHAR(50) PRIMARY KEY
  , kosuu INT
  , goukei INT
   ,orderDay DATE
   );