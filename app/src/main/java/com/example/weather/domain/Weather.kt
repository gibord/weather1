package com.example.weather.domain

data class Weather(
    val city: City = getDefaultCity(),
    val temperature: Int = 10,
    val feelsLike: Int = 25,
)

data class City(
    val name: String,
    val lat: Double,
    val lon: Double,
)

//fun getDefaultCity() = City("Москва", 55.755826, 37.617299900000035)
fun getWorldCities(): List<Weather> {
    return listOf(
        Weather(City("Лондон", 51.508, -0.125), 1, 2),
        Weather(City("Токио", 35.689, 139.691), 3, 4),
        Weather(City("Париж", 48.853, 2.348), 5, 6),
        Weather(City("Берлин", 52.520, 13.404), 7, 8),
        Weather(City("Рим", 41.902, 12.496), 9, 10),
        Weather(City("Минск", 53.904, 27.561), 11, 12),
        Weather(City("Станбул", 41.008, 28.978), 13, 14),
        Weather(City("Вашингтон", 38.907, -77.036), 15, 16),
        Weather(City("Киев", 50.450, 30.523), 17, 18),
        Weather(City("Пекин", 39.904, 116.407), 19, 20)
    )
}
fun getRussianCities(): List<Weather> {
    return listOf(
        Weather(City("Москва", 55.755, 37.617), 1, 2),
        Weather(City("Санкт-Петербург", 59.934, 30.335), 3, 4),
        Weather(City("Новосибирск", 55.008, 82.935), 5, 6),
        Weather(City("Екатеринбург", 56.838, 60.605), 7, 8),
        Weather(City("Нижний новгород", 56.296, 43.936), 9, 10),
        Weather(City("Казань", 55.830, 49.066), 11, 12),
        Weather(City("Челябинск", 55.164, 61.436), 13, 14),
        Weather(City("Омск", 54.988, 73.324), 15, 16),
        Weather(City("Ростов-на-Дону", 47.235, 39.701), 17, 18),
        Weather(City("Уфа", 54.738, 55.972), 19, 20)
    )
}
fun getDefaultCity() = City("Москва", 55.755826, 37.617299900000035)