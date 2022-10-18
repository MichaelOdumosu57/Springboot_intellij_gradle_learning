import sqlite3
con = sqlite3.connect('test.db.sqlite')
cur = con.cursor()
import sys
if sys.platform == "win32":
    sys.path.append(sys.path[0] +"\\..")
elif sys.platform =="linux":
    sys.path.append(sys.path[0] +"/..")

def init_table():
  cur.executescript(
    '''
    DROP TABLE IF EXISTS user;

    CREATE TABLE user (
      user_id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
      name VARCHAR(45) DEFAULT NULL,
      age INTEGER DEFAULT NULL,
      salary INTEGER DEFAULT NULL
    );

    INSERT INTO user VALUES (1,'kiran',26,18000),(2,'kumar',25,15000),(3,'sandeep',26,20000),(4,'bharath',26,19000);
    '''
  )

init_table()
