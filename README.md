# PolingService
<p><b>PolingService</b> API для системы опросов пользователей.<p/>
<p>Создано с использованием: Java 11, Spring-Boot, Spring Security, Spring Data JPA.<p/>
<p><b>Для работы потребуется:</b></p>

<ul>
<li><b>Java 11 версии (на 8й должно работать, но не проверял)</b></li>
<li><b>TomCat (версия не ниже 8.5)</b></li>
<li><b>БД PostgreSQL (тестировалось на 13 вер.)</b></li>
<li><b>Postman или другой клиент для работы с API, можно использовать Swagger
 (после запуска сервиса перейдите /swagger-ui/)</b></li>
</ul>

<p>Подготовка к работе сервиса (на localhost):</p>
<ul>
<li>Запустить сервер БД (если не запущен) и создать структуру таблиц в БД:
 выполнить в консоли код из файла db/migration/V1_0__PollingService_DDL.sql</li>
<li>Запустить TomCat (например, перейти \apache-tomcat-8.5.66\bin в консоли, выполнить catalina start)
 и скопировать архив с приложением(PollingService.war) в \apache-tomcat-8.5.66\webapps. 
 War-архив автоматически распакуется и приложение будет доступно на localhost.</li>
<li>MultiChiefInventory_DDL_v1.3.sql</li>
<li>MultiChiefInventory_DDL_v1.3.sql</li>
</ul>



<p>Database structure in files:</p>
<ul>
<li><b>MultiChiefInventory_DDL_v1.3.sql</b></li>
</ul>

<h3>Database scheme</h3>

![MultiChiefInventory_DB_v1_3](https://user-images.githubusercontent.com/61917893/140859298-2dbf4725-b494-4ee0-b5f3-3c88ef9254ef.jpg)


<p>Descriptions:</p>

<ul>
<li>bom - bill of materials</li>
<li>im_order - internal material imOrder</li>
<li>qty - quantity (warehouse_qty, bom_qty, im_order_qty)</li>
<li>primary key (bom_id, id) could be optional if it were not necessary to relate im order with construction
(as the busines rules provide that bom belongs to only one construction)</li>
</ul>

<p>Lev Goryachev 2022</p>
