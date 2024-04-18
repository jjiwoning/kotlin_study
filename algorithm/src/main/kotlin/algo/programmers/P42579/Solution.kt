package algo.programmers.P42579

import java.util.*

class Solution {

    fun solution(genres: Array<String>, plays: IntArray): IntArray {
        val answer = mutableListOf<Int>()

        val genresMapper = mutableMapOf<String, Genre>()
        val albums = TreeMap<String, TreeSet<Play>>()

        for (id in genres.indices) {
            val genre = genresMapper.getOrDefault(genres[id], Genre(genres[id], 0))
            val play = albums.getOrDefault(genres[id], TreeSet<Play>
            { o1, o2 ->
                if (o2.count == o1.count) {
                    return@TreeSet o1.id - o2.id
                }
                return@TreeSet o2.count - o1.count
            })

            genre.addCount(plays[id])
            genresMapper[genres[id]] = genre

            play.add(Play(id, plays[id]))
            albums[genres[id]] = play
        }

        val result = genresMapper.values.sortedBy { -it.count }

        for (genre in result) {
            var count = 0
            for (album in albums[genre.name]!!) {
                if (count == 2) {
                    break
                }
                answer.add(album.id)
                count++
            }
        }

        return answer.toIntArray()
    }
}

data class Genre(
    private val _name: String,
    private var _count: Int
) {

    val name: String
        get() = _name

    val count: Int
        get() = _count

    fun addCount(num: Int) {
        this._count += num
    }
}

data class Play(
    private val _id: Int,
    private val _count: Int
) {
    val id: Int
        get() = _id

    val count: Int
        get() = _count
}
