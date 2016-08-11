package controllers

import javax.inject.Inject

import play.api.i18n.{MessagesApi, I18nSupport}
import play.api.mvc._

class HomeController @Inject()(val messagesApi: MessagesApi) extends Controller with I18nSupport {

  def index = Action {
    Redirect(controllers.routes.HomeController.home)
  }

  def home = Action {
    Ok(views.html.index())
  }

}
