# TestTaskFoodDelivery

#### **Тестовое задание (https://docs.google.com/document/d/1uNi1DMM4UtWv-1NQLoduCHiJajLrVO3d/edit)**
#### **Cсылка на видео с примером работы приложения (https://drive.google.com/file/d/1miJtteRIsr83M4WuWg0R90nyjbLo9DIt/view?usp=drive_link)**
#### **Cсылка на собранный apk (https://github.com/SR-rodi/TestTaskFoodDelivery/blob/main/app-debug.apk)**

#### Стек технологий
- Многомодульность
- MVVM
- Kotlin Coroutines
- Flow
- Retroffit 2
- OkHttp
- Room + ksp
- Navigation componen
- Koin
- Adapter Delegate (custom: https://github.com/SR-rodi/AdapterDelegate)
- Fused Location Provider Client
- Geocoder
- Glide

Описание:
 - при старте приложение определяется координаты пользователя при помощи Fused Location Provider Client;
 - при помощи Geocoder получаем имя города в котором находится пользователь;
 - запросы в сеть осуществляем при помощи Retrofit + okhhtp 
 - ui списков рисуется при помощи самописных адаптер делегатов(ссылка выше)
 - для динамического получение информации о продуктах в корзине ответ от Room получаем в виде Flow

<p float="left">
<img src="https://github.com/SR-rodi/TestTaskFoodDelivery/blob/main/screen/home_screen.jpg" width=20% height=20%>
<img src="https://github.com/SR-rodi/TestTaskFoodDelivery/blob/main/screen/cart_screen.jpg" width=20% height=20%>
</p>

<p float="left">
<img src="https://github.com/SR-rodi/TestTaskFoodDelivery/blob/main/screen/dishes_screen_1.jpg" width=20% height=20%>
<img src="https://github.com/SR-rodi/TestTaskFoodDelivery/blob/main/screen/dishes_screen_2.jpg" width=20% height=20%>
</p>





