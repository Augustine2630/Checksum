# Checksum
1. Имеется эндпоинт по проверке хешей
<img width="1090" alt="image" src="https://user-images.githubusercontent.com/84286104/218830496-996b77d5-5844-4a3f-a6c3-d1975c07c7a7.png">
В нем пользователь заливает файл и заранее подготовленный хеш. Далее производится вычисление по MD-5 и метод возвращает: пользовательский хеш, посчитанный хеш и бул значение после сравнения.
<img width="463" alt="image" src="https://user-images.githubusercontent.com/84286104/218831194-1c64a4f5-e757-4538-9cce-e07635253ab4.png">

2. Модуль Spring Security в цепочке конфигураций запрещает доступ к эндпоинтам пока не будет произведена авторизация. 
<img width="675" alt="image" src="https://user-images.githubusercontent.com/84286104/218831097-1738bed1-00f7-4232-b6dc-4d6106e3bce3.png">

3. Настроен Swagger UI
<img width="964" alt="image" src="https://user-images.githubusercontent.com/84286104/218831406-1106e687-326c-4394-9200-e13dca7f4f3f.png">
