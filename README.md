# FR-Project
UPD:
Добавил DTO, теперь все данный отбражаются корректно( кроме http://localhost:8080/api/interviewee/1)
Добавил public.sql,
В Dto использовал Lombok



Для разворачивания данного приложения необходимо просто клонировать мой репозиторий на ваш компьютер, также желательно использовать БД PostgreSQL

Документация Api(често говоря, первый раз её пишу) 

- авторизация и аутентификации в системе нужно пройти по сслыке: http://localhost:8080/login
 
Для добавления опроса переходим по http://localhost:8080/api/poll и пишем опрос, который хотим создать. 
Для изменения опроса переходим по http://localhost:8080/api/poll и сначала пишем id опроса, который хотим изменить и меняем его данный 
Для удаления опросов переходим по http://localhost:8080/api//poll/{id} и вместо id указывам номкр опроса, котрый хотим удалить


Для добавления вопроса в опросе переходим http://localhost:8080/api/question и заполняем все поля вопроса (id, type, id опроса)
Для изменения вопроса в опросе переходим http://localhost:8080/api/question и изменяем все поля вопроса (id, type, id опроса)
Для удаления вопросов в  опросе переходим http://localhost:8080/api/poll/{poll_id}/question/{id} и вместо poll_id пишем номер опроса, из которого хотим удалить вопрос, а потом вместо id пишем номер вопроса, который хотим удалить.


Недочеты моего проекта в силу моего скромного опыта(все эти недочеты я могу исправить, но я считаю, что и так просрочил данное мне время в 3-4 часа(я просидел над проектом 6-7 часов) и считаю, что с моей стороны будет очень нагло тратить еще больше времени на исправления):
Нужно добавть dto для более правильного отображения и передачи данных(без dto выводится очень много дубликатов).
Методы persist и merge можно заменить на просто merge, но я реализовал их отдельно, чтоб Admin случайно не изменил опрос или вопрос, хотя в merge можно просто указать новый id и создасться новый опрос или вопрос, но я решил пойти таким более длиным путем, мне он показался безопаснее для Admin-а.
Я бы лучше настроил SecuriryConfig, но над проектом и так работал больше разрешенного мне срока и решил, что пусть лучше будет так.
Изначально я реализовавыл хранение ролей, логинов и паролей в БД, он наткнулся на ряд ошибок, на которым потратил время, и следовательно затянул разработку, поэтому решил реалитзовать авторизацию и аутентификацию в памяти копьютера, зато работает)).    
Стоило заменить строчки кода с геттерами, сеттерами и конструкторами на аннотации @Getter @Setter @NoArgsConsructor @AllArgsConstractor. 
Нужно было добавить data.sql и public.sql
