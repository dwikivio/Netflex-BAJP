package com.stikubank.mynetflex.utils

import com.stikubank.mynetflex.data.source.local.entity.NetflexData
import com.stikubank.mynetflex.data.source.remote.response.MovieResponse
import com.stikubank.mynetflex.data.source.remote.response.TvshowResponse

object DataDummy {

    fun generateMovies(): List<NetflexData>{

        val movies = ArrayList<NetflexData>()

        movies.add(
            NetflexData(
            "NMv01",
                "movie",
            "Bohemian Rhapsody (2018)",
            "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/lHu1wtNaczFPGFDTrjCSzeLPTKN.jpg"
        )
        )
        movies.add(
            NetflexData(
            "NMv02",
            "movie",
            "Cold Pursuit (2019)",
            "The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution.",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/hXgmWPd1SuujRZ4QnKLzrj79PAw.jpg"
        )
        )
        movies.add(
            NetflexData(
            "NMv03",
                "movie",
            "Spider-Man: Into the Spider-Verse (2018)",
            "Miles Morales is juggling his life between being a high school student and being a spider-man. When Wilson \"Kingpin\" Fisk uses a super collider, others from across the Spider-Verse are transported to this dimension.",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/iiZZdoQBEYBv6id8su7ImL0oCbD.jpg"
        )
        )
        movies.add(
            NetflexData(
            "NMv04",
                "movie",
            "Robin Hood (2018)",
            "A war-hardened Crusader and his Moorish commander mount an audacious revolt against the corrupt English crown.",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/AiRfixFcfTkNbn2A73qVJPlpkUo.jpg"
        )
        )
        movies.add(
            NetflexData(
            "NMv05",
                "movie",
            "Wreck-It Ralph (2012)",
            "Wreck-It Ralph is the 9-foot-tall, 643-pound villain of an arcade video game named Fix-It Felix Jr., in which the game's titular hero fixes buildings that Ralph destroys. Wanting to prove he can be a good guy and not just a villain, Ralph escapes his game and lands in Hero's Duty, a first-person shooter where he helps the game's hero battle against alien invaders. He later enters Sugar Rush, a kart racing game set on tracks made of candies, cookies and other sweets. There, Ralph meets Vanellope von Schweetz who has learned that her game is faced with a dire threat that could affect the entire arcade, and one that Ralph may have inadvertently started.",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/zWoIgZ7mgmPkaZjG0102BSKFIqQ.jpg"
        )
        )
        movies.add(
            NetflexData(
            "NMv06",
                "movie",
            "Master Z: Ip Man Legacy (2018)",
            "Following his defeat by Master Ip, Cheung Tin Chi tries to make a life with his young son in Hong Kong, waiting tables at a bar that caters to expats. But it's not long before the mix of foreigners, money, and triad leaders draw him once again to the fight.",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/6VxEvOF7QDovsG6ro9OVyjH07LF.jpg"
        )
        )
        movies.add(
            NetflexData(
            "NMv07",
                "movie",
            "Avengers: Infinity War (2018)",
            "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/7WsyChQLEftFiDOVTGkv3hFpyyt.jpg",
        )
        )
        movies.add(
            NetflexData(
            "NMv08",
                "movie",
            "How to Train Your Dragon: The Hidden World (2019)",
            "As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless’ discovery of an untamed, elusive mate draws the Night Fury away. When danger mounts at home and Hiccup’s reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind.",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/xvx4Yhf0DVH8G4LzNISpMfFBDy2.jpg"
        )
        )
        movies.add(
            NetflexData(
            "NMv09",
                "movie",
            "Creed II (2018)",
            "Between personal obligations and training for his next big fight against an opponent with ties to his family's past, Adonis Creed is up against the challenge of his life.",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/v3QyboWRoA4O9RbcsqH8tJMe8EB.jpg"
        )
        )
        movies.add(
            NetflexData(
            "NMv10",
                "movie",
            "Serenity (2019)",
            "The quiet life of Baker Dill, a fishing boat captain who lives on the isolated Plymouth Island, where he spends his days obsessed with capturing an elusive tuna while fighting his personal demons, is interrupted when someone from his past comes to him searching for help.",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/hgWAcic93phg4DOuQ8NrsgQWiqu.jpg"
        )
        )

    return movies
    }

