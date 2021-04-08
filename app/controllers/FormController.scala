package controllers

import models.FormRequest
import play.api.libs.json.{JsError, JsSuccess}
import play.api.mvc._

import javax.inject.{Inject, Singleton}

@Singleton
class FormController @Inject() (
  cc: ControllerComponents
) extends AbstractController(cc) {
  def get: Action[AnyContent] =
    Action { implicit request: Request[AnyContent] =>
      Ok("healthy")
    }

  def post: Action[AnyContent] =
    Action { implicit request: Request[AnyContent] =>
      val parsed = request.body.asJson
        .map { contents =>
          contents.validate[FormRequest]
        }
        .map {
          case JsSuccess(value, _) => Right(value)
          case JsError(errors)     => Left(errors)
        }
        .get
      parsed match {
        case Left(throwables) =>
          val errors = throwables.flatMap {
            case (_, errors) => errors
          }.mkString
          BadRequest(errors)
        case Right(values: FormRequest) => Ok(values.userId)
      }
    }
}
