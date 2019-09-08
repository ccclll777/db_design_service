# db_design_service
 数据库课程设计后端 使用spring boot +mybatis +redis+maven
 
 对应前端链接：
 https://github.com/ccclll777/db_design_web
 
 后端数据库设计：

  ![1]( https://github.com/ccclll777/db_design_service/blob/master/DCE861D3-F02D-4551-8394-C9DF026DF547.png)
    ![1](https://github.com/ccclll777/db_design_service/blob/master/C1E9E6EB-3879-4EE9-B224-84F1F399DDE9.png)
       ![1](https://github.com/ccclll777/db_design_service/blob/master/B91990D9-0D20-4B87-94E3-22E0333C198D.png)
          ![1](https://github.com/ccclll777/db_design_service/blob/master/A6B06592-14AD-41E3-99B1-DBA24CB9C9FB.png)
   ![1](https://github.com/ccclll777/db_design_service/blob/master/6D09BFF9-81F7-4FF7-ABF6-1FAF6C8924AC.png)
![1]( https://github.com/ccclll777/db_design_service/blob/master/6366A0E6-6F3C-44CB-9F98-3B82EEBF064F.png)
![1](https://github.com/ccclll777/db_design_service/blob/master/558E4B72-6221-4D3E-8046-53998358ADBF.png)
用户（电话号码，密码，身份证号，邮箱，真实姓名，用户类型，性别，地址）
乘客（用户电话号码，乘客身份证号，乘客真实姓名，乘客电话号码，乘客类型，地址）
列车信息（列车编号，车次，列车类型，列车车厢数，列车始发站，列车终点站，列车开车时间，列车到达时间，列车到达日期，列车运行时间，列车状态）
列车座位信息（列车编号，车厢号，座位类型，座位数）
列车经停信息（列车编号，车次，车站编号，车站名，到达时间，总运行时间，开车时间）
订单信息（订单编号，用户电话号码，乘客身份证号码，列车编号，出发站编号，到达站编号，车厢号，座位编号，订单创建时间，订单状态，开车时间）
