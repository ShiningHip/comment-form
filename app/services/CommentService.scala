package hip.shining.form
package services

import models.CommentResponse
import repositories.CommentRepository

import scala.concurrent.Future

class CommentService(
  commentRepository: CommentRepository
) {
  def getComment(userId: String): Future[CommentResponse] = ???
}
