# mono-recrux

1. Go to Application.java. Open it and codespace will suggest to install plugin for java
2. Go to docker-compose.yml. Open it and codespace will suggest to install plugin for docker

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

mysql -uroot -pP@55w0rd -h127.0.01 bsd_api_rec_auth < bsd-api-rec-auth/bsd_api_rec_auth.sql
mysql -uroot -pP@55w0rd -h127.0.01 bsd_api_rec_departments < bsd-api-rec-departments/bsd_api_rec_departments.sql
mysql -uroot -pP@55w0rd -h127.0.01 bsd_api_rec_member < bsd-api-rec-member/bsd_api_rec_member.sql

mysqldump -uroot -pP@55w0rd bsd_api_rec_auth > bsd-api-rec-auth/bsd_api_rec_auth.sql
mysqldump -uroot -pP@55w0rd bsd_api_rec_departments > bsd-api-rec-departments/bsd_api_rec_departments.sql
mysqldump -uroot -pP@55w0rd bsd_api_rec_member > bsd-api-rec-member/bsd_api_rec_member.sql

Note :

26/07/2023
1. Pasang button Add di department detail, masuk ke halaman Job creation, dan load Departmentnya untuk langsung dipasang di Job ketika di save. DONE
2. Di job detail pasang button Add, untuk masuk ke halaman resume kosong. Ini menu baru, untuk isi resume manual
3. Di resume detail, cukup 1 tab saja isinya Information, Personal Details, Resume, dll.... DONE
4. Upload Resume dihilangkan. Nanti akan ada menu baru isinya halaman job yang bisa diakses publik, dan publik bisa bebas upload resume mereka terhadap job itu, kemudian setelah upload akan masuk ke halaman resume detail dan mereka bisa melengkapi data2nya