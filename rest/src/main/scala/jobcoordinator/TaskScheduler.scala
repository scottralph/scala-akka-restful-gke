package jobcoordinator

import akka.actor.typed.Behavior
import akka.actor.typed.javadsl.{AbstractBehavior, ActorContext, BehaviorBuilder, Behaviors, Receive}
import jobcoordinator.TaskOneWorker.Start


sealed trait TaskSchedulerMessage;
case class TaskOneRequest(taskId: String) extends TaskSchedulerMessage
case class TaskTwoRequest(taskId: String) extends TaskSchedulerMessage

case class TaskStartedResponse(taskId: String) extends TaskSchedulerMessage
case class TaskCompletedResponse(taskId: String) extends TaskSchedulerMessage


object TaskScheduler {
  def apply() : Behavior[TaskSchedulerMessage] =
    Behaviors.setup[TaskSchedulerMessage](context => new TaskScheduler(context).waitForMessage)
}

class TaskScheduler(context: ActorContext[TaskSchedulerMessage]) {
  val waitForMessage: Behavior[TaskSchedulerMessage] = {
    Behaviors.receiveMessage[TaskSchedulerMessage] {
      case TaskOneRequest(taskId) => {
        println("am in task-scheduler waitForMessage")
        val worker = context.spawn(TaskOneWorker(taskId), "task-1")
        worker ! Start(context.getSelf, taskId)
        Behaviors.same
      }
      case TaskStartedResponse(taskId) => {
        println("Got a task started")
        Behaviors.same
      }
      case TaskCompletedResponse(taskId) => {
        println("Got a task completed")
        Behaviors.same
      }
    }
  }
}



