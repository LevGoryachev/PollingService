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

<p>Описание структуры:</p>
<ul>
<li>api - классы контроллеров или routes</li>
<li>app - классы инициализации/запуска</li>
<li>model - классы сущностей (по таблицам из БД)</li>
<li>repository - интерфейсы JPA (DAO слой)</li>
<li>service - классы для логики, логика разделёна по сущностям</li>
<li>exception - ControllerAdvice, отлавливающий исключения в контроллерах и классы кастомных исключений</li>
</ul>

<p>Database structure in files:</p>
<ul>
<li><b>MultiChiefInventory_DDL_v1.3.sql</b></li>
</ul>

<h3>Database scheme</h3>

<p>Descriptions:</p>

<p>Lev Goryachev 2022</p>
