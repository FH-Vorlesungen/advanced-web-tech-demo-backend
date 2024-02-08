package lv.webtech.demo.repository

import lv.webtech.demo.entity.Post
import org.springframework.data.repository.CrudRepository
import java.util.UUID
interface PostsRepository: CrudRepository<Post,UUID> {
}