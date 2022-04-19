package controllers

import com.google.inject.Singleton
import play.api.mvc.{AbstractController, ControllerComponents}
import services.Counter

import javax.inject.Inject
import scala.concurrent.duration.{DurationInt, FiniteDuration}

@Singleton
class IntervalController @Inject() (cc: ControllerComponents,
  counter: Counter) extends AbstractController(cc) {

  @volatile var interval: FiniteDuration = 0.seconds

  def setupInterval(seconds: Int) = {
    interval = seconds.seconds
    Action(Ok(s"yoy! You have new interval of $seconds seconds set!"))
  }

  def getInterval = Action(Ok(interval.toString()))
}
