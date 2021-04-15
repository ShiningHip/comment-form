package hip.shining.form
package models

import play.api.libs.json.{Json, OWrites, Reads}

case class FormRequest(
  userId: String,
  comment: String
)
object FormRequest {
  implicit def jsonWrite: OWrites[FormRequest] = Json.writes[FormRequest]
  implicit def jsonRead: Reads[FormRequest]    = Json.reads[FormRequest]
}
