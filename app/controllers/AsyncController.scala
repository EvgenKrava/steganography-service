package controllers

import play.api.mvc._

import javax.inject._
import scala.concurrent.{ExecutionContext, Future}

@Singleton
class AsyncController @Inject()(cc: ControllerComponents)(implicit exec: ExecutionContext) extends AbstractController(cc) {

  /**
   * Health check endpoint
   */
  def check: Action[AnyContent] = Action.async {
    Future.successful(Ok)
  }

}
