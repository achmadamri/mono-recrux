# mono-recrux
npm install -g @angular/cli

docker-compose up -d

ng build --configuration=production

sudo cp -r bsd-front-rec/dist/* /var/www/html/

use bsd_api_rec_member;
delete from tb_user where tbu_email = 'achmad.amri@gmail.com';
use bsd_api_rec_departments;
delete from tb_user where tbu_email = 'achmad.amri@gmail.com';
use bsd_api_rec_auth;
delete from tb_auth where tba_email = 'achmad.amri@gmail.com';

nohup java -jar target/bsd-api-rec-auth-0.0.1-SNAPSHOT.jar > output.log 2>&1 &
nohup java -jar target/bsd-api-rec-departments-0.0.1-SNAPSHOT.jar > output.log 2>&1 &
nohup java -jar target/bsd-api-rec-member-0.0.1-SNAPSHOT.jar > output.log 2>&1 &

mysql -uroot -pP@55w0rd bsd_api_rec_auth < bsd-api-rec-auth/bsd_api_rec_auth.sql
mysql -uroot -pP@55w0rd bsd_api_rec_departments < bsd-api-rec-departments/bsd_api_rec_departments.sql
mysql -uroot -pP@55w0rd bsd_api_rec_member < bsd-api-rec-member/bsd_api_rec_member.sql

mysqldump -uroot -pP@55w0rd bsd_api_rec_auth > bsd-api-rec-auth/bsd_api_rec_auth.sql
mysqldump -uroot -pP@55w0rd bsd_api_rec_departments > bsd-api-rec-departments/bsd_api_rec_departments.sql
mysqldump -uroot -pP@55w0rd bsd_api_rec_member > bsd-api-rec-member/bsd_api_rec_member.sql