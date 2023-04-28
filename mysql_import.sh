mysql -h127.0.0.1 -uroot -pP@55w0rd -e "CREATE DATABASE bsd_api_rec_auth;"
mysql -h127.0.0.1 -uroot -pP@55w0rd bsd_api_rec_auth < bsd-api-rec-auth/bsd_api_rec_auth.sql
mysql -h127.0.0.1 -uroot -pP@55w0rd -e "CREATE DATABASE bsd_api_rec_departments;"
mysql -h127.0.0.1 -uroot -pP@55w0rd bsd_api_rec_departments < bsd-api-rec-departments/bsd_api_rec_departments.sql
mysql -h127.0.0.1 -uroot -pP@55w0rd -e "CREATE DATABASE bsd_api_rec_member;"
mysql -h127.0.0.1 -uroot -pP@55w0rd bsd_api_rec_member < bsd-api-rec-member/bsd_api_rec_member.sql
