package controllers

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

  def post(userId: String, comment: String): Action[AnyContent] =
    Action { implicit request: Request[AnyContent] =>
      Ok("healthy")
    }
}
