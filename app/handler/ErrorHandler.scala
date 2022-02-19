package handler

import com.google.inject.{Inject, Singleton}
import play.api.http.HttpErrorHandler
import play.api.http.Status.NOT_FOUND
import play.api.libs.json.{JsValue, Json}
import play.api.mvc.Results.{InternalServerError, NotFound}
import play.api.mvc.{RequestHeader, Result}

import scala.concurrent.{ExecutionContext, Future}

@Singleton
class ErrorHandler @Inject()(implicit ec: ExecutionContext) extends HttpErrorHandler {
  def onClientError(request: RequestHeader, statusCode: Int, message: String = "Page not found"): Future[Result] = {
    Future.successful(statusCode).map {
      case NOT_FOUND => NotFound(Json.toJson(ErrorMessage(message)))
    }
  }

  def onServerError(request: RequestHeader, exception: Throwable): Future[Result] = {
    Future.successful(
      InternalServerError("A server error occurred: " + exception.getMessage)
    )
  }


}
