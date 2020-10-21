class WallService {
    private var posts = emptyArray<Post>()
    private var nextId: Int = 0
    private var comments = emptyArray<Comment>()

    fun add(post: Post): Post {
        posts += post
        //post.id = nextId
        //nextId++
        return posts.last()
    }

    fun update(post: Post): Boolean {
        for (targetPost in posts) {
            if (targetPost.id == post.id) {
                targetPost.text = "some text"
                println("Пост обновлён")
                return true
            }
            break
        }
        println("Не удалось обновить пост")
        return false
    }

    fun createComment(comment: Comment): Boolean {
        for (targetPost in posts) {
            if (targetPost.id == comment.postID) {
                comments += comment
                println("Комментарий добавлен")
                return true
            }
            break
        }
        println("Не удалось создать комментарий")
        throw PostNotFoundException("Не удалось добавить комментарий")
        return false
        }
}