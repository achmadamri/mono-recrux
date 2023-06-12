# mono-recrux
ng build --configuration=production

sudo cp -r bsd-front-rec/dist/* /var/www/html/

use bsd_api_rec_member;
delete from tb_user where tbu_email = 'achmad.amri@gmail.com';
use bsd_api_rec_departments;
delete from tb_user where tbu_email = 'achmad.amri@gmail.com';
use bsd_api_rec_auth;
delete from tb_auth where tba_email = 'achmad.amri@gmail.com';