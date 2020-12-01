package jobcoordinator

import akka.actor.typed.{ActorRef, Behavior }
import akka.actor.typed.javadsl.{ ActorContext,  Behaviors }
import jobcoordinator.TaskOneWorker.TaskWorkerCommand

object TaskOneWorker {

  sealed trait TaskWorkerCommand
  case class Start(replyTo : ActorRef[TaskSchedulerMessage], args: String) extends  TaskWorkerCommand

  def apply(taskId: String): Behavior[TaskWorkerCommand] = {
    Behaviors.setup[TaskWorkerCommand](context => new TaskOneWorker(context, taskId).waitForMessage)
  }
}

class TaskOneWorker(context : ActorContext[TaskWorkerCommand], taskId: String) {

  import TaskOneWorker._

  def run(args: String): Unit = {
  }

  val waitForMessage: Behavior[TaskWorkerCommand] =
    Behaviors.receiveMessage[TaskWorkerCommand] {
      case Start(replyTo, args) => {
        replyTo ! TaskStartedResponse(taskId)
        this.run(args)
        replyTo ! TaskCompletedResponse(taskId)
        Behaviors.same
      }
    }
}










