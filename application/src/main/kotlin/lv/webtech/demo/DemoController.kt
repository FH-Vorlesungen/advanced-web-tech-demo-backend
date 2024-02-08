package lv.webtech.demo

import lv.webtech.demo.openapi.api.PostsApi
import lv.webtech.demo.openapi.model.CreatePostRequest
import lv.webtech.demo.openapi.model.Post
import lv.webtech.demo.repository.PostsRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/posts")
class DemoController(val postsRepository: PostsRepository) : PostsApi {


    @GetMapping
    override fun listPosts(limit: Int?): ResponseEntity<MutableList<Post>> {
        val posts = postsRepository.findAll().toList().stream().map { x ->
            val post = Post()
            post.id(x.id)
            post.title(x.title)
            post.message(x.message)
        }.toList()
        return ResponseEntity.ok(posts)
    }
    @PostMapping
    override fun createPosts(createPostRequest: CreatePostRequest): ResponseEntity<Void> {
        val createPost = lv.webtech.demo.entity.Post(null, createPostRequest.title, createPostRequest.message)
        postsRepository.save(createPost)
        return ResponseEntity.ok().build()
    }
}