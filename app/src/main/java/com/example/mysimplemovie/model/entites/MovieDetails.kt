package com.example.mysimplemovie.model.entites

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieDetails(
    val movie: Movie? = getDefaultMovie(),
    val overview: String? = "Default Overview",
    val voteAverage: Number? = 0.0,
    val releaseDate: String? = "2000-01-01",
    val posterPath: String? = "/zpH4yEqOJOReykVcSQYA1A258SQ.jpg"
) : Parcelable

fun getDefaultMovie() = Movie(634649, "Человек-паук: Нет пути домой")
fun getDefaultDetails() = MovieDetails(getDefaultMovie(), posterPath = "/zpH4yEqOJOReykVcSQYA1A258SQ.jpg")

fun getList1() = listOf(
    MovieDetails(
        Movie(555, "Человек-паук: Нет пути домой"),
        "Мистерио удаётся выяснить истинную личность Человека-паука. С этого момента жизнь Питера Паркера становится невыносимой. Если ранее он мог успешно переключаться между своими амплуа, то сейчас это сделать невозможно. Переворачивается с ног на голову не только жизнь Человека-пауку, но и репутация. Понимая, что так жить невозможно, главный герой фильма «Человек-паук: Нет пути домой» принимает решение обратиться за помощью к своему давнему знакомому Стивену Стрэнджу. Питер Паркер надеется, что с помощью магии он сможет восстановить его анонимность. Стрэндж соглашается помочь.Мистерио удаётся выяснить истинную личность Человека-паука. С этого момента жизнь Питера Паркера становится невыносимой. Если ранее он мог успешно переключаться между своими амплуа, то сейчас это сделать невозможно. Переворачивается с ног на голову не только жизнь Человека-пауку, но и репутация. Понимая, что так жить невозможно, главный герой фильма «Человек-паук: Нет пути домой» принимает решение обратиться за помощью к своему давнему знакомому Стивену Стрэнджу. Питер Паркер надеется, что с помощью магии он сможет восстановить его анонимность. Стрэндж соглашается помочь.Мистерио удаётся выяснить истинную личность Человека-паука. С этого момента жизнь Питера Паркера становится невыносимой. Если ранее он мог успешно переключаться между своими амплуа, то сейчас это сделать невозможно. Переворачивается с ног на голову не только жизнь Человека-пауку, но и репутация. Понимая, что так жить невозможно, главный герой фильма «Человек-паук: Нет пути домой» принимает решение обратиться за помощью к своему давнему знакомому Стивену Стрэнджу. Питер Паркер надеется, что с помощью магии он сможет восстановить его анонимность. Стрэндж соглашается помочь.",
        8.2,
        "2021-12-15",
        "/zpH4yEqOJOReykVcSQYA1A258SQ.jpg"
    ),
    MovieDetails(
        Movie(666, "Вечные"),
        "Много тысячелетий назад с планеты Олимпия на Землю была отправлена группа сверхлюдей, обладающих суперспособностями, — Вечные. С доисторических времён они защищали человечество от нападений ужасных чудовищ девиантов, но любое другое вмешательство в развитие цивилизации им было запрещено. Начало XXI века. Уже несколько столетий прошло с тех пор, как был уничтожен последний девиант, когда после странного землетрясения внезапно объявляется новый монстр. Теперь живущим в разных уголках планеты Вечным снова придётся сплотить силы, чтобы противостоять новой угрозе.",
        7.2,
        "2021-11-03",
        "/5TVmoyE8ufmxyf7wW8oSuPlKJnN.jpg"
    ),
    MovieDetails(
        Movie(777, "Шан-Чи и легенда десяти колец"),
        "Мастеру боевых искусств Шан-Чи предстоит противостоять призракам из собственного прошлого, по мере того как его втягивают в паутину интриг таинственной организации «Десять колец».",
        7.7,
        "2021-09-01",
        "/hn0B1OFQRQnzr0LeLkaUbJxoiol.jpg"
    ),
    MovieDetails(
        Movie(888, "Чёрная вдова"),
        "Наташе Романофф предстоит лицом к лицу встретиться со своим прошлым. Чёрной Вдове придется вспомнить о том, что было в её жизни задолго до присоединения к команде Мстителей, и узнать об опасном заговоре, в который оказываются втянуты её старые знакомые — Елена, Алексей (известный как Красный Страж) и Мелина.",
        7.5,
        "2021-07-07",
        "/rnvUqrCs8AUpz2n7tgGF6RNatdW.jpg"
    ),
    MovieDetails(
        Movie(999, "Человек-паук: Вдали от дома"),
        "Питер Паркер вместе с одноклассниками отправляется на летние каникулы в Европу. Однако отдохнуть приятелям вряд ли удастся — по прибытии в Венецию группа попадает в эпицентр сражения. Некое существо, состоящее из воды, появляется из ниоткуда и начинает крушить всё на своём пути, и теперь Питеру придётся спасать европейские архитектурные памятники вместе с загадочным супергероем Мистерио.",
        7.5,
        "2019-06-28",
        "/5NNAHfyG4Ttu6ED9PpVe9mrRthj.jpg"
    ),
)