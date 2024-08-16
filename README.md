# Автоматизация тестирования UI + API c использованием REST Assured

## <a>**Задача:**</a>
1. Разработать автотесты на удаление книг из [колекции](https://demoqa.com/books)
    1. Авторизация и добавление книг в коллекцию с помощью API запросов с использованием **REST Assured**
       - Реализовать авторизацию с аннотацией **@WithLogin**
       - Реализовать **Lombok** модели
       - Сформировать спецификации ответов и запросов
    2. Осуществление проверок через UI с использованием **Selenide** + **JUnit5**

2. Подключить **Allure Report**:
- Прописать шаги тестов (step)
- Использовать кастомизированные логи
- Добавить скриншоты, логи и видео после выполнения каждого теста

3. Настроить запуск тестов в **Jenkins**:
- Cделать сборку
- Передать адрес удаленного браузера (**Selenoid**)
- Осуществить возможность выбора браузера и разрешения

4. Добавить уведомления о результатах прохождении автотестов с помощью **Telegram-бота**

## <img alt="Jenkins" height="25" src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/jenkins/jenkins-original.svg" width="25"/></a><a name="Сборка в Jenkins"></a>Сборка в [Jenkins](https://jenkins.autotests.cloud/job/C27-demoqa_api_ozhegov-HW/)</a>

<p align="center">  
<img title="Jenkins" src="images/screenshots/jenkins.png" width="850">  
</p>

## <img alt="Allure" height="25" src="https://github.com/ozhegov/universe_data_ui_tests/blob/main/images/logo/Allure.svg" width="25"/></a><a name="Интеграция с Allure Report"></a>Интеграция с [Allure Report](https://jenkins.autotests.cloud/job/C27-demoqa_api_ozhegov-HW/allure)</a>

### *Основная страница отчёта*

<p align="center">  
<img title="Allure Report" src="images/screenshots/allure.png" width="850">  
</p>  

### *Тест-кейсы*

<p align="center">  
<img title="Allure Test Cases" src="images/screenshots/allure_tc.png" width="850">  
</p>

## <img alt="Telegram" height="25" src="https://upload.wikimedia.org/wikipedia/commons/8/83/Telegram_2019_Logo.svg" width="25"/></a><a name="Уведомления в Telegram при помощи бота"></a>Уведомления в Telegram при помощи бота</a>
<p align="center">  
<img title="Telegram Notifications" src="images/screenshots/telegram.png" width="450">  
</p>
