/* 資材詳細テーブル */
INSERT INTO materials (
    name
  , tekisei
  , zaiko
  , price
  , detail
  , kosuu
  , goukei
  ,orderDay
) VALUES
('パイプ', '5', '6', '50000', '100本/束　単位(束)', '1', '0', '2023-2-5')
,('ペンキ（黄）', '4', '4', '5000', '1缶', '1', null, null)
;


/* 資材発注情報テーブル*/
INSERT INTO orderList (
    name
    , kosuu
    , goukei
    , orderDay
    )VALUES
    ('パイプ', '1', '50000', '2023-02-02');