    fun generateTvShows(): List<NetflexData>{

        val shows = ArrayList<NetflexData>()

        shows.add(
            NetflexData(
            "NTv01",
                "tvshow",
            "The Simpsons (1989)",
            "Set in Springfield, the average American town, the show focuses on the antics and everyday adventures of the Simpson family; Homer, Marge, Bart, Lisa and Maggie, as well as a virtual cast of thousands. Since the beginning, the series has been a pop culture icon, attracting hundreds of celebrities to guest star. The show has also made name for itself in its fearless satirical take on politics, media and American life in general.",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/2IWouZK4gkgHhJa3oyYuSWfSqbG.jpg"
        )
        )
        shows.add(
            NetflexData(
            "NTv02",
                "tvshow",
            "Dragon Ball (1986)",
            "Long ago in the mountains, a fighting master known as Gohan discovered a strange boy whom he named Goku. Gohan raised him and trained Goku in martial arts until he died. The young and very strong boy was on his own, but easily managed. Then one day, Goku met a teenage girl named Bulma, whose search for the mystical Dragon Balls brought her to Goku's home. Together, they set off to find all seven and to grant her wish.",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/tZ0jXOeYBWPZ0OWzUhTlYvMF7YR.jpg"
        )
        )
        shows.add(
            NetflexData(
            "NTv03",
                "tvshow",
            "Naruto Shippūden (2007)",
            "Naruto Shippuuden is the continuation of the original animated TV series Naruto.The story revolves around an older and slightly more matured Uzumaki Naruto and his quest to save his friend Uchiha Sasuke from the grips of the snake-like Shinobi, Orochimaru. After 2 and a half years Naruto finally returns to his village of Konoha, and sets about putting his ambitions to work, though it will not be easy, as He has amassed a few (more dangerous) enemies, in the likes of the shinobi organization; Akatsuki.",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/zAYRe2bJxpWTVrwwmBc00VFkAf4.jpg",
        )
        )
        shows.add(
            NetflexData(
            "NTv04",
                "tvshow",
            "Riverdale (2017)",
            "Set in the present, the series offers a bold, subversive take on Archie, Betty, Veronica and their friends, exploring the surreality of small-town life, the darkness and weirdness bubbling beneath Riverdale’s wholesome facade.",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/wRbjVBdDo5qHAEOVYoMWpM58FSA.jpg"
        )
        )
        shows.add(
            NetflexData(
            "NTv05",
                "tvshow",
            "NCIS (2003)",
            "From murder and espionage to terrorism and stolen submarines, a team of special agents investigates any crime that has a shred of evidence connected to Navy and Marine Corps personnel, regardless of rank or position.",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/fi8EvaWtL5CvoielOjjVvTr7ux3.jpg"
        )
        )
        shows.add(
            NetflexData(
            "NTv06",
                "tvshow",
            "Doom Patrol (2019)",
            "The Doom Patrol’s members each suffered horrible accidents that gave them superhuman abilities — but also left them scarred and disfigured. Traumatized and downtrodden, the team found purpose through The Chief, who brought them together to investigate the weirdest phenomena in existence — and to protect Earth from what they find.",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/drlfSCIlMKrEeMPhi8pqY4xGxj.jpg"
        )
        )
        shows.add(
            NetflexData(
            "NTv07",
                "tvshow",
            "The Flash (2014)",
            "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg"
        )
        )
        shows.add(
            NetflexData(
            "NTv08",
                "tvshow",
            "The Walking Dead (2010)",
            "Sheriff's deputy Rick Grimes awakens from a coma to find a post-apocalyptic world dominated by flesh-eating zombies. He sets out to find his family and encounters many other survivors along the way.",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/yTNP9UOdUbGBUZ7SSVng75IwAaY.jpg"
        )
        )
        shows.add(
            NetflexData(
            "NTv09",
                "tvshow",
            "Marvel's Iron Fist (2017)",
            "Danny Rand resurfaces 15 years after being presumed dead. Now, with the power of the Iron Fist, he seeks to reclaim his past and fulfill his destiny.",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/4YoJ9X8nPtuKOMZlg6a4WCm4RHz.jpg"
        )
        )
        shows.add(
            NetflexData(
            "NTv10",
                "tvshow",
            "Family Guy (1999)",
            "Sick, twisted, politically incorrect and Freakin' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he's not very bright but has a passion for movies). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues.",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/eWWCRjBfLyePh2tfZdvNcIvKSJe.jpg"
        )
        )
        return shows
    }

