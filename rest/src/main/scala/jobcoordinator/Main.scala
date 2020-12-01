package jobcoordinator

import akka.actor.typed.javadsl.Behaviors
import akka.actor.typed.{ActorSystem, Behavior}
import jobcoordinator.TaskOneWorker.TaskWorkerCommand


object Main extends App {
  println("hello")
  val actor = ActorSystem[TaskSchedulerMessage](TaskScheduler(), "task-scheduler")
  actor ! TaskOneRequest("a-task-id")

}
