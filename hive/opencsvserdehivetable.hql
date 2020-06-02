CREATE EXTERNAL TABLE opencsvserdehivetable (
   `col1` string ,
   `col2` string ,
   `col3` string ,
   `col4` string )
PARTITIONED BY (
  `partitionbycol` string)
ROW FORMAT SERDE
  'org.apache.hadoop.hive.serde2.OpenCSVSerde' 
WITH SERDEPROPERTIES (
  'separatorChar'='~')
STORED AS INPUTFORMAT
  'org.apache.hadoop.mapred.TextInputFormat'
OUTPUTFORMAT
  'org.apache.hadoop.hive.ql.io.HiveIgnoreKeyTextOutputFormat'
LOCATION
  '/data/databasename/opencsvserdehivetable';
