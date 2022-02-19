package handler

import play.api.libs.functional.syntax.unlift
import play.api.libs.json.{JsPath, Reads, Writes}

case class ErrorMessage(message: String)

object ErrorMessage {
  implicit val reads: Reads[ErrorMessage] = (JsPath \ "message").read[String].map(ErrorMessage.apply)
  implicit val writes: Writes[ErrorMessage] = (JsPath \ "message").write[String].contramap(unlift(ErrorMessage.unapply))
}