    fun generateRemoteDummyMovies(): List<MovieResponse>{
        val movies = ArrayList<MovieResponse>()

        movies.add(
                MovieResponse(
                        "NMv01",
                    "movie",
                        "Bohemian Rhapsody (2018)",
                        "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
                        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/lHu1wtNaczFPGFDTrjCSzeLPTKN.jpg"
                )
        )
        movies.add(
                MovieResponse(
                        "NMv02",
                    "movie",
                        "Cold Pursuit (2019)",
                        "The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution.",
                        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/hXgmWPd1SuujRZ4QnKLzrj79PAw.jpg"
                )
        )
        movies.add(
                MovieResponse(
                        "NMv03",
                    "movie",
                        "Spider-Man: Into the Spider-Verse (2018)",
                        "Miles Morales is juggling his life between being a high school student and being a spider-man. When Wilson \"Kingpin\" Fisk uses a super collider, others from across the Spider-Verse are transported to this dimension.",
                        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/iiZZdoQBEYBv6id8su7ImL0oCbD.jpg"
                )
        )
        movies.add(
                MovieResponse(
                        "NMv04",
                        "Robin Hood (2018)",
                    "movie",
                        "A war-hardened Crusader and his Moorish commander mount an audacious revolt against the corrupt English crown.",
                        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/AiRfixFcfTkNbn2A73qVJPlpkUo.jpg"
                )
        )
        movies.add(
                MovieResponse(
                        "NMv05",
                    "movie",
                        "Wreck-It Ralph (2012)",
                        "Wreck-It Ralph is the 9-foot-tall, 643-pound villain of an arcade video game named Fix-It Felix Jr., in which the game's titular hero fixes buildings that Ralph destroys. Wanting to prove he can be a good guy and not just a villain, Ralph escapes his game and lands in Hero's Duty, a first-person shooter where he helps the game's hero battle against alien invaders. He later enters Sugar Rush, a kart racing game set on tracks made of candies, cookies and other sweets. There, Ralph meets Vanellope von Schweetz who has learned that her game is faced with a dire threat that could affect the entire arcade, and one that Ralph may have inadvertently started.",
                        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/zWoIgZ7mgmPkaZjG0102BSKFIqQ.jpg"
                )
        )
        movies.add(
                MovieResponse(
                        "NMv06",
                    "movie",
                        "Master Z: Ip Man Legacy (2018)",
                        "Following his defeat by Master Ip, Cheung Tin Chi tries to make a life with his young son in Hong Kong, waiting tables at a bar that caters to expats. But it's not long before the mix of foreigners, money, and triad leaders draw him once again to the fight.",
                        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/6VxEvOF7QDovsG6ro9OVyjH07LF.jpg"
                )
        )
        movies.add(
                MovieResponse(
                        "NMv07",
                    "movie",
                        "Avengers: Infinity War (2018)",
                        "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
                        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/7WsyChQLEftFiDOVTGkv3hFpyyt.jpg",
                )
        )
        movies.add(
                MovieResponse(
                        "NMv08",
                    "movie",
                        "How to Train Your Dragon: The Hidden World (2019)",
                        "As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless’ discovery of an untamed, elusive mate draws the Night Fury away. When danger mounts at home and Hiccup’s reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind.",
                        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/xvx4Yhf0DVH8G4LzNISpMfFBDy2.jpg"
                )
        )
        movies.add(
                MovieResponse(
                        "NMv09",
                    "movie",
                        "Creed II (2018)",
                        "Between personal obligations and training for his next big fight against an opponent with ties to his family's past, Adonis Creed is up against the challenge of his life.",
                        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/v3QyboWRoA4O9RbcsqH8tJMe8EB.jpg"
                )
        )
        movies.add(
                MovieResponse(
                        "NMv10",
                    "movie",
                        "Serenity (2019)",
                        "The quiet life of Baker Dill, a fishing boat captain who lives on the isolated Plymouth Island, where he spends his days obsessed with capturing an elusive tuna while fighting his personal demons, is interrupted when someone from his past comes to him searching for help.",
                        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/hgWAcic93phg4DOuQ8NrsgQWiqu.jpg"
                )
        )

        return movies
    }

