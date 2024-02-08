package lv.webtech.demo.entity

import jakarta.persistence.*
import org.hibernate.annotations.GenericGenerator
import java.util.*

@Entity
@Table(name = "posts")
class Post(
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(columnDefinition = "uuid") val id: UUID? = null,
    @Column(name = "title") val title: String,
    @Column(name = "message") val message: String
) {

}
