## Описание Проекта

Алгоритм работы приложения:
В методе main класса Main должны происходить следующие операции:
1. Создание таблицы User(ов)
2. Добавление 4 User(ов) в таблицу с данными на свой выбор. После каждого добавления должен быть вывод в консоль ( User с именем – name добавлен в базу данных )
3. Получение всех User из базы и вывод в консоль ( должен быть переопределен toString в классе User)
4. Очистка таблицы User(ов)
5. Удаление таблицы

### Информация "для себя" о конфикурации

**для распечатки в консоль, и для форматирования**

"hibernate.show_sql","true"

"hibernate.format_sql","true"

**специальное свойство для создания таблиц из Entity, является гибридным, ему можно задать следующие свойства:**
         
* create - создание таблиц

* create-drop - будет создавать, и удалять таблицы после завершения сеанса
         
* update - обновление существующей схемы данных

* validate - проверка базы данных

* none - ни чего не делать
        
"hibernate.hbm2ddl.auto", "update"

**Свойства аннотации @Column**

name — определяет имя столбца в базе данных. Если не указано, то по умолчанию имя столбца получается из имени поля.

nullable — определяет, может ли столбец содержать нулевые значения. По умолчанию столбцы являются nullable.

unique — указывает, должен ли столбец содержать уникальные значения.

length — устанавливает максимальную длину столбца для строковых полей.

precision и scale — используются для полей с десятичными значениями, чтобы указать точность и масштаб столбца.

insertable и updatable — контролируют, должен ли столбец включаться во время операций INSERT и UPDATE.


### Пример конфигурации для MySQL xml файла 

<property name="hibernate.dialect">org.hibernate.dialect.MySQLDialect</property>

<property name="connection.driver_class">com.mysql.cj.jdbc.Driver</property><!--lib.mysql-connector-j-8.3.0-->

<property name="connection.url">jdbc:mysql://localhost:3306/mysql</property>

<property name="connection.username">root</property>

<property name="connection.password">2381012</property>

<property name="hibernate.show_sql ">true</property>

<property name="jm.task.core.jdbc.util">update</property>

<mapping class="jm.task.core.jdbc.util.Util"/>