    fun generateRemoteDummyShows(): List<TvshowResponse>{

        val shows = ArrayList<TvshowResponse>()

        shows.add(
                TvshowResponse(
                        "NTv01",
                    "tvshow",
                        "The Simpsons (1989)",
                        "Set in Springfield, the average American town, the show focuses on the antics and everyday adventures of the Simpson family; Homer, Marge, Bart, Lisa and Maggie, as well as a virtual cast of thousands. Since the beginning, the series has been a pop culture icon, attracting hundreds of celebrities to guest star. The show has also made name for itself in its fearless satirical take on politics, media and American life in general.",
                        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/2IWouZK4gkgHhJa3oyYuSWfSqbG.jpg"
                )
        )
        shows.add(
                TvshowResponse(
                        "NTv02",
                    "tvshow",
                        "Dragon Ball (1986)",
                        "Long ago in the mountains, a fighting master known as Gohan discovered a strange boy whom he named Goku. Gohan raised him and trained Goku in martial arts until he died. The young and very strong boy was on his own, but easily managed. Then one day, Goku met a teenage girl named Bulma, whose search for the mystical Dragon Balls brought her to Goku's home. Together, they set off to find all seven and to grant her wish.",
                        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/tZ0jXOeYBWPZ0OWzUhTlYvMF7YR.jpg"
                )
        )
        shows.add(
                TvshowResponse(
                        "NTv03",
                    "tvshow",
                        "Naruto Shippūden (2007)",
                        "Naruto Shippuuden is the continuation of the original animated TV series Naruto.The story revolves around an older and slightly more matured Uzumaki Naruto and his quest to save his friend Uchiha Sasuke from the grips of the snake-like Shinobi, Orochimaru. After 2 and a half years Naruto finally returns to his village of Konoha, and sets about putting his ambitions to work, though it will not be easy, as He has amassed a few (more dangerous) enemies, in the likes of the shinobi organization; Akatsuki.",
                        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/zAYRe2bJxpWTVrwwmBc00VFkAf4.jpg",
                )
        )
        shows.add(
                TvshowResponse(
                        "NTv04",
                    "tvshow",
                        "Riverdale (2017)",
                        "Set in the present, the series offers a bold, subversive take on Archie, Betty, Veronica and their friends, exploring the surreality of small-town life, the darkness and weirdness bubbling beneath Riverdale’s wholesome facade.",
                        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/wRbjVBdDo5qHAEOVYoMWpM58FSA.jpg"
                )
        )
        shows.add(
                TvshowResponse(
                        "NTv05",
                    "tvshow",
                        "NCIS (2003)",
                        "From murder and espionage to terrorism and stolen submarines, a team of special agents investigates any crime that has a shred of evidence connected to Navy and Marine Corps personnel, regardless of rank or position.",
                        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/fi8EvaWtL5CvoielOjjVvTr7ux3.jpg"
                )
        )
        shows.add(
                TvshowResponse(
                        "NTv06",
                    "tvshow",
                        "Doom Patrol (2019)",
                        "The Doom Patrol’s members each suffered horrible accidents that gave them superhuman abilities — but also left them scarred and disfigured. Traumatized and downtrodden, the team found purpose through The Chief, who brought them together to investigate the weirdest phenomena in existence — and to protect Earth from what they find.",
                        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/drlfSCIlMKrEeMPhi8pqY4xGxj.jpg"
                )
        )
        shows.add(
                TvshowResponse(
                        "NTv07",
                    "tvshow",
                        "The Flash (2014)",
                        "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg"
                )
        )
        shows.add(
                TvshowResponse(
                        "NTv08",
                    "tvshow",
                        "The Walking Dead (2010)",
                        "Sheriff's deputy Rick Grimes awakens from a coma to find a post-apocalyptic world dominated by flesh-eating zombies. He sets out to find his family and encounters many other survivors along the way.",
                        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/yTNP9UOdUbGBUZ7SSVng75IwAaY.jpg"
                )
        )
        shows.add(
                TvshowResponse(
                        "NTv09",
                    "tvshow",
                        "Marvel's Iron Fist (2017)",
                        "Danny Rand resurfaces 15 years after being presumed dead. Now, with the power of the Iron Fist, he seeks to reclaim his past and fulfill his destiny.",
                        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/4YoJ9X8nPtuKOMZlg6a4WCm4RHz.jpg"
                )
        )
        shows.add(
                TvshowResponse(
                        "NTv10",
                    "tvshow",
                        "Family Guy (1999)",
                        "Sick, twisted, politically incorrect and Freakin' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he's not very bright but has a passion for movies). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues.",
                        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/eWWCRjBfLyePh2tfZdvNcIvKSJe.jpg"
                )
        )
        return shows
    }
}